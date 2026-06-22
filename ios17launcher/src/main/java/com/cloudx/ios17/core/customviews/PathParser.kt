package com.cloudx.ios17.core.customviews

import android.graphics.Path
import android.util.Log
import java.util.Arrays
import kotlin.math.abs
import kotlin.math.atan2
import kotlin.math.ceil
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.math.tan

object PathParser {
    private val LOGTAG = PathParser::class.java.simpleName

    /**
     * @param pathData The string representing a path, the same as the "d" string in an SVG file.
     * @return the generated Path object.
     */
    @JvmStatic
    fun createPathFromPathData(pathData: String): Path {
        val path = Path()
        val nodes = createNodesFromPathData(pathData)
        nodesToPath(nodes, path)
        return path
    }

    private fun createNodesFromPathData(pathData: String): Array<PathDataNode> {
        var start = 0
        var end = 1
        val list = ArrayList<PathDataNode>()
        while (end < pathData.length) {
            end = nextStart(pathData, end)
            val s = pathData.substring(start, end)
            val values = getFloats(s)
            addNode(list, s[0], values)
            start = end
            end++
        }
        if (end - start == 1 && start < pathData.length) {
            addNode(list, pathData[start], FloatArray(0))
        }
        return list.toTypedArray()
    }

    private fun nextStart(s: String, endPosition: Int): Int {
        var end = endPosition
        while (end < s.length) {
            val c = s[end]
            if ((c - 'A') * (c - 'Z') <= 0 || (c - 'a') * (c - 'z') <= 0) {
                return end
            }
            end++
        }
        return end
    }

    private fun addNode(list: ArrayList<PathDataNode>, cmd: Char, values: FloatArray) {
        list.add(PathDataNode(cmd, values))
    }

    private fun getFloats(s: String): FloatArray {
        if (s[0] == 'z' || s[0] == 'Z') {
            return FloatArray(0)
        }
        try {
            val tmp = FloatArray(s.length)
            var count = 0
            var pos = 1
            var end = extract(s, pos)
            while (end >= 0) {
                if (pos < end) {
                    tmp[count++] = s.substring(pos, end).toFloat()
                }
                pos = end + 1
                end = extract(s, pos)
            }
            if (pos < s.length) {
                tmp[count++] = s.substring(pos).toFloat()
            }
            return Arrays.copyOf(tmp, count)
        } catch (e: NumberFormatException) {
            Log.e(LOGTAG, "error in parsing \"$s\"")
            throw e
        }
    }

    private fun extract(s: String, start: Int): Int {
        val space = s.indexOf(' ', start)
        val comma = s.indexOf(',', start)
        if (space == -1) {
            return comma
        }
        if (comma == -1) {
            return space
        }
        return if (comma > space) space else comma
    }

    private fun nodesToPath(nodes: Array<PathDataNode>, path: Path) {
        val current = FloatArray(4)
        var previousCommand = 'm'
        for (node in nodes) {
            addCommand(path, current, previousCommand, node.type, node.params)
            previousCommand = node.type
        }
    }

    private fun addCommand(path: Path, current: FloatArray, previousCmd: Char, cmd: Char, values: FloatArray) {
        var incr = 2
        var currentX = current[0]
        var currentY = current[1]
        var ctrlPointX = current[2]
        var ctrlPointY = current[3]
        var previousCommand = previousCmd

        when (cmd) {
            'z', 'Z' -> {
                path.close()
                return
            }
            'm', 'M', 'l', 'L', 't', 'T' -> incr = 2
            'h', 'H', 'v', 'V' -> incr = 1
            'c', 'C' -> incr = 6
            's', 'S', 'q', 'Q' -> incr = 4
            'a', 'A' -> incr = 7
        }

        var k = 0
        while (k < values.size) {
            var reflectiveCtrlPointX: Float
            var reflectiveCtrlPointY: Float
            when (cmd) {
                'm' -> {
                    path.rMoveTo(values[k], values[k + 1])
                    currentX += values[k]
                    currentY += values[k + 1]
                }
                'M' -> {
                    path.moveTo(values[k], values[k + 1])
                    currentX = values[k]
                    currentY = values[k + 1]
                }
                'l' -> {
                    path.rLineTo(values[k], values[k + 1])
                    currentX += values[k]
                    currentY += values[k + 1]
                }
                'L' -> {
                    path.lineTo(values[k], values[k + 1])
                    currentX = values[k]
                    currentY = values[k + 1]
                }
                'z', 'Z' -> path.close()
                'h' -> {
                    path.rLineTo(values[k], 0f)
                    currentX += values[k]
                }
                'H' -> {
                    path.lineTo(values[k], currentY)
                    currentX = values[k]
                }
                'v' -> {
                    path.rLineTo(0f, values[k])
                    currentY += values[k]
                }
                'V' -> {
                    path.lineTo(currentX, values[k])
                    currentY = values[k]
                }
                'c' -> {
                    path.rCubicTo(
                        values[k],
                        values[k + 1],
                        values[k + 2],
                        values[k + 3],
                        values[k + 4],
                        values[k + 5]
                    )
                    ctrlPointX = currentX + values[k + 2]
                    ctrlPointY = currentY + values[k + 3]
                    currentX += values[k + 4]
                    currentY += values[k + 5]
                }
                'C' -> {
                    path.cubicTo(values[k], values[k + 1], values[k + 2], values[k + 3], values[k + 4], values[k + 5])
                    currentX = values[k + 4]
                    currentY = values[k + 5]
                    ctrlPointX = values[k + 2]
                    ctrlPointY = values[k + 3]
                }
                's' -> {
                    reflectiveCtrlPointX = 0f
                    reflectiveCtrlPointY = 0f
                    if (previousCommand == 'c' || previousCommand == 's' ||
                        previousCommand == 'C' || previousCommand == 'S'
                    ) {
                        reflectiveCtrlPointX = currentX - ctrlPointX
                        reflectiveCtrlPointY = currentY - ctrlPointY
                    }
                    path.rCubicTo(
                        reflectiveCtrlPointX,
                        reflectiveCtrlPointY,
                        values[k],
                        values[k + 1],
                        values[k + 2],
                        values[k + 3]
                    )
                    ctrlPointX = currentX + values[k]
                    ctrlPointY = currentY + values[k + 1]
                    currentX += values[k + 2]
                    currentY += values[k + 3]
                }
                'S' -> {
                    reflectiveCtrlPointX = currentX
                    reflectiveCtrlPointY = currentY
                    if (previousCommand == 'c' || previousCommand == 's' ||
                        previousCommand == 'C' || previousCommand == 'S'
                    ) {
                        reflectiveCtrlPointX = 2 * currentX - ctrlPointX
                        reflectiveCtrlPointY = 2 * currentY - ctrlPointY
                    }
                    path.cubicTo(
                        reflectiveCtrlPointX,
                        reflectiveCtrlPointY,
                        values[k],
                        values[k + 1],
                        values[k + 2],
                        values[k + 3]
                    )
                    ctrlPointX = values[k]
                    ctrlPointY = values[k + 1]
                    currentX = values[k + 2]
                    currentY = values[k + 3]
                }
                'q' -> {
                    path.rQuadTo(values[k], values[k + 1], values[k + 2], values[k + 3])
                    ctrlPointX = currentX + values[k]
                    ctrlPointY = currentY + values[k + 1]
                    currentX += values[k + 2]
                    currentY += values[k + 3]
                }
                'Q' -> {
                    path.quadTo(values[k], values[k + 1], values[k + 2], values[k + 3])
                    ctrlPointX = values[k]
                    ctrlPointY = values[k + 1]
                    currentX = values[k + 2]
                    currentY = values[k + 3]
                }
                't' -> {
                    reflectiveCtrlPointX = 0f
                    reflectiveCtrlPointY = 0f
                    if (previousCommand == 'q' || previousCommand == 't' ||
                        previousCommand == 'Q' || previousCommand == 'T'
                    ) {
                        reflectiveCtrlPointX = currentX - ctrlPointX
                        reflectiveCtrlPointY = currentY - ctrlPointY
                    }
                    path.rQuadTo(reflectiveCtrlPointX, reflectiveCtrlPointY, values[k], values[k + 1])
                    ctrlPointX = currentX + reflectiveCtrlPointX
                    ctrlPointY = currentY + reflectiveCtrlPointY
                    currentX += values[k]
                    currentY += values[k + 1]
                }
                'T' -> {
                    reflectiveCtrlPointX = currentX
                    reflectiveCtrlPointY = currentY
                    if (previousCommand == 'q' || previousCommand == 't' ||
                        previousCommand == 'Q' || previousCommand == 'T'
                    ) {
                        reflectiveCtrlPointX = 2 * currentX - ctrlPointX
                        reflectiveCtrlPointY = 2 * currentY - ctrlPointY
                    }
                    path.quadTo(reflectiveCtrlPointX, reflectiveCtrlPointY, values[k], values[k + 1])
                    ctrlPointX = reflectiveCtrlPointX
                    ctrlPointY = reflectiveCtrlPointY
                    currentX = values[k]
                    currentY = values[k + 1]
                }
                'a' -> {
                    drawArc(
                        path,
                        currentX,
                        currentY,
                        values[k + 5] + currentX,
                        values[k + 6] + currentY,
                        values[k],
                        values[k + 1],
                        values[k + 2],
                        values[k + 3] != 0f,
                        values[k + 4] != 0f
                    )
                    currentX += values[k + 5]
                    currentY += values[k + 6]
                    ctrlPointX = currentX
                    ctrlPointY = currentY
                }
                'A' -> {
                    drawArc(
                        path,
                        currentX,
                        currentY,
                        values[k + 5],
                        values[k + 6],
                        values[k],
                        values[k + 1],
                        values[k + 2],
                        values[k + 3] != 0f,
                        values[k + 4] != 0f
                    )
                    currentX = values[k + 5]
                    currentY = values[k + 6]
                    ctrlPointX = currentX
                    ctrlPointY = currentY
                }
            }
            previousCommand = cmd
            k += incr
        }

        current[0] = currentX
        current[1] = currentY
        current[2] = ctrlPointX
        current[3] = ctrlPointY
    }

    private fun drawArc(
        path: Path,
        x0: Float,
        y0: Float,
        x1: Float,
        y1: Float,
        a: Float,
        b: Float,
        theta: Float,
        isMoreThanHalf: Boolean,
        isPositiveArc: Boolean
    ) {
        val thetaD = Math.toRadians(theta.toDouble())
        val cosTheta = cos(thetaD)
        val sinTheta = sin(thetaD)
        val x0p = (x0 * cosTheta + y0 * sinTheta) / a
        val y0p = (-x0 * sinTheta + y0 * cosTheta) / b
        val x1p = (x1 * cosTheta + y1 * sinTheta) / a
        val y1p = (-x1 * sinTheta + y1 * cosTheta) / b
        val dx = x0p - x1p
        val dy = y0p - y1p
        val xm = (x0p + x1p) / 2
        val ym = (y0p + y1p) / 2
        val dsq = dx * dx + dy * dy
        if (dsq == 0.0) {
            Log.w(LOGTAG, " Points are coincident")
            return
        }

        val disc = 1.0 / dsq - 1.0 / 4.0
        if (disc < 0.0) {
            Log.w(LOGTAG, "Points are too far apart $dsq")
            val adjust = (sqrt(dsq) / 1.99999).toFloat()
            drawArc(path, x0, y0, x1, y1, a * adjust, b * adjust, theta, isMoreThanHalf, isPositiveArc)
            return
        }

        val s = sqrt(disc)
        val sdx = s * dx
        val sdy = s * dy
        var cx: Double
        var cy: Double
        if (isMoreThanHalf == isPositiveArc) {
            cx = xm - sdy
            cy = ym + sdx
        } else {
            cx = xm + sdy
            cy = ym - sdx
        }

        val eta0 = atan2(y0p - cy, x0p - cx)
        val eta1 = atan2(y1p - cy, x1p - cx)
        var sweep = eta1 - eta0
        if (isPositiveArc != (sweep >= 0)) {
            sweep += if (sweep > 0) -2 * Math.PI else 2 * Math.PI
        }

        cx *= a.toDouble()
        cy *= b.toDouble()
        val tcx = cx
        cx = cx * cosTheta - cy * sinTheta
        cy = tcx * sinTheta + cy * cosTheta
        arcToBezier(path, cx, cy, a.toDouble(), b.toDouble(), x0.toDouble(), y0.toDouble(), thetaD, eta0, sweep)
    }

    private fun arcToBezier(
        path: Path,
        cx: Double,
        cy: Double,
        a: Double,
        b: Double,
        startX: Double,
        startY: Double,
        theta: Double,
        start: Double,
        sweep: Double
    ) {
        val numSegments = abs(ceil(sweep * 4 / Math.PI).toInt())
        var eta1 = start
        val cosTheta = cos(theta)
        val sinTheta = sin(theta)
        val cosEta1 = cos(eta1)
        val sinEta1 = sin(eta1)
        var e1x = startX
        var e1y = startY
        var ep1x = -a * cosTheta * sinEta1 - b * sinTheta * cosEta1
        var ep1y = -a * sinTheta * sinEta1 + b * cosTheta * cosEta1
        val anglePerSegment = sweep / numSegments
        for (i in 0 until numSegments) {
            val eta2 = eta1 + anglePerSegment
            val sinEta2 = sin(eta2)
            val cosEta2 = cos(eta2)
            val e2x = cx + a * cosTheta * cosEta2 - b * sinTheta * sinEta2
            val e2y = cy + a * sinTheta * cosEta2 + b * cosTheta * sinEta2
            val ep2x = -a * cosTheta * sinEta2 - b * sinTheta * cosEta2
            val ep2y = -a * sinTheta * sinEta2 + b * cosTheta * cosEta2
            val tanDiff2 = tan((eta2 - eta1) / 2)
            val alpha = sin(eta2 - eta1) * (sqrt(4 + 3 * tanDiff2 * tanDiff2) - 1) / 3
            val q1x = e1x + alpha * ep1x
            val q1y = e1y + alpha * ep1y
            val q2x = e2x - alpha * ep2x
            val q2y = e2y - alpha * ep2y
            path.cubicTo(q1x.toFloat(), q1y.toFloat(), q2x.toFloat(), q2y.toFloat(), e2x.toFloat(), e2y.toFloat())
            eta1 = eta2
            e1x = e2x
            e1y = e2y
            ep1x = ep2x
            ep1y = ep2y
        }
    }

    private class PathDataNode(
        val type: Char,
        val params: FloatArray
    )
}

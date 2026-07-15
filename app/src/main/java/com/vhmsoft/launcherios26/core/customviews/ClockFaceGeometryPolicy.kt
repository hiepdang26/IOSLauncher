package com.vhmsoft.launcherios26.core.customviews

import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.max
import kotlin.math.sin

data class ClockFaceLine(
    val startX: Float,
    val startY: Float,
    val endX: Float,
    val endY: Float
)

object ClockFaceGeometryPolicy {
    fun squareRadialLine(
        centerX: Float,
        centerY: Float,
        halfExtent: Float,
        lineLength: Float,
        angle: Float
    ): ClockFaceLine {
        val radians = Math.toRadians((angle - CLOCK_TOP_DEGREES).toDouble())
        val unitX = cos(radians).toFloat()
        val unitY = sin(radians).toFloat()
        val dominantAxis = max(abs(unitX), abs(unitY)).coerceAtLeast(MIN_AXIS)
        val outerRadius = halfExtent / dominantAxis
        val innerRadius = outerRadius - lineLength

        return ClockFaceLine(
            startX = centerX + unitX * innerRadius,
            startY = centerY + unitY * innerRadius,
            endX = centerX + unitX * outerRadius,
            endY = centerY + unitY * outerRadius
        )
    }

    private const val CLOCK_TOP_DEGREES = 90f
    private const val MIN_AXIS = 0.0001f
}

package com.vhmsoft.launcherios26.core

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.util.SparseArray

/** Utility class for extracting colors from a bitmap. */
object ColorExtractor {

    private const val TAG = "ColorExtractor"
    private const val MAGIC_NUMBER = 25

    @JvmStatic
    fun findDominantColorByHue(bitmap: Bitmap): Int = findDominantColorByHue(bitmap, 20)

    /**
     * This picks a dominant color, looking for high-saturation, high-value, repeated hues.
     */
    @JvmStatic
    fun findDominantColorByHue(bitmap: Bitmap, samples: Int): Int {
        val height = bitmap.height
        val width = bitmap.width
        var sampleStride = Math.sqrt((height * width / samples).toDouble()).toInt()
        if (sampleStride < 1) {
            sampleStride = 1
        }

        val hsv = FloatArray(3)
        val hueScoreHistogram = FloatArray(360)
        var highScore = -1f
        var bestHue = -1

        val pixels = IntArray(samples)
        var pixelCount = 0

        var y = 0
        while (y < height) {
            var x = 0
            while (x < width) {
                val argb = bitmap.getPixel(x, y)
                val alpha = 0xFF and (argb shr 24)
                if (alpha >= 0x80) {
                    val rgb = argb or -0x1000000
                    Color.colorToHSV(rgb, hsv)
                    val hue = hsv[0].toInt()
                    if (hue >= 0 && hue < hueScoreHistogram.size) {
                        if (pixelCount < samples) {
                            pixels[pixelCount++] = rgb
                        }
                        val score = hsv[1] * hsv[2]
                        hueScoreHistogram[hue] += score
                        if (hueScoreHistogram[hue] > highScore) {
                            highScore = hueScoreHistogram[hue]
                            bestHue = hue
                        }
                    }
                }
                x += sampleStride
            }
            y += sampleStride
        }

        val rgbScores = SparseArray<Float>()
        var bestColor = -0x1000000
        highScore = -1f
        for (i in 0 until pixelCount) {
            val rgb = pixels[i]
            Color.colorToHSV(rgb, hsv)
            val hue = hsv[0].toInt()
            if (hue == bestHue) {
                val s = hsv[1]
                val v = hsv[2]
                val bucket = (s * 100).toInt() + (v * 10000).toInt()
                val score = s * v
                val oldTotal = rgbScores[bucket]
                val newTotal = oldTotal?.plus(score) ?: score
                rgbScores.put(bucket, newTotal)
                if (newTotal > highScore) {
                    highScore = newTotal
                    bestColor = rgb
                }
            }
        }
        return bestColor
    }

    @JvmStatic
    fun isSingleColor(drawable: Drawable?, color: Int): Boolean {
        if (drawable == null) {
            return true
        }
        val testColor = posterize(color)
        if (drawable is ColorDrawable) {
            return posterize(drawable.color) == testColor
        }
        val bitmap = Utilities.drawableToBitmap(drawable) ?: return false
        val height = bitmap.height
        val width = bitmap.width

        val pixels = IntArray(height * width)
        bitmap.getPixels(pixels, 0, width, 0, 0, width, height)
        val distinctPixels = pixels.toSet()

        for (pixel in distinctPixels) {
            if (testColor != posterize(pixel)) {
                return false
            }
        }
        return true
    }

    @JvmStatic
    fun posterize(rgb: Int): Int {
        var red = 0xff and (rgb shr 16)
        var green = 0xff and (rgb shr 8)
        var blue = 0xff and rgb
        red -= red % MAGIC_NUMBER
        green -= green % MAGIC_NUMBER
        blue -= blue % MAGIC_NUMBER
        if (red < 0) {
            red = 0
        }
        if (green < 0) {
            green = 0
        }
        if (blue < 0) {
            blue = 0
        }
        return red shl 16 or (green shl 8) or blue
    }
}

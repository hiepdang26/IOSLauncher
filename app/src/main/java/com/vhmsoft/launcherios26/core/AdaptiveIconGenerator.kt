package com.vhmsoft.launcherios26.core

import android.content.Context
import android.graphics.Color
import android.graphics.RectF
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.util.SparseIntArray
import androidx.core.graphics.ColorUtils
import com.vhmsoft.launcherios26.FixedScaleDrawable
import com.vhmsoft.launcherios26.core.customviews.AdaptiveIconDrawableCompat
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt
import timber.log.Timber

class AdaptiveIconGenerator(
    private val context: Context,
    private val icon: Drawable
) {

    private var ranLoop = false
    private var shouldWrap = false
    private var backgroundColor = Color.WHITE
    private var useWhiteBackground = false
    private var isFullBleed = false
    private var noMixinNeeded = false
    private var fullBleedChecked = false
    private var matchesMaskShape = false
    private var isBackgroundWhite = false
    private var scale = 0f
    private var height = 0
    private var aHeight = 0f
    private var width = 0
    private var aWidth = 0f
    private var result: Drawable? = null

    private fun loop() {
        val extractee = icon

        val bounds = RectF()
        scale = 1.0f

        if (extractee is ColorDrawable) {
            isFullBleed = true
            fullBleedChecked = true
        }

        width = extractee.intrinsicWidth
        height = extractee.intrinsicHeight
        aWidth = width * (1 - (bounds.left + bounds.right))
        aHeight = height * (1 - (bounds.top + bounds.bottom))

        val ratio = aHeight / aWidth
        val isSquarish = 0.999 < ratio && ratio < 1.0001
        val almostSquarish = isSquarish || (0.97 < ratio && ratio < 1.005)
        if (!isSquarish) {
            isFullBleed = false
            fullBleedChecked = true
        }

        val bitmap = Utilities.drawableToBitmap(extractee)
        if (bitmap == null) {
            onExitLoop()
            return
        }

        if (!bitmap.hasAlpha()) {
            isFullBleed = true
            fullBleedChecked = true
        }

        val size = height * width
        val rgbScoreHistogram = SparseIntArray(NUMBER_OF_COLORS_GUESSTIMATE)
        val pixels = IntArray(size)
        bitmap.getPixels(pixels, 0, width, 0, 0, width, height)

        val adjHeight = height - bounds.top - bounds.bottom
        val l = bounds.left * width * adjHeight
        val top = bounds.top * height * width
        val r = bounds.right * width * adjHeight
        val bottom = bounds.bottom * height * width
        val addPixels = (l + top + r + bottom).roundToInt()

        val maxTransparent = (size * .10).roundToInt() + addPixels
        val noMixinScore = (size * .27).roundToInt() + addPixels

        var highScore = 0
        var bestRGB = 0
        var transparentScore = 0
        for (pixel in pixels) {
            val alpha = 0xFF and (pixel shr 24)
            if (alpha < MIN_VISIBLE_ALPHA) {
                transparentScore++
                if (transparentScore > maxTransparent) {
                    isFullBleed = false
                    fullBleedChecked = true
                }
                continue
            }
            val rgb = ColorExtractor.posterize(pixel)
            if (rgb < 0) {
                continue
            }
            val currentScore = rgbScoreHistogram[rgb] + 1
            rgbScoreHistogram.append(rgb, currentScore)
            if (currentScore > highScore) {
                highScore = currentScore
                bestRGB = rgb
            }
        }
        bestRGB = bestRGB or (0xff shl 24)

        isFullBleed = isFullBleed or (!fullBleedChecked && !isBackgroundWhite)
        noMixinNeeded = !isFullBleed && !isBackgroundWhite && almostSquarish && transparentScore <= noMixinScore

        if (useWhiteBackground) {
            backgroundColor = Color.WHITE and 0x80FFFFFF.toInt()
            onExitLoop()
            return
        }

        if (isFullBleed || noMixinNeeded) {
            backgroundColor = bestRGB
            onExitLoop()
            return
        }

        val numColors = rgbScoreHistogram.size()
        val singleColor = numColors <= SINGLE_COLOR_LIMIT

        val hsl = FloatArray(3)
        ColorUtils.colorToHSL(bestRGB, hsl)
        val lightness = hsl[2]

        val light = lightness > .5
        val veryLight = lightness > .75 && singleColor
        val veryDark = lightness < .35 && singleColor

        val opaqueSize = size - transparentScore
        val pxPerColor = opaqueSize / numColors.toFloat()
        val mixRatio = min(max(pxPerColor / highScore, .15f), .7f)

        val fill = if ((light && !veryLight) || veryDark) 0xFFFFFFFF.toInt() else 0xFF333333.toInt()
        backgroundColor = ColorUtils.blendARGB(bestRGB, fill, mixRatio)
        onExitLoop()
    }

    private fun onExitLoop() {
        ranLoop = true
        result = genResult()
    }

    private fun genResult(): Drawable {
        val tmp = AdaptiveIconDrawableCompat(ColorDrawable(), FixedScaleDrawable())
        (tmp.foreground as FixedScaleDrawable).setDrawable(icon)
        if (isFullBleed || noMixinNeeded) {
            val foregroundScale =
                if (noMixinNeeded) {
                    val upScale = min(width / aWidth, height / aHeight)
                    NO_MIXIN_ICON_SCALE * upScale
                } else {
                    val upScale = max(width / aWidth, height / aHeight)
                    FULL_BLEED_ICON_SCALE * upScale
                }
            (tmp.foreground as FixedScaleDrawable).setScale(foregroundScale)
        } else {
            (tmp.foreground as FixedScaleDrawable).setScale(
                scale * HomeIconRenderPolicy.legacyFallbackIconForegroundScale
            )
        }
        (tmp.background as ColorDrawable).color = backgroundColor
        return tmp
    }

    fun getResult(): Drawable {
        if (!ranLoop) {
            loop()
        }
        return requireNotNull(result)
    }

    companion object {
        private const val NUMBER_OF_COLORS_GUESSTIMATE = 45
        private const val FULL_BLEED_ICON_SCALE = 1.44f
        private const val NO_MIXIN_ICON_SCALE = 1.40f
        private const val SINGLE_COLOR_LIMIT = 5
        private const val MIN_VISIBLE_ALPHA = 0xEF
    }
}

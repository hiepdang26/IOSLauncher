package com.vhmsoft.launcherios26.features.launcher

import kotlin.math.roundToInt

object HomeWidgetPhotoPolicy {
    data class OutputSize(val width: Int, val height: Int)
    data class FloatRect(val left: Float, val top: Float, val right: Float, val bottom: Float) {
        val width: Float get() = right - left
        val height: Float get() = bottom - top
    }
    data class IntRect(val left: Int, val top: Int, val right: Int, val bottom: Int) {
        val width: Int get() = right - left
        val height: Int get() = bottom - top
    }

    fun outputSizeFor(size: HomeWidgetPlacementPolicy.WidgetSize): OutputSize {
        return when (size) {
            HomeWidgetPlacementPolicy.WidgetSize.SMALL -> OutputSize(width = 720, height = 720)
            HomeWidgetPlacementPolicy.WidgetSize.FULL_WIDTH -> OutputSize(width = 1440, height = 720)
            HomeWidgetPlacementPolicy.WidgetSize.TALL -> OutputSize(width = 720, height = 1440)
            HomeWidgetPlacementPolicy.WidgetSize.LARGE -> OutputSize(width = 1440, height = 1440)
        }
    }

    fun fileNameForWidgetId(widgetId: String): String {
        val safeName = widgetId
            .map { char -> if (char.isLetterOrDigit() || char == '_' || char == '-' || char == '.') char else '_' }
            .joinToString("")
            .ifBlank { "photo_widget" }
        return "$safeName.png"
    }

    fun sourceRectForCrop(
        imageRect: FloatRect,
        cropRect: FloatRect,
        bitmapWidth: Int,
        bitmapHeight: Int
    ): IntRect? {
        if (
            imageRect.width <= 0f ||
            imageRect.height <= 0f ||
            cropRect.width <= 0f ||
            cropRect.height <= 0f ||
            bitmapWidth <= 0 ||
            bitmapHeight <= 0
        ) {
            return null
        }

        val scaleX = bitmapWidth.toFloat() / imageRect.width
        val scaleY = bitmapHeight.toFloat() / imageRect.height
        val left = ((cropRect.left - imageRect.left) * scaleX).roundToInt().coerceIn(0, bitmapWidth - 1)
        val top = ((cropRect.top - imageRect.top) * scaleY).roundToInt().coerceIn(0, bitmapHeight - 1)
        val right = ((cropRect.right - imageRect.left) * scaleX).roundToInt().coerceIn(left + 1, bitmapWidth)
        val bottom = ((cropRect.bottom - imageRect.top) * scaleY).roundToInt().coerceIn(top + 1, bitmapHeight)
        return IntRect(left = left, top = top, right = right, bottom = bottom)
    }
}

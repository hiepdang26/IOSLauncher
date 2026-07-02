package com.vhmsoft.launcherios26.ui.launcher.icon

import kotlin.math.max
import kotlin.math.min

data class CropRect(
    val left: Float,
    val top: Float,
    val right: Float,
    val bottom: Float
) {
    val width: Float get() = right - left
    val height: Float get() = bottom - top
    val size: Float get() = min(width, height)
    val centerX: Float get() = (left + right) / 2f
    val centerY: Float get() = (top + bottom) / 2f
}

enum class CropResizeHandle {
    TopLeft,
    TopRight,
    BottomLeft,
    BottomRight
}

object IconCropGeometryPolicy {

    fun initialCropRect(bounds: CropRect, fillFraction: Float): CropRect {
        val fraction = fillFraction.coerceIn(0.2f, 1f)
        val size = min(bounds.width, bounds.height) * fraction
        val left = bounds.left + (bounds.width - size) / 2f
        val top = bounds.top + (bounds.height - size) / 2f
        return CropRect(left, top, left + size, top + size)
    }

    fun move(crop: CropRect, dx: Float, dy: Float, bounds: CropRect): CropRect {
        val size = crop.size
        val left = (crop.left + dx).coerceIn(bounds.left, bounds.right - size)
        val top = (crop.top + dy).coerceIn(bounds.top, bounds.bottom - size)
        return CropRect(left, top, left + size, top + size)
    }

    fun resize(
        crop: CropRect,
        handle: CropResizeHandle,
        dx: Float,
        dy: Float,
        bounds: CropRect,
        minSize: Float
    ): CropRect {
        val requestedSize = when (handle) {
            CropResizeHandle.TopLeft -> crop.size - max(dx, dy)
            CropResizeHandle.TopRight -> crop.size + min(dx, -dy)
            CropResizeHandle.BottomLeft -> crop.size + min(-dx, dy)
            CropResizeHandle.BottomRight -> crop.size + min(dx, dy)
        }.coerceAtLeast(minSize)

        val maxSize = when (handle) {
            CropResizeHandle.TopLeft -> min(crop.right - bounds.left, crop.bottom - bounds.top)
            CropResizeHandle.TopRight -> min(bounds.right - crop.left, crop.bottom - bounds.top)
            CropResizeHandle.BottomLeft -> min(crop.right - bounds.left, bounds.bottom - crop.top)
            CropResizeHandle.BottomRight -> min(bounds.right - crop.left, bounds.bottom - crop.top)
        }
        val size = requestedSize.coerceAtMost(maxSize)

        return when (handle) {
            CropResizeHandle.TopLeft -> CropRect(crop.right - size, crop.bottom - size, crop.right, crop.bottom)
            CropResizeHandle.TopRight -> CropRect(crop.left, crop.bottom - size, crop.left + size, crop.bottom)
            CropResizeHandle.BottomLeft -> CropRect(crop.right - size, crop.top, crop.right, crop.top + size)
            CropResizeHandle.BottomRight -> CropRect(crop.left, crop.top, crop.left + size, crop.top + size)
        }
    }
}

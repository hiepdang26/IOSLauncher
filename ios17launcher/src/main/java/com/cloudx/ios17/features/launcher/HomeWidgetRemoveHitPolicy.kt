package com.cloudx.ios17.features.launcher

object HomeWidgetRemoveHitPolicy {

    fun isInsideExpandedCorner(
        rawX: Float,
        rawY: Float,
        hostLeft: Int,
        hostTop: Int,
        touchSizePx: Int
    ): Boolean {
        val safeTouchSize = touchSizePx.coerceAtLeast(1)
        val outwardSlop = safeTouchSize / 2f
        val left = hostLeft - outwardSlop
        val top = hostTop - outwardSlop
        val right = hostLeft + safeTouchSize.toFloat()
        val bottom = hostTop + safeTouchSize.toFloat()
        return rawX in left..right && rawY in top..bottom
    }

    fun isInsideExpandedViewBounds(
        rawX: Float,
        rawY: Float,
        viewLeft: Int,
        viewTop: Int,
        viewWidth: Int,
        viewHeight: Int,
        minTouchSizePx: Int
    ): Boolean {
        val safeWidth = viewWidth.coerceAtLeast(1)
        val safeHeight = viewHeight.coerceAtLeast(1)
        val safeTouchSize = minTouchSizePx.coerceAtLeast(maxOf(safeWidth, safeHeight))
        val extraX = (safeTouchSize - safeWidth) / 2f
        val extraY = (safeTouchSize - safeHeight) / 2f
        val left = viewLeft - extraX
        val top = viewTop - extraY
        val right = viewLeft + safeWidth + extraX
        val bottom = viewTop + safeHeight + extraY
        return rawX in left..right && rawY in top..bottom
    }
}

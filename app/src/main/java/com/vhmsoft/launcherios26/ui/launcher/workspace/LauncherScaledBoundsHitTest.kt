package com.vhmsoft.launcherios26.ui.launcher.workspace

internal object LauncherScaledBoundsHitTest {
    fun isOutside(
        pointX: Float,
        pointY: Float,
        left: Float,
        top: Float,
        width: Float,
        height: Float,
        scaleX: Float,
        scaleY: Float,
        slop: Float
    ): Boolean {
        val boundedScaleX = scaleX.coerceAtLeast(0f)
        val boundedScaleY = scaleY.coerceAtLeast(0f)
        val centerX = left + width / 2f
        val centerY = top + height / 2f
        val scaledHalfWidth = width * boundedScaleX / 2f
        val scaledHalfHeight = height * boundedScaleY / 2f
        val scaledLeft = centerX - scaledHalfWidth - slop
        val scaledTop = centerY - scaledHalfHeight - slop
        val scaledRight = centerX + scaledHalfWidth + slop
        val scaledBottom = centerY + scaledHalfHeight + slop

        return pointX < scaledLeft ||
            pointX > scaledRight ||
            pointY < scaledTop ||
            pointY > scaledBottom
    }
}

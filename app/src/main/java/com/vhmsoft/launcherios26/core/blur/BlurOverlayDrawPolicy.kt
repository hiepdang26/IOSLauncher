package com.vhmsoft.launcherios26.core.blur

object BlurOverlayDrawPolicy {
    data class RoundRect(
        val left: Float,
        val top: Float,
        val right: Float,
        val bottom: Float,
        val radiusX: Float,
        val radiusY: Float
    )

    fun localRoundRect(width: Int, height: Int, cornerRadius: Float): RoundRect =
        RoundRect(
            left = 0f,
            top = 0f,
            right = width.toFloat(),
            bottom = height.toFloat(),
            radiusX = cornerRadius,
            radiusY = cornerRadius
        )
}

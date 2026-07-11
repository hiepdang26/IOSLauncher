package com.cloudx.ios17.core

object HomeIconRenderPolicy {
    const val wrapLegacyFallbackIcons = true
    const val legacyFallbackIconForegroundScale = 1.14f
    const val homeScreenIconContentScale = 1.18f
    const val cacheStyleVersion = "uniform_icon_v3"

    fun shouldClipIconDrawable(iconContentScale: Float): Boolean = true

    fun shouldScaleIconDrawable(iconContentScale: Float): Boolean = iconContentScale != 1f

    fun shouldResizeClipMaskToViewBounds(
        viewWidth: Int,
        viewHeight: Int,
        maskWidth: Float,
        maskHeight: Float
    ): Boolean {
        if (viewWidth <= 0 || viewHeight <= 0 || maskWidth <= 0f || maskHeight <= 0f) {
            return false
        }
        return kotlin.math.abs(maskWidth - viewWidth) > 0.5f ||
            kotlin.math.abs(maskHeight - viewHeight) > 0.5f
    }
}

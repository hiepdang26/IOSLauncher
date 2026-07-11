package com.cloudx.ios17.core

object HomeIconRenderPolicy {
    const val wrapLegacyFallbackIcons = true
    const val legacyFallbackIconForegroundScale = 1.14f
    const val homeScreenIconContentScale = 1.18f
    const val cacheStyleVersion = "uniform_icon_v3"

    fun shouldClipIconDrawable(iconContentScale: Float): Boolean = true

    fun shouldScaleIconDrawable(iconContentScale: Float): Boolean = iconContentScale != 1f
}

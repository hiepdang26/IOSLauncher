package com.cloudx.ios17.core.customviews

object DockStylePolicy {
    const val LAYOUT_PREFERENCES_NAME = "launcher_layout_preferences"
    const val KEY_LAYOUT_IPHONE8_STYLE = "layout_iphone8_style"

    enum class Style {
        CURRENT,
        ROUNDED,
        LIQUID_GLASS
    }

    data class LayoutMetrics(
        val heightPx: Int,
        val bottomPaddingPx: Int
    )

    fun styleFor(
        iphone8StyleEnabled: Boolean,
        liquidGlassEnabled: Boolean = false,
        darkModeEnabled: Boolean = false
    ): Style {
        if (liquidGlassEnabled) {
            return Style.LIQUID_GLASS
        }
        if (iphone8StyleEnabled) return Style.CURRENT
        if (darkModeEnabled) return Style.LIQUID_GLASS
        return Style.ROUNDED
    }

    fun drawsStyleAboveBlur(style: Style): Boolean {
        return style == Style.ROUNDED || style == Style.LIQUID_GLASS
    }

    fun drawsWallpaperBlur(
        style: Style,
        dockBlurEnabled: Boolean,
        externalRealtimeLiquidGlassEnabled: Boolean
    ): Boolean {
        return dockBlurEnabled &&
            !externalRealtimeLiquidGlassEnabled &&
            style != Style.CURRENT
    }

    fun usesExternalRealtimeLiquidGlass(
        style: Style,
        realtimeLiquidGlassAvailable: Boolean,
        @Suppress("UNUSED_PARAMETER")
        dockBlurEnabled: Boolean
    ): Boolean {
        return realtimeLiquidGlassAvailable &&
            style == Style.LIQUID_GLASS
    }

    @Suppress("UNUSED_PARAMETER")
    fun layoutMetrics(hotseatCellHeightPx: Int, bottomInsetPx: Int): LayoutMetrics {
        return LayoutMetrics(
            heightPx = hotseatCellHeightPx,
            bottomPaddingPx = 0
        )
    }
}

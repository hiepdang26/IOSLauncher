package com.vhmsoft.launcherios26.core.customviews

object DockStylePolicy {
    const val LAYOUT_PREFERENCES_NAME = "launcher_layout_preferences"
    const val KEY_LAYOUT_IPHONE8_STYLE = "layout_iphone8_style"

    enum class Style {
        CURRENT,
        IPHONE8,
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
        if (iphone8StyleEnabled) return Style.IPHONE8
        if (darkModeEnabled) return Style.LIQUID_GLASS
        return Style.ROUNDED
    }

    fun isIphone8StyleEffective(
        iphone8StyleEnabled: Boolean,
        liquidGlassEnabled: Boolean
    ): Boolean = iphone8StyleEnabled && !liquidGlassEnabled

    fun drawsStyleAboveBlur(style: Style): Boolean {
        return style == Style.ROUNDED || style == Style.LIQUID_GLASS || style == Style.IPHONE8
    }

    fun usesMaterialDrawableAboveBlur(style: Style): Boolean {
        return style == Style.ROUNDED || style == Style.LIQUID_GLASS || style == Style.IPHONE8
    }

    fun childWidthPx(
        style: Style,
        cellWidthPx: Int,
        hotseatCellWidthPx: Int,
        fullWidthDockCellWidthPx: Int = hotseatCellWidthPx
    ): Int {
        return when (style) {
            Style.CURRENT -> cellWidthPx
            Style.IPHONE8 -> fullWidthDockCellWidthPx
            Style.ROUNDED,
            Style.LIQUID_GLASS -> hotseatCellWidthPx
        }
    }

    fun fullWidthDockCellWidthPx(
        availableWidthPx: Int,
        numColumns: Int
    ): Int {
        val safeColumns = numColumns.coerceAtLeast(1)
        return availableWidthPx.coerceAtLeast(safeColumns) / safeColumns
    }

    fun drawsWallpaperBlur(
        style: Style,
        dockBlurEnabled: Boolean,
        externalRealtimeLiquidGlassEnabled: Boolean
    ): Boolean {
        return dockBlurEnabled &&
            !externalRealtimeLiquidGlassEnabled &&
            style == Style.LIQUID_GLASS
    }

    fun usesExternalRealtimeLiquidGlass(
        style: Style,
        realtimeLiquidGlassAvailable: Boolean,
        dockBlurEnabled: Boolean
    ): Boolean {
        return dockBlurEnabled &&
            realtimeLiquidGlassAvailable &&
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

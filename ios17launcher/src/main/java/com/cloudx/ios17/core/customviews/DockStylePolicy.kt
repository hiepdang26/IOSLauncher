package com.cloudx.ios17.core.customviews

object DockStylePolicy {
    const val LAYOUT_PREFERENCES_NAME = "launcher_layout_preferences"
    const val KEY_LAYOUT_IPHONE8_STYLE = "layout_iphone8_style"

    enum class Style {
        CURRENT,
        ROUNDED
    }

    data class LayoutMetrics(
        val heightPx: Int,
        val bottomPaddingPx: Int
    )

    fun styleFor(iphone8StyleEnabled: Boolean): Style {
        return if (iphone8StyleEnabled) Style.CURRENT else Style.ROUNDED
    }

    @Suppress("UNUSED_PARAMETER")
    fun layoutMetrics(hotseatCellHeightPx: Int, bottomInsetPx: Int): LayoutMetrics {
        return LayoutMetrics(
            heightPx = hotseatCellHeightPx,
            bottomPaddingPx = 0
        )
    }
}

package com.cloudx.ios17.core

import android.content.Context
import kotlin.math.roundToInt

data class LauncherHomeLayoutSettings(
    val iconSizeDp: Int,
    val rows: Int,
    val columns: Int
) {
    val maxAppsPerPage: Int
        get() = rows * columns
}

object LauncherHomeLayoutPreferences {
    const val LAYOUT_PREFERENCES_NAME = "launcher_layout_preferences"
    const val KEY_HOME_ICON_SIZE_DP = "home_icon_size_dp"
    const val KEY_HOME_GRID_ROWS = "home_grid_rows"

    const val HOME_PAGE_COLUMNS = 4
    const val HOME_GRID_ROWS_5 = 5
    const val HOME_GRID_ROWS_6 = 6
    const val DEFAULT_HOME_GRID_ROWS = HOME_GRID_ROWS_6

    const val MIN_HOME_ICON_SIZE_DP = 52
    const val DEFAULT_HOME_ICON_SIZE_DP = 64
    const val MAX_HOME_ICON_SIZE_DP = 78

    const val HOME_PAGE_TOP_PADDING_DP = 8
    const val EDIT_HOME_PAGE_TOP_PADDING_DP = 78
    const val PAGE_INDICATOR_HEIGHT_DP = 34
    const val INDICATOR_DOCK_GAP_DP = 12
    const val DOCK_HORIZONTAL_MARGIN_DP = 12
    const val DOCK_EXTRA_HEIGHT_DP = 20
    const val DOCK_BOTTOM_MARGIN_DP = 8

    private const val MIN_HORIZONTAL_GAP_DP = 8

    fun read(context: Context): LauncherHomeLayoutSettings {
        val prefs = context.getSharedPreferences(LAYOUT_PREFERENCES_NAME, Context.MODE_PRIVATE)
        return resolve(
            iconSizeDp = prefs.getInt(KEY_HOME_ICON_SIZE_DP, DEFAULT_HOME_ICON_SIZE_DP),
            rows = prefs.getInt(KEY_HOME_GRID_ROWS, DEFAULT_HOME_GRID_ROWS)
        )
    }

    fun resolve(iconSizeDp: Int, rows: Int): LauncherHomeLayoutSettings {
        return LauncherHomeLayoutSettings(
            iconSizeDp = iconSizeDp.coerceIn(MIN_HOME_ICON_SIZE_DP, MAX_HOME_ICON_SIZE_DP),
            rows = rows.takeIf { it == HOME_GRID_ROWS_5 || it == HOME_GRID_ROWS_6 } ?: DEFAULT_HOME_GRID_ROWS,
            columns = HOME_PAGE_COLUMNS
        )
    }

    fun resolveIconSizePx(
        preferredIconSizeDp: Int,
        density: Float,
        availableWidthPx: Int,
        availableHeightPx: Int,
        rows: Int,
        columns: Int,
        labelHeightPx: Int,
        labelGapPx: Int
    ): Int {
        val safeDensity = density.takeIf { it > 0f } ?: 1f
        val settings = resolve(preferredIconSizeDp, rows)
        val preferredIconPx = dp(settings.iconSizeDp, safeDensity)
        val minHorizontalGapPx = dp(MIN_HORIZONTAL_GAP_DP, safeDensity)
        val maxIconByWidth = if (columns > 0) {
            ((availableWidthPx - minHorizontalGapPx * (columns + 1)) / columns).coerceAtLeast(1)
        } else {
            preferredIconPx
        }
        val chromeWithoutDockIconPx =
            dp(HOME_PAGE_TOP_PADDING_DP, safeDensity) +
                dp(PAGE_INDICATOR_HEIGHT_DP, safeDensity) +
                dp(INDICATOR_DOCK_GAP_DP, safeDensity) +
                dp(DOCK_EXTRA_HEIGHT_DP, safeDensity) +
                dp(DOCK_BOTTOM_MARGIN_DP, safeDensity)
        val maxIconByHeight = if (rows > 0) {
            val availableForIconsPx =
                availableHeightPx -
                    chromeWithoutDockIconPx -
                    rows * (labelHeightPx + labelGapPx)
            (availableForIconsPx / (rows + 1)).coerceAtLeast(1)
        } else {
            preferredIconPx
        }
        return preferredIconPx.coerceAtMost(maxIconByWidth).coerceAtMost(maxIconByHeight).coerceAtLeast(1)
    }

    fun horizontalGapPx(availableWidthPx: Int, iconSizePx: Int, columns: Int): Int {
        if (columns <= 0) return 0
        return ((availableWidthPx - iconSizePx * columns) / (columns + 1)).coerceAtLeast(0)
    }

    fun homePageTopPaddingDp(isEditing: Boolean): Int {
        return if (isEditing) EDIT_HOME_PAGE_TOP_PADDING_DP else HOME_PAGE_TOP_PADDING_DP
    }

    private fun dp(value: Int, density: Float): Int {
        return (value * density).roundToInt().coerceAtLeast(0)
    }
}

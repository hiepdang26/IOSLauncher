package com.cloudx.ios17.core

import android.content.Context
import android.content.SharedPreferences
import kotlin.math.roundToInt

data class LauncherHomeLayoutSettings(
    val iconSizeDp: Int,
    val rows: Int,
    val columns: Int,
    val autoArrangeApps: Boolean,
    val darkMode: Boolean
) {
    val maxAppsPerPage: Int
        get() = rows * columns
}

object LauncherHomeLayoutPreferences {
    const val LAYOUT_PREFERENCES_NAME = "launcher_layout_preferences"
    const val KEY_HOME_ICON_SIZE_DP = "home_icon_size_dp"
    const val KEY_HOME_GRID_ROWS = "home_grid_rows"
    const val KEY_AUTO_REARRANGE_APPS = "auto_rearrange"
    const val KEY_LAYOUT_AUTO_REARRANGE_APPS = "layout_auto_arrange"
    const val KEY_LAYOUT_LIQUID_GLASS = "layout_liquid_glass"
    const val KEY_LAYOUT_DARK_MODE = "layout_dark_mode"
    const val KEY_CUSTOM_WALLPAPER_URI = "custom_wallpaper_uri"
    const val KEY_BLUR_EFFECT_ENABLED = "blur_effect_enabled"
    const val KEY_BLUR_FOLDER_ENABLED = "blur_folder_enabled"
    const val KEY_BLUR_SEARCH_ENABLED = "blur_search_enabled"

    const val HOME_PAGE_COLUMNS = 4
    const val HOME_GRID_ROWS_5 = 5
    const val HOME_GRID_ROWS_6 = 6
    const val DEFAULT_HOME_GRID_ROWS = HOME_GRID_ROWS_6

    const val MIN_HOME_ICON_SIZE_DP = 52
    const val DEFAULT_HOME_ICON_SIZE_DP = 65
    const val MAX_HOME_ICON_SIZE_DP = 78
    const val ICON_SIZE_SLIDER_MAX = MAX_HOME_ICON_SIZE_DP - MIN_HOME_ICON_SIZE_DP
    const val DEFAULT_ICON_SIZE_SLIDER_PROGRESS = DEFAULT_HOME_ICON_SIZE_DP - MIN_HOME_ICON_SIZE_DP
    const val DEFAULT_AUTO_REARRANGE_APPS = false
    const val DEFAULT_DARK_MODE = false
    const val DEFAULT_BLUR_EFFECT_ENABLED = true
    const val DEFAULT_BLUR_TARGET_ENABLED = true

    const val HOME_PAGE_TOP_PADDING_DP = 40
    const val EDIT_HOME_PAGE_TOP_PADDING_DP = HOME_PAGE_TOP_PADDING_DP
    const val PAGE_INDICATOR_HEIGHT_DP = 34
    const val INDICATOR_DOCK_GAP_DP = 12
    const val DOCK_HORIZONTAL_MARGIN_DP = 12
    const val DOCK_EXTRA_HEIGHT_DP = 44
    const val DOCK_BOTTOM_MARGIN_DP = 8

    private const val MIN_HORIZONTAL_GAP_DP = 8

    fun read(context: Context): LauncherHomeLayoutSettings {
        val prefs = context.getSharedPreferences(LAYOUT_PREFERENCES_NAME, Context.MODE_PRIVATE)
        return resolve(
            iconSizeDp = prefs.getInt(KEY_HOME_ICON_SIZE_DP, DEFAULT_HOME_ICON_SIZE_DP),
            rows = prefs.getInt(KEY_HOME_GRID_ROWS, DEFAULT_HOME_GRID_ROWS),
            autoArrangeApps = readAutoRearrangeApps(prefs),
            darkMode = prefs.getBoolean(KEY_LAYOUT_DARK_MODE, DEFAULT_DARK_MODE)
        )
    }

    fun resolve(
        iconSizeDp: Int,
        rows: Int,
        autoArrangeApps: Boolean = DEFAULT_AUTO_REARRANGE_APPS,
        darkMode: Boolean = DEFAULT_DARK_MODE
    ): LauncherHomeLayoutSettings {
        return LauncherHomeLayoutSettings(
            iconSizeDp = iconSizeDp.coerceIn(MIN_HOME_ICON_SIZE_DP, MAX_HOME_ICON_SIZE_DP),
            rows = rows.takeIf { it == HOME_GRID_ROWS_5 || it == HOME_GRID_ROWS_6 } ?: DEFAULT_HOME_GRID_ROWS,
            columns = HOME_PAGE_COLUMNS,
            autoArrangeApps = autoArrangeApps,
            darkMode = darkMode
        )
    }

    fun sliderProgressToIconSize(progress: Int): Int {
        return (MIN_HOME_ICON_SIZE_DP + progress).coerceIn(MIN_HOME_ICON_SIZE_DP, MAX_HOME_ICON_SIZE_DP)
    }

    fun iconSizeToSliderProgress(iconSizeDp: Int): Int {
        return (iconSizeDp.coerceIn(MIN_HOME_ICON_SIZE_DP, MAX_HOME_ICON_SIZE_DP) - MIN_HOME_ICON_SIZE_DP)
            .coerceIn(0, ICON_SIZE_SLIDER_MAX)
    }

    fun isAutoRearrangeAppsEnabled(context: Context): Boolean {
        return read(context).autoArrangeApps
    }

    fun isLiquidGlassEnabled(context: Context): Boolean {
        return context.getSharedPreferences(LAYOUT_PREFERENCES_NAME, Context.MODE_PRIVATE)
            .getBoolean(KEY_LAYOUT_LIQUID_GLASS, false)
    }

    fun isDarkModeEnabled(context: Context): Boolean {
        return context.getSharedPreferences(LAYOUT_PREFERENCES_NAME, Context.MODE_PRIVATE)
            .getBoolean(KEY_LAYOUT_DARK_MODE, DEFAULT_DARK_MODE)
    }

    fun isBlurEffectEnabled(context: Context): Boolean {
        return context.getSharedPreferences(LAYOUT_PREFERENCES_NAME, Context.MODE_PRIVATE)
            .getBoolean(KEY_BLUR_EFFECT_ENABLED, DEFAULT_BLUR_EFFECT_ENABLED)
    }

    fun isFolderBlurEnabled(context: Context): Boolean {
        return context.getSharedPreferences(LAYOUT_PREFERENCES_NAME, Context.MODE_PRIVATE)
            .getBoolean(KEY_BLUR_FOLDER_ENABLED, DEFAULT_BLUR_TARGET_ENABLED)
    }

    fun isSearchBlurEnabled(context: Context): Boolean {
        return context.getSharedPreferences(LAYOUT_PREFERENCES_NAME, Context.MODE_PRIVATE)
            .getBoolean(KEY_BLUR_SEARCH_ENABLED, DEFAULT_BLUR_TARGET_ENABLED)
    }

    fun setAutoRearrangeApps(context: Context, enabled: Boolean) {
        context.getSharedPreferences(LAYOUT_PREFERENCES_NAME, Context.MODE_PRIVATE)
            .edit()
            .putBoolean(KEY_AUTO_REARRANGE_APPS, enabled)
            .putBoolean(KEY_LAYOUT_AUTO_REARRANGE_APPS, enabled)
            .apply()
    }

    fun setDarkMode(context: Context, enabled: Boolean) {
        context.getSharedPreferences(LAYOUT_PREFERENCES_NAME, Context.MODE_PRIVATE)
            .edit()
            .putBoolean(KEY_LAYOUT_DARK_MODE, enabled)
            .apply()
    }

    fun customWallpaperUri(context: Context): String? {
        return context.getSharedPreferences(LAYOUT_PREFERENCES_NAME, Context.MODE_PRIVATE)
            .getString(KEY_CUSTOM_WALLPAPER_URI, null)
    }

    fun setCustomWallpaperUri(context: Context, uri: String?) {
        val editor = context.getSharedPreferences(LAYOUT_PREFERENCES_NAME, Context.MODE_PRIVATE).edit()
        if (uri.isNullOrBlank()) {
            editor.remove(KEY_CUSTOM_WALLPAPER_URI)
        } else {
            editor.putString(KEY_CUSTOM_WALLPAPER_URI, uri)
        }
        editor.apply()
    }

    private fun readAutoRearrangeApps(prefs: SharedPreferences): Boolean {
        if (prefs.contains(KEY_LAYOUT_AUTO_REARRANGE_APPS)) {
            return prefs.getBoolean(KEY_LAYOUT_AUTO_REARRANGE_APPS, DEFAULT_AUTO_REARRANGE_APPS)
        }
        return prefs.getBoolean(KEY_AUTO_REARRANGE_APPS, DEFAULT_AUTO_REARRANGE_APPS)
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

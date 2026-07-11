package com.vhmsoft.launcherios26.core

import android.content.Context
import android.content.SharedPreferences
import kotlin.math.min
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
    const val KEY_HOME_ICON_SIZE_COMPACT_MIGRATION_APPLIED = "home_icon_size_compact_migration_applied"
    const val KEY_HOME_ICON_SIZE_DEFAULT_56_MIGRATION_APPLIED =
        "home_icon_size_default_56_migration_applied"
    const val KEY_HOME_ICON_SIZE_DEFAULT_60_MIGRATION_APPLIED =
        "home_icon_size_default_60_migration_applied"
    const val KEY_HOME_ICON_SIZE_DEFAULT_58_MIGRATION_APPLIED =
        "home_icon_size_default_58_migration_applied"
    const val KEY_HOME_GRID_ROWS = "home_grid_rows"
    const val KEY_AUTO_REARRANGE_APPS = "auto_rearrange"
    const val KEY_LAYOUT_AUTO_REARRANGE_APPS = "layout_auto_arrange"
    const val KEY_LAYOUT_LIQUID_GLASS = "layout_liquid_glass"
    const val KEY_LAYOUT_DARK_MODE = "layout_dark_mode"
    const val KEY_CUSTOM_WALLPAPER_URI = "custom_wallpaper_uri"
    const val KEY_BLUR_EFFECT_ENABLED = "blur_effect_enabled"
    const val KEY_BLUR_DOCK_ENABLED = "blur_dock_enabled"
    const val KEY_BLUR_FOLDER_ENABLED = "blur_folder_enabled"
    const val KEY_BLUR_WIDGET_ENABLED = "blur_widget_enabled"
    const val KEY_BLUR_SEARCH_ENABLED = "blur_search_enabled"

    const val HOME_PAGE_COLUMNS = 4
    const val HOME_GRID_ROWS_5 = 5
    const val HOME_GRID_ROWS_6 = 6
    const val DEFAULT_HOME_GRID_ROWS = HOME_GRID_ROWS_6

    const val MIN_HOME_ICON_SIZE_DP = 46
    const val DEFAULT_HOME_ICON_SIZE_DP = 58
    const val MAX_HOME_ICON_SIZE_DP = 70
    const val ICON_SIZE_SLIDER_MAX = 20
    const val DEFAULT_ICON_SIZE_SLIDER_PROGRESS = ICON_SIZE_SLIDER_MAX / 2
    const val DEFAULT_AUTO_REARRANGE_APPS = false
    const val DEFAULT_DARK_MODE = false
    const val DEFAULT_LIQUID_GLASS_ENABLED = true
    const val DEFAULT_BLUR_EFFECT_ENABLED = true
    const val DEFAULT_BLUR_TARGET_ENABLED = true
    private const val MIN_APP_LABEL_TEXT_SIZE_SP = 10f
    private const val MAX_APP_LABEL_TEXT_SIZE_SP = 14f

    const val HOME_PAGE_TOP_PADDING_DP = 40
    const val EDIT_HOME_PAGE_TOP_PADDING_DP = HOME_PAGE_TOP_PADDING_DP
    const val PAGE_INDICATOR_HEIGHT_DP = 34
    const val INDICATOR_DOCK_GAP_DP = 12
    const val DOCK_HORIZONTAL_MARGIN_DP = 12
    const val DOCK_EXTRA_HEIGHT_DP = 44
    const val DOCK_BOTTOM_MARGIN_DP = 8

    private const val LEGACY_DEFAULT_HOME_ICON_SIZE_DP = 55
    private const val LEGACY_LARGE_DEFAULT_HOME_ICON_SIZE_DP = 65
    private const val PREVIOUS_COMPACT_DEFAULT_HOME_ICON_SIZE_DP = 52
    private const val PREVIOUS_DEFAULT_56_HOME_ICON_SIZE_DP = 56
    private const val PREVIOUS_DEFAULT_57_HOME_ICON_SIZE_DP = 57
    private const val PREVIOUS_DEFAULT_60_HOME_ICON_SIZE_DP = 60
    private const val RESPONSIVE_REFERENCE_WIDTH_DP = 390f
    private const val RESPONSIVE_REFERENCE_HEIGHT_DP = 844f
    private const val MIN_RESPONSIVE_ICON_SCALE = 0.9f
    private const val MIN_RESPONSIVE_HOME_ICON_SIZE_DP = 42
    private const val MIN_HORIZONTAL_GAP_DP = 8

    fun read(context: Context): LauncherHomeLayoutSettings {
        val prefs = context.getSharedPreferences(LAYOUT_PREFERENCES_NAME, Context.MODE_PRIVATE)
        val rawIconSizeDp = prefs.getInt(KEY_HOME_ICON_SIZE_DP, DEFAULT_HOME_ICON_SIZE_DP)
        val migrationApplied = prefs.getBoolean(KEY_HOME_ICON_SIZE_COMPACT_MIGRATION_APPLIED, false)
        val default56MigrationApplied =
            prefs.getBoolean(KEY_HOME_ICON_SIZE_DEFAULT_56_MIGRATION_APPLIED, false)
        val default60MigrationApplied =
            prefs.getBoolean(KEY_HOME_ICON_SIZE_DEFAULT_60_MIGRATION_APPLIED, false)
        val default58MigrationApplied =
            prefs.getBoolean(KEY_HOME_ICON_SIZE_DEFAULT_58_MIGRATION_APPLIED, false)
        val iconSizeDp = migrateStoredIconSizeDp(
            iconSizeDp = rawIconSizeDp,
            migrationApplied = migrationApplied,
            default56MigrationApplied = default56MigrationApplied,
            default60MigrationApplied = default60MigrationApplied,
            default58MigrationApplied = default58MigrationApplied
        )
        if (!migrationApplied ||
            !default56MigrationApplied ||
            !default60MigrationApplied ||
            !default58MigrationApplied
        ) {
            prefs.edit()
                .putInt(KEY_HOME_ICON_SIZE_DP, iconSizeDp)
                .putBoolean(KEY_HOME_ICON_SIZE_COMPACT_MIGRATION_APPLIED, true)
                .putBoolean(KEY_HOME_ICON_SIZE_DEFAULT_56_MIGRATION_APPLIED, true)
                .putBoolean(KEY_HOME_ICON_SIZE_DEFAULT_60_MIGRATION_APPLIED, true)
                .putBoolean(KEY_HOME_ICON_SIZE_DEFAULT_58_MIGRATION_APPLIED, true)
                .apply()
        }
        return resolve(
            iconSizeDp = iconSizeDp,
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
        val safeProgress = progress.coerceIn(0, ICON_SIZE_SLIDER_MAX)
        return if (safeProgress <= DEFAULT_ICON_SIZE_SLIDER_PROGRESS) {
            val lowerRange = DEFAULT_HOME_ICON_SIZE_DP - MIN_HOME_ICON_SIZE_DP
            MIN_HOME_ICON_SIZE_DP +
                (safeProgress * lowerRange.toFloat() / DEFAULT_ICON_SIZE_SLIDER_PROGRESS).roundToInt()
        } else {
            val upperProgress = safeProgress - DEFAULT_ICON_SIZE_SLIDER_PROGRESS
            val upperRange = MAX_HOME_ICON_SIZE_DP - DEFAULT_HOME_ICON_SIZE_DP
            DEFAULT_HOME_ICON_SIZE_DP +
                (upperProgress * upperRange.toFloat() / DEFAULT_ICON_SIZE_SLIDER_PROGRESS).roundToInt()
        }.coerceIn(MIN_HOME_ICON_SIZE_DP, MAX_HOME_ICON_SIZE_DP)
    }

    fun iconSizeToSliderProgress(iconSizeDp: Int): Int {
        val safeSize = iconSizeDp.coerceIn(MIN_HOME_ICON_SIZE_DP, MAX_HOME_ICON_SIZE_DP)
        return if (safeSize <= DEFAULT_HOME_ICON_SIZE_DP) {
            val lowerRange = DEFAULT_HOME_ICON_SIZE_DP - MIN_HOME_ICON_SIZE_DP
            ((safeSize - MIN_HOME_ICON_SIZE_DP) *
                DEFAULT_ICON_SIZE_SLIDER_PROGRESS.toFloat() / lowerRange).roundToInt()
        } else {
            val upperRange = MAX_HOME_ICON_SIZE_DP - DEFAULT_HOME_ICON_SIZE_DP
            DEFAULT_ICON_SIZE_SLIDER_PROGRESS +
                ((safeSize - DEFAULT_HOME_ICON_SIZE_DP) *
                    DEFAULT_ICON_SIZE_SLIDER_PROGRESS.toFloat() / upperRange).roundToInt()
        }.coerceIn(0, ICON_SIZE_SLIDER_MAX)
    }

    fun appLabelTextSizeSp(iconSizeDp: Int): Float {
        val safeSize = iconSizeDp.coerceIn(MIN_HOME_ICON_SIZE_DP, MAX_HOME_ICON_SIZE_DP)
        return if (safeSize <= DEFAULT_HOME_ICON_SIZE_DP) {
            val progress = (safeSize - MIN_HOME_ICON_SIZE_DP).toFloat() /
                (DEFAULT_HOME_ICON_SIZE_DP - MIN_HOME_ICON_SIZE_DP)
            MIN_APP_LABEL_TEXT_SIZE_SP +
                progress * (LauncherAppLabelStylePolicy.TEXT_SIZE_SP - MIN_APP_LABEL_TEXT_SIZE_SP)
        } else {
            val progress = (safeSize - DEFAULT_HOME_ICON_SIZE_DP).toFloat() /
                (MAX_HOME_ICON_SIZE_DP - DEFAULT_HOME_ICON_SIZE_DP)
            LauncherAppLabelStylePolicy.TEXT_SIZE_SP +
                progress * (MAX_APP_LABEL_TEXT_SIZE_SP - LauncherAppLabelStylePolicy.TEXT_SIZE_SP)
        }
    }

    fun responsiveIconSizeDp(
        iconSizeDp: Int,
        density: Float,
        availableWidthPx: Int,
        availableHeightPx: Int
    ): Int {
        val safeIconSize = iconSizeDp.coerceIn(MIN_HOME_ICON_SIZE_DP, MAX_HOME_ICON_SIZE_DP)
        val scale = responsiveIconScale(
            density = density,
            availableWidthPx = availableWidthPx,
            availableHeightPx = availableHeightPx
        )
        return (safeIconSize * scale)
            .roundToInt()
            .coerceIn(MIN_RESPONSIVE_HOME_ICON_SIZE_DP, MAX_HOME_ICON_SIZE_DP)
    }

    fun migrateStoredIconSizeDp(
        iconSizeDp: Int,
        migrationApplied: Boolean
    ): Int {
        return migrateStoredIconSizeDp(
            iconSizeDp = iconSizeDp,
            migrationApplied = migrationApplied,
            default56MigrationApplied = false,
            default60MigrationApplied = false,
            default58MigrationApplied = false
        )
    }

    fun migrateStoredIconSizeDp(
        iconSizeDp: Int,
        migrationApplied: Boolean,
        default56MigrationApplied: Boolean
    ): Int {
        return migrateStoredIconSizeDp(
            iconSizeDp = iconSizeDp,
            migrationApplied = migrationApplied,
            default56MigrationApplied = default56MigrationApplied,
            default60MigrationApplied = false,
            default58MigrationApplied = false
        )
    }

    fun migrateStoredIconSizeDp(
        iconSizeDp: Int,
        migrationApplied: Boolean,
        default56MigrationApplied: Boolean,
        default60MigrationApplied: Boolean
    ): Int {
        return migrateStoredIconSizeDp(
            iconSizeDp = iconSizeDp,
            migrationApplied = migrationApplied,
            default56MigrationApplied = default56MigrationApplied,
            default60MigrationApplied = default60MigrationApplied,
            default58MigrationApplied = false
        )
    }

    fun migrateStoredIconSizeDp(
        iconSizeDp: Int,
        migrationApplied: Boolean,
        default56MigrationApplied: Boolean,
        default60MigrationApplied: Boolean,
        default58MigrationApplied: Boolean = false
    ): Int {
        val compactMigratedSize = if (!migrationApplied) {
            when (iconSizeDp) {
                LEGACY_DEFAULT_HOME_ICON_SIZE_DP,
                LEGACY_LARGE_DEFAULT_HOME_ICON_SIZE_DP -> DEFAULT_HOME_ICON_SIZE_DP
                else -> iconSizeDp
            }
        } else {
            iconSizeDp
        }
        val default56MigratedSize = if (!default56MigrationApplied &&
            compactMigratedSize == PREVIOUS_COMPACT_DEFAULT_HOME_ICON_SIZE_DP
        ) {
            DEFAULT_HOME_ICON_SIZE_DP
        } else {
            compactMigratedSize
        }
        val default60MigratedSize = if (!default60MigrationApplied &&
            (default56MigratedSize == PREVIOUS_DEFAULT_56_HOME_ICON_SIZE_DP ||
                default56MigratedSize == PREVIOUS_DEFAULT_57_HOME_ICON_SIZE_DP)
        ) {
            DEFAULT_HOME_ICON_SIZE_DP
        } else {
            default56MigratedSize
        }
        val migratedSize = if (!default58MigrationApplied &&
            default60MigratedSize == PREVIOUS_DEFAULT_60_HOME_ICON_SIZE_DP
        ) {
            DEFAULT_HOME_ICON_SIZE_DP
        } else {
            default60MigratedSize
        }
        return migratedSize.coerceIn(MIN_HOME_ICON_SIZE_DP, MAX_HOME_ICON_SIZE_DP)
    }

    fun isAutoRearrangeAppsEnabled(context: Context): Boolean {
        return read(context).autoArrangeApps
    }

    fun isLiquidGlassEnabled(context: Context): Boolean {
        return context.getSharedPreferences(LAYOUT_PREFERENCES_NAME, Context.MODE_PRIVATE)
            .getBoolean(KEY_LAYOUT_LIQUID_GLASS, DEFAULT_LIQUID_GLASS_ENABLED)
    }

    fun isDarkModeEnabled(context: Context): Boolean {
        return context.getSharedPreferences(LAYOUT_PREFERENCES_NAME, Context.MODE_PRIVATE)
            .getBoolean(KEY_LAYOUT_DARK_MODE, DEFAULT_DARK_MODE)
    }

    fun isBlurEffectEnabled(context: Context): Boolean {
        return context.getSharedPreferences(LAYOUT_PREFERENCES_NAME, Context.MODE_PRIVATE)
            .getBoolean(KEY_BLUR_EFFECT_ENABLED, DEFAULT_BLUR_EFFECT_ENABLED)
    }

    fun isDockBlurEnabled(context: Context): Boolean {
        return context.getSharedPreferences(LAYOUT_PREFERENCES_NAME, Context.MODE_PRIVATE)
            .getBoolean(KEY_BLUR_DOCK_ENABLED, DEFAULT_BLUR_TARGET_ENABLED)
    }

    fun isFolderBlurEnabled(context: Context): Boolean {
        return context.getSharedPreferences(LAYOUT_PREFERENCES_NAME, Context.MODE_PRIVATE)
            .getBoolean(KEY_BLUR_FOLDER_ENABLED, DEFAULT_BLUR_TARGET_ENABLED)
    }

    fun isWidgetBlurEnabled(context: Context): Boolean {
        return context.getSharedPreferences(LAYOUT_PREFERENCES_NAME, Context.MODE_PRIVATE)
            .getBoolean(KEY_BLUR_WIDGET_ENABLED, DEFAULT_BLUR_TARGET_ENABLED)
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

    fun setDockBlur(context: Context, enabled: Boolean) {
        context.getSharedPreferences(LAYOUT_PREFERENCES_NAME, Context.MODE_PRIVATE)
            .edit()
            .putBoolean(KEY_BLUR_DOCK_ENABLED, enabled)
            .apply()
    }

    fun setFolderBlur(context: Context, enabled: Boolean) {
        context.getSharedPreferences(LAYOUT_PREFERENCES_NAME, Context.MODE_PRIVATE)
            .edit()
            .putBoolean(KEY_BLUR_FOLDER_ENABLED, enabled)
            .apply()
    }

    fun setWidgetBlur(context: Context, enabled: Boolean) {
        context.getSharedPreferences(LAYOUT_PREFERENCES_NAME, Context.MODE_PRIVATE)
            .edit()
            .putBoolean(KEY_BLUR_WIDGET_ENABLED, enabled)
            .apply()
    }

    fun setSearchBlur(context: Context, enabled: Boolean) {
        context.getSharedPreferences(LAYOUT_PREFERENCES_NAME, Context.MODE_PRIVATE)
            .edit()
            .putBoolean(KEY_BLUR_SEARCH_ENABLED, enabled)
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
        val preferredIconPx = dp(
            responsiveIconSizeDp(
                iconSizeDp = settings.iconSizeDp,
                density = safeDensity,
                availableWidthPx = availableWidthPx,
                availableHeightPx = availableHeightPx
            ),
            safeDensity
        )
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

    private fun responsiveIconScale(
        density: Float,
        availableWidthPx: Int,
        availableHeightPx: Int
    ): Float {
        val safeDensity = density.takeIf { it > 0f } ?: 1f
        val widthDp = availableWidthPx.takeIf { it > 0 }?.let { it / safeDensity } ?: RESPONSIVE_REFERENCE_WIDTH_DP
        val heightDp = availableHeightPx.takeIf { it > 0 }?.let { it / safeDensity } ?: RESPONSIVE_REFERENCE_HEIGHT_DP
        val widthScale = widthDp / RESPONSIVE_REFERENCE_WIDTH_DP
        val heightScale = heightDp / RESPONSIVE_REFERENCE_HEIGHT_DP
        return min(widthScale, heightScale).coerceIn(MIN_RESPONSIVE_ICON_SCALE, 1f)
    }
}

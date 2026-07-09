package com.vhmsoft.launcherios26.ui.launcher

import com.cloudx.ios17.core.LauncherHomeLayoutPreferences

object LauncherHomeIconSizePolicy {
    const val MIN_HOME_ICON_SIZE_DP = LauncherHomeLayoutPreferences.MIN_HOME_ICON_SIZE_DP
    const val DEFAULT_HOME_ICON_SIZE_DP = LauncherHomeLayoutPreferences.DEFAULT_HOME_ICON_SIZE_DP
    const val MAX_HOME_ICON_SIZE_DP = LauncherHomeLayoutPreferences.MAX_HOME_ICON_SIZE_DP
    const val ICON_SIZE_SLIDER_MAX = LauncherHomeLayoutPreferences.ICON_SIZE_SLIDER_MAX
    const val DEFAULT_ICON_SIZE_SLIDER_PROGRESS =
        LauncherHomeLayoutPreferences.DEFAULT_ICON_SIZE_SLIDER_PROGRESS
    const val KEY_HOME_ICON_SIZE_COMPACT_MIGRATION_APPLIED =
        LauncherHomeLayoutPreferences.KEY_HOME_ICON_SIZE_COMPACT_MIGRATION_APPLIED
    const val KEY_HOME_ICON_SIZE_DEFAULT_56_MIGRATION_APPLIED =
        LauncherHomeLayoutPreferences.KEY_HOME_ICON_SIZE_DEFAULT_56_MIGRATION_APPLIED

    fun sliderProgressToIconSize(progress: Int): Int {
        return LauncherHomeLayoutPreferences.sliderProgressToIconSize(progress)
    }

    fun iconSizeToSliderProgress(iconSizeDp: Int): Int {
        return LauncherHomeLayoutPreferences.iconSizeToSliderProgress(iconSizeDp)
    }

    fun appLabelTextSizeSp(iconSizeDp: Int): Float {
        return LauncherHomeLayoutPreferences.appLabelTextSizeSp(iconSizeDp)
    }

    fun migrateStoredIconSizeDp(
        iconSizeDp: Int,
        migrationApplied: Boolean,
        default56MigrationApplied: Boolean = false
    ): Int {
        return LauncherHomeLayoutPreferences.migrateStoredIconSizeDp(
            iconSizeDp = iconSizeDp,
            migrationApplied = migrationApplied,
            default56MigrationApplied = default56MigrationApplied
        )
    }
}

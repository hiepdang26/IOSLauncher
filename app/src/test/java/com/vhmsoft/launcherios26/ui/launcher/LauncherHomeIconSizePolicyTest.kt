package com.vhmsoft.launcherios26.ui.launcher

import com.cloudx.ios17.core.LauncherHomeLayoutPreferences
import org.junit.Assert.assertEquals
import org.junit.Test

class LauncherHomeIconSizePolicyTest {
    @Test
    fun iconSizeRange_matchesActiveIos17LauncherHome() {
        assertEquals(
            LauncherHomeLayoutPreferences.MIN_HOME_ICON_SIZE_DP,
            LauncherHomeIconSizePolicy.MIN_HOME_ICON_SIZE_DP
        )
        assertEquals(
            LauncherHomeLayoutPreferences.DEFAULT_HOME_ICON_SIZE_DP,
            LauncherHomeIconSizePolicy.DEFAULT_HOME_ICON_SIZE_DP
        )
        assertEquals(
            LauncherHomeLayoutPreferences.MAX_HOME_ICON_SIZE_DP,
            LauncherHomeIconSizePolicy.MAX_HOME_ICON_SIZE_DP
        )
    }

    @Test
    fun defaultIconSize_sitsAtSliderMiddleAndMapsBackToStandardSize() {
        assertEquals(
            LauncherHomeIconSizePolicy.ICON_SIZE_SLIDER_MAX / 2,
            LauncherHomeIconSizePolicy.DEFAULT_ICON_SIZE_SLIDER_PROGRESS
        )
        assertEquals(
            LauncherHomeIconSizePolicy.DEFAULT_HOME_ICON_SIZE_DP,
            LauncherHomeIconSizePolicy.sliderProgressToIconSize(
                LauncherHomeIconSizePolicy.DEFAULT_ICON_SIZE_SLIDER_PROGRESS
            )
        )
        assertEquals(
            LauncherHomeIconSizePolicy.DEFAULT_ICON_SIZE_SLIDER_PROGRESS,
            LauncherHomeIconSizePolicy.iconSizeToSliderProgress(
                LauncherHomeIconSizePolicy.DEFAULT_HOME_ICON_SIZE_DP
            )
        )
    }

    @Test
    fun iconSizeRange_usesRequestedSizesShiftedUpByOneDp() {
        assertEquals(46, LauncherHomeIconSizePolicy.MIN_HOME_ICON_SIZE_DP)
        assertEquals(57, LauncherHomeIconSizePolicy.DEFAULT_HOME_ICON_SIZE_DP)
        assertEquals(69, LauncherHomeIconSizePolicy.MAX_HOME_ICON_SIZE_DP)
    }

    @Test
    fun appLabelTextSize_scalesWithIconSize() {
        assertEquals(11f, LauncherHomeIconSizePolicy.appLabelTextSizeSp(46), 0.001f)
        assertEquals(13f, LauncherHomeIconSizePolicy.appLabelTextSizeSp(57), 0.001f)
        assertEquals(15f, LauncherHomeIconSizePolicy.appLabelTextSizeSp(69), 0.001f)
    }

    @Test
    fun migrateStoredIconSize_matchesActiveIos17LauncherHome() {
        assertEquals(57, LauncherHomeIconSizePolicy.migrateStoredIconSizeDp(55, migrationApplied = false))
        assertEquals(57, LauncherHomeIconSizePolicy.migrateStoredIconSizeDp(65, migrationApplied = false))
        assertEquals(55, LauncherHomeIconSizePolicy.migrateStoredIconSizeDp(55, migrationApplied = true))
        assertEquals(65, LauncherHomeIconSizePolicy.migrateStoredIconSizeDp(65, migrationApplied = true))
        assertEquals(
            57,
            LauncherHomeIconSizePolicy.migrateStoredIconSizeDp(
                iconSizeDp = 52,
                migrationApplied = true,
                default56MigrationApplied = false
            )
        )
    }
}

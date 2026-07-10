package com.cloudx.ios17.core

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherHomeLayoutPreferencesTest {

    @Test
    fun resolve_defaultsToSixByFourGrid() {
        val settings = LauncherHomeLayoutPreferences.resolve(iconSizeDp = 64, rows = 99)

        assertEquals(6, settings.rows)
        assertEquals(4, settings.columns)
        assertEquals(24, settings.maxAppsPerPage)
        assertFalse(settings.autoArrangeApps)
        assertFalse(settings.darkMode)
    }

    @Test
    fun resolve_acceptsFiveByFourGrid() {
        val settings = LauncherHomeLayoutPreferences.resolve(iconSizeDp = 64, rows = 5)

        assertEquals(5, settings.rows)
        assertEquals(20, settings.maxAppsPerPage)
    }

    @Test
    fun resolve_coercesIconSliderRange() {
        assertEquals(46, LauncherHomeLayoutPreferences.resolve(iconSizeDp = 1, rows = 6).iconSizeDp)
        assertEquals(70, LauncherHomeLayoutPreferences.resolve(iconSizeDp = 200, rows = 6).iconSizeDp)
    }

    @Test
    fun defaults_matchReferenceHomeIconSize() {
        val settings = LauncherHomeLayoutPreferences.resolve(
            iconSizeDp = LauncherHomeLayoutPreferences.DEFAULT_HOME_ICON_SIZE_DP,
            rows = 6
        )

        assertEquals(58, settings.iconSizeDp)
    }

    @Test
    fun defaultIconSize_sitsAtTheMiddleOfSliderControl() {
        assertEquals(
            LauncherHomeLayoutPreferences.ICON_SIZE_SLIDER_MAX / 2,
            LauncherHomeLayoutPreferences.DEFAULT_ICON_SIZE_SLIDER_PROGRESS
        )
        assertEquals(
            LauncherHomeLayoutPreferences.DEFAULT_HOME_ICON_SIZE_DP,
            LauncherHomeLayoutPreferences.sliderProgressToIconSize(
                LauncherHomeLayoutPreferences.DEFAULT_ICON_SIZE_SLIDER_PROGRESS
            )
        )
    }

    @Test
    fun sliderProgress_mapsBackToClampedIconSizes() {
        assertEquals(46, LauncherHomeLayoutPreferences.sliderProgressToIconSize(-20))
        assertEquals(58, LauncherHomeLayoutPreferences.sliderProgressToIconSize(10))
        assertEquals(70, LauncherHomeLayoutPreferences.sliderProgressToIconSize(200))
        assertEquals(10, LauncherHomeLayoutPreferences.iconSizeToSliderProgress(58))
    }

    @Test
    fun appLabelTextSize_scalesWithIconSize() {
        assertEquals(10f, LauncherHomeLayoutPreferences.appLabelTextSizeSp(46), 0.001f)
        assertEquals(12f, LauncherHomeLayoutPreferences.appLabelTextSizeSp(58), 0.001f)
        assertEquals(14f, LauncherHomeLayoutPreferences.appLabelTextSizeSp(70), 0.001f)
    }

    @Test
    fun migrateStoredIconSize_mapsPreviousDefaultSizesToNewDefaultOnce() {
        assertEquals(58, LauncherHomeLayoutPreferences.migrateStoredIconSizeDp(55, migrationApplied = false))
        assertEquals(58, LauncherHomeLayoutPreferences.migrateStoredIconSizeDp(65, migrationApplied = false))
        assertEquals(55, LauncherHomeLayoutPreferences.migrateStoredIconSizeDp(55, migrationApplied = true))
        assertEquals(65, LauncherHomeLayoutPreferences.migrateStoredIconSizeDp(65, migrationApplied = true))
        assertEquals(46, LauncherHomeLayoutPreferences.migrateStoredIconSizeDp(1, migrationApplied = false))
        assertEquals(70, LauncherHomeLayoutPreferences.migrateStoredIconSizeDp(200, migrationApplied = false))
    }

    @Test
    fun migrateStoredIconSize_mapsPreviousCompactDefaultToNewDefaultOnce() {
        assertEquals(
            58,
            LauncherHomeLayoutPreferences.migrateStoredIconSizeDp(
                iconSizeDp = 52,
                migrationApplied = true,
                default56MigrationApplied = false
            )
        )
        assertEquals(
            52,
            LauncherHomeLayoutPreferences.migrateStoredIconSizeDp(
                iconSizeDp = 52,
                migrationApplied = true,
                default56MigrationApplied = true,
                default60MigrationApplied = true
            )
        )
    }

    @Test
    fun migrateStoredIconSize_mapsPreviousDefault57ToNewDefaultOnce() {
        assertEquals(
            58,
            LauncherHomeLayoutPreferences.migrateStoredIconSizeDp(
                iconSizeDp = 57,
                migrationApplied = true,
                default56MigrationApplied = true,
                default60MigrationApplied = false
            )
        )
        assertEquals(
            57,
            LauncherHomeLayoutPreferences.migrateStoredIconSizeDp(
                iconSizeDp = 57,
                migrationApplied = true,
                default56MigrationApplied = true,
                default60MigrationApplied = true
            )
        )
    }

    @Test
    fun migrateStoredIconSize_mapsPreviousDefault60ToCurrentDefaultOnce() {
        assertEquals(
            58,
            LauncherHomeLayoutPreferences.migrateStoredIconSizeDp(
                iconSizeDp = 60,
                migrationApplied = true,
                default56MigrationApplied = true,
                default60MigrationApplied = true,
                default58MigrationApplied = false
            )
        )
        assertEquals(
            60,
            LauncherHomeLayoutPreferences.migrateStoredIconSizeDp(
                iconSizeDp = 60,
                migrationApplied = true,
                default56MigrationApplied = true,
                default60MigrationApplied = true,
                default58MigrationApplied = true
            )
        )
    }

    @Test
    fun resolve_acceptsAutoArrangePreference() {
        val settings = LauncherHomeLayoutPreferences.resolve(
            iconSizeDp = 70,
            rows = 6,
            autoArrangeApps = true,
            darkMode = true
        )

        assertTrue(settings.autoArrangeApps)
        assertTrue(settings.darkMode)
    }

    @Test
    fun darkMode_defaultsToCurrentLightAppearance() {
        assertFalse(LauncherHomeLayoutPreferences.DEFAULT_DARK_MODE)
    }

    @Test
    fun chromeSpacing_matchesReferenceHomeLayout() {
        assertEquals(40, LauncherHomeLayoutPreferences.HOME_PAGE_TOP_PADDING_DP)
        assertEquals(44, LauncherHomeLayoutPreferences.DOCK_EXTRA_HEIGHT_DP)
        assertEquals(12, LauncherHomeLayoutPreferences.INDICATOR_DOCK_GAP_DP)
        assertEquals(8, LauncherHomeLayoutPreferences.DOCK_BOTTOM_MARGIN_DP)
    }

    @Test
    fun horizontalGap_keepsFourColumnsInsideThePageWidth() {
        val gapPx = LauncherHomeLayoutPreferences.horizontalGapPx(
            availableWidthPx = 400,
            iconSizePx = 78,
            columns = 4
        )
        val usedWidth = 4 * (78 + gapPx) + gapPx

        assertTrue(usedWidth <= 400)
    }

    @Test
    fun resolveIconSizePx_keepsGridIndicatorAndDockInsideAvailableHeight() {
        val iconSizePx = LauncherHomeLayoutPreferences.resolveIconSizePx(
            preferredIconSizeDp = 78,
            density = 1f,
            availableWidthPx = 400,
            availableHeightPx = 640,
            rows = 6,
            columns = 4,
            labelHeightPx = 14,
            labelGapPx = 4
        )
        val usedHeight =
            6 * (iconSizePx + 14 + 4) +
                iconSizePx +
                LauncherHomeLayoutPreferences.HOME_PAGE_TOP_PADDING_DP +
                LauncherHomeLayoutPreferences.PAGE_INDICATOR_HEIGHT_DP +
                LauncherHomeLayoutPreferences.INDICATOR_DOCK_GAP_DP +
                LauncherHomeLayoutPreferences.DOCK_EXTRA_HEIGHT_DP +
                LauncherHomeLayoutPreferences.DOCK_BOTTOM_MARGIN_DP

        assertTrue(usedHeight <= 640)
    }

    @Test
    fun responsiveIconSize_keepsReferencePhoneAtSelectedSize() {
        assertEquals(
            58,
            LauncherHomeLayoutPreferences.responsiveIconSizeDp(
                iconSizeDp = 58,
                density = 1f,
                availableWidthPx = 390,
                availableHeightPx = 844
            )
        )
    }

    @Test
    fun responsiveIconSize_reducesSelectedSizeOnCompactPhones() {
        assertEquals(
            52,
            LauncherHomeLayoutPreferences.responsiveIconSizeDp(
                iconSizeDp = 58,
                density = 1f,
                availableWidthPx = 320,
                availableHeightPx = 640
            )
        )
    }

    @Test
    fun resolveIconSizePx_usesResponsiveSizeBeforeLayoutCaps() {
        assertEquals(
            52,
            LauncherHomeLayoutPreferences.resolveIconSizePx(
                preferredIconSizeDp = 58,
                density = 1f,
                availableWidthPx = 320,
                availableHeightPx = 640,
                rows = 6,
                columns = 4,
                labelHeightPx = 14,
                labelGapPx = 4
            )
        )
    }

    @Test
    fun homePageTopPadding_keepsIconGridStableWhileEditing() {
        assertEquals(40, LauncherHomeLayoutPreferences.homePageTopPaddingDp(isEditing = false))
        assertEquals(40, LauncherHomeLayoutPreferences.homePageTopPaddingDp(isEditing = true))
    }
}

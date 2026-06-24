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
    }

    @Test
    fun resolve_acceptsFiveByFourGrid() {
        val settings = LauncherHomeLayoutPreferences.resolve(iconSizeDp = 64, rows = 5)

        assertEquals(5, settings.rows)
        assertEquals(20, settings.maxAppsPerPage)
    }

    @Test
    fun resolve_coercesIconSliderRange() {
        assertEquals(64, LauncherHomeLayoutPreferences.resolve(iconSizeDp = 1, rows = 6).iconSizeDp)
        assertEquals(78, LauncherHomeLayoutPreferences.resolve(iconSizeDp = 200, rows = 6).iconSizeDp)
    }

    @Test
    fun defaults_matchReferenceHomeIconSize() {
        val settings = LauncherHomeLayoutPreferences.resolve(
            iconSizeDp = LauncherHomeLayoutPreferences.DEFAULT_HOME_ICON_SIZE_DP,
            rows = 6
        )

        assertEquals(70, settings.iconSizeDp)
    }

    @Test
    fun resolve_acceptsAutoArrangePreference() {
        val settings = LauncherHomeLayoutPreferences.resolve(
            iconSizeDp = 70,
            rows = 6,
            autoArrangeApps = true
        )

        assertTrue(settings.autoArrangeApps)
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
    fun homePageTopPadding_movesAppsBelowEditControlsWhileEditing() {
        assertEquals(40, LauncherHomeLayoutPreferences.homePageTopPaddingDp(isEditing = false))
        assertEquals(78, LauncherHomeLayoutPreferences.homePageTopPaddingDp(isEditing = true))
    }
}

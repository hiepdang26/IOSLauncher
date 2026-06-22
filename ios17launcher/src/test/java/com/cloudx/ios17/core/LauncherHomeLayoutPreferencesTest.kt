package com.cloudx.ios17.core

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherHomeLayoutPreferencesTest {

    @Test
    fun resolve_defaultsToSixByFourGrid() {
        val settings = LauncherHomeLayoutPreferences.resolve(iconSizeDp = 64, rows = 99)

        assertEquals(6, settings.rows)
        assertEquals(4, settings.columns)
        assertEquals(24, settings.maxAppsPerPage)
    }

    @Test
    fun resolve_acceptsFiveByFourGrid() {
        val settings = LauncherHomeLayoutPreferences.resolve(iconSizeDp = 64, rows = 5)

        assertEquals(5, settings.rows)
        assertEquals(20, settings.maxAppsPerPage)
    }

    @Test
    fun resolve_coercesIconSliderRange() {
        assertEquals(52, LauncherHomeLayoutPreferences.resolve(iconSizeDp = 1, rows = 6).iconSizeDp)
        assertEquals(78, LauncherHomeLayoutPreferences.resolve(iconSizeDp = 200, rows = 6).iconSizeDp)
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
        assertEquals(8, LauncherHomeLayoutPreferences.homePageTopPaddingDp(isEditing = false))
        assertEquals(78, LauncherHomeLayoutPreferences.homePageTopPaddingDp(isEditing = true))
    }
}

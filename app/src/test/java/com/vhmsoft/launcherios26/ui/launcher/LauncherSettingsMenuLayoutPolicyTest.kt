package com.vhmsoft.launcherios26.ui.launcher

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherSettingsMenuLayoutPolicyTest {
    @Test
    fun settingsRows_areMoreCompactLikeReferenceLauncher() {
        assertEquals(54, LauncherSettingsMenuLayoutPolicy.ROW_HEIGHT_DP)
        assertEquals(30, LauncherSettingsMenuLayoutPolicy.ICON_CONTAINER_SIZE_DP)
        assertEquals(22, LauncherSettingsMenuLayoutPolicy.ICON_SIZE_DP)
        assertEquals(15f, LauncherSettingsMenuLayoutPolicy.TITLE_TEXT_SIZE_SP)
        assertFalse(LauncherSettingsMenuLayoutPolicy.TITLE_BOLD)
    }

    @Test
    fun settingsCards_useTighterReferenceSpacing() {
        assertEquals(198, LauncherSettingsMenuLayoutPolicy.HEADER_HEIGHT_DP)
        assertEquals(14, LauncherSettingsMenuLayoutPolicy.CONTENT_HORIZONTAL_PADDING_DP)
        assertEquals(24, LauncherSettingsMenuLayoutPolicy.SCROLL_TOP_PADDING_DP)
        assertEquals(26, LauncherSettingsMenuLayoutPolicy.CARD_VERTICAL_GAP_DP)
        assertEquals(8, LauncherSettingsMenuLayoutPolicy.CARD_RADIUS_DP)
    }

    @Test
    fun featuredStar_floatsOverSettingsCards() {
        assertTrue(LauncherSettingsMenuLayoutPolicy.SHOW_FEATURED_STAR)
        assertEquals(64, LauncherSettingsMenuLayoutPolicy.FEATURED_STAR_SIZE_DP)
        assertEquals(32, LauncherSettingsMenuLayoutPolicy.FEATURED_STAR_ICON_SIZE_DP)
        assertEquals(164, LauncherSettingsMenuLayoutPolicy.FEATURED_STAR_TOP_MARGIN_DP)
        assertEquals(14, LauncherSettingsMenuLayoutPolicy.FEATURED_STAR_END_MARGIN_DP)
    }
}

package com.vhmsoft.launcherios26.ui.launcher

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherSettingsPageHeaderPolicyTest {
    @Test
    fun optionPageHeader_usesCompactToolbarWithoutExtraTopGap() {
        assertEquals(56, LauncherSettingsPageHeaderPolicy.toolbarRowHeightDp)
        assertEquals(
            LauncherSettingsPageHeaderPolicy.toolbarRowHeightDp,
            LauncherSettingsPageHeaderPolicy.toolbarHeightDp
        )
        assertTrue(LauncherSettingsPageHeaderPolicy.contentTopSpacerDp <= 8)
    }

    @Test
    fun optionPageHeader_colorsStatusBarWithToolbarSoItLooksConnectedToNotifications() {
        assertTrue(LauncherSettingsPageHeaderPolicy.usesToolbarColorForStatusBar)
    }
}

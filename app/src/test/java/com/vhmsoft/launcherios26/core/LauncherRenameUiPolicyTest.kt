package com.vhmsoft.launcherios26.core

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherRenameUiPolicyTest {
    @Test
    fun renamePage_usesIosSettingsListMetrics() {
        assertEquals(112, LauncherRenameUiPolicy.TOOLBAR_HEIGHT_DP)
        assertEquals(82, LauncherRenameUiPolicy.LIST_ROW_HEIGHT_DP)
        assertEquals(58, LauncherRenameUiPolicy.LIST_ICON_SIZE_DP)
        assertEquals(32, LauncherRenameUiPolicy.LIST_START_PADDING_DP)
    }

    @Test
    fun renameDialog_usesLargeRoundedCardWithPinkActions() {
        assertTrue(LauncherRenameUiPolicy.DIALOG_WIDTH_PERCENT in 0.80f..0.90f)
        assertEquals(28, LauncherRenameUiPolicy.DIALOG_CORNER_RADIUS_DP)
        assertEquals(112, LauncherRenameUiPolicy.DIALOG_INPUT_HEIGHT_DP)
        assertEquals(0xFFFF2D55.toInt(), LauncherRenameUiPolicy.DIALOG_ACTION_COLOR)
    }
}

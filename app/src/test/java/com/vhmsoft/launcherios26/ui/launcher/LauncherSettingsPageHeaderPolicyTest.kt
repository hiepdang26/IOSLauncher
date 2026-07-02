package com.vhmsoft.launcherios26.ui.launcher

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherSettingsPageHeaderPolicyTest {
    @Test
    fun optionPages_shareOneIosHeaderStyle() {
        assertTrue(LauncherSettingsPageHeaderPolicy.usesSharedOptionPageHeader)
        assertEquals(112, LauncherSettingsPageHeaderPolicy.toolbarHeightDp)
        assertEquals(56, LauncherSettingsPageHeaderPolicy.toolbarRowHeightDp)
        assertEquals(10, LauncherSettingsPageHeaderPolicy.backStartMarginDp)
        assertEquals(22f, LauncherSettingsPageHeaderPolicy.backTextSizeSp)
        assertEquals(LauncherRenamePickerUiPolicy.backTextSizeSp, LauncherSettingsPageHeaderPolicy.backTextSizeSp)
        assertEquals(LauncherRenamePickerUiPolicy.titleTextSizeSp, LauncherSettingsPageHeaderPolicy.titleTextSizeSp)
        assertTrue(LauncherSettingsPageHeaderPolicy.titleIsBold)
    }
}

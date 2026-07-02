package com.vhmsoft.launcherios26.ui.launcher

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherRenamePickerUiPolicyTest {
    @Test
    fun renameMenu_opensFullscreenPickerInsteadOfDialogList() {
        assertTrue(LauncherRenamePickerUiPolicy.opensFullscreenPicker)
        assertFalse(LauncherRenamePickerUiPolicy.usesDialogList)
    }

    @Test
    fun renameMenu_opensPickerBeforeLoadingAppIcons() {
        assertTrue(LauncherRenamePickerUiPolicy.opensBeforeAppIconsLoad)
    }

    @Test
    fun renameMenu_loadsAppIconsOffMainThread() {
        assertTrue(LauncherRenamePickerUiPolicy.loadsAppIconsOffMainThread)
    }
}

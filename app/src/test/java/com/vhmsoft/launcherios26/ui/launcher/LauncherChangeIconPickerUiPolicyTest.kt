package com.vhmsoft.launcherios26.ui.launcher

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherChangeIconPickerUiPolicyTest {
    @Test
    fun changeIconMenu_opensFullscreenPickerInsteadOfDialogList() {
        assertTrue(LauncherChangeIconPickerUiPolicy.opensFullscreenPicker)
        assertFalse(LauncherChangeIconPickerUiPolicy.usesDialogList)
    }

    @Test
    fun changeIconMenu_opensPickerBeforeLoadingAppIcons() {
        assertTrue(LauncherChangeIconPickerUiPolicy.opensBeforeAppIconsLoad)
    }

    @Test
    fun changeIconMenu_loadsAppIconsOffMainThread() {
        assertTrue(LauncherChangeIconPickerUiPolicy.loadsAppIconsOffMainThread)
    }
}

package com.vhmsoft.launcherios26.ui.launcher

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherWallpaperPickerUiPolicyTest {
    @Test
    fun wallpaperMenu_opensFullscreenGridInsteadOfDialogList() {
        assertTrue(LauncherWallpaperPickerUiPolicy.opensFullscreenGrid)
        assertFalse(LauncherWallpaperPickerUiPolicy.usesDialogList)
        assertEquals(3, LauncherWallpaperPickerUiPolicy.gridColumns)
    }

    @Test
    fun wallpaperPicker_commitsOnlyAfterPreviewOk() {
        assertTrue(LauncherWallpaperPickerUiPolicy.opensPreviewBeforeCommit)
        assertTrue(LauncherWallpaperPickerUiPolicy.commitsOnPreviewOk)
    }
}

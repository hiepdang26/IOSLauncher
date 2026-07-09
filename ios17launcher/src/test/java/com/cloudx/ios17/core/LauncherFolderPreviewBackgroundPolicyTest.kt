package com.cloudx.ios17.core

import org.junit.Assert.assertFalse
import org.junit.Test

class LauncherFolderPreviewBackgroundPolicyTest {
    @Test
    fun shouldUseParentBlur_neverDrawsParentBlurBehindFolderTile() {
        assertFalse(
            LauncherFolderPreviewBackgroundPolicy.shouldUseParentBlur(
                liquidGlassEnabled = false,
                darkModeEnabled = false
            )
        )
        assertFalse(
            LauncherFolderPreviewBackgroundPolicy.shouldUseParentBlur(
                liquidGlassEnabled = true,
                darkModeEnabled = false
            )
        )
        assertFalse(
            LauncherFolderPreviewBackgroundPolicy.shouldUseParentBlur(
                liquidGlassEnabled = false,
                darkModeEnabled = true
            )
        )
    }
}

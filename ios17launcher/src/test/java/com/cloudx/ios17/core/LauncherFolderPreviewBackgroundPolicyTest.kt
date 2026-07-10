package com.cloudx.ios17.core

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherFolderPreviewBackgroundPolicyTest {
    @Test
    fun shouldUseParentBlur_onlyDrawsLightFolderBlurWhenFolderBlurIsEnabled() {
        assertTrue(
            LauncherFolderPreviewBackgroundPolicy.shouldUseParentBlur(
                liquidGlassEnabled = false,
                folderBlurEnabled = true,
                darkModeEnabled = false
            )
        )
        assertFalse(
            LauncherFolderPreviewBackgroundPolicy.shouldUseParentBlur(
                liquidGlassEnabled = false,
                folderBlurEnabled = false,
                darkModeEnabled = false
            )
        )
        assertFalse(
            LauncherFolderPreviewBackgroundPolicy.shouldUseParentBlur(
                liquidGlassEnabled = true,
                folderBlurEnabled = true,
                darkModeEnabled = false
            )
        )
        assertFalse(
            LauncherFolderPreviewBackgroundPolicy.shouldUseParentBlur(
                liquidGlassEnabled = false,
                folderBlurEnabled = true,
                darkModeEnabled = true
            )
        )
    }

    @Test
    fun shouldUseRealtimeLiquidGlass_ignoresFolderBlurAndDarkModeWhenLiquidGlassIsEnabled() {
        assertFalse(
            LauncherFolderPreviewBackgroundPolicy.shouldUseRealtimeLiquidGlass(
                liquidGlassEnabled = false,
                folderBlurEnabled = true,
                darkModeEnabled = false,
                sdkInt = LauncherRealtimeLiquidGlassPolicy.QMDEVE_MIN_SDK
            )
        )
        assertTrue(
            LauncherFolderPreviewBackgroundPolicy.shouldUseRealtimeLiquidGlass(
                liquidGlassEnabled = true,
                folderBlurEnabled = false,
                darkModeEnabled = false,
                sdkInt = LauncherRealtimeLiquidGlassPolicy.QMDEVE_MIN_SDK
            )
        )
        assertTrue(
            LauncherFolderPreviewBackgroundPolicy.shouldUseRealtimeLiquidGlass(
                liquidGlassEnabled = true,
                folderBlurEnabled = true,
                darkModeEnabled = true,
                sdkInt = LauncherRealtimeLiquidGlassPolicy.QMDEVE_MIN_SDK
            )
        )
        assertFalse(
            LauncherFolderPreviewBackgroundPolicy.shouldUseRealtimeLiquidGlass(
                liquidGlassEnabled = true,
                folderBlurEnabled = true,
                darkModeEnabled = false,
                sdkInt = LauncherRealtimeLiquidGlassPolicy.QMDEVE_MIN_SDK - 1
            )
        )
        assertTrue(
            LauncherFolderPreviewBackgroundPolicy.shouldUseRealtimeLiquidGlass(
                liquidGlassEnabled = true,
                folderBlurEnabled = true,
                darkModeEnabled = false,
                sdkInt = LauncherRealtimeLiquidGlassPolicy.QMDEVE_MIN_SDK
            )
        )
    }

    @Test
    fun bitmapBackgroundDrawsOnlyWhenRealtimeLiquidGlassIsInactive() {
        assertFalse(
            LauncherFolderPreviewBackgroundPolicy.shouldDrawBitmapBackground(
                realtimeLiquidGlassActive = true
            )
        )
        assertTrue(
            LauncherFolderPreviewBackgroundPolicy.shouldDrawBitmapBackground(
                realtimeLiquidGlassActive = false
            )
        )
    }
}

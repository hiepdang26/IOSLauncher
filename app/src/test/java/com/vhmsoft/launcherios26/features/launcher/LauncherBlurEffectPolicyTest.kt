package com.vhmsoft.launcherios26.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Test

class LauncherBlurEffectPolicyTest {
    @Test
    fun overlayAlpha_isOpaqueOnlyWhenMasterAndTargetAreEnabled() {
        assertEquals(1f, LauncherBlurEffectPolicy.overlayAlpha(true, true))
        assertEquals(0f, LauncherBlurEffectPolicy.overlayAlpha(false, true))
        assertEquals(0f, LauncherBlurEffectPolicy.overlayAlpha(true, false))
        assertEquals(0f, LauncherBlurEffectPolicy.overlayAlpha(true, true, darkModeEnabled = true))
        assertEquals(0f, LauncherBlurEffectPolicy.overlayAlpha(true, true, liquidGlassEnabled = true))
    }

    @Test
    fun folderOverlayAlpha_usesWallpaperBlurWhenLiquidGlassIsOn() {
        assertEquals(
            0f,
            LauncherBlurEffectPolicy.folderOverlayAlpha(
                masterEnabled = false,
                folderEnabled = false,
                liquidGlassEnabled = false,
                darkModeEnabled = false
            )
        )
        assertEquals(
            0f,
            LauncherBlurEffectPolicy.folderOverlayAlpha(
                masterEnabled = true,
                folderEnabled = false,
                liquidGlassEnabled = false,
                darkModeEnabled = false
            )
        )
        assertEquals(
            1f,
            LauncherBlurEffectPolicy.folderOverlayAlpha(
                masterEnabled = true,
                folderEnabled = true,
                liquidGlassEnabled = false,
                darkModeEnabled = false
            )
        )
        assertEquals(
            1f,
            LauncherBlurEffectPolicy.folderOverlayAlpha(
                masterEnabled = true,
                folderEnabled = true,
                liquidGlassEnabled = true,
                darkModeEnabled = false
            )
        )
        assertEquals(
            1f,
            LauncherBlurEffectPolicy.folderOverlayAlpha(
                masterEnabled = true,
                folderEnabled = true,
                liquidGlassEnabled = true,
                darkModeEnabled = true
            )
        )
    }

    @Test
    fun folderBackgroundContentAlpha_keepsBlurredHomeVisibleBehindOpenFolder() {
        assertEquals(
            0.45f,
            LauncherBlurEffectPolicy.folderBackgroundContentAlpha(
                masterEnabled = true,
                folderEnabled = true,
                liquidGlassEnabled = false,
                darkModeEnabled = false
            )
        )
        assertEquals(
            FolderOpenLayoutPolicy.LIQUID_GLASS_BACKGROUND_CONTENT_ALPHA,
            LauncherBlurEffectPolicy.folderBackgroundContentAlpha(
                masterEnabled = true,
                folderEnabled = true,
                liquidGlassEnabled = true,
                darkModeEnabled = false
            )
        )
        assertEquals(
            FolderOpenLayoutPolicy.LIQUID_GLASS_BACKGROUND_CONTENT_ALPHA,
            LauncherBlurEffectPolicy.folderBackgroundContentAlpha(
                masterEnabled = false,
                folderEnabled = false,
                liquidGlassEnabled = true,
                darkModeEnabled = true
            )
        )
    }

    @Test
    fun searchBackgroundContentAlpha_hidesHomeContentBehindSearch() {
        assertEquals(0f, LauncherBlurEffectPolicy.searchBackgroundContentAlpha(true, true))
        assertEquals(0f, LauncherBlurEffectPolicy.searchBackgroundContentAlpha(false, true))
        assertEquals(0f, LauncherBlurEffectPolicy.searchBackgroundContentAlpha(true, false))
    }

    @Test
    fun searchTouchBlockerAlpha_darksBackgroundOnlyWhenSearchBlurIsEnabled() {
        assertEquals(
            LauncherBlurEffectPolicy.SEARCH_TOUCH_BLOCKER_ALPHA,
            LauncherBlurEffectPolicy.searchTouchBlockerAlpha(true, true)
        )
        assertEquals(0f, LauncherBlurEffectPolicy.searchTouchBlockerAlpha(false, true))
        assertEquals(0f, LauncherBlurEffectPolicy.searchTouchBlockerAlpha(true, false))
        assertEquals(0f, LauncherBlurEffectPolicy.searchTouchBlockerAlpha(true, true, darkModeEnabled = true))
        assertEquals(0f, LauncherBlurEffectPolicy.searchTouchBlockerAlpha(true, true, liquidGlassEnabled = true))
    }

}

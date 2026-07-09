package com.cloudx.ios17.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Test

class LauncherBlurEffectPolicyTest {
    @Test
    fun overlayAlpha_isOpaqueOnlyWhenMasterAndTargetAreEnabled() {
        assertEquals(1f, LauncherBlurEffectPolicy.overlayAlpha(true, true))
        assertEquals(0f, LauncherBlurEffectPolicy.overlayAlpha(false, true))
        assertEquals(0f, LauncherBlurEffectPolicy.overlayAlpha(true, false))
    }

    @Test
    fun folderOverlayAlpha_isOpaqueWheneverFolderIsOpen() {
        assertEquals(
            1f,
            LauncherBlurEffectPolicy.folderOverlayAlpha(
                masterEnabled = false,
                folderEnabled = false,
                liquidGlassEnabled = false
            )
        )
        assertEquals(
            1f,
            LauncherBlurEffectPolicy.folderOverlayAlpha(
                masterEnabled = true,
                folderEnabled = false,
                liquidGlassEnabled = false
            )
        )
        assertEquals(
            1f,
            LauncherBlurEffectPolicy.folderOverlayAlpha(
                masterEnabled = false,
                folderEnabled = true,
                liquidGlassEnabled = false
            )
        )
        assertEquals(
            1f,
            LauncherBlurEffectPolicy.folderOverlayAlpha(
                masterEnabled = false,
                folderEnabled = false,
                liquidGlassEnabled = true
            )
        )
    }

    @Test
    fun folderBackgroundContentAlpha_keepsLightFolderBackdropReadable() {
        assertEquals(
            0.16f,
            LauncherBlurEffectPolicy.folderBackgroundContentAlpha(
                masterEnabled = false,
                folderEnabled = false,
                liquidGlassEnabled = false
            )
        )
        assertEquals(
            0.16f,
            LauncherBlurEffectPolicy.folderBackgroundContentAlpha(
                masterEnabled = true,
                folderEnabled = false,
                liquidGlassEnabled = false
            )
        )
        assertEquals(
            0.16f,
            LauncherBlurEffectPolicy.folderBackgroundContentAlpha(
                masterEnabled = false,
                folderEnabled = true,
                liquidGlassEnabled = false
            )
        )
        assertEquals(
            0.16f,
            LauncherBlurEffectPolicy.folderBackgroundContentAlpha(
                masterEnabled = false,
                folderEnabled = false,
                liquidGlassEnabled = true
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
    }
}

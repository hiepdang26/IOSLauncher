package com.vhmsoft.launcherios26.features.launcher

import com.vhmsoft.launcherios26.core.LauncherLiquidGlassStylePolicy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class LauncherLiquidGlassStylePolicyTest {

    @Test
    fun fallbackFolderPreviewKeepsExistingLightMaterial() {
        val folder = LauncherLiquidGlassStylePolicy.folderPreview(
            enabled = false,
            darkMode = false,
            liquidGlass = false
        )

        assertEquals(0x70EEF8FF, folder.color)
        assertEquals(13, folder.radiusDp)
        assertNull(folder.strokeColor)
    }

    @Test
    fun liquidGlassFlagNoLongerReturnsOldSampleMaterial() {
        val fallback = LauncherLiquidGlassStylePolicy.folderPreview(
            enabled = true,
            darkMode = false,
            liquidGlass = false
        )
        val liquidRequested = LauncherLiquidGlassStylePolicy.folderPreview(
            enabled = true,
            darkMode = false,
            liquidGlass = true
        )

        assertEquals(fallback, liquidRequested)
    }

    @Test
    fun liquidGlassDockNoLongerUsesTransparentOldDockGradient() {
        val fallback = LauncherLiquidGlassStylePolicy.dockGradient(
            enabled = true,
            darkMode = false,
            liquidGlass = false
        )
        val liquidRequested = LauncherLiquidGlassStylePolicy.dockGradient(
            enabled = true,
            darkMode = false,
            liquidGlass = true
        )

        assertEquals(fallback.toList(), liquidRequested.toList())
    }

    @Test
    fun liquidGlassRemoveBadgeUsesRegularFallbackBadgeMaterial() {
        val fallback = LauncherLiquidGlassStylePolicy.removeBadge(
            enabled = false,
            darkMode = false,
            liquidGlass = false
        )
        val liquidRequested = LauncherLiquidGlassStylePolicy.removeBadge(
            enabled = true,
            darkMode = false,
            liquidGlass = true
        )

        assertEquals(fallback, liquidRequested)
    }

    @Test
    fun darkModeFallbackStillUsesDarkMaterial() {
        val search = LauncherLiquidGlassStylePolicy.searchPill(
            enabled = true,
            darkMode = true,
            liquidGlass = true
        )

        assertEquals(0xB01A242A.toInt(), search.color)
        assertEquals(22, search.radiusDp)
    }
}

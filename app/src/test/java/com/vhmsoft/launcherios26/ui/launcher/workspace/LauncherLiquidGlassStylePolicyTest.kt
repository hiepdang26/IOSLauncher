package com.vhmsoft.launcherios26.ui.launcher.workspace

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class LauncherLiquidGlassStylePolicyTest {

    @Test
    fun dockUsesFallbackMaterialEvenWhenEnabled() {
        val disabled = LauncherLiquidGlassStylePolicy.dock(enabled = false, darkMode = false)
        val enabled = LauncherLiquidGlassStylePolicy.dock(enabled = true, darkMode = false)

        assertEquals(disabled, enabled)
        assertEquals(0x4FD8F9FF, enabled.color)
        assertEquals(0x78FFFFFF, enabled.strokeColor)
        assertEquals(38, enabled.radiusDp)
    }

    @Test
    fun folderPreviewUsesFallbackMaterialEvenWhenEnabled() {
        val disabled = LauncherLiquidGlassStylePolicy.folderPreview(enabled = false, darkMode = false)
        val enabled = LauncherLiquidGlassStylePolicy.folderPreview(enabled = true, darkMode = false)

        assertEquals(disabled, enabled)
        assertEquals(0x705F6663, enabled.color)
        assertEquals(13, enabled.radiusDp)
        assertNull(enabled.strokeColor)
    }

    @Test
    fun folderPreviewRadiusTracksAppIconCornerRadius() {
        val compact = LauncherLiquidGlassStylePolicy.folderPreview(
            enabled = false,
            darkMode = false,
            iconSizeDp = 46
        )
        val large = LauncherLiquidGlassStylePolicy.folderPreview(
            enabled = false,
            darkMode = false,
            iconSizeDp = 70
        )

        assertEquals(10, compact.radiusDp)
        assertEquals(15, large.radiusDp)
    }

    @Test
    fun appLibraryFolderDoesNotUseOldSampleMaterialWhenEnabled() {
        val nonEmptyDisabled = LauncherLiquidGlassStylePolicy.appLibraryFolder(
            enabled = false,
            darkMode = false,
            empty = false
        )
        val nonEmptyEnabled = LauncherLiquidGlassStylePolicy.appLibraryFolder(
            enabled = true,
            darkMode = false,
            empty = false
        )
        val emptyEnabled = LauncherLiquidGlassStylePolicy.appLibraryFolder(
            enabled = true,
            darkMode = false,
            empty = true
        )

        assertEquals(nonEmptyDisabled, nonEmptyEnabled)
        assertEquals(0x705F6663, nonEmptyEnabled.color)
        assertEquals(0x365F6663, emptyEnabled.color)
    }

    @Test
    fun removeBadgeUsesRegularFallbackMaterialWhenEnabled() {
        val disabled = LauncherLiquidGlassStylePolicy.removeBadge(enabled = false, darkMode = false)
        val enabled = LauncherLiquidGlassStylePolicy.removeBadge(enabled = true, darkMode = false)

        assertEquals(disabled, enabled)
        assertEquals(0xC8FFFFFF.toInt(), enabled.color)
        assertEquals(0xA8FFFFFF.toInt(), enabled.strokeColor)
    }
}

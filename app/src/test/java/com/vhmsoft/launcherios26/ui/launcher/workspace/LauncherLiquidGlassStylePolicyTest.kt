package com.vhmsoft.launcherios26.ui.launcher.workspace

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherLiquidGlassStylePolicyTest {
    @Test
    fun dock_keepsLightPaletteWhenBlurIsDisabledInLightMode() {
        assertEquals(
            LauncherLiquidGlassStylePolicy.BackgroundStyle(
                color = 0x4FD8F9FF,
                radiusDp = 38,
                strokeColor = 0x78FFFFFF
            ),
            LauncherLiquidGlassStylePolicy.dock(enabled = false, darkMode = false)
        )
    }

    @Test
    fun dock_usesDarkPaletteOnlyWhenDarkModeIsEnabled() {
        assertEquals(
            LauncherLiquidGlassStylePolicy.BackgroundStyle(
                color = 0x8A182A36.toInt(),
                radiusDp = 38,
                strokeColor = 0x72FFFFFF
            ),
            LauncherLiquidGlassStylePolicy.dock(enabled = true, darkMode = true)
        )
        assertEquals(
            LauncherLiquidGlassStylePolicy.BackgroundStyle(
                color = 0x78404D5C,
                radiusDp = 38,
                strokeColor = 0x55FFFFFF
            ),
            LauncherLiquidGlassStylePolicy.dock(enabled = false, darkMode = true)
        )
    }

    @Test
    fun dock_usesGlassTintAndBrightStrokeWhenEnabled() {
        val disabled = LauncherLiquidGlassStylePolicy.dock(enabled = false, darkMode = false)
        val enabled = LauncherLiquidGlassStylePolicy.dock(enabled = true, darkMode = false)

        assertNotEquals(disabled.color, enabled.color)
        assertTrue(enabled.color > disabled.color)
        assertEquals(0xC8FFFFFF.toInt(), enabled.strokeColor)
        assertEquals(38, enabled.radiusDp)
    }

    @Test
    fun folderPreview_preservesCurrentBackgroundWhenDisabled() {
        assertEquals(0x705F6663, LauncherLiquidGlassStylePolicy.folderPreview(false, false).color)
        assertEquals(0x5A42484B, LauncherLiquidGlassStylePolicy.folderPreview(false, true).color)
        assertNull(LauncherLiquidGlassStylePolicy.folderPreview(false, false).strokeColor)
    }

    @Test
    fun searchField_preservesCurrentBackgroundWhenDisabled() {
        assertEquals(0x8AFFFFFF.toInt(), LauncherLiquidGlassStylePolicy.searchField(false, false).color)
        assertEquals(0x72FFFFFF, LauncherLiquidGlassStylePolicy.searchField(false, true).color)
        assertNull(LauncherLiquidGlassStylePolicy.searchField(false, false).strokeColor)
    }

    @Test
    fun appLibraryFolder_preservesCurrentBackgroundWhenDisabled() {
        assertEquals(
            0x705F6663,
            LauncherLiquidGlassStylePolicy.appLibraryFolder(
                enabled = false,
                darkMode = false,
                empty = false
            ).color
        )
        assertEquals(
            0x365F6663,
            LauncherLiquidGlassStylePolicy.appLibraryFolder(
                enabled = false,
                darkMode = false,
                empty = true
            ).color
        )
        assertEquals(
            0x5A42484B,
            LauncherLiquidGlassStylePolicy.appLibraryFolder(
                enabled = false,
                darkMode = true,
                empty = false
            ).color
        )
    }

    @Test
    fun appLibraryFolder_usesGlassForEmptyAndNonEmptyCardsWhenEnabled() {
        val nonEmpty = LauncherLiquidGlassStylePolicy.appLibraryFolder(
            enabled = true,
            darkMode = false,
            empty = false
        )
        val empty = LauncherLiquidGlassStylePolicy.appLibraryFolder(
            enabled = true,
            darkMode = false,
            empty = true
        )

        assertEquals(0xB8FFFFFF.toInt(), nonEmpty.strokeColor)
        assertEquals(0xB8FFFFFF.toInt(), empty.strokeColor)
        assertTrue(empty.color < nonEmpty.color)
    }
}

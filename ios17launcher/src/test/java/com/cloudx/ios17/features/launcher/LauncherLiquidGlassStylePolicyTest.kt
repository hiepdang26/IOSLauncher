package com.cloudx.ios17.features.launcher

import com.cloudx.ios17.core.LauncherLiquidGlassStylePolicy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNull
import org.junit.Test

class LauncherLiquidGlassStylePolicyTest {
    @Test
    fun folderPreview_preservesCurrentColorWhenDisabled() {
        assertEquals(
            0x1A202020,
            LauncherLiquidGlassStylePolicy.folderPreview(enabled = false).color
        )
        assertNull(LauncherLiquidGlassStylePolicy.folderPreview(enabled = false).strokeColor)
    }

    @Test
    fun appLibraryFolder_preservesCurrentColorsWhenDisabled() {
        assertEquals(
            0x705F6663,
            LauncherLiquidGlassStylePolicy.appLibraryFolder(enabled = false, empty = false).color
        )
        assertEquals(
            0x365F6663,
            LauncherLiquidGlassStylePolicy.appLibraryFolder(enabled = false, empty = true).color
        )
    }

    @Test
    fun searchPill_preservesCurrentColorWhenDisabled() {
        assertEquals(
            AppLibraryAppearancePolicy.SEARCH_PILL_COLOR,
            LauncherLiquidGlassStylePolicy.searchPill(enabled = false).color
        )
        assertNull(LauncherLiquidGlassStylePolicy.searchPill(enabled = false).strokeColor)
    }

    @Test
    fun liquidGlassStylesUseVisibleTintAndStrokeWhenEnabled() {
        val folderPreview = LauncherLiquidGlassStylePolicy.folderPreview(enabled = true)
        val searchPill = LauncherLiquidGlassStylePolicy.searchPill(enabled = true)
        val folderPanel = LauncherLiquidGlassStylePolicy.folderPanel(enabled = true)

        assertNotEquals(0x1A202020, folderPreview.color)
        assertEquals(0xB8FFFFFF.toInt(), folderPreview.strokeColor)
        assertEquals(0xC8FFFFFF.toInt(), searchPill.strokeColor)
        assertEquals(0xC8FFFFFF.toInt(), folderPanel.strokeColor)
    }
}

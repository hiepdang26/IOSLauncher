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
    fun liquidGlassStylesUseSoftGlassTintAndSubtleStrokeWhenEnabled() {
        val folderPreview = LauncherLiquidGlassStylePolicy.folderPreview(enabled = true)
        val searchPill = LauncherLiquidGlassStylePolicy.searchPill(enabled = true)
        val folderPanel = LauncherLiquidGlassStylePolicy.folderPanel(enabled = true)

        assertEquals(0x24FFFFFF, folderPreview.color)
        assertEquals(0x8CFFFFFF.toInt(), folderPreview.strokeColor)
        assertEquals(0x4DFFFFFF, folderPreview.topHighlightColor)
        assertEquals(0x18001F35, folderPreview.bottomShadeColor)
        assertEquals(0x20FFFFFF, searchPill.color)
        assertEquals(0x82FFFFFF.toInt(), searchPill.strokeColor)
        assertEquals(0x44FFFFFF, searchPill.topHighlightColor)
        assertEquals(0x1600384A, searchPill.bottomShadeColor)
        assertEquals(0x22FFFFFF, folderPanel.color)
        assertEquals(0x90FFFFFF.toInt(), folderPanel.strokeColor)
        assertEquals(0x52FFFFFF, folderPanel.topHighlightColor)
        assertEquals(0x1C001C2E, folderPanel.bottomShadeColor)
    }

    @Test
    fun pageIndicator_usesLightGlassTintWhenDisabled() {
        val pageIndicator = LauncherLiquidGlassStylePolicy.pageIndicator(enabled = false)

        assertEquals(0x66D8F9FF, pageIndicator.color)
        assertNull(pageIndicator.strokeColor)
    }

    @Test
    fun liquidDockGradient_usesClearGlassStopsWithoutVisibleBorder() {
        val gradient = LauncherLiquidGlassStylePolicy.dockGradient(enabled = true)

        assertEquals(0x20FFFFFF, gradient[0])
        assertEquals(0x16D8F9FF, gradient[1])
        assertEquals(0x26FFFFFF, gradient[2])
    }

    @Test
    fun dockMaterial_usesLayeredLiquidGlassProfile() {
        val dock = LauncherLiquidGlassStylePolicy.dockMaterial(enabled = true)

        assertEquals(0x18FFFFFF, dock.color)
        assertEquals(0x76FFFFFF, dock.strokeColor)
        assertEquals(0x46FFFFFF, dock.topHighlightColor)
        assertEquals(0x1B004A6A, dock.bottomShadeColor)
        assertEquals(0x2FD8F9FF, dock.sideHighlightColor)
        assertEquals(0x24001E3A, dock.edgeShadeColor)
        assertEquals(38, dock.radiusDp)
    }

    @Test
    fun appLibraryFolder_usesSameSubtleGlassLanguageWhenEnabled() {
        val nonEmpty = LauncherLiquidGlassStylePolicy.appLibraryFolder(
            enabled = true,
            empty = false
        )
        val empty = LauncherLiquidGlassStylePolicy.appLibraryFolder(
            enabled = true,
            empty = true
        )

        assertEquals(0x26FFFFFF, nonEmpty.color)
        assertEquals(0x78FFFFFF, nonEmpty.strokeColor)
        assertEquals(0x16FFFFFF, empty.color)
        assertEquals(0x78FFFFFF, empty.strokeColor)
        assertEquals(0x4AFFFFFF, nonEmpty.topHighlightColor)
        assertEquals(0x18001F35, nonEmpty.bottomShadeColor)
    }

    @Test
    fun searchResultsPanel_usesLiquidGlassOnlyWhenEnabled() {
        val disabled = LauncherLiquidGlassStylePolicy.searchResultsPanel(enabled = false)
        val enabled = LauncherLiquidGlassStylePolicy.searchResultsPanel(enabled = true)

        assertEquals(0x86FFFFFF.toInt(), disabled.color)
        assertNull(disabled.strokeColor)
        assertEquals(0x24FFFFFF, enabled.color)
        assertEquals(0x78FFFFFF, enabled.strokeColor)
        assertEquals(0x44FFFFFF, enabled.topHighlightColor)
        assertEquals(0x1600384A, enabled.bottomShadeColor)
        assertEquals(16, enabled.radiusDp)
    }

    @Test
    fun darkModeStylesUseSmokyGlassColors() {
        assertEquals(
            0xB01A242A.toInt(),
            LauncherLiquidGlassStylePolicy.searchPill(enabled = false, darkMode = true).color
        )
        assertEquals(
            0xAA17242B.toInt(),
            LauncherLiquidGlassStylePolicy.folderPanel(enabled = false, darkMode = true).color
        )
        assertEquals(
            0xAA1D2A31.toInt(),
            LauncherLiquidGlassStylePolicy.appLibraryFolder(
                enabled = false,
                empty = false,
                darkMode = true
            ).color
        )
    }

    @Test
    fun darkDockGradientUsesDarkCenter() {
        val gradient = LauncherLiquidGlassStylePolicy.dockGradient(
            enabled = false,
            darkMode = true
        )

        assertEquals(0xE0182B33.toInt(), gradient[0])
        assertEquals(0xEA071825.toInt(), gradient[1])
        assertEquals(0xD6213138.toInt(), gradient[2])
    }
}

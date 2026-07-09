package com.cloudx.ios17.features.launcher

import com.cloudx.ios17.core.LauncherLiquidGlassStylePolicy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNull
import org.junit.Test

class LauncherLiquidGlassStylePolicyTest {
    @Test
    fun folderPreview_usesLightBlueTileWhenLiquidGlassDisabledInLightMode() {
        assertEquals(
            0xC06F88C9.toInt(),
            LauncherLiquidGlassStylePolicy.folderPreview(enabled = false).color
        )
        assertNull(LauncherLiquidGlassStylePolicy.folderPreview(enabled = false).strokeColor)
    }

    @Test
    fun appLibraryFolder_usesLightMilkyCardsWhenLiquidGlassDisabled() {
        assertEquals(
            0x70EEF8FF,
            LauncherLiquidGlassStylePolicy.appLibraryFolder(enabled = false, empty = false).color
        )
        assertEquals(
            0x50EEF8FF,
            LauncherLiquidGlassStylePolicy.appLibraryFolder(enabled = false, empty = true).color
        )
    }

    @Test
    fun searchPill_usesMilkyLightTintWhenLiquidGlassDisabledInLightMode() {
        val searchPill = LauncherLiquidGlassStylePolicy.searchPill(enabled = false)

        assertEquals(
            0x86E8FAFF.toInt(),
            searchPill.color
        )
        assertNull(searchPill.strokeColor)
    }

    @Test
    fun liquidGlassStylesUseSoftGlassTintAndSubtleStrokeWhenEnabled() {
        val folderPreview = LauncherLiquidGlassStylePolicy.folderPreview(enabled = true)
        val searchPill = LauncherLiquidGlassStylePolicy.searchPill(enabled = true)
        val folderPanel = LauncherLiquidGlassStylePolicy.folderPanel(enabled = true)

        assertEquals(0xB07088C0.toInt(), folderPreview.color)
        assertEquals(0x55FFFFFF, folderPreview.strokeColor)
        assertEquals(0x42FFFFFF, folderPreview.topHighlightColor)
        assertNull(folderPreview.bottomShadeColor)
        assertNull(folderPreview.edgeShadeColor)
        assertEquals(0x70DDF7FF, searchPill.color)
        assertEquals(0x78FFFFFF, searchPill.strokeColor)
        assertEquals(0x55FFFFFF, searchPill.topHighlightColor)
        assertEquals(0x12005098, searchPill.bottomShadeColor)
        assertEquals(0x72FFFFFF, folderPanel.color)
        assertEquals(0x58FFFFFF, folderPanel.strokeColor)
        assertEquals(0x40FFFFFF, folderPanel.topHighlightColor)
        assertEquals(0x10005098, folderPanel.bottomShadeColor)
        assertEquals(0x1EE5FBFF, folderPanel.sideHighlightColor)
        assertEquals(0x0E004A80, folderPanel.edgeShadeColor)
    }

    @Test
    fun folderPanel_usesMilkyBackgroundWhenLiquidGlassIsDisabledInLightMode() {
        val folderPanel = LauncherLiquidGlassStylePolicy.folderPanel(
            enabled = false,
            darkMode = false
        )

        assertEquals(0x86FFFFFF.toInt(), folderPanel.color)
        assertEquals(42, folderPanel.radiusDp)
        assertNull(folderPanel.strokeColor)
        assertNull(folderPanel.topHighlightColor)
        assertNull(folderPanel.bottomShadeColor)
        assertNull(folderPanel.sideHighlightColor)
        assertNull(folderPanel.edgeShadeColor)
    }

    @Test
    fun folderBackdropOverlay_doesNotPaintFullScreenFolderUnderlay() {
        assertEquals(
            0x00000000,
            LauncherLiquidGlassStylePolicy.folderBackdropOverlay(darkMode = false)
        )
        assertEquals(
            0x00000000,
            LauncherLiquidGlassStylePolicy.folderBackdropOverlay(darkMode = true)
        )
    }

    @Test
    fun pageIndicator_usesLightGlassTintWhenDisabled() {
        val pageIndicator = LauncherLiquidGlassStylePolicy.pageIndicator(enabled = false)

        assertEquals(0x78D8F9FF, pageIndicator.color)
        assertNull(pageIndicator.strokeColor)
    }

    @Test
    fun dockGradient_usesBrightBlueStopsWhenBlurIsEnabledInLightMode() {
        val gradient = LauncherLiquidGlassStylePolicy.dockGradient(
            enabled = true,
            darkMode = false,
            liquidGlass = false
        )

        assertEquals(0x70E7FBFF, gradient[0])
        assertEquals(0x62BDEEFF, gradient[1])
        assertEquals(0x703A86E8, gradient[2])
    }

    @Test
    fun dockGradient_keepsLightPaletteWhenBlurIsDisabledInLightMode() {
        val gradient = LauncherLiquidGlassStylePolicy.dockGradient(
            enabled = false,
            darkMode = false
        )

        assertEquals(0x46E7FBFF, gradient[0])
        assertEquals(0x3CBDEEFF, gradient[1])
        assertEquals(0x463A86E8, gradient[2])
    }

    @Test
    fun dockMaterial_usesLayeredLiquidGlassProfile() {
        val dock = LauncherLiquidGlassStylePolicy.dockMaterial(
            enabled = true,
            liquidGlass = true
        )

        assertEquals(0x327EDBFF, dock.color)
        assertEquals(0x72CFFBFF, dock.strokeColor)
        assertEquals(0x55E8FFFF, dock.topHighlightColor)
        assertEquals(0x66124FCE, dock.bottomShadeColor)
        assertEquals(0x70E8FFFF, dock.sideHighlightColor)
        assertEquals(0x38105BB6, dock.edgeShadeColor)
        assertEquals(38, dock.radiusDp)
    }

    @Test
    fun dockMaterial_keepsLightPaletteWhenBlurIsDisabledInLightMode() {
        val dock = LauncherLiquidGlassStylePolicy.dockMaterial(
            enabled = false,
            darkMode = false
        )

        assertEquals(0x40A9E8FF, dock.color)
        assertEquals(0x40FFFFFF, dock.strokeColor)
        assertEquals(0x30FFFFFF, dock.topHighlightColor)
        assertEquals(0x1A0064C8, dock.bottomShadeColor)
        assertEquals(0x28D8F9FF, dock.sideHighlightColor)
        assertEquals(0x10004A99, dock.edgeShadeColor)
        assertEquals(38, dock.radiusDp)
    }

    @Test
    fun enabledLiquidGlassUsesSamplePaletteInDarkAndLightModes() {
        assertEquals(
            LauncherLiquidGlassStylePolicy.folderPanel(enabled = true, darkMode = false),
            LauncherLiquidGlassStylePolicy.folderPanel(enabled = true, darkMode = true)
        )
        assertEquals(
            LauncherLiquidGlassStylePolicy.folderPreview(enabled = true, darkMode = false),
            LauncherLiquidGlassStylePolicy.folderPreview(enabled = true, darkMode = true)
        )
        assertEquals(
            LauncherLiquidGlassStylePolicy.searchPill(enabled = true, darkMode = false),
            LauncherLiquidGlassStylePolicy.searchPill(enabled = true, darkMode = true)
        )
        assertEquals(
            LauncherLiquidGlassStylePolicy.dockMaterial(
                enabled = true,
                darkMode = false,
                liquidGlass = true
            ),
            LauncherLiquidGlassStylePolicy.dockMaterial(
                enabled = true,
                darkMode = true,
                liquidGlass = true
            )
        )
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

        assertEquals(0xB8EEF8FF.toInt(), disabled.color)
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
        assertEquals(
            0xA0182630.toInt(),
            LauncherLiquidGlassStylePolicy.folderPreview(enabled = false, darkMode = true).color
        )
        assertEquals(
            0xB01A242A.toInt(),
            LauncherLiquidGlassStylePolicy.pageIndicator(enabled = false, darkMode = true).color
        )
        assertEquals(
            0xAA1D2A31.toInt(),
            LauncherLiquidGlassStylePolicy.searchResultsPanel(enabled = false, darkMode = true).color
        )
    }

    @Test
    fun darkDockGradientUsesDarkCenter() {
        val gradient = LauncherLiquidGlassStylePolicy.dockGradient(
            enabled = true,
            darkMode = true,
            liquidGlass = false
        )

        assertEquals(0xE0182B33.toInt(), gradient[0])
        assertEquals(0xEA071825.toInt(), gradient[1])
        assertEquals(0xD6213138.toInt(), gradient[2])
    }

    @Test
    fun darkDockMaterialUsesSmokyPaletteWhenLiquidGlassIsDisabled() {
        val dock = LauncherLiquidGlassStylePolicy.dockMaterial(
            enabled = true,
            darkMode = true,
            liquidGlass = false
        )

        assertEquals(0x9A14242C.toInt(), dock.color)
        assertEquals(0x52FFFFFF, dock.strokeColor)
        assertEquals(0x20FFFFFF, dock.topHighlightColor)
        assertEquals(0x56000B16, dock.bottomShadeColor)
        assertEquals(0x1800B8D9, dock.sideHighlightColor)
        assertEquals(0x3600030A, dock.edgeShadeColor)
    }
}

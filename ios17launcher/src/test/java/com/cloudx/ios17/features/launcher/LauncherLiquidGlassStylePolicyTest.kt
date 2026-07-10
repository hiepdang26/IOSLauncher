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
        val appLibrary = LauncherLiquidGlassStylePolicy.appLibraryFolder(enabled = true, empty = false)
        val searchPill = LauncherLiquidGlassStylePolicy.searchPill(enabled = true)
        val pageIndicator = LauncherLiquidGlassStylePolicy.pageIndicator(enabled = true)

        listOf(searchPill, pageIndicator).forEach { style ->
            assertEquals(appLibrary.color, style.color)
            assertEquals(appLibrary.strokeColor, style.strokeColor)
            assertEquals(appLibrary.topHighlightColor, style.topHighlightColor)
            assertEquals(appLibrary.bottomShadeColor, style.bottomShadeColor)
            assertEquals(appLibrary.sideHighlightColor, style.sideHighlightColor)
            assertEquals(appLibrary.edgeShadeColor, style.edgeShadeColor)
        }
        assertEquals(22, searchPill.radiusDp)
        assertEquals(17, pageIndicator.radiusDp)
    }

    @Test
    fun folderPreview_usesDimmerBlueGlassWhenBlurIsEnabled() {
        val folderPreview = LauncherLiquidGlassStylePolicy.folderPreview(enabled = true)

        assertEquals(0x786F88C9, folderPreview.color)
        assertNull(folderPreview.strokeColor)
        assertEquals(0x2AFFFFFF, folderPreview.topHighlightColor)
        assertEquals(0x16001224, folderPreview.bottomShadeColor)
        assertEquals(0x20D8F9FF, folderPreview.sideHighlightColor)
        assertEquals(0x18004A99, folderPreview.edgeShadeColor)
        assertEquals(13, folderPreview.radiusDp)
    }

    @Test
    fun folderPanel_usesMintFolderGlassWhenBlurIsEnabled() {
        val folderPanel = LauncherLiquidGlassStylePolicy.folderPanel(enabled = true)

        assertEquals(0x5EEFFFF8, folderPanel.color)
        assertNull(folderPanel.strokeColor)
        assertEquals(0x50FFFFFF, folderPanel.topHighlightColor)
        assertEquals(0x08FFFFFF, folderPanel.bottomShadeColor)
        assertEquals(0x38FFFFFF, folderPanel.sideHighlightColor)
        assertEquals(0x08CFFCEF, folderPanel.edgeShadeColor)
        assertEquals(42, folderPanel.radiusDp)
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
    fun dockGradient_usesMintFolderTintWhenBlurIsEnabledInLightMode() {
        val gradient = LauncherLiquidGlassStylePolicy.dockGradient(
            enabled = true,
            darkMode = false,
            liquidGlass = false
        )

        assertEquals(0x78FFFFFF, gradient[0])
        assertEquals(0x6CEFFFF8, gradient[1])
        assertEquals(0x5EE6FFF5, gradient[2])
    }

    @Test
    fun dockGradient_usesSameLightPaletteWithLowerAlphaWhenBlurIsDisabled() {
        val gradient = LauncherLiquidGlassStylePolicy.dockGradient(
            enabled = false,
            darkMode = false
        )

        assertEquals(0x26FFFFFF, gradient[0])
        assertEquals(0x22EFFFF8, gradient[1])
        assertEquals(0x1EE6FFF5, gradient[2])
    }

    @Test
    fun dockMaterial_usesOriginalLiquidGlassProfileWhenLiquidGlassIsEnabled() {
        val dock = LauncherLiquidGlassStylePolicy.dockMaterial(
            enabled = true,
            liquidGlass = true
        )

        assertEquals(0x327EDBFF, dock.color)
        assertNull(dock.strokeColor)
        assertEquals(0x55E8FFFF, dock.topHighlightColor)
        assertEquals(0x66124FCE, dock.bottomShadeColor)
        assertEquals(0x70E8FFFF, dock.sideHighlightColor)
        assertEquals(0x38105BB6, dock.edgeShadeColor)
        assertEquals(38, dock.radiusDp)
    }

    @Test
    fun liquidGlassSurfacesKeepTheirOriginalPaletteWithoutWhiteBorder() {
        val folderPreview = LauncherLiquidGlassStylePolicy.folderPreview(
            enabled = true,
            liquidGlass = true
        )
        val folderPanel = LauncherLiquidGlassStylePolicy.folderPanel(
            enabled = true,
            liquidGlass = true
        )
        val searchPill = LauncherLiquidGlassStylePolicy.searchPill(
            enabled = true,
            liquidGlass = true
        )
        val searchResults = LauncherLiquidGlassStylePolicy.searchResultsPanel(
            enabled = true,
            liquidGlass = true
        )
        val appLibrary = LauncherLiquidGlassStylePolicy.appLibraryFolder(
            enabled = true,
            empty = false,
            liquidGlass = true
        )
        val pageIndicator = LauncherLiquidGlassStylePolicy.pageIndicator(
            enabled = true,
            liquidGlass = true
        )

        assertEquals(0x76566FA8, folderPreview.color)
        assertNull(folderPreview.strokeColor)
        assertEquals(0x72FFFFFF, folderPanel.color)
        assertNull(folderPanel.strokeColor)
        assertEquals(0x70DDF7FF, searchPill.color)
        assertNull(searchPill.strokeColor)
        assertEquals(0x24FFFFFF, searchResults.color)
        assertNull(searchResults.strokeColor)
        assertEquals(0x26FFFFFF, appLibrary.color)
        assertNull(appLibrary.strokeColor)
        assertEquals(0x70485F63, pageIndicator.color)
        assertNull(pageIndicator.strokeColor)
    }

    @Test
    fun dockMaterial_usesTransparentLightPaletteWhenBlurIsDisabled() {
        val dock = LauncherLiquidGlassStylePolicy.dockMaterial(
            enabled = false,
            darkMode = false
        )

        assertEquals(0x24EFFFF8, dock.color)
        assertEquals(0x12FFFFFF, dock.strokeColor)
        assertEquals(0x18FFFFFF, dock.topHighlightColor)
        assertEquals(0x02FFFFFF, dock.bottomShadeColor)
        assertEquals(0x14FFFFFF, dock.sideHighlightColor)
        assertEquals(0x02CFFCEF, dock.edgeShadeColor)
        assertEquals(38, dock.radiusDp)
    }

    @Test
    fun darkModeTakesPrecedenceOverEnabledLightBlurStyles() {
        assertEquals(
            LauncherLiquidGlassStylePolicy.folderPanel(enabled = false, darkMode = true),
            LauncherLiquidGlassStylePolicy.folderPanel(enabled = true, darkMode = true)
        )
        assertEquals(
            LauncherLiquidGlassStylePolicy.folderPreview(enabled = false, darkMode = true),
            LauncherLiquidGlassStylePolicy.folderPreview(enabled = true, darkMode = true)
        )
        assertEquals(
            LauncherLiquidGlassStylePolicy.searchPill(enabled = false, darkMode = true),
            LauncherLiquidGlassStylePolicy.searchPill(enabled = true, darkMode = true)
        )
        assertNotEquals(
            LauncherLiquidGlassStylePolicy.dockMaterial(
                enabled = false,
                darkMode = true,
                liquidGlass = false
            ).color,
            LauncherLiquidGlassStylePolicy.dockMaterial(
                enabled = true,
                darkMode = true,
                liquidGlass = false
            ).color
        )
    }

    @Test
    fun liquidGlassDockMaterialStaysSeparateFromDarkModePalette() {
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

        assertEquals(0x1EFFFFFF, nonEmpty.color)
        assertNull(nonEmpty.strokeColor)
        assertEquals(0x12FFFFFF, empty.color)
        assertNull(empty.strokeColor)
        assertEquals(0x34FFFFFF, nonEmpty.topHighlightColor)
        assertEquals(0x0E001F35, nonEmpty.bottomShadeColor)
    }

    @Test
    fun enabledLiquidGlassStylesDoNotDrawWhiteBorder() {
        val styles = listOf(
            LauncherLiquidGlassStylePolicy.folderPreview(enabled = true),
            LauncherLiquidGlassStylePolicy.folderPanel(enabled = true),
            LauncherLiquidGlassStylePolicy.searchPill(enabled = true),
            LauncherLiquidGlassStylePolicy.searchResultsPanel(enabled = true),
            LauncherLiquidGlassStylePolicy.appLibraryFolder(enabled = true, empty = false),
            LauncherLiquidGlassStylePolicy.appLibraryFolder(enabled = true, empty = true),
            LauncherLiquidGlassStylePolicy.pageIndicator(enabled = true)
        )

        styles.forEach { style ->
            assertNull(style.strokeColor)
        }
    }

    @Test
    fun searchResultsPanel_usesLiquidGlassOnlyWhenEnabled() {
        val appLibrary = LauncherLiquidGlassStylePolicy.appLibraryFolder(enabled = true, empty = false)
        val disabled = LauncherLiquidGlassStylePolicy.searchResultsPanel(enabled = false)
        val enabled = LauncherLiquidGlassStylePolicy.searchResultsPanel(enabled = true)

        assertEquals(0xB8EEF8FF.toInt(), disabled.color)
        assertNull(disabled.strokeColor)
        assertEquals(appLibrary.color, enabled.color)
        assertEquals(appLibrary.strokeColor, enabled.strokeColor)
        assertEquals(appLibrary.topHighlightColor, enabled.topHighlightColor)
        assertEquals(appLibrary.bottomShadeColor, enabled.bottomShadeColor)
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

    @Test
    fun darkDockMaterial_changesWhenDockBlurIsDisabled() {
        val enabled = LauncherLiquidGlassStylePolicy.dockMaterial(
            enabled = true,
            darkMode = true,
            liquidGlass = false
        )
        val disabled = LauncherLiquidGlassStylePolicy.dockMaterial(
            enabled = false,
            darkMode = true,
            liquidGlass = false
        )

        assertNotEquals(enabled.color, disabled.color)
        assertEquals(0x5214242C, disabled.color)
        assertEquals(0x24FFFFFF, disabled.strokeColor)
    }

    @Test
    fun enabledLightDockMaterialIsClearerThanPreviousOpaqueBlueTint() {
        val dock = LauncherLiquidGlassStylePolicy.dockMaterial(
            enabled = true,
            darkMode = false,
            liquidGlass = false
        )

        assertEquals(0x68EFFFF8, dock.color)
        assertEquals(0x3AFFFFFF, dock.strokeColor)
        assertEquals(0x50FFFFFF, dock.topHighlightColor)
        assertEquals(0x08FFFFFF, dock.bottomShadeColor)
        assertEquals(0x38FFFFFF, dock.sideHighlightColor)
        assertEquals(0x08CFFCEF, dock.edgeShadeColor)
    }

    @Test
    fun dockMaterial_changesClearlyWhenDockBlurIsDisabledInLightMode() {
        val enabled = LauncherLiquidGlassStylePolicy.dockMaterial(
            enabled = true,
            darkMode = false,
            liquidGlass = true
        )
        val disabled = LauncherLiquidGlassStylePolicy.dockMaterial(
            enabled = false,
            darkMode = false,
            liquidGlass = true
        )

        assertNotEquals(enabled.color, disabled.color)
        assertEquals(0x327EDBFF, enabled.color)
        assertEquals(0x24EFFFF8, disabled.color)
    }

    @Test
    fun folderPreview_usesSmallerCornerRadiusSoTileCornersDoNotExposeDarkEdges() {
        assertEquals(13, LauncherLiquidGlassStylePolicy.folderPreview(enabled = true).radiusDp)
    }
}

package com.cloudx.ios17.features.launcher

import com.cloudx.ios17.core.LauncherLiquidGlassStylePolicy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNull
import org.junit.Test

class LauncherLiquidGlassStylePolicyTest {
    @Test
    fun folderPreview_usesSharedReducedWhiteFrameWhenBlurIsDisabledInLightMode() {
        assertEquals(
            0x70EEF8FF,
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
    fun searchField_ignoresBlurToggleWhenLiquidGlassIsDisabled() {
        assertEquals(
            LauncherLiquidGlassStylePolicy.searchField(enabled = false),
            LauncherLiquidGlassStylePolicy.searchField(enabled = true)
        )
    }

    @Test
    fun homeSearchIndicator_usesFolderPreviewMaterialWhenBlurIsToggled() {
        assertMatchesFolderPreviewMaterial(
            expected = LauncherLiquidGlassStylePolicy.folderPreview(enabled = true),
            actual = LauncherLiquidGlassStylePolicy.searchIndicator(enabled = true),
            radiusDp = 22
        )
        assertMatchesFolderPreviewMaterial(
            expected = LauncherLiquidGlassStylePolicy.folderPreview(enabled = false),
            actual = LauncherLiquidGlassStylePolicy.searchIndicator(enabled = false),
            radiusDp = 22
        )
    }

    @Test
    fun pageIndicator_usesFolderPreviewMaterialWhenSearchBlurIsToggled() {
        assertMatchesFolderPreviewMaterial(
            expected = LauncherLiquidGlassStylePolicy.folderPreview(enabled = true),
            actual = LauncherLiquidGlassStylePolicy.pageIndicator(enabled = true),
            radiusDp = 17
        )
        assertMatchesFolderPreviewMaterial(
            expected = LauncherLiquidGlassStylePolicy.folderPreview(enabled = false),
            actual = LauncherLiquidGlassStylePolicy.pageIndicator(enabled = false),
            radiusDp = 17
        )
    }

    @Test
    fun searchPillUsesSoftGlassTintAndSubtleStrokeWhenEnabled() {
        val appLibrary = LauncherLiquidGlassStylePolicy.appLibraryFolder(enabled = true, empty = false)
        val searchPill = LauncherLiquidGlassStylePolicy.searchPill(enabled = true)

        assertEquals(appLibrary.color, searchPill.color)
        assertEquals(appLibrary.strokeColor, searchPill.strokeColor)
        assertEquals(appLibrary.topHighlightColor, searchPill.topHighlightColor)
        assertEquals(appLibrary.bottomShadeColor, searchPill.bottomShadeColor)
        assertEquals(appLibrary.sideHighlightColor, searchPill.sideHighlightColor)
        assertEquals(appLibrary.edgeShadeColor, searchPill.edgeShadeColor)
        assertEquals(22, searchPill.radiusDp)
    }

    @Test
    fun folderPreview_usesCurrentDisabledFrameWhenBlurIsEnabled() {
        val folderPreview = LauncherLiquidGlassStylePolicy.folderPreview(enabled = true)

        assertEquals(0x84EEF8FF.toInt(), folderPreview.color)
        assertNull(folderPreview.strokeColor)
        assertNull(folderPreview.topHighlightColor)
        assertNull(folderPreview.bottomShadeColor)
        assertNull(folderPreview.sideHighlightColor)
        assertNull(folderPreview.edgeShadeColor)
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
    fun pageIndicator_usesFolderPreviewTintWhenDisabled() {
        val pageIndicator = LauncherLiquidGlassStylePolicy.pageIndicator(enabled = false)

        assertEquals(0x70EEF8FF, pageIndicator.color)
        assertNull(pageIndicator.strokeColor)
    }

    @Test
    fun dockGradient_usesCurrentDisabledFrameWhenBlurIsEnabledInLightMode() {
        val gradient = LauncherLiquidGlassStylePolicy.dockGradient(
            enabled = true,
            darkMode = false,
            liquidGlass = false
        )

        assertEquals(0x84EEF8FF.toInt(), gradient[0])
        assertEquals(0x84EEF8FF.toInt(), gradient[1])
        assertEquals(0x84EEF8FF.toInt(), gradient[2])
    }

    @Test
    fun dockGradient_usesReducedWhiteFrameWhenBlurIsDisabled() {
        val gradient = LauncherLiquidGlassStylePolicy.dockGradient(
            enabled = false,
            darkMode = false
        )

        assertEquals(0x70EEF8FF, gradient[0])
        assertEquals(0x70EEF8FF, gradient[1])
        assertEquals(0x70EEF8FF, gradient[2])
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
    fun liquidGlassSurfacesUsePurposeBuiltFolderPanelGlass() {
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
        val searchIndicator = LauncherLiquidGlassStylePolicy.searchIndicator(
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

        assertEquals(0x26FFFFFF, folderPreview.color)
        assertNull(folderPreview.strokeColor)
        assertEquals(0x42FFFFFF, folderPreview.topHighlightColor)
        assertEquals(0x18EEF8FF, folderPreview.bottomShadeColor)
        assertEquals(0x22FFFFFF, folderPreview.sideHighlightColor)
        assertEquals(0x18EEF8FF, folderPreview.edgeShadeColor)
        assertEquals(13, folderPreview.radiusDp)
        assertEquals(0x44FFFFFF, folderPanel.color)
        assertNull(folderPanel.strokeColor)
        assertEquals(0x70FFFFFF, folderPanel.topHighlightColor)
        assertEquals(0x16001F35, folderPanel.bottomShadeColor)
        assertEquals(0x20D8F9FF, folderPanel.sideHighlightColor)
        assertEquals(0x12001E3A, folderPanel.edgeShadeColor)
        assertEquals(0x70FFFFFF, folderPanel.diagonalCornerStrokeColor)
        assertEquals(42, folderPanel.radiusDp)
        assertEquals(0x70DDF7FF, searchPill.color)
        assertNull(searchPill.strokeColor)
        assertEquals(searchPill.color, searchIndicator.color)
        assertNull(searchIndicator.strokeColor)
        assertEquals(searchPill.topHighlightColor, searchIndicator.topHighlightColor)
        assertEquals(searchPill.bottomShadeColor, searchIndicator.bottomShadeColor)
        assertEquals(searchPill.sideHighlightColor, searchIndicator.sideHighlightColor)
        assertEquals(searchPill.edgeShadeColor, searchIndicator.edgeShadeColor)
        assertEquals(22, searchIndicator.radiusDp)
        assertEquals(0x24FFFFFF, searchResults.color)
        assertNull(searchResults.strokeColor)
        assertEquals(0x26FFFFFF, appLibrary.color)
        assertNull(appLibrary.strokeColor)
        assertEquals(searchPill.color, pageIndicator.color)
        assertNull(pageIndicator.strokeColor)
        assertEquals(searchPill.topHighlightColor, pageIndicator.topHighlightColor)
        assertEquals(searchPill.bottomShadeColor, pageIndicator.bottomShadeColor)
        assertEquals(searchPill.sideHighlightColor, pageIndicator.sideHighlightColor)
        assertEquals(searchPill.edgeShadeColor, pageIndicator.edgeShadeColor)
    }

    @Test
    fun liquidGlassFolderPreviewUsesFolderColoredEdgesInsteadOfDarkCornerShading() {
        val folderPreview = LauncherLiquidGlassStylePolicy.folderPreview(
            enabled = true,
            liquidGlass = true
        )

        assertEquals(0x26FFFFFF, folderPreview.color)
        assertNull(folderPreview.strokeColor)
        assertEquals(0x42FFFFFF, folderPreview.topHighlightColor)
        assertEquals(0x18EEF8FF, folderPreview.bottomShadeColor)
        assertEquals(0x22FFFFFF, folderPreview.sideHighlightColor)
        assertEquals(0x18EEF8FF, folderPreview.edgeShadeColor)
        assertEquals(13, folderPreview.radiusDp)
    }

    @Test
    fun dockMaterial_usesTransparentLightPaletteWhenBlurIsDisabled() {
        val dock = LauncherLiquidGlassStylePolicy.dockMaterial(
            enabled = false,
            darkMode = false
        )

        assertMatchesFolderPreviewMaterial(
            expected = LauncherLiquidGlassStylePolicy.folderPreview(enabled = false),
            actual = dock,
            radiusDp = 38
        )
    }

    @Test
    fun disabledLightFolderDockAndIndicatorsShareReducedWhiteFrame() {
        val folder = LauncherLiquidGlassStylePolicy.folderPreview(enabled = false)
        val searchIndicator = LauncherLiquidGlassStylePolicy.searchIndicator(enabled = false)
        val pageIndicator = LauncherLiquidGlassStylePolicy.pageIndicator(enabled = false)
        val dock = LauncherLiquidGlassStylePolicy.dockMaterial(enabled = false)

        assertEquals(0x70EEF8FF, folder.color)
        assertEquals(folder.color, searchIndicator.color)
        assertEquals(folder.color, pageIndicator.color)
        assertEquals(folder.color, dock.color)
        assertNull(folder.strokeColor)
        assertNull(searchIndicator.strokeColor)
        assertNull(pageIndicator.strokeColor)
        assertNull(dock.strokeColor)
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
            LauncherLiquidGlassStylePolicy.searchIndicator(enabled = true),
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
    fun enabledLightDockMaterialUsesCurrentDisabledFrame() {
        val dock = LauncherLiquidGlassStylePolicy.dockMaterial(
            enabled = true,
            darkMode = false,
            liquidGlass = false
        )

        assertEquals(0x84EEF8FF.toInt(), dock.color)
        assertNull(dock.strokeColor)
        assertNull(dock.topHighlightColor)
        assertNull(dock.bottomShadeColor)
        assertNull(dock.sideHighlightColor)
        assertNull(dock.edgeShadeColor)
        assertEquals(38, dock.radiusDp)
    }

    @Test
    fun enabledLightDockMaterialKeepsAppLibraryFolderFrameHue() {
        val dock = LauncherLiquidGlassStylePolicy.dockMaterial(
            enabled = true,
            darkMode = false,
            liquidGlass = false
        )
        val appLibraryFolder = LauncherLiquidGlassStylePolicy.appLibraryFolder(
            enabled = false,
            empty = false,
            darkMode = false,
            liquidGlass = false
        )

        assertEquals(appLibraryFolder.color and 0x00FFFFFF, dock.color and 0x00FFFFFF)
        assertEquals(appLibraryFolder.strokeColor, dock.strokeColor)
        assertEquals(appLibraryFolder.topHighlightColor, dock.topHighlightColor)
        assertEquals(appLibraryFolder.bottomShadeColor, dock.bottomShadeColor)
        assertEquals(appLibraryFolder.sideHighlightColor, dock.sideHighlightColor)
        assertEquals(appLibraryFolder.edgeShadeColor, dock.edgeShadeColor)
    }

    @Test
    fun liquidGlassStylesIgnoreBlurEnabledFlag() {
        assertEquals(
            LauncherLiquidGlassStylePolicy.folderPreview(
                enabled = true,
                liquidGlass = true
            ),
            LauncherLiquidGlassStylePolicy.folderPreview(
                enabled = false,
                liquidGlass = true
            )
        )
        assertEquals(
            LauncherLiquidGlassStylePolicy.folderPanel(
                enabled = true,
                liquidGlass = true
            ),
            LauncherLiquidGlassStylePolicy.folderPanel(
                enabled = false,
                liquidGlass = true
            )
        )
        assertEquals(
            LauncherLiquidGlassStylePolicy.searchPill(
                enabled = true,
                liquidGlass = true
            ),
            LauncherLiquidGlassStylePolicy.searchPill(
                enabled = false,
                liquidGlass = true
            )
        )
        assertEquals(
            LauncherLiquidGlassStylePolicy.searchIndicator(
                enabled = true,
                liquidGlass = true
            ),
            LauncherLiquidGlassStylePolicy.searchIndicator(
                enabled = false,
                liquidGlass = true
            )
        )
        assertEquals(
            LauncherLiquidGlassStylePolicy.appLibraryFolder(
                enabled = true,
                empty = false,
                liquidGlass = true
            ),
            LauncherLiquidGlassStylePolicy.appLibraryFolder(
                enabled = false,
                empty = false,
                liquidGlass = true
            )
        )
        assertEquals(
            LauncherLiquidGlassStylePolicy.pageIndicator(
                enabled = true,
                liquidGlass = true
            ),
            LauncherLiquidGlassStylePolicy.pageIndicator(
                enabled = false,
                liquidGlass = true
            )
        )
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

        assertEquals(enabled, disabled)
    }

    @Test
    fun folderPreview_usesSmallerCornerRadiusSoTileCornersDoNotExposeDarkEdges() {
        assertEquals(13, LauncherLiquidGlassStylePolicy.folderPreview(enabled = true).radiusDp)
    }

    private fun assertMatchesFolderPreviewMaterial(
        expected: LauncherLiquidGlassStylePolicy.BackgroundStyle,
        actual: LauncherLiquidGlassStylePolicy.BackgroundStyle,
        radiusDp: Int
    ) {
        assertEquals(expected.color, actual.color)
        assertEquals(expected.strokeColor, actual.strokeColor)
        assertEquals(expected.topHighlightColor, actual.topHighlightColor)
        assertEquals(expected.bottomShadeColor, actual.bottomShadeColor)
        assertEquals(expected.sideHighlightColor, actual.sideHighlightColor)
        assertEquals(expected.edgeShadeColor, actual.edgeShadeColor)
        assertEquals(radiusDp, actual.radiusDp)
    }
}

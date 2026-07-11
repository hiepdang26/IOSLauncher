package com.cloudx.ios17.core

object LauncherLiquidGlassStylePolicy {

    data class BackgroundStyle(
        val color: Int,
        val radiusDp: Int,
        val strokeColor: Int? = null,
        val strokeWidthDp: Int = 1,
        val topHighlightColor: Int? = null,
        val bottomShadeColor: Int? = null,
        val sideHighlightColor: Int? = null,
        val edgeShadeColor: Int? = null,
        val diagonalCornerStrokeColor: Int? = null,
        val diagonalCornerStrokeWidthDp: Int = 1
    )

    private fun libraryGlassMaterial(radiusDp: Int, empty: Boolean = false): BackgroundStyle =
        BackgroundStyle(
            color = if (empty) 0x12FFFFFF else 0x1EFFFFFF,
            radiusDp = radiusDp,
            strokeColor = null,
            topHighlightColor = 0x34FFFFFF,
            bottomShadeColor = 0x0E001F35,
            sideHighlightColor = 0x18D8F9FF,
            edgeShadeColor = 0x0C001E3A
        )

    private fun appLibraryLiquidGlassMaterial(radiusDp: Int, empty: Boolean = false): BackgroundStyle =
        BackgroundStyle(
            color = if (empty) 0x16FFFFFF else 0x26FFFFFF,
            radiusDp = radiusDp,
            strokeColor = null,
            topHighlightColor = 0x4AFFFFFF,
            bottomShadeColor = 0x18001F35,
            sideHighlightColor = 0x20D8F9FF,
            edgeShadeColor = 0x14001E3A
        )

    private fun folderPreviewLiquidGlassMaterial(radiusDp: Int): BackgroundStyle =
        BackgroundStyle(
            color = 0x26FFFFFF,
            radiusDp = radiusDp,
            strokeColor = null,
            topHighlightColor = 0x42FFFFFF,
            bottomShadeColor = 0x18EEF8FF,
            sideHighlightColor = 0x22FFFFFF,
            edgeShadeColor = 0x18EEF8FF
        )

    private fun folderPanelLiquidGlassMaterial(radiusDp: Int): BackgroundStyle =
        BackgroundStyle(
            color = 0x44FFFFFF,
            radiusDp = radiusDp,
            strokeColor = null,
            topHighlightColor = 0x70FFFFFF,
            bottomShadeColor = 0x16001F35,
            sideHighlightColor = 0x20D8F9FF,
            edgeShadeColor = 0x12001E3A,
            diagonalCornerStrokeColor = 0x70FFFFFF
        )

    private fun enabledLightFrameMaterial(radiusDp: Int): BackgroundStyle =
        BackgroundStyle(
            color = 0x84EEF8FF.toInt(),
            radiusDp = radiusDp,
            strokeColor = null
        )

    private fun disabledLightFrameMaterial(radiusDp: Int): BackgroundStyle =
        BackgroundStyle(
            color = 0x70EEF8FF,
            radiusDp = radiusDp,
            strokeColor = null
        )

    private fun brightHomeGlassMaterial(radiusDp: Int, color: Int): BackgroundStyle =
        BackgroundStyle(
            color = color,
            radiusDp = radiusDp,
            strokeColor = null,
            topHighlightColor = 0x50FFFFFF,
            bottomShadeColor = 0x08FFFFFF,
            sideHighlightColor = 0x38FFFFFF,
            edgeShadeColor = 0x08CFFCEF
        )

    fun folderPreview(
        enabled: Boolean,
        darkMode: Boolean = false,
        liquidGlass: Boolean = false
    ): BackgroundStyle {
        if (liquidGlass) {
            return folderPreviewLiquidGlassMaterial(radiusDp = 13)
        }
        if (darkMode) {
            return BackgroundStyle(
                color = 0xA0182630.toInt(),
                radiusDp = 13
            )
        }
        if (enabled) {
            return enabledLightFrameMaterial(radiusDp = 13)
        }
        return disabledLightFrameMaterial(radiusDp = 13)
    }

    fun folderPanel(
        enabled: Boolean,
        darkMode: Boolean = false,
        liquidGlass: Boolean = false
    ): BackgroundStyle {
        if (liquidGlass) {
            return folderPanelLiquidGlassMaterial(radiusDp = 42)
        }
        if (darkMode) {
            return BackgroundStyle(
                color = 0xAA17242B.toInt(),
                radiusDp = 42
            )
        }
        if (enabled) {
            return brightHomeGlassMaterial(radiusDp = 42, color = 0x5EEFFFF8)
        }
        return BackgroundStyle(
            color = 0x86FFFFFF.toInt(),
            radiusDp = 42
        )
    }

    fun folderBackdropOverlay(darkMode: Boolean = false): Int =
        0x00000000

    fun searchPill(
        enabled: Boolean,
        darkMode: Boolean = false,
        liquidGlass: Boolean = false
    ): BackgroundStyle {
        return if (liquidGlass) {
            BackgroundStyle(
                color = 0x70DDF7FF,
                radiusDp = 22,
                strokeColor = null,
                topHighlightColor = 0x55FFFFFF,
                bottomShadeColor = 0x12005098,
                sideHighlightColor = 0x2EE5FBFF,
                edgeShadeColor = 0x12004A99
            )
        } else if (darkMode) {
            BackgroundStyle(
                color = 0xB01A242A.toInt(),
                radiusDp = 22
            )
        } else if (enabled) {
            libraryGlassMaterial(radiusDp = 22)
        } else {
            BackgroundStyle(
                color = 0x86E8FAFF.toInt(),
                radiusDp = 22
            )
        }
    }

    fun searchField(
        enabled: Boolean,
        darkMode: Boolean = false,
        liquidGlass: Boolean = false
    ): BackgroundStyle =
        if (liquidGlass) {
            searchPill(enabled = true, liquidGlass = true)
        } else {
            searchPill(enabled = false, darkMode = darkMode)
        }

    fun searchIndicator(
        enabled: Boolean,
        darkMode: Boolean = false,
        liquidGlass: Boolean = false
    ): BackgroundStyle {
        if (liquidGlass) {
            return searchPill(enabled = true, liquidGlass = true)
        }
        if (darkMode) {
            return searchPill(enabled = enabled, darkMode = true)
        }
        return folderPreview(enabled = enabled).copy(radiusDp = 22)
    }

    fun searchResultsPanel(
        enabled: Boolean,
        darkMode: Boolean = false,
        liquidGlass: Boolean = false
    ): BackgroundStyle {
        if (liquidGlass) {
            return BackgroundStyle(
                color = 0x24FFFFFF,
                radiusDp = 16,
                strokeColor = null,
                topHighlightColor = 0x44FFFFFF,
                bottomShadeColor = 0x1600384A
            )
        }
        if (darkMode) {
            return BackgroundStyle(
                color = 0xAA1D2A31.toInt(),
                radiusDp = 16
            )
        }
        if (enabled) {
            return libraryGlassMaterial(radiusDp = 16)
        }
        return BackgroundStyle(
            color = 0xB8EEF8FF.toInt(),
            radiusDp = 12
        )
    }

    fun appLibraryFolder(
        enabled: Boolean,
        empty: Boolean,
        darkMode: Boolean = false,
        liquidGlass: Boolean = false
    ): BackgroundStyle {
        if (liquidGlass) {
            return appLibraryLiquidGlassMaterial(radiusDp = 20, empty = empty)
        }
        if (darkMode) {
            return BackgroundStyle(
                color = if (empty) 0x7A142630 else 0xAA1D2A31.toInt(),
                radiusDp = 20
            )
        }
        if (enabled) {
            return libraryGlassMaterial(radiusDp = 20, empty = empty)
        }
        return BackgroundStyle(
            color = if (empty) 0x50EEF8FF else 0x70EEF8FF,
            radiusDp = 20
        )
    }

    fun pageIndicator(
        enabled: Boolean,
        darkMode: Boolean = false,
        liquidGlass: Boolean = false
    ): BackgroundStyle {
        if (liquidGlass) {
            return searchPill(enabled = true, liquidGlass = true).copy(radiusDp = 17)
        }
        if (darkMode) {
            return BackgroundStyle(
                color = 0xB01A242A.toInt(),
                radiusDp = 17
            )
        }
        return folderPreview(enabled = enabled).copy(radiusDp = 17)
    }

    fun dockGradient(
        enabled: Boolean,
        darkMode: Boolean = false,
        liquidGlass: Boolean = false
    ): IntArray {
        if (liquidGlass) {
            return intArrayOf(
                0x70E7FBFF,
                0x62BDEEFF,
                0x703A86E8
            )
        }
        if (enabled && !darkMode) {
            val color = enabledLightFrameMaterial(radiusDp = 38).color
            return intArrayOf(color, color, color)
        }
        if (enabled && darkMode && !liquidGlass) {
            return intArrayOf(
                0xE0182B33.toInt(),
                0xEA071825.toInt(),
                0xD6213138.toInt()
            )
        }
        val color = disabledLightFrameMaterial(radiusDp = 38).color
        return intArrayOf(color, color, color)
    }

    fun dockMaterial(
        enabled: Boolean,
        darkMode: Boolean = false,
        liquidGlass: Boolean = false
    ): BackgroundStyle {
        if (liquidGlass) {
            return BackgroundStyle(
                color = 0x327EDBFF,
                radiusDp = 38,
                strokeColor = null,
                topHighlightColor = 0x55E8FFFF,
                bottomShadeColor = 0x66124FCE,
                sideHighlightColor = 0x70E8FFFF,
                edgeShadeColor = 0x38105BB6
            )
        }
        if (enabled && darkMode) {
            return BackgroundStyle(
                color = 0x9A14242C.toInt(),
                radiusDp = 38,
                strokeColor = 0x52FFFFFF,
                topHighlightColor = 0x20FFFFFF,
                bottomShadeColor = 0x56000B16,
                sideHighlightColor = 0x1800B8D9,
                edgeShadeColor = 0x3600030A
            )
        }
        if (darkMode) {
            return BackgroundStyle(
                color = 0x5214242C,
                radiusDp = 38,
                strokeColor = 0x24FFFFFF,
                topHighlightColor = 0x12FFFFFF,
                bottomShadeColor = 0x28000B16,
                sideHighlightColor = 0x0C00B8D9,
                edgeShadeColor = 0x1A00030A
            )
        }
        if (enabled) {
            return enabledLightFrameMaterial(radiusDp = 38)
        }
        return disabledLightFrameMaterial(radiusDp = 38)
    }
}

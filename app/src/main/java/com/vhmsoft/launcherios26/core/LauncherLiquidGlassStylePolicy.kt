package com.vhmsoft.launcherios26.core

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
        if (darkMode) {
            return BackgroundStyle(
                color = 0xA0182630.toInt(),
                radiusDp = 8
            )
        }
        if (enabled) {
            return enabledLightFrameMaterial(radiusDp = 8)
        }
        return disabledLightFrameMaterial(radiusDp = 8)
    }

    fun folderPanel(
        enabled: Boolean,
        darkMode: Boolean = false,
        liquidGlass: Boolean = false
    ): BackgroundStyle {
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
        return if (darkMode) {
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
        searchPill(enabled = enabled, darkMode = darkMode, liquidGlass = liquidGlass)

    fun searchIndicator(
        enabled: Boolean,
        darkMode: Boolean = false,
        liquidGlass: Boolean = false
    ): BackgroundStyle {
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

    fun removeBadge(
        enabled: Boolean,
        darkMode: Boolean = false,
        liquidGlass: Boolean = false
    ): BackgroundStyle {
        return BackgroundStyle(
            color = if (darkMode) 0xD8FFFFFF.toInt() else 0xC8FFFFFF.toInt(),
            radiusDp = 12,
            strokeColor = 0xA8FFFFFF.toInt()
        )
    }
}

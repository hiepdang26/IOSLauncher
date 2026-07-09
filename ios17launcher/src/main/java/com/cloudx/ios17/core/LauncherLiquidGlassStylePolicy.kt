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
        val edgeShadeColor: Int? = null
    )

    fun folderPreview(enabled: Boolean, darkMode: Boolean = false): BackgroundStyle {
        if (enabled) {
            return BackgroundStyle(
                color = 0xB07088C0.toInt(),
                radiusDp = 16,
                strokeColor = 0x55FFFFFF,
                topHighlightColor = 0x42FFFFFF
            )
        }
        if (darkMode) {
            return BackgroundStyle(
                color = 0xA0182630.toInt(),
                radiusDp = 16
            )
        }
        return BackgroundStyle(
            color = 0xC06F88C9.toInt(),
            radiusDp = 16
        )
    }

    fun folderPanel(enabled: Boolean, darkMode: Boolean = false): BackgroundStyle {
        if (enabled) {
            return BackgroundStyle(
                color = 0x72FFFFFF,
                radiusDp = 42,
                strokeColor = 0x58FFFFFF,
                topHighlightColor = 0x40FFFFFF,
                bottomShadeColor = 0x10005098,
                sideHighlightColor = 0x1EE5FBFF,
                edgeShadeColor = 0x0E004A80
            )
        }
        if (darkMode) {
            return BackgroundStyle(
                color = 0xAA17242B.toInt(),
                radiusDp = 42
            )
        }
        return BackgroundStyle(
            color = 0x86FFFFFF.toInt(),
            radiusDp = 42
        )
    }

    fun folderBackdropOverlay(darkMode: Boolean = false): Int =
        0x00000000

    fun searchPill(enabled: Boolean, darkMode: Boolean = false): BackgroundStyle {
        return if (enabled) {
            BackgroundStyle(
                color = 0x70DDF7FF,
                radiusDp = 22,
                strokeColor = 0x78FFFFFF,
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
        } else {
            BackgroundStyle(
                color = 0x86E8FAFF.toInt(),
                radiusDp = 22
            )
        }
    }

    fun searchField(enabled: Boolean, darkMode: Boolean = false): BackgroundStyle =
        searchPill(enabled, darkMode)

    fun searchResultsPanel(enabled: Boolean, darkMode: Boolean = false): BackgroundStyle {
        if (enabled) {
            return BackgroundStyle(
                color = 0x24FFFFFF,
                radiusDp = 16,
                strokeColor = 0x78FFFFFF,
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
        return BackgroundStyle(
            color = 0xB8EEF8FF.toInt(),
            radiusDp = 12
        )
    }

    fun appLibraryFolder(enabled: Boolean, empty: Boolean, darkMode: Boolean = false): BackgroundStyle {
        if (enabled) {
            return BackgroundStyle(
                color = if (empty) 0x16FFFFFF else 0x26FFFFFF,
                radiusDp = 20,
                strokeColor = 0x78FFFFFF,
                topHighlightColor = 0x4AFFFFFF,
                bottomShadeColor = 0x18001F35,
                sideHighlightColor = 0x20D8F9FF,
                edgeShadeColor = 0x14001E3A
            )
        }
        if (darkMode) {
            return BackgroundStyle(
                color = if (empty) 0x7A142630 else 0xAA1D2A31.toInt(),
                radiusDp = 20
            )
        }
        return BackgroundStyle(
            color = if (empty) 0x50EEF8FF else 0x70EEF8FF,
            radiusDp = 20
        )
    }

    fun pageIndicator(enabled: Boolean, darkMode: Boolean = false): BackgroundStyle {
        if (enabled) {
            return BackgroundStyle(
                color = 0x70485F63,
                radiusDp = 17,
                strokeColor = 0x28FFFFFF,
                topHighlightColor = 0x22FFFFFF,
                bottomShadeColor = 0x18001224
            )
        }
        if (darkMode) {
            return BackgroundStyle(
                color = 0xB01A242A.toInt(),
                radiusDp = 17
            )
        }
        return BackgroundStyle(
            color = 0x78D8F9FF,
            radiusDp = 17
        )
    }

    fun dockGradient(
        enabled: Boolean,
        darkMode: Boolean = false,
        liquidGlass: Boolean = false
    ): IntArray {
        if (enabled && !darkMode) {
            return intArrayOf(
                0x70E7FBFF,
                0x62BDEEFF,
                0x703A86E8
            )
        }
        if (enabled && darkMode && !liquidGlass) {
            return intArrayOf(
                0xE0182B33.toInt(),
                0xEA071825.toInt(),
                0xD6213138.toInt()
            )
        }
        return intArrayOf(
            0x46E7FBFF,
            0x3CBDEEFF,
            0x463A86E8
        )
    }

    fun dockMaterial(
        enabled: Boolean,
        darkMode: Boolean = false,
        liquidGlass: Boolean = false
    ): BackgroundStyle {
        if (enabled && liquidGlass) {
            return BackgroundStyle(
                color = 0x327EDBFF,
                radiusDp = 38,
                strokeColor = 0x72CFFBFF,
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
        if (enabled) {
            return BackgroundStyle(
                color = 0x58A9E8FF,
                radiusDp = 38,
                strokeColor = 0x50FFFFFF,
                topHighlightColor = 0x3AFFFFFF,
                bottomShadeColor = 0x240064C8,
                sideHighlightColor = 0x30D8F9FF,
                edgeShadeColor = 0x18004A99
            )
        }
        return BackgroundStyle(
            color = 0x40A9E8FF,
            radiusDp = 38,
            strokeColor = 0x40FFFFFF,
            topHighlightColor = 0x30FFFFFF,
            bottomShadeColor = 0x1A0064C8,
            sideHighlightColor = 0x28D8F9FF,
            edgeShadeColor = 0x10004A99
        )
    }
}

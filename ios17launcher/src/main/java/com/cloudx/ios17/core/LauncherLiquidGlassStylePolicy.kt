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
        if (darkMode) {
            return BackgroundStyle(
                color = 0xA0182630.toInt(),
                radiusDp = 16
            )
        }
        return if (enabled) {
            BackgroundStyle(
                color = 0x24FFFFFF,
                radiusDp = 16,
                strokeColor = 0x8CFFFFFF.toInt(),
                topHighlightColor = 0x4DFFFFFF,
                bottomShadeColor = 0x18001F35
            )
        } else {
            BackgroundStyle(
                color = 0x1A202020,
                radiusDp = 16
            )
        }
    }

    fun folderPanel(enabled: Boolean, darkMode: Boolean = false): BackgroundStyle {
        if (darkMode) {
            return BackgroundStyle(
                color = 0xAA17242B.toInt(),
                radiusDp = 42
            )
        }
        return if (enabled) {
            BackgroundStyle(
                color = 0x22FFFFFF,
                radiusDp = 42,
                strokeColor = 0x90FFFFFF.toInt(),
                topHighlightColor = 0x52FFFFFF,
                bottomShadeColor = 0x1C001C2E,
                sideHighlightColor = 0x26D8F9FF,
                edgeShadeColor = 0x18001E3A
            )
        } else {
            BackgroundStyle(
                color = 0x86FFFFFF.toInt(),
                radiusDp = 42
            )
        }
    }

    fun searchPill(enabled: Boolean, darkMode: Boolean = false): BackgroundStyle {
        if (darkMode) {
            return BackgroundStyle(
                color = 0xB01A242A.toInt(),
                radiusDp = 22
            )
        }
        return if (enabled) {
            BackgroundStyle(
                color = 0x20FFFFFF,
                radiusDp = 22,
                strokeColor = 0x82FFFFFF.toInt(),
                topHighlightColor = 0x44FFFFFF,
                bottomShadeColor = 0x1600384A,
                sideHighlightColor = 0x22D8F9FF,
                edgeShadeColor = 0x14001E3A
            )
        } else {
            BackgroundStyle(
                color = 0x733B5B6A,
                radiusDp = 22
            )
        }
    }

    fun searchField(enabled: Boolean, darkMode: Boolean = false): BackgroundStyle =
        searchPill(enabled, darkMode)

    fun searchResultsPanel(enabled: Boolean, darkMode: Boolean = false): BackgroundStyle {
        if (darkMode) {
            return BackgroundStyle(
                color = 0xAA1D2A31.toInt(),
                radiusDp = 16
            )
        }
        return if (enabled) {
            BackgroundStyle(
                color = 0x24FFFFFF,
                radiusDp = 16,
                strokeColor = 0x78FFFFFF,
                topHighlightColor = 0x44FFFFFF,
                bottomShadeColor = 0x1600384A
            )
        } else {
            BackgroundStyle(
                color = 0x86FFFFFF.toInt(),
                radiusDp = 12
            )
        }
    }

    fun appLibraryFolder(enabled: Boolean, empty: Boolean, darkMode: Boolean = false): BackgroundStyle {
        if (darkMode) {
            return BackgroundStyle(
                color = if (empty) 0x7A142630 else 0xAA1D2A31.toInt(),
                radiusDp = 20
            )
        }
        return if (enabled) {
            BackgroundStyle(
                color = if (empty) 0x16FFFFFF else 0x26FFFFFF,
                radiusDp = 20,
                strokeColor = 0x78FFFFFF,
                topHighlightColor = 0x4AFFFFFF,
                bottomShadeColor = 0x18001F35,
                sideHighlightColor = 0x20D8F9FF,
                edgeShadeColor = 0x14001E3A
            )
        } else {
            BackgroundStyle(
                color = if (empty) 0x365F6663 else 0x705F6663,
                radiusDp = 20
            )
        }
    }

    fun pageIndicator(enabled: Boolean, darkMode: Boolean = false): BackgroundStyle {
        if (darkMode) {
            return BackgroundStyle(
                color = 0xB01A242A.toInt(),
                radiusDp = 17
            )
        }
        return if (enabled) {
            BackgroundStyle(
                color = 0x20FFFFFF,
                radiusDp = 17,
                strokeColor = 0x82FFFFFF.toInt(),
                topHighlightColor = 0x42FFFFFF,
                bottomShadeColor = 0x1400384A,
                sideHighlightColor = 0x20D8F9FF,
                edgeShadeColor = 0x12001E3A
            )
        } else {
            BackgroundStyle(
                color = 0x66D8F9FF,
                radiusDp = 17
            )
        }
    }

    fun dockGradient(enabled: Boolean, darkMode: Boolean = false): IntArray {
        if (darkMode) {
            return intArrayOf(
                0xE0182B33.toInt(),
                0xEA071825.toInt(),
                0xD6213138.toInt()
            )
        }
        return if (enabled) {
            intArrayOf(
                0x20FFFFFF,
                0x16D8F9FF,
                0x26FFFFFF
            )
        } else {
            intArrayOf(
                0x76A9E8FF,
                0x7C2FA4F5,
                0x90BFF7FF.toInt()
            )
        }
    }

    fun dockMaterial(enabled: Boolean, darkMode: Boolean = false): BackgroundStyle {
        if (darkMode) {
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
        return if (enabled) {
            BackgroundStyle(
                color = 0x18FFFFFF,
                radiusDp = 38,
                strokeColor = 0x76FFFFFF,
                topHighlightColor = 0x46FFFFFF,
                bottomShadeColor = 0x1B004A6A,
                sideHighlightColor = 0x2FD8F9FF,
                edgeShadeColor = 0x24001E3A
            )
        } else {
            BackgroundStyle(
                color = 0x50A9E8FF,
                radiusDp = 38,
                strokeColor = 0x42FFFFFF,
                topHighlightColor = 0x24FFFFFF,
                bottomShadeColor = 0x22004A6A,
                sideHighlightColor = 0x202FA4F5,
                edgeShadeColor = 0x20001E3A
            )
        }
    }
}

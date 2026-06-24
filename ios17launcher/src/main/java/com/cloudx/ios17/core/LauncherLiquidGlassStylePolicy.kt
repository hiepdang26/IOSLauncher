package com.cloudx.ios17.core

object LauncherLiquidGlassStylePolicy {

    data class BackgroundStyle(
        val color: Int,
        val radiusDp: Int,
        val strokeColor: Int? = null,
        val strokeWidthDp: Int = 1
    )

    fun folderPreview(enabled: Boolean): BackgroundStyle {
        return if (enabled) {
            BackgroundStyle(
                color = 0x42D8F9FF,
                radiusDp = 16,
                strokeColor = 0xB8FFFFFF.toInt()
            )
        } else {
            BackgroundStyle(
                color = 0x1A202020,
                radiusDp = 16
            )
        }
    }

    fun folderPanel(enabled: Boolean): BackgroundStyle {
        return if (enabled) {
            BackgroundStyle(
                color = 0x32D8F9FF,
                radiusDp = 42,
                strokeColor = 0xC8FFFFFF.toInt()
            )
        } else {
            BackgroundStyle(
                color = 0x86FFFFFF.toInt(),
                radiusDp = 42
            )
        }
    }

    fun searchPill(enabled: Boolean): BackgroundStyle {
        return if (enabled) {
            BackgroundStyle(
                color = 0x2ED8F9FF,
                radiusDp = 22,
                strokeColor = 0xC8FFFFFF.toInt()
            )
        } else {
            BackgroundStyle(
                color = 0x733B5B6A,
                radiusDp = 22
            )
        }
    }

    fun searchField(enabled: Boolean): BackgroundStyle = searchPill(enabled)

    fun appLibraryFolder(enabled: Boolean, empty: Boolean): BackgroundStyle {
        return if (enabled) {
            BackgroundStyle(
                color = if (empty) 0x26FFFFFF else 0x42D8F9FF,
                radiusDp = 20,
                strokeColor = 0xB8FFFFFF.toInt()
            )
        } else {
            BackgroundStyle(
                color = if (empty) 0x365F6663 else 0x705F6663,
                radiusDp = 20
            )
        }
    }

    fun pageIndicator(enabled: Boolean): BackgroundStyle {
        return if (enabled) {
            BackgroundStyle(
                color = 0x36D8F9FF,
                radiusDp = 17,
                strokeColor = 0xB8FFFFFF.toInt()
            )
        } else {
            BackgroundStyle(
                color = 0x733B5B6A,
                radiusDp = 17
            )
        }
    }

    fun dockGradient(enabled: Boolean): IntArray {
        return if (enabled) {
            intArrayOf(
                0x66D8F9FF,
                0x551B8EF5,
                0x66D8F9FF
            )
        } else {
            intArrayOf(
                0x76A9E8FF,
                0x7C2FA4F5,
                0x90BFF7FF.toInt()
            )
        }
    }
}

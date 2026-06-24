package com.vhmsoft.launcherios26.ui.launcher.workspace

object LauncherLiquidGlassStylePolicy {
    data class BackgroundStyle(
        val color: Int,
        val radiusDp: Int,
        val strokeColor: Int? = null,
        val strokeWidthDp: Int = 1
    )

    fun dock(enabled: Boolean, darkMode: Boolean): BackgroundStyle {
        return if (enabled) {
            BackgroundStyle(
                color = 0x55BDEFFF,
                radiusDp = 38,
                strokeColor = strongGlassStroke
            )
        } else {
            BackgroundStyle(
                color = if (darkMode) 0x78404D5C else 0x6B3CA9E8,
                radiusDp = 38,
                strokeColor = if (darkMode) 0x55FFFFFF else 0x66FFFFFF
            )
        }
    }

    fun homeSearchPill(enabled: Boolean, darkMode: Boolean): BackgroundStyle {
        return if (enabled) {
            BackgroundStyle(
                color = 0x32D8F9FF,
                radiusDp = 17,
                strokeColor = strongGlassStroke
            )
        } else {
            BackgroundStyle(
                color = if (darkMode) 0xA8001520.toInt() else 0x9A001A24.toInt(),
                radiusDp = 17
            )
        }
    }

    fun pageIndicator(enabled: Boolean, darkMode: Boolean): BackgroundStyle {
        return if (enabled) {
            BackgroundStyle(
                color = 0x36D8F9FF,
                radiusDp = 16,
                strokeColor = mediumGlassStroke
            )
        } else {
            BackgroundStyle(
                color = if (darkMode) 0x66324B5C else 0x733B5B6A,
                radiusDp = 16
            )
        }
    }

    fun folderPreview(enabled: Boolean, darkMode: Boolean): BackgroundStyle {
        return if (enabled) {
            BackgroundStyle(
                color = 0x42D8F9FF,
                radiusDp = 16,
                strokeColor = mediumGlassStroke
            )
        } else {
            BackgroundStyle(
                color = if (darkMode) 0x5A42484B else 0x705F6663,
                radiusDp = 16
            )
        }
    }

    fun folderPanel(enabled: Boolean, darkMode: Boolean): BackgroundStyle {
        return if (enabled) {
            BackgroundStyle(
                color = 0x32D8F9FF,
                radiusDp = 34,
                strokeColor = strongGlassStroke
            )
        } else {
            BackgroundStyle(
                color = if (darkMode) 0x5A42484B else 0x705F6663,
                radiusDp = 34
            )
        }
    }

    fun searchField(enabled: Boolean, darkMode: Boolean): BackgroundStyle {
        return if (enabled) {
            BackgroundStyle(
                color = 0x2ED8F9FF,
                radiusDp = 28,
                strokeColor = strongGlassStroke
            )
        } else {
            BackgroundStyle(
                color = if (darkMode) 0x72FFFFFF else 0x8AFFFFFF.toInt(),
                radiusDp = 28
            )
        }
    }

    fun librarySearchField(enabled: Boolean, darkMode: Boolean): BackgroundStyle {
        return searchField(enabled, darkMode).copy(radiusDp = 22)
    }

    fun searchResultsPanel(enabled: Boolean, darkMode: Boolean): BackgroundStyle {
        return if (enabled) {
            BackgroundStyle(
                color = 0x42FFFFFF,
                radiusDp = 28,
                strokeColor = softGlassStroke
            )
        } else {
            BackgroundStyle(
                color = if (darkMode) 0x62FFFFFF else 0x78FFFFFF,
                radiusDp = 28
            )
        }
    }

    fun appLibrarySearchPill(enabled: Boolean, darkMode: Boolean): BackgroundStyle {
        return if (enabled) {
            BackgroundStyle(
                color = 0x2ED8F9FF,
                radiusDp = 22,
                strokeColor = strongGlassStroke
            )
        } else {
            BackgroundStyle(
                color = if (darkMode) 0x66324B5C else 0x733B5B6A,
                radiusDp = 22
            )
        }
    }

    fun appLibraryFolder(
        enabled: Boolean,
        darkMode: Boolean,
        empty: Boolean
    ): BackgroundStyle {
        return if (enabled) {
            BackgroundStyle(
                color = if (empty) 0x26FFFFFF else 0x42D8F9FF,
                radiusDp = 20,
                strokeColor = mediumGlassStroke
            )
        } else {
            BackgroundStyle(
                color = when {
                    darkMode -> 0x5A42484B
                    empty -> 0x365F6663
                    else -> 0x705F6663
                },
                radiusDp = 20
            )
        }
    }

    private val strongGlassStroke = 0xC8FFFFFF.toInt()
    private val mediumGlassStroke = 0xB8FFFFFF.toInt()
    private val softGlassStroke = 0x88FFFFFF.toInt()
}

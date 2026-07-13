package com.vhmsoft.launcherios26.ui.launcher.workspace

object LauncherLiquidGlassStylePolicy {
    data class BackgroundStyle(
        val color: Int,
        val radiusDp: Int,
        val strokeColor: Int? = null,
        val strokeWidthDp: Int = 1
    )

    fun dock(enabled: Boolean, darkMode: Boolean): BackgroundStyle {
        if (darkMode) {
            return BackgroundStyle(
                color = if (enabled) 0x8A182A36.toInt() else 0x78404D5C,
                radiusDp = 38,
                strokeColor = if (enabled) 0x72FFFFFF else 0x55FFFFFF
            )
        }
        return BackgroundStyle(
            color = 0x4FD8F9FF,
            radiusDp = 38,
            strokeColor = 0x78FFFFFF
        )
    }

    fun homeSearchPill(enabled: Boolean, darkMode: Boolean): BackgroundStyle {
        return BackgroundStyle(
            color = if (darkMode) 0xA8001520.toInt() else 0x9A001A24.toInt(),
            radiusDp = 17
        )
    }

    fun pageIndicator(enabled: Boolean, darkMode: Boolean): BackgroundStyle {
        return BackgroundStyle(
            color = if (darkMode) 0x66324B5C else 0x733B5B6A,
            radiusDp = 16
        )
    }

    fun folderPreview(enabled: Boolean, darkMode: Boolean): BackgroundStyle {
        return BackgroundStyle(
            color = if (darkMode) 0x5A42484B else 0x705F6663,
            radiusDp = 8
        )
    }

    fun folderPanel(enabled: Boolean, darkMode: Boolean): BackgroundStyle {
        return BackgroundStyle(
            color = if (darkMode) 0x5A42484B else 0x705F6663,
            radiusDp = 34
        )
    }

    fun searchField(enabled: Boolean, darkMode: Boolean): BackgroundStyle {
        return BackgroundStyle(
            color = if (darkMode) 0x72FFFFFF else 0x8AFFFFFF.toInt(),
            radiusDp = 28
        )
    }

    fun librarySearchField(enabled: Boolean, darkMode: Boolean): BackgroundStyle {
        return searchField(enabled, darkMode).copy(radiusDp = 22)
    }

    fun searchResultsPanel(enabled: Boolean, darkMode: Boolean): BackgroundStyle {
        return BackgroundStyle(
            color = if (darkMode) 0x62FFFFFF else 0x78FFFFFF,
            radiusDp = 28
        )
    }

    fun appLibrarySearchPill(enabled: Boolean, darkMode: Boolean): BackgroundStyle {
        return BackgroundStyle(
            color = if (darkMode) 0x66324B5C else 0x733B5B6A,
            radiusDp = 22
        )
    }

    fun appLibraryFolder(
        enabled: Boolean,
        darkMode: Boolean,
        empty: Boolean
    ): BackgroundStyle {
        return BackgroundStyle(
            color = when {
                darkMode -> 0x5A42484B
                empty -> 0x365F6663
                else -> 0x705F6663
            },
            radiusDp = 20
        )
    }

    fun removeBadge(enabled: Boolean, darkMode: Boolean): BackgroundStyle =
        BackgroundStyle(
            color = if (darkMode) 0xD8FFFFFF.toInt() else 0xC8FFFFFF.toInt(),
            radiusDp = 12,
            strokeColor = 0xA8FFFFFF.toInt()
        )
}

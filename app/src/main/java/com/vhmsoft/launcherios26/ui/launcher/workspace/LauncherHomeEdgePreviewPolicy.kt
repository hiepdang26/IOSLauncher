package com.vhmsoft.launcherios26.ui.launcher.workspace

internal object LauncherHomeEdgePreviewPolicy {
    fun shouldUpdatePreview(
        dragActive: Boolean,
        pageSwitching: Boolean,
        edgeDirection: Int = 0,
        dragPage: Int,
        sourcePage: Int,
        hasLeftSourcePage: Boolean
    ): Boolean {
        if (!dragActive || pageSwitching) return false
        if (edgeDirection != 0) return false
        return dragPage != sourcePage || hasLeftSourcePage
    }
}

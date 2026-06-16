package com.vhmsoft.launcherios26.ui.launcher.workspace

internal object LauncherHomeEdgePreviewPolicy {
    fun shouldUpdatePreview(
        dragActive: Boolean,
        pageSwitching: Boolean,
        dragPage: Int,
        sourcePage: Int,
        hasLeftSourcePage: Boolean
    ): Boolean {
        if (!dragActive || pageSwitching) return false
        return dragPage != sourcePage || hasLeftSourcePage
    }
}

package com.vhmsoft.launcherios26.ui.launcher

internal object LauncherDragEdgeGlowPolicy {
    data class EdgeGlowState(
        val showLeft: Boolean,
        val showRight: Boolean
    )

    fun resolve(dragActive: Boolean): EdgeGlowState {
        return EdgeGlowState(
            showLeft = dragActive,
            showRight = dragActive
        )
    }
}

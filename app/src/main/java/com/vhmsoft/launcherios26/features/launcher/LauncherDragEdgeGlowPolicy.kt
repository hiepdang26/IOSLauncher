package com.vhmsoft.launcherios26.features.launcher

object LauncherDragEdgeGlowPolicy {
    data class State(
        val showLeft: Boolean,
        val showRight: Boolean
    )

    fun resolve(dragActive: Boolean): State {
        return State(
            showLeft = dragActive,
            showRight = dragActive
        )
    }
}

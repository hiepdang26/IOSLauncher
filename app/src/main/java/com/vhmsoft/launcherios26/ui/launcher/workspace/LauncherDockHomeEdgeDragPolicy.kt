package com.vhmsoft.launcherios26.ui.launcher.workspace

internal object LauncherDockHomeEdgeDragPolicy {
    fun shouldHandle(
        editingHome: Boolean,
        alreadyActive: Boolean,
        inDock: Boolean,
        inWorkspace: Boolean,
        inEdgeZone: Boolean
    ): Boolean {
        if (!editingHome || inDock || !inWorkspace) return false
        return alreadyActive || inEdgeZone
    }
}

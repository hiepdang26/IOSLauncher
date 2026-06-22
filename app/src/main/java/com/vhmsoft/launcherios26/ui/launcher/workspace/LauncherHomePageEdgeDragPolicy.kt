package com.vhmsoft.launcherios26.ui.launcher.workspace

internal object LauncherHomePageEdgeDragPolicy {
    const val DEFAULT_EDGE_ZONE_DP = 64

    fun directionForCenter(
        rootCenterX: Float,
        rootWidth: Int,
        edgeZonePx: Int
    ): Int {
        if (rootWidth <= 0 || edgeZonePx <= 0) return 0
        return when {
            rootCenterX <= edgeZonePx -> -1
            rootCenterX >= rootWidth - edgeZonePx -> 1
            else -> 0
        }
    }

    fun shouldStart(
        editingHome: Boolean,
        hasDraggableItem: Boolean,
        alreadyActive: Boolean,
        direction: Int
    ): Boolean {
        if (!editingHome || !hasDraggableItem) return false
        return alreadyActive || direction != 0
    }
}

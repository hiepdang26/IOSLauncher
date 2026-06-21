package com.vhmsoft.launcherios26.ui.launcher.workspace

internal object LauncherIos17DragDropPolicy {
    const val REORDER_TIMEOUT_MS = 350L
    const val DOCK_PARENT_PAGE = -99

    fun shouldFireReorderAlarm(
        folderInterest: Boolean,
        targetIndex: Int,
        hoverElapsedMs: Long
    ): Boolean {
        if (folderInterest || targetIndex < 0) return false
        return hoverElapsedMs >= REORDER_TIMEOUT_MS
    }

    fun canDockReorder(
        dockItemCount: Int,
        maxDockItems: Int,
        parentPage: Int
    ): Boolean {
        return dockItemCount < maxDockItems || parentPage == DOCK_PARENT_PAGE
    }

    fun canCreateNextPage(currentPageItemCount: Int): Boolean {
        return currentPageItemCount > 1
    }
}

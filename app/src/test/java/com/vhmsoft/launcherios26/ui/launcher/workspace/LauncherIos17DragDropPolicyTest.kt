package com.vhmsoft.launcherios26.ui.launcher.workspace

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherIos17DragDropPolicyTest {
    @Test
    fun shouldFireReorderAlarm_waitsForIos17TimeoutAndSkipsFolderInterest() {
        assertFalse(
            LauncherIos17DragDropPolicy.shouldFireReorderAlarm(
                folderInterest = false,
                targetIndex = 2,
                hoverElapsedMs = 349L
            )
        )

        assertTrue(
            LauncherIos17DragDropPolicy.shouldFireReorderAlarm(
                folderInterest = false,
                targetIndex = 2,
                hoverElapsedMs = 350L
            )
        )

        assertFalse(
            LauncherIos17DragDropPolicy.shouldFireReorderAlarm(
                folderInterest = true,
                targetIndex = 2,
                hoverElapsedMs = 350L
            )
        )
    }

    @Test
    fun canDockReorder_matchesDockReorderAlarmListener() {
        assertTrue(
            LauncherIos17DragDropPolicy.canDockReorder(
                dockItemCount = 4,
                maxDockItems = 4,
                parentPage = LauncherIos17DragDropPolicy.DOCK_PARENT_PAGE
            )
        )

        assertFalse(
            LauncherIos17DragDropPolicy.canDockReorder(
                dockItemCount = 4,
                maxDockItems = 4,
                parentPage = 0
            )
        )
    }

    @Test
    fun canCreateNextPage_requiresMoreThanOneItemOnCurrentPageWhenAutoArrangeIsEnabled() {
        assertFalse(
            LauncherIos17DragDropPolicy.canCreateNextPage(
                currentPageItemCount = 1,
                autoArrange = true
            )
        )
        assertTrue(
            LauncherIos17DragDropPolicy.canCreateNextPage(
                currentPageItemCount = 2,
                autoArrange = true
            )
        )
    }

    @Test
    fun canCreateNextPage_allowsSparsePagesWhenAutoArrangeIsDisabled() {
        assertTrue(
            LauncherIos17DragDropPolicy.canCreateNextPage(
                currentPageItemCount = 1,
                autoArrange = false
            )
        )
    }
}

package com.vhmsoft.launcherios26.ui.launcher.workspace

import org.junit.Assert.assertEquals
import org.junit.Test

class LauncherPagedFolderGridPolicyTest {
    @Test
    fun pageCount_startsANewPageAfterNineApps() {
        assertEquals(0, LauncherPagedFolderGridPolicy.pageCount(itemCount = 0))
        assertEquals(1, LauncherPagedFolderGridPolicy.pageCount(itemCount = 1))
        assertEquals(1, LauncherPagedFolderGridPolicy.pageCount(itemCount = 9))
        assertEquals(2, LauncherPagedFolderGridPolicy.pageCount(itemCount = 10))
        assertEquals(2, LauncherPagedFolderGridPolicy.pageCount(itemCount = 18))
        assertEquals(3, LauncherPagedFolderGridPolicy.pageCount(itemCount = 19))
    }

    @Test
    fun cellPosition_placesAppsLeftToRightBeforeStartingNextRow() {
        assertEquals(
            LauncherPagedFolderGridPolicy.CellPosition(page = 0, row = 0, column = 0),
            LauncherPagedFolderGridPolicy.cellPosition(index = 0)
        )
        assertEquals(
            LauncherPagedFolderGridPolicy.CellPosition(page = 0, row = 0, column = 2),
            LauncherPagedFolderGridPolicy.cellPosition(index = 2)
        )
        assertEquals(
            LauncherPagedFolderGridPolicy.CellPosition(page = 0, row = 1, column = 0),
            LauncherPagedFolderGridPolicy.cellPosition(index = 3)
        )
        assertEquals(
            LauncherPagedFolderGridPolicy.CellPosition(page = 0, row = 2, column = 2),
            LauncherPagedFolderGridPolicy.cellPosition(index = 8)
        )
    }

    @Test
    fun cellPosition_placesTenthAppAtStartOfNextPage() {
        assertEquals(
            LauncherPagedFolderGridPolicy.CellPosition(page = 1, row = 0, column = 0),
            LauncherPagedFolderGridPolicy.cellPosition(index = 9)
        )
        assertEquals(
            LauncherPagedFolderGridPolicy.CellPosition(page = 1, row = 0, column = 1),
            LauncherPagedFolderGridPolicy.cellPosition(index = 10)
        )
    }
}

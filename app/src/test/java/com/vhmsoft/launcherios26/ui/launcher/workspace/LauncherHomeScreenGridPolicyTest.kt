package com.vhmsoft.launcherios26.ui.launcher.workspace

import org.junit.Assert.assertEquals
import org.junit.Test

class LauncherHomeScreenGridPolicyTest {
    @Test
    fun pageSize_usesRowsFromHomeScreenGrid() {
        assertEquals(24, LauncherHomeScreenGridPolicy.pageSize(rows = 6, columns = 4))
        assertEquals(20, LauncherHomeScreenGridPolicy.pageSize(rows = 5, columns = 4))
    }

    @Test
    fun replacePage_constrainsChangedPageToGridCapacityAndCarriesOverflowForward() {
        val firstPage = (0 until 24).map { index -> placeholder(index) }
        val secondPage = listOf(placeholder(100), placeholder(101))
        val changedPage = (200 until 225).map { index -> placeholder(index) }

        val flattened = LauncherHomeScreenGridPolicy.replacePage(
            pages = listOf(firstPage, secondPage),
            pagePosition = 0,
            pageItems = changedPage,
            pageSize = 24
        )

        assertEquals(changedPage.take(24), flattened.take(24))
        assertEquals(changedPage[24], flattened[24])
        assertEquals(secondPage, flattened.drop(25))
    }

    @Test
    fun blankDropPosition_capsFinalPositionToLastSlotInSelectedGridRows() {
        val position = LauncherHomeScreenGridPolicy.blankDropPosition(
            draggedCenterX = 390f,
            draggedCenterY = 590f,
            gridWidth = 400,
            gridHeight = 600,
            rows = 6,
            columns = 4,
            itemCount = 25
        )

        assertEquals(23, position)
    }

    @Test
    fun blankDropPosition_returnsPlaceholderCellInsideCurrentItems() {
        val position = LauncherHomeScreenGridPolicy.blankDropPosition(
            draggedCenterX = 150f,
            draggedCenterY = 150f,
            gridWidth = 400,
            gridHeight = 600,
            rows = 6,
            columns = 4,
            itemCount = 24,
            isBlankAtPosition = { index -> index == 5 }
        )

        assertEquals(5, position)
    }

    @Test
    fun blankDropPosition_ignoresOccupiedCellInsideCurrentItems() {
        val position = LauncherHomeScreenGridPolicy.blankDropPosition(
            draggedCenterX = 150f,
            draggedCenterY = 150f,
            gridWidth = 400,
            gridHeight = 600,
            rows = 6,
            columns = 4,
            itemCount = 24,
            isBlankAtPosition = { false }
        )

        assertEquals(LauncherHomeScreenGridPolicy.NO_POSITION, position)
    }

    private fun placeholder(index: Int): LauncherHomeItemUiModel.Placeholder {
        return LauncherHomeItemUiModel.Placeholder.forGridIndex(index)
    }
}

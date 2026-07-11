package com.vhmsoft.launcherios26.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherHomeCellPolicyTest {

    @Test
    fun autoArrange_defaultsToDisabled() {
        assertFalse(LauncherHomeCellPolicy.DEFAULT_AUTO_REARRANGE_APPS)
    }

    @Test
    fun rowAndColumn_useStoredCellWhenAutoArrangeIsDisabled() {
        val placement = LauncherHomeCellPolicy.gridPlacementForCell(cell = 7, columns = 4)

        assertEquals(1, placement.row)
        assertEquals(3, placement.column)
    }

    @Test
    fun resolveCell_keepsPreferredEmptyCellBeforeAppending() {
        val cell = LauncherHomeCellPolicy.resolveCell(
            preferredCell = 5,
            requestedIndex = -1,
            occupiedCells = setOf(0, 1, 2),
            maxCells = 24
        )

        assertEquals(5, cell)
    }

    @Test
    fun resolveCell_appendsAfterLastOccupiedCellWithoutFillingEarlierGap() {
        val cell = LauncherHomeCellPolicy.resolveCell(
            preferredCell = -1,
            requestedIndex = -1,
            occupiedCells = setOf(0, 2, 3),
            maxCells = 24
        )

        assertEquals(4, cell)
    }

    @Test
    fun nextAppendCell_doesNotFillEarlierGapWhenLastCellIsOccupied() {
        val cell = LauncherHomeCellPolicy.nextAppendCell(
            occupiedCells = setOf(0, 2, 23),
            maxCells = 24
        )

        assertNull(cell)
    }

    @Test
    fun dropCell_usesDropCoordinatesInsideSixByFourGrid() {
        val cell = LauncherHomeCellPolicy.dropCell(
            dropX = 251f,
            dropY = 141f,
            gridLeft = 0,
            gridTop = 0,
            paddingLeft = 10,
            paddingTop = 40,
            cellWidth = 100,
            cellHeight = 80,
            rows = 6,
            columns = 4
        )

        assertEquals(6, cell)
    }

    @Test
    fun gridOffsetForCell_keepsSixthRowAtFixedGridOffset() {
        val offset = LauncherHomeCellPolicy.gridOffsetForCell(
            cell = 22,
            columns = 4,
            cellWidth = 100,
            cellHeight = 80
        )

        assertEquals(200, offset.left)
        assertEquals(400, offset.top)
    }

    @Test
    fun manualLayoutForCell_keepsSixthRowDirectlyAfterFifthRow() {
        val fifthRow = LauncherHomeCellPolicy.manualLayoutForCell(
            cell = 16,
            columns = 4,
            cellWidth = 100,
            cellHeight = 80
        )
        val sixthRow = LauncherHomeCellPolicy.manualLayoutForCell(
            cell = 20,
            columns = 4,
            cellWidth = 100,
            cellHeight = 80
        )

        assertEquals(0, sixthRow.specRow)
        assertEquals(0, sixthRow.specColumn)
        assertEquals(400, sixthRow.top)
        assertEquals(fifthRow.top + 80, sixthRow.top)
    }

    @Test
    fun cellHeightForPage_recalculatesWhenEditPaddingChanges() {
        val normalHeight = LauncherHomeCellPolicy.cellHeightForPage(
            workspaceHeight = 600,
            normalTopPadding = 40,
            currentTopPadding = 40,
            rows = 6,
            maxCellHeight = 100
        )
        val editHeight = LauncherHomeCellPolicy.cellHeightForPage(
            workspaceHeight = 600,
            normalTopPadding = 40,
            currentTopPadding = 78,
            rows = 6,
            maxCellHeight = 100
        )

        assertEquals(100, normalHeight)
        assertEquals(93, editHeight)
    }

    @Test
    fun dropCell_clampsBelowGridToLastRow() {
        val cell = LauncherHomeCellPolicy.dropCell(
            dropX = 251f,
            dropY = 999f,
            gridLeft = 0,
            gridTop = 0,
            paddingLeft = 10,
            paddingTop = 40,
            cellWidth = 100,
            cellHeight = 80,
            rows = 6,
            columns = 4
        )

        assertEquals(22, cell)
    }

    @Test
    fun compactCell_usesChildOrderWhenAutoArrangeIsEnabled() {
        assertEquals(3, LauncherHomeCellPolicy.compactCell(childIndex = 3))
    }

    @Test
    fun compactCells_pushesLowerRowsIntoEarlierGaps() {
        val compacted = LauncherHomeCellPolicy.compactCells(
            itemCount = 6,
            maxCells = 24
        )

        assertEquals(listOf(0, 1, 2, 3, 4, 5), compacted)
    }

    @Test
    fun shouldCompactCells_followsAutoArrangeSettingUnlessForced() {
        assertFalse(
            LauncherHomeCellPolicy.shouldCompactCells(
                autoArrangeEnabled = false,
                forceCompact = false
            )
        )
        assertTrue(
            LauncherHomeCellPolicy.shouldCompactCells(
                autoArrangeEnabled = true,
                forceCompact = false
            )
        )
        assertTrue(
            LauncherHomeCellPolicy.shouldCompactCells(
                autoArrangeEnabled = false,
                forceCompact = true
            )
        )
    }

    @Test
    fun displacedCellForCollision_prefersMovingOriginalCellWhenItIsFree() {
        val cell = LauncherHomeCellPolicy.displacedCellForCollision(
            movingOriginalCell = 10,
            targetCell = 5,
            occupiedCells = setOf(5, 7),
            maxCells = 24
        )

        assertEquals(10, cell)
    }

    @Test
    fun displacedCellForCollision_usesNearestEmptyCellWhenOriginalCellIsUnavailable() {
        val cell = LauncherHomeCellPolicy.displacedCellForCollision(
            movingOriginalCell = 10,
            targetCell = 5,
            occupiedCells = setOf(5, 7, 10, 11),
            maxCells = 24
        )

        assertEquals(9, cell)
    }

    @Test
    fun collisionPreview_movesTargetOccupantIntoMovingCurrentCell() {
        val preview = LauncherHomeCellPolicy.collisionPreview(
            movingCurrentCell = 2,
            targetCell = 5,
            occupiedCells = setOf(5, 7),
            maxCells = 24
        )

        assertEquals(5, preview.movingCell)
        assertEquals(2, preview.displacedCell)
    }

    @Test
    fun folderCreationCell_keepsTargetAppCellWhenEarlierGapsExist() {
        val cell = LauncherHomeCellPolicy.folderCreationCell(
            targetCell = 10,
            targetIndex = 4,
            maxCells = 24
        )

        assertEquals(10, cell)
    }

    @Test
    fun folderCreationCell_fallsBackToTargetIndexWhenTargetCellIsInvalid() {
        val cell = LauncherHomeCellPolicy.folderCreationCell(
            targetCell = -1,
            targetIndex = 4,
            maxCells = 24
        )

        assertEquals(4, cell)
    }

    @Test
    fun resolvePageCell_movesOverflowItemToNextAvailablePage() {
        val placement = LauncherHomeCellPolicy.resolvePageCell(
            preferredPage = 1,
            preferredCell = 23,
            occupiedCellsByPage = mapOf(
                1 to (0 until 24).toSet(),
                2 to setOf(0, 1, 2, 3)
            ),
            maxCells = 24
        )

        assertEquals(2, placement.page)
        assertEquals(4, placement.cell)
    }

    @Test
    fun resolvePageCell_keepsPreferredEmptyCell() {
        val placement = LauncherHomeCellPolicy.resolvePageCell(
            preferredPage = 1,
            preferredCell = 8,
            occupiedCellsByPage = mapOf(
                1 to setOf(0, 1, 2)
            ),
            maxCells = 24
        )

        assertEquals(1, placement.page)
        assertEquals(8, placement.cell)
    }

    @Test
    fun newItemPlacement_fillsNearestPageGapBeforeCreatingNewPage() {
        val placement = LauncherHomeCellPolicy.newItemPlacement(
            preferredPage = 1,
            existingPageCount = 3,
            occupiedCellsByPage = mapOf(
                0 to ((0 until 24).toSet() - 7),
                1 to (0 until 24).toSet(),
                2 to ((0 until 24).toSet() - 5)
            ),
            maxCells = 24
        )

        assertEquals(2, placement.page)
        assertEquals(5, placement.cell)
    }

    @Test
    fun newItemPlacement_createsNextPageWhenAllExistingPagesAreFull() {
        val placement = LauncherHomeCellPolicy.newItemPlacement(
            preferredPage = 0,
            existingPageCount = 2,
            occupiedCellsByPage = mapOf(
                0 to (0 until 24).toSet(),
                1 to (0 until 24).toSet()
            ),
            maxCells = 24
        )

        assertEquals(2, placement.page)
        assertEquals(0, placement.cell)
    }
}

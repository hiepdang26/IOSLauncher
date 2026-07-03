package com.cloudx.ios17.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class FolderDragSessionPolicyTest {

    @Test
    fun firstAvailablePlacement_usesNineSlotsPerFolderPage() {
        assertEquals(9, FolderDragSessionPolicy.ITEMS_PER_PAGE)

        val pageOnePlacement = FolderDragSessionPolicy.firstAvailablePlacement(
            occupiedCells = (0 until 9).toSet(),
            startPage = 0
        )

        assertEquals(1, pageOnePlacement.page)
        assertEquals(0, pageOnePlacement.cell)

        val pageTwoPlacement = FolderDragSessionPolicy.firstAvailablePlacement(
            occupiedCells = (0 until 18).toSet(),
            startPage = 0
        )

        assertEquals(2, pageTwoPlacement.page)
        assertEquals(0, pageTwoPlacement.cell)
    }

    @Test
    fun folderPageScrollAnimation_isSlowEnoughToReadDuringDrag() {
        assertEquals(320, FolderDragSessionPolicy.FOLDER_PAGE_SCROLL_ANIMATION_MS)
    }

    @Test
    fun edgeTargetPage_movesOnlyAtHorizontalEdges() {
        assertEquals(
            0,
            FolderDragSessionPolicy.edgeTargetPage(
                x = 10f,
                width = 300,
                currentPage = 1,
                pageCount = 3,
                edgeSizePx = 40
            )
        )
        assertEquals(
            1,
            FolderDragSessionPolicy.edgeTargetPage(
                x = 290f,
                width = 300,
                currentPage = 0,
                pageCount = 3,
                edgeSizePx = 40
            )
        )
        assertEquals(
            1,
            FolderDragSessionPolicy.edgeTargetPage(
                x = 150f,
                width = 300,
                currentPage = 1,
                pageCount = 3,
                edgeSizePx = 40
            )
        )
        assertEquals(
            2,
            FolderDragSessionPolicy.edgeTargetPage(
                x = 290f,
                width = 300,
                currentPage = 2,
                pageCount = 3,
                edgeSizePx = 40
            )
        )
    }

    @Test
    fun shouldExitFolder_usesThresholdAroundFolderBounds() {
        assertFalse(
            FolderDragSessionPolicy.shouldExitFolder(
                x = 95f,
                y = 120f,
                left = 100,
                top = 100,
                right = 300,
                bottom = 300,
                thresholdPx = 24
            )
        )
        assertTrue(
            FolderDragSessionPolicy.shouldExitFolder(
                x = 70f,
                y = 120f,
                left = 100,
                top = 100,
                right = 300,
                bottom = 300,
                thresholdPx = 24
            )
        )
    }

    @Test
    fun shouldExitHoverOpenedFolder_waitsUntilDragEntersExpandedPanel() {
        assertFalse(
            FolderDragSessionPolicy.shouldExitHoverOpenedFolder(
                x = 0f,
                y = 0f,
                left = 100,
                top = 100,
                right = 300,
                bottom = 300,
                thresholdPx = 24,
                hasEnteredOpenFolder = false
            )
        )
    }

    @Test
    fun shouldExitHoverOpenedFolder_exitsAfterLeavingExpandedPanelWithThreshold() {
        assertFalse(
            FolderDragSessionPolicy.shouldExitHoverOpenedFolder(
                x = 95f,
                y = 120f,
                left = 100,
                top = 100,
                right = 300,
                bottom = 300,
                thresholdPx = 24,
                hasEnteredOpenFolder = true
            )
        )
        assertTrue(
            FolderDragSessionPolicy.shouldExitHoverOpenedFolder(
                x = 70f,
                y = 120f,
                left = 100,
                top = 100,
                right = 300,
                bottom = 300,
                thresholdPx = 24,
                hasEnteredOpenFolder = true
            )
        )
    }

    @Test
    fun collisionPreview_movesOccupiedTargetIntoMovingCurrentCellLikeHomescreen() {
        val preview = FolderDragSessionPolicy.collisionPreview(
            movingCell = 0,
            targetCell = 2,
            occupiedCells = setOf(1, 2, 3),
            maxCells = 9
        )

        assertEquals(2, preview.movingCell)
        assertEquals(mapOf(2 to 0), preview.displacedCells)
    }

    @Test
    fun collisionPreview_canOverflowToNextFolderPageForExternalApp() {
        val preview = FolderDragSessionPolicy.collisionPreview(
            movingCell = null,
            targetCell = 8,
            occupiedCells = (0 until 9).toSet(),
            maxCells = 9
        )

        assertEquals(8, preview.movingCell)
        assertEquals(mapOf(8 to 9), preview.displacedCells)
    }

    @Test
    fun collisionPreview_doesNotShiftWhenTargetCellIsEmpty() {
        val preview = FolderDragSessionPolicy.collisionPreview(
            movingCell = 0,
            targetCell = 4,
            occupiedCells = setOf(1, 2, 3),
            maxCells = 9
        )

        assertEquals(4, preview.movingCell)
        assertTrue(preview.displacedCells.isEmpty())
    }

    @Test
    fun cellConversion_mapsAbsoluteCellsAcrossFolderPages() {
        assertEquals(14, FolderDragSessionPolicy.absoluteCell(page = 1, cell = 5))
        assertEquals(2, FolderDragSessionPolicy.pageForCell(22))
        assertEquals(4, FolderDragSessionPolicy.cellInPage(22))
    }

    @Test
    fun shouldRenderFolderItem_excludesMovingItemDuringDrag() {
        assertFalse(
            FolderDragSessionPolicy.shouldRenderFolderItem(
                itemIsMoving = true,
                folderDragActive = true
            )
        )
        assertTrue(
            FolderDragSessionPolicy.shouldRenderFolderItem(
                itemIsMoving = true,
                folderDragActive = false
            )
        )
        assertTrue(
            FolderDragSessionPolicy.shouldRenderFolderItem(
                itemIsMoving = false,
                folderDragActive = true
            )
        )
    }

    @Test
    fun shouldPreviewDropDuringPageScroll_onlyWhenTargetPageDoesNotExistYet() {
        assertFalse(
            FolderDragSessionPolicy.shouldPreviewDropDuringPageScroll(
                targetPage = 0,
                pageCount = 2
            )
        )
        assertFalse(
            FolderDragSessionPolicy.shouldPreviewDropDuringPageScroll(
                targetPage = 1,
                pageCount = 2
            )
        )
        assertTrue(
            FolderDragSessionPolicy.shouldPreviewDropDuringPageScroll(
                targetPage = 2,
                pageCount = 2
            )
        )
    }
}

package com.cloudx.ios17.features.launcher

object FolderDragSessionPolicy {
    const val FOLDER_COLUMNS = 3
    const val FOLDER_ROWS = 3
    const val ITEMS_PER_PAGE = FOLDER_COLUMNS * FOLDER_ROWS
    const val FOLDER_PAGE_SCROLL_ANIMATION_MS = 520

    data class FolderPlacement(
        val page: Int,
        val cell: Int
    )

    data class FolderCollisionPreview(
        val movingCell: Int,
        val displacedCells: Map<Int, Int>
    )

    fun absoluteCell(page: Int, cell: Int): Int =
        page.coerceAtLeast(0) * ITEMS_PER_PAGE + cell.coerceIn(0, ITEMS_PER_PAGE - 1)

    fun pageForCell(cell: Int): Int =
        cell.coerceAtLeast(0) / ITEMS_PER_PAGE

    fun cellInPage(cell: Int): Int =
        cell.coerceAtLeast(0) % ITEMS_PER_PAGE

    fun shouldRenderFolderItem(itemIsMoving: Boolean, folderDragActive: Boolean): Boolean =
        !folderDragActive || !itemIsMoving

    fun shouldPreviewDropDuringPageScroll(targetPage: Int, pageCount: Int): Boolean =
        targetPage >= pageCount.coerceAtLeast(1)

    fun firstAvailablePlacement(occupiedCells: Set<Int>, startPage: Int): FolderPlacement {
        var page = startPage.coerceAtLeast(0)
        while (true) {
            val pageStart = absoluteCell(page, 0)
            val availableCell = (0 until ITEMS_PER_PAGE)
                .firstOrNull { pageStart + it !in occupiedCells }
            if (availableCell != null) {
                return FolderPlacement(page, availableCell)
            }
            page++
        }
    }

    fun edgeTargetPage(
        x: Float,
        width: Int,
        currentPage: Int,
        pageCount: Int,
        edgeSizePx: Int
    ): Int {
        val safePageCount = pageCount.coerceAtLeast(1)
        val safeCurrentPage = currentPage.coerceIn(0, safePageCount - 1)
        val safeWidth = width.coerceAtLeast(1)
        val safeEdge = edgeSizePx.coerceAtLeast(1)
        return when {
            x <= safeEdge -> (safeCurrentPage - 1).coerceAtLeast(0)
            x >= safeWidth - safeEdge -> (safeCurrentPage + 1).coerceAtMost(safePageCount - 1)
            else -> safeCurrentPage
        }
    }

    fun shouldExitFolder(
        x: Float,
        y: Float,
        left: Int,
        top: Int,
        right: Int,
        bottom: Int,
        thresholdPx: Int
    ): Boolean {
        val threshold = thresholdPx.coerceAtLeast(0)
        return x < left - threshold ||
            x > right + threshold ||
            y < top - threshold ||
            y > bottom + threshold
    }

    fun collisionPreview(
        movingCell: Int?,
        targetCell: Int,
        occupiedCells: Set<Int>,
        maxCells: Int
    ): FolderCollisionPreview {
        val safeMax = maxCells.coerceAtLeast(1)
        val safeTargetCell = targetCell.coerceAtLeast(0)
        val occupiedWithoutMoving = movingCell?.let { occupiedCells - it } ?: occupiedCells
        if (safeTargetCell !in occupiedWithoutMoving) {
            return FolderCollisionPreview(
                movingCell = safeTargetCell,
                displacedCells = emptyMap()
            )
        }

        val displacedCell = if (movingCell != null && movingCell >= 0 && movingCell !in occupiedWithoutMoving) {
            movingCell
        } else {
            ((safeTargetCell + 1) until safeMax)
                .firstOrNull { it !in occupiedWithoutMoving }
                ?: safeMax
        }
        return FolderCollisionPreview(
            movingCell = safeTargetCell,
            displacedCells = mapOf(safeTargetCell to displacedCell)
        )
    }
}

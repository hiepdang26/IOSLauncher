package com.cloudx.ios17.features.launcher

import kotlin.math.abs

object LauncherHomeCellPolicy {
    const val DEFAULT_AUTO_REARRANGE_APPS = false

    data class GridPlacement(
        val row: Int,
        val column: Int
    )

    data class GridOffset(
        val left: Int,
        val top: Int
    )

    data class ManualLayout(
        val specRow: Int,
        val specColumn: Int,
        val left: Int,
        val top: Int
    )

    data class PageCell(
        val page: Int,
        val cell: Int
    )

    data class CollisionPreview(
        val movingCell: Int,
        val displacedCell: Int?
    )

    fun compactCell(childIndex: Int): Int {
        return childIndex.coerceAtLeast(0)
    }

    fun compactCells(itemCount: Int, maxCells: Int): List<Int> {
        val safeMax = maxCells.coerceAtLeast(0)
        val safeCount = itemCount.coerceIn(0, safeMax)
        return (0 until safeCount).toList()
    }

    fun shouldCompactCells(autoArrangeEnabled: Boolean, forceCompact: Boolean): Boolean {
        return autoArrangeEnabled || forceCompact
    }

    fun displacedCellForCollision(
        movingOriginalCell: Int,
        targetCell: Int,
        occupiedCells: Set<Int>,
        maxCells: Int
    ): Int {
        val safeMax = maxCells.coerceAtLeast(1)
        val blockedCells = occupiedCells
        if (movingOriginalCell in 0 until safeMax && movingOriginalCell !in blockedCells) {
            return movingOriginalCell
        }
        val anchorCell = movingOriginalCell.takeIf { it in 0 until safeMax } ?: targetCell
        return (0 until safeMax)
            .filter { it !in blockedCells }
            .minWithOrNull(compareBy<Int> { kotlin.math.abs(it - anchorCell) }.thenBy { it })
            ?: targetCell.coerceIn(0, safeMax - 1)
    }

    fun collisionPreview(
        movingCurrentCell: Int,
        targetCell: Int,
        occupiedCells: Set<Int>,
        maxCells: Int
    ): CollisionPreview {
        val safeMax = maxCells.coerceAtLeast(1)
        val safeTargetCell = targetCell.coerceIn(0, safeMax - 1)
        val displacedCell = if (safeTargetCell in occupiedCells) {
            displacedCellForCollision(
                movingOriginalCell = movingCurrentCell,
                targetCell = safeTargetCell,
                occupiedCells = occupiedCells,
                maxCells = safeMax
            )
        } else {
            null
        }
        return CollisionPreview(
            movingCell = safeTargetCell,
            displacedCell = displacedCell
        )
    }

    fun folderCreationCell(targetCell: Int, targetIndex: Int, maxCells: Int): Int {
        val safeMax = maxCells.coerceAtLeast(1)
        if (targetCell in 0 until safeMax) {
            return targetCell
        }
        return targetIndex.coerceIn(0, safeMax - 1)
    }

    fun gridPlacementForCell(cell: Int, columns: Int): GridPlacement {
        val safeColumns = columns.coerceAtLeast(1)
        val safeCell = cell.coerceAtLeast(0)
        return GridPlacement(
            row = safeCell / safeColumns,
            column = safeCell % safeColumns
        )
    }

    fun dropCell(
        dropX: Float,
        dropY: Float,
        gridLeft: Int,
        gridTop: Int,
        paddingLeft: Int,
        paddingTop: Int,
        cellWidth: Int,
        cellHeight: Int,
        rows: Int,
        columns: Int
    ): Int {
        val safeRows = rows.coerceAtLeast(1)
        val safeColumns = columns.coerceAtLeast(1)
        val safeCellWidth = cellWidth.coerceAtLeast(1)
        val safeCellHeight = cellHeight.coerceAtLeast(1)
        val column = ((dropX - gridLeft - paddingLeft) / safeCellWidth)
            .toInt()
            .coerceIn(0, safeColumns - 1)
        val row = ((dropY - gridTop - paddingTop) / safeCellHeight)
            .toInt()
            .coerceIn(0, safeRows - 1)
        return row * safeColumns + column
    }

    fun gridOffsetForCell(
        cell: Int,
        columns: Int,
        cellWidth: Int,
        cellHeight: Int
    ): GridOffset {
        val placement = gridPlacementForCell(cell, columns)
        return GridOffset(
            left = placement.column * cellWidth.coerceAtLeast(0),
            top = placement.row * cellHeight.coerceAtLeast(0)
        )
    }

    fun manualLayoutForCell(
        cell: Int,
        columns: Int,
        cellWidth: Int,
        cellHeight: Int
    ): ManualLayout {
        val offset = gridOffsetForCell(
            cell = cell,
            columns = columns,
            cellWidth = cellWidth,
            cellHeight = cellHeight
        )
        return ManualLayout(
            specRow = 0,
            specColumn = 0,
            left = offset.left,
            top = offset.top
        )
    }

    fun cellHeightForPage(
        workspaceHeight: Int,
        normalTopPadding: Int,
        currentTopPadding: Int,
        rows: Int,
        maxCellHeight: Int
    ): Int {
        val safeRows = rows.coerceAtLeast(1)
        val boundedWorkspaceHeight = (
            workspaceHeight +
                normalTopPadding -
                currentTopPadding
            ).coerceAtLeast(safeRows)
        return (boundedWorkspaceHeight / safeRows)
            .coerceIn(1, maxCellHeight.coerceAtLeast(1))
    }

    fun nextAppendCell(occupiedCells: Set<Int>, maxCells: Int): Int? {
        val safeMax = maxCells.coerceAtLeast(0)
        if (safeMax == 0) {
            return null
        }
        val appendCell = (occupiedCells.maxOrNull() ?: -1) + 1
        return appendCell.takeIf { it in 0 until safeMax }
    }

    fun resolveCell(
        preferredCell: Int,
        requestedIndex: Int,
        occupiedCells: Set<Int>,
        maxCells: Int
    ): Int {
        val safeMax = maxCells.coerceAtLeast(1)
        if (preferredCell in 0 until safeMax && preferredCell !in occupiedCells) {
            return preferredCell
        }
        if (requestedIndex in 0 until safeMax && requestedIndex !in occupiedCells) {
            return requestedIndex
        }

        nextAppendCell(occupiedCells, safeMax)?.let { return it }

        return (0 until safeMax).firstOrNull { it !in occupiedCells } ?: (safeMax - 1)
    }

    fun resolvePageCell(
        preferredPage: Int,
        preferredCell: Int,
        occupiedCellsByPage: Map<Int, Set<Int>>,
        maxCells: Int
    ): PageCell {
        val safeMax = maxCells.coerceAtLeast(1)
        val startPage = preferredPage.coerceAtLeast(0)

        if (preferredCell in 0 until safeMax &&
            preferredCell !in occupiedCellsByPage[startPage].orEmpty()
        ) {
            return PageCell(startPage, preferredCell)
        }

        var page = startPage
        while (true) {
            val occupiedCells = occupiedCellsByPage[page].orEmpty()
            val cell = (0 until safeMax).firstOrNull { it !in occupiedCells }
            if (cell != null) {
                return PageCell(page, cell)
            }
            page++
        }
    }

    fun newItemPlacement(
        preferredPage: Int,
        existingPageCount: Int,
        occupiedCellsByPage: Map<Int, Set<Int>>,
        maxCells: Int
    ): PageCell {
        val safeMax = maxCells.coerceAtLeast(1)
        val safePageCount = existingPageCount.coerceAtLeast(0)
        if (safePageCount == 0) {
            return PageCell(0, 0)
        }

        val safePreferredPage = preferredPage.coerceIn(0, safePageCount - 1)
        val candidatePages = (0 until safePageCount)
            .sortedWith(
                compareBy<Int> { abs(it - safePreferredPage) }
                    .thenBy { if (it < safePreferredPage) 1 else 0 }
                    .thenBy { it }
            )
        for (page in candidatePages) {
            val occupiedCells = occupiedCellsByPage[page].orEmpty()
            val cell = (0 until safeMax).firstOrNull { it !in occupiedCells }
            if (cell != null) {
                return PageCell(page, cell)
            }
        }
        return PageCell(safePageCount, 0)
    }
}

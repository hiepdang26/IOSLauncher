package com.cloudx.ios17.features.launcher

object HomeWidgetPlacementPolicy {
    enum class WidgetSize {
        SMALL,
        FULL_WIDTH
    }

    data class Span(
        val columns: Int,
        val rows: Int
    )

    data class Placement(
        val anchorCell: Int,
        val occupiedCells: Set<Int>
    )

    fun spanFor(size: WidgetSize, columns: Int): Span {
        val safeColumns = columns.coerceAtLeast(1)
        return when (size) {
            WidgetSize.SMALL -> Span(
                columns = minOf(2, safeColumns),
                rows = 2
            )
            WidgetSize.FULL_WIDTH -> Span(
                columns = safeColumns,
                rows = 2
            )
        }
    }

    fun placementForDropCell(
        dropCell: Int,
        size: WidgetSize,
        columns: Int,
        maxCells: Int,
        occupiedCells: Set<Int>
    ): Placement? {
        val safeColumns = columns.coerceAtLeast(1)
        val safeMaxCells = maxCells.coerceAtLeast(0)
        if (safeMaxCells == 0) {
            return null
        }

        val span = spanFor(size, safeColumns)
        val rows = (safeMaxCells + safeColumns - 1) / safeColumns
        if (rows < span.rows) {
            return null
        }

        val safeDropCell = dropCell.coerceIn(0, safeMaxCells - 1)
        val dropRow = safeDropCell / safeColumns
        val dropColumn = safeDropCell % safeColumns
        val anchorRow = dropRow.coerceIn(0, rows - span.rows)
        val anchorColumn = dropColumn.coerceIn(0, safeColumns - span.columns)
        val anchorCell = anchorRow * safeColumns + anchorColumn
        val cells = occupiedCellsFor(anchorCell, span, safeColumns, safeMaxCells) ?: return null
        if (cells.any { it in occupiedCells }) {
            return null
        }
        return Placement(anchorCell, cells)
    }

    fun placementForCenteredDropCell(
        dropCell: Int,
        size: WidgetSize,
        columns: Int,
        maxCells: Int,
        occupiedCells: Set<Int>
    ): Placement? {
        val safeColumns = columns.coerceAtLeast(1)
        val safeMaxCells = maxCells.coerceAtLeast(0)
        if (safeMaxCells == 0) {
            return null
        }

        val span = spanFor(size, safeColumns)
        val rows = (safeMaxCells + safeColumns - 1) / safeColumns
        if (rows < span.rows) {
            return null
        }

        val safeDropCell = dropCell.coerceIn(0, safeMaxCells - 1)
        val dropRow = safeDropCell / safeColumns
        val dropColumn = safeDropCell % safeColumns
        val centeredAnchorRow = (dropRow - span.rows / 2).coerceIn(0, rows - span.rows)
        val centeredAnchorColumn = (dropColumn - span.columns / 2).coerceIn(0, safeColumns - span.columns)
        val topLeftAnchorRow = dropRow.coerceIn(0, rows - span.rows)
        val topLeftAnchorColumn = dropColumn.coerceIn(0, safeColumns - span.columns)

        return sequenceOf(
            centeredAnchorRow to centeredAnchorColumn,
            topLeftAnchorRow to topLeftAnchorColumn
        ).distinct().firstNotNullOfOrNull { (row, column) ->
            placementForAnchor(
                anchorCell = row * safeColumns + column,
                span = span,
                columns = safeColumns,
                maxCells = safeMaxCells,
                occupiedCells = occupiedCells
            )
        }
    }

    private fun placementForAnchor(
        anchorCell: Int,
        span: Span,
        columns: Int,
        maxCells: Int,
        occupiedCells: Set<Int>
    ): Placement? {
        val cells = occupiedCellsFor(anchorCell, span, columns, maxCells) ?: return null
        if (cells.any { it in occupiedCells }) {
            return null
        }
        return Placement(anchorCell, cells)
    }

    fun occupiedCellsFor(
        anchorCell: Int,
        span: Span,
        columns: Int,
        maxCells: Int
    ): Set<Int>? {
        val safeColumns = columns.coerceAtLeast(1)
        val safeMaxCells = maxCells.coerceAtLeast(0)
        if (safeMaxCells == 0) {
            return null
        }

        val anchor = anchorCell.coerceAtLeast(0)
        val anchorRow = anchor / safeColumns
        val anchorColumn = anchor % safeColumns
        if (anchorColumn + span.columns > safeColumns) {
            return null
        }

        val cells = linkedSetOf<Int>()
        repeat(span.rows) { rowOffset ->
            repeat(span.columns) { columnOffset ->
                val cell = (anchorRow + rowOffset) * safeColumns + anchorColumn + columnOffset
                if (cell !in 0 until safeMaxCells) {
                    return null
                }
                cells.add(cell)
            }
        }
        return cells
    }
}

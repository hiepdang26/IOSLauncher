package com.vhmsoft.launcherios26.ui.launcher.workspace

internal object LauncherPagedFolderGridPolicy {
    const val COLUMNS = 3
    const val ROWS = 3
    const val ITEMS_PER_PAGE = COLUMNS * ROWS

    data class CellPosition(
        val page: Int,
        val row: Int,
        val column: Int
    )

    fun pageCount(
        itemCount: Int,
        columns: Int = COLUMNS,
        rows: Int = ROWS
    ): Int {
        if (itemCount <= 0) return 0

        val pageSize = (columns * rows).coerceAtLeast(1)
        return (itemCount + pageSize - 1) / pageSize
    }

    fun cellPosition(
        index: Int,
        columns: Int = COLUMNS,
        rows: Int = ROWS
    ): CellPosition {
        require(index >= 0) { "index must be non-negative" }

        val pageSize = (columns * rows).coerceAtLeast(1)
        val indexInPage = index % pageSize
        return CellPosition(
            page = index / pageSize,
            row = indexInPage / columns,
            column = indexInPage % columns
        )
    }
}

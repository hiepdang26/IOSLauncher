package com.vhmsoft.launcherios26.ui.launcher.workspace

internal object LauncherHomeScreenGridPolicy {
    fun pageSize(rows: Int, columns: Int): Int {
        return rows.coerceAtLeast(1) * columns.coerceAtLeast(1)
    }

    fun <T> replacePage(
        pages: List<List<T>>,
        pagePosition: Int,
        pageItems: List<T>,
        pageSize: Int
    ): List<T> {
        if (pagePosition !in pages.indices) return pages.flatten()

        val capacity = pageSize.coerceAtLeast(1)
        val constrainedPage = pageItems.take(capacity)
        val overflow = pageItems.drop(capacity)
        val flattened = mutableListOf<T>()

        pages.forEachIndexed { index, page ->
            when (index) {
                pagePosition -> flattened += constrainedPage
                pagePosition + 1 -> {
                    flattened += overflow
                    flattened += page
                }
                else -> flattened += page
            }
        }
        if (pagePosition == pages.lastIndex) {
            flattened += overflow
        }
        return flattened
    }

    fun blankDropPosition(
        draggedCenterX: Float,
        draggedCenterY: Float,
        gridWidth: Int,
        gridHeight: Int,
        rows: Int,
        columns: Int,
        itemCount: Int
    ): Int {
        if (gridWidth <= 0 || gridHeight <= 0 || itemCount <= 0) return NO_POSITION
        if (draggedCenterX < 0f ||
            draggedCenterX > gridWidth ||
            draggedCenterY < 0f ||
            draggedCenterY > gridHeight
        ) {
            return NO_POSITION
        }

        val safeRows = rows.coerceAtLeast(1)
        val safeColumns = columns.coerceAtLeast(1)
        val capacity = pageSize(safeRows, safeColumns)
        if (itemCount > capacity) return capacity - 1

        val cellWidth = gridWidth / safeColumns.toFloat()
        val cellHeight = gridHeight / safeRows.toFloat()
        val column = (draggedCenterX / cellWidth).toInt().coerceIn(0, safeColumns - 1)
        val row = (draggedCenterY / cellHeight).toInt().coerceIn(0, safeRows - 1)
        val gridIndex = row * safeColumns + column
        if (gridIndex < itemCount) return NO_POSITION

        return (itemCount - 1).coerceIn(0, capacity - 1)
    }

    const val NO_POSITION = -1
}

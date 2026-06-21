package com.vhmsoft.launcherios26.ui.launcher.workspace

internal object LauncherHomeIconMovePolicy {
    private const val DEFAULT_COLUMNS = 4
    private const val DEFAULT_ROWS = 6

    fun moveExistingItem(
        items: List<LauncherHomeItemUiModel>,
        draggedStableId: Long,
        targetIndex: Int,
        columns: Int = DEFAULT_COLUMNS,
        rows: Int = DEFAULT_ROWS
    ): List<LauncherHomeItemUiModel>? {
        val fromIndex = items.indexOfFirst { item -> item.stableId == draggedStableId }
        if (fromIndex == -1 || targetIndex !in items.indices || fromIndex == targetIndex) {
            return null
        }

        plusLineMove(items, fromIndex, targetIndex, columns, rows)?.let { movedItems ->
            return LauncherHomeLayoutBuilder.normalize(movedItems)
        }

        val movedItems = items.toMutableList()
        val draggedItem = movedItems[fromIndex]
        movedItems[fromIndex] = movedItems[targetIndex]
        movedItems[targetIndex] = draggedItem

        return LauncherHomeLayoutBuilder.normalize(movedItems)
    }

    private fun plusLineMove(
        items: List<LauncherHomeItemUiModel>,
        fromIndex: Int,
        targetIndex: Int,
        columns: Int,
        rows: Int
    ): List<LauncherHomeItemUiModel>? {
        val boundedColumns = columns.coerceAtLeast(1)
        val boundedRows = rows.coerceAtLeast(1)
        val pageSize = boundedColumns * boundedRows
        val fromPage = fromIndex / pageSize
        val targetPage = targetIndex / pageSize
        if (fromPage != targetPage) return null

        val pageStart = fromPage * pageSize
        val fromOffset = fromIndex - pageStart
        val targetOffset = targetIndex - pageStart
        val fromRow = fromOffset / boundedColumns
        val targetRow = targetOffset / boundedColumns
        val fromColumn = fromOffset % boundedColumns
        val targetColumn = targetOffset % boundedColumns

        val linePositions = when {
            fromRow == targetRow -> {
                val rowStart = pageStart + fromRow * boundedColumns
                (0 until boundedColumns).map { column -> rowStart + column }
            }

            fromColumn == targetColumn -> {
                (0 until boundedRows).map { row ->
                    pageStart + row * boundedColumns + fromColumn
                }
            }

            else -> return null
        }.filter { index -> index in items.indices }

        val fromLineIndex = linePositions.indexOf(fromIndex)
        val targetLineIndex = linePositions.indexOf(targetIndex)
        if (fromLineIndex == -1 || targetLineIndex == -1 || fromLineIndex == targetLineIndex) {
            return null
        }

        val movedItems = items.toMutableList()
        val draggedItem = movedItems[fromIndex]
        if (fromLineIndex < targetLineIndex) {
            for (index in fromLineIndex until targetLineIndex) {
                movedItems[linePositions[index]] = movedItems[linePositions[index + 1]]
            }
        } else {
            for (index in fromLineIndex downTo targetLineIndex + 1) {
                movedItems[linePositions[index]] = movedItems[linePositions[index - 1]]
            }
        }
        movedItems[targetIndex] = draggedItem
        return movedItems
    }
}

package com.vhmsoft.launcherios26.ui.launcher.workspace

internal object LauncherHomeScreenGridPolicy {
    fun pageSize(rows: Int, columns: Int): Int {
        return rows.coerceAtLeast(1) * columns.coerceAtLeast(1)
    }

    fun removeEmptyPages(
        items: List<LauncherHomeItemUiModel>,
        pageSize: Int
    ): List<LauncherHomeItemUiModel> {
        val capacity = pageSize.coerceAtLeast(1)
        return items.chunked(capacity)
            .filter { page -> page.any { item -> item.hasHomeIcon() } }
            .flatten()
            .let { visiblePages -> LauncherHomeLayoutBuilder.normalize(visiblePages) }
    }

    fun padToFullPages(
        items: List<LauncherHomeItemUiModel>,
        pageSize: Int,
        preserveEmptyPages: Boolean = false
    ): List<LauncherHomeItemUiModel> {
        val capacity = pageSize.coerceAtLeast(1)
        val normalized = if (preserveEmptyPages) {
            LauncherHomeLayoutBuilder.normalize(items)
        } else {
            removeEmptyPages(items, capacity)
        }
        if (normalized.isEmpty()) return emptyList()

        val requiredSize = ((normalized.size + capacity - 1) / capacity) * capacity
        return normalized.withPlaceholdersUntil(requiredSize)
    }

    fun ensurePageExists(
        items: List<LauncherHomeItemUiModel>,
        page: Int,
        pageSize: Int
    ): List<LauncherHomeItemUiModel> {
        val capacity = pageSize.coerceAtLeast(1)
        val requiredSize = (page.coerceAtLeast(0) + 1) * capacity
        return LauncherHomeLayoutBuilder.normalize(items)
            .withPlaceholdersUntil(requiredSize)
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
        itemCount: Int,
        isBlankAtPosition: (Int) -> Boolean = { false }
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
        if (gridIndex < itemCount) {
            return if (isBlankAtPosition(gridIndex)) gridIndex else NO_POSITION
        }

        return gridIndex.coerceIn(0, capacity - 1)
    }

    const val NO_POSITION = -1

    private fun List<LauncherHomeItemUiModel>.withPlaceholdersUntil(
        targetSize: Int
    ): List<LauncherHomeItemUiModel> {
        if (size >= targetSize) return this

        return toMutableList().apply {
            while (size < targetSize) {
                add(LauncherHomeItemUiModel.Placeholder.forGridIndex(size))
            }
        }
    }

    private fun LauncherHomeItemUiModel.hasHomeIcon(): Boolean {
        return when (this) {
            is LauncherHomeItemUiModel.App -> true
            is LauncherHomeItemUiModel.Folder -> apps.isNotEmpty()
            is LauncherHomeItemUiModel.Placeholder -> false
        }
    }
}

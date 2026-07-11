package com.vhmsoft.launcherios26.features.launcher

object HomeWidgetDisplacementPolicy {

    data class WidgetBlock<T>(
        val id: T,
        val anchorCell: Int,
        val span: HomeWidgetPlacementPolicy.Span
    )

    fun <T> displacedAppCells(
        appCells: Map<T, Int>,
        widgetCells: Set<Int>,
        reservedCells: Set<Int>,
        maxCells: Int
    ): Map<T, Int>? {
        if (maxCells <= 0 || widgetCells.isEmpty()) {
            return emptyMap()
        }

        val coveredApps = appCells
            .filterValues { it in widgetCells }
            .entries
            .sortedBy { it.value }
        if (coveredApps.isEmpty()) {
            return emptyMap()
        }

        val appByCell = appCells.entries
            .filter { it.value in 0 until maxCells }
            .sortedBy { it.value }
            .associate { it.value to it.key }
        val displaced = linkedMapOf<T, Int>()
        val pendingApps = ArrayDeque<T>()
        val firstWidgetCell = widgetCells.minOrNull() ?: return emptyMap()

        for (cell in firstWidgetCell until maxCells) {
            val appAtCell = appByCell[cell]
            if (cell in widgetCells) {
                if (appAtCell != null) {
                    pendingApps.addLast(appAtCell)
                }
                continue
            }
            if (cell in reservedCells) {
                continue
            }
            if (pendingApps.isNotEmpty()) {
                if (appAtCell != null) {
                    pendingApps.addLast(appAtCell)
                }
                displaced[pendingApps.removeFirst()] = cell
            }
        }

        if (pendingApps.isNotEmpty()) {
            for (cell in firstWidgetCell - 1 downTo 0) {
                if (cell in reservedCells || cell in widgetCells || cell in appByCell) {
                    continue
                }
                displaced[pendingApps.removeFirst()] = cell
                if (pendingApps.isEmpty()) {
                    break
                }
            }
        }

        if (pendingApps.isNotEmpty()) {
            return null
        }

        return displaced
            .filter { (app, cell) -> appCells[app] != cell }
            .toMap()
    }

    fun <T> displacedWidgetCells(
        widgets: List<WidgetBlock<T>>,
        draggedWidgetCells: Set<Int>,
        reservedCells: Set<Int>,
        columns: Int,
        maxCells: Int
    ): Map<T, Int>? {
        val safeColumns = columns.coerceAtLeast(1)
        if (maxCells <= 0 || draggedWidgetCells.isEmpty()) {
            return emptyMap()
        }

        val widgetCells = widgets.mapNotNull { block ->
            val cells = HomeWidgetPlacementPolicy.occupiedCellsFor(
                anchorCell = block.anchorCell,
                span = block.span,
                columns = safeColumns,
                maxCells = maxCells
            ) ?: return@mapNotNull null
            block to cells
        }
        val coveredWidgets = widgetCells
            .filter { (_, cells) -> cells.any { it in draggedWidgetCells } }
            .sortedBy { (block, _) -> block.anchorCell }
        if (coveredWidgets.isEmpty()) {
            return emptyMap()
        }

        val coveredIds = coveredWidgets.map { (block, _) -> block.id }.toSet()
        val occupiedCells = linkedSetOf<Int>().apply {
            addAll(reservedCells)
            addAll(draggedWidgetCells)
            widgetCells
                .filter { (block, _) -> block.id !in coveredIds }
                .forEach { (_, cells) -> addAll(cells) }
        }

        val displaced = linkedMapOf<T, Int>()
        coveredWidgets.forEach { (block, _) ->
            val candidate = nearestFreeWidgetAnchor(
                block = block,
                occupiedCells = occupiedCells,
                columns = safeColumns,
                maxCells = maxCells,
                preferredStartCell = draggedWidgetCells.minOrNull() ?: block.anchorCell
            ) ?: return null
            val candidateCells = HomeWidgetPlacementPolicy.occupiedCellsFor(
                anchorCell = candidate,
                span = block.span,
                columns = safeColumns,
                maxCells = maxCells
            ) ?: return null
            occupiedCells.addAll(candidateCells)
            if (candidate != block.anchorCell) {
                displaced[block.id] = candidate
            }
        }

        return displaced
    }

    private fun <T> nearestFreeWidgetAnchor(
        block: WidgetBlock<T>,
        occupiedCells: Set<Int>,
        columns: Int,
        maxCells: Int,
        preferredStartCell: Int
    ): Int? {
        return (0 until maxCells)
            .mapNotNull { anchorCell ->
                val cells = HomeWidgetPlacementPolicy.occupiedCellsFor(
                    anchorCell = anchorCell,
                    span = block.span,
                    columns = columns,
                    maxCells = maxCells
                ) ?: return@mapNotNull null
                if (cells.any { it in occupiedCells }) {
                    return@mapNotNull null
                }
                anchorCell
            }
            .minWithOrNull(
                compareBy<Int> { if (it >= preferredStartCell) 0 else 1 }
                    .thenBy { gridDistance(it, block.anchorCell, columns) }
                    .thenBy { kotlin.math.abs(it - block.anchorCell) }
                    .thenBy { it }
            )
    }

    private fun gridDistance(
        firstCell: Int,
        secondCell: Int,
        columns: Int
    ): Int {
        val firstRow = firstCell / columns
        val firstColumn = firstCell % columns
        val secondRow = secondCell / columns
        val secondColumn = secondCell % columns
        return kotlin.math.abs(firstRow - secondRow) + kotlin.math.abs(firstColumn - secondColumn)
    }
}

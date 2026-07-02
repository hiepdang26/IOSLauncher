package com.cloudx.ios17.features.launcher

object HomeWidgetMergePolicy {

    fun upsert(
        items: List<HomeWidgetPreferences.Item>,
        item: HomeWidgetPreferences.Item
    ): MutableList<HomeWidgetPreferences.Item> {
        return (items.filter { it.id != item.id } + item).toMutableList()
    }

    fun normalize(
        items: List<HomeWidgetPreferences.Item>,
        columnsForPage: (Int) -> Int,
        maxCellsForPage: (Int) -> Int
    ): MutableList<HomeWidgetPreferences.Item> {
        val byId = linkedMapOf<String, HomeWidgetPreferences.Item>()
        items.forEach { item -> byId[item.id] = item }

        val occupiedByPage = linkedMapOf<Int, MutableSet<Int>>()
        val normalized = mutableListOf<HomeWidgetPreferences.Item>()
        byId.values
            .sortedWith(compareBy<HomeWidgetPreferences.Item> { it.page }.thenBy { it.cell })
            .forEach { item ->
                val columns = columnsForPage(item.page).coerceAtLeast(1)
                val maxCells = maxCellsForPage(item.page).coerceAtLeast(0)
                val span = HomeWidgetPlacementPolicy.spanFor(item.size, columns)
                val occupiedCells = HomeWidgetPlacementPolicy.occupiedCellsFor(
                    anchorCell = item.cell,
                    span = span,
                    columns = columns,
                    maxCells = maxCells
                ) ?: return@forEach
                val pageOccupied = occupiedByPage.getOrPut(item.page) { linkedSetOf() }
                if (occupiedCells.any { it in pageOccupied }) {
                    return@forEach
                }
                pageOccupied.addAll(occupiedCells)
                normalized.add(item)
            }
        return normalized
    }
}

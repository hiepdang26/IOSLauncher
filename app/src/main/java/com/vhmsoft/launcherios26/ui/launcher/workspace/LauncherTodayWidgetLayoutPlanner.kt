package com.vhmsoft.launcherios26.ui.launcher.workspace

internal enum class LauncherTodayWidgetSize {
    SMALL,
    WIDE
}

internal object LauncherTodayWidgetLayoutPlanner {
    fun rows(sizes: List<LauncherTodayWidgetSize>): List<List<Int>> {
        val rows = mutableListOf<List<Int>>()
        val pendingSmall = mutableListOf<Int>()

        sizes.forEachIndexed { index, size ->
            if (size == LauncherTodayWidgetSize.SMALL) {
                pendingSmall += index
                if (pendingSmall.size == SMALL_WIDGETS_PER_ROW) {
                    rows += pendingSmall.toList()
                    pendingSmall.clear()
                }
            } else {
                if (pendingSmall.isNotEmpty()) {
                    rows += pendingSmall.toList()
                    pendingSmall.clear()
                }
                rows += listOf(index)
            }
        }

        if (pendingSmall.isNotEmpty()) {
            rows += pendingSmall.toList()
        }


        return rows
    }

    fun <T> move(items: List<T>, fromIndex: Int, toIndex: Int): List<T> {
        if (fromIndex !in items.indices) return items
        if (items.isEmpty()) return items

        val mutableItems = items.toMutableList()
        val item = mutableItems.removeAt(fromIndex)
        mutableItems.add(toIndex.coerceIn(0, mutableItems.size), item)
        return mutableItems
    }

    private const val SMALL_WIDGETS_PER_ROW = 2
}

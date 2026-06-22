package com.cloudx.ios17.features.launcher

object LauncherSearchResultPolicy {
    const val GRID_COLUMNS = 4
    const val EMPTY_QUERY_SUGGESTION_LIMIT = 8
    const val QUERY_RESULT_LIMIT = 16

    fun rowCountFor(itemCount: Int): Int {
        return ((itemCount + GRID_COLUMNS - 1) / GRID_COLUMNS).coerceAtLeast(1)
    }
}

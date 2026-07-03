package com.cloudx.ios17.features.launcher

object LayoutGridPreviewPolicy {
    data class GridSpec(
        val rows: Int,
        val columns: Int,
        val cellCount: Int
    )

    fun previewSpec(rows: Int): GridSpec {
        val safeRows = rows.coerceAtLeast(1)
        return GridSpec(
            rows = safeRows,
            columns = HOME_GRID_PREVIEW_COLUMNS,
            cellCount = safeRows * HOME_GRID_PREVIEW_COLUMNS
        )
    }

    private const val HOME_GRID_PREVIEW_COLUMNS = 4
}

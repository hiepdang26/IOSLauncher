package com.vhmsoft.launcherios26.features.launcher

object HomeWidgetPickerPreviewPolicy {

    fun previewHeight(
        homeCellHeightPx: Int,
        fallbackHeightPx: Int,
        safetyInsetPx: Int = 0
    ): Int {
        val baseHeight = maxOf(fallbackHeightPx, homeCellHeightPx.coerceAtLeast(1) * 2)
        return baseHeight
    }

    fun gridPreviewHeight(
        contentWidthPx: Int,
        columns: Int,
        rows: Int,
        cardsInRow: Int,
        horizontalMarginsPx: Int,
        minimumHeightPx: Int
    ): Int {
        val safeColumns = columns.coerceAtLeast(1)
        val safeRows = rows.coerceAtLeast(1)
        val safeCardsInRow = cardsInRow.coerceAtLeast(1)
        val cardWidth = (contentWidthPx - horizontalMarginsPx.coerceAtLeast(0))
            .coerceAtLeast(safeCardsInRow) / safeCardsInRow
        val gridHeight = cardWidth * safeRows / safeColumns
        return maxOf(minimumHeightPx.coerceAtLeast(0), gridHeight)
    }
}

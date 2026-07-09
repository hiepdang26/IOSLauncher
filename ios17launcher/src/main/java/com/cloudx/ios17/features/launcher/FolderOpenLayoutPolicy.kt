package com.cloudx.ios17.features.launcher

import kotlin.math.max
import kotlin.math.roundToInt

object FolderOpenLayoutPolicy {
    private const val PANEL_WIDTH_RATIO = 0.78f
    private const val MIN_PANEL_WIDTH_DP = 312
    private const val HORIZONTAL_MARGIN_DP = 24
    private const val CELL_EXTRA_HEIGHT_DP = 20
    private const val INDICATOR_HEIGHT_DP = 28
    private const val TITLE_BOTTOM_GAP_DP = 40
    private const val CORNER_RADIUS_DP = 42
    private const val TITLE_TEXT_SIZE_SP = 40f
    const val BACKGROUND_CONTENT_ALPHA = 0.16f

    data class Metrics(
        val panelWidth: Int,
        val panelHeight: Int,
        val cellWidth: Int,
        val cellHeight: Int,
        val gridHeight: Int,
        val indicatorHeight: Int,
        val titleBottomGap: Int,
        val cornerRadius: Int,
        val titleTextSizeSp: Float
    )

    fun metrics(
        availableWidth: Int,
        availableHeight: Int,
        homeCellHeight: Int,
        iconSize: Int,
        density: Float
    ): Metrics {
        val maxPanelWidth = max(0, availableWidth - dp(HORIZONTAL_MARGIN_DP * 2, density))
        val preferredPanelWidth = (availableWidth * PANEL_WIDTH_RATIO).roundToInt()
        val minPanelWidth = dp(MIN_PANEL_WIDTH_DP, density)
        val panelWidth = preferredPanelWidth.coerceAtLeast(minPanelWidth).coerceAtMost(maxPanelWidth)
        val cellWidth = panelWidth / 3
        val indicatorHeight = dp(INDICATOR_HEIGHT_DP, density)
        val maxCellHeight = max(1, (availableHeight - indicatorHeight) / 3)
        val cellHeight = max(homeCellHeight, max(iconSize, cellWidth) + dp(CELL_EXTRA_HEIGHT_DP, density))
            .coerceAtMost(maxCellHeight)
        val gridHeight = cellHeight * 3
        return Metrics(
            panelWidth = panelWidth,
            panelHeight = gridHeight + indicatorHeight,
            cellWidth = cellWidth,
            cellHeight = cellHeight,
            gridHeight = gridHeight,
            indicatorHeight = indicatorHeight,
            titleBottomGap = dp(TITLE_BOTTOM_GAP_DP, density),
            cornerRadius = dp(CORNER_RADIUS_DP, density),
            titleTextSizeSp = TITLE_TEXT_SIZE_SP
        )
    }

    private fun dp(value: Int, density: Float): Int = (value * density).roundToInt()
}

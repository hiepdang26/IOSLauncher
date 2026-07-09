package com.cloudx.ios17.features.launcher

object HomeWidgetProviderPreviewPolicy {
    fun sizeText(minWidthDp: Int, minHeightDp: Int): String {
        return "${gridSpan(minWidthDp)} x ${gridSpan(minHeightDp)}"
    }

    fun homeWidgetSize(minWidthDp: Int, minHeightDp: Int): HomeWidgetPlacementPolicy.WidgetSize {
        val columns = gridSpan(minWidthDp).coerceAtLeast(MIN_HOME_WIDGET_SPAN)
        val rows = gridSpan(minHeightDp).coerceAtLeast(MIN_HOME_WIDGET_SPAN)
        return when {
            columns >= LARGE_HOME_WIDGET_SPAN && rows >= LARGE_HOME_WIDGET_SPAN ->
                HomeWidgetPlacementPolicy.WidgetSize.LARGE
            columns >= LARGE_HOME_WIDGET_SPAN ->
                HomeWidgetPlacementPolicy.WidgetSize.FULL_WIDTH
            rows >= LARGE_HOME_WIDGET_SPAN ->
                HomeWidgetPlacementPolicy.WidgetSize.TALL
            else ->
                HomeWidgetPlacementPolicy.WidgetSize.SMALL
        }
    }

    fun pickerHeight(
        screenHeightPx: Int,
        topClearancePx: Int,
        preferredHeightPx: Int,
        bottomOverflowPx: Int = 0
    ): Int {
        val overflow = bottomOverflowPx.coerceAtLeast(0)
        val maxHeight = (screenHeightPx + overflow - topClearancePx.coerceAtLeast(0)).coerceAtLeast(0)
        return (preferredHeightPx.coerceAtLeast(0) + overflow).coerceAtMost(maxHeight)
    }

    fun pickerTopClearance(
        anchorBottomOnScreenPx: Int?,
        rootTopOnScreenPx: Int,
        fallbackPx: Int,
        marginPx: Int
    ): Int {
        val fallback = fallbackPx.coerceAtLeast(0)
        val anchorBottom = anchorBottomOnScreenPx ?: return fallback
        return (anchorBottom - rootTopOnScreenPx + marginPx.coerceAtLeast(0)).coerceAtLeast(fallback)
    }

    fun visibleAppCount(totalApps: Int, hasSearchQuery: Boolean): Int =
        totalApps.coerceAtLeast(0)

    fun compactAppListLimit(): Int = COMPACT_APP_LIST_LIMIT

    private fun gridSpan(sizeDp: Int): Int {
        return when {
            sizeDp >= LARGE_SPAN_MIN_DP -> 4
            sizeDp >= MEDIUM_SPAN_MIN_DP -> 2
            else -> 1
        }
    }

    private const val MEDIUM_SPAN_MIN_DP = 120
    private const val LARGE_SPAN_MIN_DP = 260
    private const val MIN_HOME_WIDGET_SPAN = 2
    private const val LARGE_HOME_WIDGET_SPAN = 4
    private const val COMPACT_APP_LIST_LIMIT = 8
}

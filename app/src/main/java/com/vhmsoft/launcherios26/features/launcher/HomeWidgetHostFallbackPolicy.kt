package com.vhmsoft.launcherios26.features.launcher

object HomeWidgetHostFallbackPolicy {

    fun visualFallback(
        tagItem: HomeWidgetPreferences.Item,
        actualPage: Int,
        actualCell: Int
    ): HomeWidgetPreferences.Item {
        return tagItem.copy(
            page = actualPage.coerceAtLeast(0),
            cell = actualCell.coerceAtLeast(0)
        )
    }
}

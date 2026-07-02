package com.cloudx.ios17.features.launcher

object HomeWidgetRemovePolicy {
    data class Result(
        val items: List<HomeWidgetPreferences.Item>,
        val removed: Boolean
    )

    fun remove(
        items: List<HomeWidgetPreferences.Item>,
        widgetId: String,
        fallbackItem: HomeWidgetPreferences.Item?
    ): Result {
        val uniqueFallbackItem = uniqueFallbackItem(items, fallbackItem)
        val remaining = items.filterNot { item ->
            item.id == widgetId ||
                matchesFallback(item, fallbackItem) ||
                item == uniqueFallbackItem
        }
        return Result(
            items = remaining,
            removed = remaining.size != items.size
        )
    }

    fun resolveWidgetId(
        hostItem: HomeWidgetPreferences.Item?,
        capturedWidgetId: String?,
        fallbackItem: HomeWidgetPreferences.Item
    ): String {
        return hostItem?.id ?: capturedWidgetId ?: fallbackItem.id
    }

    private fun matchesFallback(
        item: HomeWidgetPreferences.Item,
        fallbackItem: HomeWidgetPreferences.Item?
    ): Boolean {
        fallbackItem ?: return false
        return item.type == fallbackItem.type &&
            item.size == fallbackItem.size &&
            item.page == fallbackItem.page &&
            item.cell == fallbackItem.cell
    }

    private fun uniqueFallbackItem(
        items: List<HomeWidgetPreferences.Item>,
        fallbackItem: HomeWidgetPreferences.Item?
    ): HomeWidgetPreferences.Item? {
        fallbackItem ?: return null
        val candidates = items.filter { item ->
            item.type == fallbackItem.type && item.size == fallbackItem.size
        }
        return candidates.singleOrNull()
    }
}

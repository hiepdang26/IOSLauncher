package com.vhmsoft.launcherios26.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Test

class HomeWidgetHostFallbackPolicyTest {

    @Test
    fun visualFallbackUsesActualHostPageAndCellWhenTagIsStale() {
        val staleTag = item(id = "stale", page = 0, cell = 0)

        val fallback = HomeWidgetHostFallbackPolicy.visualFallback(
            tagItem = staleTag,
            actualPage = 1,
            actualCell = 8
        )

        assertEquals("stale", fallback.id)
        assertEquals(1, fallback.page)
        assertEquals(8, fallback.cell)
    }

    @Test
    fun removePolicyCanDeleteStoredWidgetFromVisualFallbackPosition() {
        val stored = item(id = "stored", page = 1, cell = 8)
        val sibling = item(id = "sibling", page = 1, cell = 16)
        val staleTag = item(id = "stale", page = 0, cell = 0)
        val fallback = HomeWidgetHostFallbackPolicy.visualFallback(
            tagItem = staleTag,
            actualPage = 1,
            actualCell = 8
        )

        val result = HomeWidgetRemovePolicy.remove(
            items = listOf(stored, sibling),
            widgetId = "stale",
            fallbackItem = fallback
        )

        assertEquals(listOf(sibling), result.items)
    }

    private fun item(
        id: String,
        page: Int,
        cell: Int
    ) = HomeWidgetPreferences.Item(
        id = id,
        type = "weather",
        size = HomeWidgetPlacementPolicy.WidgetSize.FULL_WIDTH,
        page = page,
        cell = cell
    )
}

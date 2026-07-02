package com.cloudx.ios17.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class HomeWidgetRemovePolicyTest {

    @Test
    fun removesWidgetById() {
        val first = item(id = "one", cell = 0)
        val second = item(id = "two", cell = 4)

        val result = HomeWidgetRemovePolicy.remove(
            items = listOf(first, second),
            widgetId = "one",
            fallbackItem = null
        )

        assertTrue(result.removed)
        assertEquals(listOf(second), result.items)
    }

    @Test
    fun removesWidgetByFallbackItemWhenIdIsStale() {
        val stored = item(id = "stored", cell = 8)
        val fallback = item(id = "stale", cell = 8)

        val result = HomeWidgetRemovePolicy.remove(
            items = listOf(stored),
            widgetId = "stale",
            fallbackItem = fallback
        )

        assertTrue(result.removed)
        assertEquals(emptyList<HomeWidgetPreferences.Item>(), result.items)
    }

    @Test
    fun resolvesWidgetIdFromCurrentHostBeforeCapturedButtonId() {
        val hostItem = item(id = "current-host", cell = 8)
        val fallback = item(id = "visual-fallback", cell = 8)

        val resolvedId = HomeWidgetRemovePolicy.resolveWidgetId(
            hostItem = hostItem,
            capturedWidgetId = "stale-button",
            fallbackItem = fallback
        )

        assertEquals("current-host", resolvedId)
    }

    @Test
    fun resolvesWidgetIdFromVisualFallbackWhenButtonIdIsMissing() {
        val fallback = item(id = "visual-fallback", cell = 8)

        val resolvedId = HomeWidgetRemovePolicy.resolveWidgetId(
            hostItem = null,
            capturedWidgetId = null,
            fallbackItem = fallback
        )

        assertEquals("visual-fallback", resolvedId)
    }

    @Test
    fun removesOnlyMatchingWidgetWhenHostPositionIsStaleButTypeAndSizeAreUnique() {
        val stored = item(id = "stored", cell = 8)
        val other = item(
            id = "other",
            type = "battery",
            size = HomeWidgetPlacementPolicy.WidgetSize.SMALL,
            cell = 16
        )
        val fallback = item(id = "stale", cell = 12)

        val result = HomeWidgetRemovePolicy.remove(
            items = listOf(stored, other),
            widgetId = "stale",
            fallbackItem = fallback
        )

        assertTrue(result.removed)
        assertEquals(listOf(other), result.items)
    }

    @Test
    fun keepsWidgetsWhenStaleHostFallbackWouldMatchMultipleSameTypeWidgets() {
        val first = item(id = "first", cell = 8)
        val second = item(id = "second", cell = 16)
        val fallback = item(id = "stale", cell = 12)

        val result = HomeWidgetRemovePolicy.remove(
            items = listOf(first, second),
            widgetId = "stale",
            fallbackItem = fallback
        )

        assertFalse(result.removed)
        assertEquals(listOf(first, second), result.items)
    }

    private fun item(
        id: String,
        cell: Int,
        type: String = "weather",
        size: HomeWidgetPlacementPolicy.WidgetSize = HomeWidgetPlacementPolicy.WidgetSize.FULL_WIDTH
    ): HomeWidgetPreferences.Item {
        return HomeWidgetPreferences.Item(
            id = id,
            type = type,
            size = size,
            page = 0,
            cell = cell
        )
    }
}

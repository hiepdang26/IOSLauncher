package com.vhmsoft.launcherios26.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Test

class HomeWidgetMergePolicyTest {

    @Test
    fun upsertReplacesExistingWidgetAndRemovesDuplicateIds() {
        val original = listOf(
            item(id = "weather", type = "weather", page = 0, cell = 0),
            item(id = "weather", type = "weather", page = 0, cell = 4),
            item(id = "battery", type = "battery", page = 0, cell = 8)
        )

        val merged = HomeWidgetMergePolicy.upsert(
            items = original,
            item = item(id = "weather", type = "weather", page = 0, cell = 12)
        )

        assertEquals(
            listOf(
                item(id = "battery", type = "battery", page = 0, cell = 8),
                item(id = "weather", type = "weather", page = 0, cell = 12)
            ),
            merged
        )
    }

    @Test
    fun normalizeRemovesOverlappingDuplicateWidgetsOnSamePage() {
        val normalized = HomeWidgetMergePolicy.normalize(
            items = listOf(
                item(id = "old", type = "weather", page = 0, cell = 4),
                item(id = "duplicate", type = "weather", page = 0, cell = 5),
                item(id = "safe", type = "battery", page = 0, cell = 16)
            ),
            columnsForPage = { 4 },
            maxCellsForPage = { 24 }
        )

        assertEquals(
            listOf(
                item(id = "old", type = "weather", page = 0, cell = 4),
                item(id = "safe", type = "battery", page = 0, cell = 16)
            ),
            normalized
        )
    }

    private fun item(
        id: String,
        type: String,
        page: Int,
        cell: Int,
        size: HomeWidgetPlacementPolicy.WidgetSize = if (type == "weather") {
            HomeWidgetPlacementPolicy.WidgetSize.FULL_WIDTH
        } else {
            HomeWidgetPlacementPolicy.WidgetSize.SMALL
        }
    ): HomeWidgetPreferences.Item =
        HomeWidgetPreferences.Item(
            id = id,
            type = type,
            size = size,
            page = page,
            cell = cell
        )
}

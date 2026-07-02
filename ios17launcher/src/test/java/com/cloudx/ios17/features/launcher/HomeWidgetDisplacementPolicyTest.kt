package com.cloudx.ios17.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class HomeWidgetDisplacementPolicyTest {

    @Test
    fun displacesAppsCoveredByWidgetToLaterFreeCellsInGridOrder() {
        val displaced = HomeWidgetDisplacementPolicy.displacedAppCells(
            appCells = linkedMapOf(
                "a" to 0,
                "b" to 1,
                "c" to 2,
                "d" to 3,
                "e" to 4,
                "f" to 5,
                "g" to 6,
                "h" to 7
            ),
            widgetCells = setOf(2, 3, 6, 7),
            reservedCells = emptySet(),
            maxCells = 24
        )

        assertEquals(
            mapOf(
                "c" to 4,
                "d" to 5,
                "e" to 8,
                "f" to 9,
                "g" to 10,
                "h" to 11
            ),
            displaced
        )
    }

    @Test
    fun pushesDownstreamAppsWhenWidgetCoversMiddleOfPackedGrid() {
        val displaced = HomeWidgetDisplacementPolicy.displacedAppCells(
            appCells = linkedMapOf(
                "a" to 8,
                "b" to 9,
                "c" to 10,
                "d" to 11,
                "e" to 12,
                "f" to 13
            ),
            widgetCells = setOf(8, 9, 12, 13),
            reservedCells = emptySet(),
            maxCells = 18
        )

        assertEquals(
            mapOf(
                "a" to 10,
                "b" to 11,
                "c" to 14,
                "d" to 15,
                "e" to 16,
                "f" to 17
            ),
            displaced
        )
    }

    @Test
    fun keepsDisplacedAppsOutOfOtherWidgetCells() {
        val displaced = HomeWidgetDisplacementPolicy.displacedAppCells(
            appCells = linkedMapOf(
                "a" to 4,
                "b" to 5,
                "c" to 8,
                "d" to 9
            ),
            widgetCells = setOf(4, 5, 8, 9),
            reservedCells = setOf(10, 11),
            maxCells = 16
        )

        assertEquals(
            mapOf(
                "a" to 6,
                "b" to 7,
                "c" to 12,
                "d" to 13
            ),
            displaced
        )
    }

    @Test
    fun returnsNullWhenNoRoomExistsForCoveredApps() {
        val displaced = HomeWidgetDisplacementPolicy.displacedAppCells(
            appCells = linkedMapOf(
                "a" to 0,
                "b" to 1,
                "c" to 2,
                "d" to 3
            ),
            widgetCells = setOf(0, 1),
            reservedCells = emptySet(),
            maxCells = 4
        )

        assertNull(displaced)
    }

    @Test
    fun returnsEmptyMapWhenWidgetDoesNotCoverAnyApp() {
        val displaced = HomeWidgetDisplacementPolicy.displacedAppCells(
            appCells = linkedMapOf(
                "a" to 0,
                "b" to 1
            ),
            widgetCells = setOf(4, 5, 8, 9),
            reservedCells = emptySet(),
            maxCells = 12
        )

        assertEquals(emptyMap<String, Int>(), displaced)
    }

    @Test
    fun movesSmallWidgetCoveredByDraggedWidgetToNearestFreeAnchor() {
        val displaced = HomeWidgetDisplacementPolicy.displacedWidgetCells(
            widgets = listOf(
                HomeWidgetDisplacementPolicy.WidgetBlock(
                    id = "battery",
                    anchorCell = 0,
                    span = HomeWidgetPlacementPolicy.Span(columns = 2, rows = 2)
                )
            ),
            draggedWidgetCells = setOf(0, 1, 4, 5),
            reservedCells = emptySet(),
            columns = 4,
            maxCells = 24
        )

        assertEquals(mapOf("battery" to 2), displaced)
    }

    @Test
    fun movesFullWidthWidgetCoveredByDraggedWidgetDownToNextFreeAnchor() {
        val displaced = HomeWidgetDisplacementPolicy.displacedWidgetCells(
            widgets = listOf(
                HomeWidgetDisplacementPolicy.WidgetBlock(
                    id = "weather",
                    anchorCell = 0,
                    span = HomeWidgetPlacementPolicy.Span(columns = 4, rows = 2)
                )
            ),
            draggedWidgetCells = setOf(0, 1, 2, 3, 4, 5, 6, 7),
            reservedCells = emptySet(),
            columns = 4,
            maxCells = 24
        )

        assertEquals(mapOf("weather" to 8), displaced)
    }

    @Test
    fun keepsMovedWidgetsOutOfFixedWidgetCells() {
        val displaced = HomeWidgetDisplacementPolicy.displacedWidgetCells(
            widgets = listOf(
                HomeWidgetDisplacementPolicy.WidgetBlock(
                    id = "battery",
                    anchorCell = 0,
                    span = HomeWidgetPlacementPolicy.Span(columns = 2, rows = 2)
                ),
                HomeWidgetDisplacementPolicy.WidgetBlock(
                    id = "photo",
                    anchorCell = 2,
                    span = HomeWidgetPlacementPolicy.Span(columns = 2, rows = 2)
                )
            ),
            draggedWidgetCells = setOf(0, 1, 4, 5),
            reservedCells = emptySet(),
            columns = 4,
            maxCells = 24
        )

        assertEquals(mapOf("battery" to 8), displaced)
    }

    @Test
    fun returnsNullWhenNoRoomExistsForCoveredWidget() {
        val displaced = HomeWidgetDisplacementPolicy.displacedWidgetCells(
            widgets = listOf(
                HomeWidgetDisplacementPolicy.WidgetBlock(
                    id = "battery",
                    anchorCell = 0,
                    span = HomeWidgetPlacementPolicy.Span(columns = 2, rows = 2)
                )
            ),
            draggedWidgetCells = setOf(0, 1, 2, 3),
            reservedCells = emptySet(),
            columns = 2,
            maxCells = 4
        )

        assertNull(displaced)
    }
}

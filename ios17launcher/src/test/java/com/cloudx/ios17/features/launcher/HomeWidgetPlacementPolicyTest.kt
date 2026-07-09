package com.cloudx.ios17.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class HomeWidgetPlacementPolicyTest {

    @Test
    fun smallWidgetUsesTwoByTwoCells() {
        assertEquals(
            HomeWidgetPlacementPolicy.Span(columns = 2, rows = 2),
            HomeWidgetPlacementPolicy.spanFor(HomeWidgetPlacementPolicy.WidgetSize.SMALL, columns = 4)
        )
    }

    @Test
    fun fullWidthWidgetUsesAllColumnsAndTwoRows() {
        assertEquals(
            HomeWidgetPlacementPolicy.Span(columns = 4, rows = 2),
            HomeWidgetPlacementPolicy.spanFor(HomeWidgetPlacementPolicy.WidgetSize.FULL_WIDTH, columns = 4)
        )
    }

    @Test
    fun tallWidgetUsesTwoColumnsAndFourRows() {
        assertEquals(
            HomeWidgetPlacementPolicy.Span(columns = 2, rows = 4),
            HomeWidgetPlacementPolicy.spanFor(HomeWidgetPlacementPolicy.WidgetSize.TALL, columns = 4)
        )
    }

    @Test
    fun largeWidgetUsesAllColumnsAndFourRows() {
        assertEquals(
            HomeWidgetPlacementPolicy.Span(columns = 4, rows = 4),
            HomeWidgetPlacementPolicy.spanFor(HomeWidgetPlacementPolicy.WidgetSize.LARGE, columns = 4)
        )
    }

    @Test
    fun placementReturnsAllOccupiedCellsForSmallWidget() {
        val placement = HomeWidgetPlacementPolicy.placementForDropCell(
            dropCell = 5,
            size = HomeWidgetPlacementPolicy.WidgetSize.SMALL,
            columns = 4,
            maxCells = 24,
            occupiedCells = emptySet()
        )

        assertEquals(5, placement?.anchorCell)
        assertEquals(setOf(5, 6, 9, 10), placement?.occupiedCells)
    }

    @Test
    fun placementClampsSmallWidgetAwayFromRightEdge() {
        val placement = HomeWidgetPlacementPolicy.placementForDropCell(
            dropCell = 7,
            size = HomeWidgetPlacementPolicy.WidgetSize.SMALL,
            columns = 4,
            maxCells = 24,
            occupiedCells = emptySet()
        )

        assertEquals(6, placement?.anchorCell)
        assertEquals(setOf(6, 7, 10, 11), placement?.occupiedCells)
    }

    @Test
    fun placementRejectsOverlap() {
        val placement = HomeWidgetPlacementPolicy.placementForDropCell(
            dropCell = 5,
            size = HomeWidgetPlacementPolicy.WidgetSize.SMALL,
            columns = 4,
            maxCells = 24,
            occupiedCells = setOf(10)
        )

        assertNull(placement)
    }

    @Test
    fun twoSmallWidgetsCanShareTheSameRow() {
        val secondPlacement = HomeWidgetPlacementPolicy.placementForDropCell(
            dropCell = 2,
            size = HomeWidgetPlacementPolicy.WidgetSize.SMALL,
            columns = 4,
            maxCells = 24,
            occupiedCells = setOf(0, 1, 4, 5)
        )

        assertEquals(2, secondPlacement?.anchorCell)
        assertEquals(setOf(2, 3, 6, 7), secondPlacement?.occupiedCells)
    }

    @Test
    fun placementFallsBackToNearbyAnchorWhenFingerIsCenteredNearReservedWidget() {
        val placement = HomeWidgetPlacementPolicy.placementForCenteredDropCell(
            dropCell = 12,
            size = HomeWidgetPlacementPolicy.WidgetSize.SMALL,
            columns = 4,
            maxCells = 24,
            occupiedCells = setOf(16, 17, 18, 19)
        )

        assertEquals(8, placement?.anchorCell)
        assertEquals(setOf(8, 9, 12, 13), placement?.occupiedCells)
    }

    @Test
    fun placementRejectsWhenGridIsTooShort() {
        val placement = HomeWidgetPlacementPolicy.placementForDropCell(
            dropCell = 0,
            size = HomeWidgetPlacementPolicy.WidgetSize.FULL_WIDTH,
            columns = 4,
            maxCells = 4,
            occupiedCells = emptySet()
        )

        assertNull(placement)
    }
}

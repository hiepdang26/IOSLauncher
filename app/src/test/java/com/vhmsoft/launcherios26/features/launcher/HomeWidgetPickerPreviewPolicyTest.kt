package com.vhmsoft.launcherios26.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Test

class HomeWidgetPickerPreviewPolicyTest {

    @Test
    fun previewHeightUsesFallbackWhenTwoHomeRowsAreShorter() {
        assertEquals(
            340,
            HomeWidgetPickerPreviewPolicy.previewHeight(
                homeCellHeightPx = 150,
                fallbackHeightPx = 340
            )
        )
    }

    @Test
    fun previewHeightIsAtLeastTwoHomeRows() {
        assertEquals(
            420,
            HomeWidgetPickerPreviewPolicy.previewHeight(
                homeCellHeightPx = 210,
                fallbackHeightPx = 340
            )
        )
    }

    @Test
    fun previewHeightKeepsTwoRowFootprintWhenSafetyInsetIsProvided() {
        assertEquals(
            420,
            HomeWidgetPickerPreviewPolicy.previewHeight(
                homeCellHeightPx = 210,
                fallbackHeightPx = 340,
                safetyInsetPx = 32
            )
        )
    }

    @Test
    fun twoByTwoPreviewHeightMatchesHalfCardWidth() {
        assertEquals(
            388,
            HomeWidgetPickerPreviewPolicy.gridPreviewHeight(
                contentWidthPx = 800,
                columns = 2,
                rows = 2,
                cardsInRow = 2,
                horizontalMarginsPx = 24,
                minimumHeightPx = 0
            )
        )
    }

    @Test
    fun twoByFourPreviewHeightUsesTwoRowsOfFullWidthGrid() {
        assertEquals(
            394,
            HomeWidgetPickerPreviewPolicy.gridPreviewHeight(
                contentWidthPx = 800,
                columns = 4,
                rows = 2,
                cardsInRow = 1,
                horizontalMarginsPx = 12,
                minimumHeightPx = 0
            )
        )
    }
}

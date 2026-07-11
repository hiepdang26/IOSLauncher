package com.cloudx.ios17.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Test

class FolderOpenLayoutPolicyTest {

    @Test
    fun metrics_usesWideIosStylePanelIndependentOfHomeGrid() {
        val metrics = FolderOpenLayoutPolicy.metrics(
            availableWidth = 1000,
            availableHeight = 2200,
            homeCellHeight = 220,
            iconSize = 132,
            density = 2.5f
        )

        assertEquals(780, metrics.panelWidth)
        assertEquals(260, metrics.cellWidth)
        assertEquals(320, metrics.cellHeight)
        assertEquals(960, metrics.gridHeight)
        assertEquals(60, metrics.titleBottomGap)
        assertEquals(105, metrics.cornerRadius)
        assertEquals(32f, metrics.titleTextSizeSp, 0.001f)
    }

    @Test
    fun metrics_keepsPanelInsideNarrowScreen() {
        val metrics = FolderOpenLayoutPolicy.metrics(
            availableWidth = 360,
            availableHeight = 760,
            homeCellHeight = 90,
            iconSize = 52,
            density = 1f
        )

        assertEquals(312, metrics.panelWidth)
        assertEquals(104, metrics.cellWidth)
        assertEquals(128, metrics.cellHeight)
        assertEquals(384, metrics.gridHeight)
    }
}

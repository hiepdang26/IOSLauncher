package com.cloudx.ios17.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Test

class TodayWidgetLayoutPolicyTest {

    @Test
    fun `uses half row span for square widgets`() {
        val span = TodayWidgetLayoutPolicy.spanFor(minWidth = 160, minHeight = 150)

        assertEquals(TodayWidgetLayoutPolicy.Span.HALF, span)
    }

    @Test
    fun `uses full row span for wide widgets`() {
        val span = TodayWidgetLayoutPolicy.spanFor(minWidth = 320, minHeight = 130)

        assertEquals(TodayWidgetLayoutPolicy.Span.FULL, span)
    }

    @Test
    fun `packs square widgets two per row while preserving full width widgets`() {
        val rows = TodayWidgetLayoutPolicy.packRows(
            listOf(
                TodayWidgetLayoutPolicy.Item(1, TodayWidgetLayoutPolicy.Span.HALF),
                TodayWidgetLayoutPolicy.Item(2, TodayWidgetLayoutPolicy.Span.HALF),
                TodayWidgetLayoutPolicy.Item(3, TodayWidgetLayoutPolicy.Span.FULL),
                TodayWidgetLayoutPolicy.Item(4, TodayWidgetLayoutPolicy.Span.HALF)
            )
        )

        assertEquals(
            listOf(
                TodayWidgetLayoutPolicy.Row(TodayWidgetLayoutPolicy.Span.HALF, listOf(1, 2)),
                TodayWidgetLayoutPolicy.Row(TodayWidgetLayoutPolicy.Span.FULL, listOf(3)),
                TodayWidgetLayoutPolicy.Row(TodayWidgetLayoutPolicy.Span.HALF, listOf(4))
            ),
            rows
        )
    }

    @Test
    fun `reorders dragged widget before drop target`() {
        val reordered = TodayWidgetLayoutPolicy.reorder(
            ids = listOf(10, 20, 30, 40),
            draggedId = 30,
            targetIndex = 1
        )

        assertEquals(listOf(10, 30, 20, 40), reordered)
    }
}

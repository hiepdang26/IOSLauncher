package com.vhmsoft.launcherios26.features.launcher

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class TodayWidgetDragUpdatePolicyTest {

    @Test
    fun firstMove_isInspectedImmediately() {
        assertTrue(
            TodayWidgetDragUpdatePolicy.shouldInspectMove(
                lastRawX = Float.NaN,
                lastRawY = Float.NaN,
                rawX = 120f,
                rawY = 240f,
                lastUptimeMs = 0L,
                nowUptimeMs = 8L,
                minMovePx = 6f,
                minIntervalMs = 32L
            )
        )
    }

    @Test
    fun tinyMoveInsideFrameWindow_isSkipped() {
        assertFalse(
            TodayWidgetDragUpdatePolicy.shouldInspectMove(
                lastRawX = 120f,
                lastRawY = 240f,
                rawX = 122f,
                rawY = 242f,
                lastUptimeMs = 100L,
                nowUptimeMs = 116L,
                minMovePx = 6f,
                minIntervalMs = 32L
            )
        )
    }

    @Test
    fun largeMove_isInspectedEvenInsideFrameWindow() {
        assertTrue(
            TodayWidgetDragUpdatePolicy.shouldInspectMove(
                lastRawX = 120f,
                lastRawY = 240f,
                rawX = 134f,
                rawY = 248f,
                lastUptimeMs = 100L,
                nowUptimeMs = 112L,
                minMovePx = 6f,
                minIntervalMs = 32L
            )
        )
    }

    @Test
    fun sheetDragStartsOnlyAfterTouchSlop() {
        assertFalse(TodayWidgetDragUpdatePolicy.shouldStartSheetDrag(deltaY = 3f, touchSlop = 8f))
        assertTrue(TodayWidgetDragUpdatePolicy.shouldStartSheetDrag(deltaY = -10f, touchSlop = 8f))
    }
}

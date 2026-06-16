package com.vhmsoft.launcherios26.ui.launcher.workspace

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test

class LauncherTodayWidgetPushPreviewTest {
    @Test
    fun offsetsForMove_pushesWidgetsTowardPreviewSlotsWhenDraggingDown() {
        val offsets = LauncherTodayWidgetPushPreview.offsetsForMove(
            widgetIds = listOf(1L, 2L, 3L),
            draggedWidgetId = 1L,
            targetIndex = 2,
            centers = mapOf(
                1L to LauncherTodayWidgetCenter(0f, 0f),
                2L to LauncherTodayWidgetCenter(0f, 100f),
                3L to LauncherTodayWidgetCenter(0f, 200f)
            )
        )

        assertEquals(LauncherTodayWidgetOffset(0f, -100f), offsets[2L])
        assertEquals(LauncherTodayWidgetOffset(0f, -100f), offsets[3L])
        assertFalse(offsets.containsKey(1L))
    }

    @Test
    fun offsetsForMove_pushesWidgetsTowardPreviewSlotsWhenDraggingUp() {
        val offsets = LauncherTodayWidgetPushPreview.offsetsForMove(
            widgetIds = listOf(1L, 2L, 3L),
            draggedWidgetId = 3L,
            targetIndex = 0,
            centers = mapOf(
                1L to LauncherTodayWidgetCenter(0f, 0f),
                2L to LauncherTodayWidgetCenter(0f, 100f),
                3L to LauncherTodayWidgetCenter(0f, 200f)
            )
        )

        assertEquals(LauncherTodayWidgetOffset(0f, 100f), offsets[1L])
        assertEquals(LauncherTodayWidgetOffset(0f, 100f), offsets[2L])
        assertFalse(offsets.containsKey(3L))
    }

    @Test
    fun offsetsForTargetCenters_usesComputedLayoutCenters() {
        val offsets = LauncherTodayWidgetPushPreview.offsetsForTargetCenters(
            draggedWidgetId = 3L,
            centers = mapOf(
                1L to LauncherTodayWidgetCenter(180f, 80f),
                2L to LauncherTodayWidgetCenter(84f, 270f),
                3L to LauncherTodayWidgetCenter(180f, 460f)
            ),
            targetCenters = mapOf(
                1L to LauncherTodayWidgetCenter(180f, 80f),
                3L to LauncherTodayWidgetCenter(84f, 270f),
                2L to LauncherTodayWidgetCenter(276f, 270f)
            )
        )

        assertEquals(LauncherTodayWidgetOffset(192f, 0f), offsets[2L])
        assertFalse(offsets.containsKey(3L))
    }
}

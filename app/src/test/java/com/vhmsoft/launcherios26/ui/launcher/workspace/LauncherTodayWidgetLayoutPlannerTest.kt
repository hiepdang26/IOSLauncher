package com.vhmsoft.launcherios26.ui.launcher.workspace

import org.junit.Assert.assertEquals
import org.junit.Test

class LauncherTodayWidgetLayoutPlannerTest {
    @Test
    fun rows_packsTwoSmallWidgetsIntoOneRow() {
        val rows = LauncherTodayWidgetLayoutPlanner.rows(
            listOf(
                LauncherTodayWidgetSize.SMALL,
                LauncherTodayWidgetSize.SMALL,
                LauncherTodayWidgetSize.WIDE
            )
        )

        assertEquals(listOf(listOf(0, 1), listOf(2)), rows)
    }

    @Test
    fun rows_keepsWideWidgetsInTheirOwnRows() {
        val rows = LauncherTodayWidgetLayoutPlanner.rows(
            listOf(
                LauncherTodayWidgetSize.WIDE,
                LauncherTodayWidgetSize.SMALL,
                LauncherTodayWidgetSize.WIDE,
                LauncherTodayWidgetSize.SMALL
            )
        )

        assertEquals(listOf(listOf(0), listOf(1), listOf(2), listOf(3)), rows)
    }

    @Test
    fun move_reordersWidgetByIndex() {
        val moved = LauncherTodayWidgetLayoutPlanner.move(
            items = listOf("weather", "battery", "apps"),
            fromIndex = 2,
            toIndex = 0
        )

        assertEquals(listOf("apps", "weather", "battery"), moved)
    }

    @Test
    fun rows_packsSmallWidgetsTogetherAfterReorder() {
        val movedSizes = LauncherTodayWidgetLayoutPlanner.move(
            items = listOf(
                LauncherTodayWidgetSize.WIDE,
                LauncherTodayWidgetSize.SMALL,
                LauncherTodayWidgetSize.WIDE,
                LauncherTodayWidgetSize.SMALL
            ),
            fromIndex = 3,
            toIndex = 1
        )

        val rows = LauncherTodayWidgetLayoutPlanner.rows(movedSizes)

        assertEquals(listOf(listOf(0), listOf(1, 2), listOf(3)), rows)
    }
}

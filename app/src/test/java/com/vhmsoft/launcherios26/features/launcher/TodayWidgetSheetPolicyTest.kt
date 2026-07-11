package com.vhmsoft.launcherios26.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Test

class TodayWidgetSheetPolicyTest {

    @Test
    fun `clamps drag between expanded and dismiss bounds`() {
        assertEquals(
            -180f,
            TodayWidgetSheetPolicy.dragTranslation(
                startTranslation = 0f,
                deltaY = -260f,
                minTranslation = -180f,
                maxTranslation = 500f
            )
        )
        assertEquals(
            500f,
            TodayWidgetSheetPolicy.dragTranslation(
                startTranslation = 120f,
                deltaY = 460f,
                minTranslation = -180f,
                maxTranslation = 500f
            )
        )
    }

    @Test
    fun `dismisses when released far below resting point`() {
        assertEquals(
            TodayWidgetSheetPolicy.SnapTarget.DISMISS,
            TodayWidgetSheetPolicy.snapTarget(
                translationY = 220f,
                sheetHeight = 800f
            )
        )
    }

    @Test
    fun `snaps upward drag to expanded state`() {
        assertEquals(
            TodayWidgetSheetPolicy.SnapTarget.EXPANDED,
            TodayWidgetSheetPolicy.snapTarget(
                translationY = -90f,
                sheetHeight = 800f
            )
        )
    }

    @Test
    fun `small drag returns to resting state`() {
        assertEquals(
            TodayWidgetSheetPolicy.SnapTarget.RESTING,
            TodayWidgetSheetPolicy.snapTarget(
                translationY = 24f,
                sheetHeight = 800f
            )
        )
    }
}

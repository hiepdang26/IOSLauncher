package com.cloudx.ios17.features.launcher

import org.junit.Assert.assertFalse
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class HomeWidgetInteractionPolicyTest {
    @Test
    fun systemWidgetContentKeepsProviderTouchHandling() {
        assertFalse(
            HomeWidgetInteractionPolicy.shouldAttachLauncherTouchTracking(
                widgetType = "system",
                isProviderContent = true
            )
        )
    }

    @Test
    fun systemWidgetChromeStillUsesLauncherTouchHandling() {
        assertTrue(
            HomeWidgetInteractionPolicy.shouldAttachLauncherTouchTracking(
                widgetType = "system",
                isProviderContent = false
            )
        )
    }

    @Test
    fun builtInWidgetContentUsesLauncherTouchHandling() {
        assertTrue(
            HomeWidgetInteractionPolicy.shouldAttachLauncherTouchTracking(
                widgetType = "weather",
                isProviderContent = true
            )
        )
    }

    @Test
    fun activeWidgetDragCapturesGlobalMoveAndEndEvents() {
        assertTrue(
            HomeWidgetInteractionPolicy.shouldCaptureGlobalDragMotion(
                active = true,
                action = HomeWidgetInteractionPolicy.TouchAction.MOVE
            )
        )
        assertTrue(
            HomeWidgetInteractionPolicy.shouldCaptureGlobalDragMotion(
                active = true,
                action = HomeWidgetInteractionPolicy.TouchAction.UP
            )
        )
        assertTrue(
            HomeWidgetInteractionPolicy.shouldCaptureGlobalDragMotion(
                active = true,
                action = HomeWidgetInteractionPolicy.TouchAction.CANCEL
            )
        )
    }

    @Test
    fun inactiveWidgetDragDoesNotCaptureGlobalMoveEvents() {
        assertFalse(
            HomeWidgetInteractionPolicy.shouldCaptureGlobalDragMotion(
                active = false,
                action = HomeWidgetInteractionPolicy.TouchAction.MOVE
            )
        )
    }

    @Test
    fun widgetDragUsesCachedPointInsideSourceBounds() {
        val start = HomeWidgetInteractionPolicy.dragStartPoint(
            rawX = 120f,
            rawY = 240f,
            sourceBounds = HomeWidgetInteractionPolicy.Bounds(
                left = 100,
                top = 200,
                right = 300,
                bottom = 420
            )
        )

        assertEquals(120f, start.x)
        assertEquals(240f, start.y)
    }

    @Test
    fun widgetDragFallsBackToSourceCenterWhenCachedPointIsStale() {
        val start = HomeWidgetInteractionPolicy.dragStartPoint(
            rawX = 900f,
            rawY = 1800f,
            sourceBounds = HomeWidgetInteractionPolicy.Bounds(
                left = 100,
                top = 200,
                right = 300,
                bottom = 420
            )
        )

        assertEquals(200f, start.x)
        assertEquals(310f, start.y)
    }
}

package com.cloudx.ios17.features.launcher

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class HomeWidgetRemoveTouchPolicyTest {

    @Test
    fun downInsideRemoveButtonRemovesImmediately() {
        val decision = HomeWidgetRemoveTouchPolicy.decide(
            action = HomeWidgetRemoveTouchPolicy.Action.DOWN,
            editing = true,
            draggingWidget = false,
            hitRemoveButton = true,
            trackingRemoveButton = false
        )

        assertTrue(decision.consume)
        assertFalse(decision.trackRemoveButton)
        assertFalse(decision.pressed)
        assertTrue(decision.remove)
    }

    @Test
    fun staleRemoveButtonDoesNotRemoveWhenEditStateStopped() {
        val decision = HomeWidgetRemoveTouchPolicy.decide(
            action = HomeWidgetRemoveTouchPolicy.Action.DOWN,
            editing = false,
            draggingWidget = false,
            hitRemoveButton = true,
            trackingRemoveButton = false
        )

        assertFalse(decision.consume)
        assertFalse(decision.trackRemoveButton)
        assertFalse(decision.pressed)
        assertFalse(decision.remove)
    }

    @Test
    fun upInsideTrackedRemoveButtonRemovesWidget() {
        val decision = HomeWidgetRemoveTouchPolicy.decide(
            action = HomeWidgetRemoveTouchPolicy.Action.UP,
            editing = true,
            draggingWidget = false,
            hitRemoveButton = true,
            trackingRemoveButton = true
        )

        assertTrue(decision.consume)
        assertFalse(decision.trackRemoveButton)
        assertFalse(decision.pressed)
        assertTrue(decision.remove)
    }

    @Test
    fun upWithoutTrackedDownDoesNotRemoveWidget() {
        val decision = HomeWidgetRemoveTouchPolicy.decide(
            action = HomeWidgetRemoveTouchPolicy.Action.UP,
            editing = true,
            draggingWidget = false,
            hitRemoveButton = true,
            trackingRemoveButton = false
        )

        assertFalse(decision.consume)
        assertFalse(decision.trackRemoveButton)
        assertFalse(decision.pressed)
        assertFalse(decision.remove)
    }

    @Test
    fun removeButtonIgnoresTouchesWhileWidgetIsDragging() {
        val decision = HomeWidgetRemoveTouchPolicy.decide(
            action = HomeWidgetRemoveTouchPolicy.Action.DOWN,
            editing = true,
            draggingWidget = true,
            hitRemoveButton = true,
            trackingRemoveButton = false
        )

        assertFalse(decision.consume)
        assertFalse(decision.trackRemoveButton)
        assertFalse(decision.pressed)
        assertFalse(decision.remove)
    }
}

package com.cloudx.ios17.features.launcher

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class HomeWidgetEditStatePolicyTest {

    @Test
    fun showsRemoveButtonOnlyWhenEditingAndNotDraggingWidget() {
        assertTrue(
            HomeWidgetEditStatePolicy.shouldShowRemoveButton(
                editing = true,
                draggingWidget = false
            )
        )
        assertFalse(
            HomeWidgetEditStatePolicy.shouldShowRemoveButton(
                editing = false,
                draggingWidget = false
            )
        )
        assertFalse(
            HomeWidgetEditStatePolicy.shouldShowRemoveButton(
                editing = true,
                draggingWidget = true
            )
        )
    }

    @Test
    fun animatesWidgetOnlyWhenEditingAndNotDraggingWidget() {
        assertTrue(
            HomeWidgetEditStatePolicy.shouldAnimateWidget(
                editing = true,
                draggingWidget = false
            )
        )
        assertFalse(
            HomeWidgetEditStatePolicy.shouldAnimateWidget(
                editing = false,
                draggingWidget = false
            )
        )
        assertFalse(
            HomeWidgetEditStatePolicy.shouldAnimateWidget(
                editing = true,
                draggingWidget = true
            )
        )
    }

    @Test
    fun hidesEntryCardOnlyWhenHomeIsTappedDuringEditing() {
        assertTrue(
            HomeWidgetEditStatePolicy.shouldHideEntryCardOnHomeTap(
                editing = true,
                entryCardVisible = true
            )
        )
        assertFalse(
            HomeWidgetEditStatePolicy.shouldHideEntryCardOnHomeTap(
                editing = false,
                entryCardVisible = true
            )
        )
        assertFalse(
            HomeWidgetEditStatePolicy.shouldHideEntryCardOnHomeTap(
                editing = true,
                entryCardVisible = false
            )
        )
    }

    @Test
    fun purgesEditChromeWhenEditingStopsOrWidgetDragStarts() {
        assertTrue(
            HomeWidgetEditStatePolicy.shouldPurgeEditChrome(
                editing = false,
                draggingWidget = false
            )
        )
        assertTrue(
            HomeWidgetEditStatePolicy.shouldPurgeEditChrome(
                editing = true,
                draggingWidget = true
            )
        )
        assertFalse(
            HomeWidgetEditStatePolicy.shouldPurgeEditChrome(
                editing = true,
                draggingWidget = false
            )
        )
    }

    @Test
    fun resetsTransientWidgetTouchStateWhenEditingStops() {
        assertTrue(
            HomeWidgetEditStatePolicy.shouldResetTransientTouchState(
                editing = false
            )
        )
        assertFalse(
            HomeWidgetEditStatePolicy.shouldResetTransientTouchState(
                editing = true
            )
        )
    }
}

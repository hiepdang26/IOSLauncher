package com.cloudx.ios17.features.launcher

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class HomeWidgetTouchDragPolicyTest {

    @Test
    fun previewPlacementOnlyWhenDropCellChanges() {
        assertFalse(
            HomeWidgetTouchDragPolicy.shouldPreviewPlacement(
                previousDropKey = "1:8",
                currentDropKey = "1:8"
            )
        )

        assertTrue(
            HomeWidgetTouchDragPolicy.shouldPreviewPlacement(
                previousDropKey = "1:8",
                currentDropKey = "1:9"
            )
        )
    }

    @Test
    fun animatesDisplacementOnlyAfterThrottleWindow() {
        assertFalse(
            HomeWidgetTouchDragPolicy.shouldAnimateDisplacement(
                nowMs = 140L,
                lastAnimationMs = 100L,
                throttleMs = 48L
            )
        )

        assertTrue(
            HomeWidgetTouchDragPolicy.shouldAnimateDisplacement(
                nowMs = 148L,
                lastAnimationMs = 100L,
                throttleMs = 48L
            )
        )
    }

    @Test
    fun activeTouchDragConsumesMoveAndEndEvents() {
        assertTrue(HomeWidgetTouchDragPolicy.shouldHandleMove(active = true))
        assertTrue(HomeWidgetTouchDragPolicy.shouldHandleEnd(active = true))
        assertFalse(HomeWidgetTouchDragPolicy.shouldHandleMove(active = false))
        assertFalse(HomeWidgetTouchDragPolicy.shouldHandleEnd(active = false))
    }

    @Test
    fun displacedAppStillRunsMoveAnimationWhileItIsWobbling() {
        assertTrue(
            HomeWidgetTouchDragPolicy.shouldAnimateDisplacedApp(
                requestedAnimation = true,
                appIsWobbling = true
            )
        )

        assertTrue(
            HomeWidgetTouchDragPolicy.shouldAnimateDisplacedApp(
                requestedAnimation = true,
                appIsWobbling = false
            )
        )
    }

    @Test
    fun wobblingDisplacedAppKeepsItsExistingEditAnimationStable() {
        assertFalse(
            HomeWidgetTouchDragPolicy.shouldCancelDisplacedAppAnimator(
                appIsWobbling = true
            )
        )

        assertTrue(
            HomeWidgetTouchDragPolicy.shouldCancelDisplacedAppAnimator(
                appIsWobbling = false
            )
        )
    }

    @Test
    fun invalidNoRoomPreviewDoesNotRestoreDisplacementUntilDropEnds() {
        assertFalse(
            HomeWidgetTouchDragPolicy.shouldRestoreDisplacementForInvalidPreview(
                outsideHome = false
            )
        )

        assertTrue(
            HomeWidgetTouchDragPolicy.shouldRestoreDisplacementForInvalidPreview(
                outsideHome = true
            )
        )
    }
}

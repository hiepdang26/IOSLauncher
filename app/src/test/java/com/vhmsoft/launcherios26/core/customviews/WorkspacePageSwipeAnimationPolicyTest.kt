package com.vhmsoft.launcherios26.core.customviews

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class WorkspacePageSwipeAnimationPolicyTest {
    @Test
    fun regularPageSnap_isFasterThanLegacySpeed() {
        assertTrue(
            WorkspacePageSwipeAnimationPolicy.PAGE_SNAP_DURATION_MS <
                WorkspacePageSwipeAnimationPolicy.LEGACY_PAGE_SNAP_DURATION_MS
        )
        assertTrue(
            WorkspacePageSwipeAnimationPolicy.PAGE_SNAP_DURATION_MS <
                PagedView.SLOW_PAGE_SNAP_ANIMATION_DURATION
        )
        assertEquals(
            480,
            WorkspacePageSwipeAnimationPolicy.pageSnapDuration(isInOverScroll = false, overScrollDurationMs = 270)
        )
    }

    @Test
    fun overScrollSnap_keepsShortEdgeFeedback() {
        assertEquals(
            270,
            WorkspacePageSwipeAnimationPolicy.pageSnapDuration(isInOverScroll = true, overScrollDurationMs = 270)
        )
    }

    @Test
    fun flingSnap_scalesDurationDownWithoutPassingSlowCap() {
        assertEquals(360, WorkspacePageSwipeAnimationPolicy.flingSnapDuration(500))
        assertEquals(648, WorkspacePageSwipeAnimationPolicy.flingSnapDuration(900))
        assertEquals(950, WorkspacePageSwipeAnimationPolicy.flingSnapDuration(2000))
    }
}

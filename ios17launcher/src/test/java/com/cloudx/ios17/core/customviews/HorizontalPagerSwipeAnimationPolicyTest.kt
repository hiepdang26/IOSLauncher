package com.cloudx.ios17.core.customviews

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class HorizontalPagerSwipeAnimationPolicyTest {
    @Test
    fun defaultPageSnap_isSmootherThanLegacySnap() {
        assertTrue(
            HorizontalPagerSwipeAnimationPolicy.PAGE_SNAP_DURATION_MS >
                HorizontalPagerSwipeAnimationPolicy.LEGACY_PAGE_SNAP_DURATION_MS
        )
        assertEquals(720, HorizontalPagerSwipeAnimationPolicy.PAGE_SNAP_DURATION_MS)
    }

    @Test
    fun flingSnap_requiresMoreDeliberateVelocityThanLegacy() {
        assertTrue(
            HorizontalPagerSwipeAnimationPolicy.SNAP_VELOCITY_PX_PER_SECOND >
                HorizontalPagerSwipeAnimationPolicy.LEGACY_SNAP_VELOCITY_PX_PER_SECOND
        )
        assertEquals(1400, HorizontalPagerSwipeAnimationPolicy.SNAP_VELOCITY_PX_PER_SECOND)
    }

    @Test
    fun destinationSnap_waitsForMeaningfulPageDrag() {
        val width = 1000
        val currentPageStartX = 1000
        val currentPage = 1
        val childCount = 3

        assertEquals(
            currentPage,
            HorizontalPagerSwipeAnimationPolicy.destinationPage(
                scrollX = 801,
                currentPageStartX = currentPageStartX,
                currentPage = currentPage,
                childCount = childCount,
                width = width
            )
        )
        assertEquals(
            0,
            HorizontalPagerSwipeAnimationPolicy.destinationPage(
                scrollX = 799,
                currentPageStartX = currentPageStartX,
                currentPage = currentPage,
                childCount = childCount,
                width = width
            )
        )
        assertEquals(
            currentPage,
            HorizontalPagerSwipeAnimationPolicy.destinationPage(
                scrollX = 1199,
                currentPageStartX = currentPageStartX,
                currentPage = currentPage,
                childCount = childCount,
                width = width
            )
        )
        assertEquals(
            2,
            HorizontalPagerSwipeAnimationPolicy.destinationPage(
                scrollX = 1201,
                currentPageStartX = currentPageStartX,
                currentPage = currentPage,
                childCount = childCount,
                width = width
            )
        )
    }

    @Test
    fun drawnPageRange_skipsPagesFarOutsideTheViewport() {
        assertEquals(
            0..1,
            HorizontalPagerSwipeAnimationPolicy.drawnPageRange(
                scrollX = 0,
                viewportWidth = 1000,
                pageWidth = 1000,
                childCount = 6
            )
        )
        assertEquals(
            1..4,
            HorizontalPagerSwipeAnimationPolicy.drawnPageRange(
                scrollX = 2500,
                viewportWidth = 1000,
                pageWidth = 1000,
                childCount = 6
            )
        )
        assertEquals(
            4..5,
            HorizontalPagerSwipeAnimationPolicy.drawnPageRange(
                scrollX = 5000,
                viewportWidth = 1000,
                pageWidth = 1000,
                childCount = 6
            )
        )
    }

    @Test
    fun settlingPager_finishesBeforeChildTouchSoIconTapCanRun() {
        assertTrue(
            HorizontalPagerSwipeAnimationPolicy.shouldFinishSettlingBeforeChildTouch(
                scrollerFinished = false
            )
        )
        assertFalse(
            HorizontalPagerSwipeAnimationPolicy.shouldFinishSettlingBeforeChildTouch(
                scrollerFinished = true
            )
        )
    }
}

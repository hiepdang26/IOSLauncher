package com.vhmsoft.launcherios26.core.customviews

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ClockTickerPolicyTest {
    @Test
    fun animatesOnlyWhenAutoUpdatingAttachedAggregatedVisibleAndWindowVisible() {
        assertTrue(
            ClockTickerPolicy.shouldAnimate(
                autoUpdate = true,
                attachedToWindow = true,
                aggregatedVisible = true,
                windowVisible = true
            )
        )
    }

    @Test
    fun stopsWhenAncestorIsHidden() {
        assertFalse(
            ClockTickerPolicy.shouldAnimate(
                autoUpdate = true,
                attachedToWindow = true,
                aggregatedVisible = false,
                windowVisible = true
            )
        )
    }

    @Test
    fun stopsWhenWindowIsHidden() {
        assertFalse(
            ClockTickerPolicy.shouldAnimate(
                autoUpdate = true,
                attachedToWindow = true,
                aggregatedVisible = true,
                windowVisible = false
            )
        )
    }
}

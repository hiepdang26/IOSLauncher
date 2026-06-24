package com.cloudx.ios17.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Test

class TodayWidgetDragShadowPolicyTest {

    @Test
    fun invisibleShadowUsesSinglePixelMetrics() {
        val metrics = TodayWidgetDragShadowPolicy.invisibleMetrics()

        assertEquals(1, metrics.width)
        assertEquals(1, metrics.height)
        assertEquals(0, metrics.touchX)
        assertEquals(0, metrics.touchY)
    }
}

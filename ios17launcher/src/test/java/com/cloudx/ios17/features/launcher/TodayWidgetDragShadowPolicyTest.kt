package com.cloudx.ios17.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Test

class TodayWidgetDragShadowPolicyTest {

    @Test
    fun bitmapShadowTracksFingerFromTheCenterOfTheWidgetPreview() {
        assertEquals(
            TodayWidgetDragShadowPolicy.Metrics(
                width = 240,
                height = 120,
                touchX = 120,
                touchY = 60
            ),
            TodayWidgetDragShadowPolicy.bitmapMetrics(width = 240, height = 120)
        )
    }
}

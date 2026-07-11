package com.vhmsoft.launcherios26.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Test

class TodayWidgetDragAnimationPolicyTest {

    @Test
    fun `translation starts from previous host bounds`() {
        val translation = TodayWidgetDragAnimationPolicy.startTranslation(
            previousLeft = 40,
            previousTop = 120,
            currentLeft = 10,
            currentTop = 200
        )

        assertEquals(30f, translation.x)
        assertEquals(-80f, translation.y)
    }

    @Test
    fun `unchanged host has no starting translation`() {
        val translation = TodayWidgetDragAnimationPolicy.startTranslation(
            previousLeft = 10,
            previousTop = 20,
            currentLeft = 10,
            currentTop = 20
        )

        assertEquals(0f, translation.x)
        assertEquals(0f, translation.y)
    }
}

package com.vhmsoft.launcherios26.features.launcher

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class HomeWidgetDragSessionPolicyTest {

    @Test
    fun appliesDragEndOnlyForCurrentSession() {
        assertTrue(
            HomeWidgetDragSessionPolicy.shouldApplyDragEnd(
                activeSessionId = 4L,
                endedSessionId = 4L
            )
        )
        assertFalse(
            HomeWidgetDragSessionPolicy.shouldApplyDragEnd(
                activeSessionId = 5L,
                endedSessionId = 4L
            )
        )
    }

    @Test
    fun invalidatesSessionByIncrementingIt() {
        assertTrue(HomeWidgetDragSessionPolicy.nextSessionId(7L) > 7L)
    }
}

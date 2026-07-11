package com.vhmsoft.launcherios26.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class HomeWidgetPhotoCropLayoutPolicyTest {
    @Test
    fun toolbar_usesCompactIosNavigationHeight() {
        assertEquals(68, HomeWidgetPhotoCropLayoutPolicy.TOOLBAR_HEIGHT_DP)
        assertEquals(56, HomeWidgetPhotoCropLayoutPolicy.TOOLBAR_CONTENT_HEIGHT_DP)
    }

    @Test
    fun toolbar_usesThreeEqualSlotsToPreventTitleOverlap() {
        assertEquals(3, HomeWidgetPhotoCropLayoutPolicy.TOOLBAR_SLOT_COUNT)
    }

    @Test
    fun cropFrame_isNarrowerThanFullPreviewWidth() {
        assertTrue(HomeWidgetPhotoCropLayoutPolicy.CROP_MAX_WIDTH_FRACTION < 0.78f)
        assertEquals(0.70f, HomeWidgetPhotoCropLayoutPolicy.CROP_MAX_WIDTH_FRACTION)
    }
}

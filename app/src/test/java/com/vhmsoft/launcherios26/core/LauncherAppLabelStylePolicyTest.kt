package com.vhmsoft.launcherios26.core

import org.junit.Assert.assertEquals
import org.junit.Test

class LauncherAppLabelStylePolicyTest {

    @Test
    fun appLabels_matchReferenceTypography() {
        assertEquals("sans-serif-medium", LauncherAppLabelStylePolicy.FONT_FAMILY)
        assertEquals(12f, LauncherAppLabelStylePolicy.TEXT_SIZE_SP)
        assertEquals(2f, LauncherAppLabelStylePolicy.SHADOW_RADIUS_DP)
        assertEquals(1f, LauncherAppLabelStylePolicy.SHADOW_DY_DP)
    }
}

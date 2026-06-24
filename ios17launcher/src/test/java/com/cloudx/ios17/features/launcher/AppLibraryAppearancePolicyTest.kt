package com.cloudx.ios17.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Test

class AppLibraryAppearancePolicyTest {
    @Test
    fun searchPillMatchesAppModuleAppearance() {
        assertEquals(0x733B5B6A, AppLibraryAppearancePolicy.SEARCH_PILL_COLOR)
        assertEquals(22, AppLibraryAppearancePolicy.SEARCH_PILL_RADIUS_DP)
    }
}

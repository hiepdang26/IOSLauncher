package com.vhmsoft.launcherios26.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Test

class AppLibraryAppearancePolicyTest {
    @Test
    fun searchPillMatchesAppModuleAppearance() {
        assertEquals(0x86E8FAFF.toInt(), AppLibraryAppearancePolicy.SEARCH_PILL_COLOR)
        assertEquals(22, AppLibraryAppearancePolicy.SEARCH_PILL_RADIUS_DP)
    }
}

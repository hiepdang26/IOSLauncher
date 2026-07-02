package com.cloudx.ios17.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Test

class LauncherReloadPagePolicyTest {
    @Test
    fun restoredPage_keepsRequestedHomePageWhenItStillExists() {
        val restoredPage = LauncherReloadPagePolicy.restoredPage(
            requestedPage = 3,
            homePageCount = 4,
            hasAppLibraryPage = true
        )

        assertEquals(3, restoredPage)
    }

    @Test
    fun restoredPage_clampsToLastHomePageWhenRequestedPageWasRemoved() {
        val restoredPage = LauncherReloadPagePolicy.restoredPage(
            requestedPage = 4,
            homePageCount = 2,
            hasAppLibraryPage = false
        )

        assertEquals(2, restoredPage)
    }
}

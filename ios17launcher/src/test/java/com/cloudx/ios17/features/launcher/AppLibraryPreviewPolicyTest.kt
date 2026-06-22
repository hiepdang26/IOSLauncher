package com.cloudx.ios17.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class AppLibraryPreviewPolicyTest {
    @Test
    fun shouldUseOverflowClusterOnlyWhenMoreThanFourApps() {
        assertFalse(AppLibraryPreviewPolicy.shouldUseOverflowCluster(appCount = 4))
        assertTrue(AppLibraryPreviewPolicy.shouldUseOverflowCluster(appCount = 5))
    }

    @Test
    fun overflowPreviewStartsAtFourthApp() {
        val apps = (1..9).map { index -> "app$index" }

        assertEquals(
            listOf("app4", "app5", "app6", "app7"),
            AppLibraryPreviewPolicy.overflowPreviewApps(apps)
        )
    }
}

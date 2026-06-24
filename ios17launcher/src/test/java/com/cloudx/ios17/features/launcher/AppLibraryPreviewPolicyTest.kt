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

    @Test
    fun previewSlotContentUsesOverflowClusterOnlyInFourthSlotWhenMoreThanFourApps() {
        assertEquals(
            AppLibraryPreviewPolicy.SlotContent.LARGE_ICON,
            AppLibraryPreviewPolicy.previewSlotContent(appCount = 5, slot = 0)
        )
        assertEquals(
            AppLibraryPreviewPolicy.SlotContent.LARGE_ICON,
            AppLibraryPreviewPolicy.previewSlotContent(appCount = 5, slot = 2)
        )
        assertEquals(
            AppLibraryPreviewPolicy.SlotContent.OVERFLOW_CLUSTER,
            AppLibraryPreviewPolicy.previewSlotContent(appCount = 5, slot = 3)
        )
    }

    @Test
    fun previewSlotContentKeepsFourthSlotLargeWhenThereAreOnlyFourApps() {
        assertEquals(
            AppLibraryPreviewPolicy.SlotContent.LARGE_ICON,
            AppLibraryPreviewPolicy.previewSlotContent(appCount = 4, slot = 3)
        )
    }
}

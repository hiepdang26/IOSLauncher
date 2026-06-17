package com.vhmsoft.launcherios26.ui.launcher.workspace

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherHomeEdgePreviewPolicyTest {
    @Test
    fun shouldUpdatePreview_skipsSourcePageBeforeDragLeavesSource() {
        assertFalse(
            LauncherHomeEdgePreviewPolicy.shouldUpdatePreview(
                dragActive = true,
                pageSwitching = false,
                dragPage = 0,
                sourcePage = 0,
                hasLeftSourcePage = false
            )
        )
    }

    @Test
    fun shouldUpdatePreview_allowsSourcePageAfterDragReturnsFromAnotherPage() {
        assertTrue(
            LauncherHomeEdgePreviewPolicy.shouldUpdatePreview(
                dragActive = true,
                pageSwitching = false,
                dragPage = 0,
                sourcePage = 0,
                hasLeftSourcePage = true
            )
        )
    }

    @Test
    fun shouldUpdatePreview_allowsNonSourcePage() {
        assertTrue(
            LauncherHomeEdgePreviewPolicy.shouldUpdatePreview(
                dragActive = true,
                pageSwitching = false,
                dragPage = 1,
                sourcePage = 0,
                hasLeftSourcePage = false
            )
        )
    }

    @Test
    fun shouldUpdatePreview_skipsWhilePageSwitching() {
        assertFalse(
            LauncherHomeEdgePreviewPolicy.shouldUpdatePreview(
                dragActive = true,
                pageSwitching = true,
                dragPage = 1,
                sourcePage = 0,
                hasLeftSourcePage = true
            )
        )
    }
}

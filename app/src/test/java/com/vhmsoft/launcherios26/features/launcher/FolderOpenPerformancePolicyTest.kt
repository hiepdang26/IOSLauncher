package com.vhmsoft.launcherios26.features.launcher

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class FolderOpenPerformancePolicyTest {
    @Test
    fun tapOpenedFolder_defersHeavyContentUntilOpenAnimationEnds() {
        assertTrue(
            FolderOpenPerformancePolicy.shouldDeferContentBinding(
                openedByDragHover = false
            )
        )
    }

    @Test
    fun dragHoverOpenedFolder_bindsContentImmediatelyForDropTargeting() {
        assertFalse(
            FolderOpenPerformancePolicy.shouldDeferContentBinding(
                openedByDragHover = true
            )
        )
    }

    @Test
    fun realtimeGlassBindingDoesNotDeferSoLiquidGlassIsVisibleWhenFolderOpens() {
        assertFalse(
            FolderOpenPerformancePolicy.shouldDeferRealtimeGlassBinding(
                openedByDragHover = false,
                liquidGlassEnabled = true
            )
        )
        assertFalse(
            FolderOpenPerformancePolicy.shouldDeferRealtimeGlassBinding(
                openedByDragHover = true,
                liquidGlassEnabled = true
            )
        )
        assertFalse(
            FolderOpenPerformancePolicy.shouldDeferRealtimeGlassBinding(
                openedByDragHover = false,
                liquidGlassEnabled = false
            )
        )
    }
}

package com.vhmsoft.launcherios26.ui.launcher

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherDragEdgeGlowPolicyTest {
    @Test
    fun homeDrag_showsBothEdgeRails() {
        val state = LauncherDragEdgeGlowPolicy.resolve(dragActive = true)

        assertTrue(state.showLeft)
        assertTrue(state.showRight)
    }

    @Test
    fun noDrag_hidesBothEdgeRails() {
        val state = LauncherDragEdgeGlowPolicy.resolve(dragActive = false)

        assertFalse(state.showLeft)
        assertFalse(state.showRight)
    }
}

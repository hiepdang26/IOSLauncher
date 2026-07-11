package com.vhmsoft.launcherios26.features.launcher

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherDragEdgeGlowPolicyTest {

    @Test
    fun activeDragShowsBothEdgeRails() {
        val state = LauncherDragEdgeGlowPolicy.resolve(dragActive = true)

        assertTrue(state.showLeft)
        assertTrue(state.showRight)
    }

    @Test
    fun inactiveDragHidesBothEdgeRails() {
        val state = LauncherDragEdgeGlowPolicy.resolve(dragActive = false)

        assertFalse(state.showLeft)
        assertFalse(state.showRight)
    }
}

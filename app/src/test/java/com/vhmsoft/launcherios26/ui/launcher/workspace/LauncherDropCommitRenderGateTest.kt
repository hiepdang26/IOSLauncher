package com.vhmsoft.launcherios26.ui.launcher.workspace

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherDropCommitRenderGateTest {
    @Test
    fun afterCommittedRender_waitsForTwoAnimationFramesBeforeRunningAction() {
        val postedFrames = mutableListOf<() -> Unit>()
        val gate = LauncherDropCommitRenderGate(
            postOnAnimation = { action -> postedFrames += action }
        )
        val events = mutableListOf<String>()

        gate.afterCommittedRender {
            events += "hide-preview"
        }

        assertTrue(events.isEmpty())
        assertEquals(1, postedFrames.size)

        postedFrames.removeAt(0).invoke()

        assertTrue(events.isEmpty())
        assertEquals(1, postedFrames.size)

        postedFrames.removeAt(0).invoke()

        assertEquals(listOf("hide-preview"), events)
        assertTrue(postedFrames.isEmpty())
    }
}

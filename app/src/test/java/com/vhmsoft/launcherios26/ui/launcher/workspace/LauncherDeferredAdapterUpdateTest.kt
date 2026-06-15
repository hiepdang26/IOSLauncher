package com.vhmsoft.launcherios26.ui.launcher.workspace

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherDeferredAdapterUpdateTest {
    @Test
    fun run_executesImmediatelyWhenAdapterCanNotify() {
        val gate = LauncherDeferredAdapterUpdate(
            shouldDefer = { false },
            post = { error("Should not post") }
        )
        var ran = false

        gate.run { ran = true }

        assertTrue(ran)
    }

    @Test
    fun run_postsLatestUpdateUntilAdapterCanNotify() {
        var shouldDefer = true
        val posted = mutableListOf<() -> Unit>()
        val gate = LauncherDeferredAdapterUpdate(
            shouldDefer = { shouldDefer },
            post = { runnable -> posted += runnable }
        )
        val events = mutableListOf<String>()

        gate.run { events += "first" }
        gate.run { events += "second" }

        assertTrue(events.isEmpty())
        assertEquals(1, posted.size)

        shouldDefer = false
        posted.removeAt(0).invoke()

        assertEquals(listOf("second"), events)
        assertFalse(gate.hasPendingUpdate())
    }

    @Test
    fun run_repostsWhenAdapterStillCannotNotify() {
        var shouldDefer = true
        val posted = mutableListOf<() -> Unit>()
        val gate = LauncherDeferredAdapterUpdate(
            shouldDefer = { shouldDefer },
            post = { runnable -> posted += runnable }
        )
        val events = mutableListOf<String>()

        gate.run { events += "update" }
        posted.removeAt(0).invoke()

        assertTrue(events.isEmpty())
        assertEquals(1, posted.size)

        shouldDefer = false
        posted.removeAt(0).invoke()

        assertEquals(listOf("update"), events)
    }

    @Test
    fun cancelPendingUpdate_preventsDeferredUpdateFromRunning() {
        var shouldDefer = true
        val posted = mutableListOf<() -> Unit>()
        val gate = LauncherDeferredAdapterUpdate(
            shouldDefer = { shouldDefer },
            post = { runnable -> posted += runnable }
        )
        var ran = false

        gate.run { ran = true }
        gate.cancelPendingUpdate()
        shouldDefer = false
        posted.removeAt(0).invoke()

        assertFalse(ran)
        assertFalse(gate.hasPendingUpdate())
    }
}

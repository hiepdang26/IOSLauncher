package com.vhmsoft.launcherios26.ui.launcher.workspace

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherSingleDragCommitGuardTest {
    @Test
    fun tryCommit_allowsOnlyOneCommitPerDrag() {
        val guard = LauncherSingleDragCommitGuard()

        guard.beginDrag()

        assertTrue(guard.tryCommit())
        assertFalse(guard.tryCommit())
    }

    @Test
    fun beginDrag_allowsCommitAfterPreviousDragCommitted() {
        val guard = LauncherSingleDragCommitGuard()

        guard.beginDrag()
        assertTrue(guard.tryCommit())

        guard.beginDrag()

        assertTrue(guard.tryCommit())
    }
}

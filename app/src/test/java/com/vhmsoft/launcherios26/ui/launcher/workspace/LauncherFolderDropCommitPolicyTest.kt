package com.vhmsoft.launcherios26.ui.launcher.workspace

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherFolderDropCommitPolicyTest {
    @Test
    fun shouldCommitBeforeAnimation_whenDropTargetIsPending() {
        assertTrue(
            LauncherFolderDropCommitPolicy.shouldCommitBeforeAnimation(
                hasPendingDropTarget = true
            )
        )
    }

    @Test
    fun shouldCommitBeforeAnimation_returnsFalseWithoutPendingDropTarget() {
        assertFalse(
            LauncherFolderDropCommitPolicy.shouldCommitBeforeAnimation(
                hasPendingDropTarget = false
            )
        )
    }
}

package com.vhmsoft.launcherios26.ui.launcher

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherDefaultSelectionPolicyTest {
    @Test
    fun promptConfirmation_opensSystemSelectionInsteadOfLaunchingHomeImmediately() {
        val action = LauncherDefaultSelectionPolicy.resolvePromptConfirmation(
            isCurrentDefaultLauncher = true
        )

        assertTrue(action.openSystemLauncherSelection)
        assertFalse(action.openLauncherImmediately)
    }
}

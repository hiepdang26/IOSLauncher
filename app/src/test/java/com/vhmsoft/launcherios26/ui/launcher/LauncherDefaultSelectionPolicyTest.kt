package com.vhmsoft.launcherios26.ui.launcher

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherDefaultSelectionPolicyTest {
    @Test
    fun promptConfirmation_alwaysOpensSystemSelectionWhenAlreadyDefault() {
        val action = LauncherDefaultSelectionPolicy.resolvePromptConfirmation(
            isCurrentDefaultLauncher = true
        )

        assertTrue(action.openSystemLauncherSelection)
        assertFalse(action.openLauncherImmediately)
    }

    @Test
    fun promptConfirmation_opensSystemSelectionWhenNotDefault() {
        val action = LauncherDefaultSelectionPolicy.resolvePromptConfirmation(
            isCurrentDefaultLauncher = false
        )

        assertTrue(action.openSystemLauncherSelection)
        assertFalse(action.openLauncherImmediately)
    }

    @Test
    fun systemLauncherSelection_usesHomeSettingsBeforeRoleRequestOnAndroidQAndNewer() {
        assertFalse(LauncherDefaultSelectionPolicy.shouldRequestHomeRoleBeforeSettings(sdkInt = 29))
        assertFalse(LauncherDefaultSelectionPolicy.shouldRequestHomeRoleBeforeSettings(sdkInt = 36))
    }

    @Test
    fun systemLauncherSelection_usesSettingsFallbackBeforeAndroidQ() {
        assertFalse(LauncherDefaultSelectionPolicy.shouldRequestHomeRoleBeforeSettings(sdkInt = 28))
    }
}

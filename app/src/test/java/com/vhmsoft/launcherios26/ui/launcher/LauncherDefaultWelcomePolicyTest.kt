package com.vhmsoft.launcherios26.ui.launcher

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherDefaultWelcomePolicyTest {
    @Test
    fun shouldShowWelcomeWhenLauncherJustBecameDefaultAndWelcomeWasNotShown() {
        assertTrue(
            LauncherDefaultWelcomePolicy.shouldShowWelcome(
                isDefaultLauncher = true,
                hasShownWelcome = false
            )
        )
    }

    @Test
    fun shouldNotShowWelcomeBeforeLauncherIsDefault() {
        assertFalse(
            LauncherDefaultWelcomePolicy.shouldShowWelcome(
                isDefaultLauncher = false,
                hasShownWelcome = false
            )
        )
    }

    @Test
    fun shouldNotShowWelcomeAgainAfterItWasShown() {
        assertFalse(
            LauncherDefaultWelcomePolicy.shouldShowWelcome(
                isDefaultLauncher = true,
                hasShownWelcome = true
            )
        )
    }
}

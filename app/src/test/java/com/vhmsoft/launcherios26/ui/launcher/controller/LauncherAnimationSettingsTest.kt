package com.vhmsoft.launcherios26.ui.launcher.controller

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherAnimationSettingsTest {
    @Test
    fun defaults_matchAnimationSettingsScreen() {
        val settings = LauncherAnimationSettings()

        assertTrue(settings.unlockEnabled)
        assertFalse(settings.openCloseEnabled)
        assertFalse(settings.parallaxZoomEnabled)
    }

    @Test
    fun openCloseToggle_controlsAppLaunchAnimation() {
        val enabled = LauncherAnimationSettings(openCloseEnabled = true)
        val disabled = LauncherAnimationSettings(openCloseEnabled = false)

        assertTrue(enabled.shouldAnimateAppOpen)
        assertFalse(disabled.shouldAnimateAppOpen)
    }
}

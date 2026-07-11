package com.vhmsoft.launcherios26.ui.launcher.controller

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherBlurSettingsTest {
    @Test
    fun dockBlurFollowsTopBlurSwitch() {
        assertTrue(
            LauncherBlurSettings(
                dockEnabled = true,
                folderEnabled = false,
                widgetEnabled = false,
                searchEnabled = false
            ).dockBlurActive
        )
        assertFalse(
            LauncherBlurSettings(
                dockEnabled = false,
                folderEnabled = true,
                widgetEnabled = true,
                searchEnabled = true
            ).dockBlurActive
        )
    }

    @Test
    fun dockDisabled_doesNotDisableOtherBlurTargets() {
        val settings = LauncherBlurSettings(
            dockEnabled = false,
            folderEnabled = true,
            widgetEnabled = true,
            searchEnabled = true
        )

        assertFalse(settings.dockBlurActive)
        assertTrue(settings.folderBlurActive)
        assertTrue(settings.widgetBlurActive)
        assertTrue(settings.searchBlurActive)
    }

    @Test
    fun targetSwitches_controlTheirOwnBlurIndependently() {
        val settings = LauncherBlurSettings(
            dockEnabled = false,
            folderEnabled = false,
            widgetEnabled = true,
            searchEnabled = false
        )

        assertFalse(settings.folderBlurActive)
        assertTrue(settings.widgetBlurActive)
        assertFalse(settings.searchBlurActive)
    }
}

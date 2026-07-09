package com.vhmsoft.launcherios26.ui.launcher.controller

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherBlurSettingsTest {
    @Test
    fun dockBlurFollowsTopBlurSwitch() {
        assertTrue(
            LauncherBlurSettings(
                enabled = true,
                folderEnabled = false,
                widgetEnabled = false,
                searchEnabled = false
            ).dockBlurActive
        )
        assertFalse(
            LauncherBlurSettings(
                enabled = false,
                folderEnabled = true,
                widgetEnabled = true,
                searchEnabled = true
            ).dockBlurActive
        )
    }

    @Test
    fun globalDisabled_disablesEveryBlurTarget() {
        val settings = LauncherBlurSettings(
            enabled = false,
            folderEnabled = true,
            widgetEnabled = true,
            searchEnabled = true
        )

        assertFalse(settings.folderBlurActive)
        assertFalse(settings.widgetBlurActive)
        assertFalse(settings.searchBlurActive)
    }

    @Test
    fun targetSwitches_controlTheirOwnBlurWhenGlobalEnabled() {
        val settings = LauncherBlurSettings(
            enabled = true,
            folderEnabled = false,
            widgetEnabled = true,
            searchEnabled = false
        )

        assertFalse(settings.folderBlurActive)
        assertTrue(settings.widgetBlurActive)
        assertFalse(settings.searchBlurActive)
    }
}

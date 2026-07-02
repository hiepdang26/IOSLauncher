package com.vhmsoft.launcherios26.ui.launcher

import org.junit.Assert.assertEquals
import org.junit.Test

class LauncherSettingsSwitchStylePolicyTest {
    @Test
    fun checkedSwitch_usesIosGreenTrackWithWhiteThumb() {
        assertEquals(0xFF34C759.toInt(), LauncherSettingsSwitchStylePolicy.CHECKED_TRACK_COLOR)
        assertEquals(0xFF2FBF5B.toInt(), LauncherSettingsSwitchStylePolicy.CHECKED_TRACK_STROKE_COLOR)
        assertEquals(0xFFFFFFFF.toInt(), LauncherSettingsSwitchStylePolicy.CHECKED_THUMB_COLOR)
        assertEquals(0xFFE5E5EA.toInt(), LauncherSettingsSwitchStylePolicy.THUMB_STROKE_COLOR)
    }

    @Test
    fun uncheckedSwitch_usesWhiteTrackWithRedThumb() {
        assertEquals(0xFFFFFFFF.toInt(), LauncherSettingsSwitchStylePolicy.UNCHECKED_TRACK_COLOR)
        assertEquals(0xFFFF5A3D.toInt(), LauncherSettingsSwitchStylePolicy.UNCHECKED_THUMB_COLOR)
        assertEquals(0xFFE5E5EA.toInt(), LauncherSettingsSwitchStylePolicy.UNCHECKED_TRACK_STROKE_COLOR)
    }

    @Test
    fun settingsSwitch_isCompactEnoughToAvoidClippingTheWhiteThumb() {
        assertEquals(54, LauncherSettingsSwitchStylePolicy.switchViewWidthDp)
        assertEquals(36, LauncherSettingsSwitchStylePolicy.switchViewHeightDp)
        assertEquals(46, LauncherSettingsSwitchStylePolicy.trackWidthDp)
        assertEquals(28, LauncherSettingsSwitchStylePolicy.trackHeightDp)
        assertEquals(26, LauncherSettingsSwitchStylePolicy.thumbSizeDp)
        assertEquals(1, LauncherSettingsSwitchStylePolicy.strokeWidthDp)
    }
}

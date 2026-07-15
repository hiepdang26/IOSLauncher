package com.vhmsoft.launcherios26.core

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherSpecialAppTypePolicyTest {
    @Test
    fun recognizesAndroidDeskClockPackage() {
        assertTrue(
            LauncherSpecialAppTypePolicy.isClockApp(
                label = "Clock",
                packageName = "com.android.deskclock",
                className = "com.android.deskclock.DeskClockTabActivity"
            )
        )
    }

    @Test
    fun recognizesVietnameseClockLabel() {
        assertTrue(
            LauncherSpecialAppTypePolicy.isClockApp(
                label = "Đồng hồ",
                packageName = "com.miui.notes",
                className = "com.miui.notes.MainActivity"
            )
        )
    }

    @Test
    fun ignoresNonLaunchableTimeServicePackages() {
        assertFalse(
            LauncherSpecialAppTypePolicy.isClockApp(
                label = "Time Service",
                packageName = "com.qualcomm.timeservice",
                className = "com.qualcomm.timeservice.TimeService"
            )
        )
    }
}

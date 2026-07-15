package com.vhmsoft.launcherios26.features.launcher

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherSelfLaunchPolicyTest {
    @Test
    fun shouldOpenLauncherMenuForCurrentLauncherPackage() {
        assertTrue(
            LauncherSelfLaunchPolicy.shouldOpenLauncherMenu(
                itemPackageName = "com.vhmsoft.launcherios26",
                targetPackageName = "com.vhmsoft.launcherios26",
                launcherPackageName = "com.vhmsoft.launcherios26"
            )
        )
    }

    @Test
    fun shouldOpenLauncherMenuWhenOnlyTargetComponentMatchesCurrentPackage() {
        assertTrue(
            LauncherSelfLaunchPolicy.shouldOpenLauncherMenu(
                itemPackageName = null,
                targetPackageName = "com.vhmsoft.launcherios26",
                launcherPackageName = "com.vhmsoft.launcherios26"
            )
        )
    }

    @Test
    fun shouldNotOpenLauncherMenuForExternalApps() {
        assertFalse(
            LauncherSelfLaunchPolicy.shouldOpenLauncherMenu(
                itemPackageName = "com.android.vending",
                targetPackageName = "com.android.vending",
                launcherPackageName = "com.vhmsoft.launcherios26"
            )
        )
    }
}

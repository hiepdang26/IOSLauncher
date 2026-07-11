package com.vhmsoft.launcherios26.features.launcher

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherInstalledAppRevealPolicyTest {
    @Test
    fun revealsOnlyWhenLauncherIsResumedAndTargetIsHomePage() {
        assertTrue(
            LauncherInstalledAppRevealPolicy.shouldReveal(
                launcherResumed = true,
                targetPagerPage = 2,
                homePageCount = 3
            )
        )
        assertFalse(
            LauncherInstalledAppRevealPolicy.shouldReveal(
                launcherResumed = false,
                targetPagerPage = 2,
                homePageCount = 3
            )
        )
        assertFalse(
            LauncherInstalledAppRevealPolicy.shouldReveal(
                launcherResumed = true,
                targetPagerPage = 0,
                homePageCount = 3
            )
        )
        assertFalse(
            LauncherInstalledAppRevealPolicy.shouldReveal(
                launcherResumed = true,
                targetPagerPage = 4,
                homePageCount = 3
            )
        )
    }

    @Test
    fun bloomAnimationUsesFastOvershootScales() {
        assertTrue(LauncherInstalledAppRevealPolicy.INITIAL_SCALE < 1f)
        assertTrue(LauncherInstalledAppRevealPolicy.PEAK_SCALE > 1f)
        assertTrue(LauncherInstalledAppRevealPolicy.SETTLE_SCALE < 1f)
        assertTrue(
            LauncherInstalledAppRevealPolicy.ALPHA_DURATION_MS <
                LauncherInstalledAppRevealPolicy.REVEAL_DURATION_MS
        )
    }
}

package com.vhmsoft.launcherios26.features.launcher

object LauncherInstalledAppRevealPolicy {
    const val INITIAL_SCALE = 0.35f
    const val PEAK_SCALE = 1.16f
    const val SETTLE_SCALE = 0.96f
    const val FINAL_SCALE = 1f
    const val REVEAL_DURATION_MS = 260L
    const val ALPHA_DURATION_MS = 90L

    fun shouldReveal(
        launcherResumed: Boolean,
        targetPagerPage: Int,
        homePageCount: Int
    ): Boolean {
        return launcherResumed && targetPagerPage in 1..homePageCount
    }
}

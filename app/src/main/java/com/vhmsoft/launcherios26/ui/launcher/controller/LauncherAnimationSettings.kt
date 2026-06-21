package com.vhmsoft.launcherios26.ui.launcher.controller

data class LauncherAnimationSettings(
    val unlockEnabled: Boolean = true,
    val openCloseEnabled: Boolean = false,
    val parallaxZoomEnabled: Boolean = false
) {
    val shouldAnimateAppOpen: Boolean = openCloseEnabled
}

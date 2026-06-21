package com.vhmsoft.launcherios26.ui.launcher

object LauncherDefaultWelcomePolicy {
    fun shouldShowWelcome(
        isDefaultLauncher: Boolean,
        hasShownWelcome: Boolean
    ): Boolean {
        return isDefaultLauncher && !hasShownWelcome
    }
}

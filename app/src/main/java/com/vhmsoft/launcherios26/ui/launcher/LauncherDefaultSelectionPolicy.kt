package com.vhmsoft.launcherios26.ui.launcher

object LauncherDefaultSelectionPolicy {
    fun resolvePromptConfirmation(
        isCurrentDefaultLauncher: Boolean
    ): DefaultLauncherPromptAction {
        return DefaultLauncherPromptAction(
            openSystemLauncherSelection = true,
            openLauncherImmediately = false
        )
    }

    fun shouldRequestHomeRoleBeforeSettings(sdkInt: Int): Boolean {
        return false
    }
}

data class DefaultLauncherPromptAction(
    val openSystemLauncherSelection: Boolean,
    val openLauncherImmediately: Boolean
)

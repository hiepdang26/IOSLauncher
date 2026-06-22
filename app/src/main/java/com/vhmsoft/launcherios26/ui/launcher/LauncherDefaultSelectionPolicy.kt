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
}

data class DefaultLauncherPromptAction(
    val openSystemLauncherSelection: Boolean,
    val openLauncherImmediately: Boolean
)

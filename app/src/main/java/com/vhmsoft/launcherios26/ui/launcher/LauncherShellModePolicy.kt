package com.vhmsoft.launcherios26.ui.launcher

object LauncherShellModePolicy {
    @Suppress("UNUSED_PARAMETER")
    fun shouldShowWorkspace(
        isCurrentDefaultLauncher: Boolean,
        forceSettingsPanel: Boolean
    ): Boolean = false

    fun shouldInitializeWorkspace(): Boolean = false

    fun shouldLoadWorkspaceData(): Boolean = false

    fun shouldShowFullOptionsMenu(): Boolean = true
}

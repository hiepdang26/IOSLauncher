package com.vhmsoft.launcherios26.ui.launcher.workspace

internal object LauncherFolderDropCommitPolicy {
    fun shouldCommitBeforeAnimation(hasPendingDropTarget: Boolean): Boolean {
        return hasPendingDropTarget
    }
}

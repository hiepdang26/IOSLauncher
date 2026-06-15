package com.vhmsoft.launcherios26.ui.launcher.workspace

internal class LauncherSingleDragCommitGuard {
    private var committed = false

    fun beginDrag() {
        committed = false
    }

    fun tryCommit(): Boolean {
        if (committed) return false
        committed = true
        return true
    }
}

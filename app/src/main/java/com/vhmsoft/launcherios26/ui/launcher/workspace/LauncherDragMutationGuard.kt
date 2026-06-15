package com.vhmsoft.launcherios26.ui.launcher.workspace

internal object LauncherDragMutationGuard {
    fun canMutate(
        isComputingLayout: Boolean,
        itemAnimatorRunning: Boolean,
        hasPendingAdapterUpdates: Boolean,
        isScrollIdle: Boolean
    ): Boolean {
        return !isComputingLayout &&
            !itemAnimatorRunning &&
            !hasPendingAdapterUpdates &&
            isScrollIdle
    }
}

package com.vhmsoft.launcherios26.ui.launcher.workspace

import androidx.recyclerview.widget.RecyclerView

internal object LauncherPageBindDeferral {
    fun shouldDefer(
        childComputingLayout: Boolean,
        childItemAnimatorRunning: Boolean,
        parentComputingLayout: Boolean,
        parentScrollState: Int
    ): Boolean {
        return childComputingLayout ||
            childItemAnimatorRunning ||
            parentComputingLayout ||
            parentScrollState != RecyclerView.SCROLL_STATE_IDLE
    }
}

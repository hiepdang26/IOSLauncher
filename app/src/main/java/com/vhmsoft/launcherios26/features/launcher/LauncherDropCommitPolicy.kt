package com.vhmsoft.launcherios26.features.launcher

object LauncherDropCommitPolicy {
    fun shouldAttachToTargetPage(
        movingHasParent: Boolean,
        movingParentIsTargetPage: Boolean
    ): Boolean = true

    fun targetInsertIndex(requestedIndex: Int, childCount: Int): Int {
        return if (requestedIndex < 0 || requestedIndex > childCount) {
            childCount
        } else {
            requestedIndex
        }
    }
}

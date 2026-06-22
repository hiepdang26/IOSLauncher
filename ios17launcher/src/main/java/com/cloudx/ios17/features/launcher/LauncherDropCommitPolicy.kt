package com.cloudx.ios17.features.launcher

object LauncherDropCommitPolicy {
    fun shouldAttachToTargetPage(
        movingHasParent: Boolean,
        movingParentIsTargetPage: Boolean
    ): Boolean = !movingHasParent || !movingParentIsTargetPage

    fun targetInsertIndex(requestedIndex: Int, childCount: Int): Int {
        return if (requestedIndex < 0 || requestedIndex > childCount) {
            childCount
        } else {
            requestedIndex
        }
    }
}

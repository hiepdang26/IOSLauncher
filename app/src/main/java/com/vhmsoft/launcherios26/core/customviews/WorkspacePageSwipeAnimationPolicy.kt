package com.vhmsoft.launcherios26.core.customviews

import kotlin.math.roundToInt

internal object WorkspacePageSwipeAnimationPolicy {
    const val LEGACY_PAGE_SNAP_DURATION_MS = 750
    const val PAGE_SNAP_DURATION_MS = 480

    private const val FLING_DURATION_SCALE = 0.72f

    fun pageSnapDuration(isInOverScroll: Boolean, overScrollDurationMs: Int): Int {
        return if (isInOverScroll) overScrollDurationMs else PAGE_SNAP_DURATION_MS
    }

    fun flingSnapDuration(calculatedDurationMs: Int): Int {
        return (calculatedDurationMs * FLING_DURATION_SCALE)
            .roundToInt()
            .coerceAtMost(PagedView.SLOW_PAGE_SNAP_ANIMATION_DURATION)
    }
}

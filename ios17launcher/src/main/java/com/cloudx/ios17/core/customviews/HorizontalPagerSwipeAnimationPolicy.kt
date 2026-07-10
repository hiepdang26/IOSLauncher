package com.cloudx.ios17.core.customviews

import kotlin.math.floor
import kotlin.math.max
import kotlin.math.min

internal object HorizontalPagerSwipeAnimationPolicy {
    const val LEGACY_PAGE_SNAP_DURATION_MS = 400
    const val PAGE_SNAP_DURATION_MS = 720

    const val LEGACY_SNAP_VELOCITY_PX_PER_SECOND = 1000
    const val SNAP_VELOCITY_PX_PER_SECOND = 1400

    private const val DESTINATION_THRESHOLD_DIVISOR = 5

    fun destinationPage(
        scrollX: Int,
        currentPageStartX: Int,
        currentPage: Int,
        childCount: Int,
        width: Int
    ): Int {
        val threshold = width / DESTINATION_THRESHOLD_DIVISOR
        return when {
            scrollX < currentPageStartX - threshold -> max(0, currentPage - 1)
            scrollX > currentPageStartX + threshold -> min(childCount - 1, currentPage + 1)
            else -> currentPage
        }
    }

    fun drawnPageRange(
        scrollX: Int,
        viewportWidth: Int,
        pageWidth: Int,
        childCount: Int
    ): IntRange {
        if (viewportWidth <= 0 || pageWidth <= 0 || childCount <= 0) {
            return 0..-1
        }
        val firstVisible = floor(scrollX / pageWidth.toFloat()).toInt()
        val lastVisible = floor((scrollX + viewportWidth - 1) / pageWidth.toFloat()).toInt()
        val firstDrawn = max(0, firstVisible - 1)
        val lastDrawn = min(childCount - 1, lastVisible + 1)
        return firstDrawn..lastDrawn
    }

    fun shouldFinishSettlingBeforeChildTouch(scrollerFinished: Boolean): Boolean {
        return !scrollerFinished
    }
}

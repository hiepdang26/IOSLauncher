package com.vhmsoft.launcherios26.ui.launcher.workspace

internal object LauncherPageIndicatorWindowPolicy {
    data class Marker(
        val pageIndex: Int,
        val state: MarkerState
    )

    data class ScrollFrame(
        val fromMarkers: List<Marker>,
        val toMarkers: List<Marker>,
        val direction: SlideDirection,
        val progress: Float
    )

    enum class MarkerState {
        SMALL,
        INACTIVE,
        ACTIVE
    }

    enum class SlideDirection {
        BACKWARD,
        NONE,
        FORWARD
    }

    fun markers(
        pageCount: Int,
        selectedPage: Int,
        maxVisibleMarkers: Int = DEFAULT_MAX_VISIBLE_MARKERS
    ): List<Marker> {
        if (pageCount <= 0) return emptyList()

        val visibleCount = minOf(pageCount, maxVisibleMarkers.coerceAtLeast(1))
        val boundedSelectedPage = selectedPage.coerceIn(0, pageCount - 1)
        if (pageCount > maxVisibleMarkers) {
            val activeSlot = if (boundedSelectedPage >= pageCount - 2) {
                LAST_PAGE_ACTIVE_SLOT
            } else {
                FIRST_PAGE_ACTIVE_SLOT
            }
            val windowStart = boundedSelectedPage - activeSlot
            return (windowStart until windowStart + maxVisibleMarkers).map { pageIndex ->
                Marker(
                    pageIndex = pageIndex,
                    state = when {
                        pageIndex == boundedSelectedPage -> MarkerState.ACTIVE
                        pageIndex !in 0 until pageCount -> MarkerState.SMALL
                        pageIndex == windowStart && windowStart > 0 -> MarkerState.SMALL
                        pageIndex == windowStart + maxVisibleMarkers - 1 &&
                            windowStart + maxVisibleMarkers < pageCount -> MarkerState.SMALL
                        else -> MarkerState.INACTIVE
                    }
                )
            }
        }

        val maxWindowStart = (pageCount - visibleCount).coerceAtLeast(0)
        val windowStart = when {
            pageCount <= visibleCount -> 0
            boundedSelectedPage <= 1 -> 0
            boundedSelectedPage >= pageCount - 2 -> maxWindowStart
            else -> boundedSelectedPage - 1
        }.coerceIn(0, maxWindowStart)
        val windowEndExclusive = windowStart + visibleCount
        val hasHiddenLeftPages = windowStart > 0
        val hasHiddenRightPages = windowEndExclusive < pageCount

        return (windowStart until windowEndExclusive).map { pageIndex ->
            Marker(
                pageIndex = pageIndex,
                state = when {
                    pageIndex == boundedSelectedPage -> MarkerState.ACTIVE
                    pageIndex == windowStart && hasHiddenLeftPages -> MarkerState.SMALL
                    pageIndex == windowEndExclusive - 1 && hasHiddenRightPages -> MarkerState.SMALL
                    else -> MarkerState.INACTIVE
                }
            )
        }
    }

    fun slideDirection(
        currentPages: List<Int>,
        nextPages: List<Int>
    ): SlideDirection {
        val currentFirst = currentPages.firstOrNull() ?: return SlideDirection.NONE
        val nextFirst = nextPages.firstOrNull() ?: return SlideDirection.NONE
        return when {
            nextFirst > currentFirst -> SlideDirection.FORWARD
            nextFirst < currentFirst -> SlideDirection.BACKWARD
            else -> SlideDirection.NONE
        }
    }

    fun wheelMarkers(
        currentMarkers: List<Marker>,
        nextMarkers: List<Marker>,
        direction: SlideDirection
    ): List<Marker> {
        return when (direction) {
            SlideDirection.FORWARD -> currentMarkers + listOfNotNull(nextMarkers.lastOrNull())
            SlideDirection.BACKWARD -> listOfNotNull(nextMarkers.firstOrNull()) + currentMarkers
            SlideDirection.NONE -> nextMarkers
        }
    }

    fun markerCenterOffset(
        slot: Int,
        markerCount: Int,
        dotStepPx: Float
    ): Float {
        val visibleCount = markerCount.coerceAtLeast(1)
        return (slot - (visibleCount - 1) / 2f) * dotStepPx
    }

    fun markerCenterOffsets(
        markerCount: Int,
        dotStepPx: Float
    ): List<Float> {
        if (markerCount <= 0) return emptyList()
        return (0 until markerCount).map { slot ->
            markerCenterOffset(slot, markerCount, dotStepPx)
        }
    }

    fun scrollFrame(
        pageCount: Int,
        pagePosition: Float
    ): ScrollFrame {
        if (pageCount <= 0) {
            return ScrollFrame(
                fromMarkers = emptyList(),
                toMarkers = emptyList(),
                direction = SlideDirection.NONE,
                progress = 0f
            )
        }

        val lastPage = pageCount - 1
        val boundedPosition = pagePosition.coerceIn(0f, lastPage.toFloat())
        val fromPage = boundedPosition.toInt().coerceIn(0, lastPage)
        val rawProgress = boundedPosition - fromPage
        val toPage = if (rawProgress <= 0f) {
            fromPage
        } else {
            (fromPage + 1).coerceAtMost(lastPage)
        }
        val fromMarkers = markers(pageCount, fromPage)
        val toMarkers = markers(pageCount, toPage)
        return ScrollFrame(
            fromMarkers = fromMarkers,
            toMarkers = toMarkers,
            direction = slideDirection(
                currentPages = fromMarkers.map { marker -> marker.pageIndex },
                nextPages = toMarkers.map { marker -> marker.pageIndex }
            ),
            progress = if (fromPage == toPage) 0f else rawProgress.coerceIn(0f, 1f)
        )
    }

    const val DEFAULT_MAX_VISIBLE_MARKERS = 4
    private const val FIRST_PAGE_ACTIVE_SLOT = 1
    private const val LAST_PAGE_ACTIVE_SLOT = 2
}

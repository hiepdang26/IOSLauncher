package com.vhmsoft.launcherios26.ui.launcher.workspace

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherPageIndicatorWindowPolicyTest {
    @Test
    fun markers_showEveryPageWhenPageCountFitsVisibleWindow() {
        val markers = LauncherPageIndicatorWindowPolicy.markers(
            pageCount = 3,
            selectedPage = 1
        )

        assertEquals(
            listOf(
                marker(0, LauncherPageIndicatorWindowPolicy.MarkerState.INACTIVE),
                marker(1, LauncherPageIndicatorWindowPolicy.MarkerState.ACTIVE),
                marker(2, LauncherPageIndicatorWindowPolicy.MarkerState.INACTIVE)
            ),
            markers
        )
    }

    @Test
    fun markerCenterOffsets_centerTwoDotsInsideIndicator() {
        assertOffsets(
            expected = listOf(-7f, 7f),
            actual = LauncherPageIndicatorWindowPolicy.markerCenterOffsets(
                markerCount = 2,
                dotStepPx = 14f
            )
        )
    }

    @Test
    fun markerCenterOffsets_centerThreeDotsInsideIndicator() {
        assertOffsets(
            expected = listOf(-14f, 0f, 14f),
            actual = LauncherPageIndicatorWindowPolicy.markerCenterOffsets(
                markerCount = 3,
                dotStepPx = 14f
            )
        )
    }

    @Test
    fun markerCenterOffsets_keepFourDotsInFullIndicatorWindow() {
        assertOffsets(
            expected = listOf(-21f, -7f, 7f, 21f),
            actual = LauncherPageIndicatorWindowPolicy.markerCenterOffsets(
                markerCount = 4,
                dotStepPx = 14f
            )
        )
    }

    @Test
    fun markers_keepFirstPageActiveOnMiddleLeftDotWhenMorePagesExistOnTheRight() {
        val markers = LauncherPageIndicatorWindowPolicy.markers(
            pageCount = 6,
            selectedPage = 0
        )

        assertEquals(
            listOf(
                marker(-1, LauncherPageIndicatorWindowPolicy.MarkerState.SMALL),
                marker(0, LauncherPageIndicatorWindowPolicy.MarkerState.ACTIVE),
                marker(1, LauncherPageIndicatorWindowPolicy.MarkerState.INACTIVE),
                marker(2, LauncherPageIndicatorWindowPolicy.MarkerState.SMALL)
            ),
            markers
        )
    }

    @Test
    fun markers_useSmallDotsOnBothSidesWhenSelectedPageIsInTheMiddle() {
        val markers = LauncherPageIndicatorWindowPolicy.markers(
            pageCount = 6,
            selectedPage = 2
        )

        assertEquals(
            listOf(
                marker(1, LauncherPageIndicatorWindowPolicy.MarkerState.SMALL),
                marker(2, LauncherPageIndicatorWindowPolicy.MarkerState.ACTIVE),
                marker(3, LauncherPageIndicatorWindowPolicy.MarkerState.INACTIVE),
                marker(4, LauncherPageIndicatorWindowPolicy.MarkerState.SMALL)
            ),
            markers
        )
    }

    @Test
    fun markers_keepLastPageActiveOnMiddleRightDotWhenHiddenPagesExistOnTheLeft() {
        val markers = LauncherPageIndicatorWindowPolicy.markers(
            pageCount = 6,
            selectedPage = 5
        )

        assertEquals(
            listOf(
                marker(3, LauncherPageIndicatorWindowPolicy.MarkerState.SMALL),
                marker(4, LauncherPageIndicatorWindowPolicy.MarkerState.INACTIVE),
                marker(5, LauncherPageIndicatorWindowPolicy.MarkerState.ACTIVE),
                marker(6, LauncherPageIndicatorWindowPolicy.MarkerState.SMALL)
            ),
            markers
        )
    }

    @Test
    fun slideDirection_reportsForwardWhenWindowMovesToHigherPages() {
        assertEquals(
            LauncherPageIndicatorWindowPolicy.SlideDirection.FORWARD,
            LauncherPageIndicatorWindowPolicy.slideDirection(
                currentPages = listOf(-1, 0, 1, 2),
                nextPages = listOf(0, 1, 2, 3)
            )
        )
    }

    @Test
    fun slideDirection_reportsBackwardWhenWindowMovesToLowerPages() {
        assertEquals(
            LauncherPageIndicatorWindowPolicy.SlideDirection.BACKWARD,
            LauncherPageIndicatorWindowPolicy.slideDirection(
                currentPages = listOf(0, 1, 2, 3),
                nextPages = listOf(-1, 0, 1, 2)
            )
        )
    }

    @Test
    fun wheelMarkers_appendIncomingRightMarkerWhenSlidingForward() {
        val current = listOf(
            marker(0, LauncherPageIndicatorWindowPolicy.MarkerState.ACTIVE),
            marker(1, LauncherPageIndicatorWindowPolicy.MarkerState.INACTIVE),
            marker(2, LauncherPageIndicatorWindowPolicy.MarkerState.INACTIVE),
            marker(3, LauncherPageIndicatorWindowPolicy.MarkerState.SMALL)
        )
        val next = listOf(
            marker(1, LauncherPageIndicatorWindowPolicy.MarkerState.SMALL),
            marker(2, LauncherPageIndicatorWindowPolicy.MarkerState.ACTIVE),
            marker(3, LauncherPageIndicatorWindowPolicy.MarkerState.INACTIVE),
            marker(4, LauncherPageIndicatorWindowPolicy.MarkerState.SMALL)
        )

        assertEquals(
            current + next.last(),
            LauncherPageIndicatorWindowPolicy.wheelMarkers(
                currentMarkers = current,
                nextMarkers = next,
                direction = LauncherPageIndicatorWindowPolicy.SlideDirection.FORWARD
            )
        )
    }

    @Test
    fun wheelMarkers_prependIncomingLeftMarkerWhenSlidingBackward() {
        val current = listOf(
            marker(1, LauncherPageIndicatorWindowPolicy.MarkerState.SMALL),
            marker(2, LauncherPageIndicatorWindowPolicy.MarkerState.ACTIVE),
            marker(3, LauncherPageIndicatorWindowPolicy.MarkerState.INACTIVE),
            marker(4, LauncherPageIndicatorWindowPolicy.MarkerState.SMALL)
        )
        val next = listOf(
            marker(0, LauncherPageIndicatorWindowPolicy.MarkerState.ACTIVE),
            marker(1, LauncherPageIndicatorWindowPolicy.MarkerState.INACTIVE),
            marker(2, LauncherPageIndicatorWindowPolicy.MarkerState.INACTIVE),
            marker(3, LauncherPageIndicatorWindowPolicy.MarkerState.SMALL)
        )

        assertEquals(
            listOf(next.first()) + current,
            LauncherPageIndicatorWindowPolicy.wheelMarkers(
                currentMarkers = current,
                nextMarkers = next,
                direction = LauncherPageIndicatorWindowPolicy.SlideDirection.BACKWARD
            )
        )
    }

    @Test
    fun scrollFrame_reportsRealtimeProgressBetweenPages() {
        val frame = LauncherPageIndicatorWindowPolicy.scrollFrame(
            pageCount = 6,
            pagePosition = 1.35f
        )

        assertEquals(
            LauncherPageIndicatorWindowPolicy.markers(pageCount = 6, selectedPage = 1),
            frame.fromMarkers
        )
        assertEquals(
            LauncherPageIndicatorWindowPolicy.markers(pageCount = 6, selectedPage = 2),
            frame.toMarkers
        )
        assertEquals(LauncherPageIndicatorWindowPolicy.SlideDirection.FORWARD, frame.direction)
        assertTrue(kotlin.math.abs(frame.progress - 0.35f) < 0.001f)
    }

    @Test
    fun scrollFrame_clampsPastLastPageToFinalMarkersWithoutProgress() {
        val frame = LauncherPageIndicatorWindowPolicy.scrollFrame(
            pageCount = 5,
            pagePosition = 4.8f
        )

        assertEquals(
            LauncherPageIndicatorWindowPolicy.markers(pageCount = 5, selectedPage = 4),
            frame.fromMarkers
        )
        assertEquals(frame.fromMarkers, frame.toMarkers)
        assertEquals(LauncherPageIndicatorWindowPolicy.SlideDirection.NONE, frame.direction)
        assertEquals(0f, frame.progress)
    }

    private fun marker(
        pageIndex: Int,
        state: LauncherPageIndicatorWindowPolicy.MarkerState
    ): LauncherPageIndicatorWindowPolicy.Marker {
        return LauncherPageIndicatorWindowPolicy.Marker(pageIndex, state)
    }

    private fun assertOffsets(
        expected: List<Float>,
        actual: List<Float>
    ) {
        assertEquals(expected.size, actual.size)
        expected.zip(actual).forEach { (expectedOffset, actualOffset) ->
            assertEquals(expectedOffset, actualOffset, 0.001f)
        }
    }
}

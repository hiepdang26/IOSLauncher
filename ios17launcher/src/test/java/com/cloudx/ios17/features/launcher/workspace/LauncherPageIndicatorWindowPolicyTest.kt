package com.cloudx.ios17.features.launcher.workspace

import org.junit.Assert.assertEquals
import org.junit.Test

class LauncherPageIndicatorWindowPolicyTest {

    @Test
    fun markersLimitVisibleDotsAndKeepSelectedActive() {
        val markers = LauncherPageIndicatorWindowPolicy.markers(pageCount = 7, selectedPage = 3)

        assertEquals(4, markers.size)
        assertEquals(3, markers.single { it.state == LauncherPageIndicatorWindowPolicy.MarkerState.ACTIVE }.pageIndex)
        assertEquals(LauncherPageIndicatorWindowPolicy.MarkerState.SMALL, markers.first().state)
        assertEquals(LauncherPageIndicatorWindowPolicy.MarkerState.SMALL, markers.last().state)
    }

    @Test
    fun scrollFrameInterpolatesBetweenPages() {
        val frame = LauncherPageIndicatorWindowPolicy.scrollFrame(pageCount = 5, pagePosition = 1.5f)

        assertEquals(0.5f, frame.progress, 0.001f)
        assertEquals(1, frame.fromMarkers.single { it.state == LauncherPageIndicatorWindowPolicy.MarkerState.ACTIVE }.pageIndex)
        assertEquals(2, frame.toMarkers.single { it.state == LauncherPageIndicatorWindowPolicy.MarkerState.ACTIVE }.pageIndex)
    }
}

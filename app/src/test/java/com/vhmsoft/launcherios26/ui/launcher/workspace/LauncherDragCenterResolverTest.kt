package com.vhmsoft.launcherios26.ui.launcher.workspace

import org.junit.Assert.assertEquals
import org.junit.Test

class LauncherDragCenterResolverTest {
    @Test
    fun resolve_prefersRawTouchWhenRecyclerDeltaDriftsDuringReorder() {
        val center = LauncherDragCenterResolver.resolve(
            dragStartCenterX = 100f,
            dragStartCenterY = 100f,
            dX = 260f,
            dY = -120f,
            rawTouch = Pair(132f, 146f),
            touchToCenterOffsetX = 8f,
            touchToCenterOffsetY = -6f
        )

        assertEquals(Pair(140f, 140f), center)
    }

    @Test
    fun resolve_fallsBackToRecyclerDeltaWhenRawTouchIsMissing() {
        val center = LauncherDragCenterResolver.resolve(
            dragStartCenterX = 100f,
            dragStartCenterY = 100f,
            dX = 24f,
            dY = -12f,
            rawTouch = null,
            touchToCenterOffsetX = 8f,
            touchToCenterOffsetY = -6f
        )

        assertEquals(Pair(124f, 88f), center)
    }
}

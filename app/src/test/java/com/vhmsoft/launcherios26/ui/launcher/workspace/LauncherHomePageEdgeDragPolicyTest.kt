package com.vhmsoft.launcherios26.ui.launcher.workspace

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherHomePageEdgeDragPolicyTest {
    @Test
    fun directionForCenter_returnsLeftInsideExpandedLeftEdgeZone() {
        assertEquals(
            -1,
            LauncherHomePageEdgeDragPolicy.directionForCenter(
                rootCenterX = 54f,
                rootWidth = 390,
                edgeZonePx = LauncherHomePageEdgeDragPolicy.DEFAULT_EDGE_ZONE_DP
            )
        )
    }

    @Test
    fun directionForCenter_returnsRightInsideExpandedRightEdgeZone() {
        assertEquals(
            1,
            LauncherHomePageEdgeDragPolicy.directionForCenter(
                rootCenterX = 336f,
                rootWidth = 390,
                edgeZonePx = LauncherHomePageEdgeDragPolicy.DEFAULT_EDGE_ZONE_DP
            )
        )
    }

    @Test
    fun directionForCenter_returnsNoneAwayFromEdges() {
        assertEquals(
            0,
            LauncherHomePageEdgeDragPolicy.directionForCenter(
                rootCenterX = 96f,
                rootWidth = 390,
                edgeZonePx = LauncherHomePageEdgeDragPolicy.DEFAULT_EDGE_ZONE_DP
            )
        )
    }

    @Test
    fun shouldStart_returnsTrueOnlyWhenEditingValidItemAndInEdgeZone() {
        assertTrue(
            LauncherHomePageEdgeDragPolicy.shouldStart(
                editingHome = true,
                hasDraggableItem = true,
                alreadyActive = false,
                direction = -1
            )
        )

        assertFalse(
            LauncherHomePageEdgeDragPolicy.shouldStart(
                editingHome = true,
                hasDraggableItem = true,
                alreadyActive = false,
                direction = 0
            )
        )
    }

    @Test
    fun shouldStart_keepsActiveDragHandlingOutsideEdgeZone() {
        assertTrue(
            LauncherHomePageEdgeDragPolicy.shouldStart(
                editingHome = true,
                hasDraggableItem = true,
                alreadyActive = true,
                direction = 0
            )
        )
    }
}

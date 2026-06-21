package com.vhmsoft.launcherios26.ui.launcher.workspace

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherDockHomeEdgeDragPolicyTest {
    @Test
    fun shouldHandle_returnsTrueWhenDockDragEntersWorkspaceEdgeZone() {
        assertTrue(
            LauncherDockHomeEdgeDragPolicy.shouldHandle(
                editingHome = true,
                alreadyActive = false,
                inDock = false,
                inWorkspace = true,
                inEdgeZone = true
            )
        )
    }

    @Test
    fun shouldHandle_keepsHandlingAfterEdgeDragStarts() {
        assertTrue(
            LauncherDockHomeEdgeDragPolicy.shouldHandle(
                editingHome = true,
                alreadyActive = true,
                inDock = false,
                inWorkspace = true,
                inEdgeZone = false
            )
        )
    }

    @Test
    fun shouldHandle_returnsFalseInsideDock() {
        assertFalse(
            LauncherDockHomeEdgeDragPolicy.shouldHandle(
                editingHome = true,
                alreadyActive = true,
                inDock = true,
                inWorkspace = true,
                inEdgeZone = true
            )
        )
    }

    @Test
    fun shouldHandle_returnsFalseOutsideWorkspace() {
        assertFalse(
            LauncherDockHomeEdgeDragPolicy.shouldHandle(
                editingHome = true,
                alreadyActive = true,
                inDock = false,
                inWorkspace = false,
                inEdgeZone = true
            )
        )
    }
}

package com.vhmsoft.launcherios26.ui.launcher.workspace

import org.junit.Assert.assertEquals
import org.junit.Test

class LauncherDragPreviewPositionerTest {
    @Test
    fun positionForIconCenter_keepsIconCenterAtPointer() {
        val position = LauncherDragPreviewPositioner.positionForIconCenter(
            rootWidth = 360,
            rootHeight = 760,
            previewWidth = 94,
            previewHeight = 118,
            iconCenterY = 36,
            centerX = 180f,
            centerY = 220f,
            horizontalPadding = 4,
            verticalPadding = 12
        )

        assertEquals(133, position.left)
        assertEquals(184, position.top)
    }

    @Test
    fun positionForIconCenter_clampsPreviewInsideRoot() {
        val position = LauncherDragPreviewPositioner.positionForIconCenter(
            rootWidth = 120,
            rootHeight = 160,
            previewWidth = 94,
            previewHeight = 118,
            iconCenterY = 36,
            centerX = -20f,
            centerY = 400f,
            horizontalPadding = 4,
            verticalPadding = 12
        )

        assertEquals(4, position.left)
        assertEquals(30, position.top)
    }
}

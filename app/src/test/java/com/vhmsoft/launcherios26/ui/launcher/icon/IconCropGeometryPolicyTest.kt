package com.vhmsoft.launcherios26.ui.launcher.icon

import org.junit.Assert.assertEquals
import org.junit.Test

class IconCropGeometryPolicyTest {

    @Test
    fun initialCropRect_isCenteredSquareInsideImageBounds() {
        val crop = IconCropGeometryPolicy.initialCropRect(
            bounds = CropRect(left = 10f, top = 20f, right = 310f, bottom = 320f),
            fillFraction = 0.8f
        )

        assertEquals(40f, crop.left)
        assertEquals(50f, crop.top)
        assertEquals(240f, crop.size)
    }

    @Test
    fun move_clampsCropInsideBounds() {
        val moved = IconCropGeometryPolicy.move(
            crop = CropRect(left = 80f, top = 40f, right = 320f, bottom = 280f),
            dx = 500f,
            dy = 500f,
            bounds = CropRect(left = 0f, top = 0f, right = 360f, bottom = 360f)
        )

        assertEquals(120f, moved.left)
        assertEquals(120f, moved.top)
        assertEquals(240f, moved.size)
    }

    @Test
    fun resizeFromBottomRight_keepsSquareAndMinimumSize() {
        val resized = IconCropGeometryPolicy.resize(
            crop = CropRect(left = 80f, top = 80f, right = 280f, bottom = 280f),
            handle = CropResizeHandle.BottomRight,
            dx = -180f,
            dy = -180f,
            bounds = CropRect(left = 0f, top = 0f, right = 360f, bottom = 360f),
            minSize = 96f
        )

        assertEquals(80f, resized.left)
        assertEquals(80f, resized.top)
        assertEquals(96f, resized.size)
    }
}

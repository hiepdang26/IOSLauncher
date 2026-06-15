package com.vhmsoft.launcherios26.ui.launcher.workspace

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherScaledBoundsHitTestTest {
    @Test
    fun isOutside_returnsFalseForPointInsideUnscaledBounds() {
        val outside = LauncherScaledBoundsHitTest.isOutside(
            pointX = 180f,
            pointY = 240f,
            left = 100f,
            top = 100f,
            width = 200f,
            height = 300f,
            scaleX = 1f,
            scaleY = 1f,
            slop = 0f
        )

        assertFalse(outside)
    }

    @Test
    fun isOutside_returnsTrueForPointInsideOriginalButOutsideScaledBounds() {
        val outside = LauncherScaledBoundsHitTest.isOutside(
            pointX = 180f,
            pointY = 240f,
            left = 100f,
            top = 100f,
            width = 200f,
            height = 300f,
            scaleX = 0.16f,
            scaleY = 0.16f,
            slop = 0f
        )

        assertTrue(outside)
    }

    @Test
    fun isOutside_keepsSlopAroundScaledBounds() {
        val outside = LauncherScaledBoundsHitTest.isOutside(
            pointX = 180f,
            pointY = 250f,
            left = 100f,
            top = 100f,
            width = 200f,
            height = 300f,
            scaleX = 0.16f,
            scaleY = 0.16f,
            slop = 15f
        )

        assertFalse(outside)
    }
}

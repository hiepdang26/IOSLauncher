package com.vhmsoft.launcherios26.ui.launcher.workspace

import org.junit.Assert.assertEquals
import org.junit.Test

class LauncherFolderDropPreviewTransformTest {
    @Test
    fun hoverProgress_usesDeceleratedMotion() {
        val progress = LauncherFolderDropPreviewTransform.hoverProgress(
            elapsedMs = 90L,
            durationMs = 180L
        )

        assertEquals(0.75f, progress, 0.001f)
    }

    @Test
    fun hoverTransform_movesPreviewPartWayIntoFolder() {
        val transform = LauncherFolderDropPreviewTransform.hoverTransform(
            currentCenterX = 100f,
            currentCenterY = 100f,
            targetCenterX = 200f,
            targetCenterY = 220f,
            elapsedMs = 180L,
            durationMs = 180L
        )

        assertEquals(152f, transform.centerX, 0.001f)
        assertEquals(162.4f, transform.centerY, 0.001f)
        assertEquals(0.72f, transform.scale, 0.001f)
        assertEquals(0.82f, transform.alphaFraction, 0.001f)
    }

    @Test
    fun dropTransform_finishesAtFolderCenter() {
        val transform = LauncherFolderDropPreviewTransform.dropTransform(
            currentCenterX = 100f,
            currentCenterY = 100f,
            targetCenterX = 200f,
            targetCenterY = 220f,
            progress = 1f
        )

        assertEquals(200f, transform.centerX, 0.001f)
        assertEquals(220f, transform.centerY, 0.001f)
        assertEquals(0.18f, transform.scale, 0.001f)
        assertEquals(0f, transform.alphaFraction, 0.001f)
    }
}

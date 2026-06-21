package com.vhmsoft.launcherios26.ui.launcher.workspace

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherIos17DragGeometryPolicyTest {
    @Test
    fun isFolderInterest_usesFortyFivePercentIconDistance() {
        assertTrue(
            LauncherIos17DragGeometryPolicy.isFolderInterest(
                localXInIcon = 0.1f,
                localYInIcon = 0.5f
            )
        )

        assertFalse(
            LauncherIos17DragGeometryPolicy.isFolderInterest(
                localXInIcon = 0.03f,
                localYInIcon = 0.5f
            )
        )
    }

    @Test
    fun intersectsTargetIcon_matchesIos17DragRectIntersection() {
        assertTrue(
            LauncherIos17DragGeometryPolicy.intersectsTargetIcon(
                dragCenterX = 140f,
                dragCenterY = 50f,
                dragIconWidth = 100f,
                dragIconHeight = 100f,
                targetLeft = 0f,
                targetTop = 0f,
                targetRight = 100f,
                targetBottom = 100f
            )
        )

        assertFalse(
            LauncherIos17DragGeometryPolicy.intersectsTargetIcon(
                dragCenterX = 151f,
                dragCenterY = 50f,
                dragIconWidth = 100f,
                dragIconHeight = 100f,
                targetLeft = 0f,
                targetTop = 0f,
                targetRight = 100f,
                targetBottom = 100f
            )
        )
    }
}

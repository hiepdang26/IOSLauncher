package com.vhmsoft.launcherios26.features.launcher

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class HomeWidgetRemoveHitPolicyTest {

    @Test
    fun expandedCornerHitAcceptsTouchesNearVisibleRemoveBadge() {
        assertTrue(
            HomeWidgetRemoveHitPolicy.isInsideExpandedCorner(
                rawX = 92f,
                rawY = 92f,
                hostLeft = 100,
                hostTop = 100,
                touchSizePx = 56
            )
        )
    }

    @Test
    fun expandedCornerHitRejectsTouchesInsideWidgetButAwayFromRemoveBadge() {
        assertFalse(
            HomeWidgetRemoveHitPolicy.isInsideExpandedCorner(
                rawX = 190f,
                rawY = 160f,
                hostLeft = 100,
                hostTop = 100,
                touchSizePx = 56
            )
        )
    }

    @Test
    fun expandedViewHitUsesActualRemoveButtonBounds() {
        assertTrue(
            HomeWidgetRemoveHitPolicy.isInsideExpandedViewBounds(
                rawX = 130f,
                rawY = 130f,
                viewLeft = 112,
                viewTop = 112,
                viewWidth = 34,
                viewHeight = 34,
                minTouchSizePx = 56
            )
        )
    }

    @Test
    fun expandedViewHitRejectsPointsAwayFromActualRemoveButton() {
        assertFalse(
            HomeWidgetRemoveHitPolicy.isInsideExpandedViewBounds(
                rawX = 180f,
                rawY = 180f,
                viewLeft = 112,
                viewTop = 112,
                viewWidth = 34,
                viewHeight = 34,
                minTouchSizePx = 56
            )
        )
    }
}

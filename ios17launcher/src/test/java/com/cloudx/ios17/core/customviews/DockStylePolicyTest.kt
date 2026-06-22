package com.cloudx.ios17.core.customviews

import org.junit.Assert.assertEquals
import org.junit.Test

class DockStylePolicyTest {

    @Test
    fun styleFor_usesCurrentDockWhenIphone8StyleEnabled() {
        assertEquals(DockStylePolicy.Style.CURRENT, DockStylePolicy.styleFor(iphone8StyleEnabled = true))
    }

    @Test
    fun styleFor_usesRoundedDockWhenIphone8StyleDisabled() {
        assertEquals(DockStylePolicy.Style.ROUNDED, DockStylePolicy.styleFor(iphone8StyleEnabled = false))
    }

    @Test
    fun layoutMetrics_keepDockHeightOnIconRowWhenBottomNavigationIsHidden() {
        assertEquals(
            DockStylePolicy.LayoutMetrics(heightPx = 88, bottomPaddingPx = 0),
            DockStylePolicy.layoutMetrics(hotseatCellHeightPx = 88, bottomInsetPx = 36)
        )
    }
}

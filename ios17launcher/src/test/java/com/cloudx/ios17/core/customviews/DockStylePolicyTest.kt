package com.cloudx.ios17.core.customviews

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
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
    fun styleFor_usesLiquidGlassDockWhenLiquidGlassIsEnabled() {
        assertEquals(
            DockStylePolicy.Style.LIQUID_GLASS,
            DockStylePolicy.styleFor(
                iphone8StyleEnabled = true,
                liquidGlassEnabled = true
            )
        )
        assertEquals(
            DockStylePolicy.Style.LIQUID_GLASS,
            DockStylePolicy.styleFor(
                iphone8StyleEnabled = false,
                liquidGlassEnabled = true
            )
        )
    }

    @Test
    fun styleFor_keepsCurrentDockWhenIphone8AndDarkModeAreEnabled() {
        assertEquals(
            DockStylePolicy.Style.CURRENT,
            DockStylePolicy.styleFor(
                iphone8StyleEnabled = true,
                darkModeEnabled = true
            )
        )
    }

    @Test
    fun styleFor_usesLiquidGlassDockWhenDarkModeIsEnabledWithoutIphone8Style() {
        assertEquals(
            DockStylePolicy.Style.LIQUID_GLASS,
            DockStylePolicy.styleFor(
                iphone8StyleEnabled = false,
                darkModeEnabled = true
            )
        )
    }

    @Test
    fun layoutMetrics_keepDockHeightOnIconRowWhenBottomNavigationIsHidden() {
        assertEquals(
            DockStylePolicy.LayoutMetrics(heightPx = 88, bottomPaddingPx = 0),
            DockStylePolicy.layoutMetrics(hotseatCellHeightPx = 88, bottomInsetPx = 36)
        )
    }

    @Test
    fun roundedAndLiquidGlassDrawTintAboveBlurSoEdgesStaySoft() {
        assertTrue(DockStylePolicy.drawsStyleAboveBlur(DockStylePolicy.Style.LIQUID_GLASS))
        assertTrue(DockStylePolicy.drawsStyleAboveBlur(DockStylePolicy.Style.ROUNDED))
        assertFalse(DockStylePolicy.drawsStyleAboveBlur(DockStylePolicy.Style.CURRENT))
    }

    @Test
    fun roundedAndLiquidGlassUseMaterialDrawableAboveBlur() {
        assertTrue(DockStylePolicy.usesMaterialDrawableAboveBlur(DockStylePolicy.Style.LIQUID_GLASS))
        assertTrue(DockStylePolicy.usesMaterialDrawableAboveBlur(DockStylePolicy.Style.ROUNDED))
        assertFalse(DockStylePolicy.usesMaterialDrawableAboveBlur(DockStylePolicy.Style.CURRENT))
    }

    @Test
    fun wallpaperBlurDrawsOnlyForLiquidGlassDockWhenDockBlurIsEnabled() {
        assertFalse(
            DockStylePolicy.drawsWallpaperBlur(
                style = DockStylePolicy.Style.ROUNDED,
                dockBlurEnabled = true,
                externalRealtimeLiquidGlassEnabled = false
            )
        )
        assertTrue(
            DockStylePolicy.drawsWallpaperBlur(
                style = DockStylePolicy.Style.LIQUID_GLASS,
                dockBlurEnabled = true,
                externalRealtimeLiquidGlassEnabled = false
            )
        )
        assertFalse(
            DockStylePolicy.drawsWallpaperBlur(
                style = DockStylePolicy.Style.CURRENT,
                dockBlurEnabled = true,
                externalRealtimeLiquidGlassEnabled = false
            )
        )
        assertFalse(
            DockStylePolicy.drawsWallpaperBlur(
                style = DockStylePolicy.Style.ROUNDED,
                dockBlurEnabled = false,
                externalRealtimeLiquidGlassEnabled = false
            )
        )
        assertFalse(
            DockStylePolicy.drawsWallpaperBlur(
                style = DockStylePolicy.Style.LIQUID_GLASS,
                dockBlurEnabled = true,
                externalRealtimeLiquidGlassEnabled = true
            )
        )
    }

    @Test
    fun realtimeLiquidGlassDockRequiresLiquidGlassStyleAndRealtimeAvailabilityOnly() {
        assertTrue(
            DockStylePolicy.usesExternalRealtimeLiquidGlass(
                style = DockStylePolicy.Style.LIQUID_GLASS,
                realtimeLiquidGlassAvailable = true,
                dockBlurEnabled = true
            )
        )
        assertTrue(
            DockStylePolicy.usesExternalRealtimeLiquidGlass(
                style = DockStylePolicy.Style.LIQUID_GLASS,
                realtimeLiquidGlassAvailable = true,
                dockBlurEnabled = false
            )
        )
        assertFalse(
            DockStylePolicy.usesExternalRealtimeLiquidGlass(
                style = DockStylePolicy.Style.ROUNDED,
                realtimeLiquidGlassAvailable = true,
                dockBlurEnabled = true
            )
        )
        assertFalse(
            DockStylePolicy.usesExternalRealtimeLiquidGlass(
                style = DockStylePolicy.Style.LIQUID_GLASS,
                realtimeLiquidGlassAvailable = false,
                dockBlurEnabled = true
            )
        )
    }
}

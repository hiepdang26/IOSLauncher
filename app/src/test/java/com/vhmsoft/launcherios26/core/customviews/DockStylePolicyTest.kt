package com.vhmsoft.launcherios26.core.customviews

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class DockStylePolicyTest {

    @Test
    fun styleFor_usesIphone8DockWhenIphone8StyleEnabled() {
        assertEquals(DockStylePolicy.Style.IPHONE8, DockStylePolicy.styleFor(iphone8StyleEnabled = true))
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
    fun styleFor_keepsIphone8DockWhenIphone8AndDarkModeAreEnabled() {
        assertEquals(
            DockStylePolicy.Style.IPHONE8,
            DockStylePolicy.styleFor(
                iphone8StyleEnabled = true,
                darkModeEnabled = true
            )
        )
    }

    @Test
    fun iphone8StyleIsEffectiveOnlyUntilLiquidGlassOverridesIt() {
        assertTrue(
            DockStylePolicy.isIphone8StyleEffective(
                iphone8StyleEnabled = true,
                liquidGlassEnabled = false
            )
        )
        assertFalse(
            DockStylePolicy.isIphone8StyleEffective(
                iphone8StyleEnabled = true,
                liquidGlassEnabled = true
            )
        )
        assertFalse(
            DockStylePolicy.isIphone8StyleEffective(
                iphone8StyleEnabled = false,
                liquidGlassEnabled = false
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
    fun realtimeGlassHeightUsesMeasuredDockHeightWhenLayoutIsWrapContent() {
        assertEquals(
            92,
            DockStylePolicy.realtimeGlassHeightPx(
                layoutHeightPx = -2,
                measuredHeightPx = 92,
                fallbackHeightPx = 88
            )
        )
    }

    @Test
    fun realtimeGlassHeightFallsBackToHotseatHeightBeforeDockIsMeasured() {
        assertEquals(
            88,
            DockStylePolicy.realtimeGlassHeightPx(
                layoutHeightPx = -2,
                measuredHeightPx = 0,
                fallbackHeightPx = 88
            )
        )
    }

    @Test
    fun roundedLiquidGlassAndIphone8DrawTintAboveBlurSoEdgesStaySoft() {
        assertTrue(DockStylePolicy.drawsStyleAboveBlur(DockStylePolicy.Style.LIQUID_GLASS))
        assertTrue(DockStylePolicy.drawsStyleAboveBlur(DockStylePolicy.Style.ROUNDED))
        assertTrue(DockStylePolicy.drawsStyleAboveBlur(DockStylePolicy.Style.IPHONE8))
        assertFalse(DockStylePolicy.drawsStyleAboveBlur(DockStylePolicy.Style.CURRENT))
    }

    @Test
    fun roundedLiquidGlassAndIphone8UseMaterialDrawableAboveBlur() {
        assertTrue(DockStylePolicy.usesMaterialDrawableAboveBlur(DockStylePolicy.Style.LIQUID_GLASS))
        assertTrue(DockStylePolicy.usesMaterialDrawableAboveBlur(DockStylePolicy.Style.ROUNDED))
        assertTrue(DockStylePolicy.usesMaterialDrawableAboveBlur(DockStylePolicy.Style.IPHONE8))
        assertFalse(DockStylePolicy.usesMaterialDrawableAboveBlur(DockStylePolicy.Style.CURRENT))
    }

    @Test
    fun iphone8DockUsesFullWidthCellWidthSoIconsStayCenteredInTheDockBand() {
        assertEquals(
            107,
            DockStylePolicy.childWidthPx(
                style = DockStylePolicy.Style.IPHONE8,
                cellWidthPx = 96,
                hotseatCellWidthPx = 84,
                fullWidthDockCellWidthPx = 107
            )
        )
    }

    @Test
    fun fullWidthDockCellWidthDividesTheDockAcrossTheVisibleScreen() {
        assertEquals(
            107,
            DockStylePolicy.fullWidthDockCellWidthPx(
                availableWidthPx = 428,
                numColumns = 4
            )
        )
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
                style = DockStylePolicy.Style.IPHONE8,
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
    fun realtimeLiquidGlassDockIgnoresDockBlurWhenLiquidGlassStyleAndRealtimeAreAvailable() {
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

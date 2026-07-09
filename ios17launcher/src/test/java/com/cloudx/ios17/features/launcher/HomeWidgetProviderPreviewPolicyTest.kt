package com.cloudx.ios17.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Test

class HomeWidgetProviderPreviewPolicyTest {
    @Test
    fun sizeTextMapsSmallProviderToOneByOne() {
        assertEquals("1 x 1", HomeWidgetProviderPreviewPolicy.sizeText(80, 80))
    }

    @Test
    fun sizeTextMapsMediumProviderToTwoByTwo() {
        assertEquals("2 x 2", HomeWidgetProviderPreviewPolicy.sizeText(180, 160))
    }

    @Test
    fun widgetSizeUsesFullWidthForWideProvider() {
        assertEquals(
            HomeWidgetPlacementPolicy.WidgetSize.FULL_WIDTH,
            HomeWidgetProviderPreviewPolicy.homeWidgetSize(280, 120)
        )
    }

    @Test
    fun widgetSizeUsesSmallForCompactProvider() {
        assertEquals(
            HomeWidgetPlacementPolicy.WidgetSize.SMALL,
            HomeWidgetProviderPreviewPolicy.homeWidgetSize(160, 160)
        )
    }

    @Test
    fun widgetSizeUsesTallForNarrowTallProvider() {
        assertEquals(
            HomeWidgetPlacementPolicy.WidgetSize.TALL,
            HomeWidgetProviderPreviewPolicy.homeWidgetSize(160, 280)
        )
    }

    @Test
    fun widgetSizeUsesLargeForWideTallProvider() {
        assertEquals(
            HomeWidgetPlacementPolicy.WidgetSize.LARGE,
            HomeWidgetProviderPreviewPolicy.homeWidgetSize(280, 280)
        )
    }

    @Test
    fun pickerHeightKeepsTopClearance() {
        assertEquals(
            760,
            HomeWidgetProviderPreviewPolicy.pickerHeight(
                screenHeightPx = 900,
                topClearancePx = 140,
                preferredHeightPx = 820
            )
        )
    }

    @Test
    fun pickerHeightCapsPreferredHeightWhenClearanceIsSmaller() {
        assertEquals(
            360,
            HomeWidgetProviderPreviewPolicy.pickerHeight(
                screenHeightPx = 500,
                topClearancePx = 140,
                preferredHeightPx = 420
            )
        )
    }

    @Test
    fun pickerHeightKeepsPreferredHeightWhenItFits() {
        assertEquals(
            520,
            HomeWidgetProviderPreviewPolicy.pickerHeight(
                screenHeightPx = 900,
                topClearancePx = 140,
                preferredHeightPx = 520
            )
        )
    }

    @Test
    fun pickerHeightIncludesBottomOverflow() {
        assertEquals(
            808,
            HomeWidgetProviderPreviewPolicy.pickerHeight(
                screenHeightPx = 900,
                topClearancePx = 140,
                preferredHeightPx = 900,
                bottomOverflowPx = 48
            )
        )
    }

    @Test
    fun pickerHeightCanStayAboveSystemNavigationWhenOverflowIsDisabled() {
        assertEquals(
            760,
            HomeWidgetProviderPreviewPolicy.pickerHeight(
                screenHeightPx = 900,
                topClearancePx = 140,
                preferredHeightPx = 900,
                bottomOverflowPx = 0
            )
        )
    }

    @Test
    fun visibleAppCountKeepsAllAppsWhenSearchIsBlank() {
        assertEquals(
            24,
            HomeWidgetProviderPreviewPolicy.visibleAppCount(
                totalApps = 24,
                hasSearchQuery = false
            )
        )
    }

    @Test
    fun pickerTopClearanceUsesAnchorBottomWhenAvailable() {
        assertEquals(
            236,
            HomeWidgetProviderPreviewPolicy.pickerTopClearance(
                anchorBottomOnScreenPx = 220,
                rootTopOnScreenPx = 12,
                fallbackPx = 128,
                marginPx = 28
            )
        )
    }

    @Test
    fun pickerTopClearanceFallsBackWhenAnchorIsMissing() {
        assertEquals(
            128,
            HomeWidgetProviderPreviewPolicy.pickerTopClearance(
                anchorBottomOnScreenPx = null,
                rootTopOnScreenPx = 12,
                fallbackPx = 128,
                marginPx = 28
            )
        )
    }
}

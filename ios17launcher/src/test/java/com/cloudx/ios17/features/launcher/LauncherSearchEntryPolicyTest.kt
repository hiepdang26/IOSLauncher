package com.cloudx.ios17.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherSearchEntryPolicyTest {

    @Test
    fun indicatorTap_opensSearchWhenSearchPillIsVisible() {
        assertEquals(
            LauncherSearchEntryPolicy.IndicatorTapAction.OPEN_SEARCH,
            LauncherSearchEntryPolicy.indicatorTapAction(
                indicatorShowsSearch = true,
                searchVisible = false,
                editing = false
            )
        )
    }

    @Test
    fun indicatorTap_opensSearchWhenDotsAreVisible() {
        assertEquals(
            LauncherSearchEntryPolicy.IndicatorTapAction.OPEN_SEARCH,
            LauncherSearchEntryPolicy.indicatorTapAction(
                indicatorShowsSearch = false,
                searchVisible = false,
                editing = false
            )
        )
    }

    @Test
    fun indicatorTap_ignoresWhenSearchIsAlreadyVisible() {
        assertEquals(
            LauncherSearchEntryPolicy.IndicatorTapAction.IGNORE,
            LauncherSearchEntryPolicy.indicatorTapAction(
                indicatorShowsSearch = true,
                searchVisible = true,
                editing = false
            )
        )
    }

    @Test
    fun indicatorTap_ignoresWhileEditing() {
        assertEquals(
            LauncherSearchEntryPolicy.IndicatorTapAction.IGNORE,
            LauncherSearchEntryPolicy.indicatorTapAction(
                indicatorShowsSearch = true,
                searchVisible = false,
                editing = true
            )
        )
    }

    @Test
    fun searchInput_focusesWhenSearchOpens() {
        assertTrue(LauncherSearchEntryPolicy.shouldFocusInputWhenOpened())
    }

    @Test
    fun searchOpenAnimation_usesMinimumDurationWhenOpenedFromIndicator() {
        assertEquals(
            300L,
            LauncherSearchEntryPolicy.searchOpenAnimationDurationMs(currentBlurAlpha = 0f)
        )
        assertEquals(
            150L,
            LauncherSearchEntryPolicy.searchOpenAnimationDurationMs(currentBlurAlpha = 0.5f)
        )
    }

    @Test
    fun swipeDownSearch_startsOnHomePagesBeforeRightmostPage() {
        assertTrue(
            LauncherSearchEntryPolicy.canStartSwipeDownSearch(
                currentPage = 1,
                rightmostPage = 3
            )
        )
    }

    @Test
    fun swipeDownSearch_ignoresWidgetAndRightmostPages() {
        assertEquals(
            false,
            LauncherSearchEntryPolicy.canStartSwipeDownSearch(
                currentPage = 0,
                rightmostPage = 3
            )
        )
        assertEquals(
            false,
            LauncherSearchEntryPolicy.canStartSwipeDownSearch(
                currentPage = 3,
                rightmostPage = 3
            )
        )
    }

    @Test
    fun pageIndicator_hidesWhenScrollingIntoAppLibraryPage() {
        assertEquals(
            false,
            LauncherSearchEntryPolicy.shouldShowIndicatorDuringPageScroll(
                fromPage = 3,
                toPage = 4,
                firstHomePage = 1,
                lastHomePage = 3,
                appLibraryPage = 4
            )
        )
        assertEquals(
            false,
            LauncherSearchEntryPolicy.shouldShowIndicatorDuringPageScroll(
                fromPage = 4,
                toPage = 3,
                firstHomePage = 1,
                lastHomePage = 3,
                appLibraryPage = 4
            )
        )
    }

    @Test
    fun pageIndicator_showsOnlyBetweenHomePages() {
        assertEquals(
            true,
            LauncherSearchEntryPolicy.shouldShowIndicatorDuringPageScroll(
                fromPage = 1,
                toPage = 2,
                firstHomePage = 1,
                lastHomePage = 3,
                appLibraryPage = 4
            )
        )
    }

    @Test
    fun pageIndicator_staysPinnedWhileDockSlidesAtScreenEdge() {
        assertEquals(
            0f,
            LauncherSearchEntryPolicy.indicatorTranslationYForDockSlide(dockTranslationY = 128f),
            0.001f
        )
    }

    @Test
    fun searchOverlay_hidesHomeIndicatorImmediately() {
        assertTrue(LauncherSearchEntryPolicy.shouldHideIndicatorWhileSearchIsActive())
    }

    @Test
    fun dotsIndicatorFrame_rebuildsOnlyWhenFrameIsNotAlreadyReady() {
        assertEquals(
            false,
            LauncherSearchEntryPolicy.shouldRebuildDotsIndicatorFrame(
                indicatorModeIsDots = true,
                wheelAttached = true,
                indicatorVisible = true
            )
        )
        assertEquals(
            true,
            LauncherSearchEntryPolicy.shouldRebuildDotsIndicatorFrame(
                indicatorModeIsDots = false,
                wheelAttached = true,
                indicatorVisible = true
            )
        )
        assertEquals(
            true,
            LauncherSearchEntryPolicy.shouldRebuildDotsIndicatorFrame(
                indicatorModeIsDots = true,
                wheelAttached = false,
                indicatorVisible = true
            )
        )
        assertEquals(
            true,
            LauncherSearchEntryPolicy.shouldRebuildDotsIndicatorFrame(
                indicatorModeIsDots = true,
                wheelAttached = true,
                indicatorVisible = false
            )
        )
    }
}

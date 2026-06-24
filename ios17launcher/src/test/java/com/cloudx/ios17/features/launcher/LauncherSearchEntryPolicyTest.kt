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
}

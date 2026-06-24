package com.cloudx.ios17.features.launcher

object LauncherSearchEntryPolicy {
    enum class IndicatorTapAction {
        OPEN_SEARCH,
        IGNORE
    }

    fun indicatorTapAction(
        indicatorShowsSearch: Boolean,
        searchVisible: Boolean,
        editing: Boolean
    ): IndicatorTapAction {
        return if (indicatorShowsSearch && !searchVisible && !editing) {
            IndicatorTapAction.OPEN_SEARCH
        } else {
            IndicatorTapAction.IGNORE
        }
    }

    fun canStartSwipeDownSearch(currentPage: Int, rightmostPage: Int): Boolean {
        return currentPage > 0 && currentPage < rightmostPage
    }

    fun shouldFocusInputWhenOpened(): Boolean = true
}

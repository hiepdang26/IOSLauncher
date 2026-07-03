package com.cloudx.ios17.features.launcher

object LauncherSearchEntryPolicy {
    private const val SEARCH_OPEN_ANIMATION_MS = 300L

    enum class IndicatorTapAction {
        OPEN_SEARCH,
        IGNORE
    }

    fun indicatorTapAction(
        indicatorShowsSearch: Boolean,
        searchVisible: Boolean,
        editing: Boolean
    ): IndicatorTapAction {
        return if (!searchVisible && !editing) {
            IndicatorTapAction.OPEN_SEARCH
        } else {
            IndicatorTapAction.IGNORE
        }
    }

    fun canStartSwipeDownSearch(currentPage: Int, rightmostPage: Int): Boolean {
        return currentPage > 0 && currentPage < rightmostPage
    }

    fun shouldFocusInputWhenOpened(): Boolean = true

    fun shouldShowIndicatorDuringPageScroll(
        fromPage: Int,
        toPage: Int,
        firstHomePage: Int,
        lastHomePage: Int,
        appLibraryPage: Int
    ): Boolean {
        if (fromPage == appLibraryPage || toPage == appLibraryPage) {
            return false
        }
        return fromPage in firstHomePage..lastHomePage &&
            toPage in firstHomePage..lastHomePage
    }

    fun indicatorTranslationYForDockSlide(dockTranslationY: Float): Float = 0f

    fun shouldHideIndicatorWhileSearchIsActive(): Boolean = true

    fun searchOpenAnimationDurationMs(currentBlurAlpha: Float): Long {
        val remainingAlphaDuration = (currentBlurAlpha.coerceIn(0f, 1f) * SEARCH_OPEN_ANIMATION_MS).toLong()
        return if (remainingAlphaDuration > 0L) {
            remainingAlphaDuration
        } else {
            SEARCH_OPEN_ANIMATION_MS
        }
    }
}

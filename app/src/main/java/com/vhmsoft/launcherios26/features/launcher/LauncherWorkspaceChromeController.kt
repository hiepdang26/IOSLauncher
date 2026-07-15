package com.vhmsoft.launcherios26.features.launcher

class LauncherWorkspaceChromeController(
    private val actions: Actions
) {
    fun updateForPage(state: WorkspaceChromeState) {
        if (state.folderActive) {
            actions.hideHomeIndicatorForFolder()
            return
        }

        if (state.appLibraryPage) {
            actions.removeIndicatorHideCallbacks()
            actions.resetHomeIndicatorPosition()
            actions.setDockChromeVisible(false)
            actions.setIndicatorChromeVisible(false)
        } else {
            actions.setDockChromeVisible(state.showDockForPage)
        }

        if (!state.homePage) {
            actions.removeIndicatorHideCallbacks()
            actions.resetHomeIndicatorPosition()
            actions.setIndicatorChromeVisible(false)
        } else if (state.editing || state.keepDotsVisible) {
            actions.showDotsInIndicator(state.homePagePosition, false)
            actions.setIndicatorChromeVisible(true)
        } else if (state.indicatorMode == IndicatorMode.SEARCH) {
            actions.showSearchControlInIndicator(false)
        }
    }

    data class WorkspaceChromeState(
        val folderActive: Boolean,
        val appLibraryPage: Boolean,
        val homePage: Boolean,
        val showDockForPage: Boolean,
        val editing: Boolean,
        val keepDotsVisible: Boolean,
        val indicatorMode: IndicatorMode,
        val homePagePosition: Int
    )

    enum class IndicatorMode {
        DOTS,
        SEARCH
    }

    interface Actions {
        fun hideHomeIndicatorForFolder()
        fun removeIndicatorHideCallbacks()
        fun resetHomeIndicatorPosition()
        fun setDockChromeVisible(visible: Boolean)
        fun setIndicatorChromeVisible(visible: Boolean)
        fun showDotsInIndicator(position: Int, animate: Boolean)
        fun showSearchControlInIndicator(animated: Boolean)
    }
}

package com.vhmsoft.launcherios26.features.launcher

class LauncherHomeNavigationController(
    private val actions: Actions
) {
    fun returnToHome(state: ReturnHomeState) {
        when {
            state.hiddenAppsPanelVisible -> {
                actions.hideHiddenAppsPanel()
                return
            }
            state.layoutSettingsPanelVisible -> {
                actions.hideLayoutSettingsPanel()
                return
            }
            state.blurSettingsPanelVisible -> {
                actions.hideBlurEffectSettingsPanel()
                return
            }
            state.renameAppPanelVisible -> {
                actions.hideRenameAppPicker()
                return
            }
            state.widgetPreviewVisible -> {
                actions.dismissTodayWidgetPreview()
                return
            }
            state.widgetPickerShowing -> {
                actions.dismissTodayWidgetPicker()
                return
            }
            state.appLibrarySearchOverlayVisible -> {
                actions.hideAppLibrarySearchOverlay()
                return
            }
            state.appLibraryDetailOverlayVisible -> {
                actions.hideAppLibraryDetailOverlay()
                return
            }
            state.homeWidgetOptionsVisible -> {
                actions.dismissHomeWidgetOptionsPopup()
                return
            }
            state.launcherOptionsVisible -> {
                actions.dismissLauncherOptionsPopup()
                return
            }
        }

        if (state.activeWidgetResizing) {
            actions.hideWidgetResizeContainer()
        }

        actions.clearSearchQuery()

        if (state.swipeSearchVisible) {
            actions.hideSwipeSearchContainer()
        }

        when (state.returnHomeAction) {
            ReturnHomeAction.CLOSE_FOLDER -> actions.hideFolderWindowContainer()
            ReturnHomeAction.EXIT_EDIT_MODE -> actions.exitEditMode()
            ReturnHomeAction.EXIT_TODAY_WIDGET_EDIT -> actions.exitTodayWidgetEdit()
            ReturnHomeAction.NONE -> Unit
        }
    }

    data class ReturnHomeState(
        val hiddenAppsPanelVisible: Boolean = false,
        val layoutSettingsPanelVisible: Boolean = false,
        val blurSettingsPanelVisible: Boolean = false,
        val renameAppPanelVisible: Boolean = false,
        val widgetPreviewVisible: Boolean = false,
        val widgetPickerShowing: Boolean = false,
        val appLibrarySearchOverlayVisible: Boolean = false,
        val appLibraryDetailOverlayVisible: Boolean = false,
        val homeWidgetOptionsVisible: Boolean = false,
        val launcherOptionsVisible: Boolean = false,
        val activeWidgetResizing: Boolean = false,
        val swipeSearchVisible: Boolean = false,
        val returnHomeAction: ReturnHomeAction = ReturnHomeAction.NONE
    )

    enum class ReturnHomeAction {
        NONE,
        CLOSE_FOLDER,
        EXIT_EDIT_MODE,
        EXIT_TODAY_WIDGET_EDIT
    }

    interface Actions {
        fun hideHiddenAppsPanel()
        fun hideLayoutSettingsPanel()
        fun hideBlurEffectSettingsPanel()
        fun hideRenameAppPicker()
        fun dismissTodayWidgetPreview()
        fun dismissTodayWidgetPicker()
        fun hideAppLibrarySearchOverlay()
        fun hideAppLibraryDetailOverlay()
        fun dismissHomeWidgetOptionsPopup()
        fun dismissLauncherOptionsPopup()
        fun hideWidgetResizeContainer()
        fun clearSearchQuery()
        fun hideSwipeSearchContainer()
        fun hideFolderWindowContainer()
        fun exitEditMode()
        fun exitTodayWidgetEdit()
    }
}

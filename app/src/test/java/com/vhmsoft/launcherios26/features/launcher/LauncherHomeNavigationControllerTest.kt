package com.vhmsoft.launcherios26.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Test

class LauncherHomeNavigationControllerTest {
    @Test
    fun `return home closes the first blocking panel and stops`() {
        val actions = RecordingHomeNavigationActions()
        val controller = LauncherHomeNavigationController(actions)

        controller.returnToHome(
            LauncherHomeNavigationController.ReturnHomeState(
                hiddenAppsPanelVisible = true,
                layoutSettingsPanelVisible = true
            )
        )

        assertEquals(listOf("hideHiddenAppsPanel"), actions.events)
    }

    @Test
    fun `return home clears search before hiding swipe search and closing folder`() {
        val actions = RecordingHomeNavigationActions()
        val controller = LauncherHomeNavigationController(actions)

        controller.returnToHome(
            LauncherHomeNavigationController.ReturnHomeState(
                swipeSearchVisible = true,
                returnHomeAction = LauncherHomeNavigationController.ReturnHomeAction.CLOSE_FOLDER
            )
        )

        assertEquals(
            listOf(
                "clearSearchQuery",
                "hideSwipeSearchContainer",
                "hideFolderWindowContainer"
            ),
            actions.events
        )
    }

    @Test
    fun `return home keeps resize cleanup before search cleanup`() {
        val actions = RecordingHomeNavigationActions()
        val controller = LauncherHomeNavigationController(actions)

        controller.returnToHome(
            LauncherHomeNavigationController.ReturnHomeState(
                activeWidgetResizing = true,
                swipeSearchVisible = true,
                returnHomeAction = LauncherHomeNavigationController.ReturnHomeAction.EXIT_EDIT_MODE
            )
        )

        assertEquals(
            listOf(
                "hideWidgetResizeContainer",
                "clearSearchQuery",
                "hideSwipeSearchContainer",
                "exitEditMode"
            ),
            actions.events
        )
    }

    @Test
    fun `return home exits today widget edit after search cleanup`() {
        val actions = RecordingHomeNavigationActions()
        val controller = LauncherHomeNavigationController(actions)

        controller.returnToHome(
            LauncherHomeNavigationController.ReturnHomeState(
                returnHomeAction = LauncherHomeNavigationController.ReturnHomeAction.EXIT_TODAY_WIDGET_EDIT
            )
        )

        assertEquals(
            listOf(
                "clearSearchQuery",
                "exitTodayWidgetEdit"
            ),
            actions.events
        )
    }

    private class RecordingHomeNavigationActions : LauncherHomeNavigationController.Actions {
        val events = mutableListOf<String>()

        override fun hideHiddenAppsPanel() {
            events += "hideHiddenAppsPanel"
        }

        override fun hideLayoutSettingsPanel() {
            events += "hideLayoutSettingsPanel"
        }

        override fun hideBlurEffectSettingsPanel() {
            events += "hideBlurEffectSettingsPanel"
        }

        override fun hideRenameAppPicker() {
            events += "hideRenameAppPicker"
        }

        override fun dismissTodayWidgetPreview() {
            events += "dismissTodayWidgetPreview"
        }

        override fun dismissTodayWidgetPicker() {
            events += "dismissTodayWidgetPicker"
        }

        override fun hideAppLibrarySearchOverlay() {
            events += "hideAppLibrarySearchOverlay"
        }

        override fun hideAppLibraryDetailOverlay() {
            events += "hideAppLibraryDetailOverlay"
        }

        override fun dismissHomeWidgetOptionsPopup() {
            events += "dismissHomeWidgetOptionsPopup"
        }

        override fun dismissLauncherOptionsPopup() {
            events += "dismissLauncherOptionsPopup"
        }

        override fun hideWidgetResizeContainer() {
            events += "hideWidgetResizeContainer"
        }

        override fun clearSearchQuery() {
            events += "clearSearchQuery"
        }

        override fun hideSwipeSearchContainer() {
            events += "hideSwipeSearchContainer"
        }

        override fun hideFolderWindowContainer() {
            events += "hideFolderWindowContainer"
        }

        override fun exitEditMode() {
            events += "exitEditMode"
        }

        override fun exitTodayWidgetEdit() {
            events += "exitTodayWidgetEdit"
        }
    }
}

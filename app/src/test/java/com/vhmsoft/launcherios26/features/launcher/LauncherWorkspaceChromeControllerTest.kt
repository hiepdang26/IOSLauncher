package com.vhmsoft.launcherios26.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Test

class LauncherWorkspaceChromeControllerTest {
    @Test
    fun `folder page hides folder indicator and stops`() {
        val actions = RecordingWorkspaceChromeActions()
        val controller = LauncherWorkspaceChromeController(actions)

        controller.updateForPage(
            LauncherWorkspaceChromeController.WorkspaceChromeState(
                folderActive = true,
                appLibraryPage = true,
                homePage = true,
                showDockForPage = true,
                editing = true,
                keepDotsVisible = true,
                indicatorMode = LauncherWorkspaceChromeController.IndicatorMode.SEARCH,
                homePagePosition = 2
            )
        )

        assertEquals(listOf("hideHomeIndicatorForFolder"), actions.events)
    }

    @Test
    fun `app library page keeps legacy dock and indicator hide order`() {
        val actions = RecordingWorkspaceChromeActions()
        val controller = LauncherWorkspaceChromeController(actions)

        controller.updateForPage(
            LauncherWorkspaceChromeController.WorkspaceChromeState(
                folderActive = false,
                appLibraryPage = true,
                homePage = false,
                showDockForPage = false,
                editing = false,
                keepDotsVisible = false,
                indicatorMode = LauncherWorkspaceChromeController.IndicatorMode.SEARCH,
                homePagePosition = 0
            )
        )

        assertEquals(
            listOf(
                "removeIndicatorHideCallbacks",
                "resetHomeIndicatorPosition",
                "setDockChromeVisible:false",
                "setIndicatorChromeVisible:false",
                "removeIndicatorHideCallbacks",
                "resetHomeIndicatorPosition",
                "setIndicatorChromeVisible:false"
            ),
            actions.events
        )
    }

    @Test
    fun `non home non app library page hides dock and indicator`() {
        val actions = RecordingWorkspaceChromeActions()
        val controller = LauncherWorkspaceChromeController(actions)

        controller.updateForPage(
            LauncherWorkspaceChromeController.WorkspaceChromeState(
                folderActive = false,
                appLibraryPage = false,
                homePage = false,
                showDockForPage = false,
                editing = false,
                keepDotsVisible = false,
                indicatorMode = LauncherWorkspaceChromeController.IndicatorMode.SEARCH,
                homePagePosition = 0
            )
        )

        assertEquals(
            listOf(
                "setDockChromeVisible:false",
                "removeIndicatorHideCallbacks",
                "resetHomeIndicatorPosition",
                "setIndicatorChromeVisible:false"
            ),
            actions.events
        )
    }

    @Test
    fun `home page in edit mode shows dock dots and indicator`() {
        val actions = RecordingWorkspaceChromeActions()
        val controller = LauncherWorkspaceChromeController(actions)

        controller.updateForPage(
            LauncherWorkspaceChromeController.WorkspaceChromeState(
                folderActive = false,
                appLibraryPage = false,
                homePage = true,
                showDockForPage = true,
                editing = true,
                keepDotsVisible = false,
                indicatorMode = LauncherWorkspaceChromeController.IndicatorMode.SEARCH,
                homePagePosition = 1
            )
        )

        assertEquals(
            listOf(
                "setDockChromeVisible:true",
                "showDotsInIndicator:1:false",
                "setIndicatorChromeVisible:true"
            ),
            actions.events
        )
    }

    @Test
    fun `home page in search mode shows search control`() {
        val actions = RecordingWorkspaceChromeActions()
        val controller = LauncherWorkspaceChromeController(actions)

        controller.updateForPage(
            LauncherWorkspaceChromeController.WorkspaceChromeState(
                folderActive = false,
                appLibraryPage = false,
                homePage = true,
                showDockForPage = true,
                editing = false,
                keepDotsVisible = false,
                indicatorMode = LauncherWorkspaceChromeController.IndicatorMode.SEARCH,
                homePagePosition = 0
            )
        )

        assertEquals(
            listOf(
                "setDockChromeVisible:true",
                "showSearchControlInIndicator:false"
            ),
            actions.events
        )
    }

    private class RecordingWorkspaceChromeActions : LauncherWorkspaceChromeController.Actions {
        val events = mutableListOf<String>()

        override fun hideHomeIndicatorForFolder() {
            events += "hideHomeIndicatorForFolder"
        }

        override fun removeIndicatorHideCallbacks() {
            events += "removeIndicatorHideCallbacks"
        }

        override fun resetHomeIndicatorPosition() {
            events += "resetHomeIndicatorPosition"
        }

        override fun setDockChromeVisible(visible: Boolean) {
            events += "setDockChromeVisible:$visible"
        }

        override fun setIndicatorChromeVisible(visible: Boolean) {
            events += "setIndicatorChromeVisible:$visible"
        }

        override fun showDotsInIndicator(position: Int, animate: Boolean) {
            events += "showDotsInIndicator:$position:$animate"
        }

        override fun showSearchControlInIndicator(animated: Boolean) {
            events += "showSearchControlInIndicator:$animated"
        }
    }
}

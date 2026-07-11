package com.vhmsoft.launcherios26.features.launcher

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherBlurSettingsRefreshPolicyTest {
    @Test
    fun dockBlurOnlyRefreshesDockChrome() {
        val actions = LauncherBlurSettingsRefreshPolicy.actionsFor(
            LauncherBlurSettingsRefreshPolicy.Target.DOCK
        )

        assertTrue(actions.refreshDock)
        assertFalse(actions.refreshFolderChrome)
        assertFalse(actions.refreshFolderPreviews)
        assertFalse(actions.refreshWidgets)
        assertFalse(actions.refreshSearchChrome)
    }

    @Test
    fun otherBlurOptionsRefreshTheirOwnSurfacesWithoutDependingOnDock() {
        val folder = LauncherBlurSettingsRefreshPolicy.actionsFor(
            LauncherBlurSettingsRefreshPolicy.Target.FOLDER
        )
        val widget = LauncherBlurSettingsRefreshPolicy.actionsFor(
            LauncherBlurSettingsRefreshPolicy.Target.WIDGET
        )
        val search = LauncherBlurSettingsRefreshPolicy.actionsFor(
            LauncherBlurSettingsRefreshPolicy.Target.SEARCH
        )

        assertFalse(folder.refreshDock)
        assertTrue(folder.refreshFolderChrome)
        assertTrue(folder.refreshFolderPreviews)

        assertFalse(widget.refreshDock)
        assertTrue(widget.refreshWidgets)

        assertFalse(search.refreshDock)
        assertTrue(search.refreshSearchChrome)
    }
}

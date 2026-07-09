package com.cloudx.ios17.features.launcher

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherWorkspaceChromePolicyTest {

    @Test
    fun dockShowsOnlyOnHomePages() {
        assertFalse(
            LauncherWorkspaceChromePolicy.shouldShowDockForPage(
                page = 0,
                firstHomePage = 1,
                lastHomePage = 3
            )
        )
        assertTrue(
            LauncherWorkspaceChromePolicy.shouldShowDockForPage(
                page = 1,
                firstHomePage = 1,
                lastHomePage = 3
            )
        )
        assertTrue(
            LauncherWorkspaceChromePolicy.shouldShowDockForPage(
                page = 3,
                firstHomePage = 1,
                lastHomePage = 3
            )
        )
        assertFalse(
            LauncherWorkspaceChromePolicy.shouldShowDockForPage(
                page = 4,
                firstHomePage = 1,
                lastHomePage = 3
            )
        )
    }
}

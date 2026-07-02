package com.vhmsoft.launcherios26.ui.launcher.controller

import android.view.View
import org.junit.Assert.assertEquals
import org.junit.Test

class LauncherLibrarySearchVisibilityPolicyTest {
    @Test
    fun homeContent_hidesWhileLibrarySearchIsOpen() {
        assertEquals(
            View.GONE,
            LauncherLibrarySearchVisibilityPolicy.homeContentVisibility(
                librarySearchVisible = true
            )
        )
    }

    @Test
    fun homeContent_returnsWhenLibrarySearchCloses() {
        assertEquals(
            View.VISIBLE,
            LauncherLibrarySearchVisibilityPolicy.homeContentVisibility(
                librarySearchVisible = false
            )
        )
    }
}

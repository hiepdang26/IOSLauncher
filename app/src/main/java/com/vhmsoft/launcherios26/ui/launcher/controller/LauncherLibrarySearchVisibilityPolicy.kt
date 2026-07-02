package com.vhmsoft.launcherios26.ui.launcher.controller

import android.view.View

object LauncherLibrarySearchVisibilityPolicy {
    fun homeContentVisibility(librarySearchVisible: Boolean): Int {
        return if (librarySearchVisible) View.GONE else View.VISIBLE
    }
}

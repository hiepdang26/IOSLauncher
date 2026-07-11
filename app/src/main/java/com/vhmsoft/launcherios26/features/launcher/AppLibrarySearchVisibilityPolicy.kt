package com.vhmsoft.launcherios26.features.launcher

import android.view.View

object AppLibrarySearchVisibilityPolicy {
    fun pageVisibility(searchVisible: Boolean): Int {
        return if (searchVisible) View.INVISIBLE else View.VISIBLE
    }

    fun detailPageVisibility(detailVisible: Boolean): Int {
        return if (detailVisible) View.INVISIBLE else View.VISIBLE
    }

    fun overlayBackgroundColor(): Int = TRANSPARENT_BACKGROUND

    private const val TRANSPARENT_BACKGROUND = 0x00000000
}

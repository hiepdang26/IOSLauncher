package com.cloudx.ios17.features.launcher

import android.view.View
import org.junit.Assert.assertEquals
import org.junit.Test

class AppLibrarySearchVisibilityPolicyTest {
    @Test
    fun appLibraryPage_isInvisibleWhileSearchIsOpen() {
        assertEquals(
            View.INVISIBLE,
            AppLibrarySearchVisibilityPolicy.pageVisibility(searchVisible = true)
        )
    }

    @Test
    fun appLibraryPage_isVisibleWhenSearchIsClosed() {
        assertEquals(
            View.VISIBLE,
            AppLibrarySearchVisibilityPolicy.pageVisibility(searchVisible = false)
        )
    }

    @Test
    fun appLibraryPage_isInvisibleWhileDetailIsOpen() {
        assertEquals(
            View.INVISIBLE,
            AppLibrarySearchVisibilityPolicy.detailPageVisibility(detailVisible = true)
        )
    }

    @Test
    fun appLibraryPage_isVisibleWhenDetailIsClosed() {
        assertEquals(
            View.VISIBLE,
            AppLibrarySearchVisibilityPolicy.detailPageVisibility(detailVisible = false)
        )
    }

    @Test
    fun searchOverlayBackground_isTransparentSoLibraryWallpaperShowsThrough() {
        assertEquals(
            0,
            AppLibrarySearchVisibilityPolicy.overlayBackgroundColor().alphaComponent()
        )
    }

    private fun Int.alphaComponent(): Int = ushr(24) and 0xFF
}

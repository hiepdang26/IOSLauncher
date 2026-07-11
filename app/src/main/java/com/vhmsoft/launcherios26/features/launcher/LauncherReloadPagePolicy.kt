package com.vhmsoft.launcherios26.features.launcher

object LauncherReloadPagePolicy {
    fun restoredPage(
        requestedPage: Int,
        homePageCount: Int,
        hasAppLibraryPage: Boolean
    ): Int {
        val safeHomePageCount = homePageCount.coerceAtLeast(1)
        val maxPage = safeHomePageCount + if (hasAppLibraryPage) 1 else 0
        return requestedPage.coerceIn(0, maxPage)
    }
}

package com.cloudx.ios17.features.launcher

object LauncherWorkspaceChromePolicy {

    fun shouldShowDockForPage(
        page: Int,
        firstHomePage: Int,
        lastHomePage: Int
    ): Boolean = page in firstHomePage..lastHomePage
}

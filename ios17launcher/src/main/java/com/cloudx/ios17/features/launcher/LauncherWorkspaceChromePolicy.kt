package com.cloudx.ios17.features.launcher

object LauncherWorkspaceChromePolicy {

    fun shouldShowDockForPage(
        page: Int,
        firstHomePage: Int,
        lastHomePage: Int,
        folderVisible: Boolean = false
    ): Boolean = !folderVisible && page in firstHomePage..lastHomePage
}

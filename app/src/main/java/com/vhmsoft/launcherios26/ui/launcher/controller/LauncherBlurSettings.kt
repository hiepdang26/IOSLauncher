package com.vhmsoft.launcherios26.ui.launcher.controller

data class LauncherBlurSettings(
    val dockEnabled: Boolean = true,
    val folderEnabled: Boolean = true,
    val widgetEnabled: Boolean = true,
    val searchEnabled: Boolean = true
) {
    val dockBlurActive: Boolean = dockEnabled
    val folderBlurActive: Boolean = folderEnabled
    val widgetBlurActive: Boolean = widgetEnabled
    val searchBlurActive: Boolean = searchEnabled
}

package com.vhmsoft.launcherios26.ui.launcher.controller

data class LauncherBlurSettings(
    val enabled: Boolean = true,
    val folderEnabled: Boolean = true,
    val widgetEnabled: Boolean = true,
    val searchEnabled: Boolean = true
) {
    val dockBlurActive: Boolean = enabled
    val folderBlurActive: Boolean = enabled && folderEnabled
    val widgetBlurActive: Boolean = enabled && widgetEnabled
    val searchBlurActive: Boolean = enabled && searchEnabled
}

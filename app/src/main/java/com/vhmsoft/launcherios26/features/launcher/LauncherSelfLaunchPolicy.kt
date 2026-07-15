package com.vhmsoft.launcherios26.features.launcher

object LauncherSelfLaunchPolicy {
    const val MENU_ACTIVITY_CLASS = "com.vhmsoft.launcherios26.ui.launcher.LauncherMenuActivity"

    fun shouldOpenLauncherMenu(
        itemPackageName: String?,
        targetPackageName: String?,
        launcherPackageName: String
    ): Boolean {
        return itemPackageName.equals(launcherPackageName, ignoreCase = true) ||
            targetPackageName.equals(launcherPackageName, ignoreCase = true)
    }
}

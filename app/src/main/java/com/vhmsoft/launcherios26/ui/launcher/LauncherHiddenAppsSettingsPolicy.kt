package com.vhmsoft.launcherios26.ui.launcher

import com.vhmsoft.launcherios26.data.model.LauncherApp

object LauncherHiddenAppsSettingsPolicy {
    const val opensFullscreenPage = true
    const val usesDialogList = false
    const val showsPageBeforeLoadingApps = true

    data class Sections(
        val hidden: List<LauncherApp>,
        val visible: List<LauncherApp>
    )

    fun sections(apps: List<LauncherApp>, hiddenIconKeys: Set<String>): Sections {
        val sortedApps = apps.sortedWith(compareBy(String.CASE_INSENSITIVE_ORDER) { app -> app.label })
        return Sections(
            hidden = sortedApps.filter { app -> app.iconKey in hiddenIconKeys },
            visible = sortedApps.filterNot { app -> app.iconKey in hiddenIconKeys }
        )
    }
}

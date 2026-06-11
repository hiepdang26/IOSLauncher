package com.vhmsoft.launcherios26.ui.launcher

import com.vhmsoft.launcherios26.data.model.LauncherApp
import com.vhmsoft.launcherios26.data.repository.LauncherRepository
import com.vhmsoft.launcherios26.ui.launcher.icon.IosLauncherIconTheme
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherIconUiModel

internal suspend fun LauncherRepository.getLauncherIconItems(): List<LauncherIconUiModel> {
    return getInstalledApps().map { app -> app.toLauncherIconItem(this) }
}

private suspend fun LauncherApp.toLauncherIconItem(
    repository: LauncherRepository
): LauncherIconUiModel {
    val sourceIcon = repository.getAppIcon(this)
    return LauncherIconUiModel(
        app = this,
        icon = IosLauncherIconTheme.createIcon(this, sourceIcon),
        category = repository.getAppCategory(this)
    )
}

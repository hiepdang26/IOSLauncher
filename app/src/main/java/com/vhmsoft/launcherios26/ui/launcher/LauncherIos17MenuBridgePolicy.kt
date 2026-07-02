package com.vhmsoft.launcherios26.ui.launcher

import com.cloudx.ios17.core.LauncherAppRenamePolicy
import com.vhmsoft.launcherios26.data.model.LauncherApp

object LauncherIos17MenuBridgePolicy {
    fun renameKeys(app: LauncherApp): List<String> {
        return LauncherAppRenamePolicy.appKeys(
            appId = app.iconKey,
            componentName = "${app.packageName}/${app.className}",
            packageName = app.packageName
        )
    }

    fun iconKeys(app: LauncherApp): List<String> {
        return renameKeys(app)
    }
}

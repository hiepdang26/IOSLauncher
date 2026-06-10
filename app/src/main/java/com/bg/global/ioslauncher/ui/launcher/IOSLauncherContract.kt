package com.bg.global.ioslauncher.ui.launcher

import com.bg.global.ioslauncher.base.BaseView
import com.bg.global.ioslauncher.data.model.LauncherApp
import com.bg.global.ioslauncher.ui.launcher.workspace.LauncherIconUiModel

interface IOSLauncherContract {
    interface View : BaseView {
        fun showLoading(isLoading: Boolean)
        fun showLauncherApps(apps: List<LauncherIconUiModel>)
        fun showError(message: String)
        fun openDefaultLauncherSelection()
        fun showAlreadyDefaultLauncher()
        fun showAppOptions(item: LauncherIconUiModel)
        fun openApp(app: LauncherApp)
        fun openAppInfo(app: LauncherApp)
    }

    interface Presenter {
        fun loadLauncherData()
        fun refreshApps()
        fun clearIconCache()
        fun onSetDefaultLauncherClicked()
        fun onAppClicked(item: LauncherIconUiModel)
        fun onOpenAppOptionClicked(app: LauncherApp)
        fun onRenameAppOptionClicked(app: LauncherApp)
        fun onChangeIconOptionClicked(app: LauncherApp)
        fun onHideAppOptionClicked(app: LauncherApp)
        fun onAppInfoOptionClicked(app: LauncherApp)
        fun onAppsReordered(apps: List<LauncherIconUiModel>)
    }
}

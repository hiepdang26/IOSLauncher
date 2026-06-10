package com.vhmsoft.launcherios26.ui.launcher

import com.vhmsoft.launcherios26.base.BaseView
import com.vhmsoft.launcherios26.data.model.LauncherApp
import com.vhmsoft.launcherios26.data.model.LauncherFolder
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherHomeItemUiModel
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherIconUiModel

interface IOSLauncherContract {
    interface View : BaseView {
        fun showLoading(isLoading: Boolean)
        fun showLauncherApps(apps: List<LauncherIconUiModel>, folders: List<LauncherFolder>)
        fun showError(message: String)
        fun openDefaultLauncherSelection()
        fun showAlreadyDefaultLauncher()
        fun showAppOptions(item: LauncherIconUiModel)
        fun openApp(app: LauncherApp)
        fun openAppInfo(app: LauncherApp)
        fun openAppLibrarySettings()
    }

    interface Presenter {
        fun loadLauncherData()
        fun refreshApps()
        fun clearIconCache()
        fun onSetDefaultLauncherClicked()
        fun onAppLibraryClicked()
        fun onAppClicked(item: LauncherIconUiModel)
        fun onOpenAppOptionClicked(app: LauncherApp)
        fun onRenameAppOptionClicked(app: LauncherApp)
        fun onChangeIconOptionClicked(app: LauncherApp)
        fun onHideAppOptionClicked(app: LauncherApp)
        fun onAppInfoOptionClicked(app: LauncherApp)
        fun onAppsReordered(apps: List<LauncherIconUiModel>)
        fun onHomeItemsChanged(items: List<LauncherHomeItemUiModel>)
    }
}

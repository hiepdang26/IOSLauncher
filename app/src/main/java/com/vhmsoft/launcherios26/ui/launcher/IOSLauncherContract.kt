package com.vhmsoft.launcherios26.ui.launcher

import com.vhmsoft.launcherios26.base.BaseView
import com.vhmsoft.launcherios26.data.model.LauncherApp
import com.vhmsoft.launcherios26.data.model.LauncherFolder
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherHomeItemUiModel
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherIconUiModel
import com.vhmsoft.launcherios26.ui.settings.feature.LauncherExternalFeatureCode

interface IOSLauncherContract {
    interface View : BaseView {
        fun showLoading(isLoading: Boolean)
        fun showLauncherApps(
            apps: List<LauncherIconUiModel>,
            folders: List<LauncherFolder>,
            dockFolders: List<LauncherFolder>,
            dockOrder: List<String>
        )
        fun showError(message: String)
        fun openDefaultLauncherSelection()
        fun showAlreadyDefaultLauncher()
        fun showAppOptions(item: LauncherIconUiModel)
        fun openApp(app: LauncherApp)
        fun openAppInfo(app: LauncherApp)
        fun openAppLibrarySettings()
        fun shareLauncherApp()
        fun shareLauncherAppByMail()
        fun showRatingPrompt()
        fun showLayoutSettingsPage()
        fun applyLayoutDarkMode(enabled: Boolean)
        fun showExternalFeatureDownloadPrompt(featureCode: LauncherExternalFeatureCode)
        fun showSettingsDrawer()
        fun showRenameAppDialog(app: LauncherApp)
        fun showChangeIconDialog(app: LauncherApp)
        fun showHideAppDialog(app: LauncherApp)
    }

    interface Presenter {
        fun loadLauncherData()
        fun refreshApps()
        fun clearIconCache()
        fun onSettingsMenuClicked()
        fun onLockScreenClicked()
        fun onControlCenterClicked()
        fun onAssistiveTouchClicked()
        fun onSetDefaultLauncherClicked()
        fun onAppLibraryClicked()
        fun onShareClicked()
        fun onMailClicked()
        fun onRateClicked()
        fun onLayoutSettingsClicked()
        fun onLayoutDarkModeChanged(enabled: Boolean)
        fun onAppClicked(item: LauncherIconUiModel)
        fun onOpenAppOptionClicked(app: LauncherApp)
        fun onRenameAppOptionClicked(app: LauncherApp)
        fun onChangeIconOptionClicked(app: LauncherApp)
        fun onHideAppOptionClicked(app: LauncherApp)
        fun onAppInfoOptionClicked(app: LauncherApp)
        fun onAppsReordered(apps: List<LauncherIconUiModel>)
        fun onHomeItemsChanged(items: List<LauncherHomeItemUiModel>)
        fun onDockItemsChanged(items: List<LauncherHomeItemUiModel>)
    }
}

package com.vhmsoft.launcherios26.ui.launcher

import com.vhmsoft.launcherios26.base.CoroutinePresenter
import com.vhmsoft.launcherios26.data.model.LauncherApp
import com.vhmsoft.launcherios26.data.repository.LauncherRepository
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherHomeItemUiModel
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherHomeLayoutBuilder
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherIconUiModel
import com.vhmsoft.launcherios26.ui.settings.feature.LauncherExternalFeatureCode
import kotlinx.coroutines.launch

class IOSLauncherPresenter(
    private val launcherRepository: LauncherRepository
) : CoroutinePresenter<IOSLauncherContract.View>(), IOSLauncherContract.Presenter {
    override fun loadLauncherData() {
        view?.showLoading(true)
        presenterScope.launch {
            runCatching { launcherRepository.getLauncherIconItems() }
                .onSuccess { iconItems ->
                    view?.showLauncherApps(
                        apps = iconItems,
                        folders = launcherRepository.getLauncherFolders(),
                        dockFolders = launcherRepository.getDockFolders(),
                        dockOrder = launcherRepository.getDockOrder()
                    )
                }
                .onFailure { error ->
                    view?.showError(error.message ?: "Cannot load launcher apps")
                }
            view?.showLoading(false)
        }
    }

    override fun refreshApps() {
        loadLauncherData()
    }

    override fun clearIconCache() {
        launcherRepository.clearIconCache()
    }

    override fun onSettingsMenuClicked() {
        view?.showSettingsDrawer()
    }

    override fun onLockScreenClicked() {
        view?.showExternalFeatureDownloadPrompt(LauncherExternalFeatureCode.LOCK_SCREEN)
    }

    override fun onControlCenterClicked() {
        view?.showExternalFeatureDownloadPrompt(LauncherExternalFeatureCode.CONTROL_CENTER)
    }

    override fun onAssistiveTouchClicked() {
        view?.showExternalFeatureDownloadPrompt(LauncherExternalFeatureCode.ASSISTIVE_TOUCH)
    }

    override fun onSetDefaultLauncherClicked() {
        view?.openDefaultLauncherSelection()
    }

    override fun onAppLibraryClicked() {
        view?.openAppLibrarySettings()
    }

    override fun onShareClicked() {
        view?.shareLauncherApp()
    }

    override fun onMailClicked() {
        view?.shareLauncherAppByMail()
    }

    override fun onRateClicked() {
        view?.showRatingPrompt()
    }

    override fun onLayoutSettingsClicked() {
        view?.showLayoutSettingsPage()
    }

    override fun onLayoutDarkModeChanged(enabled: Boolean) {
        view?.applyLayoutDarkMode(enabled)
    }

    override fun onAppClicked(item: LauncherIconUiModel) {
        view?.showAppOptions(item)
    }

    override fun onOpenAppOptionClicked(app: LauncherApp) {
        view?.openApp(app)
    }

    override fun onRenameAppOptionClicked(app: LauncherApp) {
        view?.showError("Đổi tên: ${app.label}")
    }

    override fun onChangeIconOptionClicked(app: LauncherApp) {
        view?.showError("Thay biểu tượng: ${app.label}")
    }

    override fun onHideAppOptionClicked(app: LauncherApp) {
        view?.showError("Ẩn ứng dụng: ${app.label}")
    }

    override fun onAppInfoOptionClicked(app: LauncherApp) {
        view?.openAppInfo(app)
    }

    override fun onAppsReordered(apps: List<LauncherIconUiModel>) {
        launcherRepository.saveAppOrder(apps.map { it.app })
    }

    override fun onHomeItemsChanged(items: List<LauncherHomeItemUiModel>) {
        launcherRepository.saveLauncherFolders(LauncherHomeLayoutBuilder.extractFolders(items))
        launcherRepository.saveAppOrder(
            LauncherHomeLayoutBuilder.flattenApps(items).map { iconItem -> iconItem.app }
        )
    }

    override fun onDockItemsChanged(items: List<LauncherHomeItemUiModel>) {
        launcherRepository.saveDockFolders(LauncherHomeLayoutBuilder.extractFolders(items))
        launcherRepository.saveDockOrder(
            LauncherHomeLayoutBuilder.flattenApps(items).map { iconItem -> iconItem.app.iconKey }
        )
    }
}

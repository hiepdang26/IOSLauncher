package com.bg.global.ioslauncher.ui.launcher

import com.bg.global.ioslauncher.base.CoroutinePresenter
import com.bg.global.ioslauncher.data.model.LauncherApp
import com.bg.global.ioslauncher.data.repository.LauncherRepository
import com.bg.global.ioslauncher.ui.launcher.workspace.LauncherIconUiModel
import kotlinx.coroutines.launch

class IOSLauncherPresenter(
    private val launcherRepository: LauncherRepository
) : CoroutinePresenter<IOSLauncherContract.View>(), IOSLauncherContract.Presenter {
    override fun loadLauncherData() {
        view?.showLoading(true)
        presenterScope.launch {
            runCatching { launcherRepository.getInstalledApps() }
                .mapCatching { apps ->
                    apps.map { app ->
                        LauncherIconUiModel(
                            app = app,
                            icon = launcherRepository.getAppIcon(app),
                            category = launcherRepository.getAppCategory(app)
                        )
                    }
                }
                .onSuccess { iconItems ->
                    view?.showLauncherApps(iconItems)
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

    override fun onSetDefaultLauncherClicked() {
        view?.openDefaultLauncherSelection()
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
}

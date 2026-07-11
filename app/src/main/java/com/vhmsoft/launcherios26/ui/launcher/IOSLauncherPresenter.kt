package com.vhmsoft.launcherios26.ui.launcher

import com.vhmsoft.launcherios26.base.CoroutinePresenter
import com.vhmsoft.launcherios26.data.model.LauncherApp
import com.vhmsoft.launcherios26.data.repository.LauncherRepository
import com.vhmsoft.launcherios26.ui.settings.feature.LauncherExternalFeatureCode

class IOSLauncherPresenter(
    private val launcherRepository: LauncherRepository
) : CoroutinePresenter<IOSLauncherContract.View>(), IOSLauncherContract.Presenter {
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

    override fun onOpenAppOptionClicked(app: LauncherApp) {
        view?.openApp(app)
    }

    override fun onRenameAppOptionClicked(app: LauncherApp) {
        view?.showRenameAppDialog(app)
    }

    override fun onChangeIconOptionClicked(app: LauncherApp) {
        view?.showChangeIconDialog(app)
    }

    override fun onHideAppOptionClicked(app: LauncherApp) {
        view?.showHideAppDialog(app)
    }

    override fun onAppInfoOptionClicked(app: LauncherApp) {
        view?.openAppInfo(app)
    }
}

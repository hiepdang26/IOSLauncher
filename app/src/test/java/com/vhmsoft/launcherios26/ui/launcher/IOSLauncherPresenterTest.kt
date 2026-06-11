package com.vhmsoft.launcherios26.ui.launcher

import android.graphics.drawable.Drawable
import com.vhmsoft.launcherios26.data.model.LauncherApp
import com.vhmsoft.launcherios26.data.model.LauncherAppCategory
import com.vhmsoft.launcherios26.data.model.LauncherFolder
import com.vhmsoft.launcherios26.data.repository.LauncherRepository
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherIconUiModel
import org.junit.Assert.assertTrue
import org.junit.Test

class IOSLauncherPresenterTest {
    @Test
    fun onAppLibraryClicked_requestsAppLibraryScreen() {
        val view = FakeView()
        val presenter = IOSLauncherPresenter(FakeRepository)

        presenter.attachView(view)
        presenter.onAppLibraryClicked()

        assertTrue(view.openedAppLibrary)
    }

    @Test
    fun settingsFeatureClicks_requestMatchingPrompts() {
        val view = FakeView()
        val presenter = IOSLauncherPresenter(FakeRepository)

        presenter.attachView(view)
        presenter.onLockScreenClicked()
        presenter.onControlCenterClicked()
        presenter.onAssistiveTouchClicked()
        presenter.onSettingsMenuClicked()

        assertTrue(view.showedLockScreenDownload)
        assertTrue(view.showedControlCenterDownload)
        assertTrue(view.showedAssistiveTouchDownload)
        assertTrue(view.showedSettingsDrawer)
    }

    private class FakeView : IOSLauncherContract.View {
        var openedAppLibrary = false
        var showedLockScreenDownload = false
        var showedControlCenterDownload = false
        var showedAssistiveTouchDownload = false
        var showedSettingsDrawer = false

        override fun showLoading(isLoading: Boolean) = Unit
        override fun showLauncherApps(apps: List<LauncherIconUiModel>, folders: List<LauncherFolder>) = Unit
        override fun showError(message: String) = Unit
        override fun openDefaultLauncherSelection() = Unit
        override fun showAlreadyDefaultLauncher() = Unit
        override fun showAppOptions(item: LauncherIconUiModel) = Unit
        override fun openApp(app: LauncherApp) = Unit
        override fun openAppInfo(app: LauncherApp) = Unit
        override fun openAppLibrarySettings() {
            openedAppLibrary = true
        }
        override fun showLockScreenDownloadPrompt() {
            showedLockScreenDownload = true
        }
        override fun showControlCenterDownloadPrompt() {
            showedControlCenterDownload = true
        }
        override fun showAssistiveTouchDownloadPrompt() {
            showedAssistiveTouchDownload = true
        }
        override fun showSettingsDrawer() {
            showedSettingsDrawer = true
        }
    }

    private object FakeRepository : LauncherRepository {
        override suspend fun getInstalledApps(): List<LauncherApp> = emptyList()
        override suspend fun getAppIcon(app: LauncherApp): Drawable {
            error("Not used")
        }
        override fun clearIconCache() = Unit
        override fun saveAppOrder(apps: List<LauncherApp>) = Unit
        override fun getLauncherFolders(): List<LauncherFolder> = emptyList()
        override fun saveLauncherFolders(folders: List<LauncherFolder>) = Unit
        override fun getAppCategory(app: LauncherApp): LauncherAppCategory = LauncherAppCategory.OTHER
        override fun saveAppCategory(app: LauncherApp, category: LauncherAppCategory) = Unit
    }
}

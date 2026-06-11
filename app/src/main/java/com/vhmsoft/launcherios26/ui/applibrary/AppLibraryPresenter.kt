package com.vhmsoft.launcherios26.ui.applibrary

import com.vhmsoft.launcherios26.base.CoroutinePresenter
import com.vhmsoft.launcherios26.data.model.LauncherAppCategory
import com.vhmsoft.launcherios26.data.repository.LauncherRepository
import com.vhmsoft.launcherios26.ui.launcher.getLauncherIconItems
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherIconUiModel
import kotlinx.coroutines.launch

class AppLibraryPresenter(
    private val launcherRepository: LauncherRepository
) : CoroutinePresenter<AppLibraryContract.View>(), AppLibraryContract.Presenter {
    private var currentApps: List<LauncherIconUiModel> = emptyList()

    override fun loadApps() {
        presenterScope.launch {
            runCatching { launcherRepository.getLauncherIconItems() }
                .onSuccess { items ->
                    currentApps = items
                    view?.showApps(items)
                }
                .onFailure { error ->
                    view?.showError(error.message ?: "Cannot load app library")
                }
        }
    }

    override fun onAppClicked(item: LauncherIconUiModel) {
        view?.showCategoryPicker(item, item.category)
    }

    override fun onCategorySelected(item: LauncherIconUiModel, category: LauncherAppCategory) {
        launcherRepository.saveAppCategory(item.app, category)
        currentApps = currentApps.map { currentItem ->
            if (currentItem.app.iconKey == item.app.iconKey) {
                currentItem.copy(category = category)
            } else {
                currentItem
            }
        }
        view?.showApps(currentApps)
    }
}

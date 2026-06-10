package com.vhmsoft.launcherios26.ui.applibrary

import com.vhmsoft.launcherios26.base.BaseView
import com.vhmsoft.launcherios26.data.model.LauncherAppCategory
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherIconUiModel

interface AppLibraryContract {
    interface View : BaseView {
        fun showApps(apps: List<LauncherIconUiModel>)
        fun showCategoryPicker(item: LauncherIconUiModel, selectedCategory: LauncherAppCategory)
        fun showError(message: String)
    }

    interface Presenter {
        fun loadApps()
        fun onAppClicked(item: LauncherIconUiModel)
        fun onCategorySelected(item: LauncherIconUiModel, category: LauncherAppCategory)
    }
}

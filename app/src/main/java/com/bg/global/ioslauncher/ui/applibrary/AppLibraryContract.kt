package com.bg.global.ioslauncher.ui.applibrary

import com.bg.global.ioslauncher.base.BaseView
import com.bg.global.ioslauncher.data.model.LauncherAppCategory
import com.bg.global.ioslauncher.ui.launcher.workspace.LauncherIconUiModel

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

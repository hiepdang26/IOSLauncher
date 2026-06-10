package com.vhmsoft.launcherios26.ui.launcher.workspace

import com.vhmsoft.launcherios26.data.model.LauncherAppCategory

data class AppLibraryGroupUiModel(
    val category: LauncherAppCategory,
    val apps: List<LauncherIconUiModel>
) {
    val title: String = category.displayName
    val previewApps: List<LauncherIconUiModel> = apps.take(PREVIEW_ICON_COUNT)

    private companion object {
        const val PREVIEW_ICON_COUNT = 4
    }
}

package com.vhmsoft.launcherios26.ui.launcher.workspace

import com.vhmsoft.launcherios26.data.model.LauncherAppCategory

object AppLibraryGroupBuilder {
    fun buildGroups(apps: List<LauncherIconUiModel>): List<AppLibraryGroupUiModel> {
        val appsByCategory = apps.groupBy { item -> item.category }
        return listOf(
            AppLibraryGroupUiModel(
                category = LauncherAppCategory.RECENT,
                apps = apps.take(RECENT_LIBRARY_APP_COUNT)
            )
        ) + LauncherAppCategory.selectableEntries.map { category ->
            AppLibraryGroupUiModel(
                category = category,
                apps = appsByCategory[category].orEmpty()
            )
        }
    }

    private const val RECENT_LIBRARY_APP_COUNT = 4
}

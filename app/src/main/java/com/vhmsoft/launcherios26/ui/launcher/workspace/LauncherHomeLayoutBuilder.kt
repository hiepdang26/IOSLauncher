package com.vhmsoft.launcherios26.ui.launcher.workspace

import com.vhmsoft.launcherios26.data.model.LauncherFolder

object LauncherHomeLayoutBuilder {
    fun build(
        apps: List<LauncherIconUiModel>,
        folders: List<LauncherFolder>
    ): List<LauncherHomeItemUiModel> {
        if (folders.isEmpty()) {
            return apps.map { LauncherHomeItemUiModel.App(it) }
        }

        val appByKey = apps.associateBy { it.app.iconKey }
        val folderItems = folders.mapNotNull { folder ->
            val folderApps = folder.appIconKeys.mapNotNull { iconKey -> appByKey[iconKey] }
            if (folderApps.size < MIN_FOLDER_SIZE) {
                null
            } else {
                LauncherHomeItemUiModel.Folder(
                    id = folder.id,
                    title = folder.title.ifBlank { DEFAULT_FOLDER_TITLE },
                    apps = folderApps
                )
            }
        }
        if (folderItems.isEmpty()) {
            return apps.map { LauncherHomeItemUiModel.App(it) }
        }

        val folderKeys = folderItems
            .flatMap { folder -> folder.apps.map { item -> item.app.iconKey } }
            .toSet()
        val folderByFirstKey = folderItems.associateBy { folder ->
            folder.apps.first().app.iconKey
        }

        return apps.mapNotNull { app ->
            folderByFirstKey[app.app.iconKey]
                ?: LauncherHomeItemUiModel.App(app).takeIf { app.app.iconKey !in folderKeys }
        }
    }

    fun extractFolders(items: List<LauncherHomeItemUiModel>): List<LauncherFolder> {
        return items.mapNotNull { item ->
            val folder = item as? LauncherHomeItemUiModel.Folder ?: return@mapNotNull null
            if (folder.apps.size < MIN_FOLDER_SIZE) return@mapNotNull null

            LauncherFolder(
                id = folder.id,
                title = folder.title.ifBlank { DEFAULT_FOLDER_TITLE },
                appIconKeys = folder.apps.map { app -> app.app.iconKey }
            )
        }
    }

    fun flattenApps(items: List<LauncherHomeItemUiModel>): List<LauncherIconUiModel> {
        return items.flatMap { item -> item.containedApps() }
    }

    const val DEFAULT_FOLDER_TITLE = "Thư mục"
    private const val MIN_FOLDER_SIZE = 2
}

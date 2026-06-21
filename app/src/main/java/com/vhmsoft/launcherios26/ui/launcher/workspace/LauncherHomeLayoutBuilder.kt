package com.vhmsoft.launcherios26.ui.launcher.workspace

import com.vhmsoft.launcherios26.data.model.LauncherFolder
import java.util.Locale

object LauncherHomeLayoutBuilder {
    fun build(
        apps: List<LauncherIconUiModel>,
        folders: List<LauncherFolder>
    ): List<LauncherHomeItemUiModel> {
        if (folders.isEmpty()) {
            return buildIosCloneDefaultLayout(apps)
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

    private fun buildIosCloneDefaultLayout(
        apps: List<LauncherIconUiModel>
    ): List<LauncherHomeItemUiModel> {
        val pinnedItems = listOfNotNull(
            apps.firstOrNull { app -> app.isWeatherApp() },
            apps.firstOrNull { app -> app.isIosLauncherApp() },
            apps.firstOrNull { app -> app.isPlayStoreApp() }
        ).distinctBy { app -> app.app.iconKey }
        val pinnedKeys = pinnedItems.map { app -> app.app.iconKey }.toSet()
        val googleApps = apps
            .filterNot { app -> app.app.iconKey in pinnedKeys }
            .filter { app -> app.isGoogleFolderApp() }
        val googleKeys = googleApps.map { app -> app.app.iconKey }.toSet()
        val remainingApps = apps.filterNot { app ->
            app.app.iconKey in pinnedKeys || app.app.iconKey in googleKeys
        }

        return buildList {
            addAll(pinnedItems.map { app -> LauncherHomeItemUiModel.App(app) })
            if (googleApps.isNotEmpty()) {
                add(
                    LauncherHomeItemUiModel.Folder(
                        id = DEFAULT_GOOGLE_FOLDER_ID,
                        title = DEFAULT_FOLDER_TITLE,
                        apps = googleApps
                    )
                )
            }
            while (isNotEmpty() && size < IOS_CLONE_DEFAULT_FIRST_PAGE_SIZE) {
                add(LauncherHomeItemUiModel.Placeholder.forGridIndex(size))
            }
            addAll(remainingApps.map { app -> LauncherHomeItemUiModel.App(app) })
        }
    }

    fun extractFolders(items: List<LauncherHomeItemUiModel>): List<LauncherFolder> {
        return normalize(items).mapNotNull { item ->
            val folder = item as? LauncherHomeItemUiModel.Folder ?: return@mapNotNull null
            if (folder.apps.size < MIN_FOLDER_SIZE && !folder.shouldPersistSingleAppFolder()) {
                return@mapNotNull null
            }

            LauncherFolder(
                id = folder.id,
                title = folder.title.ifBlank { DEFAULT_FOLDER_TITLE },
                appIconKeys = folder.apps.map { app -> app.app.iconKey }
            )
        }
    }

    fun flattenApps(items: List<LauncherHomeItemUiModel>): List<LauncherIconUiModel> {
        return normalize(items).flatMap { item -> item.containedApps() }
    }

    fun normalize(items: List<LauncherHomeItemUiModel>): List<LauncherHomeItemUiModel> {
        return items.flatMap { item ->
            when (item) {
                is LauncherHomeItemUiModel.App -> listOf(item)
                is LauncherHomeItemUiModel.Placeholder -> listOf(item)
                is LauncherHomeItemUiModel.Folder -> when (item.apps.size) {
                    0 -> emptyList()
                    1 -> if (item.shouldPersistSingleAppFolder()) {
                        listOf(item)
                    } else {
                        listOf(LauncherHomeItemUiModel.App(item.apps.first()))
                    }
                    else -> listOf(item)
                }
            }
        }.mapIndexed { index, item ->
            when (item) {
                is LauncherHomeItemUiModel.Placeholder -> item.normalizedForGridIndex(index)
                else -> item
            }
        }
    }

    const val DEFAULT_FOLDER_TITLE = "Thư mục"
    fun compact(items: List<LauncherHomeItemUiModel>): List<LauncherHomeItemUiModel> {
        return normalize(items)
            .filterNot { item -> item is LauncherHomeItemUiModel.Placeholder }
    }

    private fun LauncherHomeItemUiModel.Folder.shouldPersistSingleAppFolder(): Boolean {
        return id == DEFAULT_GOOGLE_FOLDER_ID
    }

    private const val MIN_FOLDER_SIZE = 2
    private const val DEFAULT_GOOGLE_FOLDER_ID = "default-google-folder"
    private const val IOS_CLONE_DEFAULT_FIRST_PAGE_SIZE = 24

    private fun LauncherIconUiModel.normalizedSearchText(): String {
        return "${app.label} ${app.packageName}".lowercase(Locale.ROOT)
    }

    private fun LauncherIconUiModel.isWeatherApp(): Boolean {
        val value = normalizedSearchText()
        return value.contains("thời tiết") || value.contains("weather")
    }

    private fun LauncherIconUiModel.isIosLauncherApp(): Boolean {
        val value = normalizedSearchText()
        return value.contains("ios launcher") ||
            value.contains("launcherios") ||
            value.contains("launcher ios")
    }

    private fun LauncherIconUiModel.isPlayStoreApp(): Boolean {
        val value = normalizedSearchText()
        return app.packageName == "com.android.vending" ||
            value.contains("cửa hàng play") ||
            value.contains("play store") ||
            value.contains("google play")
    }

    private fun LauncherIconUiModel.isGoogleFolderApp(): Boolean {
        val packageName = app.packageName.lowercase(Locale.ROOT)
        val value = normalizedSearchText()
        if (isPlayStoreApp()) return false
        return packageName.startsWith("com.google.") ||
            packageName == "com.android.chrome" ||
            value.contains("chrome") ||
            value.contains("gmail") ||
            value.contains("maps") ||
            value.contains("youtube") ||
            value.contains("drive") ||
            value.contains("photos") ||
            value.contains("google")
    }
}

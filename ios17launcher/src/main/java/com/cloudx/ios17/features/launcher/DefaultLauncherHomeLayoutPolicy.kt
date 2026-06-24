package com.cloudx.ios17.features.launcher

import com.cloudx.ios17.core.database.model.ApplicationItem
import com.cloudx.ios17.core.database.model.FolderItem
import com.cloudx.ios17.core.database.model.LauncherItem
import com.cloudx.ios17.core.utils.Constants
import java.text.Collator

object DefaultLauncherHomeLayoutPolicy {
    const val GOOGLE_FOLDER_ID = "-1700170001"

    private const val DEFAULT_MAX_APPS_PER_PAGE = 24
    private const val GOOGLE_FOLDER_TITLE = "Google"
    private const val FOLDER_PACKAGE_NAME = "FOLDER"
    private const val CHROME_PACKAGE = "com.android.chrome"
    private const val PLAY_STORE_PACKAGE = "com.android.vending"

    fun arrangeDesktopItems(
        apps: List<ApplicationItem>,
        launcherPackageName: String,
        maxAppsPerPage: Int = DEFAULT_MAX_APPS_PER_PAGE
    ): MutableList<LauncherItem> {
        val safeMaxAppsPerPage = maxAppsPerPage.coerceAtLeast(1)
        val sortedApps = apps.sortedWith { app1, app2 ->
            Collator.getInstance().compare(app1.title.toString(), app2.title.toString())
        }
        val selectedIds = LinkedHashSet<String>()

        fun takeFirst(predicate: (ApplicationItem) -> Boolean): ApplicationItem? {
            val app = sortedApps.firstOrNull { it.id !in selectedIds && predicate(it) }
            if (app != null) {
                selectedIds.add(app.id)
            }
            return app
        }

        val weatherApp = takeFirst(::isWeatherApp)
        val launcherApps = sortedApps.filter { app ->
            isCurrentLauncherApp(app, launcherPackageName)
        }
        val launcherApp = launcherApps.firstOrNull { it.id !in selectedIds }
        if (launcherApp != null) {
            selectedIds.addAll(launcherApps.map { it.id })
        }
        val playStoreApp = takeFirst(::isPlayStoreApp)
        val googleApps = sortedApps
            .filter { it.id !in selectedIds && isGoogleFolderApp(it) }
            .also { googleItems -> selectedIds.addAll(googleItems.map { it.id }) }
        val googleFolder = createGoogleFolder(googleApps)
        val firstPageItems = listOfNotNull(weatherApp, launcherApp, playStoreApp, googleFolder)
        val remainingApps = sortedApps.filter { it.id !in selectedIds }

        return ArrayList<LauncherItem>().apply {
            firstPageItems.forEachIndexed { index, item ->
                placeOnDesktop(item, screenId = 0, cell = index)
                add(item)
            }
            remainingApps.forEachIndexed { index, app ->
                placeOnDesktop(
                    item = app,
                    screenId = 1L + (index / safeMaxAppsPerPage).toLong(),
                    cell = index % safeMaxAppsPerPage
                )
                add(app)
            }
        }
    }

    private fun createGoogleFolder(googleApps: List<ApplicationItem>): FolderItem? {
        if (googleApps.isEmpty()) {
            return null
        }

        return FolderItem().apply {
            id = GOOGLE_FOLDER_ID
            title = GOOGLE_FOLDER_TITLE
            packageName = FOLDER_PACKAGE_NAME
            container = Constants.CONTAINER_DESKTOP.toLong()
            screenId = 0
            cell = 0
            items = googleApps.mapIndexed { index, app ->
                app.container = GOOGLE_FOLDER_ID.toLong()
                app.screenId = -1
                app.cell = index
                app
            }.toMutableList()
        }
    }

    private fun placeOnDesktop(item: LauncherItem, screenId: Long, cell: Int) {
        item.container = Constants.CONTAINER_DESKTOP.toLong()
        item.screenId = screenId
        item.cell = cell
    }

    private fun isWeatherApp(app: ApplicationItem): Boolean {
        val packageName = app.packageName.orEmpty()
        val title = app.title.toString()
        return packageName.contains("weather", ignoreCase = true) ||
            title.equals("Weather", ignoreCase = true) ||
            title.equals("Thời tiết", ignoreCase = true)
    }

    private fun isPlayStoreApp(app: ApplicationItem): Boolean {
        val packageName = app.packageName.orEmpty()
        val title = app.title.toString()
        return packageName.equals(PLAY_STORE_PACKAGE, ignoreCase = true) ||
            title.equals("Play Store", ignoreCase = true) ||
            title.equals("Cửa hàng Play", ignoreCase = true) ||
            title.equals("CH Play", ignoreCase = true)
    }

    private fun isCurrentLauncherApp(app: ApplicationItem, launcherPackageName: String): Boolean {
        val packageName = app.packageName.orEmpty()
        return packageName.equals(launcherPackageName, ignoreCase = true) ||
            app.id.startsWith("$launcherPackageName/", ignoreCase = true)
    }

    private fun isGoogleFolderApp(app: ApplicationItem): Boolean {
        val packageName = app.packageName.orEmpty()
        return packageName.startsWith("com.google.", ignoreCase = true) ||
            packageName.equals(CHROME_PACKAGE, ignoreCase = true)
    }
}

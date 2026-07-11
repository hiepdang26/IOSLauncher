package com.vhmsoft.launcherios26.data.repository

import android.graphics.drawable.Drawable
import com.vhmsoft.launcherios26.data.icon.SystemIosIconOverridePolicy
import com.vhmsoft.launcherios26.data.model.LauncherApp
import com.vhmsoft.launcherios26.data.model.LauncherAppCategory
import com.vhmsoft.launcherios26.data.model.LauncherAppCustomizationPolicy
import com.vhmsoft.launcherios26.data.model.LauncherFolder
import com.vhmsoft.launcherios26.data.source.local.LauncherLocalDataSource
import com.vhmsoft.launcherios26.data.source.remote.LauncherRemoteDataSource

class LauncherRepositoryImpl(
    private val localDataSource: LauncherLocalDataSource,
    private val remoteDataSource: LauncherRemoteDataSource
) : LauncherRepository {
    override suspend fun getAllInstalledApps(): List<LauncherApp> {
        return remoteDataSource.getInstalledApps()
            .withCustomLabels(localDataSource.getCustomLabels())
            .sortedBySavedOrder(localDataSource.getAppOrder())
    }

    override suspend fun getInstalledApps(): List<LauncherApp> {
        return LauncherAppCustomizationPolicy.apply(
            apps = remoteDataSource.getInstalledApps(),
            hiddenIconKeys = localDataSource.getHiddenIconKeys(),
            customLabels = localDataSource.getCustomLabels()
        ).sortedBySavedOrder(localDataSource.getAppOrder())
    }

    override suspend fun getAppIcon(app: LauncherApp): Drawable {
        localDataSource.getCustomIcon(app.iconKey)?.let { customIcon ->
            return customIcon
        }

        if (!SystemIosIconOverridePolicy.hasOverride(app)) {
            localDataSource.getCachedIcon(app.iconKey)?.let { cachedIcon ->
                return cachedIcon
            }
        }

        return remoteDataSource.getAppIcon(app).also { icon ->
            localDataSource.cacheIcon(app.iconKey, icon)
        }
    }

    override fun clearIconCache() {
        localDataSource.clearIconCache()
    }

    override fun saveAppOrder(apps: List<LauncherApp>) {
        localDataSource.saveAppOrder(apps.map { it.iconKey })
    }

    override fun getDockOrder(): List<String> {
        return localDataSource.getDockOrder()
    }

    override fun saveDockOrder(iconKeys: List<String>) {
        localDataSource.saveDockOrder(iconKeys)
    }

    override fun getLauncherFolders(): List<LauncherFolder> {
        return localDataSource.getLauncherFolders()
    }

    override fun saveLauncherFolders(folders: List<LauncherFolder>) {
        localDataSource.saveLauncherFolders(folders)
    }

    override fun getDockFolders(): List<LauncherFolder> {
        return localDataSource.getDockFolders()
    }

    override fun saveDockFolders(folders: List<LauncherFolder>) {
        localDataSource.saveDockFolders(folders)
    }

    override fun getAppCategory(app: LauncherApp): LauncherAppCategory {
        val savedCategoryCode = localDataSource.getAppCategory(app.iconKey)
        val savedCategory = LauncherAppCategory.fromCode(savedCategoryCode)
        return if (savedCategoryCode != null) {
            savedCategory
        } else {
            LauncherAppCategory.inferFrom(app)
        }
    }

    override fun saveAppCategory(app: LauncherApp, category: LauncherAppCategory) {
        localDataSource.saveAppCategory(app.iconKey, category.code)
    }

    override fun saveCustomLabel(app: LauncherApp, label: String) {
        localDataSource.saveCustomLabel(app.iconKey, label)
    }

    override fun getHiddenIconKeys(): Set<String> {
        return localDataSource.getHiddenIconKeys()
    }

    override fun setAppHidden(app: LauncherApp, hidden: Boolean) {
        localDataSource.setAppHidden(app.iconKey, hidden)
    }

    override fun saveCustomIconUri(app: LauncherApp, uri: String?) {
        localDataSource.saveCustomIconUri(app.iconKey, uri)
    }

    private fun List<LauncherApp>.withCustomLabels(customLabels: Map<String, String>): List<LauncherApp> {
        return LauncherAppCustomizationPolicy.apply(
            apps = this,
            hiddenIconKeys = emptySet(),
            customLabels = customLabels
        )
    }

    private fun List<LauncherApp>.sortedBySavedOrder(savedOrder: List<String>): List<LauncherApp> {
        if (savedOrder.isEmpty()) return this

        val orderIndex = savedOrder.withIndex().associate { it.value to it.index }
        return sortedWith(
            compareBy<LauncherApp> { orderIndex[it.iconKey] ?: Int.MAX_VALUE }
                .thenBy(String.CASE_INSENSITIVE_ORDER) { it.label }
        )
    }
}

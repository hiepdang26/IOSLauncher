package com.vhmsoft.launcherios26.data.source.local

import android.graphics.drawable.Drawable
import com.vhmsoft.launcherios26.data.cache.AppIconCache
import com.vhmsoft.launcherios26.data.cache.LauncherPreferences
import com.vhmsoft.launcherios26.data.model.LauncherFolder

class LauncherLocalDataSourceImpl(
    private val iconCache: AppIconCache,
    private val preferences: LauncherPreferences
) : LauncherLocalDataSource {
    override fun getCachedIcon(iconKey: String): Drawable? {
        return iconCache.get(iconKey)
    }

    override fun cacheIcon(iconKey: String, icon: Drawable) {
        iconCache.put(iconKey, icon)
    }

    override fun clearIconCache() {
        iconCache.clear()
    }

    override fun getAppOrder(): List<String> {
        return preferences.getAppOrder()
    }

    override fun saveAppOrder(iconKeys: List<String>) {
        preferences.saveAppOrder(iconKeys)
    }

    override fun getLauncherFolders(): List<LauncherFolder> {
        return preferences.getLauncherFolders()
    }

    override fun saveLauncherFolders(folders: List<LauncherFolder>) {
        preferences.saveLauncherFolders(folders)
    }

    override fun getAppCategory(iconKey: String): String? {
        return preferences.getAppCategory(iconKey)
    }

    override fun getAppCategories(): Map<String, String> {
        return preferences.getAppCategories()
    }

    override fun saveAppCategory(iconKey: String, categoryCode: String) {
        preferences.saveAppCategory(iconKey, categoryCode)
    }
}

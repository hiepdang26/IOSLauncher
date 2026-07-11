package com.vhmsoft.launcherios26.data.source.local

import android.content.Context
import android.graphics.drawable.Drawable
import com.vhmsoft.launcherios26.core.LauncherCustomIconPreferences
import com.vhmsoft.launcherios26.data.cache.AppIconCache
import com.vhmsoft.launcherios26.data.cache.LauncherPreferences
import com.vhmsoft.launcherios26.data.model.LauncherFolder

class LauncherLocalDataSourceImpl(
    private val iconCache: AppIconCache,
    private val preferences: LauncherPreferences,
    context: Context
) : LauncherLocalDataSource {
    private val appContext = context.applicationContext

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

    override fun getDockOrder(): List<String> {
        return preferences.getDockOrder()
    }

    override fun saveDockOrder(iconKeys: List<String>) {
        preferences.saveDockOrder(iconKeys)
    }

    override fun getLauncherFolders(): List<LauncherFolder> {
        return preferences.getLauncherFolders()
    }

    override fun saveLauncherFolders(folders: List<LauncherFolder>) {
        preferences.saveLauncherFolders(folders)
    }

    override fun getDockFolders(): List<LauncherFolder> {
        return preferences.getDockFolders()
    }

    override fun saveDockFolders(folders: List<LauncherFolder>) {
        preferences.saveDockFolders(folders)
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

    override fun getCustomLabels(): Map<String, String> {
        return preferences.getCustomLabels()
    }

    override fun saveCustomLabel(iconKey: String, label: String) {
        preferences.saveCustomLabel(iconKey, label)
    }

    override fun getHiddenIconKeys(): Set<String> {
        return preferences.getHiddenIconKeys()
    }

    override fun setAppHidden(iconKey: String, hidden: Boolean) {
        preferences.setAppHidden(iconKey, hidden)
    }

    override fun getCustomIcon(iconKey: String): Drawable? {
        return LauncherCustomIconPreferences.loadCustomIcon(appContext, listOf(iconKey))
    }

    override fun saveCustomIconUri(iconKey: String, uri: String?) {
        LauncherCustomIconPreferences.saveCustomIconUri(appContext, listOf(iconKey), uri)
        clearIconCache()
    }
}

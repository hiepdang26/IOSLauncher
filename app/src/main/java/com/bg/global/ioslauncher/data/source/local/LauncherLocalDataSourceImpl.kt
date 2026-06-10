package com.bg.global.ioslauncher.data.source.local

import android.graphics.drawable.Drawable
import com.bg.global.ioslauncher.data.cache.AppIconCache
import com.bg.global.ioslauncher.data.cache.LauncherPreferences

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

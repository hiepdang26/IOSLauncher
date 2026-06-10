package com.bg.global.ioslauncher.data.source.local

import android.graphics.drawable.Drawable

interface LauncherLocalDataSource {
    fun getCachedIcon(iconKey: String): Drawable?
    fun cacheIcon(iconKey: String, icon: Drawable)
    fun clearIconCache()
    fun getAppOrder(): List<String>
    fun saveAppOrder(iconKeys: List<String>)
    fun getAppCategory(iconKey: String): String?
    fun getAppCategories(): Map<String, String>
    fun saveAppCategory(iconKey: String, categoryCode: String)
}

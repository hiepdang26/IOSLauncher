package com.vhmsoft.launcherios26.data.source.local

import android.graphics.drawable.Drawable
import com.vhmsoft.launcherios26.data.model.LauncherFolder

interface LauncherLocalDataSource {
    fun getCachedIcon(iconKey: String): Drawable?
    fun cacheIcon(iconKey: String, icon: Drawable)
    fun clearIconCache()
    fun getAppOrder(): List<String>
    fun saveAppOrder(iconKeys: List<String>)
    fun getDockOrder(): List<String>
    fun saveDockOrder(iconKeys: List<String>)
    fun getLauncherFolders(): List<LauncherFolder>
    fun saveLauncherFolders(folders: List<LauncherFolder>)
    fun getDockFolders(): List<LauncherFolder>
    fun saveDockFolders(folders: List<LauncherFolder>)
    fun getAppCategory(iconKey: String): String?
    fun getAppCategories(): Map<String, String>
    fun saveAppCategory(iconKey: String, categoryCode: String)
    fun getCustomLabels(): Map<String, String>
    fun saveCustomLabel(iconKey: String, label: String)
    fun getHiddenIconKeys(): Set<String>
    fun setAppHidden(iconKey: String, hidden: Boolean)
    fun getCustomIcon(iconKey: String): Drawable?
    fun saveCustomIconUri(iconKey: String, uri: String?)
}

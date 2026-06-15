package com.vhmsoft.launcherios26.data.repository

import android.graphics.drawable.Drawable
import com.vhmsoft.launcherios26.data.model.LauncherApp
import com.vhmsoft.launcherios26.data.model.LauncherAppCategory
import com.vhmsoft.launcherios26.data.model.LauncherFolder

interface LauncherRepository {
    suspend fun getInstalledApps(): List<LauncherApp>
    suspend fun getAppIcon(app: LauncherApp): Drawable
    fun clearIconCache()
    fun saveAppOrder(apps: List<LauncherApp>)
    fun getDockOrder(): List<String>
    fun saveDockOrder(iconKeys: List<String>)
    fun getLauncherFolders(): List<LauncherFolder>
    fun saveLauncherFolders(folders: List<LauncherFolder>)
    fun getDockFolders(): List<LauncherFolder>
    fun saveDockFolders(folders: List<LauncherFolder>)
    fun getAppCategory(app: LauncherApp): LauncherAppCategory
    fun saveAppCategory(app: LauncherApp, category: LauncherAppCategory)
}

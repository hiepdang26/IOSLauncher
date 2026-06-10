package com.bg.global.ioslauncher.data.repository

import android.graphics.drawable.Drawable
import com.bg.global.ioslauncher.data.model.LauncherApp
import com.bg.global.ioslauncher.data.model.LauncherAppCategory

interface LauncherRepository {
    suspend fun getInstalledApps(): List<LauncherApp>
    suspend fun getAppIcon(app: LauncherApp): Drawable
    fun clearIconCache()
    fun saveAppOrder(apps: List<LauncherApp>)
    fun getAppCategory(app: LauncherApp): LauncherAppCategory
    fun saveAppCategory(app: LauncherApp, category: LauncherAppCategory)
}

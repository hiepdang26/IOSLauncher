package com.bg.global.ioslauncher.data.source.remote

import android.graphics.drawable.Drawable
import com.bg.global.ioslauncher.data.model.LauncherApp

interface LauncherRemoteDataSource {
    suspend fun getInstalledApps(): List<LauncherApp>
    suspend fun getAppIcon(app: LauncherApp): Drawable
}

package com.vhmsoft.launcherios26.data.source.remote

import android.graphics.drawable.Drawable
import com.vhmsoft.launcherios26.data.model.LauncherApp

interface LauncherRemoteDataSource {
    suspend fun getInstalledApps(): List<LauncherApp>
    suspend fun getAppIcon(app: LauncherApp): Drawable
}

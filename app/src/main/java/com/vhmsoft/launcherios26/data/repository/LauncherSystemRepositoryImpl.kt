package com.vhmsoft.launcherios26.data.repository

import android.appwidget.AppWidgetProviderInfo
import android.content.ComponentName
import android.graphics.Rect
import android.os.UserHandle
import com.vhmsoft.launcherios26.data.source.remote.LauncherSystemRemoteDataSource

class LauncherSystemRepositoryImpl(
    private val remoteDataSource: LauncherSystemRemoteDataSource
) : LauncherSystemRepository {
    override fun loadWidgetProviderLabel(providerInfo: AppWidgetProviderInfo): CharSequence {
        return remoteDataSource.loadWidgetProviderLabel(providerInfo)
    }

    override fun isLauncherPackageAvailable(packageName: String, userHandle: UserHandle): Boolean {
        return remoteDataSource.isLauncherPackageAvailable(packageName, userHandle)
    }

    override fun startMainActivity(
        componentName: ComponentName?,
        userHandle: UserHandle,
        sourceBounds: Rect?
    ) {
        remoteDataSource.startMainActivity(componentName, userHandle, sourceBounds)
    }
}

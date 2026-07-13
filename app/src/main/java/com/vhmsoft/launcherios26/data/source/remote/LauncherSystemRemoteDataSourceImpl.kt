package com.vhmsoft.launcherios26.data.source.remote

import android.appwidget.AppWidgetProviderInfo
import android.content.ComponentName
import android.content.pm.LauncherApps
import android.content.pm.PackageManager
import android.graphics.Rect
import android.os.Bundle
import android.os.UserHandle

class LauncherSystemRemoteDataSourceImpl(
    private val packageManager: PackageManager,
    private val launcherApps: LauncherApps
) : LauncherSystemRemoteDataSource {
    override fun loadWidgetProviderLabel(providerInfo: AppWidgetProviderInfo): CharSequence {
        return providerInfo.loadLabel(packageManager)
    }

    override fun isLauncherPackageAvailable(packageName: String, userHandle: UserHandle): Boolean {
        return launcherApps.getActivityList(packageName, userHandle).isNotEmpty()
    }

    override fun startMainActivity(
        componentName: ComponentName?,
        userHandle: UserHandle,
        sourceBounds: Rect?
    ) {
        launcherApps.startMainActivity(componentName, userHandle, sourceBounds, null as Bundle?)
    }
}

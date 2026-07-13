package com.vhmsoft.launcherios26.data.source.remote

import android.appwidget.AppWidgetProviderInfo
import android.content.ComponentName
import android.graphics.Rect
import android.os.UserHandle

interface LauncherSystemRemoteDataSource {
    fun loadWidgetProviderLabel(providerInfo: AppWidgetProviderInfo): CharSequence
    fun isLauncherPackageAvailable(packageName: String, userHandle: UserHandle): Boolean
    fun startMainActivity(componentName: ComponentName?, userHandle: UserHandle, sourceBounds: Rect?)
}

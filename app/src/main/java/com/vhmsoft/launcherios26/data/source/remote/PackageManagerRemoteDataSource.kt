package com.vhmsoft.launcherios26.data.source.remote

import android.content.ComponentName
import android.content.Intent
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.os.Build
import com.vhmsoft.launcherios26.common.coroutines.DefaultDispatcherProvider
import com.vhmsoft.launcherios26.common.coroutines.DispatcherProvider
import com.vhmsoft.launcherios26.data.model.LauncherApp
import kotlinx.coroutines.withContext

class PackageManagerRemoteDataSource(
    private val packageManager: PackageManager,
    private val appPackageName: String,
    private val dispatcherProvider: DispatcherProvider = DefaultDispatcherProvider
) : LauncherRemoteDataSource {
    override suspend fun getInstalledApps(): List<LauncherApp> = withContext(dispatcherProvider.io) {
        val launcherIntent = Intent(Intent.ACTION_MAIN).apply {
            addCategory(Intent.CATEGORY_LAUNCHER)
        }
        val resolveInfos = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            packageManager.queryIntentActivities(
                launcherIntent,
                PackageManager.ResolveInfoFlags.of(0)
            )
        } else {
            @Suppress("DEPRECATION")
            packageManager.queryIntentActivities(launcherIntent, 0)
        }

        resolveInfos
            .asSequence()
            .mapNotNull { resolveInfo ->
                val activityInfo = resolveInfo.activityInfo ?: return@mapNotNull null
                val packageName = activityInfo.packageName ?: return@mapNotNull null

                val label = resolveInfo.loadLabel(packageManager)?.toString()
                    ?.takeIf { it.isNotBlank() }
                    ?: activityInfo.name.substringAfterLast('.')
                val className = activityInfo.name
                LauncherApp(
                    label = label,
                    packageName = packageName,
                    className = className,
                    iconKey = "$packageName/$className",
                    canUninstall = canUninstall(
                        packageName = packageName,
                        applicationFlags = activityInfo.applicationInfo?.flags ?: 0
                    )
                )
            }
            .distinctBy { it.iconKey }
            .sortedWith(
                compareBy<LauncherApp> { app -> app.packageName != appPackageName }
                    .thenBy(String.CASE_INSENSITIVE_ORDER) { app -> app.label }
            )
            .toList()
    }

    override suspend fun getAppIcon(app: LauncherApp): Drawable = withContext(dispatcherProvider.io) {
        packageManager.getActivityIcon(ComponentName(app.packageName, app.className))
    }

    private fun canUninstall(
        packageName: String,
        applicationFlags: Int
    ): Boolean {
        if (packageName == appPackageName) return false

        val systemApp = (applicationFlags and ApplicationInfo.FLAG_SYSTEM) != 0
        val updatedSystemApp = (applicationFlags and ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) != 0
        return !systemApp && !updatedSystemApp
    }
}

package com.cloudx.ios17.core.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.ApplicationInfo
import android.content.pm.LauncherActivityInfo
import android.content.pm.LauncherApps
import android.content.pm.PackageManager
import com.cloudx.ios17.BlissLauncher
import com.cloudx.ios17.R
import com.cloudx.ios17.core.IconsHandler
import com.cloudx.ios17.core.LauncherCustomIconPolicy
import com.cloudx.ios17.core.LauncherCustomIconPreferences
import com.cloudx.ios17.core.LauncherAppRenamePreferences
import com.cloudx.ios17.core.SystemIosIconOverridePolicy
import com.cloudx.ios17.core.database.model.ApplicationItem
import com.cloudx.ios17.features.launcher.AppProvider
import java.util.LinkedHashMap
import timber.log.Timber

object AppUtils {

    private const val TAG = "AppUtils"

    @Volatile
    private var sLauncherApps: LauncherApps? = null

    /** Uses the PackageManager to find all launchable apps. */
    @SuppressLint("CheckResult")
    @JvmStatic
    fun loadAll(context: Context): Map<String, ApplicationItem> {
        val manager = context.getSystemService(Context.USER_SERVICE) as android.os.UserManager
        val launcherApps = getLauncherApps(context)
        val iconsHandler = BlissLauncher.getApplication(context).iconsHandler
        val appArrayMap = LinkedHashMap<String, ApplicationItem>()

        for (profile in manager.userProfiles) {
            val user = UserHandle(manager.getSerialNumberForUser(profile), profile)
            val infos = launcherApps.getActivityList(null, profile)
            Timber.tag(TAG).i("totalAppsBefore: %s", infos.size)
            for (activityInfo in infos) {
                val appInfo = activityInfo.applicationInfo
                if (AppProvider.DISABLED_PACKAGES.contains(appInfo.packageName)) {
                    continue
                }
                val applicationItem = createApplicationItem(context, activityInfo, user, iconsHandler, appInfo)
                appArrayMap[applicationItem.id] = applicationItem
            }
        }
        Timber.tag(TAG).i("Total Apps Loaded: %s", appArrayMap.size)
        return appArrayMap
    }

    @JvmStatic
    fun getPackageNameForIntent(intent: Intent, pm: PackageManager): String? {
        val activities = pm.queryIntentActivities(intent, 0)
        if (activities.isEmpty()) {
            return null
        }
        val activity = activities[0].activityInfo
        return activity.applicationInfo.packageName
    }

    @JvmStatic
    fun createAppItem(context: Context, packageName: String, userHandle: UserHandle): ApplicationItem? {
        if (AppProvider.DISABLED_PACKAGES.contains(packageName)) {
            return null
        }

        val launcherApps = getLauncherApps(context)
        val iconsHandler = BlissLauncher.getApplication(context).iconsHandler

        val launcherActivityInfos = launcherApps.getActivityList(packageName, userHandle.getRealHandle())
        if (launcherActivityInfos == null || launcherActivityInfos.isEmpty()) {
            return null
        }

        val launcherActivityInfo = launcherActivityInfos[0] ?: return null
        val appInfo = launcherActivityInfo.applicationInfo
        return createApplicationItem(context, launcherActivityInfo, userHandle, iconsHandler, appInfo)
    }

    private fun getLauncherApps(context: Context): LauncherApps {
        val cached = sLauncherApps
        if (cached != null) {
            return cached
        }
        val launcherApps = context.getSystemService(Context.LAUNCHER_APPS_SERVICE) as LauncherApps
        sLauncherApps = launcherApps
        return launcherApps
    }

    private fun createApplicationItem(
        context: Context,
        activityInfo: LauncherActivityInfo,
        user: UserHandle,
        iconsHandler: IconsHandler,
        appInfo: ApplicationInfo
    ): ApplicationItem {
        val applicationItem = ApplicationItem(activityInfo, user)
        val appKeys = LauncherCustomIconPolicy.iconKeys(
            appId = applicationItem.id,
            componentName = applicationItem.componentName?.flattenToString(),
            packageName = appInfo.packageName
        )
        val activityLabel = activityInfo.label?.toString().orEmpty()
        val isSystemApp =
            (appInfo.flags and ApplicationInfo.FLAG_SYSTEM) != 0 ||
                (appInfo.flags and ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) != 0
        applicationItem.icon = LauncherCustomIconPreferences.loadCustomIcon(context, appKeys)
            ?: SystemIosIconOverridePolicy.resolveDrawable(
                context = context,
                label = activityLabel,
                packageName = appInfo.packageName,
                className = activityInfo.componentName.className,
                isSystemApp = isSystemApp
            )
            ?: iconsHandler.getDrawableIconForPackage(activityInfo, user)
        val componentName = activityInfo.componentName.toString()
        applicationItem.appType =
            if (iconsHandler.isClock(componentName)) {
                ApplicationItem.TYPE_CLOCK
            } else if (iconsHandler.isCalendar(componentName)) {
                ApplicationItem.TYPE_CALENDAR
            } else {
                ApplicationItem.TYPE_DEFAULT
            }
        applicationItem.title = activityLabel
        applicationItem.container = Constants.CONTAINER_DESKTOP.toLong()
        if (appInfo.packageName.equals("com.generalmagic.magicearth", ignoreCase = true)) {
            applicationItem.title = context.getString(R.string.app_name_maps)
        }
        applicationItem.title = LauncherAppRenamePreferences.renamedTitle(
            context = context,
            appKeys = appKeys,
            defaultTitle = applicationItem.title?.toString().orEmpty()
        )
        applicationItem.packageName = appInfo.packageName
        return applicationItem
    }
}

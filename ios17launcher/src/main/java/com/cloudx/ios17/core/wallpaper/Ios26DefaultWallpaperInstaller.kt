package com.cloudx.ios17.core.wallpaper

import android.app.WallpaperManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import com.cloudx.ios17.R
import com.cloudx.ios17.core.LauncherHomeLayoutPreferences
import com.cloudx.ios17.core.executors.AppExecutors
import timber.log.Timber

object Ios26DefaultWallpaperInstaller {
    private const val KEY_APPLIED_WALLPAPER_VERSION = "ios26_default_wallpaper_applied_version"
    private const val WALLPAPER_VERSION = 1

    @Volatile
    private var applyInFlight = false

    fun applyIfNeededWhenDefaultLauncher(context: Context): Boolean {
        return applyWhenDefaultLauncher(context, force = false)
    }

    fun applyWhenDefaultLauncherSelected(context: Context): Boolean {
        return applyWhenDefaultLauncher(context, force = true)
    }

    private fun applyWhenDefaultLauncher(context: Context, force: Boolean): Boolean {
        val appContext = context.applicationContext
        if (!isCurrentDefaultLauncher(appContext)) {
            return false
        }
        return applyIfNeeded(appContext, force)
    }

    private fun applyIfNeeded(context: Context, force: Boolean): Boolean {
        val prefs = context.getSharedPreferences(
            LauncherHomeLayoutPreferences.LAYOUT_PREFERENCES_NAME,
            Context.MODE_PRIVATE
        )
        if (!force && prefs.getInt(KEY_APPLIED_WALLPAPER_VERSION, 0) >= WALLPAPER_VERSION) {
            return false
        }

        synchronized(this) {
            if (applyInFlight) return false
            applyInFlight = true
        }

        val clearedCustomWallpaper = !prefs.getString(
            LauncherHomeLayoutPreferences.KEY_CUSTOM_WALLPAPER_URI,
            null
        ).isNullOrBlank()
        if (clearedCustomWallpaper) {
            prefs.edit()
                .remove(LauncherHomeLayoutPreferences.KEY_CUSTOM_WALLPAPER_URI)
                .apply()
        }

        AppExecutors.getInstance().diskIO().execute {
            try {
                WallpaperManager.getInstance(context).setResource(
                    R.drawable.ios26_sky_home_screen_light,
                    WallpaperManager.FLAG_SYSTEM
                )
                prefs.edit()
                    .putInt(KEY_APPLIED_WALLPAPER_VERSION, WALLPAPER_VERSION)
                    .apply()
            } catch (error: Throwable) {
                Timber.w(error, "Unable to apply iOS 26 default launcher wallpaper")
            } finally {
                applyInFlight = false
            }
        }

        return clearedCustomWallpaper
    }

    private fun isCurrentDefaultLauncher(context: Context): Boolean {
        val homeIntent = Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_HOME)
        val resolveInfo = context.packageManager.resolveActivity(
            homeIntent,
            PackageManager.MATCH_DEFAULT_ONLY
        ) ?: return false
        return resolveInfo.activityInfo?.packageName == context.packageName
    }
}

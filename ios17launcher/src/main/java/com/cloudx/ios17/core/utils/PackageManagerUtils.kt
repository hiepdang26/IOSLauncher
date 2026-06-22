package com.cloudx.ios17.core.utils

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager

object PackageManagerUtils {

    private const val FLAG_SUSPENDED = 1 shl 30

    /**
     * Checks whether a given package exists.
     */
    @JvmStatic
    fun isAppInstalled(context: Context, packageName: String): Boolean {
        return getApplicationInfo(context, packageName, 0) != null
    }

    /**
     * Check whether a package with specific flags is enabled.
     */
    @JvmStatic
    fun isAppEnabled(context: Context, packageName: String, flags: Int): Boolean {
        val info = getApplicationInfo(context, packageName, flags)
        return info != null && info.enabled
    }

    /**
     * Check whether a package is enabled.
     */
    @JvmStatic
    fun isAppEnabled(context: Context, packageName: String): Boolean {
        return isAppEnabled(context, packageName, 0)
    }

    /**
     * Check if a package can possibly be on the SDCard. This is just a workaround
     * and doesn't guarantee that the app is on SD card.
     */
    @JvmStatic
    fun isAppOnSdcard(context: Context, packageName: String): Boolean {
        return isAppEnabled(context, packageName, PackageManager.GET_UNINSTALLED_PACKAGES)
    }

    /**
     * Check if a package is suspended.
     */
    @JvmStatic
    fun isAppSuspended(context: Context, packageName: String): Boolean {
        return isAppSuspended(getApplicationInfo(context, packageName, 0))
    }

    /**
     * Check if a package is suspended.
     */
    @JvmStatic
    fun isAppSuspended(info: ApplicationInfo?): Boolean {
        return info != null && (info.flags and FLAG_SUSPENDED) != 0
    }

    /**
     * Get the ApplicationInfo of a package.
     */
    @JvmStatic
    fun getApplicationInfo(context: Context, packageName: String, flags: Int): ApplicationInfo? {
        return try {
            context.packageManager.getApplicationInfo(packageName, flags)
        } catch (e: PackageManager.NameNotFoundException) {
            null
        }
    }
}

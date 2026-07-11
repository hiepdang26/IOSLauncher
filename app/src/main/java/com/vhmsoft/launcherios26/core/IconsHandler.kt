package com.vhmsoft.launcherios26.core

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.LauncherActivityInfo
import android.content.pm.LauncherApps
import android.content.pm.PackageManager
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.drawable.AdaptiveIconDrawable
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.Log
import com.vhmsoft.launcherios26.BlissLauncher
import com.vhmsoft.launcherios26.core.customviews.AdaptiveIconDrawableCompat
import com.vhmsoft.launcherios26.core.utils.UserHandle
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStream
import java.util.HashMap
import javax.xml.parsers.DocumentBuilderFactory

/**
 * Inspired from
 * http://stackoverflow.com/questions/31490630/how-to-load-icon-from-icon-pack
 */
class IconsHandler(private val ctx: Context) {

    // Map with available icons packs.
    private val iconsPacks = HashMap<String, String>()

    // Map with available drawable for an icons pack.
    private val packagesDrawables: MutableMap<String, String> = HashMap()

    private val mIconDpi = BlissLauncher.getApplication(ctx).deviceProfile.fillResIconDpi
    private var iconPackres: Resources? = null
    private var iconsPackPackageName = ""
    private var maskImage: Bitmap? = null
    private var frontImage: Bitmap? = null
    private var factor = 1.0f
    private val pm: PackageManager = ctx.packageManager

    init {
        loadIconsPack("foundation.e.blissiconpack")
    }

    private fun iconPackExists(packageManager: PackageManager): Boolean =
        try {
            packageManager.getPackageInfo("foundation.e.blissiconpack", PackageManager.GET_META_DATA)
            true
        } catch (_: PackageManager.NameNotFoundException) {
            false
        }

    /**
     * Parse icons pack metadata.
     *
     * @param packageName Android package ID of the package to parse.
     */
    fun loadIconsPack(packageName: String) {
        iconsPackPackageName = if (iconPackExists(pm)) packageName else "default"

        packagesDrawables.clear()

        // System icons, nothing to do.
        if (iconsPackPackageName.equals("default", ignoreCase = true)) {
            return
        }

        try {
            iconPackres = pm.getResourcesForApplication(iconsPackPackageName)
            val iconPackContext = ctx.createPackageContext(iconsPackPackageName, 0)
            val stream: InputStream = iconPackContext.assets.open("appfilter.xml")
            stream.use {
                val doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(it)
                val items = doc.getElementsByTagName("item")
                for (i in 0 until items.length) {
                    val item = items.item(i)
                    val componentName = item.attributes.getNamedItem("component").textContent
                    val drawableName = item.attributes.getNamedItem("drawable").textContent

                    if (!packagesDrawables.containsKey(componentName)) {
                        packagesDrawables[componentName] = drawableName
                    }
                }
            }
            Log.i(TAG, "Cached ${packagesDrawables.size} icons")
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e(TAG, "Error parsing appfilter.xml $e")
        }
    }

    private fun getDefaultAppDrawable(
        activityInfo: LauncherActivityInfo,
        userHandle: UserHandle
    ): Drawable = activityInfo.getIcon(0)

    fun isClock(componentName: String): Boolean = packagesDrawables[componentName] == "clock"

    fun isCalendar(componentName: String): Boolean = packagesDrawables[componentName] == "calendar"

    /**
     * Get or generate icon for an app.
     */
    fun getDrawableIconForPackage(
        activityInfo: LauncherActivityInfo,
        userHandle: UserHandle
    ): Drawable? {
        val componentName = activityInfo.componentName
        val drawable = packagesDrawables[activityInfo.componentName.toString()]
        val iconPackResources = iconPackres
        if (drawable != null && iconPackResources != null) {
            val id = iconPackResources.getIdentifier(drawable, "drawable", iconsPackPackageName)
            if (id > 0) {
                try {
                    return getBadgedIcon(iconPackResources.getDrawable(id), activityInfo.user)
                } catch (e: Resources.NotFoundException) {
                    e.printStackTrace()
                }
            }
        }

        val key = userHandle.addUserSuffixToString(componentName.flattenToString(), '/')

        // Search first in cache.
        var systemIcon = cacheGetDrawable(key)
        if (systemIcon != null) {
            return systemIcon
        }

        val defaultIcon = getDefaultAppDrawable(activityInfo, userHandle)
        systemIcon = if (Utilities.ATLEAST_OREO && defaultIcon is AdaptiveIconDrawable) {
            AdaptiveIconDrawableCompat(defaultIcon.background, defaultIcon.foreground)
        } else {
            val adaptiveIcon = AdaptiveIconProvider().load(ctx, componentName.packageName)
            if (adaptiveIcon != null) {
                adaptiveIcon
            } else if (HomeIconRenderPolicy.wrapLegacyFallbackIcons) {
                AdaptiveIconGenerator(ctx, defaultIcon).getResult()
            } else {
                defaultIcon
            }
        }

        val badgedIcon = getBadgedIcon(systemIcon, activityInfo.user)
        cacheStoreDrawable(key, badgedIcon)
        return badgedIcon
    }

    fun resetIconDrawableForPackage(componentName: ComponentName?, userHandle: UserHandle) {
        val safeComponentName = componentName!!
        if (!packagesDrawables.containsKey(safeComponentName.toString())) {
            val launcherApps = ctx.getSystemService(Context.LAUNCHER_APPS_SERVICE) as LauncherApps
            for (launcherActivityInfo in launcherApps.getActivityList(
                safeComponentName.packageName,
                userHandle.getRealHandle()
            )) {
                if (launcherActivityInfo.componentName.flattenToString() == safeComponentName.flattenToString()) {
                    var icon = getDefaultAppDrawable(launcherActivityInfo, userHandle)
                    icon = if (Utilities.ATLEAST_OREO && icon is AdaptiveIconDrawable) {
                        AdaptiveIconDrawableCompat(icon.background, icon.foreground)
                    } else {
                        val adaptiveIcon = AdaptiveIconProvider().load(ctx, safeComponentName.packageName)
                        adaptiveIcon ?: if (HomeIconRenderPolicy.wrapLegacyFallbackIcons) {
                            AdaptiveIconGenerator(ctx, icon).getResult()
                        } else {
                            icon
                        }
                    }

                    val badgedIcon = getBadgedIcon(icon, launcherActivityInfo.user)
                    cacheStoreDrawable(
                        userHandle.addUserSuffixToString(safeComponentName.flattenToString(), '/'),
                        badgedIcon
                    )
                }
            }
        }
    }

    private fun getBadgedIcon(icon: Drawable, userHandle: android.os.UserHandle): Drawable =
        ctx.applicationContext.packageManager.getUserBadgedIcon(icon, userHandle)

    private fun isDrawableInCache(key: String): Boolean {
        val drawableFile = cacheGetFileName(key)
        return drawableFile.isFile
    }

    private fun cacheStoreDrawable(key: String, drawable: Drawable) {
        val bitmap = getBitmapFromDrawable(drawable)
        val drawableFile = cacheGetFileName(key)
        try {
            val fos = FileOutputStream(drawableFile)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos)
            fos.flush()
            fos.close()
        } catch (e: Exception) {
            Log.e(TAG, "Unable to store drawable in cache $e")
        }
    }

    private fun getBitmapFromDrawable(drawable: Drawable): Bitmap {
        val bitmap = Bitmap.createBitmap(
            drawable.intrinsicWidth,
            drawable.intrinsicHeight,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)
        return bitmap
    }

    private fun cacheGetDrawable(key: String): Drawable? {
        if (!isDrawableInCache(key)) {
            return null
        }

        return try {
            val fis = FileInputStream(cacheGetFileName(key))
            val drawable = BitmapDrawable(ctx.resources, BitmapFactory.decodeStream(fis))
            fis.close()
            drawable
        } catch (e: Exception) {
            Log.e(TAG, "Unable to get drawable from cache $e")
            null
        }
    }

    /**
     * Create path for icons cache like this:
     * {cacheDir}/icons/{icon_style_version}_{icons_pack_package_name}_{key_hash}.png
     */
    private fun cacheGetFileName(key: String): File =
        File(
            getIconsCacheDir().toString() +
                File.separator +
                HomeIconRenderPolicy.cacheStyleVersion +
                "_" +
                iconsPackPackageName +
                "_" +
                key.hashCode() +
                ".png"
        )

    /**
     * Returns icons cache directory.
     */
    private fun getIconsCacheDir(): File {
        val file = File(ctx.cacheDir.path + "/icons/")
        file.mkdir()
        return file
    }

    /**
     * Clear cache.
     */
    private fun cacheClear() {
        val cacheDir = getIconsCacheDir()

        if (!cacheDir.isDirectory) {
            return
        }

        cacheDir.listFiles()?.forEach { item ->
            if (!item.delete()) {
                Log.w(TAG, "Failed to delete file: ${item.absolutePath}")
            }
        }
    }

    fun convertIcon(icon: Drawable?): Drawable {
        val safeIcon = requireNotNull(icon)
        return if (HomeIconRenderPolicy.wrapLegacyFallbackIcons) {
            AdaptiveIconGenerator(ctx, safeIcon).getResult()
        } else {
            safeIcon
        }
    }

    val fullResDefaultActivityIcon: Drawable
        get() = getFullResIcon(
            Resources.getSystem(),
            if (Utilities.ATLEAST_OREO) android.R.drawable.sym_def_app_icon else android.R.mipmap.sym_def_app_icon
        )

    private fun getFullResIcon(resources: Resources, iconId: Int): Drawable {
        val drawable = try {
            resources.getDrawableForDensity(iconId, mIconDpi)
        } catch (_: Resources.NotFoundException) {
            null
        }

        return drawable ?: fullResDefaultActivityIcon
    }

    fun clearAll() {
        packagesDrawables.clear()
        cacheClear()
    }

    companion object {
        private const val TAG = "IconsHandler"
        /**
         * Returns a drawable suitable for the all apps view. If the package or the
         * resource do not exist, it returns null.
         */
        @JvmStatic
        fun createIconDrawable(iconRes: Intent.ShortcutIconResource, context: Context): Drawable? {
            val packageManager = context.packageManager
            try {
                val resources = packageManager.getResourcesForApplication(iconRes.packageName)
                val id = resources.getIdentifier(iconRes.resourceName, null, null)
                return resources.getDrawableForDensity(
                    id,
                    BlissLauncher.getApplication(context).deviceProfile.fillResIconDpi
                )
            } catch (_: Exception) {
                // Icon not found.
            }
            return null
        }

        /**
         * Returns a drawable which is of the appropriate size to be displayed as an icon.
         */
        @JvmStatic
        fun createIconDrawable(icon: Bitmap, context: Context): Drawable = BitmapDrawable(icon)
    }
}

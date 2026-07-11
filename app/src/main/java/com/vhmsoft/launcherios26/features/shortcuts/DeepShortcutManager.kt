package com.vhmsoft.launcherios26.features.shortcuts

import android.annotation.TargetApi
import android.content.ComponentName
import android.content.Context
import android.content.pm.LauncherApps
import android.content.pm.LauncherApps.ShortcutQuery
import android.content.pm.ShortcutInfo
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.UserHandle
import com.vhmsoft.launcherios26.core.Utilities
import timber.log.Timber

/**
 * Performs operations related to deep shortcuts, such as querying for them,
 * pinning them, etc.
 */
class DeepShortcutManager private constructor(context: Context) {

    private val mLauncherApps =
        context.getSystemService(Context.LAUNCHER_APPS_SERVICE) as LauncherApps
    private var mWasLastCallSuccess = false

    fun wasLastCallSuccess(): Boolean = mWasLastCallSuccess

    fun onShortcutsChanged(shortcuts: List<ShortcutInfoCompat>) {
        // mShortcutCache.removeShortcuts(shortcuts)
    }

    /**
     * Queries for the shortcuts with the package name and provided ids.
     *
     * This method is intended to get the full details for shortcuts when they are
     * added or updated, because we only get "key" fields in onShortcutsChanged().
     */
    fun queryForFullDetails(
        packageName: String,
        shortcutIds: List<String>,
        user: UserHandle
    ): List<ShortcutInfoCompat> =
        query(FLAG_GET_ALL, packageName, null, shortcutIds, user)

    /**
     * Gets all the manifest and dynamic shortcuts associated with the given package
     * and user, to be displayed in the shortcuts container on long press.
     */
    fun queryForShortcutsContainer(
        activity: ComponentName,
        ids: List<String>?,
        user: UserHandle
    ): List<ShortcutInfoCompat> =
        query(
            ShortcutQuery.FLAG_MATCH_MANIFEST or ShortcutQuery.FLAG_MATCH_DYNAMIC,
            activity.packageName,
            activity,
            ids,
            user
        )

    /**
     * Removes the given shortcut from the current list of pinned shortcuts. Runs
     * on a background thread.
     */
    @TargetApi(25)
    fun unpinShortcut(key: ShortcutKey) {
        if (Utilities.ATLEAST_NOUGAT_MR1) {
            val packageName = key.componentName.packageName
            val id = key.getId()
            val user = key.user
            val pinnedIds = extractIds(queryForPinnedShortcuts(packageName, user))
            pinnedIds.remove(id)
            try {
                mLauncherApps.pinShortcuts(packageName, pinnedIds, user)
                mWasLastCallSuccess = true
            } catch (e: SecurityException) {
                Timber.tag(TAG).w(e, "Failed to unpin shortcut")
                mWasLastCallSuccess = false
            } catch (e: IllegalStateException) {
                Timber.tag(TAG).w(e, "Failed to unpin shortcut")
                mWasLastCallSuccess = false
            }
        }
    }

    /**
     * Adds the given shortcut to the current list of pinned shortcuts. Runs on a
     * background thread.
     */
    @TargetApi(25)
    fun pinShortcut(key: ShortcutKey) {
        if (Utilities.ATLEAST_NOUGAT_MR1) {
            val packageName = key.componentName.packageName
            val id = key.getId()
            val user = key.user
            val pinnedIds = extractIds(queryForPinnedShortcuts(packageName, user))
            pinnedIds.add(id)
            try {
                mLauncherApps.pinShortcuts(packageName, pinnedIds, user)
                mWasLastCallSuccess = true
                Timber.tag(TAG).d("pinShortcut called: $key")
            } catch (e: SecurityException) {
                Timber.tag(TAG).w(e, "Failed to pin shortcut")
                mWasLastCallSuccess = false
            } catch (e: IllegalStateException) {
                Timber.tag(TAG).w(e, "Failed to pin shortcut")
                mWasLastCallSuccess = false
            }
        }
    }

    @TargetApi(25)
    fun startShortcut(
        packageName: String,
        id: String,
        sourceBounds: Rect?,
        startActivityOptions: Bundle?,
        user: UserHandle
    ) {
        if (Utilities.ATLEAST_NOUGAT_MR1) {
            try {
                mLauncherApps.startShortcut(packageName, id, sourceBounds, startActivityOptions, user)
                mWasLastCallSuccess = true
            } catch (e: SecurityException) {
                Timber.tag(TAG).w(e, "Failed to start shortcut")
                mWasLastCallSuccess = false
            } catch (e: IllegalStateException) {
                Timber.tag(TAG).w(e, "Failed to start shortcut")
                mWasLastCallSuccess = false
            }
        }
    }

    @TargetApi(25)
    fun getShortcutIconDrawable(shortcutInfo: ShortcutInfoCompat, density: Int): Drawable? {
        if (Utilities.ATLEAST_NOUGAT_MR1) {
            try {
                val icon = mLauncherApps.getShortcutIconDrawable(shortcutInfo.shortcutInfo, density)
                mWasLastCallSuccess = true
                return icon
            } catch (e: SecurityException) {
                Timber.tag(TAG).w(e, "Failed to get shortcut icon")
                mWasLastCallSuccess = false
            } catch (e: IllegalStateException) {
                Timber.tag(TAG).w(e, "Failed to get shortcut icon")
                mWasLastCallSuccess = false
            }
        }
        return null
    }

    /**
     * Returns the ids of pinned shortcuts associated with the given package and
     * user. If packageName is null, returns all pinned shortcuts regardless of package.
     */
    fun queryForPinnedShortcuts(packageName: String?, user: UserHandle): List<ShortcutInfoCompat> =
        query(ShortcutQuery.FLAG_MATCH_PINNED, packageName, null, null, user)

    fun queryForAllShortcuts(user: UserHandle): List<ShortcutInfoCompat> =
        query(FLAG_GET_ALL, null, null, null, user)

    private fun extractIds(shortcuts: List<ShortcutInfoCompat>): ArrayList<String> {
        val shortcutIds = ArrayList<String>(shortcuts.size)
        for (shortcut in shortcuts) {
            shortcutIds.add(shortcut.id)
        }
        return shortcutIds
    }

    /**
     * Query the system server for all the shortcuts matching the given parameters.
     * If packageName == null, query for all shortcuts with the passed flags.
     */
    @TargetApi(25)
    private fun query(
        flags: Int,
        packageName: String?,
        activity: ComponentName?,
        shortcutIds: List<String>?,
        user: UserHandle
    ): List<ShortcutInfoCompat> {
        if (Utilities.ATLEAST_NOUGAT_MR1) {
            val query = ShortcutQuery()
            query.setQueryFlags(flags)
            if (packageName != null) {
                query.setPackage(packageName)
                query.setActivity(activity)
                query.setShortcutIds(shortcutIds)
            }
            val shortcutInfos: List<ShortcutInfo>? = try {
                mLauncherApps.getShortcuts(query, user).also {
                    mWasLastCallSuccess = true
                }
            } catch (e: SecurityException) {
                Timber.tag(TAG).w(e, "Failed to query for shortcuts")
                mWasLastCallSuccess = false
                null
            } catch (e: IllegalStateException) {
                Timber.tag(TAG).w(e, "Failed to query for shortcuts")
                mWasLastCallSuccess = false
                null
            }
            if (shortcutInfos == null) {
                return emptyList()
            }
            val shortcutInfoCompats = ArrayList<ShortcutInfoCompat>(shortcutInfos.size)
            for (shortcutInfo in shortcutInfos) {
                shortcutInfoCompats.add(ShortcutInfoCompat(shortcutInfo))
            }
            return shortcutInfoCompats
        }
        return emptyList()
    }

    @TargetApi(25)
    fun hasHostPermission(): Boolean {
        if (Utilities.ATLEAST_NOUGAT_MR1) {
            try {
                return mLauncherApps.hasShortcutHostPermission()
            } catch (e: SecurityException) {
                Timber.tag(TAG).w(e, "Failed to make shortcut manager call")
            } catch (e: IllegalStateException) {
                Timber.tag(TAG).w(e, "Failed to make shortcut manager call")
            }
        }
        return false
    }

    companion object {
        private const val TAG = "DeepShortcutManager"

        private const val FLAG_GET_ALL =
            ShortcutQuery.FLAG_MATCH_DYNAMIC or
                ShortcutQuery.FLAG_MATCH_MANIFEST or
                ShortcutQuery.FLAG_MATCH_PINNED

        private var sInstance: DeepShortcutManager? = null
        private val sInstanceLock = Any()

        @JvmStatic
        fun getInstance(context: Context): DeepShortcutManager =
            synchronized(sInstanceLock) {
                if (sInstance == null) {
                    sInstance = DeepShortcutManager(context.applicationContext)
                }
                sInstance!!
            }
    }
}

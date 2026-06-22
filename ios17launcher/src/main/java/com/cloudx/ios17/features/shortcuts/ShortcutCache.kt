package com.cloudx.ios17.features.shortcuts

import android.annotation.TargetApi
import android.os.Build
import android.util.ArrayMap
import android.util.LruCache

@TargetApi(Build.VERSION_CODES.N)
class ShortcutCache {
    private val mCachedShortcuts = LruCache<ShortcutKey, ShortcutInfoCompat>(CACHE_SIZE)
    private val mPinnedShortcuts = ArrayMap<ShortcutKey, ShortcutInfoCompat>()

    fun removeShortcuts(shortcuts: List<ShortcutInfoCompat>) {
        for (shortcut in shortcuts) {
            val key = ShortcutKey.fromInfo(shortcut)
            mCachedShortcuts.remove(key)
            mPinnedShortcuts.remove(key)
        }
    }

    operator fun get(key: ShortcutKey): ShortcutInfoCompat? {
        if (mPinnedShortcuts.containsKey(key)) {
            return mPinnedShortcuts[key]
        }
        return mCachedShortcuts[key]
    }

    fun put(key: ShortcutKey, shortcut: ShortcutInfoCompat) {
        if (shortcut.isPinned) {
            mPinnedShortcuts[key] = shortcut
        } else {
            mCachedShortcuts.put(key, shortcut)
        }
    }

    companion object {
        private const val CACHE_SIZE = 30
    }
}

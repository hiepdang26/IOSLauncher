package com.vhmsoft.launcherios26.data.cache

import android.graphics.drawable.Drawable
import android.util.LruCache

class AppIconCache(maxEntries: Int = DEFAULT_MAX_ENTRIES) {
    private val cache = object : LruCache<String, Drawable>(maxEntries) {}

    fun get(key: String): Drawable? = cache.get(key)

    fun put(key: String, drawable: Drawable) {
        cache.put(key, drawable)
    }

    fun clear() {
        cache.evictAll()
    }

    private companion object {
        const val DEFAULT_MAX_ENTRIES = 160
    }
}

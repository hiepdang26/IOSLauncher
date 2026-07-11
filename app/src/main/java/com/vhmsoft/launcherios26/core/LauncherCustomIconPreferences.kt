package com.vhmsoft.launcherios26.core

import android.content.Context
import android.graphics.ImageDecoder
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import java.io.File

object LauncherCustomIconPreferences {

    fun customIconUri(context: Context, appKeys: List<String>): String? {
        val preferences = context.getSharedPreferences(LauncherCustomIconPolicy.PREF_NAME, Context.MODE_PRIVATE)
        return appKeys.firstNotNullOfOrNull { key ->
            preferences.getString(LauncherCustomIconPolicy.preferenceKey(key), null)
                ?.takeIf { it.isNotBlank() }
        }
    }

    fun saveCustomIconUri(context: Context, appKeys: List<String>, uri: String?) {
        val preferences = context.getSharedPreferences(LauncherCustomIconPolicy.PREF_NAME, Context.MODE_PRIVATE)
        val editor = preferences.edit()
        appKeys.forEach { key ->
            val preferenceKey = LauncherCustomIconPolicy.preferenceKey(key)
            if (uri == null) {
                editor.remove(preferenceKey)
            } else {
                editor.putString(preferenceKey, uri)
            }
        }
        editor.putLong(LauncherCustomIconPolicy.KEY_CUSTOM_ICON_VERSION, version(context) + 1L)
        editor.apply()
    }

    fun version(context: Context): Long {
        return context.getSharedPreferences(LauncherCustomIconPolicy.PREF_NAME, Context.MODE_PRIVATE)
            .getLong(LauncherCustomIconPolicy.KEY_CUSTOM_ICON_VERSION, 0L)
    }

    fun loadCustomIcon(context: Context, appKeys: List<String>): Drawable? {
        val rawUri = customIconUri(context, appKeys) ?: return null
        val uri = runCatching { Uri.parse(rawUri) }.getOrNull() ?: return null
        return runCatching {
            if (uri.scheme == "file") {
                val file = File(uri.path ?: return null)
                decodeFileDrawable(file)
            } else {
                decodeContentDrawable(context, uri)
            }
        }.getOrNull()
    }

    private fun decodeFileDrawable(file: File): Drawable? {
        if (!file.exists()) return null
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            ImageDecoder.decodeDrawable(ImageDecoder.createSource(file))
        } else {
            @Suppress("DEPRECATION")
            Drawable.createFromPath(file.absolutePath)
        }
    }

    private fun decodeContentDrawable(context: Context, uri: Uri): Drawable? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            ImageDecoder.decodeDrawable(ImageDecoder.createSource(context.contentResolver, uri))
        } else {
            @Suppress("DEPRECATION")
            context.contentResolver.openInputStream(uri)?.use { input ->
                Drawable.createFromStream(input, uri.toString())
            }
        }
    }
}

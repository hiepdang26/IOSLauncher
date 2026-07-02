package com.cloudx.ios17.core

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import java.io.File
import java.io.FileOutputStream
import kotlin.math.max

object LauncherCustomIconStore {
    private const val ICON_DIR = "custom_icons"

    fun saveBitmap(context: Context, appKeys: List<String>, bitmap: Bitmap): String {
        val safeKeys = appKeys.filter { it.isNotBlank() }.distinct()
        val primaryKey = safeKeys.firstOrNull() ?: error("Custom icon key is required")
        val directory = File(context.filesDir, ICON_DIR).apply { mkdirs() }
        val outputFile = File(directory, LauncherCustomIconPolicy.fileNameForKey(primaryKey))
        FileOutputStream(outputFile).use { output ->
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, output)
        }
        val uri = Uri.fromFile(outputFile).toString()
        LauncherCustomIconPreferences.saveCustomIconUri(context, safeKeys, uri)
        return uri
    }

    fun saveDrawable(context: Context, appKeys: List<String>, drawable: Drawable, sizePx: Int): String {
        return saveBitmap(context, appKeys, drawable.toBitmap(sizePx.coerceAtLeast(1)))
    }

    fun reset(context: Context, appKeys: List<String>) {
        val previousUris = appKeys.mapNotNull { key ->
            LauncherCustomIconPreferences.customIconUri(context, listOf(key))
        }.distinct()
        LauncherCustomIconPreferences.saveCustomIconUri(context, appKeys, null)
        previousUris.forEach { uriString ->
            runCatching {
                val uri = Uri.parse(uriString)
                if (uri.scheme == "file") {
                    uri.path?.let { File(it).delete() }
                }
            }
        }
    }

    private fun Drawable.toBitmap(sizePx: Int): Bitmap {
        if (this is BitmapDrawable && bitmap != null) {
            return Bitmap.createScaledBitmap(bitmap, sizePx, sizePx, true)
        }

        val bitmap = Bitmap.createBitmap(sizePx, sizePx, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val previousBounds = Rect(bounds)
        val intrinsicWidth = intrinsicWidth.takeIf { it > 0 } ?: sizePx
        val intrinsicHeight = intrinsicHeight.takeIf { it > 0 } ?: sizePx
        val scale = sizePx.toFloat() / max(intrinsicWidth, intrinsicHeight).toFloat()
        val drawWidth = (intrinsicWidth * scale).toInt()
        val drawHeight = (intrinsicHeight * scale).toInt()
        val left = (sizePx - drawWidth) / 2
        val top = (sizePx - drawHeight) / 2
        setBounds(left, top, left + drawWidth, top + drawHeight)
        draw(canvas)
        bounds = previousBounds
        return bitmap
    }
}

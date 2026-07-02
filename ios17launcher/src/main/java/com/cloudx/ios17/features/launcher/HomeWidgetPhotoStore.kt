package com.cloudx.ios17.features.launcher

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import java.io.File
import java.io.FileOutputStream

object HomeWidgetPhotoStore {
    private const val PHOTO_DIR = "home_widget_photos"

    fun saveBitmap(context: Context, widgetId: String, bitmap: Bitmap): String {
        val outputFile = photoFile(context, widgetId)
        outputFile.parentFile?.mkdirs()
        FileOutputStream(outputFile).use { output ->
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, output)
        }
        return outputFile.absolutePath
    }

    fun loadDrawable(context: Context, widgetId: String): Drawable? {
        val file = photoFile(context, widgetId)
        if (!file.exists()) {
            return null
        }
        val bitmap = BitmapFactory.decodeFile(file.absolutePath) ?: return null
        return BitmapDrawable(context.resources, bitmap)
    }

    private fun photoFile(context: Context, widgetId: String): File {
        return File(File(context.filesDir, PHOTO_DIR), HomeWidgetPhotoPolicy.fileNameForWidgetId(widgetId))
    }
}

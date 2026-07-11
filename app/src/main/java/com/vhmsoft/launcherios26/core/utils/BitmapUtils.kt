package com.vhmsoft.launcherios26.core.utils

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode

object BitmapUtils {
    @JvmStatic
    fun getCroppedBitmap(src: Bitmap, path: Path): Bitmap {
        val output = Bitmap.createBitmap(src.width, src.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(output)

        val paint = Paint().apply {
            isDither = true
            isAntiAlias = true
            isFilterBitmap = true
            color = 0xFF000000.toInt()
        }

        canvas.drawPath(path, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        canvas.drawBitmap(src, 0f, 0f, paint)
        return output
    }
}

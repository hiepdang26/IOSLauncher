package com.cloudx.ios17.features.notification

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import com.cloudx.ios17.R

class DotRenderer(private val mContext: Context, iconSizePx: Int) {
    private val mSize: Int = (SIZE_PERCENTAGE * iconSizePx).toInt()
    private val mPaint = Paint(
        Paint.ANTI_ALIAS_FLAG or Paint.DITHER_FLAG or Paint.FILTER_BITMAP_FLAG
    )

    fun drawDot(canvas: Canvas, iconBounds: Rect) {
        val bitmap = BitmapFactory.decodeResource(mContext.resources, R.drawable.notification_icon_72)
        val scaledBitmap = Bitmap.createScaledBitmap(bitmap, mSize, mSize, true)
        canvas.drawBitmap(
            scaledBitmap,
            (iconBounds.left - scaledBitmap.width / 2).toFloat(),
            (iconBounds.top - scaledBitmap.height / 2).toFloat(),
            mPaint
        )
    }

    companion object {
        private const val SIZE_PERCENTAGE = 0.3375f
    }
}

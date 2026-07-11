package com.vhmsoft.launcherios26.features.launcher

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Point
import android.view.View

internal object TodayWidgetDragShadowPolicy {
    data class Metrics(
        val width: Int,
        val height: Int,
        val touchX: Int,
        val touchY: Int
    )

    fun invisibleMetrics(): Metrics = Metrics(
        width = 1,
        height = 1,
        touchX = 0,
        touchY = 0
    )

    fun bitmapMetrics(width: Int, height: Int): Metrics = Metrics(
        width = width,
        height = height,
        touchX = width / 2,
        touchY = height / 2
    )
}

internal class InvisibleTodayWidgetDragShadowBuilder(view: View) : View.DragShadowBuilder(view) {
    override fun onProvideShadowMetrics(size: Point, touch: Point) {
        val metrics = TodayWidgetDragShadowPolicy.invisibleMetrics()
        size.set(metrics.width, metrics.height)
        touch.set(metrics.touchX, metrics.touchY)
    }

    override fun onDrawShadow(canvas: Canvas) = Unit
}

internal class BitmapTodayWidgetDragShadowBuilder(
    view: View,
    private val bitmap: Bitmap
) : View.DragShadowBuilder(view) {

    override fun onProvideShadowMetrics(size: Point, touch: Point) {
        val metrics = TodayWidgetDragShadowPolicy.bitmapMetrics(bitmap.width, bitmap.height)
        size.set(metrics.width, metrics.height)
        touch.set(metrics.touchX, metrics.touchY)
    }

    override fun onDrawShadow(canvas: Canvas) {
        canvas.drawBitmap(bitmap, 0f, 0f, null)
    }
}

package com.cloudx.ios17.features.launcher

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
}

internal class InvisibleTodayWidgetDragShadowBuilder(view: View) : View.DragShadowBuilder(view) {
    override fun onProvideShadowMetrics(size: Point, touch: Point) {
        val metrics = TodayWidgetDragShadowPolicy.invisibleMetrics()
        size.set(metrics.width, metrics.height)
        touch.set(metrics.touchX, metrics.touchY)
    }

    override fun onDrawShadow(canvas: Canvas) = Unit
}

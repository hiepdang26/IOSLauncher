package com.cloudx.ios17.core.customviews

import android.graphics.Canvas
import android.graphics.Point
import android.view.View
import timber.log.Timber

class BlissDragShadowBuilder(view: View, x: Float, y: Float) : View.DragShadowBuilder(view) {
    private val mX = x.toInt()
    private val mY = y.toInt()

    @JvmField
    val yOffset: Float

    @JvmField
    val xOffset: Float

    private lateinit var mScaleFactor: Point

    init {
        Timber.tag(TAG).i("Touchpoint: $mX $mY")
        xOffset = mX - view.width / 2f
        yOffset = mY - view.height / 2f
        Timber.tag(TAG).i("Offset: $xOffset $yOffset")
    }

    override fun onProvideShadowMetrics(size: Point, touch: Point) {
        val width = view.width
        val height = view.height
        size.set(width, height)
        mScaleFactor = size
        touch.set(mX, mY)
    }

    override fun onDrawShadow(canvas: Canvas) {
        canvas.save()
        canvas.scale(
            mScaleFactor.x / view.width.toFloat(),
            mScaleFactor.y / view.height.toFloat()
        )
        view.draw(canvas)
        canvas.restore()
    }

    companion object {
        private const val TAG = "BlissDragShadowBuilder"
    }
}

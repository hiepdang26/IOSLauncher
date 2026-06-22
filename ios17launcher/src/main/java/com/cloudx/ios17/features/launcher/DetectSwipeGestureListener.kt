package com.cloudx.ios17.features.launcher

import android.view.GestureDetector
import android.view.MotionEvent
import kotlin.math.abs

class DetectSwipeGestureListener : GestureDetector.SimpleOnGestureListener() {
    private var mOnSwipeDownListener: OnSwipeDownListener? = null

    fun setListener(listener: OnSwipeDownListener) {
        mOnSwipeDownListener = listener
    }

    override fun onDown(e: MotionEvent): Boolean = true

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        if (e1 == null) {
            return false
        }

        val deltaY = e1.y - e2.y
        val deltaYAbs = abs(deltaY)
        if (deltaYAbs >= MIN_SWIPE_DISTANCE_Y && deltaYAbs <= MAX_SWIPE_DISTANCE_Y) {
            if (deltaY < 0) {
                mOnSwipeDownListener?.onSwipeFinish()
                return true
            }
        }
        return false
    }

    override fun onSingleTapConfirmed(e: MotionEvent): Boolean = false

    override fun onDoubleTap(e: MotionEvent): Boolean = false

    companion object {
        private const val MIN_SWIPE_DISTANCE_Y = 100
        private const val MAX_SWIPE_DISTANCE_Y = 1000
    }
}

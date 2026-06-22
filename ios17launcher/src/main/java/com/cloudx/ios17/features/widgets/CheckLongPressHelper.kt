package com.cloudx.ios17.features.widgets

import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import com.cloudx.ios17.core.Utilities

/**
 * Utility class to handle tripper long press on a view with custom timeout and stylus event.
 */
class CheckLongPressHelper @JvmOverloads constructor(
    private val mView: View,
    private val mListener: View.OnLongClickListener? = null
) {

    private val mSlop = ViewConfiguration.get(mView.context).scaledTouchSlop.toFloat()
    private var mLongPressTimeoutFactor = DEFAULT_LONG_PRESS_TIMEOUT_FACTOR
    private var mHasPerformedLongPress = false
    private var mPendingCheckForLongPress: Runnable? = null

    /**
     * Handles the touch event on a view.
     *
     * @see View.onTouchEvent
     */
    fun onTouchEvent(ev: MotionEvent) {
        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                cancelLongPress()

                postCheckForLongPress()
                if (isStylusButtonPressed(ev)) {
                    triggerLongPress()
                }
            }

            MotionEvent.ACTION_CANCEL,
            MotionEvent.ACTION_UP -> cancelLongPress()

            MotionEvent.ACTION_MOVE ->
                if (!Utilities.pointInView(mView, ev.x, ev.y, mSlop)) {
                    cancelLongPress()
                } else if (mPendingCheckForLongPress != null && isStylusButtonPressed(ev)) {
                    triggerLongPress()
                }
        }
    }

    /** Overrides the default long press timeout. */
    fun setLongPressTimeoutFactor(longPressTimeoutFactor: Float) {
        mLongPressTimeoutFactor = longPressTimeoutFactor
    }

    private fun postCheckForLongPress() {
        mHasPerformedLongPress = false

        if (mPendingCheckForLongPress == null) {
            mPendingCheckForLongPress = Runnable { triggerLongPress() }
        }
        mView.postDelayed(
            mPendingCheckForLongPress,
            (ViewConfiguration.getLongPressTimeout() * mLongPressTimeoutFactor).toLong()
        )
    }

    /** Cancels any pending long press. */
    fun cancelLongPress() {
        mHasPerformedLongPress = false
        clearCallbacks()
    }

    /**
     * Returns true if long press has been performed in the current touch gesture.
     */
    fun hasPerformedLongPress(): Boolean = mHasPerformedLongPress

    private fun triggerLongPress() {
        if (
            mView.parent != null &&
            mView.hasWindowFocus() &&
            (!mView.isPressed || mListener != null) &&
            !mHasPerformedLongPress
        ) {
            val handled = mListener?.onLongClick(mView) ?: mView.performLongClick()
            if (handled) {
                mView.isPressed = false
                mHasPerformedLongPress = true
            }
            clearCallbacks()
        }
    }

    private fun clearCallbacks() {
        val pendingCheckForLongPress = mPendingCheckForLongPress
        if (pendingCheckForLongPress != null) {
            mView.removeCallbacks(pendingCheckForLongPress)
            mPendingCheckForLongPress = null
        }
    }

    companion object {
        const val DEFAULT_LONG_PRESS_TIMEOUT_FACTOR = 0.75f

        private fun isStylusButtonPressed(event: MotionEvent): Boolean {
            return event.getToolType(0) == MotionEvent.TOOL_TYPE_STYLUS &&
                event.isButtonPressed(MotionEvent.BUTTON_SECONDARY)
        }
    }
}

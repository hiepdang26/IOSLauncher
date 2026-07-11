package com.vhmsoft.launcherios26.core.customviews

import android.appwidget.AppWidgetHostView
import android.content.Context
import android.graphics.Rect
import android.widget.FrameLayout
import android.widget.ImageView
import com.vhmsoft.launcherios26.R

class AppWidgetResizeFrame(
    private val mContext: Context,
    private val mRoundedWidgetView: RoundedWidgetView
) : FrameLayout(mContext) {

    private var mTopHandle: ImageView? = null
    private var mBottomHandle: ImageView? = null

    private var mTopBorderActive = false
    private var mBottomBorderActive = false
    private var mWidgetPaddingTop = 0
    private var mWidgetPaddingBottom = 0

    private var mBaselineWidth = 0
    private var mBaselineHeight = 0
    private var mBaselineX = 0
    private var mBaselineY = 0
    private var mResizeMode = 0

    private var mRunningHInc = 0
    private var mRunningVInc = 0
    private var mMinHeight = 0
    private var mDeltaX = 0
    private var mDeltaY = 0
    private var mDeltaXAddOn = 0
    private var mDeltaYAddOn = 0

    private var mBackgroundPadding = 0
    private var mTouchTargetWidth = 0

    private var mTopTouchRegionAdjustment = 0
    private var mBottomTouchRegionAdjustment = 0

    private val mDirectionVector = IntArray(2)
    private val mLastDirectionVector = IntArray(2)

    private val snapDuration = SNAP_DURATION
    private val backgroundPadding = BACKGROUND_PADDING
    private val dimmedHandleAlpha = DIMMED_HANDLE_ALPHA
    private val resizeThreshold = RESIZE_THRESHOLD

    init {
        val info = mRoundedWidgetView.appWidgetInfo
        val padding = AppWidgetHostView.getDefaultPaddingForWidget(mContext, info.provider, null)
        mMinHeight = info.minHeight + padding.top + padding.bottom

        setBackgroundResource(R.drawable.widget_resize_frame)
        setPadding(0, 0, 0, 0)
    }

    companion object {
        private val mTmpRect = Rect()

        const val TOP = 1
        const val BOTTOM = 3

        private const val SNAP_DURATION = 150
        private const val BACKGROUND_PADDING = 24
        private const val DIMMED_HANDLE_ALPHA = 0f
        private const val RESIZE_THRESHOLD = 0.66f

        private const val TAG = "AppWidgetResizeFrame"
    }
}

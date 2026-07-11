package com.vhmsoft.launcherios26.core.customviews

import android.appwidget.AppWidgetHostView
import android.appwidget.AppWidgetProviderInfo
import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.Rect
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import com.vhmsoft.launcherios26.R
import com.vhmsoft.launcherios26.core.blur.BlurViewDelegate
import com.vhmsoft.launcherios26.core.blur.BlurWallpaperProvider
import com.vhmsoft.launcherios26.features.widgets.CheckLongPressHelper

open class RoundedWidgetView(
    private val mContext: Context,
    blurBackground: Boolean
) : AppWidgetHostView(mContext) {

    private val stencilPath = Path()
    private var cornerRadius = 0f
    private val mLongPressHelper: CheckLongPressHelper
    private var resizeBorder: ImageView? = null
    private var mChildrenFocused = false
    private var activated = false
    private var mBlurDelegate: BlurViewDelegate? = null

    init {
        cornerRadius = mContext.resources.getDimensionPixelSize(R.dimen.corner_radius).toFloat()
        mLongPressHelper = CheckLongPressHelper(this)
        if (blurBackground) {
            mBlurDelegate = BlurViewDelegate(this, BlurWallpaperProvider.blurConfigWidget, null)
            mBlurDelegate?.blurCornerRadius = cornerRadius
            setWillNotDraw(false)
            outlineProvider = mBlurDelegate?.outlineProvider
            clipToOutline = true
        }
    }

    override fun setAppWidget(appWidgetId: Int, info: AppWidgetProviderInfo?) {
        super.setAppWidget(appWidgetId, info)
        setPadding(0, 0, 0, 0)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        stencilPath.reset()
        stencilPath.addRoundRect(0f, 0f, w.toFloat(), h.toFloat(), cornerRadius, cornerRadius, Path.Direction.CW)
        stencilPath.close()
    }

    override fun dispatchDraw(canvas: Canvas) {
        val save = canvas.save()
        canvas.clipPath(stencilPath)
        super.dispatchDraw(canvas)
        canvas.restoreToCount(save)
    }

    override fun onDraw(canvas: Canvas) {
        mBlurDelegate?.draw(canvas)
        super.onDraw(canvas)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        mLongPressHelper.onTouchEvent(ev)
        return mLongPressHelper.hasPerformedLongPress()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        mLongPressHelper.onTouchEvent(event)
        return true
    }

    override fun cancelLongPress() {
        super.cancelLongPress()
        mLongPressHelper.cancelLongPress()
    }

    override fun getDescendantFocusability(): Int {
        return if (mChildrenFocused) {
            ViewGroup.FOCUS_BEFORE_DESCENDANTS
        } else {
            ViewGroup.FOCUS_BLOCK_DESCENDANTS
        }
    }

    override fun onFocusChanged(gainFocus: Boolean, direction: Int, previouslyFocusedRect: Rect?) {
        if (gainFocus) {
            mChildrenFocused = false
            dispatchChildFocus(false)
        }
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect)
    }

    override fun requestChildFocus(child: View, focused: View?) {
        super.requestChildFocus(child, focused)
        dispatchChildFocus(mChildrenFocused && focused != null)
        if (focused != null) {
            focused.isFocusableInTouchMode = false
        }
    }

    override fun dispatchUnhandledMove(focused: View, direction: Int): Boolean = mChildrenFocused

    private fun dispatchChildFocus(childIsFocused: Boolean) {
        isSelected = childIsFocused
    }

    fun addBorder() {
        if (resizeBorder != null) {
            removeBorder()
        }
        resizeBorder = ImageView(mContext)
        resizeBorder?.setImageResource(R.drawable.widget_resize_frame)
        val layoutParams = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        resizeBorder?.layoutParams = layoutParams
        addView(resizeBorder)
        activated = true
    }

    fun removeBorder() {
        val border = resizeBorder
        if (border != null) {
            removeView(border)
            resizeBorder = null
            activated = false
        }
    }

    fun isWidgetActivated(): Boolean = activated

    companion object {
        private const val TAG = "RoundedWidgetView"
    }
}

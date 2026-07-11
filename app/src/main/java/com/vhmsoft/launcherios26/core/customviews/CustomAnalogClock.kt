package com.vhmsoft.launcherios26.core.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.os.Handler
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.vhmsoft.launcherios26.BlissLauncher
import com.vhmsoft.launcherios26.R
import java.util.Calendar
import kotlin.math.min

/** Created by falcon on 8/3/18. */
class CustomAnalogClock : View {

    private lateinit var mCalendar: Calendar
    private lateinit var mFace: Drawable
    private var mDialWidth = 0
    private var sizeScale = 1f
    private var mDialHeight = 0
    private var mBottom = 0
    private var mTop = 0
    private var mLeft = 0
    private var mRight = 0
    private var mSizeChanged = false
    private lateinit var mHandsOverlay: HandsOverlay
    private var autoUpdate = false
    private lateinit var mContext: Context

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        handleAttrs(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        handleAttrs(context, attrs)
    }

    constructor(context: Context) : super(context) {
        init(context)
    }

    private fun handleAttrs(context: Context, attrs: AttributeSet?) {
        init(context)
    }

    fun init(context: Context) {
        init(context, R.drawable.clock, R.drawable.hours, R.drawable.minutes, R.drawable.seconds, 0, false, false)
    }

    fun setScale(scale: Float) {
        if (scale <= 0) {
            throw IllegalArgumentException("Scale must be bigger than 0")
        }
        sizeScale = scale
        mHandsOverlay.withScale(sizeScale)
        invalidate()
    }

    fun setFace(drawableRes: Int) {
        setFace(resources.getDrawable(drawableRes))
    }

    fun init(
        context: Context,
        watchFace: Int,
        hourHand: Int,
        minuteHand: Int,
        secHand: Int,
        alpha: Int,
        is24: Boolean,
        hourOnTop: Boolean
    ) {
        mContext = context
        CustomAnalogClock.is24 = is24

        CustomAnalogClock.hourOnTop = hourOnTop
        setFace(watchFace)
        val hourDrawable = requireNotNull(ContextCompat.getDrawable(context, hourHand))
        if (alpha > 0) {
            hourDrawable.alpha = alpha
        }

        val minuteDrawable = ContextCompat.getDrawable(context, minuteHand)
        val secondDrawable = ContextCompat.getDrawable(context, secHand)

        mCalendar = Calendar.getInstance()

        mHandsOverlay = HandsOverlay(hourDrawable, minuteDrawable, secondDrawable).withScale(sizeScale)
        mHandsOverlay.setShowSeconds(true)
        setScale(BlissLauncher.getApplication(mContext).deviceProfile.iconSizePx.toFloat() / mDialWidth)
    }

    fun setFace(face: Drawable) {
        mFace = face
        mDialHeight = mFace.intrinsicHeight
        mDialWidth = mFace.intrinsicWidth
        mSizeChanged = true
        invalidate()
    }

    fun setTime(time: Long) {
        mCalendar.timeInMillis = time
        invalidate()
    }

    fun setTime(calendar: Calendar) {
        mCalendar = calendar
        invalidate()
        if (autoUpdate) {
            Handler().postDelayed({ setTime(Calendar.getInstance()) }, 1000)
        }
    }

    fun setAutoUpdate(autoUpdate: Boolean) {
        this.autoUpdate = autoUpdate
        setTime(Calendar.getInstance())
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mSizeChanged = true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val sizeChanged = mSizeChanged
        if (sizeChanged) {
            mSizeChanged = false
        }

        val availW = mRight - mLeft
        val availH = mBottom - mTop

        val cX = availW / 2
        val cY = availH / 2

        val w = (mDialWidth * sizeScale).toInt()
        val h = (mDialHeight * sizeScale).toInt()

        var scaled = false

        if (availW < w || availH < h) {
            scaled = true
            val scale = min(availW.toFloat() / w.toFloat(), availH.toFloat() / h.toFloat())
            canvas.save()
            canvas.scale(scale, scale, cX.toFloat(), cY.toFloat())
        }

        if (sizeChanged) {
            mFace.setBounds(cX - w / 2, cY - h / 2 - 1, cX + w / 2, cY + h / 2 + 1)
        }

        mFace.draw(canvas)
        mHandsOverlay.onDraw(canvas, cX.toFloat(), cY.toFloat(), w, h, mCalendar, sizeChanged)

        if (scaled) {
            canvas.restore()
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        var hScale = 1.0f
        var vScale = 1.0f

        if (widthMode != MeasureSpec.UNSPECIFIED && widthSize < mDialWidth) {
            hScale = widthSize.toFloat() / mDialWidth.toFloat()
        }

        if (heightMode != MeasureSpec.UNSPECIFIED && heightSize < mDialHeight) {
            vScale = heightSize.toFloat() / mDialHeight.toFloat()
        }

        val scale = min(hScale, vScale)

        setMeasuredDimension(
            resolveSizeAndState((mDialWidth * scale).toInt(), widthMeasureSpec, 0),
            resolveSizeAndState((mDialHeight * scale).toInt(), heightMeasureSpec, 0)
        )
    }

    override fun getSuggestedMinimumHeight(): Int = (mDialHeight * sizeScale).toInt()

    override fun getSuggestedMinimumWidth(): Int = (mDialWidth * sizeScale).toInt()

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        mRight = right
        mLeft = left
        mTop = top
        mBottom = bottom
    }

    companion object {
        @JvmField
        var is24: Boolean = false

        @JvmField
        var hourOnTop: Boolean = false

        private const val TAG = "CustomAnalogClock"
    }
}

package com.cloudx.ios17.core.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import java.util.Calendar
import kotlin.math.roundToInt

/** Created by falcon on 8/3/18. */
class HandsOverlay : DialOverlay {

    private val mHour: Drawable?
    private val mMinute: Drawable?
    private val mSecond: Drawable?
    private val mUseLargeFace: Boolean
    private var mHourRot = 0f
    private var mMinRot = 0f
    private var mSecRot = 0f
    private var mShowSeconds = false
    private var scale = 0f

    constructor(context: Context, useLargeFace: Boolean) {
        context.resources
        mUseLargeFace = useLargeFace
        mHour = null
        mMinute = null
        mSecond = null
    }

    constructor(hourHand: Drawable?, minuteHand: Drawable?, secHand: Drawable?) {
        mUseLargeFace = false
        mHour = hourHand
        mMinute = minuteHand
        mSecond = secHand
    }

    fun withScale(scale: Float): HandsOverlay {
        this.scale = scale
        return this
    }

    constructor(context: Context, hourHandRes: Int, minuteHandRes: Int) {
        val resources = context.resources
        mUseLargeFace = false
        mHour = resources.getDrawable(hourHandRes)
        mMinute = resources.getDrawable(minuteHandRes)
        mSecond = resources.getDrawable(minuteHandRes)
    }

    override fun onDraw(
        canvas: Canvas,
        cX: Float,
        cY: Float,
        w: Int,
        h: Int,
        calendar: Calendar,
        sizeChanged: Boolean
    ) {
        updateHands(calendar)

        canvas.save()
        if (!CustomAnalogClock.hourOnTop) {
            drawHours(canvas, cX, cY, w, h, sizeChanged)
        } else {
            drawMinutes(canvas, cX, cY, w, h, sizeChanged)
        }
        canvas.restore()

        canvas.save()
        if (!CustomAnalogClock.hourOnTop) {
            drawMinutes(canvas, cX, cY, w, h, sizeChanged)
        } else {
            drawHours(canvas, cX, cY, w, h, sizeChanged)
        }
        canvas.restore()

        canvas.save()
        drawSec(canvas, cX, cY, w, h, sizeChanged)
        canvas.restore()
    }

    private fun drawMinutes(canvas: Canvas, cX: Float, cY: Float, w: Int, h: Int, sizeChanged: Boolean) {
        var width = w
        var height = h
        val minute = mMinute!!
        canvas.rotate(mMinRot, cX, cY)

        if (sizeChanged) {
            width = (minute.intrinsicWidth * scale).toInt()
            height = (minute.intrinsicHeight * scale).toInt()
            minute.setBounds(
                (cX - width / 2f).roundToInt(),
                (cY - height / 2f).roundToInt(),
                (cX + width / 2f).roundToInt(),
                (cY + height / 2f).roundToInt()
            )
        }
        minute.draw(canvas)
    }

    private fun drawHours(canvas: Canvas, cX: Float, cY: Float, w: Int, h: Int, sizeChanged: Boolean) {
        var width = w
        var height = h
        val hour = mHour!!
        canvas.rotate(mHourRot, cX, cY)

        if (sizeChanged) {
            width = (hour.intrinsicWidth * scale).toInt()
            height = (hour.intrinsicHeight * scale).toInt()
            hour.setBounds(
                (cX - width / 2f).roundToInt(),
                (cY - height / 2f).roundToInt(),
                (cX + width / 2f).roundToInt(),
                (cY + height / 2f).roundToInt()
            )
        }
        hour.draw(canvas)
    }

    private fun drawSec(canvas: Canvas, cX: Float, cY: Float, w: Int, h: Int, sizeChanged: Boolean) {
        var width = w
        var height = h
        val second = mSecond!!
        canvas.rotate(mSecRot, cX, cY)

        if (sizeChanged) {
            width = (second.intrinsicWidth * scale).toInt()
            height = (second.intrinsicHeight * scale).toInt()
            second.setBounds(
                (cX - width / 2f).roundToInt(),
                (cY - height / 2f).roundToInt(),
                (cX + width / 2f).roundToInt(),
                (cY + height / 2f).roundToInt()
            )
        }
        second.draw(canvas)
    }

    fun setShowSeconds(showSeconds: Boolean) {
        mShowSeconds = showSeconds
    }

    private fun updateHands(calendar: Calendar) {
        val h = calendar[Calendar.HOUR_OF_DAY]
        val m = calendar[Calendar.MINUTE]
        val s = calendar[Calendar.SECOND]

        mHourRot = getHourHandAngle(h, m)
        mMinRot = (m / 60.0f) * 360 + if (mShowSeconds) (s / 60.0f) * 360 / 60.0f else 0f
        mSecRot = s * 6.0f
    }

    companion object {
        @JvmStatic
        fun getHourHandAngle(h: Int, m: Int): Float {
            return if (CustomAnalogClock.is24) {
                ((12 + h) / 24.0f * 360) % 360 + (m / 60.0f) * 360 / 24.0f
            } else {
                ((12 + h) / 12.0f * 360) % 360 + (m / 60.0f) * 360 / 12.0f
            }
        }
    }
}

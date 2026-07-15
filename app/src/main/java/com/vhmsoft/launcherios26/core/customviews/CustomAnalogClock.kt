package com.vhmsoft.launcherios26.core.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.vhmsoft.launcherios26.BlissLauncher
import com.vhmsoft.launcherios26.R
import java.util.Calendar
import java.util.TimeZone
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.roundToInt
import kotlin.math.sin

/** Created by falcon on 8/3/18. */
class CustomAnalogClock : View {

    private val calendar = Calendar.getInstance()
    private val iconBounds = RectF()
    private val platePaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val borderPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val tickPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val numberPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val handPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val centerPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val numberTypeface = Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD)
    private var dialWidth = DEFAULT_DIAL_SIZE
    private var dialHeight = DEFAULT_DIAL_SIZE
    private var sizeScale = 1f
    private var autoUpdate = false
    private var explicitTimeMillis = System.currentTimeMillis()
    private var tickerPosted = false

    private val tickRunnable = object : Runnable {
        override fun run() {
            tickerPosted = false
            if (shouldAnimate()) {
                invalidate()
                startTicker()
            }
        }
    }

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
        requestLayout()
        invalidate()
    }

    fun setFace(drawableRes: Int) {
        ContextCompat.getDrawable(context, drawableRes)?.let(::setFace)
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
        CustomAnalogClock.is24 = is24
        CustomAnalogClock.hourOnTop = hourOnTop
        setFace(requireNotNull(ContextCompat.getDrawable(context, watchFace)))
        setScale(BlissLauncher.getApplication(context).deviceProfile.iconSizePx.toFloat() / dialWidth.coerceAtLeast(1))
    }

    fun setFace(face: Drawable) {
        dialWidth = face.intrinsicWidth.takeIf { it > 0 } ?: DEFAULT_DIAL_SIZE
        dialHeight = face.intrinsicHeight.takeIf { it > 0 } ?: DEFAULT_DIAL_SIZE
        requestLayout()
        invalidate()
    }

    fun setTime(time: Long) {
        explicitTimeMillis = time
        calendar.timeInMillis = time
        invalidate()
    }

    fun setTime(calendar: Calendar) {
        this.calendar.timeZone = calendar.timeZone
        setTime(calendar.timeInMillis)
    }

    fun setAutoUpdate(autoUpdate: Boolean) {
        this.autoUpdate = autoUpdate
        if (autoUpdate) {
            startTicker()
        } else {
            stopTicker()
        }
        invalidate()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        startTicker()
    }

    override fun onDetachedFromWindow() {
        stopTicker()
        super.onDetachedFromWindow()
    }

    override fun onVisibilityChanged(changedView: View, visibility: Int) {
        super.onVisibilityChanged(changedView, visibility)
        if (changedView == this && visibility == VISIBLE) {
            startTicker()
        } else if (changedView == this) {
            stopTicker()
        }
    }

    override fun onVisibilityAggregated(isVisible: Boolean) {
        super.onVisibilityAggregated(isVisible)
        if (isVisible) {
            startTicker()
        } else {
            stopTicker()
        }
    }

    override fun onWindowVisibilityChanged(visibility: Int) {
        super.onWindowVisibilityChanged(visibility)
        if (visibility == VISIBLE) {
            startTicker()
        } else {
            stopTicker()
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val availableW = width - paddingLeft - paddingRight
        val availableH = height - paddingTop - paddingBottom
        if (availableW <= 0 || availableH <= 0) return

        val desiredSize = min(dialWidth * sizeScale, dialHeight * sizeScale)
        val iconSize = min(min(availableW, availableH).toFloat(), desiredSize)
        val cX = paddingLeft + availableW / 2f
        val cY = paddingTop + availableH / 2f
        val halfSize = iconSize / 2f

        iconBounds.set(cX - halfSize, cY - halfSize, cX + halfSize, cY + halfSize)
        drawPlate(canvas, iconSize)
        drawTicks(canvas, cX, cY, iconSize)
        drawNumbers(canvas, cX, cY, iconSize)
        drawHands(canvas, cX, cY, iconSize, anglesForCurrentTime())
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val desiredWidth = (dialWidth * sizeScale).roundToInt().coerceAtLeast(1)
        val desiredHeight = (dialHeight * sizeScale).roundToInt().coerceAtLeast(1)
        setMeasuredDimension(
            resolveSizeAndState(desiredWidth, widthMeasureSpec, 0),
            resolveSizeAndState(desiredHeight, heightMeasureSpec, 0)
        )
    }

    override fun getSuggestedMinimumHeight(): Int = (dialHeight * sizeScale).roundToInt()

    override fun getSuggestedMinimumWidth(): Int = (dialWidth * sizeScale).roundToInt()

    private fun drawPlate(canvas: Canvas, iconSize: Float) {
        val cornerRadius = iconSize * ICON_CORNER_FRACTION
        platePaint.style = Paint.Style.FILL
        platePaint.color = Color.WHITE
        canvas.drawRoundRect(iconBounds, cornerRadius, cornerRadius, platePaint)

        borderPaint.style = Paint.Style.STROKE
        borderPaint.strokeWidth = (iconSize * BORDER_WIDTH_FRACTION).coerceAtLeast(1f)
        borderPaint.color = ICON_BORDER_COLOR
        canvas.drawRoundRect(iconBounds, cornerRadius, cornerRadius, borderPaint)
    }

    private fun drawTicks(canvas: Canvas, cX: Float, cY: Float, iconSize: Float) {
        val outerRadius = iconSize * TICK_OUTER_RADIUS_FRACTION
        for (tick in 0 until TICK_COUNT) {
            val isHourTick = tick % HOUR_TICK_INTERVAL == 0
            val angle = tick * FULL_CIRCLE_DEGREES / TICK_COUNT
            val innerRadius = outerRadius - if (isHourTick) {
                iconSize * HOUR_TICK_LENGTH_FRACTION
            } else {
                iconSize * MINUTE_TICK_LENGTH_FRACTION
            }
            tickPaint.style = Paint.Style.STROKE
            tickPaint.strokeCap = Paint.Cap.ROUND
            tickPaint.strokeWidth = if (isHourTick) {
                (iconSize * HOUR_TICK_WIDTH_FRACTION).coerceAtLeast(1.25f)
            } else {
                (iconSize * MINUTE_TICK_WIDTH_FRACTION).coerceAtLeast(1f)
            }
            tickPaint.color = if (isHourTick) HOUR_TICK_COLOR else MINUTE_TICK_COLOR
            drawRadialLine(canvas, cX, cY, innerRadius, outerRadius, angle, tickPaint)
        }
    }

    private fun drawNumbers(canvas: Canvas, cX: Float, cY: Float, iconSize: Float) {
        numberPaint.style = Paint.Style.FILL
        numberPaint.color = NUMBER_COLOR
        numberPaint.typeface = numberTypeface
        numberPaint.textAlign = Paint.Align.CENTER
        numberPaint.textSize = iconSize * NUMBER_TEXT_SIZE_FRACTION

        drawCenteredNumber(canvas, "12", cX, cY - iconSize * NUMBER_RADIUS_FRACTION)
        drawCenteredNumber(canvas, "3", cX + iconSize * NUMBER_RADIUS_FRACTION, cY)
        drawCenteredNumber(canvas, "6", cX, cY + iconSize * NUMBER_RADIUS_FRACTION)
        drawCenteredNumber(canvas, "9", cX - iconSize * NUMBER_RADIUS_FRACTION, cY)
    }

    private fun drawCenteredNumber(canvas: Canvas, text: String, x: Float, y: Float) {
        val textCenterOffset = (numberPaint.descent() + numberPaint.ascent()) / 2f
        canvas.drawText(text, x, y - textCenterOffset, numberPaint)
    }

    private fun drawHands(canvas: Canvas, cX: Float, cY: Float, iconSize: Float, angles: ClockHandAngles) {
        drawHand(
            canvas = canvas,
            cX = cX,
            cY = cY,
            angle = angles.hour,
            length = iconSize * HOUR_HAND_LENGTH_FRACTION,
            tailLength = iconSize * HOUR_HAND_TAIL_FRACTION,
            strokeWidth = iconSize * HOUR_HAND_WIDTH_FRACTION,
            color = HAND_COLOR
        )
        drawHand(
            canvas = canvas,
            cX = cX,
            cY = cY,
            angle = angles.minute,
            length = iconSize * MINUTE_HAND_LENGTH_FRACTION,
            tailLength = iconSize * MINUTE_HAND_TAIL_FRACTION,
            strokeWidth = iconSize * MINUTE_HAND_WIDTH_FRACTION,
            color = HAND_COLOR
        )
        drawHand(
            canvas = canvas,
            cX = cX,
            cY = cY,
            angle = angles.second,
            length = iconSize * SECOND_HAND_LENGTH_FRACTION,
            tailLength = iconSize * SECOND_HAND_TAIL_FRACTION,
            strokeWidth = iconSize * SECOND_HAND_WIDTH_FRACTION,
            color = SECOND_HAND_COLOR
        )

        centerPaint.style = Paint.Style.FILL
        centerPaint.color = SECOND_HAND_COLOR
        canvas.drawCircle(cX, cY, iconSize * CENTER_DOT_RADIUS_FRACTION, centerPaint)
    }

    private fun drawHand(
        canvas: Canvas,
        cX: Float,
        cY: Float,
        angle: Float,
        length: Float,
        tailLength: Float,
        strokeWidth: Float,
        color: Int
    ) {
        handPaint.style = Paint.Style.STROKE
        handPaint.strokeCap = Paint.Cap.ROUND
        handPaint.strokeWidth = strokeWidth.coerceAtLeast(1f)
        handPaint.color = color
        drawRadialLine(canvas, cX, cY, -tailLength, length, angle, handPaint)
    }

    private fun anglesForCurrentTime(): ClockHandAngles {
        val timeMillis = if (autoUpdate) System.currentTimeMillis() else explicitTimeMillis
        if (autoUpdate) {
            calendar.timeZone = TimeZone.getDefault()
        }
        calendar.timeInMillis = timeMillis
        return ClockHandAnglePolicy.fromTime(
            hourOfDay = calendar[Calendar.HOUR_OF_DAY],
            minute = calendar[Calendar.MINUTE],
            second = calendar[Calendar.SECOND],
            millisecond = calendar[Calendar.MILLISECOND],
            is24Hour = is24
        )
    }

    private fun drawRadialLine(
        canvas: Canvas,
        cX: Float,
        cY: Float,
        startRadius: Float,
        endRadius: Float,
        angle: Float,
        paint: Paint
    ) {
        val radians = Math.toRadians((angle - CLOCK_TOP_DEGREES).toDouble())
        val unitX = cos(radians).toFloat()
        val unitY = sin(radians).toFloat()
        canvas.drawLine(
            cX + unitX * startRadius,
            cY + unitY * startRadius,
            cX + unitX * endRadius,
            cY + unitY * endRadius,
            paint
        )
    }

    private fun shouldAnimate(): Boolean =
        ClockTickerPolicy.shouldAnimate(
            autoUpdate = autoUpdate,
            attachedToWindow = isAttachedToWindow,
            aggregatedVisible = isShown,
            windowVisible = windowVisibility == VISIBLE
        )

    private fun startTicker() {
        if (!shouldAnimate() || tickerPosted) return
        tickerPosted = true
        postOnAnimation(tickRunnable)
    }

    private fun stopTicker() {
        removeCallbacks(tickRunnable)
        tickerPosted = false
    }

    companion object {
        @JvmField
        var is24: Boolean = false

        @JvmField
        var hourOnTop: Boolean = false

        private const val DEFAULT_DIAL_SIZE = 1024
        private const val FULL_CIRCLE_DEGREES = 360f
        private const val CLOCK_TOP_DEGREES = 90f
        private const val TICK_COUNT = 60
        private const val HOUR_TICK_INTERVAL = 5
        private const val ICON_CORNER_FRACTION = 0.24f
        private const val BORDER_WIDTH_FRACTION = 0.006f
        private const val TICK_OUTER_RADIUS_FRACTION = 0.455f
        private const val HOUR_TICK_LENGTH_FRACTION = 0.098f
        private const val MINUTE_TICK_LENGTH_FRACTION = 0.066f
        private const val HOUR_TICK_WIDTH_FRACTION = 0.018f
        private const val MINUTE_TICK_WIDTH_FRACTION = 0.0085f
        private const val NUMBER_RADIUS_FRACTION = 0.302f
        private const val NUMBER_TEXT_SIZE_FRACTION = 0.165f
        private const val HOUR_HAND_LENGTH_FRACTION = 0.22f
        private const val HOUR_HAND_TAIL_FRACTION = 0.034f
        private const val HOUR_HAND_WIDTH_FRACTION = 0.035f
        private const val MINUTE_HAND_LENGTH_FRACTION = 0.323f
        private const val MINUTE_HAND_TAIL_FRACTION = 0.045f
        private const val MINUTE_HAND_WIDTH_FRACTION = 0.027f
        private const val SECOND_HAND_LENGTH_FRACTION = 0.365f
        private const val SECOND_HAND_TAIL_FRACTION = 0.088f
        private const val SECOND_HAND_WIDTH_FRACTION = 0.014f
        private const val CENTER_DOT_RADIUS_FRACTION = 0.028f
        private const val ICON_BORDER_COLOR = 0x18000000
        private const val HOUR_TICK_COLOR = 0xFF202124.toInt()
        private const val MINUTE_TICK_COLOR = 0xFF6D7076.toInt()
        private const val NUMBER_COLOR = 0xFF34363A.toInt()
        private const val HAND_COLOR = 0xFF1C1C1E.toInt()
        private const val SECOND_HAND_COLOR = 0xFFFF3B30.toInt()
    }
}

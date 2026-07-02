package com.cloudx.ios17.core.customviews

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.cloudx.ios17.core.DeviceProfile

class SquareImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {
    var iconContentScale = 1f
        set(value) {
            field = value
            invalidate()
        }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val size = minOf(measuredWidth, measuredHeight)
        setMeasuredDimension(size, size)
    }

    override fun onDraw(canvas: Canvas) {
        if (iconContentScale == 1f) {
            super.onDraw(canvas)
            return
        }

        val saveCount = canvas.save()
        canvas.clipPath(DeviceProfile.path)
        canvas.scale(iconContentScale, iconContentScale, width / 2f, height / 2f)
        super.onDraw(canvas)
        canvas.restoreToCount(saveCount)
    }
}

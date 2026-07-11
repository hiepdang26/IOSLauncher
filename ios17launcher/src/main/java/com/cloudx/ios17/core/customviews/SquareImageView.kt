package com.cloudx.ios17.core.customviews

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.cloudx.ios17.core.DeviceProfile
import com.cloudx.ios17.core.HomeIconRenderPolicy

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
        val saveCount = canvas.save()
        if (HomeIconRenderPolicy.shouldClipIconDrawable(iconContentScale)) {
            canvas.clipPath(DeviceProfile.path)
        }
        if (HomeIconRenderPolicy.shouldScaleIconDrawable(iconContentScale)) {
            canvas.scale(iconContentScale, iconContentScale, width / 2f, height / 2f)
        }
        super.onDraw(canvas)
        canvas.restoreToCount(saveCount)
    }
}

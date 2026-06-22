package com.cloudx.ios17.core.customviews

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.FrameLayout
import com.cloudx.ios17.core.DeviceProfile
import com.cloudx.ios17.core.blur.BlurViewDelegate
import com.cloudx.ios17.core.blur.BlurWallpaperProvider

class SquareFrameLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private var mBlurDelegate: BlurViewDelegate? = null

    init {
        setWillNotDraw(false)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val size = minOf(measuredWidth, measuredHeight)
        setMeasuredDimension(size, size)
    }

    fun enableBlur() {
        mBlurDelegate = BlurViewDelegate(this, BlurWallpaperProvider.blurConfigAppGroup, null)
        setWillNotDraw(false)
    }

    override fun onDraw(canvas: Canvas) {
        mBlurDelegate?.let { delegate ->
            val count = canvas.save()
            canvas.clipPath(DeviceProfile.path)
            delegate.draw(canvas)
            canvas.restoreToCount(count)
        }
        super.onDraw(canvas)
    }
}

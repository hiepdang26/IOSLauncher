package com.vhmsoft.launcherios26.core.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.vhmsoft.launcherios26.core.DeviceProfile
import com.vhmsoft.launcherios26.core.HomeIconRenderPolicy

class SquareImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {
    private val resizedMaskPath = Path()
    private val maskMatrix = Matrix()
    private val sourceMaskBounds = RectF()
    private val targetMaskBounds = RectF()

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
            canvas.clipPath(iconMaskPathForCurrentBounds())
        }
        if (HomeIconRenderPolicy.shouldScaleIconDrawable(iconContentScale)) {
            canvas.scale(iconContentScale, iconContentScale, width / 2f, height / 2f)
        }
        super.onDraw(canvas)
        canvas.restoreToCount(saveCount)
    }

    private fun iconMaskPathForCurrentBounds(): Path {
        val sourcePath = DeviceProfile.path
        sourcePath.computeBounds(sourceMaskBounds, true)
        if (!HomeIconRenderPolicy.shouldResizeClipMaskToViewBounds(
                viewWidth = width,
                viewHeight = height,
                maskWidth = sourceMaskBounds.width(),
                maskHeight = sourceMaskBounds.height()
            )
        ) {
            return sourcePath
        }

        resizedMaskPath.reset()
        resizedMaskPath.addPath(sourcePath)
        targetMaskBounds.set(0f, 0f, width.toFloat(), height.toFloat())
        maskMatrix.reset()
        maskMatrix.setRectToRect(sourceMaskBounds, targetMaskBounds, Matrix.ScaleToFit.FILL)
        resizedMaskPath.transform(maskMatrix)
        return resizedMaskPath
    }
}

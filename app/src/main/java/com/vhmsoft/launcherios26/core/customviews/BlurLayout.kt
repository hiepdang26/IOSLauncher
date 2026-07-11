package com.vhmsoft.launcherios26.core.customviews

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.FrameLayout
import com.vhmsoft.launcherios26.core.blur.BlurViewDelegate
import com.vhmsoft.launcherios26.core.blur.BlurWallpaperProvider

open class BlurLayout @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    FrameLayout(context, attrs) {

    private val delegate = BlurViewDelegate(this, BlurWallpaperProvider.blurConfigWidget, attrs)

    init {
        setWillNotDraw(false)
        clipToOutline = true

        outlineProvider = delegate.outlineProvider
    }

    var blurCornerRadius: Float
        get() = delegate.blurCornerRadius
        set(value) {
            delegate.blurCornerRadius = value
            invalidateOutline()
            invalidate()
        }

    override fun onDraw(canvas: Canvas) {
        if (shouldDrawBlurBackground()) {
            delegate.draw(canvas)
        }
        super.onDraw(canvas)
    }

    protected open fun shouldDrawBlurBackground(): Boolean = true
}

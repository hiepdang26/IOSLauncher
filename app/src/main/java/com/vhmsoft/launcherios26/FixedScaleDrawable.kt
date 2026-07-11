package com.vhmsoft.launcherios26

import android.annotation.TargetApi
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.DrawableWrapper
import android.os.Build
import android.util.AttributeSet
import org.xmlpull.v1.XmlPullParser

@TargetApi(Build.VERSION_CODES.N)
class FixedScaleDrawable : DrawableWrapper(ColorDrawable()) {
    private var mScaleX = LEGACY_ICON_SCALE
    private var mScaleY = LEGACY_ICON_SCALE

    override fun draw(canvas: Canvas) {
        val saveCount = canvas.save()
        canvas.scale(mScaleX, mScaleY, bounds.exactCenterX(), bounds.exactCenterY())
        super.draw(canvas)
        canvas.restoreToCount(saveCount)
    }

    override fun inflate(r: Resources, parser: XmlPullParser, attrs: AttributeSet) {
    }

    override fun inflate(
        r: Resources,
        parser: XmlPullParser,
        attrs: AttributeSet,
        theme: Resources.Theme?
    ) {
    }

    fun setScale(scale: Float) {
        val height = intrinsicHeight.toFloat()
        val width = intrinsicWidth.toFloat()
        mScaleX = scale * LEGACY_ICON_SCALE
        mScaleY = scale * LEGACY_ICON_SCALE
        if (height > width && width > 0) {
            mScaleX *= width / height
        } else if (width > height && height > 0) {
            mScaleY *= height / width
        }
    }

    companion object {
        const val LEGACY_ICON_SCALE = .7f * .6667f
    }
}

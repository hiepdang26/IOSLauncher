package com.vhmsoft.launcherios26.core.customviews

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.LinearLayout
import com.vhmsoft.launcherios26.BlissLauncher

class PageIndicatorLinearLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    private val mContext: Context = context
    private var fallbackBackground: Drawable? = null
    private var externalRealtimeLiquidGlassEnabled = false

    fun setFallbackBackground(drawable: Drawable?) {
        fallbackBackground = drawable
        applyResolvedBackground()
    }

    fun setExternalRealtimeLiquidGlassEnabled(enabled: Boolean) {
        if (externalRealtimeLiquidGlassEnabled == enabled) return
        externalRealtimeLiquidGlassEnabled = enabled
        applyResolvedBackground()
    }

    private fun applyResolvedBackground() {
        background = if (externalRealtimeLiquidGlassEnabled) {
            null
        } else {
            fallbackBackground
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val params = layoutParams
        if (params != null && params.width != ViewGroup.LayoutParams.MATCH_PARENT) {
            return
        }
        val deviceProfile = BlissLauncher.getApplication(mContext).deviceProfile
        setMeasuredDimension(deviceProfile.availableWidthPx, deviceProfile.pageIndicatorHeight)
    }
}

package com.cloudx.ios17.core.customviews

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout

class LauncherRealtimeLiquidGlassSourceLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : FrameLayout(context, attrs), Insettable {

    private val lastInsets = Rect()

    override fun setInsets(insets: Rect?) {
        lastInsets.set(InsettableRectPolicy.nonNull(insets))
        updateChildInsets()
    }

    override fun onViewAdded(child: View) {
        super.onViewAdded(child)
        updateChildInsets()
    }

    private fun updateChildInsets() {
        for (index in 0 until childCount) {
            (getChildAt(index) as? Insettable)?.setInsets(lastInsets)
        }
    }
}

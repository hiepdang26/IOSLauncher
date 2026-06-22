package com.cloudx.ios17.core.customviews

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsets
import android.widget.RelativeLayout
import com.cloudx.ios17.BlissLauncher
import com.cloudx.ios17.R

class InsettableRelativeLayout @JvmOverloads constructor(
    private val mContext: Context,
    attrs: AttributeSet? = null
) : RelativeLayout(mContext, attrs) {

    protected val mInsets: Rect = Rect()

    override fun onApplyWindowInsets(insets: WindowInsets): WindowInsets {
        BlissLauncher.getApplication(mContext).resetDeviceProfile()
        mInsets.set(
            insets.systemWindowInsetLeft,
            insets.systemWindowInsetTop,
            insets.systemWindowInsetRight,
            insets.systemWindowInsetBottom
        )
        updateChildInsets()
        return insets
    }

    private fun updateChildInsets() {
        val childCount = childCount
        for (index in 0 until childCount) {
            val child = getChildAt(index)
            if (child is Insettable) {
                child.setInsets(mInsets)
            }
        }
    }

    override fun generateLayoutParams(attrs: AttributeSet): LayoutParams {
        return LayoutParams(context, attrs)
    }

    override fun generateDefaultLayoutParams(): LayoutParams {
        return LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun checkLayoutParams(params: ViewGroup.LayoutParams): Boolean {
        return params is LayoutParams
    }

    override fun generateLayoutParams(params: ViewGroup.LayoutParams): LayoutParams {
        return LayoutParams(params)
    }

    class LayoutParams : RelativeLayout.LayoutParams {
        @JvmField
        var ignoreInsets: Boolean = false

        constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
            val typedArray =
                context.obtainStyledAttributes(attrs, R.styleable.InsettableFrameLayout_Layout)
            ignoreInsets = typedArray.getBoolean(
                R.styleable.InsettableFrameLayout_Layout_layout_ignoreInsets,
                false
            )
            typedArray.recycle()
        }

        constructor(width: Int, height: Int) : super(width, height)

        constructor(layoutParams: ViewGroup.LayoutParams) : super(layoutParams)
    }

    override fun onViewAdded(child: View) {
        super.onViewAdded(child)
        updateChildInsets()
    }
}

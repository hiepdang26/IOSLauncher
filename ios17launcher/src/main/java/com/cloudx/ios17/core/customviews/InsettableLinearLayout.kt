package com.cloudx.ios17.core.customviews

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import android.view.ViewDebug
import android.view.ViewGroup
import android.widget.LinearLayout
import com.cloudx.ios17.R

class InsettableLinearLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(context, attrs), Insettable {

    @ViewDebug.ExportedProperty(category = "launcher")
    protected val mInsets: Rect = Rect()

    private var mInsetsSet = false

    val insets: Rect
        get() = mInsets

    fun setLinearLayoutChildInsets(child: View, newInsets: Rect?, oldInsets: Rect?) {
        val safeNewInsets = InsettableRectPolicy.nonNull(newInsets)
        val safeOldInsets = InsettableRectPolicy.nonNull(oldInsets)
        val lp = child.layoutParams as LayoutParams

        val childIndex = indexOfChild(child)
        val newTop = if (childIndex == 0) safeNewInsets.top else 0
        val oldTop = if (childIndex == 0) safeOldInsets.top else 0
        val newBottom = if (childIndex == childCount - 1) safeNewInsets.bottom else 0
        val oldBottom = if (childIndex == childCount - 1) safeOldInsets.bottom else 0

        if (child is Insettable) {
            child.setInsets(Rect(safeNewInsets.left, newTop, safeNewInsets.right, newBottom))
        } else if (!lp.ignoreInsets) {
            lp.topMargin += newTop - oldTop
            lp.leftMargin += safeNewInsets.left - safeOldInsets.left
            lp.rightMargin += safeNewInsets.right - safeOldInsets.right
            lp.bottomMargin += newBottom - oldBottom
        }
        child.layoutParams = lp
    }

    override fun setInsets(insets: Rect?) {
        if (orientation != VERTICAL) {
            throw IllegalStateException("Doesn't support horizontal orientation")
        }
        val safeInsets = InsettableRectPolicy.nonNull(insets)
        mInsetsSet = true
        val childCount = childCount
        for (i in 0 until childCount) {
            setLinearLayoutChildInsets(getChildAt(i), safeInsets, mInsets)
        }
        mInsets.set(safeInsets)
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

    class LayoutParams : LinearLayout.LayoutParams {
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
        if (mInsetsSet) {
            throw IllegalStateException("Cannot modify views after insets are set")
        }
    }

    override fun onViewRemoved(child: View) {
        super.onViewRemoved(child)
        if (mInsetsSet) {
            throw IllegalStateException("Cannot modify views after insets are set")
        }
    }
}

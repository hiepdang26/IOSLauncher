package com.cloudx.ios17.core.customviews

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import android.view.ViewDebug
import android.view.ViewGroup
import android.widget.FrameLayout
import com.cloudx.ios17.R

open class InsettableFrameLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : FrameLayout(context, attrs), Insettable {

    @ViewDebug.ExportedProperty(category = "launcher")
    protected val mInsets: Rect = Rect()

    val insets: Rect
        get() = mInsets

    fun setFrameLayoutChildInsets(child: View, newInsets: Rect?, oldInsets: Rect?) {
        val safeNewInsets = InsettableRectPolicy.nonNull(newInsets)
        val safeOldInsets = InsettableRectPolicy.nonNull(oldInsets)
        val lp = child.layoutParams as LayoutParams

        if (child is Insettable) {
            child.setInsets(safeNewInsets)
        } else if (!lp.ignoreInsets) {
            lp.topMargin += safeNewInsets.top - safeOldInsets.top
            lp.leftMargin += safeNewInsets.left - safeOldInsets.left
            lp.rightMargin += safeNewInsets.right - safeOldInsets.right
            lp.bottomMargin += safeNewInsets.bottom - safeOldInsets.bottom
        }
        child.layoutParams = lp
    }

    override fun setInsets(insets: Rect?) {
        val safeInsets = InsettableRectPolicy.nonNull(insets)
        val childCount = childCount
        for (i in 0 until childCount) {
            setFrameLayoutChildInsets(getChildAt(i), safeInsets, mInsets)
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

    class LayoutParams : FrameLayout.LayoutParams {
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
        if (!isAttachedToWindow) {
            return
        }
        setFrameLayoutChildInsets(child, mInsets, Rect())
    }

    companion object {
        @JvmStatic
        fun dispatchInsets(parent: ViewGroup, insets: Rect?) {
            val childCount = parent.childCount
            for (i in 0 until childCount) {
                val child = parent.getChildAt(i)
                if (child is Insettable) {
                    child.setInsets(insets)
                }
            }
        }
    }
}

package com.luutinhit.launcher6

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout

open class InsertAbleFrameLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private val insertedViews = linkedSetOf<View>()

    init {
        clipChildren = false
        clipToPadding = false
    }

    fun insertView(view: View, params: LayoutParams = generateDefaultLayoutParams()) {
        if (insertedViews.add(view)) {
            addView(view, params)
        }
    }

    fun removeInsertedView(view: View) {
        if (insertedViews.remove(view)) {
            removeView(view)
        }
    }

    fun clearInsertedViews() {
        insertedViews.toList().forEach(::removeView)
        insertedViews.clear()
    }
}

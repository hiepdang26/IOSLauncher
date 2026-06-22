package com.cloudx.ios17.core.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.DragEvent
import androidx.appcompat.widget.AppCompatEditText

class BlissInput @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatEditText(context, attrs, defStyleAttr) {
    override fun onDragEvent(event: DragEvent?): Boolean = false
}

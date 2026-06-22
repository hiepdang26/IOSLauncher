package com.cloudx.ios17.core.customviews

import android.graphics.Canvas
import java.util.Calendar

interface DialOverlay {
    fun onDraw(
        canvas: Canvas,
        cX: Float,
        cY: Float,
        w: Int,
        h: Int,
        calendar: Calendar,
        sizeChanged: Boolean
    )
}

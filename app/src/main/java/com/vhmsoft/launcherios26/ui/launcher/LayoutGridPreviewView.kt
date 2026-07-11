package com.vhmsoft.launcherios26.ui.launcher

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class LayoutGridPreviewView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var rows = LauncherLayoutGridPreviewPolicy.rows5x4
    private var cellColor = LauncherLayoutGridPreviewPolicy.lightCellColor

    fun setPreview(rows: Int, color: Int) {
        this.rows = rows.coerceAtLeast(1)
        cellColor = color
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.color = cellColor

        val cellSize = dp(LauncherLayoutGridPreviewPolicy.cellSizeDp).toFloat()
        val gap = dp(LauncherLayoutGridPreviewPolicy.cellGapDp).toFloat()
        val columns = LauncherLayoutGridPreviewPolicy.columns
        val gridWidth = columns * cellSize + (columns - 1) * gap
        val gridHeight = rows * cellSize + (rows - 1) * gap
        val startX = (width - gridWidth) / 2f
        val startY = (height - gridHeight) / 2f

        for (row in 0 until rows) {
            for (column in 0 until columns) {
                val left = startX + column * (cellSize + gap)
                val top = startY + row * (cellSize + gap)
                canvas.drawRect(left, top, left + cellSize, top + cellSize, paint)
            }
        }
    }

    private fun dp(value: Int): Int =
        (value * resources.displayMetrics.density + 0.5f).toInt()
}

package com.vhmsoft.launcherios26.core

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable

object LauncherLiquidGlassDrawableFactory {

    fun create(
        context: Context,
        style: LauncherLiquidGlassStylePolicy.BackgroundStyle
    ): Drawable {
        val radius = dp(context, style.radiusDp).toFloat()
        val layers = mutableListOf<Drawable>()

        layers += roundedRect(radius).apply {
            setColor(style.color)
        }

        if (style.sideHighlightColor != null || style.edgeShadeColor != null) {
            layers += roundedGradient(
                radius = radius,
                orientation = GradientDrawable.Orientation.LEFT_RIGHT,
                colors = intArrayOf(
                    style.sideHighlightColor ?: Color.TRANSPARENT,
                    Color.TRANSPARENT,
                    style.edgeShadeColor ?: Color.TRANSPARENT
                )
            )
        }

        if (style.topHighlightColor != null || style.bottomShadeColor != null) {
            layers += roundedGradient(
                radius = radius,
                orientation = GradientDrawable.Orientation.TOP_BOTTOM,
                colors = intArrayOf(
                    style.topHighlightColor ?: Color.TRANSPARENT,
                    Color.TRANSPARENT,
                    style.bottomShadeColor ?: Color.TRANSPARENT
                )
            )
        }

        style.strokeColor?.let { strokeColor ->
            layers += roundedRect(radius).apply {
                setColor(Color.TRANSPARENT)
                setStroke(dp(context, style.strokeWidthDp).coerceAtLeast(1), strokeColor)
            }
        }

        style.diagonalCornerStrokeColor?.let { strokeColor ->
            layers += DiagonalCornerStrokeDrawable(
                radius = radius,
                color = strokeColor,
                strokeWidth = dp(context, style.diagonalCornerStrokeWidthDp).coerceAtLeast(1).toFloat()
            )
        }

        return LayerDrawable(layers.toTypedArray())
    }

    private fun roundedRect(radius: Float): GradientDrawable =
        GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = radius
        }

    private fun roundedGradient(
        radius: Float,
        orientation: GradientDrawable.Orientation,
        colors: IntArray
    ): GradientDrawable =
        GradientDrawable(orientation, colors).apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = radius
        }

    private fun dp(context: Context, value: Int): Int =
        (value * context.resources.displayMetrics.density + 0.5f).toInt()

    private class DiagonalCornerStrokeDrawable(
        private val radius: Float,
        color: Int,
        strokeWidth: Float
    ) : Drawable() {
        private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style = Paint.Style.STROKE
            strokeCap = Paint.Cap.ROUND
            this.strokeWidth = strokeWidth
            this.color = color
        }

        override fun draw(canvas: Canvas) {
            val b = bounds
            val inset = paint.strokeWidth / 2f
            val r = radius.coerceAtMost(minOf(b.width(), b.height()) / 2f)
            val run = r * 0.58f
            val left = b.left.toFloat() + inset
            val top = b.top.toFloat() + inset
            val right = b.right.toFloat() - inset
            val bottom = b.bottom.toFloat() - inset

            canvas.drawLine(left + r, top, left + r + run, top, paint)
            canvas.drawLine(left, top + r, left, top + r + run, paint)
            canvas.drawArc(RectF(left, top, left + r * 2f, top + r * 2f), 180f, 90f, false, paint)

            canvas.drawLine(right - r, bottom, right - r - run, bottom, paint)
            canvas.drawLine(right, bottom - r, right, bottom - r - run, paint)
            canvas.drawArc(RectF(right - r * 2f, bottom - r * 2f, right, bottom), 0f, 90f, false, paint)
        }

        override fun setAlpha(alpha: Int) {
            paint.alpha = alpha
        }

        override fun setColorFilter(colorFilter: android.graphics.ColorFilter?) {
            paint.colorFilter = colorFilter
        }

        @Suppress("DEPRECATION")
        override fun getOpacity(): Int = android.graphics.PixelFormat.TRANSLUCENT
    }
}

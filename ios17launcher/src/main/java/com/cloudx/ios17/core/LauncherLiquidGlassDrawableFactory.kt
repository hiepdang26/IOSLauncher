package com.cloudx.ios17.core

import android.content.Context
import android.graphics.Color
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
}

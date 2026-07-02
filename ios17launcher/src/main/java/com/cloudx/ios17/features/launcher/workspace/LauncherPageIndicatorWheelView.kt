package com.cloudx.ios17.features.launcher.workspace

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.DecelerateInterpolator

class LauncherPageIndicatorWheelView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.WHITE
    }
    private var markers: List<LauncherPageIndicatorWindowPolicy.Marker> = emptyList()
    private var fromMarkers: List<LauncherPageIndicatorWindowPolicy.Marker> = emptyList()
    private var toMarkers: List<LauncherPageIndicatorWindowPolicy.Marker> = emptyList()
    private var slideDirection = LauncherPageIndicatorWindowPolicy.SlideDirection.NONE
    private var slideProgress = 1f
    private var animator: ValueAnimator? = null

    fun setMarkers(
        nextMarkers: List<LauncherPageIndicatorWindowPolicy.Marker>,
        animate: Boolean = true
    ) {
        if (nextMarkers == markers && slideProgress >= 1f) return

        val currentMarkers = if (toMarkers.isNotEmpty() && slideProgress < 1f) {
            toMarkers
        } else {
            markers
        }
        val direction = LauncherPageIndicatorWindowPolicy.slideDirection(
            currentPages = currentMarkers.map { marker -> marker.pageIndex },
            nextPages = nextMarkers.map { marker -> marker.pageIndex }
        )

        animator?.cancel()
        if (!animate || currentMarkers.isEmpty() || direction == LauncherPageIndicatorWindowPolicy.SlideDirection.NONE) {
            markers = nextMarkers
            fromMarkers = emptyList()
            toMarkers = emptyList()
            slideDirection = LauncherPageIndicatorWindowPolicy.SlideDirection.NONE
            slideProgress = 1f
            invalidate()
            return
        }

        fromMarkers = currentMarkers
        toMarkers = nextMarkers
        slideDirection = direction
        slideProgress = 0f
        animator = ValueAnimator.ofFloat(0f, 1f).apply {
            duration = WHEEL_ANIMATION_MS
            interpolator = DecelerateInterpolator()
            addUpdateListener { valueAnimator ->
                slideProgress = valueAnimator.animatedValue as Float
                invalidate()
            }
            addListener(object : AnimatorListenerAdapter() {
                private var cancelled = false

                override fun onAnimationCancel(animation: Animator) {
                    cancelled = true
                }

                override fun onAnimationEnd(animation: Animator) {
                    if (!cancelled) {
                        markers = nextMarkers
                        fromMarkers = emptyList()
                        toMarkers = emptyList()
                        slideDirection = LauncherPageIndicatorWindowPolicy.SlideDirection.NONE
                        slideProgress = 1f
                        invalidate()
                    }
                    if (animator === animation) {
                        animator = null
                    }
                }
            })
            start()
        }
    }

    fun setScrollPosition(
        pageCount: Int,
        pagePosition: Float
    ) {
        val frame = LauncherPageIndicatorWindowPolicy.scrollFrame(
            pageCount = pageCount,
            pagePosition = pagePosition
        )
        animator?.cancel()
        if (frame.progress <= 0f || frame.fromMarkers == frame.toMarkers) {
            markers = frame.fromMarkers
            fromMarkers = emptyList()
            toMarkers = emptyList()
            slideDirection = LauncherPageIndicatorWindowPolicy.SlideDirection.NONE
            slideProgress = 1f
            invalidate()
            return
        }

        markers = frame.toMarkers
        fromMarkers = frame.fromMarkers
        toMarkers = frame.toMarkers
        slideDirection = frame.direction
        slideProgress = frame.progress
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (fromMarkers.isNotEmpty() && toMarkers.isNotEmpty() && slideProgress < 1f) {
            drawWheelTransition(canvas)
        } else {
            val markerCount = markers.size
            markers.forEachIndexed { index, marker ->
                drawMarker(canvas, marker, slotX(index, markerCount), 1f)
            }
        }
    }

    private fun drawWheelTransition(canvas: Canvas) {
        val progress = slideProgress.coerceIn(0f, 1f)
        val fromMarkerCount = fromMarkers.size
        val toMarkerCount = toMarkers.size
        when (slideDirection) {
            LauncherPageIndicatorWindowPolicy.SlideDirection.FORWARD -> {
                fromMarkers.forEachIndexed { index, marker ->
                    val fade = 1f - progress
                    drawMarker(canvas, marker, slotX(index, fromMarkerCount) - dotStepPx() * progress, fade)
                }
                toMarkers.forEachIndexed { index, marker ->
                    drawMarker(canvas, marker, slotX(index, toMarkerCount) + dotStepPx() * (1f - progress), progress)
                }
            }

            LauncherPageIndicatorWindowPolicy.SlideDirection.BACKWARD -> {
                toMarkers.forEachIndexed { index, marker ->
                    drawMarker(canvas, marker, slotX(index, toMarkerCount) - dotStepPx() * (1f - progress), progress)
                }
                fromMarkers.forEachIndexed { index, marker ->
                    val fade = 1f - progress
                    drawMarker(canvas, marker, slotX(index, fromMarkerCount) + dotStepPx() * progress, fade)
                }
            }

            LauncherPageIndicatorWindowPolicy.SlideDirection.NONE -> {
                fromMarkers.forEachIndexed { index, marker ->
                    drawMarker(canvas, marker, slotX(index, fromMarkerCount), 1f - progress)
                }
                toMarkers.forEachIndexed { index, marker ->
                    drawMarker(canvas, marker, slotX(index, toMarkerCount), progress)
                }
            }
        }
    }

    private fun drawMarker(
        canvas: Canvas,
        marker: LauncherPageIndicatorWindowPolicy.Marker,
        centerX: Float,
        fadeFraction: Float
    ) {
        val visual = visualFor(marker.state)
        paint.alpha = (visual.alpha * fadeFraction.coerceIn(0f, 1f) * 255f).toInt().coerceIn(0, 255)
        canvas.drawCircle(
            centerX,
            height / 2f,
            dotRadiusPx() * visual.scale,
            paint
        )
        paint.alpha = 255
    }

    private fun visualFor(state: LauncherPageIndicatorWindowPolicy.MarkerState): MarkerVisual {
        return when (state) {
            LauncherPageIndicatorWindowPolicy.MarkerState.ACTIVE -> MarkerVisual(alpha = 1f, scale = 1f)
            LauncherPageIndicatorWindowPolicy.MarkerState.INACTIVE -> MarkerVisual(alpha = 0.5f, scale = 1f)
            LauncherPageIndicatorWindowPolicy.MarkerState.SMALL -> MarkerVisual(alpha = 0.5f, scale = 0.6f)
        }
    }

    private fun slotX(
        slot: Int,
        markerCount: Int
    ): Float {
        return width / 2f + LauncherPageIndicatorWindowPolicy.markerCenterOffset(
            slot = slot,
            markerCount = markerCount,
            dotStepPx = dotStepPx()
        )
    }

    private fun dotStepPx(): Float = DOT_STEP_DP * resources.displayMetrics.density

    private fun dotRadiusPx(): Float = DOT_RADIUS_DP * resources.displayMetrics.density

    private data class MarkerVisual(
        val alpha: Float,
        val scale: Float
    )

    private companion object {
        const val DOT_RADIUS_DP = 3f
        const val DOT_STEP_DP = 14f
        const val WHEEL_ANIMATION_MS = 268L
    }
}

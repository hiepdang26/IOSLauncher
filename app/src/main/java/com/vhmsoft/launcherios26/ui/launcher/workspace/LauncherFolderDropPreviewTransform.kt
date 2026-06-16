package com.vhmsoft.launcherios26.ui.launcher.workspace

import kotlin.math.max
import kotlin.math.min

internal object LauncherFolderDropPreviewTransform {
    data class Transform(
        val centerX: Float,
        val centerY: Float,
        val scale: Float,
        val alphaFraction: Float
    )

    fun hoverProgress(elapsedMs: Long, durationMs: Long): Float {
        if (durationMs <= 0L) return 1f
        val linear = (elapsedMs.toFloat() / durationMs).coerceIn(0f, 1f)
        return 1f - (1f - linear) * (1f - linear)
    }

    fun hoverTransform(
        currentCenterX: Float,
        currentCenterY: Float,
        targetCenterX: Float,
        targetCenterY: Float,
        elapsedMs: Long,
        durationMs: Long
    ): Transform {
        val easedProgress = hoverProgress(elapsedMs, durationMs)
        val pullProgress = easedProgress * HOVER_PULL_PROGRESS
        return Transform(
            centerX = lerp(currentCenterX, targetCenterX, pullProgress),
            centerY = lerp(currentCenterY, targetCenterY, pullProgress),
            scale = lerp(1f, HOVER_SCALE, easedProgress),
            alphaFraction = lerp(1f, HOVER_ALPHA, easedProgress)
        )
    }

    fun dropTransform(
        currentCenterX: Float,
        currentCenterY: Float,
        targetCenterX: Float,
        targetCenterY: Float,
        progress: Float
    ): Transform {
        val boundedProgress = progress.coerceIn(0f, 1f)
        return Transform(
            centerX = lerp(currentCenterX, targetCenterX, boundedProgress),
            centerY = lerp(currentCenterY, targetCenterY, boundedProgress),
            scale = lerp(1f, DROP_SCALE, boundedProgress),
            alphaFraction = lerp(1f, DROP_ALPHA, boundedProgress)
        )
    }

    private fun lerp(start: Float, end: Float, progress: Float): Float {
        val boundedProgress = max(0f, min(1f, progress))
        return start + (end - start) * boundedProgress
    }

    private const val HOVER_PULL_PROGRESS = 0.52f
    private const val HOVER_SCALE = 0.72f
    private const val HOVER_ALPHA = 0.82f
    private const val DROP_SCALE = 0.18f
    private const val DROP_ALPHA = 0f
}

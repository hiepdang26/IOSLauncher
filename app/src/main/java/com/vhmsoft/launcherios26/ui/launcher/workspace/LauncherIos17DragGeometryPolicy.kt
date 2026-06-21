package com.vhmsoft.launcherios26.ui.launcher.workspace

import kotlin.math.sqrt

internal object LauncherIos17DragGeometryPolicy {
    fun isFolderInterest(
        localXInIcon: Float,
        localYInIcon: Float,
        thresholdFraction: Float = FOLDER_INTEREST_DISTANCE_FRACTION
    ): Boolean {
        val localX = localXInIcon.coerceIn(0f, 1f)
        val localY = localYInIcon.coerceIn(0f, 1f)
        val distance = sqrt((localX - 0.5f) * (localX - 0.5f) + (localY - 0.5f) * (localY - 0.5f))
        return distance < thresholdFraction
    }

    fun intersectsTargetIcon(
        dragCenterX: Float,
        dragCenterY: Float,
        dragIconWidth: Float,
        dragIconHeight: Float,
        targetLeft: Float,
        targetTop: Float,
        targetRight: Float,
        targetBottom: Float
    ): Boolean {
        if (dragIconWidth <= 0f || dragIconHeight <= 0f) return false
        val dragLeft = dragCenterX - dragIconWidth / 2f
        val dragTop = dragCenterY - dragIconHeight / 2f
        val dragRight = dragCenterX + dragIconWidth / 2f
        val dragBottom = dragCenterY + dragIconHeight / 2f
        return dragLeft < targetRight &&
            dragRight > targetLeft &&
            dragTop < targetBottom &&
            dragBottom > targetTop
    }

    private const val FOLDER_INTEREST_DISTANCE_FRACTION = 0.45f
}

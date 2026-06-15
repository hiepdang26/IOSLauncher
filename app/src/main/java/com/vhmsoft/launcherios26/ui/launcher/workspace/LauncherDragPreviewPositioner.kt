package com.vhmsoft.launcherios26.ui.launcher.workspace

object LauncherDragPreviewPositioner {
    data class Position(
        val left: Int,
        val top: Int
    )

    fun positionForIconCenter(
        rootWidth: Int,
        rootHeight: Int,
        previewWidth: Int,
        previewHeight: Int,
        iconCenterY: Int,
        centerX: Float,
        centerY: Float,
        horizontalPadding: Int,
        verticalPadding: Int
    ): Position {
        val maxLeft = (rootWidth - previewWidth - horizontalPadding)
            .coerceAtLeast(horizontalPadding)
        val maxTop = (rootHeight - previewHeight - verticalPadding)
            .coerceAtLeast(verticalPadding)
        return Position(
            left = (centerX - previewWidth / 2f)
                .toInt()
                .coerceIn(horizontalPadding, maxLeft),
            top = (centerY - iconCenterY)
                .toInt()
                .coerceIn(verticalPadding, maxTop)
        )
    }
}

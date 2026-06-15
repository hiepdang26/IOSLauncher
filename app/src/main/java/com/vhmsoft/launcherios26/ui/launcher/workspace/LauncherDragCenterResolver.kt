package com.vhmsoft.launcherios26.ui.launcher.workspace

internal object LauncherDragCenterResolver {
    fun resolve(
        dragStartCenterX: Float,
        dragStartCenterY: Float,
        dX: Float,
        dY: Float,
        rawTouch: Pair<Float, Float>?,
        touchToCenterOffsetX: Float,
        touchToCenterOffsetY: Float
    ): Pair<Float, Float> {
        if (rawTouch != null) {
            return Pair(
                rawTouch.first + touchToCenterOffsetX,
                rawTouch.second + touchToCenterOffsetY
            )
        }

        return Pair(
            dragStartCenterX + dX,
            dragStartCenterY + dY
        )
    }
}

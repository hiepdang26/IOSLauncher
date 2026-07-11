package com.vhmsoft.launcherios26.features.launcher

object TodayWidgetDragAnimationPolicy {
    const val MOVE_DURATION_MS = 300L

    data class Translation(
        val x: Float,
        val y: Float
    )

    fun startTranslation(
        previousLeft: Int,
        previousTop: Int,
        currentLeft: Int,
        currentTop: Int
    ): Translation {
        return Translation(
            x = (previousLeft - currentLeft).toFloat(),
            y = (previousTop - currentTop).toFloat()
        )
    }
}

package com.vhmsoft.launcherios26.features.launcher

object FolderOpenPerformancePolicy {
    const val OPEN_ANIMATION_DURATION_MS = 300L
    const val CONTENT_FADE_IN_DURATION_MS = 120L
    const val REALTIME_GLASS_BIND_DELAY_MS = 120L

    fun shouldDeferContentBinding(openedByDragHover: Boolean): Boolean =
        !openedByDragHover

    fun shouldDeferRealtimeGlassBinding(
        openedByDragHover: Boolean,
        liquidGlassEnabled: Boolean
    ): Boolean = liquidGlassEnabled && !openedByDragHover
}

package com.vhmsoft.launcherios26.ui.launcher.workspace

internal data class LauncherTodayWidgetCenter(
    val x: Float,
    val y: Float
)

internal data class LauncherTodayWidgetOffset(
    val x: Float,
    val y: Float
)

internal object LauncherTodayWidgetPushPreview {
    fun offsetsForMove(
        widgetIds: List<Long>,
        draggedWidgetId: Long,
        targetIndex: Int,
        centers: Map<Long, LauncherTodayWidgetCenter>
    ): Map<Long, LauncherTodayWidgetOffset> {
        val fromIndex = widgetIds.indexOf(draggedWidgetId)
        if (fromIndex == -1) return emptyMap()

        val previewIds = LauncherTodayWidgetLayoutPlanner.move(
            items = widgetIds,
            fromIndex = fromIndex,
            toIndex = targetIndex
        )
        if (previewIds == widgetIds) return emptyMap()

        return previewIds.mapIndexedNotNull { slotIndex, widgetId ->
            if (widgetId == draggedWidgetId) return@mapIndexedNotNull null

            val sourceCenter = centers[widgetId] ?: return@mapIndexedNotNull null
            val slotWidgetId = widgetIds.getOrNull(slotIndex) ?: return@mapIndexedNotNull null
            val targetCenter = centers[slotWidgetId] ?: return@mapIndexedNotNull null
            widgetId to LauncherTodayWidgetOffset(
                x = targetCenter.x - sourceCenter.x,
                y = targetCenter.y - sourceCenter.y
            )
        }.toMap()
    }

    fun offsetsForTargetCenters(
        draggedWidgetId: Long,
        centers: Map<Long, LauncherTodayWidgetCenter>,
        targetCenters: Map<Long, LauncherTodayWidgetCenter>
    ): Map<Long, LauncherTodayWidgetOffset> {
        return targetCenters.mapNotNull { (widgetId, targetCenter) ->
            if (widgetId == draggedWidgetId) return@mapNotNull null

            val sourceCenter = centers[widgetId] ?: return@mapNotNull null
            widgetId to LauncherTodayWidgetOffset(
                x = targetCenter.x - sourceCenter.x,
                y = targetCenter.y - sourceCenter.y
            )
        }.toMap()
    }
}

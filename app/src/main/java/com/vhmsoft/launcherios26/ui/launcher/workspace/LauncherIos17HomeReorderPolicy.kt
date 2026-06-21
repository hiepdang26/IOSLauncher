package com.vhmsoft.launcherios26.ui.launcher.workspace

internal object LauncherIos17HomeReorderPolicy {
    fun moveExistingItemToIndex(
        items: List<LauncherHomeItemUiModel>,
        draggedStableId: Long,
        targetIndex: Int
    ): List<LauncherHomeItemUiModel>? {
        val fromIndex = items.indexOfFirst { item -> item.stableId == draggedStableId }
        if (fromIndex == -1 || fromIndex !in items.indices || fromIndex == targetIndex) return null

        val mutableItems = items.toMutableList()
        val draggedItem = mutableItems.removeAt(fromIndex)
        val adjustedTargetIndex = targetIndex.coerceIn(0, mutableItems.size)
        mutableItems.add(adjustedTargetIndex, draggedItem)
        return LauncherHomeLayoutBuilder.normalize(mutableItems)
    }
}

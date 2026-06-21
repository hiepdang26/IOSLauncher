package com.vhmsoft.launcherios26.ui.launcher.workspace

internal object LauncherDockHomeDropResolver {
    fun resolveDrop(
        baseItems: List<LauncherHomeItemUiModel>,
        dockItem: LauncherHomeItemUiModel,
        dropIndex: Int,
        folderTargetIndex: Int?
    ): List<LauncherHomeItemUiModel> {
        return when (dockItem) {
            is LauncherHomeItemUiModel.App -> LauncherFolderExitDropResolver.resolveDrop(
                baseItems = baseItems,
                draggedApp = dockItem.iconItem,
                dropIndex = dropIndex,
                folderTargetIndex = folderTargetIndex
            )

            is LauncherHomeItemUiModel.Folder -> insertAtHomeIndex(
                baseItems = baseItems,
                index = dropIndex,
                item = dockItem
            )

            is LauncherHomeItemUiModel.Placeholder -> LauncherHomeLayoutBuilder.normalize(baseItems)
        }
    }

    private fun insertAtHomeIndex(
        baseItems: List<LauncherHomeItemUiModel>,
        index: Int,
        item: LauncherHomeItemUiModel
    ): List<LauncherHomeItemUiModel> {
        val targetIndex = index.coerceAtLeast(0)
        return LauncherHomeLayoutBuilder.normalize(
            baseItems.toMutableList().apply {
                while (size < targetIndex) {
                    add(LauncherHomeItemUiModel.Placeholder.forGridIndex(size))
                }
                val boundedIndex = targetIndex.coerceAtMost(size)
                if (getOrNull(boundedIndex) is LauncherHomeItemUiModel.Placeholder) {
                    this[boundedIndex] = item
                } else {
                    add(boundedIndex, item)
                }
            }
        )
    }
}

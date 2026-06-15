package com.vhmsoft.launcherios26.ui.launcher.workspace

object LauncherHomeItemDropResolver {
    fun resolveDrop(
        baseItems: List<LauncherHomeItemUiModel>,
        draggedItem: LauncherHomeItemUiModel,
        dropIndex: Int
    ): List<LauncherHomeItemUiModel> {
        if (draggedItem is LauncherHomeItemUiModel.Placeholder) {
            return LauncherHomeLayoutBuilder.normalize(baseItems)
        }

        return LauncherHomeLayoutBuilder.normalize(
            removeDraggedItem(baseItems, draggedItem).toMutableList().apply {
                val targetIndex = dropIndex.coerceAtLeast(0)
                while (size < targetIndex) {
                    add(LauncherHomeItemUiModel.Placeholder.forGridIndex(size))
                }
                if (getOrNull(targetIndex) is LauncherHomeItemUiModel.Placeholder) {
                    this[targetIndex] = draggedItem
                } else {
                    add(targetIndex.coerceAtMost(size), draggedItem)
                }
            }
        )
    }

    private fun removeDraggedItem(
        items: List<LauncherHomeItemUiModel>,
        draggedItem: LauncherHomeItemUiModel
    ): List<LauncherHomeItemUiModel> {
        return when (draggedItem) {
            is LauncherHomeItemUiModel.App -> items.mapNotNull { item ->
                when (item) {
                    is LauncherHomeItemUiModel.App -> item.takeIf { appItem ->
                        appItem.iconItem.app.iconKey != draggedItem.iconItem.app.iconKey
                    }

                    is LauncherHomeItemUiModel.Folder -> item.copy(
                        apps = item.apps.filterNot { app ->
                            app.app.iconKey == draggedItem.iconItem.app.iconKey
                        }
                    )

                    is LauncherHomeItemUiModel.Placeholder -> item
                }
            }

            is LauncherHomeItemUiModel.Folder -> items.filterNot { item ->
                item.stableId == draggedItem.stableId
            }

            is LauncherHomeItemUiModel.Placeholder -> items
        }
    }
}

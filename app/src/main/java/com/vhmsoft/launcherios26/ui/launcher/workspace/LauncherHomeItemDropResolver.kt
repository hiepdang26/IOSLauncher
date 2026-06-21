package com.vhmsoft.launcherios26.ui.launcher.workspace

object LauncherHomeItemDropResolver {
    fun resolveDrop(
        baseItems: List<LauncherHomeItemUiModel>,
        draggedItem: LauncherHomeItemUiModel,
        dropIndex: Int,
        sourcePlaceholderStableId: Long? = null,
        columns: Int = DEFAULT_HOME_COLUMNS,
        rows: Int = DEFAULT_HOME_ROWS
    ): List<LauncherHomeItemUiModel> {
        if (draggedItem is LauncherHomeItemUiModel.Placeholder) {
            return movePlaceholder(
                baseItems = baseItems,
                draggedPlaceholder = draggedItem,
                dropIndex = dropIndex
            )
        }

        LauncherIos17HomeReorderPolicy.moveExistingItemToIndex(
            items = baseItems,
            draggedStableId = draggedItem.stableId,
            targetIndex = dropIndex
        )?.let { movedItems -> return movedItems }

        sourcePlaceholderStableId?.let { placeholderStableId ->
            swapDraggedItemWithTargetFromSourcePlaceholder(
                baseItems = baseItems,
                draggedItem = draggedItem,
                dropIndex = dropIndex,
                sourcePlaceholderStableId = placeholderStableId
            )?.let { movedItems -> return movedItems }
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

    private fun movePlaceholder(
        baseItems: List<LauncherHomeItemUiModel>,
        draggedPlaceholder: LauncherHomeItemUiModel.Placeholder,
        dropIndex: Int
    ): List<LauncherHomeItemUiModel> {
        val fromIndex = baseItems.indexOfFirst { item ->
            item.stableId == draggedPlaceholder.stableId
        }
        if (fromIndex == -1) return LauncherHomeLayoutBuilder.normalize(baseItems)

        val targetIndex = dropIndex.coerceAtLeast(0)
        val items = baseItems.toMutableList()
        while (items.size <= targetIndex) {
            items.add(LauncherHomeItemUiModel.Placeholder.forGridIndex(items.size))
        }

        if (items[targetIndex] is LauncherHomeItemUiModel.Placeholder) {
            items[fromIndex] = LauncherHomeItemUiModel.Placeholder.forGridIndex(fromIndex)
            items[targetIndex] = draggedPlaceholder
            return LauncherHomeLayoutBuilder.normalize(items)
        }

        val targetItem = items[targetIndex]
        items[targetIndex] = draggedPlaceholder
        items[fromIndex] = targetItem
        return LauncherHomeLayoutBuilder.normalize(items)
    }

    private fun swapDraggedItemWithTargetFromSourcePlaceholder(
        baseItems: List<LauncherHomeItemUiModel>,
        draggedItem: LauncherHomeItemUiModel,
        dropIndex: Int,
        sourcePlaceholderStableId: Long
    ): List<LauncherHomeItemUiModel>? {
        val items = LauncherHomeLayoutBuilder.normalize(baseItems).toMutableList()
        val sourceIndex = items.indexOfFirst { item -> item.stableId == sourcePlaceholderStableId }
        if (sourceIndex == -1) return null

        val targetIndex = dropIndex.coerceAtLeast(0)
        while (items.size <= targetIndex) {
            items.add(LauncherHomeItemUiModel.Placeholder.forGridIndex(items.size))
        }

        val targetItem = items[targetIndex]
        items[targetIndex] = draggedItem
        items[sourceIndex] = if (targetItem is LauncherHomeItemUiModel.Placeholder) {
            LauncherHomeItemUiModel.Placeholder.forGridIndex(sourceIndex)
        } else {
            targetItem
        }
        return LauncherHomeLayoutBuilder.normalize(items)
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

    private const val DEFAULT_HOME_COLUMNS = 4
    private const val DEFAULT_HOME_ROWS = 6
}

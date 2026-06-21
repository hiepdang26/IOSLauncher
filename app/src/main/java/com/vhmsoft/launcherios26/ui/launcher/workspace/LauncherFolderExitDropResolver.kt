package com.vhmsoft.launcherios26.ui.launcher.workspace

object LauncherFolderExitDropResolver {
    fun resolveDrop(
        baseItems: List<LauncherHomeItemUiModel>,
        draggedApp: LauncherIconUiModel,
        dropIndex: Int,
        folderTargetIndex: Int?
    ): List<LauncherHomeItemUiModel> {
        val sanitizedBaseItems = removeDraggedApp(baseItems, draggedApp)
        val folderIndex = folderTargetIndex
        if (folderIndex != null) {
            val targetItem = sanitizedBaseItems.getOrNull(folderIndex)
            when (targetItem) {
                is LauncherHomeItemUiModel.App -> {
                    return LauncherHomeLayoutBuilder.normalize(
                        sanitizedBaseItems.toMutableList().apply {
                            this[folderIndex] = LauncherHomeItemUiModel.Folder(
                                id = "folder_${targetItem.stableId}_${draggedApp.stableId}",
                                title = LauncherHomeLayoutBuilder.DEFAULT_FOLDER_TITLE,
                                apps = listOf(targetItem.iconItem, draggedApp)
                            )
                        }
                    )
                }

                is LauncherHomeItemUiModel.Folder -> {
                    if (targetItem.apps.any { app -> app.app.iconKey == draggedApp.app.iconKey }) {
                        return LauncherHomeLayoutBuilder.normalize(sanitizedBaseItems)
                    }
                    return LauncherHomeLayoutBuilder.normalize(
                        sanitizedBaseItems.toMutableList().apply {
                            this[folderIndex] = targetItem.copy(apps = targetItem.apps + draggedApp)
                        }
                    )
                }

                else -> Unit
            }
        }

        return LauncherHomeLayoutBuilder.normalize(
            sanitizedBaseItems.toMutableList().apply {
                val targetIndex = dropIndex.coerceAtLeast(0)
                while (size < targetIndex) {
                    add(LauncherHomeItemUiModel.Placeholder.forGridIndex(size))
                }
                val draggedItem = LauncherHomeItemUiModel.App(draggedApp)
                if (getOrNull(targetIndex) is LauncherHomeItemUiModel.Placeholder) {
                    this[targetIndex] = draggedItem
                } else {
                    add(targetIndex, draggedItem)
                }
            }
        )
    }

    private fun removeDraggedApp(
        items: List<LauncherHomeItemUiModel>,
        draggedApp: LauncherIconUiModel
    ): List<LauncherHomeItemUiModel> {
        return items.mapNotNull { item ->
            when (item) {
                is LauncherHomeItemUiModel.App -> {
                    item.takeIf { appItem ->
                        appItem.iconItem.app.iconKey != draggedApp.app.iconKey
                    }
                }

                is LauncherHomeItemUiModel.Folder -> {
                    item.copy(
                        apps = item.apps.filterNot { app ->
                            app.app.iconKey == draggedApp.app.iconKey
                        }
                    )
                }

                is LauncherHomeItemUiModel.Placeholder -> item
            }
        }
    }
}

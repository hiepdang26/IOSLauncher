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
            val targetFolder = sanitizedBaseItems.getOrNull(folderIndex) as? LauncherHomeItemUiModel.Folder
            if (targetFolder != null) {
                if (targetFolder.apps.any { app -> app.app.iconKey == draggedApp.app.iconKey }) {
                    return LauncherHomeLayoutBuilder.normalize(sanitizedBaseItems)
                }
                return LauncherHomeLayoutBuilder.normalize(
                    sanitizedBaseItems.toMutableList().apply {
                        this[folderIndex] = targetFolder.copy(apps = targetFolder.apps + draggedApp)
                    }
                )
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

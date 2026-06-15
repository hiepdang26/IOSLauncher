package com.vhmsoft.launcherios26.ui.launcher.workspace

object LauncherHomeDragBaseBuilder {
    fun forMovingItem(
        items: List<LauncherHomeItemUiModel>,
        draggedItem: LauncherHomeItemUiModel
    ): List<LauncherHomeItemUiModel> {
        return when (draggedItem) {
            is LauncherHomeItemUiModel.App -> forMovingApp(items, draggedItem.iconItem)
            is LauncherHomeItemUiModel.Folder -> LauncherHomeLayoutBuilder.normalize(
                items.mapIndexed { index, item ->
                    if (item.stableId == draggedItem.stableId) {
                        LauncherHomeItemUiModel.Placeholder.forGridIndex(index)
                    } else {
                        item
                    }
                }
            )

            is LauncherHomeItemUiModel.Placeholder -> LauncherHomeLayoutBuilder.normalize(items)
        }
    }

    fun forMovingApp(
        items: List<LauncherHomeItemUiModel>,
        draggedApp: LauncherIconUiModel
    ): List<LauncherHomeItemUiModel> {
        return LauncherHomeLayoutBuilder.normalize(
            items.mapIndexed { index, item ->
                when (item) {
                    is LauncherHomeItemUiModel.App -> {
                        if (item.iconItem.app.iconKey == draggedApp.app.iconKey) {
                            LauncherHomeItemUiModel.Placeholder.forGridIndex(index)
                        } else {
                            item
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
        )
    }
}

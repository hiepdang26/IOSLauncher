package com.vhmsoft.launcherios26.ui.launcher.workspace

internal enum class LauncherHomeHoverDropAction {
    REORDER,
    FOLDER
}

internal object LauncherHomeHoverDropPolicy {
    fun resolveAction(
        draggedItem: LauncherHomeItemUiModel?,
        targetItem: LauncherHomeItemUiModel?,
        localXInCell: Float,
        localYInCell: Float
    ): LauncherHomeHoverDropAction? {
        if (draggedItem == null || targetItem == null) return null
        if (targetItem is LauncherHomeItemUiModel.Placeholder) return null

        val localX = localXInCell.coerceIn(0f, 1f)
        val localY = localYInCell.coerceIn(0f, 1f)
        val canCreateOrUpdateFolder = draggedItem is LauncherHomeItemUiModel.App &&
            (targetItem is LauncherHomeItemUiModel.App || targetItem is LauncherHomeItemUiModel.Folder)

        return when {
            canCreateOrUpdateFolder && LauncherIos17DragGeometryPolicy.isFolderInterest(
                localXInIcon = localX,
                localYInIcon = localY
            ) -> LauncherHomeHoverDropAction.FOLDER

            else -> LauncherHomeHoverDropAction.REORDER
        }
    }
}

package com.vhmsoft.launcherios26.ui.launcher.workspace

internal enum class LauncherHomeHoverDropAction {
    INSERT_BEFORE,
    INSERT_AFTER,
    FOLDER
}

internal object LauncherHomeHoverDropPolicy {
    fun resolveAction(
        draggedItem: LauncherHomeItemUiModel?,
        targetItem: LauncherHomeItemUiModel?,
        localXInCell: Float,
        localYInCell: Float,
        edgeInsertFraction: Float = DEFAULT_EDGE_INSERT_FRACTION,
        edgeInsertVerticalFraction: Float = DEFAULT_EDGE_INSERT_VERTICAL_FRACTION
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

            localX <= edgeInsertFraction -> LauncherHomeHoverDropAction.INSERT_BEFORE
            localX >= 1f - edgeInsertFraction -> LauncherHomeHoverDropAction.INSERT_AFTER
            localY <= edgeInsertVerticalFraction -> LauncherHomeHoverDropAction.INSERT_BEFORE
            localY >= 1f - edgeInsertVerticalFraction -> LauncherHomeHoverDropAction.INSERT_AFTER
            else -> LauncherHomeHoverDropAction.INSERT_AFTER
        }
    }

    private const val DEFAULT_EDGE_INSERT_FRACTION = 0.32f
    private const val DEFAULT_EDGE_INSERT_VERTICAL_FRACTION = 0.22f
}

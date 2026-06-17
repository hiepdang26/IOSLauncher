package com.vhmsoft.launcherios26.ui.launcher.workspace

internal data class LauncherFolderDropCommitResult(
    val items: List<LauncherHomeItemUiModel>,
    val draggedIndex: Int,
    val updatedTargetIndex: Int,
    val updatedFolderStableId: Long
)

internal object LauncherFolderDropCommitResolver {
    fun resolve(
        items: List<LauncherHomeItemUiModel>,
        draggedStableId: Long,
        targetStableId: Long,
        newFolderId: () -> String
    ): LauncherFolderDropCommitResult? {
        val draggedIndex = items.indexOfFirst { item -> item.stableId == draggedStableId }
        val targetIndex = items.indexOfFirst { item -> item.stableId == targetStableId }
        if (draggedIndex == -1 || targetIndex == -1 || draggedIndex == targetIndex) return null

        val dragged = items[draggedIndex] as? LauncherHomeItemUiModel.App ?: return null
        val targetItem = items[targetIndex]
        val updatedTarget = when (targetItem) {
            is LauncherHomeItemUiModel.App -> LauncherHomeItemUiModel.Folder(
                id = newFolderId(),
                title = LauncherHomeLayoutBuilder.DEFAULT_FOLDER_TITLE,
                apps = listOf(targetItem.iconItem, dragged.iconItem)
            )

            is LauncherHomeItemUiModel.Folder -> {
                if (targetItem.apps.any { item -> item.app.iconKey == dragged.iconItem.app.iconKey }) {
                    return null
                }
                targetItem.copy(apps = targetItem.apps + dragged.iconItem)
            }

            is LauncherHomeItemUiModel.Placeholder -> return null
        }

        val newItems = items.toMutableList()
        newItems[draggedIndex] = LauncherHomeItemUiModel.Placeholder.forGridIndex(draggedIndex)
        newItems[targetIndex] = updatedTarget

        return LauncherFolderDropCommitResult(
            items = LauncherHomeLayoutBuilder.normalize(newItems),
            draggedIndex = draggedIndex,
            updatedTargetIndex = targetIndex,
            updatedFolderStableId = updatedTarget.stableId
        )
    }
}

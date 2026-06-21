package com.vhmsoft.launcherios26.ui.launcher.workspace

internal object LauncherHomeDragPreviewPlanner {
    data class Move(
        val stableId: Long,
        val fromIndex: Int,
        val toIndex: Int
    )

    fun moves(
        basePageItems: List<LauncherHomeItemUiModel>,
        previewPageItems: List<LauncherHomeItemUiModel>
    ): List<Move> {
        val previewPositions = previewPageItems
            .mapIndexedNotNull { index, item ->
                item.stableId.takeIf { item.canMoveAsPreviewIcon() }?.let { stableId ->
                    stableId to index
                }
            }
            .toMap()

        return basePageItems.mapIndexedNotNull { index, item ->
            if (!item.canMoveAsPreviewIcon()) return@mapIndexedNotNull null

            val targetIndex = previewPositions[item.stableId] ?: return@mapIndexedNotNull null
            if (targetIndex == index) return@mapIndexedNotNull null
            Move(
                stableId = item.stableId,
                fromIndex = index,
                toIndex = targetIndex
            )
        }
    }

    private fun LauncherHomeItemUiModel.canMoveAsPreviewIcon(): Boolean {
        return this !is LauncherHomeItemUiModel.Placeholder
    }
}

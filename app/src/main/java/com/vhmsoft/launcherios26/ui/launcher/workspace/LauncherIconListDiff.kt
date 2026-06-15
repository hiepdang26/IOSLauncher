package com.vhmsoft.launcherios26.ui.launcher.workspace

object LauncherIconListDiff {
    fun between(
        oldItems: List<LauncherHomeItemUiModel>,
        newItems: List<LauncherHomeItemUiModel>
    ): Result {
        if (oldItems.size != newItems.size) {
            return Result(
                requiresFullRefresh = true,
                changedIndices = emptyList()
            )
        }

        return Result(
            requiresFullRefresh = false,
            changedIndices = oldItems.indices.filter { index ->
                oldItems[index] != newItems[index]
            }
        )
    }

    data class Result(
        val requiresFullRefresh: Boolean,
        val changedIndices: List<Int>
    )
}

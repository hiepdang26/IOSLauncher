package com.vhmsoft.launcherios26.ui.launcher.workspace

internal object LauncherPageDiff {
    data class Result(
        val pageCountChanged: Boolean,
        val changedIndices: List<Int>
    )

    fun between(
        oldPages: List<List<LauncherHomeItemUiModel>>,
        newPages: List<List<LauncherHomeItemUiModel>>
    ): Result {
        if (oldPages.size != newPages.size) {
            return Result(pageCountChanged = true, changedIndices = emptyList())
        }

        return Result(
            pageCountChanged = false,
            changedIndices = newPages.indices.filter { index ->
                oldPages[index] != newPages[index]
            }
        )
    }
}

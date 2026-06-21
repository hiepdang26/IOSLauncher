package com.vhmsoft.launcherios26.ui.launcher.workspace

internal data class LauncherHomePageCountUpdate(
    val changedPages: List<Int>,
    val insertedPageStart: Int?,
    val insertedPageCount: Int,
    val removedPageStart: Int?,
    val removedPageCount: Int
)

internal object LauncherHomePageCountUpdatePolicy {
    fun plan(
        oldPages: List<List<LauncherHomeItemUiModel>>,
        newPages: List<List<LauncherHomeItemUiModel>>,
        focusedPage: Int?
    ): LauncherHomePageCountUpdate {
        val oldPageCount = oldPages.size
        val newPageCount = newPages.size
        val commonChangedPages = (0 until minOf(oldPageCount, newPageCount))
            .filter { index -> oldPages[index] != newPages[index] }
        val changedPages = (commonChangedPages + listOfNotNull(focusedPage))
            .filter { page -> page in newPages.indices }
            .distinct()

        return LauncherHomePageCountUpdate(
            changedPages = changedPages,
            insertedPageStart = oldPageCount.takeIf { newPageCount > oldPageCount },
            insertedPageCount = (newPageCount - oldPageCount).coerceAtLeast(0),
            removedPageStart = newPageCount.takeIf { newPageCount < oldPageCount },
            removedPageCount = (oldPageCount - newPageCount).coerceAtLeast(0)
        )
    }
}

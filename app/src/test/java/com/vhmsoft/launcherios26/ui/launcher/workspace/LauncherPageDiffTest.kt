package com.vhmsoft.launcherios26.ui.launcher.workspace

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherPageDiffTest {
    @Test
    fun changedIndices_returnsOnlyPagesWhoseItemsChangedWhenPageCountIsSame() {
        val oldPages = listOf(
            listOf(placeholder(0), placeholder(1)),
            listOf(placeholder(2), placeholder(3))
        )
        val newPages = listOf(
            listOf(placeholder(0), placeholder(1)),
            listOf(placeholder(2), placeholder(4))
        )

        val diff = LauncherPageDiff.between(oldPages, newPages)

        assertFalse(diff.pageCountChanged)
        assertEquals(listOf(1), diff.changedIndices)
    }

    @Test
    fun changedIndices_marksPageCountChangedWhenNewPageIsAdded() {
        val oldPages = listOf(listOf(placeholder(0), placeholder(1)))
        val newPages = listOf(
            listOf(placeholder(0), placeholder(1)),
            listOf(placeholder(2))
        )

        val diff = LauncherPageDiff.between(oldPages, newPages)

        assertTrue(diff.pageCountChanged)
        assertEquals(emptyList<Int>(), diff.changedIndices)
    }

    private fun placeholder(index: Int): LauncherHomeItemUiModel.Placeholder {
        return LauncherHomeItemUiModel.Placeholder.forGridIndex(index)
    }
}

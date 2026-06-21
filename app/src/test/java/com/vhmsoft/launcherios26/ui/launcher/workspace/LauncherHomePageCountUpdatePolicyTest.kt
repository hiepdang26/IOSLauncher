package com.vhmsoft.launcherios26.ui.launcher.workspace

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class LauncherHomePageCountUpdatePolicyTest {
    @Test
    fun plan_removesOnlyTrailingAdapterPageWhenMiddlePageCompactsAway() {
        val oldPages = listOf(
            listOf(placeholder(0), placeholder(1)),
            listOf(placeholder(2), placeholder(3)),
            listOf(placeholder(4), placeholder(5))
        )
        val newPages = listOf(
            oldPages[0],
            oldPages[2]
        )

        val update = LauncherHomePageCountUpdatePolicy.plan(
            oldPages = oldPages,
            newPages = newPages,
            focusedPage = null
        )

        assertEquals(listOf(1), update.changedPages)
        assertEquals(2, update.removedPageStart)
        assertEquals(1, update.removedPageCount)
        assertNull(update.insertedPageStart)
        assertEquals(0, update.insertedPageCount)
    }

    @Test
    fun plan_insertsOnlyTrailingAdapterPageWhenPageAppearsInMiddle() {
        val oldPages = listOf(
            listOf(placeholder(0), placeholder(1)),
            listOf(placeholder(4), placeholder(5))
        )
        val insertedPage = listOf(placeholder(2), placeholder(3))
        val newPages = listOf(
            oldPages[0],
            insertedPage,
            oldPages[1]
        )

        val update = LauncherHomePageCountUpdatePolicy.plan(
            oldPages = oldPages,
            newPages = newPages,
            focusedPage = null
        )

        assertEquals(listOf(1), update.changedPages)
        assertEquals(2, update.insertedPageStart)
        assertEquals(1, update.insertedPageCount)
        assertNull(update.removedPageStart)
        assertEquals(0, update.removedPageCount)
    }

    @Test
    fun plan_includesFocusedPageWhenItStillExists() {
        val oldPages = listOf(
            listOf(placeholder(0)),
            listOf(placeholder(1))
        )
        val newPages = listOf(oldPages[0])

        val update = LauncherHomePageCountUpdatePolicy.plan(
            oldPages = oldPages,
            newPages = newPages,
            focusedPage = 0
        )

        assertEquals(listOf(0), update.changedPages)
    }

    private fun placeholder(index: Int): LauncherHomeItemUiModel.Placeholder {
        return LauncherHomeItemUiModel.Placeholder.forGridIndex(index)
    }
}

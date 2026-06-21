package com.vhmsoft.launcherios26.ui.launcher.workspace

import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable
import com.vhmsoft.launcherios26.data.model.LauncherApp
import com.vhmsoft.launcherios26.data.model.LauncherAppCategory
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherHomeScreenGridPolicyTest {
    @Test
    fun pageSize_usesRowsFromHomeScreenGrid() {
        assertEquals(24, LauncherHomeScreenGridPolicy.pageSize(rows = 6, columns = 4))
        assertEquals(20, LauncherHomeScreenGridPolicy.pageSize(rows = 5, columns = 4))
    }

    @Test
    fun replacePage_constrainsChangedPageToGridCapacityAndCarriesOverflowForward() {
        val firstPage = (0 until 24).map { index -> placeholder(index) }
        val secondPage = listOf(placeholder(100), placeholder(101))
        val changedPage = (200 until 225).map { index -> placeholder(index) }

        val flattened = LauncherHomeScreenGridPolicy.replacePage(
            pages = listOf(firstPage, secondPage),
            pagePosition = 0,
            pageItems = changedPage,
            pageSize = 24
        )

        assertEquals(changedPage.take(24), flattened.take(24))
        assertEquals(changedPage[24], flattened[24])
        assertEquals(secondPage, flattened.drop(25))
    }

    @Test
    fun removeEmptyPages_removesPagesWithoutHomeIcons() {
        val firstPage = (0 until 24).map { index ->
            if (index == 0) LauncherHomeItemUiModel.App(appItem("Photos")) else placeholder(index)
        }
        val emptyPage = (24 until 48).map { index -> placeholder(index) }
        val thirdPage = (48 until 72).map { index ->
            if (index == 50) LauncherHomeItemUiModel.App(appItem("Maps")) else placeholder(index)
        }

        val cleaned = LauncherHomeScreenGridPolicy.removeEmptyPages(
            items = firstPage + emptyPage + thirdPage,
            pageSize = 24
        )

        assertEquals(48, cleaned.size)
        assertEquals("Photos", cleaned[0].label)
        assertEquals("Maps", cleaned[26].label)
    }

    @Test
    fun removeEmptyPages_returnsEmptyListWhenOnlyPlaceholdersRemain() {
        val cleaned = LauncherHomeScreenGridPolicy.removeEmptyPages(
            items = (0 until 24).map { index -> placeholder(index) },
            pageSize = 24
        )

        assertEquals(emptyList<LauncherHomeItemUiModel>(), cleaned)
    }

    @Test
    fun padToFullPages_keepsEveryVisiblePageAtGridCapacity() {
        val photos = LauncherHomeItemUiModel.App(appItem("Photos"))

        val padded = LauncherHomeScreenGridPolicy.padToFullPages(
            items = listOf(photos),
            pageSize = 24
        )

        assertEquals(24, padded.size)
        assertEquals(photos, padded[0])
        assertTrue(padded.drop(1).all { item -> item is LauncherHomeItemUiModel.Placeholder })
    }

    @Test
    fun padToFullPages_removesEmptyPagesBeforeLaterIconPages() {
        val firstPage = (0 until 24).map { index ->
            if (index == 0) LauncherHomeItemUiModel.App(appItem("Photos")) else placeholder(index)
        }
        val emptyPage = (24 until 48).map { index -> placeholder(index) }
        val thirdPage = (48 until 72).map { index ->
            if (index == 50) LauncherHomeItemUiModel.App(appItem("Maps")) else placeholder(index)
        }

        val padded = LauncherHomeScreenGridPolicy.padToFullPages(
            items = firstPage + emptyPage + thirdPage,
            pageSize = 24
        )

        assertEquals(48, padded.size)
        assertEquals("Photos", padded[0].label)
        assertEquals("Maps", padded[26].label)
    }

    @Test
    fun padToFullPages_canPreserveTemporaryEmptyPagesForDragPreview() {
        val firstPage = (0 until 24).map { index ->
            if (index == 0) LauncherHomeItemUiModel.App(appItem("Photos")) else placeholder(index)
        }
        val emptyPage = (24 until 48).map { index -> placeholder(index) }

        val padded = LauncherHomeScreenGridPolicy.padToFullPages(
            items = firstPage + emptyPage,
            pageSize = 24,
            preserveEmptyPages = true
        )

        assertEquals(48, padded.size)
        assertTrue(padded.drop(24).all { item -> item is LauncherHomeItemUiModel.Placeholder })
    }

    @Test
    fun ensurePageExists_createsFullBlankPageForTheRequestedPage() {
        val photos = LauncherHomeItemUiModel.App(appItem("Photos"))

        val padded = LauncherHomeScreenGridPolicy.ensurePageExists(
            items = listOf(photos),
            page = 1,
            pageSize = 24
        )

        assertEquals(48, padded.size)
        assertEquals(photos, padded[0])
        assertTrue(padded.drop(1).all { item -> item is LauncherHomeItemUiModel.Placeholder })
    }

    @Test
    fun blankDropPosition_capsFinalPositionToLastSlotInSelectedGridRows() {
        val position = LauncherHomeScreenGridPolicy.blankDropPosition(
            draggedCenterX = 390f,
            draggedCenterY = 590f,
            gridWidth = 400,
            gridHeight = 600,
            rows = 6,
            columns = 4,
            itemCount = 25
        )

        assertEquals(23, position)
    }

    @Test
    fun blankDropPosition_returnsPlaceholderCellInsideCurrentItems() {
        val position = LauncherHomeScreenGridPolicy.blankDropPosition(
            draggedCenterX = 150f,
            draggedCenterY = 150f,
            gridWidth = 400,
            gridHeight = 600,
            rows = 6,
            columns = 4,
            itemCount = 24,
            isBlankAtPosition = { index -> index == 5 }
        )

        assertEquals(5, position)
    }

    @Test
    fun blankDropPosition_ignoresOccupiedCellInsideCurrentItems() {
        val position = LauncherHomeScreenGridPolicy.blankDropPosition(
            draggedCenterX = 150f,
            draggedCenterY = 150f,
            gridWidth = 400,
            gridHeight = 600,
            rows = 6,
            columns = 4,
            itemCount = 24,
            isBlankAtPosition = { false }
        )

        assertEquals(LauncherHomeScreenGridPolicy.NO_POSITION, position)
    }

    @Test
    fun blankDropPosition_returnsDeepBlankCellPastCurrentItemCountWithinGridCapacity() {
        val position = LauncherHomeScreenGridPolicy.blankDropPosition(
            draggedCenterX = 250f,
            draggedCenterY = 550f,
            gridWidth = 400,
            gridHeight = 600,
            rows = 6,
            columns = 4,
            itemCount = 10
        )

        assertEquals(22, position)
    }

    private fun placeholder(index: Int): LauncherHomeItemUiModel.Placeholder {
        return LauncherHomeItemUiModel.Placeholder.forGridIndex(index)
    }

    private fun appItem(label: String): LauncherIconUiModel {
        val app = LauncherApp(
            label = label,
            packageName = "test.${label.lowercase()}",
            className = "MainActivity",
            iconKey = label
        )
        return LauncherIconUiModel(app, TestDrawable, LauncherAppCategory.OTHER)
    }

    @Suppress("OVERRIDE_DEPRECATION")
    private object TestDrawable : Drawable() {
        override fun draw(canvas: Canvas) = Unit
        override fun setAlpha(alpha: Int) = Unit
        @Suppress("DEPRECATION")
        override fun setColorFilter(colorFilter: ColorFilter?) = Unit
        @Suppress("DEPRECATION")
        override fun getOpacity(): Int = PixelFormat.TRANSLUCENT
    }
}

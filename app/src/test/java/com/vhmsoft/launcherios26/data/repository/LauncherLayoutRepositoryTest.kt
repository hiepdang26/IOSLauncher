package com.vhmsoft.launcherios26.data.repository

import android.widget.GridLayout
import com.vhmsoft.launcherios26.core.database.model.WidgetItem
import com.vhmsoft.launcherios26.data.source.local.LauncherLayoutLocalDataSource
import io.reactivex.Single
import org.junit.Assert.assertEquals
import org.junit.Assert.assertSame
import org.junit.Test
import sun.misc.Unsafe

class LauncherLayoutRepositoryTest {
    @Test
    fun saveLayouts_delegatesToLocalDataSource() {
        val pages = emptyList<GridLayout>()
        val dock = stubGridLayout()
        val localDataSource = FakeLocalDataSource()
        val repository = LauncherLayoutRepositoryImpl(localDataSource)

        repository.saveLayouts(pages, dock)

        assertEquals(1, localDataSource.saveLayoutsCount)
        assertSame(pages, localDataSource.savedPages)
        assertSame(dock, localDataSource.savedDock)
    }

    @Test
    fun widgetOperations_delegateToLocalDataSource() {
        val widgetItem = WidgetItem(42)
        val widgetOrder = listOf(42, 43)
        val widgetIds = intArrayOf(42, 43)
        val widgetsResult = Single.just(listOf(widgetItem))
        val localDataSource = FakeLocalDataSource(widgetsResult)
        val repository = LauncherLayoutRepositoryImpl(localDataSource)

        repository.insertWidget(widgetItem)
        repository.saveWidgetHeight(id = 42, height = 7)
        repository.saveWidgetOrder(widgetOrder)
        repository.removeWidget(43)
        val returnedWidgets = repository.getWidgets(widgetIds)

        assertSame(widgetItem, localDataSource.insertedWidget)
        assertEquals(42, localDataSource.savedWidgetHeightId)
        assertEquals(7, localDataSource.savedWidgetHeight)
        assertSame(widgetOrder, localDataSource.savedWidgetOrder)
        assertEquals(43, localDataSource.removedWidgetId)
        assertSame(widgetIds, localDataSource.requestedWidgetIds)
        assertSame(widgetsResult, returnedWidgets)
    }

    @Test
    fun launcherItemOperations_delegateToLocalDataSource() {
        val localDataSource = FakeLocalDataSource()
        val repository = LauncherLayoutRepositoryImpl(localDataSource)

        repository.removeLauncherItem("item-1")
        repository.removeLauncherPackage("com.example.app")

        assertEquals("item-1", localDataSource.removedLauncherItemId)
        assertEquals("com.example.app", localDataSource.removedLauncherPackageName)
    }

    private class FakeLocalDataSource(
        private val widgetsResult: Single<List<WidgetItem>> = Single.just(emptyList())
    ) : LauncherLayoutLocalDataSource {
        var saveLayoutsCount = 0
        var savedPages: List<GridLayout>? = null
        var savedDock: GridLayout? = null
        var insertedWidget: WidgetItem? = null
        var savedWidgetHeightId: Int? = null
        var savedWidgetHeight: Int? = null
        var savedWidgetOrder: List<Int>? = null
        var removedWidgetId: Int? = null
        var requestedWidgetIds: IntArray? = null
        var removedLauncherItemId: String? = null
        var removedLauncherPackageName: String? = null

        override fun saveLayouts(pages: List<GridLayout>, dock: GridLayout) {
            saveLayoutsCount += 1
            savedPages = pages
            savedDock = dock
        }

        override fun insertWidget(widgetItem: WidgetItem) {
            insertedWidget = widgetItem
        }

        override fun saveWidgetHeight(id: Int, height: Int) {
            savedWidgetHeightId = id
            savedWidgetHeight = height
        }

        override fun saveWidgetOrder(widgetIds: List<Int>) {
            savedWidgetOrder = widgetIds
        }

        override fun removeWidget(id: Int) {
            removedWidgetId = id
        }

        override fun getWidgets(widgetIds: IntArray): Single<List<WidgetItem>> {
            requestedWidgetIds = widgetIds
            return widgetsResult
        }

        override fun removeLauncherItem(itemId: String) {
            removedLauncherItemId = itemId
        }

        override fun removeLauncherPackage(packageName: String) {
            removedLauncherPackageName = packageName
        }
    }

    private companion object {
        fun stubGridLayout(): GridLayout {
            val field = Unsafe::class.java.getDeclaredField("theUnsafe")
            field.isAccessible = true
            return (field.get(null) as Unsafe).allocateInstance(GridLayout::class.java) as GridLayout
        }
    }
}

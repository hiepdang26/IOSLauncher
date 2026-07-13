package com.vhmsoft.launcherios26.data.repository

import android.widget.GridLayout
import com.vhmsoft.launcherios26.core.database.model.WidgetItem
import com.vhmsoft.launcherios26.data.source.local.LauncherLayoutLocalDataSource
import io.reactivex.Single

class LauncherLayoutRepositoryImpl(
    private val localDataSource: LauncherLayoutLocalDataSource
) : LauncherLayoutRepository {
    override fun saveLayouts(pages: List<GridLayout>, dock: GridLayout) {
        localDataSource.saveLayouts(pages, dock)
    }

    override fun insertWidget(widgetItem: WidgetItem) {
        localDataSource.insertWidget(widgetItem)
    }

    override fun saveWidgetHeight(id: Int, height: Int) {
        localDataSource.saveWidgetHeight(id, height)
    }

    override fun saveWidgetOrder(widgetIds: List<Int>) {
        localDataSource.saveWidgetOrder(widgetIds)
    }

    override fun removeWidget(id: Int) {
        localDataSource.removeWidget(id)
    }

    override fun getWidgets(widgetIds: IntArray): Single<List<WidgetItem>> {
        return localDataSource.getWidgets(widgetIds)
    }

    override fun removeLauncherItem(itemId: String) {
        localDataSource.removeLauncherItem(itemId)
    }

    override fun removeLauncherPackage(packageName: String) {
        localDataSource.removeLauncherPackage(packageName)
    }
}

package com.vhmsoft.launcherios26.data.source.local

import android.content.Context
import android.widget.GridLayout
import com.vhmsoft.launcherios26.core.database.DatabaseManager
import com.vhmsoft.launcherios26.core.database.model.WidgetItem
import io.reactivex.Single

class LauncherLayoutLocalDataSourceImpl(context: Context) : LauncherLayoutLocalDataSource {
    private val appContext = context.applicationContext

    override fun saveLayouts(pages: List<GridLayout>, dock: GridLayout) {
        DatabaseManager.getManager(appContext).saveLayouts(pages, dock)
    }

    override fun insertWidget(widgetItem: WidgetItem) {
        DatabaseManager.getManager(appContext).insertWidget(widgetItem)
    }

    override fun saveWidgetHeight(id: Int, height: Int) {
        DatabaseManager.getManager(appContext).saveWidgetHeight(id, height)
    }

    override fun saveWidgetOrder(widgetIds: List<Int>) {
        DatabaseManager.getManager(appContext).saveWidgetOrder(widgetIds)
    }

    override fun removeWidget(id: Int) {
        DatabaseManager.getManager(appContext).removeWidget(id)
    }

    override fun getWidgets(widgetIds: IntArray): Single<List<WidgetItem>> {
        return DatabaseManager.getManager(appContext).getWidgets(widgetIds)
    }

    override fun removeLauncherItem(itemId: String) {
        DatabaseManager.getManager(appContext).removeLauncherItem(itemId)
    }

    override fun removeLauncherPackage(packageName: String) {
        DatabaseManager.getManager(appContext).removeLauncherPackage(packageName)
    }
}

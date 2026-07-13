package com.vhmsoft.launcherios26.data.repository

import android.widget.GridLayout
import com.vhmsoft.launcherios26.core.database.model.WidgetItem
import io.reactivex.Single

interface LauncherLayoutRepository {
    fun saveLayouts(pages: List<GridLayout>, dock: GridLayout)
    fun insertWidget(widgetItem: WidgetItem)
    fun saveWidgetHeight(id: Int, height: Int)
    fun saveWidgetOrder(widgetIds: List<Int>)
    fun removeWidget(id: Int)
    fun getWidgets(widgetIds: IntArray): Single<List<WidgetItem>>
    fun removeLauncherItem(itemId: String)
    fun removeLauncherPackage(packageName: String)
}

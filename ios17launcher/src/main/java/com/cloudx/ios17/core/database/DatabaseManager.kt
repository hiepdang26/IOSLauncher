package com.cloudx.ios17.core.database

import android.content.Context
import android.widget.GridLayout
import com.cloudx.ios17.core.customviews.BlissFrameLayout
import com.cloudx.ios17.core.database.model.FolderItem
import com.cloudx.ios17.core.database.model.LauncherItem
import com.cloudx.ios17.core.database.model.WidgetItem
import com.cloudx.ios17.core.executors.AppExecutors
import com.cloudx.ios17.core.utils.Constants
import io.reactivex.Single
import java.util.Comparator
import java.util.HashSet

class DatabaseManager private constructor(private val mContext: Context) {

    private val mAppExecutors = AppExecutors.getInstance()

    fun removeLauncherItem(itemId: String) {
        mAppExecutors.diskIO().execute { LauncherDB.getDatabase(mContext).launcherDao().delete(itemId) }
    }

    fun saveLayouts(pages: List<GridLayout>, dock: GridLayout) {
        val tempPages = pages
        val tempDock = dock
        mAppExecutors.diskIO().execute { saveLauncherItems(tempPages, tempDock) }
    }

    private fun saveLauncherItems(pages: List<GridLayout>, dock: GridLayout) {
        val items = ArrayList<LauncherItem>()
        for (i in 0 until dock.childCount) {
            val launcherItem = (dock.getChildAt(i) as BlissFrameLayout).launcherItem
            if (launcherItem.itemType == Constants.ITEM_TYPE_FOLDER) {
                val folderItem = launcherItem as FolderItem
                folderItem.screenId = -1
                folderItem.cell = i
                folderItem.container = Constants.CONTAINER_HOTSEAT.toLong()
                items.add(launcherItem)

                val folderItems = folderItem.items.orEmpty()
                for (j in folderItems.indices) {
                    val item = folderItems[j]
                    item.screenId = -1
                    item.container = folderItem.id.toLong()
                    item.cell = j
                    items.add(item)
                }
            } else {
                launcherItem.screenId = -1
                launcherItem.container = Constants.CONTAINER_HOTSEAT.toLong()
                launcherItem.cell = i
                items.add(launcherItem)
            }
        }

        for (i in pages.indices) {
            val gridLayout = pages[i]
            for (j in 0 until gridLayout.childCount) {
                val launcherItem = (gridLayout.getChildAt(j) as BlissFrameLayout).launcherItem
                if (launcherItem.itemType == Constants.ITEM_TYPE_FOLDER) {
                    val folderItem = launcherItem as FolderItem
                    folderItem.screenId = i.toLong()
                    folderItem.cell = j
                    folderItem.container = Constants.CONTAINER_DESKTOP.toLong()
                    items.add(folderItem)

                    val folderItems = folderItem.items.orEmpty()
                    for (k in folderItems.indices) {
                        val item = folderItems[k]
                        item.screenId = -1
                        item.container = folderItem.id.toLong()
                        item.cell = k
                        items.add(item)
                    }
                } else {
                    launcherItem.screenId = i.toLong()
                    launcherItem.container = Constants.CONTAINER_DESKTOP.toLong()
                    launcherItem.cell = j
                    items.add(launcherItem)
                }
            }
        }
        LauncherDB.getDatabase(mContext).launcherDao().insertAll(items)
    }

    fun removeShortcut(name: String) {
        mAppExecutors.diskIO().execute { LauncherDB.getDatabase(mContext).launcherDao().deleteShortcut(name) }
    }

    // Already invoked in a disk io thread, so no need to execute in separate thread here.
    fun migrateComponent(oldComponentName: String, newComponentName: String) {
        LauncherDB.getDatabase(mContext).launcherDao().delete(newComponentName)
        LauncherDB.getDatabase(mContext).launcherDao().updateComponent(oldComponentName, newComponentName)
    }

    fun insertWidget(widgetItem: WidgetItem) {
        mAppExecutors.diskIO().execute { LauncherDB.getDatabase(mContext).widgetDao().insert(widgetItem) }
    }

    fun saveWidgetHeight(id: Int, height: Int) {
        mAppExecutors.diskIO().execute { LauncherDB.getDatabase(mContext).widgetDao().updateHeight(id, height) }
    }

    fun saveWidgetOrder(widgetIds: List<Int>) {
        mAppExecutors.diskIO().execute {
            val widgetDao = LauncherDB.getDatabase(mContext).widgetDao()
            widgetIds.forEachIndexed { index, id ->
                widgetDao.updateOrder(id, index)
            }
        }
    }

    fun removeWidget(id: Int) {
        mAppExecutors.diskIO().execute { LauncherDB.getDatabase(mContext).widgetDao().delete(id) }
    }

    fun getWidgets(widgetIds: IntArray): Single<List<WidgetItem>> {
        return Single.defer {
            val missingIds = HashSet<Int>()
            for (widgetId in widgetIds) {
                missingIds.add(widgetId)
            }
            val widgetDao = LauncherDB.getDatabase(mContext).widgetDao()
            val widgets = widgetDao.getAll().toMutableList()
            for (widget in widgets) {
                missingIds.remove(widget.id)
            }
            for (id in missingIds) {
                val item = WidgetItem(id)
                widgets.add(item)
                widgetDao.insert(item)
            }
            widgets.sortWith(
                Comparator.comparingInt<WidgetItem> { it.order }.thenComparingInt { it.id }
            )
            Single.just(widgets)
        }
    }

    companion object {
        private const val TAG = "DatabaseManager"

        @Volatile
        private var INSTANCE: DatabaseManager? = null

        @JvmStatic
        fun getManager(context: Context): DatabaseManager {
            return INSTANCE ?: synchronized(DatabaseManager::class.java) {
                INSTANCE ?: DatabaseManager(context).also { INSTANCE = it }
            }
        }
    }
}

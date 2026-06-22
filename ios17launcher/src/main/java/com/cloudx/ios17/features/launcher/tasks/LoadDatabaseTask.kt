package com.cloudx.ios17.features.launcher.tasks

import android.os.AsyncTask
import com.cloudx.ios17.core.database.LauncherDB
import com.cloudx.ios17.core.database.model.LauncherItem
import com.cloudx.ios17.core.migrate.Migration
import com.cloudx.ios17.features.launcher.AppProvider
import com.cloudx.ios17.features.widgets.WidgetMigration

class LoadDatabaseTask : AsyncTask<Void, Void, List<LauncherItem>>() {
    private var mAppProvider: AppProvider? = null

    fun setAppProvider(appProvider: AppProvider) {
        mAppProvider = appProvider
    }

    override fun doInBackground(vararg params: Void?): List<LauncherItem> {
        val context = mAppProvider!!.context
        Migration.migrateSafely(context)
        WidgetMigration.migrateAdvancedPrivacy(context)
        return LauncherDB.getDatabase(context).launcherDao().getAllItems()
    }

    override fun onPostExecute(launcherItems: List<LauncherItem>) {
        super.onPostExecute(launcherItems)
        mAppProvider?.loadDatabaseOver(launcherItems)
    }
}

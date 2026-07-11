package com.vhmsoft.launcherios26.features.launcher.tasks

import android.os.AsyncTask
import com.vhmsoft.launcherios26.core.database.LauncherDB
import com.vhmsoft.launcherios26.core.database.model.LauncherItem
import com.vhmsoft.launcherios26.core.migrate.Migration
import com.vhmsoft.launcherios26.features.launcher.AppProvider
import com.vhmsoft.launcherios26.features.widgets.WidgetMigration

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

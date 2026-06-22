package com.cloudx.ios17.features.launcher.tasks

import android.os.AsyncTask
import com.cloudx.ios17.core.database.model.ApplicationItem
import com.cloudx.ios17.core.utils.AppUtils
import com.cloudx.ios17.features.launcher.AppProvider

class LoadAppsTask : AsyncTask<Void, Void, Map<String, ApplicationItem>>() {
    private var mAppProvider: AppProvider? = null

    fun setAppProvider(appProvider: AppProvider) {
        mAppProvider = appProvider
    }

    override fun doInBackground(vararg params: Void?): Map<String, ApplicationItem> =
        AppUtils.loadAll(mAppProvider!!.context)

    override fun onPostExecute(appItemPair: Map<String, ApplicationItem>) {
        super.onPostExecute(appItemPair)
        mAppProvider?.loadAppsOver(appItemPair)
    }
}

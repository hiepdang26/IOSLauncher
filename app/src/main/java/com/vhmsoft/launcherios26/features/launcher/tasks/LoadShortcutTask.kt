package com.vhmsoft.launcherios26.features.launcher.tasks

import android.os.AsyncTask
import android.os.Process
import com.vhmsoft.launcherios26.features.launcher.AppProvider
import com.vhmsoft.launcherios26.features.shortcuts.DeepShortcutManager
import com.vhmsoft.launcherios26.features.shortcuts.ShortcutInfoCompat
import timber.log.Timber

class LoadShortcutTask : AsyncTask<Void, Void, Map<String, ShortcutInfoCompat>>() {
    private var mAppProvider: AppProvider? = null

    fun setAppProvider(appProvider: AppProvider) {
        mAppProvider = appProvider
    }

    override fun doInBackground(vararg params: Void?): Map<String, ShortcutInfoCompat> {
        val provider = mAppProvider!!
        val list = DeepShortcutManager.getInstance(provider.context)
            .queryForPinnedShortcuts(null, Process.myUserHandle())
        Timber.tag(TAG).i("doInBackground: %s", list.size)

        val shortcutInfoMap = HashMap<String, ShortcutInfoCompat>()
        for (shortcutInfoCompat in list) {
            shortcutInfoMap[shortcutInfoCompat.id] = shortcutInfoCompat
        }
        return shortcutInfoMap
    }

    override fun onPostExecute(shortcuts: Map<String, ShortcutInfoCompat>) {
        super.onPostExecute(shortcuts)
        mAppProvider?.loadShortcutsOver(shortcuts)
    }

    companion object {
        private const val TAG = "LoadShortcutTask"
    }
}

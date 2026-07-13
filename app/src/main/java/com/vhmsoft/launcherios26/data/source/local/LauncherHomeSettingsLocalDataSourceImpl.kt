package com.vhmsoft.launcherios26.data.source.local

import android.content.Context
import com.vhmsoft.launcherios26.core.LauncherHomeLayoutPreferences
import com.vhmsoft.launcherios26.core.LauncherHomeLayoutSettings

class LauncherHomeSettingsLocalDataSourceImpl(context: Context) : LauncherHomeSettingsLocalDataSource {
    private val appContext = context.applicationContext

    override fun readHomeLayoutSettings(): LauncherHomeLayoutSettings {
        return LauncherHomeLayoutPreferences.read(appContext)
    }

    override fun saveHomeIconSizeDp(iconSizeDp: Int) {
        appContext.getSharedPreferences(
            LauncherHomeLayoutPreferences.LAYOUT_PREFERENCES_NAME,
            Context.MODE_PRIVATE
        )
            .edit()
            .putInt(LauncherHomeLayoutPreferences.KEY_HOME_ICON_SIZE_DP, iconSizeDp)
            .apply()
    }

    override fun saveHomeGridRows(rows: Int) {
        appContext.getSharedPreferences(
            LauncherHomeLayoutPreferences.LAYOUT_PREFERENCES_NAME,
            Context.MODE_PRIVATE
        )
            .edit()
            .putInt(LauncherHomeLayoutPreferences.KEY_HOME_GRID_ROWS, rows)
            .apply()
    }

    override fun setAutoRearrangeApps(enabled: Boolean) {
        LauncherHomeLayoutPreferences.setAutoRearrangeApps(appContext, enabled)
    }

    override fun setDarkMode(enabled: Boolean) {
        LauncherHomeLayoutPreferences.setDarkMode(appContext, enabled)
    }
}

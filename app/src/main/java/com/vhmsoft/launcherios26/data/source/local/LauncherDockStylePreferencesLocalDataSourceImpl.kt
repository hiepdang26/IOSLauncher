package com.vhmsoft.launcherios26.data.source.local

import android.content.Context
import com.vhmsoft.launcherios26.core.customviews.DockStylePolicy

class LauncherDockStylePreferencesLocalDataSourceImpl(
    context: Context
) : LauncherDockStylePreferencesLocalDataSource {
    private val preferences = context.applicationContext.getSharedPreferences(
        DockStylePolicy.LAYOUT_PREFERENCES_NAME,
        Context.MODE_PRIVATE
    )

    override fun isIphone8StyleEnabled(): Boolean {
        return preferences.getBoolean(DockStylePolicy.KEY_LAYOUT_IPHONE8_STYLE, false)
    }

    override fun setIphone8StyleEnabled(enabled: Boolean) {
        preferences.edit()
            .putBoolean(DockStylePolicy.KEY_LAYOUT_IPHONE8_STYLE, enabled)
            .apply()
    }
}

package com.vhmsoft.launcherios26.data.source.local

import android.content.Context

class LauncherAppLibraryPreferencesLocalDataSourceImpl(
    context: Context
) : LauncherAppLibraryPreferencesLocalDataSource {
    private val preferences = context.applicationContext.getSharedPreferences(
        APP_LIBRARY_PREF_NAME,
        Context.MODE_PRIVATE
    )

    override fun getAllPreferences(): Map<String, *> {
        return preferences.all
    }

    private companion object {
        const val APP_LIBRARY_PREF_NAME = "ios_launcher_preferences"
    }
}

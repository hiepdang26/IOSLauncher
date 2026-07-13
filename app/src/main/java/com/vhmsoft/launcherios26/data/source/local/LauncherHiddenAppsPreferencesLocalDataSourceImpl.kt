package com.vhmsoft.launcherios26.data.source.local

import android.content.Context

class LauncherHiddenAppsPreferencesLocalDataSourceImpl(
    context: Context
) : LauncherHiddenAppsPreferencesLocalDataSource {
    private val appContext = context.applicationContext

    override fun getHiddenIdsValue(): Any? {
        return hiddenAppsPreferences().all[HIDDEN_APPS_PREF_IDS]
    }

    override fun getLegacyHiddenIdsValue(): Any? {
        return legacyHiddenAppsPreferences().all[LEGACY_HIDDEN_APPS_PREF_IDS]
    }

    override fun saveHiddenIdsValue(value: String) {
        hiddenAppsPreferences()
            .edit()
            .putString(HIDDEN_APPS_PREF_IDS, value)
            .apply()
    }

    override fun clearLegacyHiddenIds() {
        legacyHiddenAppsPreferences()
            .edit()
            .remove(LEGACY_HIDDEN_APPS_PREF_IDS)
            .apply()
    }

    private fun hiddenAppsPreferences() =
        appContext.getSharedPreferences(HIDDEN_APPS_PREF_NAME, Context.MODE_PRIVATE)

    private fun legacyHiddenAppsPreferences() =
        appContext.getSharedPreferences(LEGACY_HIDDEN_APPS_PREF_NAME, Context.MODE_PRIVATE)

    private companion object {
        const val HIDDEN_APPS_PREF_NAME = "ios_launcher_preferences"
        const val HIDDEN_APPS_PREF_IDS = "hidden_icon_keys"
        const val LEGACY_HIDDEN_APPS_PREF_NAME = "ios_launcher_hidden_apps"
        const val LEGACY_HIDDEN_APPS_PREF_IDS = "hidden_app_ids"
    }
}

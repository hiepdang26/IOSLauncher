package com.vhmsoft.launcherios26.data.source.local

interface LauncherHiddenAppsPreferencesLocalDataSource {
    fun getHiddenIdsValue(): Any?
    fun getLegacyHiddenIdsValue(): Any?
    fun saveHiddenIdsValue(value: String)
    fun clearLegacyHiddenIds()
}

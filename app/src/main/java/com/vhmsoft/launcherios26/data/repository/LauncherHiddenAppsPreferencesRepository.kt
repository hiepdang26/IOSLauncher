package com.vhmsoft.launcherios26.data.repository

interface LauncherHiddenAppsPreferencesRepository {
    fun getHiddenIdsValue(): Any?
    fun getLegacyHiddenIdsValue(): Any?
    fun saveHiddenIdsValue(value: String)
    fun clearLegacyHiddenIds()
}

package com.vhmsoft.launcherios26.data.repository

import com.vhmsoft.launcherios26.data.source.local.LauncherHiddenAppsPreferencesLocalDataSource

class LauncherHiddenAppsPreferencesRepositoryImpl(
    private val localDataSource: LauncherHiddenAppsPreferencesLocalDataSource
) : LauncherHiddenAppsPreferencesRepository {
    override fun getHiddenIdsValue(): Any? {
        return localDataSource.getHiddenIdsValue()
    }

    override fun getLegacyHiddenIdsValue(): Any? {
        return localDataSource.getLegacyHiddenIdsValue()
    }

    override fun saveHiddenIdsValue(value: String) {
        localDataSource.saveHiddenIdsValue(value)
    }

    override fun clearLegacyHiddenIds() {
        localDataSource.clearLegacyHiddenIds()
    }
}

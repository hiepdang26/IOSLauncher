package com.vhmsoft.launcherios26.data.repository

import com.vhmsoft.launcherios26.data.source.local.LauncherDockStylePreferencesLocalDataSource

class LauncherDockStylePreferencesRepositoryImpl(
    private val localDataSource: LauncherDockStylePreferencesLocalDataSource
) : LauncherDockStylePreferencesRepository {
    override fun isIphone8StyleEnabled(): Boolean {
        return localDataSource.isIphone8StyleEnabled()
    }

    override fun setIphone8StyleEnabled(enabled: Boolean) {
        localDataSource.setIphone8StyleEnabled(enabled)
    }
}

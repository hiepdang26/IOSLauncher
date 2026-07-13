package com.vhmsoft.launcherios26.data.repository

import com.vhmsoft.launcherios26.data.source.local.LauncherAppLibraryPreferencesLocalDataSource

class LauncherAppLibraryPreferencesRepositoryImpl(
    private val localDataSource: LauncherAppLibraryPreferencesLocalDataSource
) : LauncherAppLibraryPreferencesRepository {
    override fun getAllPreferences(): Map<String, *> {
        return localDataSource.getAllPreferences()
    }
}

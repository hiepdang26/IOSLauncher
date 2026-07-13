package com.vhmsoft.launcherios26.data.repository

interface LauncherAppLibraryPreferencesRepository {
    fun getAllPreferences(): Map<String, *>
}

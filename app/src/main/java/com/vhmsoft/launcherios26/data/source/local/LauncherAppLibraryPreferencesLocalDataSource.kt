package com.vhmsoft.launcherios26.data.source.local

interface LauncherAppLibraryPreferencesLocalDataSource {
    fun getAllPreferences(): Map<String, *>
}

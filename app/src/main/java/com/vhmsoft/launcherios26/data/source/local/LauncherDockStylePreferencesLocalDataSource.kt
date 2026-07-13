package com.vhmsoft.launcherios26.data.source.local

interface LauncherDockStylePreferencesLocalDataSource {
    fun isIphone8StyleEnabled(): Boolean
    fun setIphone8StyleEnabled(enabled: Boolean)
}

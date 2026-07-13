package com.vhmsoft.launcherios26.data.repository

interface LauncherDockStylePreferencesRepository {
    fun isIphone8StyleEnabled(): Boolean
    fun setIphone8StyleEnabled(enabled: Boolean)
}

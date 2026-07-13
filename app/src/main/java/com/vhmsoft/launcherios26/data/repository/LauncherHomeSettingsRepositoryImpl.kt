package com.vhmsoft.launcherios26.data.repository

import com.vhmsoft.launcherios26.core.LauncherHomeLayoutSettings
import com.vhmsoft.launcherios26.data.source.local.LauncherHomeSettingsLocalDataSource

class LauncherHomeSettingsRepositoryImpl(
    private val localDataSource: LauncherHomeSettingsLocalDataSource
) : LauncherHomeSettingsRepository {
    override fun readHomeLayoutSettings(): LauncherHomeLayoutSettings {
        return localDataSource.readHomeLayoutSettings()
    }

    override fun saveHomeIconSizeDp(iconSizeDp: Int) {
        localDataSource.saveHomeIconSizeDp(iconSizeDp)
    }

    override fun saveHomeGridRows(rows: Int) {
        localDataSource.saveHomeGridRows(rows)
    }

    override fun setAutoRearrangeApps(enabled: Boolean) {
        localDataSource.setAutoRearrangeApps(enabled)
    }

    override fun setDarkMode(enabled: Boolean) {
        localDataSource.setDarkMode(enabled)
    }
}

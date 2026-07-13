package com.vhmsoft.launcherios26.data.repository

import com.vhmsoft.launcherios26.core.LauncherHomeLayoutPreferences
import com.vhmsoft.launcherios26.core.LauncherHomeLayoutSettings
import com.vhmsoft.launcherios26.data.source.local.LauncherHomeSettingsLocalDataSource
import org.junit.Assert.assertEquals
import org.junit.Test

class LauncherHomeSettingsRepositoryTest {
    @Test
    fun readHomeLayoutSettings_returnsLocalSettings() {
        val settings = LauncherHomeLayoutPreferences.resolve(
            iconSizeDp = 64,
            rows = LauncherHomeLayoutPreferences.HOME_GRID_ROWS_5,
            autoArrangeApps = true,
            darkMode = true
        )
        val localDataSource = FakeLocalDataSource(settings)
        val repository = LauncherHomeSettingsRepositoryImpl(localDataSource)

        assertEquals(settings, repository.readHomeLayoutSettings())
        assertEquals(1, localDataSource.readCount)
    }

    @Test
    fun saveHomeLayoutSettings_delegatesToLocalDataSource() {
        val localDataSource = FakeLocalDataSource(defaultSettings())
        val repository = LauncherHomeSettingsRepositoryImpl(localDataSource)

        repository.saveHomeIconSizeDp(64)
        repository.saveHomeGridRows(LauncherHomeLayoutPreferences.HOME_GRID_ROWS_5)
        repository.setAutoRearrangeApps(true)
        repository.setDarkMode(true)

        assertEquals(64, localDataSource.savedIconSizeDp)
        assertEquals(LauncherHomeLayoutPreferences.HOME_GRID_ROWS_5, localDataSource.savedGridRows)
        assertEquals(true, localDataSource.savedAutoRearrangeApps)
        assertEquals(true, localDataSource.savedDarkMode)
    }

    private class FakeLocalDataSource(
        private val settings: LauncherHomeLayoutSettings
    ) : LauncherHomeSettingsLocalDataSource {
        var readCount = 0
        var savedIconSizeDp: Int? = null
        var savedGridRows: Int? = null
        var savedAutoRearrangeApps: Boolean? = null
        var savedDarkMode: Boolean? = null

        override fun readHomeLayoutSettings(): LauncherHomeLayoutSettings {
            readCount += 1
            return settings
        }

        override fun saveHomeIconSizeDp(iconSizeDp: Int) {
            savedIconSizeDp = iconSizeDp
        }

        override fun saveHomeGridRows(rows: Int) {
            savedGridRows = rows
        }

        override fun setAutoRearrangeApps(enabled: Boolean) {
            savedAutoRearrangeApps = enabled
        }

        override fun setDarkMode(enabled: Boolean) {
            savedDarkMode = enabled
        }
    }

    private companion object {
        fun defaultSettings(): LauncherHomeLayoutSettings {
            return LauncherHomeLayoutPreferences.resolve(
                iconSizeDp = LauncherHomeLayoutPreferences.DEFAULT_HOME_ICON_SIZE_DP,
                rows = LauncherHomeLayoutPreferences.DEFAULT_HOME_GRID_ROWS
            )
        }
    }
}

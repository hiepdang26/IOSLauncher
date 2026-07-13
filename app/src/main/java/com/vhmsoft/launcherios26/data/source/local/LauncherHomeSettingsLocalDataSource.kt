package com.vhmsoft.launcherios26.data.source.local

import com.vhmsoft.launcherios26.core.LauncherHomeLayoutSettings

interface LauncherHomeSettingsLocalDataSource {
    fun readHomeLayoutSettings(): LauncherHomeLayoutSettings
    fun saveHomeIconSizeDp(iconSizeDp: Int)
    fun saveHomeGridRows(rows: Int)
    fun setAutoRearrangeApps(enabled: Boolean)
    fun setDarkMode(enabled: Boolean)
}

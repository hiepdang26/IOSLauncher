package com.vhmsoft.launcherios26.data.repository

import com.vhmsoft.launcherios26.core.LauncherHomeLayoutSettings

interface LauncherHomeSettingsRepository {
    fun readHomeLayoutSettings(): LauncherHomeLayoutSettings
    fun saveHomeIconSizeDp(iconSizeDp: Int)
    fun saveHomeGridRows(rows: Int)
    fun setAutoRearrangeApps(enabled: Boolean)
    fun setDarkMode(enabled: Boolean)
}

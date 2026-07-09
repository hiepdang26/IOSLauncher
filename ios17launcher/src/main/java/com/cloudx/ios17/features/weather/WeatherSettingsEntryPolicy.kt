package com.cloudx.ios17.features.weather

object WeatherSettingsEntryPolicy {
    enum class Target {
        LAUNCHER_SETTINGS,
        LEGACY_PREFERENCES
    }

    fun targetForLauncherContext(hasLauncherContext: Boolean): Target {
        return if (hasLauncherContext) Target.LAUNCHER_SETTINGS else Target.LEGACY_PREFERENCES
    }
}

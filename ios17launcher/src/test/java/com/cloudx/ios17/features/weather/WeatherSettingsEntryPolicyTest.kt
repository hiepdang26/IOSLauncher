package com.cloudx.ios17.features.weather

import org.junit.Assert.assertEquals
import org.junit.Test

class WeatherSettingsEntryPolicyTest {
    @Test
    fun launcherContextUsesLauncherSettingsScreen() {
        assertEquals(
            WeatherSettingsEntryPolicy.Target.LAUNCHER_SETTINGS,
            WeatherSettingsEntryPolicy.targetForLauncherContext(hasLauncherContext = true)
        )
    }

    @Test
    fun nonLauncherContextFallsBackToLegacyPreferences() {
        assertEquals(
            WeatherSettingsEntryPolicy.Target.LEGACY_PREFERENCES,
            WeatherSettingsEntryPolicy.targetForLauncherContext(hasLauncherContext = false)
        )
    }
}

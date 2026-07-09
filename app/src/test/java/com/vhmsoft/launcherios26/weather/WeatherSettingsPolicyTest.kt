package com.vhmsoft.launcherios26.weather

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.concurrent.TimeUnit

class WeatherSettingsPolicyTest {
    @Test
    fun temperatureUnitFromMetricDefaultsToCelsius() {
        assertEquals(
            WeatherSettingsPolicy.TemperatureUnit.CELSIUS,
            WeatherSettingsPolicy.temperatureUnit(useMetric = true)
        )
    }

    @Test
    fun temperatureUnitFromImperialUsesFahrenheit() {
        assertEquals(
            WeatherSettingsPolicy.TemperatureUnit.FAHRENHEIT,
            WeatherSettingsPolicy.temperatureUnit(useMetric = false)
        )
    }

    @Test
    fun refreshIntervalDefaultsToHourly() {
        assertEquals(
            WeatherSettingsPolicy.RefreshInterval.HOURLY,
            WeatherSettingsPolicy.refreshInterval("missing")
        )
    }

    @Test
    fun refreshIntervalsMapToExpectedMilliseconds() {
        assertEquals(
            TimeUnit.HOURS.toMillis(3),
            WeatherSettingsPolicy.RefreshInterval.EVERY_3_HOURS.millis
        )
        assertEquals(
            TimeUnit.HOURS.toMillis(6),
            WeatherSettingsPolicy.RefreshInterval.EVERY_6_HOURS.millis
        )
        assertEquals(
            TimeUnit.HOURS.toMillis(9),
            WeatherSettingsPolicy.RefreshInterval.EVERY_9_HOURS.millis
        )
        assertEquals(
            TimeUnit.HOURS.toMillis(12),
            WeatherSettingsPolicy.RefreshInterval.EVERY_12_HOURS.millis
        )
    }
}

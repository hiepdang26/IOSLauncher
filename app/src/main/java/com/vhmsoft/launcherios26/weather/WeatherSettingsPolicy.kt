package com.vhmsoft.launcherios26.weather

import java.util.concurrent.TimeUnit

object WeatherSettingsPolicy {
    enum class TemperatureUnit(
        val apiValue: String,
        val useMetric: Boolean
    ) {
        CELSIUS("celsius", true),
        FAHRENHEIT("fahrenheit", false)
    }

    enum class RefreshInterval(
        val preferenceValue: String,
        val minutes: Long
    ) {
        HOURLY("60", 60),
        EVERY_3_HOURS("180", 180),
        EVERY_6_HOURS("360", 360),
        EVERY_9_HOURS("540", 540),
        EVERY_12_HOURS("720", 720);

        val millis: Long
            get() = TimeUnit.MINUTES.toMillis(minutes)
    }

    fun temperatureUnit(useMetric: Boolean): TemperatureUnit {
        return if (useMetric) TemperatureUnit.CELSIUS else TemperatureUnit.FAHRENHEIT
    }

    fun refreshInterval(preferenceValue: String?): RefreshInterval {
        return RefreshInterval.values()
            .firstOrNull { it.preferenceValue == preferenceValue }
            ?: RefreshInterval.HOURLY
    }
}

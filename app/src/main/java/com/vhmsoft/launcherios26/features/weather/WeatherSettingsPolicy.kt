package com.vhmsoft.launcherios26.features.weather

import com.vhmsoft.launcherios26.features.weather.openmeteo.DailyWeather
import com.vhmsoft.launcherios26.features.weather.openmeteo.HourlyWeather
import com.vhmsoft.launcherios26.features.weather.openmeteo.WeatherForecast
import java.util.concurrent.TimeUnit
import kotlin.math.roundToInt

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

    fun convertForecastTemperatureUnit(
        forecast: WeatherForecast,
        targetUnit: TemperatureUnit
    ): WeatherForecast {
        if (forecast.temperatureUnit == targetUnit) {
            return forecast
        }
        return forecast.copy(
            currentTemperatureC = convertTemperature(
                forecast.currentTemperatureC,
                forecast.temperatureUnit,
                targetUnit
            ),
            highTemperatureC = convertTemperature(
                forecast.highTemperatureC,
                forecast.temperatureUnit,
                targetUnit
            ),
            lowTemperatureC = convertTemperature(
                forecast.lowTemperatureC,
                forecast.temperatureUnit,
                targetUnit
            ),
            hourly = forecast.hourly.map { hour ->
                convertHourlyWeather(hour, forecast.temperatureUnit, targetUnit)
            },
            daily = forecast.daily.map { day ->
                convertDailyWeather(day, forecast.temperatureUnit, targetUnit)
            },
            temperatureUnit = targetUnit
        )
    }

    private fun convertHourlyWeather(
        hour: HourlyWeather,
        sourceUnit: TemperatureUnit,
        targetUnit: TemperatureUnit
    ): HourlyWeather {
        return hour.copy(
            temperatureC = convertTemperature(hour.temperatureC, sourceUnit, targetUnit)
        )
    }

    private fun convertDailyWeather(
        day: DailyWeather,
        sourceUnit: TemperatureUnit,
        targetUnit: TemperatureUnit
    ): DailyWeather {
        return day.copy(
            minTemperatureC = convertTemperature(day.minTemperatureC, sourceUnit, targetUnit),
            maxTemperatureC = convertTemperature(day.maxTemperatureC, sourceUnit, targetUnit)
        )
    }

    private fun convertTemperature(
        temperature: Int,
        sourceUnit: TemperatureUnit,
        targetUnit: TemperatureUnit
    ): Int {
        if (sourceUnit == targetUnit) {
            return temperature
        }
        return when (targetUnit) {
            TemperatureUnit.CELSIUS -> ((temperature - 32) * 5f / 9f).roundToInt()
            TemperatureUnit.FAHRENHEIT -> (temperature * 9f / 5f + 32f).roundToInt()
        }
    }
}

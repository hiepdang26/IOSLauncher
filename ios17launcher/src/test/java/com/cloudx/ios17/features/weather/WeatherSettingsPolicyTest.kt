package com.cloudx.ios17.features.weather

import com.cloudx.ios17.features.weather.openmeteo.DailyWeather
import com.cloudx.ios17.features.weather.openmeteo.HourlyWeather
import com.cloudx.ios17.features.weather.openmeteo.WeatherForecast
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
            WeatherSettingsPolicy.refreshInterval("unknown")
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

    @Test
    fun convertForecastTemperatureUnit_convertsCachedForecastToFahrenheitForImmediateHomeRefresh() {
        val forecast = forecast(
            unit = WeatherSettingsPolicy.TemperatureUnit.CELSIUS,
            currentTemperature = 28,
            highTemperature = 33,
            lowTemperature = 26,
            hourlyTemperature = 30,
            dailyMinTemperature = 24,
            dailyMaxTemperature = 31
        )

        val converted = WeatherSettingsPolicy.convertForecastTemperatureUnit(
            forecast,
            WeatherSettingsPolicy.TemperatureUnit.FAHRENHEIT
        )

        assertEquals(WeatherSettingsPolicy.TemperatureUnit.FAHRENHEIT, converted.temperatureUnit)
        assertEquals(82, converted.currentTemperatureC)
        assertEquals(91, converted.highTemperatureC)
        assertEquals(79, converted.lowTemperatureC)
        assertEquals(86, converted.hourly.first().temperatureC)
        assertEquals(75, converted.daily.first().minTemperatureC)
        assertEquals(88, converted.daily.first().maxTemperatureC)
    }

    @Test
    fun convertForecastTemperatureUnit_convertsCachedForecastToCelsiusForImmediateHomeRefresh() {
        val forecast = forecast(
            unit = WeatherSettingsPolicy.TemperatureUnit.FAHRENHEIT,
            currentTemperature = 88,
            highTemperature = 98,
            lowTemperature = 79,
            hourlyTemperature = 86,
            dailyMinTemperature = 75,
            dailyMaxTemperature = 88
        )

        val converted = WeatherSettingsPolicy.convertForecastTemperatureUnit(
            forecast,
            WeatherSettingsPolicy.TemperatureUnit.CELSIUS
        )

        assertEquals(WeatherSettingsPolicy.TemperatureUnit.CELSIUS, converted.temperatureUnit)
        assertEquals(31, converted.currentTemperatureC)
        assertEquals(37, converted.highTemperatureC)
        assertEquals(26, converted.lowTemperatureC)
        assertEquals(30, converted.hourly.first().temperatureC)
        assertEquals(24, converted.daily.first().minTemperatureC)
        assertEquals(31, converted.daily.first().maxTemperatureC)
    }

    @Test
    fun convertForecastTemperatureUnit_keepsForecastWhenUnitAlreadyMatches() {
        val forecast = forecast(unit = WeatherSettingsPolicy.TemperatureUnit.CELSIUS)

        val converted = WeatherSettingsPolicy.convertForecastTemperatureUnit(
            forecast,
            WeatherSettingsPolicy.TemperatureUnit.CELSIUS
        )

        assertEquals(forecast, converted)
    }

    private fun forecast(
        unit: WeatherSettingsPolicy.TemperatureUnit,
        currentTemperature: Int = 28,
        highTemperature: Int = 33,
        lowTemperature: Int = 26,
        hourlyTemperature: Int = 30,
        dailyMinTemperature: Int = 24,
        dailyMaxTemperature: Int = 31
    ): WeatherForecast {
        return WeatherForecast(
            locationName = "Hà Nội",
            currentTemperatureC = currentTemperature,
            condition = "nhiều mây",
            conditionCode = 3,
            highTemperatureC = highTemperature,
            lowTemperatureC = lowTemperature,
            windDirectionDegrees = 0,
            windSpeedKmh = 0,
            hourly = listOf(
                HourlyWeather("20", hourlyTemperature, 3, "nhiều mây")
            ),
            daily = listOf(
                DailyWeather("Th 2", dailyMinTemperature, dailyMaxTemperature, 0, 3, "nhiều mây")
            ),
            temperatureUnit = unit
        )
    }
}

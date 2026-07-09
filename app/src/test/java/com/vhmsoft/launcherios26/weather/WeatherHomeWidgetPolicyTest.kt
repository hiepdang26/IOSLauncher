package com.vhmsoft.launcherios26.weather

import org.junit.Assert.assertEquals
import org.junit.Test

class WeatherHomeWidgetPolicyTest {
    @Test
    fun homeWidgetForecast_showsSixHourlyItems() {
        val forecast = forecast(
            hourly = (0 until 8).map { index ->
                HourlyWeather(
                    label = "%02d".format(20 + index),
                    temperatureC = 88 - index,
                    conditionCode = 61,
                    condition = "mưa"
                )
            }
        )

        val summary = WeatherHomeWidgetPolicy.homeSummary(forecast)

        assertEquals(6, summary.hourly.size)
        assertEquals(listOf("20", "21", "22", "23", "24", "25"), summary.hourly.map { it.label })
    }

    @Test
    fun homeWidgetForecast_skipsCurrentHourLabel() {
        val forecast = forecast(
            hourly = listOf(
                HourlyWeather("Bây giờ", 30, 3, "nhiều mây"),
                HourlyWeather("20", 30, 3, "nhiều mây"),
                HourlyWeather("21", 30, 61, "mưa"),
                HourlyWeather("22", 27, 61, "mưa"),
                HourlyWeather("23", 27, 61, "mưa"),
                HourlyWeather("0", 27, 61, "mưa"),
                HourlyWeather("1", 27, 61, "mưa")
            )
        )

        val summary = WeatherHomeWidgetPolicy.homeSummary(forecast)

        assertEquals(listOf("20", "21", "22", "23", "0", "1"), summary.hourly.map { it.label })
    }

    @Test
    fun homeWidgetForecast_usesApiTemperaturesForSelectedUnit() {
        val forecast = forecast(
            currentTemperatureC = 88,
            highTemperatureC = 98,
            lowTemperatureC = 79,
            hourly = listOf(
                HourlyWeather("20", 88, 61, "mưa"),
                HourlyWeather("21", 87, 61, "mưa")
            )
        )

        val summary = WeatherHomeWidgetPolicy.homeSummary(forecast)

        assertEquals(88, summary.currentTemperature)
        assertEquals(98, summary.highTemperature)
        assertEquals(79, summary.lowTemperature)
        assertEquals(listOf(88, 87), summary.hourly.map { it.temperature })
    }

    private fun forecast(
        currentTemperatureC: Int = 28,
        highTemperatureC: Int = 33,
        lowTemperatureC: Int = 26,
        hourly: List<HourlyWeather> = emptyList()
    ): WeatherForecast {
        return WeatherForecast(
            locationName = "Phú Diễn",
            currentTemperatureC = currentTemperatureC,
            condition = "mưa nhẹ",
            conditionCode = 61,
            highTemperatureC = highTemperatureC,
            lowTemperatureC = lowTemperatureC,
            windDirectionDegrees = 0,
            windSpeedKmh = 0,
            hourly = hourly,
            daily = emptyList()
        )
    }
}

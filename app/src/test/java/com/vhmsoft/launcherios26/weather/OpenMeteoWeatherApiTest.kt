package com.vhmsoft.launcherios26.weather

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class OpenMeteoWeatherApiTest {
    @Test
    fun buildForecastUrl_usesFreeForecastEndpointWithoutApiKey() {
        val url = OpenMeteoWeatherApi.buildForecastUrl(
            WeatherCoordinates(latitude = 21.048, longitude = 105.763)
        )

        assertTrue(url.startsWith("https://api.open-meteo.com/v1/forecast?"))
        assertTrue(url.contains("latitude=21.048"))
        assertTrue(url.contains("longitude=105.763"))
        assertTrue(url.contains("current="))
        assertTrue(url.contains("hourly="))
        assertTrue(url.contains("daily="))
        assertTrue(url.contains("forecast_days=7"))
        assertTrue(url.contains("timezone=auto"))
        assertFalse(url.contains("apikey"))
        assertEquals(url, OpenMeteoWeatherApi.buildForecastUrl(WeatherCoordinates(21.048, 105.763)))
    }

    @Test
    fun buildForecastUrl_usesSelectedTemperatureUnit() {
        val url = OpenMeteoWeatherApi.buildForecastUrl(
            coordinates = WeatherCoordinates(latitude = 21.048, longitude = 105.763),
            temperatureUnit = WeatherSettingsPolicy.TemperatureUnit.FAHRENHEIT
        )

        assertTrue(url.contains("temperature_unit=fahrenheit"))
    }
}

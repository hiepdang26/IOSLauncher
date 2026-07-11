package com.vhmsoft.launcherios26.features.weather.openmeteo

import com.vhmsoft.launcherios26.features.weather.WeatherSettingsPolicy
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

object OpenMeteoWeatherApi {
    fun buildForecastUrl(
        coordinates: WeatherCoordinates,
        temperatureUnit: WeatherSettingsPolicy.TemperatureUnit = WeatherSettingsPolicy.TemperatureUnit.CELSIUS
    ): String {
        val parameters = linkedMapOf(
            "latitude" to coordinates.latitude.toString(),
            "longitude" to coordinates.longitude.toString(),
            "current" to "temperature_2m,weather_code,wind_speed_10m,wind_direction_10m",
            "hourly" to "temperature_2m,weather_code",
            "daily" to "weather_code,temperature_2m_max,temperature_2m_min,precipitation_probability_max",
            "timezone" to "auto",
            "forecast_days" to "7",
            "forecast_hours" to "8",
            "temperature_unit" to temperatureUnit.apiValue,
            "wind_speed_unit" to "kmh"
        )
        return FORECAST_ENDPOINT + parameters.entries.joinToString("&") { (key, value) ->
            "${encode(key)}=${encode(value)}"
        }
    }

    @Throws(IOException::class)
    fun fetchForecast(
        coordinates: WeatherCoordinates,
        locationName: String,
        temperatureUnit: WeatherSettingsPolicy.TemperatureUnit = WeatherSettingsPolicy.TemperatureUnit.CELSIUS
    ): WeatherForecast {
        val connection = URL(buildForecastUrl(coordinates, temperatureUnit)).openConnection() as HttpURLConnection
        connection.connectTimeout = NETWORK_TIMEOUT_MS
        connection.readTimeout = NETWORK_TIMEOUT_MS
        connection.requestMethod = "GET"
        try {
            val responseCode = connection.responseCode
            val stream = if (responseCode in 200..299) {
                connection.inputStream
            } else {
                connection.errorStream ?: throw IOException("Open-Meteo HTTP $responseCode")
            }
            val body = stream.bufferedReader().use { reader -> reader.readText() }
            if (responseCode !in 200..299) {
                throw IOException("Open-Meteo HTTP $responseCode: $body")
            }
            return OpenMeteoWeatherParser.parse(body, locationName, temperatureUnit)
        } finally {
            connection.disconnect()
        }
    }

    private fun encode(value: String): String {
        return URLEncoder.encode(value, Charsets.UTF_8.name())
    }

    private const val FORECAST_ENDPOINT = "https://api.open-meteo.com/v1/forecast?"
    private const val NETWORK_TIMEOUT_MS = 12_000
}

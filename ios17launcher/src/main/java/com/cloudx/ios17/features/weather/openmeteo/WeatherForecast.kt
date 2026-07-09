package com.cloudx.ios17.features.weather.openmeteo

import com.cloudx.ios17.features.weather.WeatherSettingsPolicy

data class WeatherForecast(
    val locationName: String,
    val currentTemperatureC: Int,
    val condition: String,
    val conditionCode: Int,
    val highTemperatureC: Int,
    val lowTemperatureC: Int,
    val windDirectionDegrees: Int,
    val windSpeedKmh: Int,
    val hourly: List<HourlyWeather>,
    val daily: List<DailyWeather>,
    val temperatureUnit: WeatherSettingsPolicy.TemperatureUnit = WeatherSettingsPolicy.TemperatureUnit.CELSIUS
)

data class HourlyWeather(
    val label: String,
    val temperatureC: Int,
    val conditionCode: Int,
    val condition: String
)

data class DailyWeather(
    val dayLabel: String,
    val minTemperatureC: Int,
    val maxTemperatureC: Int,
    val precipitationProbability: Int,
    val conditionCode: Int,
    val condition: String
)

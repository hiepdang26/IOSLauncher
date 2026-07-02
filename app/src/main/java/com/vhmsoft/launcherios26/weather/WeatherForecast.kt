package com.vhmsoft.launcherios26.weather

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
    val daily: List<DailyWeather>
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

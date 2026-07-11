package com.vhmsoft.launcherios26.features.weather

import com.vhmsoft.launcherios26.features.weather.openmeteo.WeatherForecast

object HomeWeatherWidgetPolicy {
    const val MAX_HOURLY_ITEMS = 6

    fun iconTypeFor(conditionCode: Int): HomeWeatherIconType {
        return when (conditionCode) {
            0, 1 -> HomeWeatherIconType.CLEAR
            2, 3, 45, 48 -> HomeWeatherIconType.CLOUD
            51, 53, 55, 56, 57, 61, 63, 65, 66, 67, 80, 81, 82 -> HomeWeatherIconType.RAIN
            71, 73, 75, 77, 85, 86 -> HomeWeatherIconType.SNOW
            95, 96, 99 -> HomeWeatherIconType.STORM
            else -> HomeWeatherIconType.CLOUD
        }
    }

    fun homeSummary(forecast: WeatherForecast): HomeWeatherSummary {
        return HomeWeatherSummary(
            locationName = forecast.locationName,
            currentTemperature = forecast.currentTemperatureC,
            condition = forecast.condition,
            conditionCode = forecast.conditionCode,
            highTemperature = forecast.highTemperatureC,
            lowTemperature = forecast.lowTemperatureC,
            hourly = forecast.hourly
                .filterNot { item -> item.label == CURRENT_HOUR_LABEL }
                .take(MAX_HOURLY_ITEMS)
                .map { item ->
                    HomeHourlyWeather(
                        label = item.label,
                        temperature = item.temperatureC,
                        conditionCode = item.conditionCode
                    )
                }
        )
    }

    private const val CURRENT_HOUR_LABEL = "Bây giờ"
}

data class HomeWeatherSummary(
    val locationName: String,
    val currentTemperature: Int,
    val condition: String,
    val conditionCode: Int,
    val highTemperature: Int,
    val lowTemperature: Int,
    val hourly: List<HomeHourlyWeather>
)

data class HomeHourlyWeather(
    val label: String,
    val temperature: Int,
    val conditionCode: Int
)

enum class HomeWeatherIconType {
    CLEAR,
    CLOUD,
    RAIN,
    SNOW,
    STORM
}

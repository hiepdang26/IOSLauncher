package com.vhmsoft.launcherios26.weather

object WeatherHomeWidgetPolicy {
    const val MAX_HOURLY_ITEMS = 6

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

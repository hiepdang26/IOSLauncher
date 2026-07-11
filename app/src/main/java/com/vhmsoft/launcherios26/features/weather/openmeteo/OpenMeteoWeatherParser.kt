package com.vhmsoft.launcherios26.features.weather.openmeteo

import com.vhmsoft.launcherios26.features.weather.WeatherSettingsPolicy
import java.time.LocalDate
import kotlin.math.roundToInt
import org.json.JSONObject

object OpenMeteoWeatherParser {
    fun parse(
        json: String,
        locationName: String,
        temperatureUnit: WeatherSettingsPolicy.TemperatureUnit = WeatherSettingsPolicy.TemperatureUnit.CELSIUS
    ): WeatherForecast {
        val root = JSONObject(json)
        val current = root.getJSONObject("current")
        val daily = root.getJSONObject("daily")
        val hourly = root.getJSONObject("hourly")
        val currentCode = current.optInt("weather_code")
        val currentTemperature = current.optDouble("temperature_2m").roundToInt()
        val firstMax = daily.getJSONArray("temperature_2m_max").optDouble(0).roundToInt()
        val firstMin = daily.getJSONArray("temperature_2m_min").optDouble(0).roundToInt()

        return WeatherForecast(
            locationName = locationName,
            currentTemperatureC = currentTemperature,
            condition = WeatherConditionMapper.descriptionFor(currentCode),
            conditionCode = currentCode,
            highTemperatureC = firstMax,
            lowTemperatureC = firstMin,
            windDirectionDegrees = current.optDouble("wind_direction_10m").roundToInt(),
            windSpeedKmh = current.optDouble("wind_speed_10m").roundToInt(),
            hourly = parseHourly(hourly),
            daily = parseDaily(daily),
            temperatureUnit = temperatureUnit
        )
    }

    private fun parseHourly(hourly: JSONObject): List<HourlyWeather> {
        val times = hourly.getJSONArray("time")
        val temperatures = hourly.getJSONArray("temperature_2m")
        val codes = hourly.getJSONArray("weather_code")
        val count = minOf(times.length(), temperatures.length(), codes.length(), MAX_HOURLY_ITEMS)
        return (0 until count).map { index ->
            val code = codes.optInt(index)
            HourlyWeather(
                label = if (index == 0) "Bây giờ" else hourLabel(times.optString(index)),
                temperatureC = temperatures.optDouble(index).roundToInt(),
                conditionCode = code,
                condition = WeatherConditionMapper.descriptionFor(code)
            )
        }
    }

    private fun parseDaily(daily: JSONObject): List<DailyWeather> {
        val times = daily.getJSONArray("time")
        val codes = daily.getJSONArray("weather_code")
        val maxTemperatures = daily.getJSONArray("temperature_2m_max")
        val minTemperatures = daily.getJSONArray("temperature_2m_min")
        val precipitation = daily.optJSONArray("precipitation_probability_max")
        val count = minOf(times.length(), codes.length(), maxTemperatures.length(), minTemperatures.length(), MAX_DAILY_ITEMS)
        return (0 until count).map { index ->
            val code = codes.optInt(index)
            DailyWeather(
                dayLabel = dayLabel(times.optString(index)),
                minTemperatureC = minTemperatures.optDouble(index).roundToInt(),
                maxTemperatureC = maxTemperatures.optDouble(index).roundToInt(),
                precipitationProbability = precipitation?.optInt(index) ?: 0,
                conditionCode = code,
                condition = WeatherConditionMapper.descriptionFor(code)
            )
        }
    }

    private fun hourLabel(rawTime: String): String {
        val hourStart = rawTime.indexOf('T') + 1
        if (hourStart <= 0 || rawTime.length < hourStart + 2) return rawTime
        return rawTime.substring(hourStart, hourStart + 2).trimStart('0').ifEmpty { "0" }
    }

    private fun dayLabel(rawDate: String): String {
        val dayOfWeek = runCatching { LocalDate.parse(rawDate).dayOfWeek.value }.getOrDefault(1)
        return when (dayOfWeek) {
            1 -> "Th 2"
            2 -> "Th 3"
            3 -> "Th 4"
            4 -> "Th 5"
            5 -> "Th 6"
            6 -> "Th 7"
            else -> "CN"
        }
    }

    private const val MAX_HOURLY_ITEMS = 8
    private const val MAX_DAILY_ITEMS = 7
}

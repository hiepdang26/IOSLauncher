package com.cloudx.ios17.features.weather

import android.content.Context
import com.cloudx.ios17.R
import java.text.DecimalFormat
import lineageos.app.LineageContextConstants
import lineageos.providers.WeatherContract
import lineageos.providers.WeatherContract.WeatherColumns.WeatherCode

object WeatherUtils {

    private val sNoDigitsFormat = DecimalFormat("0")

    private const val DIRECTION_NORTH = 23.0
    private const val DIRECTION_NORTH_EAST = 68.0
    private const val DIRECTION_EAST = 113.0
    private const val DIRECTION_SOUTH_EAST = 158.0
    private const val DIRECTION_SOUTH = 203.0
    private const val DIRECTION_SOUTH_WEST = 248.0
    private const val DIRECTION_WEST = 293.0
    private const val DIRECTION_NORTH_WEST = 338.0

    private var weatherServiceFeatureCached = false
    private var weatherServiceAvailable = false

    @JvmStatic
    fun resolveWindDirection(context: Context, windDirection: Double): String {
        val resId =
            if (windDirection < 0) {
                R.string.unknown
            } else if (windDirection < DIRECTION_NORTH) {
                R.string.weather_N
            } else if (windDirection < DIRECTION_NORTH_EAST) {
                R.string.weather_NE
            } else if (windDirection < DIRECTION_EAST) {
                R.string.weather_E
            } else if (windDirection < DIRECTION_SOUTH_EAST) {
                R.string.weather_SE
            } else if (windDirection < DIRECTION_SOUTH) {
                R.string.weather_S
            } else if (windDirection < DIRECTION_SOUTH_WEST) {
                R.string.weather_SW
            } else if (windDirection < DIRECTION_WEST) {
                R.string.weather_W
            } else if (windDirection < DIRECTION_NORTH_WEST) {
                R.string.weather_NW
            } else {
                R.string.weather_N
            }

        return context.getString(resId)
    }

    @JvmStatic
    fun resolveWeatherCondition(context: Context, conditionCode: Int): String {
        val res = context.resources
        val resId = res.getIdentifier(
            "weather_${addOffsetToConditionCodeFromWeatherContract(conditionCode)}",
            "string",
            context.packageName
        )
        if (resId != 0) {
            return res.getString(resId)
        }
        return ""
    }

    private fun getFormattedValue(value: Double, unit: String): String {
        if (java.lang.Double.isNaN(value)) {
            return "-"
        }
        var formatted = sNoDigitsFormat.format(value)
        if (formatted == "-0") {
            formatted = "0"
        }
        return formatted + unit
    }

    @JvmStatic
    fun formatHumidity(humidity: Double): String = getFormattedValue(humidity, "%")

    @JvmStatic
    fun formatWindSpeed(context: Context, windSpeed: Double, windSpeedUnit: Int): String {
        if (windSpeed < 0) {
            return context.getString(R.string.unknown)
        }

        val localizedSpeedUnit =
            when (windSpeedUnit) {
                WeatherContract.WeatherColumns.WindSpeedUnit.MPH -> context.getString(R.string.weather_mph)
                WeatherContract.WeatherColumns.WindSpeedUnit.KPH -> context.getString(R.string.weather_kph)
                else -> return context.getString(R.string.unknown)
            }
        return getFormattedValue(windSpeed, localizedSpeedUnit)
    }

    @JvmStatic
    fun milesToKilometers(miles: Double): Double = miles * 1.609344

    @JvmStatic
    fun kilometersToMiles(km: Double): Double = km * 0.6214

    @JvmStatic
    fun addOffsetToConditionCodeFromWeatherContract(conditionCode: Int): Int {
        return if (conditionCode <= WeatherContract.WeatherColumns.WeatherCode.SHOWERS) {
            conditionCode
        } else if (conditionCode <= WeatherCode.SCATTERED_THUNDERSTORMS) {
            conditionCode + 1
        } else if (conditionCode <= WeatherCode.SCATTERED_SNOW_SHOWERS) {
            conditionCode + 2
        } else if (conditionCode <= WeatherCode.ISOLATED_THUNDERSHOWERS) {
            conditionCode + 3
        } else {
            WeatherCode.NOT_AVAILABLE
        }
    }

    @JvmStatic
    fun isWeatherServiceAvailable(context: Context): Boolean {
        if (!weatherServiceFeatureCached) {
            weatherServiceAvailable = context.packageManager
                .hasSystemFeature(LineageContextConstants.Features.WEATHER_SERVICES)
            weatherServiceFeatureCached = true
        }
        return weatherServiceAvailable
    }
}

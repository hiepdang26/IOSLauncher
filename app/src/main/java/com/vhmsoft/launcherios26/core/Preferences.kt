package com.vhmsoft.launcherios26.core

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import com.vhmsoft.launcherios26.core.utils.Constants
import java.util.Locale
import lineageos.weather.WeatherInfo
import lineageos.weather.WeatherLocation
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

object Preferences {

    /** Weather related keys and constants. */
    private const val WEATHER_LOCATION_CITY_ID = "city_id"
    private const val WEATHER_LOCATION_CITY_NAME = "city_name"
    private const val WEATHER_LOCATION_STATE = "state"
    private const val WEATHER_LOCATION_POSTAL_CODE = "postal_code"
    private const val WEATHER_LOCATION_COUNTRY_ID = "country_id"
    private const val WEATHER_LOCATION_COUNTRY_NAME = "country_name"

    private const val WEATHER_INFO_CITY = "city"
    private const val WEATHER_INFO_CONDITION_CODE = "condition_code"
    private const val WEATHER_INFO_TEMPERATURE = "temperature"
    private const val WEATHER_INFO_TEMPERATURE_UNIT = "temperature_unit"
    private const val WEATHER_INFO_TIMESTAMP = "timestamp"
    private const val WEATHER_INFO_HUMIDITY = "humidity"
    private const val WEATHER_INFO_TODAYS_HIGH = "todays_high"
    private const val WEATHER_INFO_TODAYS_LOW = "todays_low"
    private const val WEATHER_INFO_WIND_SPEED = "wind_speed"
    private const val WEATHER_INFO_WIND_SPEED_UNIT = "wind_speed_unit"
    private const val WEATHER_INFO_WIND_SPEED_DIRECTION = "wind_speed_direction"
    private const val WEATHER_INFO_FORECAST = "forecasts"

    private const val DAY_FORECAST_CONDITION_CODE = "condition_code"
    private const val DAY_FORECAST_LOW = "low"
    private const val DAY_FORECAST_HIGH = "high"

    private const val NOTIFICATION_ACCESS = "notification_access"
    private const val NOTIFICATION_INFO = "notification_info"
    private const val ENABLE_LOCATION = "enable_location"
    private const val ACTION_USAGE = "com.vhmsoft.launcherios26.ACTION_USAGE"
    private const val CURRENT_MIGRATION_VERSION = "current_migration_version"

    private const val ADDED_WEATHER_WIDGET = "added_weather_widget"
    private const val ADDED_ECLOUD_WIDGET = "added_ecloud_widget"
    private const val ADDED_PRIVACY_WIDGET = "added_privacy_widget"

    private const val AP_MIGRATION_1 = "ap_migration_1"
    private val WEATHER_REFRESH_INTERVAL_VALUES = setOf("60", "180", "360", "540", "720")

    @JvmStatic
    fun isFirstWeatherUpdate(context: Context): Boolean =
        getPrefs(context).getBoolean(Constants.WEATHER_FIRST_UPDATE, true)

    @JvmStatic
    fun weatherFontColor(context: Context): Int =
        Color.parseColor(
            getPrefs(context).getString(Constants.WEATHER_FONT_COLOR, Constants.DEFAULT_LIGHT_COLOR)
        )

    @JvmStatic
    fun getWeatherIconSet(context: Context): String =
        getPrefs(context).getString(Constants.WEATHER_ICONS, "color") ?: "color"

    @JvmStatic
    fun useMetricUnits(context: Context): Boolean {
        val locale = context.resources.configuration.locale
        val defValue = !(locale == Locale.US ||
            locale.toString() == "ms_MY" ||
            locale.toString() == "si_LK")
        return getPrefs(context).getBoolean(Constants.WEATHER_USE_METRIC, defValue)
    }

    @JvmStatic
    fun setUseMetricUnits(context: Context, value: Boolean) {
        getPrefs(context).edit().putBoolean(Constants.WEATHER_USE_METRIC, value).apply()
    }

    @JvmStatic
    fun weatherRefreshIntervalInMs(context: Context): Long {
        val value = weatherRefreshIntervalValue(context)
        return value.toLong() * 60L * 1000L
    }

    @JvmStatic
    fun weatherRefreshIntervalValue(context: Context): String =
        getPrefs(context).getString(Constants.WEATHER_REFRESH_INTERVAL, "60")
            ?.takeIf { it in WEATHER_REFRESH_INTERVAL_VALUES }
            ?: "60"

    @JvmStatic
    fun setWeatherRefreshIntervalValue(context: Context, value: String) {
        getPrefs(context).edit().putString(Constants.WEATHER_REFRESH_INTERVAL, value).apply()
    }

    @JvmStatic
    fun useCustomWeatherLocation(context: Context): Boolean =
        getPrefs(context).getBoolean(Constants.WEATHER_USE_CUSTOM_LOCATION, false)

    @JvmStatic
    fun setUseCustomWeatherLocation(context: Context, value: Boolean) {
        getPrefs(context).edit().putBoolean(Constants.WEATHER_USE_CUSTOM_LOCATION, value).apply()
    }

    @JvmStatic
    fun getCustomWeatherLocationCity(context: Context): String? =
        getPrefs(context).getString(Constants.WEATHER_CUSTOM_LOCATION_CITY, null)

    @JvmStatic
    fun setCustomWeatherLocationCity(context: Context, city: String?) {
        getPrefs(context).edit().putString(Constants.WEATHER_CUSTOM_LOCATION_CITY, city).apply()
    }

    @JvmStatic
    fun setCustomWeatherLocation(context: Context, weatherLocation: WeatherLocation?): Boolean {
        if (weatherLocation == null) {
            getPrefs(context).edit().remove(Constants.WEATHER_CUSTOM_LOCATION).apply()
            return true
        }
        return try {
            val jsonObject = weatherLocationToJSON(weatherLocation)
            getPrefs(context).edit().putString(Constants.WEATHER_CUSTOM_LOCATION, jsonObject.toString()).apply()
            true
        } catch (_: JSONException) {
            false
        }
    }

    @JvmStatic
    fun getCustomWeatherLocation(context: Context): WeatherLocation? {
        val weatherLocation = getPrefs(context).getString(Constants.WEATHER_CUSTOM_LOCATION, null)
            ?: return null

        return try {
            val jsonObject = JSONObject(weatherLocation)
            JSONToWeatherLocation(jsonObject)
        } catch (_: JSONException) {
            null
        }
    }

    @Throws(JSONException::class)
    private fun JSONToWeatherLocation(jsonObject: JSONObject): WeatherLocation? {
        val cityId = jsonObject.getString(WEATHER_LOCATION_CITY_ID)
        val cityName = jsonObject.getString(WEATHER_LOCATION_CITY_NAME)
        val state = jsonObject.getString(WEATHER_LOCATION_STATE)
        val postalCode = jsonObject.getString(WEATHER_LOCATION_POSTAL_CODE)
        val countryId = jsonObject.getString(WEATHER_LOCATION_COUNTRY_ID)
        val countryName = jsonObject.getString(WEATHER_LOCATION_COUNTRY_NAME)

        if (cityId == null && cityName == null) {
            return null
        }

        val location = WeatherLocation.Builder(cityId, cityName)
        if (countryId != null) location.setCountryId(countryId)
        if (countryName != null) location.setCountry(countryName)
        if (state != null) location.setState(state)
        if (postalCode != null) location.setPostalCode(postalCode)

        return location.build()
    }

    @Throws(JSONException::class)
    private fun weatherLocationToJSON(location: WeatherLocation): JSONObject =
        JSONObject()
            .put(WEATHER_LOCATION_CITY_ID, location.cityId)
            .put(WEATHER_LOCATION_CITY_NAME, location.city)
            .put(WEATHER_LOCATION_STATE, location.state)
            .put(WEATHER_LOCATION_POSTAL_CODE, location.postalCode)
            .put(WEATHER_LOCATION_COUNTRY_ID, location.countryId)
            .put(WEATHER_LOCATION_COUNTRY_NAME, location.country)

    @JvmStatic
    fun setCachedWeatherInfo(context: Context, timestamp: Long, info: WeatherInfo?) {
        val editor = getPrefs(context).edit()
        editor.putLong(Constants.WEATHER_LAST_UPDATE, timestamp)
        if (info != null) {
            val jsonObject = JSONObject()
            var serialized = false
            try {
                jsonObject.put(WEATHER_INFO_CITY, info.city)
                    .put(WEATHER_INFO_CONDITION_CODE, info.conditionCode)
                    .put(WEATHER_INFO_TEMPERATURE, info.temperature)
                    .put(WEATHER_INFO_TEMPERATURE_UNIT, info.temperatureUnit)
                    .put(WEATHER_INFO_TIMESTAMP, info.timestamp)

                val humidity = info.humidity
                jsonObject.put(WEATHER_INFO_HUMIDITY, if (java.lang.Double.isNaN(humidity)) "NaN" else humidity)

                val todaysHigh = info.todaysHigh
                jsonObject.put(
                    WEATHER_INFO_TODAYS_HIGH,
                    if (java.lang.Double.isNaN(todaysHigh)) "NaN" else todaysHigh
                )

                val todaysLow = info.todaysLow
                jsonObject.put(
                    WEATHER_INFO_TODAYS_LOW,
                    if (java.lang.Double.isNaN(todaysLow)) "NaN" else todaysLow
                )

                val windSpeed = info.windSpeed
                val windDirection = info.windDirection
                jsonObject.put(
                    WEATHER_INFO_WIND_SPEED,
                    if (java.lang.Double.isNaN(windSpeed)) "NaN" else windSpeed
                )
                    .put(WEATHER_INFO_WIND_SPEED_UNIT, info.windSpeedUnit)
                    .put(
                        WEATHER_INFO_WIND_SPEED_DIRECTION,
                        if (java.lang.Double.isNaN(windDirection)) "NaN" else windDirection
                    )

                val forecastArray = JSONArray()
                for (forecast in info.forecasts) {
                    val jsonForecast = JSONObject()
                        .put(DAY_FORECAST_CONDITION_CODE, forecast.conditionCode)

                    val low = forecast.low
                    jsonForecast.put(DAY_FORECAST_LOW, if (java.lang.Double.isNaN(low)) "NaN" else low)
                    val high = forecast.high
                    jsonForecast.put(DAY_FORECAST_HIGH, if (java.lang.Double.isNaN(high)) "NaN" else high)
                    forecastArray.put(jsonForecast)
                }
                jsonObject.put(WEATHER_INFO_FORECAST, forecastArray)
                serialized = true
            } catch (_: JSONException) {
            }
            if (serialized) {
                editor.putString(Constants.WEATHER_DATA, jsonObject.toString())
                editor.putBoolean(Constants.WEATHER_FIRST_UPDATE, false)
            }
        } else {
            editor.remove(Constants.WEATHER_DATA)
        }
        editor.apply()
    }

    @JvmStatic
    fun setCachedCity(context: Context, city: String?) {
        val editor = getPrefs(context).edit()
        editor.putString(Constants.CACHED_CITY, city)
        editor.apply()
    }

    @JvmStatic
    fun getCachedCity(context: Context, fallbackCity: String): String? =
        getPrefs(context).getString(Constants.CACHED_CITY, fallbackCity)

    @JvmStatic
    fun getCachedWeatherInfo(context: Context): WeatherInfo? {
        val cachedInfo = getPrefs(context).getString(Constants.WEATHER_DATA, null)
            ?: return null

        val forecastList = ArrayList<WeatherInfo.DayForecast>()

        return try {
            val cached = JSONObject(cachedInfo)
            val city = cached.getString(WEATHER_INFO_CITY)
            val conditionCode = cached.getInt(WEATHER_INFO_CONDITION_CODE)
            val temperature = cached.getDouble(WEATHER_INFO_TEMPERATURE)
            val tempUnit = cached.getInt(WEATHER_INFO_TEMPERATURE_UNIT)
            val humidity = cached.getDouble(WEATHER_INFO_HUMIDITY)
            val windSpeed = cached.getDouble(WEATHER_INFO_WIND_SPEED)
            val windDirection = cached.getDouble(WEATHER_INFO_WIND_SPEED_DIRECTION)
            val windSpeedUnit = cached.getInt(WEATHER_INFO_WIND_SPEED_UNIT)
            val timestamp = cached.getLong(WEATHER_INFO_TIMESTAMP)
            val todaysHigh = cached.getDouble(WEATHER_INFO_TODAYS_HIGH)
            val todaysLow = cached.getDouble(WEATHER_INFO_TODAYS_LOW)
            val forecasts = cached.getJSONArray(WEATHER_INFO_FORECAST)
            for (index in 0 until forecasts.length()) {
                val forecast = forecasts.getJSONObject(index)
                val low = forecast.getDouble(DAY_FORECAST_LOW)
                val high = forecast.getDouble(DAY_FORECAST_HIGH)
                val code = forecast.getInt(DAY_FORECAST_CONDITION_CODE)
                val builder = WeatherInfo.DayForecast.Builder(code)
                if (!java.lang.Double.isNaN(low)) builder.setLow(low)
                if (!java.lang.Double.isNaN(high)) builder.setHigh(high)
                forecastList.add(builder.build())
            }
            val weatherInfo = WeatherInfo.Builder(city, temperature, tempUnit)
                .setWeatherCondition(conditionCode)
                .setTimestamp(timestamp)

            if (!java.lang.Double.isNaN(humidity)) weatherInfo.setHumidity(humidity)
            if (!java.lang.Double.isNaN(windSpeed) && !java.lang.Double.isNaN(windDirection)) {
                weatherInfo.setWind(windSpeed, windDirection, windSpeedUnit)
            }
            if (forecastList.isNotEmpty()) weatherInfo.setForecast(forecastList)
            if (!java.lang.Double.isNaN(todaysHigh)) weatherInfo.setTodaysHigh(todaysHigh)
            if (!java.lang.Double.isNaN(todaysLow)) weatherInfo.setTodaysLow(todaysLow)
            weatherInfo.build()
        } catch (_: JSONException) {
            null
        }
    }

    @JvmStatic
    fun setWeatherSource(context: Context, source: String?) {
        getPrefs(context).edit().putString(Constants.WEATHER_SOURCE, source).apply()
    }

    @JvmStatic
    fun getWeatherSource(context: Context): String? =
        getPrefs(context).getString(Constants.WEATHER_SOURCE, null)

    @JvmStatic
    fun setUserCreationTime(context: Context, key: String) {
        getPrefs(context).edit().putLong(key, System.currentTimeMillis()).apply()
    }

    @JvmStatic
    fun shouldOpenUsageAccess(context: Context): Boolean =
        getPrefs(context).getBoolean(ACTION_USAGE, true)

    @JvmStatic
    fun setNotOpenUsageAccess(context: Context) {
        getPrefs(context).edit().putBoolean(ACTION_USAGE, false).apply()
    }

    @JvmStatic
    fun shouldAskForNotificationAccess(context: Context): Boolean =
        getPrefs(context).getBoolean(NOTIFICATION_ACCESS, true)

    @JvmStatic
    fun setNotToAskForNotificationAccess(context: Context) {
        getPrefs(context).edit().putBoolean(NOTIFICATION_ACCESS, false).apply()
    }

    @JvmStatic
    fun setNotToShowNotificationDialog(context: Context) {
        getPrefs(context).edit().putBoolean(NOTIFICATION_INFO, false).apply()
    }

    @JvmStatic
    fun shouldShowNotificationDialog(context: Context): Boolean =
        getPrefs(context).getBoolean(NOTIFICATION_INFO, true)

    @JvmStatic
    fun getCurrentMigrationVersion(context: Context): Int =
        getPrefs(context).getInt(CURRENT_MIGRATION_VERSION, 0)

    @JvmStatic
    fun setCurrentMigrationVersion(context: Context, version: Int) {
        getPrefs(context).edit().putInt(CURRENT_MIGRATION_VERSION, version).apply()
    }

    @JvmStatic
    fun getPrefs(context: Context): SharedPreferences =
        context.getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE)

    @JvmStatic
    fun setEnableLocation(context: Context) {
        getPrefs(context).edit().putBoolean(ENABLE_LOCATION, true).apply()
    }

    @JvmStatic
    fun getEnableLocation(context: Context): Boolean =
        getPrefs(context).getBoolean(ENABLE_LOCATION, false)

    @JvmStatic
    fun setAddedWeatherWidget(context: Context) {
        getPrefs(context).edit().putBoolean(ADDED_WEATHER_WIDGET, true).apply()
    }

    @JvmStatic
    fun getAddedWeatherWidget(context: Context): Boolean =
        getPrefs(context).getBoolean(ADDED_WEATHER_WIDGET, false)

    @JvmStatic
    fun setAddedEcloudWidget(context: Context) {
        getPrefs(context).edit().putBoolean(ADDED_ECLOUD_WIDGET, true).apply()
    }

    @JvmStatic
    fun getAddedEcloudWidget(context: Context): Boolean =
        getPrefs(context).getBoolean(ADDED_ECLOUD_WIDGET, false)

    @JvmStatic
    fun setAddedPrivacyWidget(context: Context) {
        getPrefs(context).edit().putBoolean(ADDED_PRIVACY_WIDGET, true).apply()
    }

    @JvmStatic
    fun setRemovedPrivacyWidget(context: Context) {
        getPrefs(context).edit().putBoolean(ADDED_PRIVACY_WIDGET, false).apply()
    }

    @JvmStatic
    fun setApMigration1Status(context: Context, status: Boolean) {
        getPrefs(context).edit().putBoolean(AP_MIGRATION_1, status).apply()
    }

    @JvmStatic
    fun getApMigration1Status(context: Context): Boolean =
        getPrefs(context).getBoolean(AP_MIGRATION_1, false)

    @JvmStatic
    fun getAddedPrivacyWidget(context: Context): Boolean =
        getPrefs(context).getBoolean(ADDED_PRIVACY_WIDGET, false)
}

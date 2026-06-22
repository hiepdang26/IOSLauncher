package com.cloudx.ios17.core.utils

import com.cloudx.ios17.BuildConfig

object Constants {
    @JvmField
    val DEBUG: Boolean = BuildConfig.DEBUG

    const val PREF_NAME = "com.cloudx.ios17.prefs"

    const val WEATHER_SOURCE = "weather_source"
    const val WEATHER_USE_CUSTOM_LOCATION = "weather_use_custom_location"
    const val WEATHER_CUSTOM_LOCATION_CITY = "weather_custom_location_city"
    const val WEATHER_CUSTOM_LOCATION = "weather_custom_location"
    const val WEATHER_USE_METRIC = "weather_use_metric"
    const val WEATHER_REFRESH_INTERVAL = "weather_refresh_interval"
    const val WEATHER_FONT_COLOR = "weather_font_color"
    const val WEATHER_ICONS = "weather_icons"

    const val MONOCHROME = "mono"
    const val COLOR_STD = "color"

    const val WEATHER_LAST_UPDATE = "last_weather_update"
    const val FORCE_WEATHER_LAST_TRY = "last_weather_try"
    const val WEATHER_DATA = "weather_data"

    const val CACHED_CITY = "cached_city"
    const val WEATHER_FIRST_UPDATE = "weather_first_update"

    const val DEFAULT_LIGHT_COLOR = "#ffffffff"
    const val DEFAULT_DARK_COLOR = "#80ffffff"

    const val USER_CREATION_TIME_KEY = "user_creation_time_"

    const val ITEM_TYPE_APPLICATION = 0
    const val ITEM_TYPE_SHORTCUT = 1
    const val ITEM_TYPE_FOLDER = 2

    const val CONTAINER_DESKTOP = -100
    const val CONTAINER_HOTSEAT = -101
}

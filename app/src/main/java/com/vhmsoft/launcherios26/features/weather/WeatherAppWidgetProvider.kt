package com.vhmsoft.launcherios26.features.weather

import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import com.vhmsoft.launcherios26.BuildConfig

class WeatherAppWidgetProvider : AppWidgetProvider() {
    companion object {
        @JvmField
        val COMPONENT_NAME = ComponentName(
            BuildConfig.APPLICATION_ID,
            WeatherAppWidgetProvider::class.java.name
        )
    }
}

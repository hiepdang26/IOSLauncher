package com.cloudx.ios17.features.weather

import android.content.Context
import android.view.LayoutInflater
import android.widget.RemoteViews
import com.cloudx.ios17.R
import com.cloudx.ios17.core.customviews.RoundedWidgetView

class WeatherWidgetHostView(context: Context) : RoundedWidgetView(context, true) {
    init {
        LayoutInflater.from(context).inflate(R.layout.layout_weather_info, this)
    }

    override fun updateAppWidget(remoteViews: RemoteViews?) {
        // Do nothing.
    }
}

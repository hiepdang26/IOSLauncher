package com.cloudx.ios17.core.customviews

import android.appwidget.AppWidgetHost
import android.appwidget.AppWidgetHostView
import android.appwidget.AppWidgetProviderInfo
import android.content.Context
import android.view.ContextThemeWrapper
import com.cloudx.ios17.core.utils.getActivityThemeRes
import com.cloudx.ios17.features.weather.WeatherAppWidgetProvider
import com.cloudx.ios17.features.weather.WeatherWidgetHostView
import com.cloudx.ios17.features.widgets.DefaultWidgets

class WidgetHost(context: Context, hostId: Int) : AppWidgetHost(context, hostId) {
    override fun onCreateView(
        context: Context,
        appWidgetId: Int,
        appWidget: AppWidgetProviderInfo
    ): AppWidgetHostView {
        if (appWidget.provider == WeatherAppWidgetProvider.COMPONENT_NAME) {
            val themedContext = ContextThemeWrapper(context, getActivityThemeRes(context))
            return WeatherWidgetHostView(themedContext)
        }

        val isDefaultWidget = DefaultWidgets.widgets.contains(appWidget.provider)
        return RoundedWidgetView(context, isDefaultWidget)
    }

    override fun stopListening() {
        super.stopListening()
        clearViews()
    }
}

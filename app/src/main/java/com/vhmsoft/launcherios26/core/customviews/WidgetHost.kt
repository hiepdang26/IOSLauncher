package com.vhmsoft.launcherios26.core.customviews

import android.appwidget.AppWidgetHost
import android.appwidget.AppWidgetHostView
import android.appwidget.AppWidgetProviderInfo
import android.content.Context
import android.view.ContextThemeWrapper
import com.vhmsoft.launcherios26.core.LauncherHomeLayoutPreferences
import com.vhmsoft.launcherios26.core.utils.getActivityThemeRes
import com.vhmsoft.launcherios26.features.weather.WeatherAppWidgetProvider
import com.vhmsoft.launcherios26.features.weather.WeatherWidgetHostView
import com.vhmsoft.launcherios26.features.widgets.DefaultWidgets

class WidgetHost(context: Context, hostId: Int) : AppWidgetHost(context, hostId) {
    override fun onCreateView(
        context: Context,
        appWidgetId: Int,
        appWidget: AppWidgetProviderInfo
    ): AppWidgetHostView {
        val widgetBlurEnabled = LauncherHomeLayoutPreferences.isWidgetBlurEnabled(context)
        if (appWidget.provider == WeatherAppWidgetProvider.COMPONENT_NAME) {
            val themedContext = ContextThemeWrapper(context, getActivityThemeRes(context))
            return WeatherWidgetHostView(themedContext, blurBackground = widgetBlurEnabled)
        }

        val isDefaultWidget = DefaultWidgets.widgets.contains(appWidget.provider)
        return RoundedWidgetView(context, blurBackground = isDefaultWidget && widgetBlurEnabled)
    }

    override fun stopListening() {
        super.stopListening()
        clearViews()
    }
}

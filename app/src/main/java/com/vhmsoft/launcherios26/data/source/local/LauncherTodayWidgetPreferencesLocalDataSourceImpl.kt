package com.vhmsoft.launcherios26.data.source.local

import android.content.Context

class LauncherTodayWidgetPreferencesLocalDataSourceImpl(
    context: Context
) : LauncherTodayWidgetPreferencesLocalDataSource {
    private val preferences = context.applicationContext.getSharedPreferences(
        TODAY_WIDGET_PREF_NAME,
        Context.MODE_PRIVATE
    )

    override fun getQuickWidgets(): String? {
        return preferences.getString(TODAY_WIDGET_PREF_QUICK, null)
    }

    override fun getWidgetOrder(): String? {
        return preferences.getString(TODAY_WIDGET_PREF_ORDER, null)
    }

    override fun saveQuickWidgets(quickWidgets: String, widgetOrder: String) {
        preferences.edit()
            .putString(TODAY_WIDGET_PREF_QUICK, quickWidgets)
            .putString(TODAY_WIDGET_PREF_ORDER, widgetOrder)
            .apply()
    }

    private companion object {
        const val TODAY_WIDGET_PREF_NAME = "ios_launcher_today_widgets"
        const val TODAY_WIDGET_PREF_QUICK = "quick_widgets"
        const val TODAY_WIDGET_PREF_ORDER = "widget_order"
    }
}

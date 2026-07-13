package com.vhmsoft.launcherios26.data.source.local

interface LauncherTodayWidgetPreferencesLocalDataSource {
    fun getQuickWidgets(): String?
    fun getWidgetOrder(): String?
    fun saveQuickWidgets(quickWidgets: String, widgetOrder: String)
}

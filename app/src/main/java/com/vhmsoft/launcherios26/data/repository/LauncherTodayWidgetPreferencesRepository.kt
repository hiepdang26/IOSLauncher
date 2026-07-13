package com.vhmsoft.launcherios26.data.repository

interface LauncherTodayWidgetPreferencesRepository {
    fun getQuickWidgets(): String?
    fun getWidgetOrder(): String?
    fun saveQuickWidgets(quickWidgets: String, widgetOrder: String)
}

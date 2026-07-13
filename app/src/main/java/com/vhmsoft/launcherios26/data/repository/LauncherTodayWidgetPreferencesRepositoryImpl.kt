package com.vhmsoft.launcherios26.data.repository

import com.vhmsoft.launcherios26.data.source.local.LauncherTodayWidgetPreferencesLocalDataSource

class LauncherTodayWidgetPreferencesRepositoryImpl(
    private val localDataSource: LauncherTodayWidgetPreferencesLocalDataSource
) : LauncherTodayWidgetPreferencesRepository {
    override fun getQuickWidgets(): String? {
        return localDataSource.getQuickWidgets()
    }

    override fun getWidgetOrder(): String? {
        return localDataSource.getWidgetOrder()
    }

    override fun saveQuickWidgets(quickWidgets: String, widgetOrder: String) {
        localDataSource.saveQuickWidgets(quickWidgets, widgetOrder)
    }
}

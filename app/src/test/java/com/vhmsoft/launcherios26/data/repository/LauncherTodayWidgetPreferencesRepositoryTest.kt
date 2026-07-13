package com.vhmsoft.launcherios26.data.repository

import com.vhmsoft.launcherios26.data.source.local.LauncherTodayWidgetPreferencesLocalDataSource
import org.junit.Assert.assertEquals
import org.junit.Test

class LauncherTodayWidgetPreferencesRepositoryTest {
    @Test
    fun readTodayWidgetPreferences_delegatesToLocalDataSource() {
        val localDataSource = FakeLocalDataSource(
            quickWidgets = "-1000:WEATHER,-1001:BATTERY",
            widgetOrder = "-1000,-1001,42"
        )
        val repository = LauncherTodayWidgetPreferencesRepositoryImpl(localDataSource)

        assertEquals("-1000:WEATHER,-1001:BATTERY", repository.getQuickWidgets())
        assertEquals("-1000,-1001,42", repository.getWidgetOrder())
        assertEquals(1, localDataSource.quickWidgetsReadCount)
        assertEquals(1, localDataSource.widgetOrderReadCount)
    }

    @Test
    fun saveTodayWidgetPreferences_delegatesToLocalDataSource() {
        val localDataSource = FakeLocalDataSource()
        val repository = LauncherTodayWidgetPreferencesRepositoryImpl(localDataSource)

        repository.saveQuickWidgets(
            quickWidgets = "-1000:WEATHER,-1001:BATTERY",
            widgetOrder = "-1000,-1001,42"
        )

        assertEquals("-1000:WEATHER,-1001:BATTERY", localDataSource.savedQuickWidgets)
        assertEquals("-1000,-1001,42", localDataSource.savedWidgetOrder)
    }

    private class FakeLocalDataSource(
        private val quickWidgets: String? = null,
        private val widgetOrder: String? = null
    ) : LauncherTodayWidgetPreferencesLocalDataSource {
        var quickWidgetsReadCount = 0
        var widgetOrderReadCount = 0
        var savedQuickWidgets: String? = null
        var savedWidgetOrder: String? = null

        override fun getQuickWidgets(): String? {
            quickWidgetsReadCount += 1
            return quickWidgets
        }

        override fun getWidgetOrder(): String? {
            widgetOrderReadCount += 1
            return widgetOrder
        }

        override fun saveQuickWidgets(quickWidgets: String, widgetOrder: String) {
            savedQuickWidgets = quickWidgets
            savedWidgetOrder = widgetOrder
        }
    }
}

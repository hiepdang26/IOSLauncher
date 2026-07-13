package com.vhmsoft.launcherios26.data.repository

import com.vhmsoft.launcherios26.data.source.local.LauncherHiddenAppsPreferencesLocalDataSource
import org.junit.Assert.assertEquals
import org.junit.Test

class LauncherHiddenAppsPreferencesRepositoryTest {
    @Test
    fun readHiddenAppsPreferences_delegatesToLocalDataSource() {
        val currentValue = "com.example.one|com.example.two"
        val legacyValue = setOf("com.example.legacy")
        val localDataSource = FakeLocalDataSource(
            currentHiddenIdsValue = currentValue,
            legacyHiddenIdsValue = legacyValue
        )
        val repository = LauncherHiddenAppsPreferencesRepositoryImpl(localDataSource)

        assertEquals(currentValue, repository.getHiddenIdsValue())
        assertEquals(legacyValue, repository.getLegacyHiddenIdsValue())
        assertEquals(1, localDataSource.currentReadCount)
        assertEquals(1, localDataSource.legacyReadCount)
    }

    @Test
    fun saveHiddenAppsPreferences_delegatesToLocalDataSource() {
        val localDataSource = FakeLocalDataSource()
        val repository = LauncherHiddenAppsPreferencesRepositoryImpl(localDataSource)

        repository.saveHiddenIdsValue("com.example.one|com.example.two")
        repository.clearLegacyHiddenIds()

        assertEquals("com.example.one|com.example.two", localDataSource.savedHiddenIdsValue)
        assertEquals(1, localDataSource.clearLegacyCount)
    }

    private class FakeLocalDataSource(
        private val currentHiddenIdsValue: Any? = null,
        private val legacyHiddenIdsValue: Any? = null
    ) : LauncherHiddenAppsPreferencesLocalDataSource {
        var currentReadCount = 0
        var legacyReadCount = 0
        var savedHiddenIdsValue: String? = null
        var clearLegacyCount = 0

        override fun getHiddenIdsValue(): Any? {
            currentReadCount += 1
            return currentHiddenIdsValue
        }

        override fun getLegacyHiddenIdsValue(): Any? {
            legacyReadCount += 1
            return legacyHiddenIdsValue
        }

        override fun saveHiddenIdsValue(value: String) {
            savedHiddenIdsValue = value
        }

        override fun clearLegacyHiddenIds() {
            clearLegacyCount += 1
        }
    }
}

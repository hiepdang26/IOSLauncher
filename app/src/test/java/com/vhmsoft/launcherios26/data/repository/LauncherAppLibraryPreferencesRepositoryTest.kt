package com.vhmsoft.launcherios26.data.repository

import com.vhmsoft.launcherios26.data.source.local.LauncherAppLibraryPreferencesLocalDataSource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertSame
import org.junit.Test

class LauncherAppLibraryPreferencesRepositoryTest {
    @Test
    fun getAllPreferences_delegatesToLocalDataSource() {
        val preferences = mapOf(
            "app_category_com.example.one" to "social",
            "unrelated" to 12
        )
        val localDataSource = FakeLocalDataSource(preferences)
        val repository = LauncherAppLibraryPreferencesRepositoryImpl(localDataSource)

        val result = repository.getAllPreferences()

        assertSame(preferences, result)
        assertEquals(1, localDataSource.readCount)
    }

    private class FakeLocalDataSource(
        private val preferences: Map<String, *>
    ) : LauncherAppLibraryPreferencesLocalDataSource {
        var readCount = 0

        override fun getAllPreferences(): Map<String, *> {
            readCount += 1
            return preferences
        }
    }
}

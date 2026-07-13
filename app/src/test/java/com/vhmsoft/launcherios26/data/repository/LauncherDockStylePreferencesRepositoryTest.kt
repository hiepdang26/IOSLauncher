package com.vhmsoft.launcherios26.data.repository

import com.vhmsoft.launcherios26.data.source.local.LauncherDockStylePreferencesLocalDataSource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherDockStylePreferencesRepositoryTest {
    @Test
    fun isIphone8StyleEnabled_delegatesToLocalDataSource() {
        val localDataSource = FakeLocalDataSource(iphone8StyleEnabled = true)
        val repository = LauncherDockStylePreferencesRepositoryImpl(localDataSource)

        assertTrue(repository.isIphone8StyleEnabled())
        assertEquals(1, localDataSource.readCount)
    }

    @Test
    fun setIphone8StyleEnabled_delegatesToLocalDataSource() {
        val localDataSource = FakeLocalDataSource()
        val repository = LauncherDockStylePreferencesRepositoryImpl(localDataSource)

        repository.setIphone8StyleEnabled(true)

        assertEquals(true, localDataSource.savedIphone8StyleEnabled)
    }

    private class FakeLocalDataSource(
        private val iphone8StyleEnabled: Boolean = false
    ) : LauncherDockStylePreferencesLocalDataSource {
        var readCount = 0
        var savedIphone8StyleEnabled: Boolean? = null

        override fun isIphone8StyleEnabled(): Boolean {
            readCount += 1
            return iphone8StyleEnabled
        }

        override fun setIphone8StyleEnabled(enabled: Boolean) {
            savedIphone8StyleEnabled = enabled
        }
    }
}

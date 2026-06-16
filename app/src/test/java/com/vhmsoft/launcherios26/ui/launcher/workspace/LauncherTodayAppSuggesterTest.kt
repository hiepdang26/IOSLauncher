package com.vhmsoft.launcherios26.ui.launcher.workspace

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherTodayAppSuggesterTest {
    @Test
    fun select_returnsAtMostEightDistinctApps() {
        val apps = (0 until 12).map { index -> "app-$index" } + listOf("app-3", "app-4")

        val selected = LauncherTodayAppSuggester.select(
            apps = apps,
            limit = 8,
            stableKey = { key -> key },
            seed = 26L
        )

        assertEquals(8, selected.size)
        assertEquals(selected.distinct(), selected)
    }

    @Test
    fun select_usesSeedToShuffleApps() {
        val apps = (0 until 8).map { index -> "app-$index" }

        val selected = LauncherTodayAppSuggester.select(
            apps = apps,
            limit = 8,
            stableKey = { key -> key },
            seed = 26L
        )

        assertTrue(selected != apps)
        assertEquals(apps.sorted(), selected.sorted())
    }
}

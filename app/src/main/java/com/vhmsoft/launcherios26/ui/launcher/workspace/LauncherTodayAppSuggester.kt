package com.vhmsoft.launcherios26.ui.launcher.workspace

import kotlin.random.Random

internal object LauncherTodayAppSuggester {
    fun <T> select(
        apps: List<T>,
        limit: Int,
        stableKey: (T) -> String,
        seed: Long
    ): List<T> {
        if (limit <= 0) return emptyList()

        return apps
            .distinctBy(stableKey)
            .shuffled(Random(seed))
            .take(limit)
    }
}

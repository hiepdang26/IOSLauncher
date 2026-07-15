package com.vhmsoft.launcherios26.features.launcher

object SuggestedAppsViewPolicy {
    fun hasRequiredViews(
        usageAccessPrompt: Any?,
        suggestedAppsGrid: Any?
    ): Boolean {
        return usageAccessPrompt != null && suggestedAppsGrid != null
    }

    fun <T : Any> suggestedAppsRootForSearchTextObserver(
        swipeSearchContainer: T,
        usedAppsLayoutRoot: T?
    ): T {
        return usedAppsLayoutRoot ?: swipeSearchContainer
    }
}

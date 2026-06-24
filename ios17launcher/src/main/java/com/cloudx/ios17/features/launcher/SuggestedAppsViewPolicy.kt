package com.cloudx.ios17.features.launcher

object SuggestedAppsViewPolicy {
    fun hasRequiredViews(
        usageAccessPrompt: Any?,
        suggestedAppsGrid: Any?
    ): Boolean {
        return usageAccessPrompt != null && suggestedAppsGrid != null
    }
}

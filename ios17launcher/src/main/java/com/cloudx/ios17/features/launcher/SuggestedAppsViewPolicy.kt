package com.cloudx.ios17.features.launcher

class SuggestedAppsViewPolicy private constructor() {
    companion object {
        @JvmStatic
        fun hasRequiredViews(openUsageAccessSettingsView: Any?, suggestedAppsGridView: Any?): Boolean {
            return openUsageAccessSettingsView != null && suggestedAppsGridView != null
        }
    }
}

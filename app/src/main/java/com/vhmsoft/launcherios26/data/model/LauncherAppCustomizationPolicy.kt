package com.vhmsoft.launcherios26.data.model

object LauncherAppCustomizationPolicy {
    fun apply(
        apps: List<LauncherApp>,
        hiddenIconKeys: Set<String>,
        customLabels: Map<String, String>
    ): List<LauncherApp> {
        return apps
            .filterNot { app -> app.iconKey in hiddenIconKeys }
            .map { app ->
                val customLabel = customLabels[app.iconKey]?.trim().orEmpty()
                if (customLabel.isNotEmpty()) {
                    app.copy(label = customLabel)
                } else {
                    app
                }
            }
    }
}

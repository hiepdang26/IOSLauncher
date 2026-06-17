package com.vhmsoft.launcherios26.data.model

data class LauncherApp(
    val label: String,
    val packageName: String,
    val className: String,
    val iconKey: String,
    val canUninstall: Boolean = true
)

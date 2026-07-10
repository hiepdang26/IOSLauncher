package com.cloudx.ios17.features.launcher

object LauncherBlurSettingsRefreshPolicy {
    enum class Target {
        DOCK,
        FOLDER,
        WIDGET,
        SEARCH
    }

    data class RefreshActions(
        val refreshDock: Boolean = false,
        val refreshFolderChrome: Boolean = false,
        val refreshFolderPreviews: Boolean = false,
        val refreshWidgets: Boolean = false,
        val refreshSearchChrome: Boolean = false
    )

    fun actionsFor(target: Target): RefreshActions =
        when (target) {
            Target.DOCK -> RefreshActions(refreshDock = true)
            Target.FOLDER -> RefreshActions(
                refreshFolderChrome = true,
                refreshFolderPreviews = true
            )
            Target.WIDGET -> RefreshActions(refreshWidgets = true)
            Target.SEARCH -> RefreshActions(refreshSearchChrome = true)
        }
}

package com.vhmsoft.launcherios26.ui.launcher.workspace

internal data class LauncherEditModePagerUpdate(
    val refreshWholePager: Boolean,
    val updateBoundHomePages: Boolean,
    val updateAttachedWidgetPage: Boolean,
    val refreshAllHomePages: Boolean
)

internal object LauncherEditModePagerUpdatePolicy {
    fun plan(
        currentEditing: Boolean,
        nextEditing: Boolean
    ): LauncherEditModePagerUpdate {
        val changed = currentEditing != nextEditing
        val completingEdit = currentEditing && !nextEditing
        return LauncherEditModePagerUpdate(
            refreshWholePager = false,
            updateBoundHomePages = changed,
            updateAttachedWidgetPage = changed,
            refreshAllHomePages = completingEdit
        )
    }
}

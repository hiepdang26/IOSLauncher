package com.cloudx.ios17.features.launcher

object LauncherEditModeEntryPolicy {
    enum class LongPressAction {
        SHOW_OPTIONS,
        START_DRAG
    }

    fun longPressAction(isEditing: Boolean): LongPressAction {
        return if (isEditing) LongPressAction.START_DRAG else LongPressAction.SHOW_OPTIONS
    }

    fun shouldEnterEditMode(editHomeClicked: Boolean): Boolean {
        return editHomeClicked
    }

    fun shouldEnterEditModeFromEmptyAreaLongPress(
        isEditing: Boolean,
        searchVisible: Boolean,
        folderVisible: Boolean
    ): Boolean {
        return !isEditing && !searchVisible && !folderVisible
    }

    fun shouldExitEditModeFromIconTap(): Boolean {
        return false
    }
}

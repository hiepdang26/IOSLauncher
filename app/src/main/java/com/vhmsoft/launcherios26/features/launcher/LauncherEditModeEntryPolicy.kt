package com.vhmsoft.launcherios26.features.launcher

import com.vhmsoft.launcherios26.core.utils.Constants

object LauncherEditModeEntryPolicy {
    enum class LongPressAction {
        SHOW_OPTIONS,
        START_DRAG
    }

    enum class TapAction {
        IGNORE,
        LAUNCH_ITEM,
        OPEN_FOLDER
    }

    enum class ReturnHomeAction {
        NONE,
        CLOSE_FOLDER,
        EXIT_EDIT_MODE,
        EXIT_TODAY_WIDGET_EDIT
    }

    fun longPressAction(isEditing: Boolean): LongPressAction {
        return if (isEditing) LongPressAction.START_DRAG else LongPressAction.SHOW_OPTIONS
    }

    fun tapAction(itemType: Int, isEditing: Boolean): TapAction {
        if (itemType == Constants.ITEM_TYPE_FOLDER) {
            return TapAction.OPEN_FOLDER
        }
        return if (isEditing) TapAction.IGNORE else TapAction.LAUNCH_ITEM
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

    fun returnHomeAction(
        isEditing: Boolean,
        todayWidgetEditing: Boolean,
        folderVisible: Boolean
    ): ReturnHomeAction {
        if (folderVisible) {
            return ReturnHomeAction.CLOSE_FOLDER
        }
        if (isEditing) {
            return ReturnHomeAction.EXIT_EDIT_MODE
        }
        if (todayWidgetEditing) {
            return ReturnHomeAction.EXIT_TODAY_WIDGET_EDIT
        }
        return ReturnHomeAction.NONE
    }
}

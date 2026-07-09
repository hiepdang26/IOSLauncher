package com.cloudx.ios17.features.launcher

import com.cloudx.ios17.core.utils.Constants
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherEditModeEntryPolicyTest {

    @Test
    fun longPress_showsOptionsBeforeEditing() {
        assertEquals(
            LauncherEditModeEntryPolicy.LongPressAction.SHOW_OPTIONS,
            LauncherEditModeEntryPolicy.longPressAction(isEditing = false)
        )
    }

    @Test
    fun longPress_startsDragWhileEditing() {
        assertEquals(
            LauncherEditModeEntryPolicy.LongPressAction.START_DRAG,
            LauncherEditModeEntryPolicy.longPressAction(isEditing = true)
        )
    }

    @Test
    fun editHomeMenuItem_entersEditMode() {
        assertTrue(LauncherEditModeEntryPolicy.shouldEnterEditMode(editHomeClicked = true))
    }

    @Test
    fun emptyAreaLongPress_entersEditModeWhenLauncherIsIdle() {
        assertTrue(
            LauncherEditModeEntryPolicy.shouldEnterEditModeFromEmptyAreaLongPress(
                isEditing = false,
                searchVisible = false,
                folderVisible = false
            )
        )
    }

    @Test
    fun emptyAreaLongPress_isIgnoredWhenLauncherIsBusy() {
        assertFalse(
            LauncherEditModeEntryPolicy.shouldEnterEditModeFromEmptyAreaLongPress(
                isEditing = true,
                searchVisible = false,
                folderVisible = false
            )
        )
        assertFalse(
            LauncherEditModeEntryPolicy.shouldEnterEditModeFromEmptyAreaLongPress(
                isEditing = false,
                searchVisible = true,
                folderVisible = false
            )
        )
        assertFalse(
            LauncherEditModeEntryPolicy.shouldEnterEditModeFromEmptyAreaLongPress(
                isEditing = false,
                searchVisible = false,
                folderVisible = true
            )
        )
    }

    @Test
    fun iconTap_doesNotExitEditMode() {
        assertFalse(LauncherEditModeEntryPolicy.shouldExitEditModeFromIconTap())
    }

    @Test
    fun returnToHome_closesOpenFolderBeforeLeavingEditMode() {
        assertEquals(
            LauncherEditModeEntryPolicy.ReturnHomeAction.CLOSE_FOLDER,
            LauncherEditModeEntryPolicy.returnHomeAction(
                isEditing = true,
                todayWidgetEditing = false,
                folderVisible = true
            )
        )
    }

    @Test
    fun returnToHome_leavesEditModeOnlyWhenNoFolderIsOpen() {
        assertEquals(
            LauncherEditModeEntryPolicy.ReturnHomeAction.EXIT_EDIT_MODE,
            LauncherEditModeEntryPolicy.returnHomeAction(
                isEditing = true,
                todayWidgetEditing = false,
                folderVisible = false
            )
        )
    }

    @Test
    fun returnToHome_closesFolderInNormalMode() {
        assertEquals(
            LauncherEditModeEntryPolicy.ReturnHomeAction.CLOSE_FOLDER,
            LauncherEditModeEntryPolicy.returnHomeAction(
                isEditing = false,
                todayWidgetEditing = false,
                folderVisible = true
            )
        )
    }

    @Test
    fun appTap_launchesOnlyOutsideEditMode() {
        assertEquals(
            LauncherEditModeEntryPolicy.TapAction.LAUNCH_ITEM,
            LauncherEditModeEntryPolicy.tapAction(
                itemType = Constants.ITEM_TYPE_APPLICATION,
                isEditing = false
            )
        )
        assertEquals(
            LauncherEditModeEntryPolicy.TapAction.IGNORE,
            LauncherEditModeEntryPolicy.tapAction(
                itemType = Constants.ITEM_TYPE_APPLICATION,
                isEditing = true
            )
        )
    }

    @Test
    fun folderTap_opensInBothNormalAndEditMode() {
        assertEquals(
            LauncherEditModeEntryPolicy.TapAction.OPEN_FOLDER,
            LauncherEditModeEntryPolicy.tapAction(
                itemType = Constants.ITEM_TYPE_FOLDER,
                isEditing = false
            )
        )
        assertEquals(
            LauncherEditModeEntryPolicy.TapAction.OPEN_FOLDER,
            LauncherEditModeEntryPolicy.tapAction(
                itemType = Constants.ITEM_TYPE_FOLDER,
                isEditing = true
            )
        )
    }
}

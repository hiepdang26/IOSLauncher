package com.cloudx.ios17.features.launcher

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
}

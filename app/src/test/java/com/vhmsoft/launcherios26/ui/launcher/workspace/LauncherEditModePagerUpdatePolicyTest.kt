package com.vhmsoft.launcherios26.ui.launcher.workspace

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherEditModePagerUpdatePolicyTest {
    @Test
    fun plan_updatesAttachedPagesWithoutRefreshingWholePagerWhenEditingChanges() {
        val update = LauncherEditModePagerUpdatePolicy.plan(
            currentEditing = true,
            nextEditing = false
        )

        assertFalse(update.refreshWholePager)
        assertTrue(update.updateBoundHomePages)
        assertTrue(update.updateAttachedWidgetPage)
    }

    @Test
    fun plan_returnsNoUpdateWhenEditingDoesNotChange() {
        val update = LauncherEditModePagerUpdatePolicy.plan(
            currentEditing = false,
            nextEditing = false
        )

        assertFalse(update.refreshWholePager)
        assertFalse(update.updateBoundHomePages)
        assertFalse(update.updateAttachedWidgetPage)
    }
}

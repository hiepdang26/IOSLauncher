package com.cloudx.ios17.features.launcher

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherUninstallConfirmationPolicyTest {
    @Test
    fun userInstalledAppsRequireConfirmationBeforeUninstall() {
        assertTrue(
            LauncherUninstallConfirmationPolicy.shouldConfirmBeforeUninstall(
                isApplication = true,
                canUninstall = true
            )
        )
    }

    @Test
    fun foldersAndLockedAppsDoNotUseAppUninstallConfirmation() {
        assertFalse(
            LauncherUninstallConfirmationPolicy.shouldConfirmBeforeUninstall(
                isApplication = false,
                canUninstall = true
            )
        )
        assertFalse(
            LauncherUninstallConfirmationPolicy.shouldConfirmBeforeUninstall(
                isApplication = true,
                canUninstall = false
            )
        )
    }

    @Test
    fun removesFromHomeOnlyAfterUninstallIntentStarts() {
        assertTrue(LauncherUninstallConfirmationPolicy.shouldRemoveFromHomeAfterUninstallRequest(true))
        assertFalse(LauncherUninstallConfirmationPolicy.shouldRemoveFromHomeAfterUninstallRequest(false))
    }
}

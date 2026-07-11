package com.vhmsoft.launcherios26.features.launcher

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherUninstallConfirmationPolicyTest {
    @Test
    fun userInstalledAppsUseSystemUninstallConfirmationOnly() {
        assertTrue(
            LauncherUninstallConfirmationPolicy.shouldRequestSystemUninstall(
                isApplication = true,
                canUninstall = true
            )
        )
    }

    @Test
    fun foldersAndLockedAppsDoNotStartSystemUninstall() {
        assertFalse(
            LauncherUninstallConfirmationPolicy.shouldRequestSystemUninstall(
                isApplication = false,
                canUninstall = true
            )
        )
        assertFalse(
            LauncherUninstallConfirmationPolicy.shouldRequestSystemUninstall(
                isApplication = true,
                canUninstall = false
            )
        )
    }

    @Test
    fun doesNotRemoveFromHomeUntilSystemConfirmsPackageRemoved() {
        assertFalse(LauncherUninstallConfirmationPolicy.shouldRemoveFromHomeAfterUninstallRequest(true))
        assertFalse(LauncherUninstallConfirmationPolicy.shouldRemoveFromHomeAfterUninstallRequest(false))
    }

    @Test
    fun removesFromHomeAfterSystemUninstallReturnsOk() {
        assertTrue(LauncherUninstallConfirmationPolicy.shouldRemoveFromHomeAfterUninstallResult(true))
        assertFalse(LauncherUninstallConfirmationPolicy.shouldRemoveFromHomeAfterUninstallResult(false))
    }
}

package com.vhmsoft.launcherios26.ui.launcher

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherShellModePolicyTest {
    @Test
    fun appModuleShell_neverShowsWorkspaceEvenWhenPackageIsDefaultLauncher() {
        val showWorkspace = LauncherShellModePolicy.shouldShowWorkspace(
            isCurrentDefaultLauncher = true,
            forceSettingsPanel = false
        )

        assertFalse(showWorkspace)
    }

    @Test
    fun appModuleShell_doesNotInitializeOrLoadWorkspaceData() {
        assertFalse(LauncherShellModePolicy.shouldInitializeWorkspace())
        assertFalse(LauncherShellModePolicy.shouldLoadWorkspaceData())
    }

    @Test
    fun appModuleShell_keepsFullSettingsOptionsVisible() {
        assertTrue(LauncherShellModePolicy.shouldShowFullOptionsMenu())
    }
}

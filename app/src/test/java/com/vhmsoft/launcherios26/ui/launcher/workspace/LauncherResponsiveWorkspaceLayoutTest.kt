package com.vhmsoft.launcherios26.ui.launcher.workspace

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherResponsiveWorkspaceLayoutTest {
    @Test
    fun resolve_keepsRegularSixRowsWhenScreenHasEnoughHeight() {
        val spec = LauncherResponsiveWorkspaceLayout.resolve(
            rootHeightPx = 840,
            density = 1f,
            preferredRows = 6,
            preferredIconSizeDp = 64,
            iphone8Style = false
        )

        assertEquals(6, spec.effectiveRows)
        assertEquals(64, spec.effectiveIconSizeDp)
        assertEquals(78, spec.homeTopPaddingDp)
    }

    @Test
    fun resolve_keepsSixRowsAndShrinksIconBeforeDroppingRows() {
        val spec = LauncherResponsiveWorkspaceLayout.resolve(
            rootHeightPx = 640,
            density = 1f,
            preferredRows = 6,
            preferredIconSizeDp = 64,
            iphone8Style = false
        )

        assertEquals(6, spec.effectiveRows)
        assertTrue(spec.effectiveIconSizeDp <= 56)
        assertTrue(spec.homeTopPaddingDp < 78)
        assertTrue(spec.dockHeightDp < 92)
    }

    @Test
    fun resolve_usesCompactFiveRowsOnVeryShortScreen() {
        val spec = LauncherResponsiveWorkspaceLayout.resolve(
            rootHeightPx = 560,
            density = 1f,
            preferredRows = 6,
            preferredIconSizeDp = 64,
            iphone8Style = false
        )

        assertEquals(5, spec.effectiveRows)
        assertTrue(spec.effectiveIconSizeDp <= 56)
    }

    @Test
    fun resolve_preservesUserFiveRowsOnTallScreen() {
        val spec = LauncherResponsiveWorkspaceLayout.resolve(
            rootHeightPx = 840,
            density = 1f,
            preferredRows = 5,
            preferredIconSizeDp = 70,
            iphone8Style = true
        )

        assertEquals(5, spec.effectiveRows)
        assertEquals(70, spec.effectiveIconSizeDp)
        assertTrue(spec.dockHeightDp > 92)
    }
}

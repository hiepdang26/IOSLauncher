package com.vhmsoft.launcherios26.core

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherRealtimeLiquidGlassPolicyTest {

    @Test
    fun realtimeLiquidGlass_requiresPreferenceAndQmDeveAndroid13MinSdk() {
        val qmDeveMinSdk = LauncherRealtimeLiquidGlassPolicy.QMDEVE_MIN_SDK

        assertEquals(33, qmDeveMinSdk)

        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldUseRealtimeLiquidGlass(
                liquidGlassEnabled = false,
                sdkInt = qmDeveMinSdk
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldUseRealtimeLiquidGlass(
                liquidGlassEnabled = true,
                sdkInt = qmDeveMinSdk - 1
            )
        )
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldUseRealtimeLiquidGlass(
                liquidGlassEnabled = true,
                sdkInt = qmDeveMinSdk
            )
        )
    }

    @Test
    fun fallbackBlurDrawsOnlyWhenRealtimeLiquidGlassIsInactive() {
        assertFalse(LauncherRealtimeLiquidGlassPolicy.shouldDrawFallbackBlur(realtimeLiquidGlassActive = true))
        assertTrue(LauncherRealtimeLiquidGlassPolicy.shouldDrawFallbackBlur(realtimeLiquidGlassActive = false))
    }

    @Test
    fun everySurfaceUsesPureRealtimeGlassBackgroundAfterRealtimeGlassIsActive() {
        LauncherRealtimeLiquidGlassPolicy.Surface.entries.forEach { surface ->
            assertTrue(
                LauncherRealtimeLiquidGlassPolicy.shouldUseTransparentSurfaceBackground(
                    surface = surface,
                    realtimeLiquidGlassActive = true
                )
            )
            assertFalse(
                LauncherRealtimeLiquidGlassPolicy.shouldUseTransparentSurfaceBackground(
                    surface = surface,
                    realtimeLiquidGlassActive = false
                )
            )
        }
    }

    @Test
    fun everySurfaceDisablesFallbackDrawingAfterRealtimeGlassIsActive() {
        LauncherRealtimeLiquidGlassPolicy.Surface.entries.forEach { surface ->
            assertTrue(
                LauncherRealtimeLiquidGlassPolicy.shouldDisableFallbackDrawingForExternalGlass(
                    surface = surface,
                    realtimeLiquidGlassActive = true
                )
            )
            assertFalse(
                LauncherRealtimeLiquidGlassPolicy.shouldDisableFallbackDrawingForExternalGlass(
                    surface = surface,
                    realtimeLiquidGlassActive = false
                )
            )
        }
    }

    @Test
    fun customMaterialOverlayDoesNotDrawOverRealtimeLiquidGlass() {
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldDrawMaterialOverlay(
                realtimeLiquidGlassActive = true,
                hasMaterialDrawable = true
            )
        )
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldDrawMaterialOverlay(
                realtimeLiquidGlassActive = false,
                hasMaterialDrawable = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldDrawMaterialOverlay(
                realtimeLiquidGlassActive = false,
                hasMaterialDrawable = false
            )
        )
    }

    @Test
    fun realtimeGlassRefreshesWhenVisibleAgain() {
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshRealtimeOnVisibilityChanged(
                realtimeEnabled = true,
                visible = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshRealtimeOnVisibilityChanged(
                realtimeEnabled = true,
                visible = false
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshRealtimeOnVisibilityChanged(
                realtimeEnabled = false,
                visible = true
            )
        )
    }

    @Test
    fun chromeTransformSyncDoesNotRefreshRealtimeGlassEveryFrame() {
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshRealtimeOnChromeSync(
                realtimeEnabled = true,
                wasVisible = true,
                nextVisible = true
            )
        )
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshRealtimeOnChromeSync(
                realtimeEnabled = true,
                wasVisible = false,
                nextVisible = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshRealtimeOnChromeSync(
                realtimeEnabled = false,
                wasVisible = false,
                nextVisible = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshRealtimeOnChromeSync(
                realtimeEnabled = true,
                wasVisible = true,
                nextVisible = false
            )
        )
    }

    @Test
    fun realtimeSourceCannotContainRealtimeTarget() {
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldBindRealtimeSource(
                sourceContainsTarget = false
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldBindRealtimeSource(
                sourceContainsTarget = true
            )
        )
    }

    @Test
    fun customWallpaperMirrorsIntoRealtimeSource() {
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldMirrorCustomWallpaperToSource(
                customWallpaperAvailable = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldMirrorCustomWallpaperToSource(
                customWallpaperAvailable = false
            )
        )
    }

    @Test
    fun defaultWallpaperFallbackSourceIsUsedOnlyWithoutCustomWallpaper() {
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldUseDefaultWallpaperSourceFallback(
                customWallpaperAvailable = true
            )
        )
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldUseDefaultWallpaperSourceFallback(
                customWallpaperAvailable = false
            )
        )
    }

    @Test
    fun realtimeProfileRecreationRunsOnlyWhenProfileChanges() {
        val profile = LauncherRealtimeLiquidGlassPolicy.profileFor(
            surface = LauncherRealtimeLiquidGlassPolicy.Surface.SEARCH_PILL,
            radiusDp = 22,
            darkMode = false
        )
        val sameTestLiquidGlassProfile = LauncherRealtimeLiquidGlassPolicy.profileFor(
            surface = LauncherRealtimeLiquidGlassPolicy.Surface.SEARCH_PILL,
            radiusDp = 24,
            darkMode = false
        )

        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldRecreateRealtimeView(
                currentProfile = null,
                nextProfile = profile
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldRecreateRealtimeView(
                currentProfile = profile,
                nextProfile = profile
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldRecreateRealtimeView(
                currentProfile = profile,
                nextProfile = sameTestLiquidGlassProfile
            )
        )
    }

    @Test
    fun searchPillProfile_usesDirectTestLiquidGlassMainActivityTuning() {
        val profile = LauncherRealtimeLiquidGlassPolicy.profileFor(
            surface = LauncherRealtimeLiquidGlassPolicy.Surface.SEARCH_PILL,
            radiusDp = 22,
            darkMode = false
        )

        assertEquals(90f, profile.cornerRadius, 0.001f)
        assertEquals(2.5f, profile.blurRadiusDp, 0.001f)
        assertEquals(50f, profile.refractionHeightDp, 0.01f)
        assertEquals(120f, profile.refractionOffsetDp, 0.01f)
        assertEquals(0.08f, profile.dispersion, 0.01f)
        assertEquals(1f, profile.tintRed, 0.01f)
        assertEquals(1f, profile.tintGreen, 0.01f)
        assertEquals(1f, profile.tintBlue, 0.01f)
        assertEquals(0.008f, profile.tintAlpha, 0.001f)
    }

    @Test
    fun allRealtimeProfilesUseTestLiquidGlassMainActivityTuning() {
        LauncherRealtimeLiquidGlassPolicy.Surface.entries.forEach { surface ->
            val profile = LauncherRealtimeLiquidGlassPolicy.profileFor(
                surface = surface,
                radiusDp = 24,
                darkMode = false
            )

            assertEquals(90f, profile.cornerRadius, 0.001f)
            assertEquals(2.5f, profile.blurRadiusDp, 0.001f)
            assertEquals(50f, profile.refractionHeightDp, 0.01f)
            assertEquals(120f, profile.refractionOffsetDp, 0.01f)
            assertEquals(0.08f, profile.dispersion, 0.01f)
            assertEquals(1f, profile.tintRed, 0.01f)
            assertEquals(1f, profile.tintGreen, 0.01f)
            assertEquals(1f, profile.tintBlue, 0.01f)
            assertEquals(0.008f, profile.tintAlpha, 0.001f)
        }
    }

    @Test
    fun realtimeProfilesIgnoreSurfaceRadiusAndUseTestLiquidGlassCornerRadius() {
        val dock = LauncherRealtimeLiquidGlassPolicy.profileFor(
            surface = LauncherRealtimeLiquidGlassPolicy.Surface.DOCK,
            radiusDp = 38,
            darkMode = false
        )
        val folderPanel = LauncherRealtimeLiquidGlassPolicy.profileFor(
            surface = LauncherRealtimeLiquidGlassPolicy.Surface.FOLDER_PANEL,
            radiusDp = 42,
            darkMode = false
        )

        assertEquals(90f, dock.cornerRadius, 0.001f)
        assertEquals(90f, folderPanel.cornerRadius, 0.001f)
        assertEquals(dock.blurRadiusDp, folderPanel.blurRadiusDp, 0.001f)
        assertEquals(dock.refractionHeightDp, folderPanel.refractionHeightDp, 0.01f)
        assertEquals(dock.refractionOffsetDp, folderPanel.refractionOffsetDp, 0.01f)
        assertEquals(dock.dispersion, folderPanel.dispersion, 0.01f)
        assertEquals(dock.tintAlpha, folderPanel.tintAlpha, 0.001f)
    }

    @Test
    fun liquidProfilesUseSameTintInDarkAndLightModes() {
        val light = LauncherRealtimeLiquidGlassPolicy.profileFor(
            surface = LauncherRealtimeLiquidGlassPolicy.Surface.FOLDER_PANEL,
            radiusDp = 42,
            darkMode = false
        )
        val dark = LauncherRealtimeLiquidGlassPolicy.profileFor(
            surface = LauncherRealtimeLiquidGlassPolicy.Surface.FOLDER_PANEL,
            radiusDp = 42,
            darkMode = true
        )

        assertEquals(light.cornerRadius, dark.cornerRadius, 0.001f)
        assertEquals(light.blurRadiusDp, dark.blurRadiusDp, 0.001f)
        assertEquals(light.refractionHeightDp, dark.refractionHeightDp, 0.01f)
        assertEquals(light.refractionOffsetDp, dark.refractionOffsetDp, 0.01f)
        assertEquals(light.dispersion, dark.dispersion, 0.01f)
        assertEquals(light.tintRed, dark.tintRed, 0.01f)
        assertEquals(light.tintGreen, dark.tintGreen, 0.01f)
        assertEquals(light.tintBlue, dark.tintBlue, 0.01f)
        assertEquals(light.tintAlpha, dark.tintAlpha, 0.01f)
    }

    @Test
    fun visibilityOverlayOnlyDrawsForSmallRealtimeSurfacesThatNeedContrast() {
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldDrawVisibilityOverlay(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.SEARCH_PILL,
                realtimeLiquidGlassActive = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldDrawVisibilityOverlay(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.SEARCH_RESULTS,
                realtimeLiquidGlassActive = true
            )
        )
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldDrawVisibilityOverlay(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.DOCK,
                realtimeLiquidGlassActive = true
            )
        )
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldDrawVisibilityOverlay(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.APP_LIBRARY_FOLDER,
                realtimeLiquidGlassActive = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldDrawVisibilityOverlay(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.DOCK,
                realtimeLiquidGlassActive = false
            )
        )
    }
}

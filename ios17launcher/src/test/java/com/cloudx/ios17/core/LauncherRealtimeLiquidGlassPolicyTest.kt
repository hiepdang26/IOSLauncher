package com.cloudx.ios17.core

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
    fun customMaterialOverlayDrawsWheneverMaterialExists() {
        assertTrue(
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
        val changedProfile = LauncherRealtimeLiquidGlassPolicy.profileFor(
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
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldRecreateRealtimeView(
                currentProfile = profile,
                nextProfile = changedProfile
            )
        )
    }

    @Test
    fun searchPillProfile_usesQmDeveLiquidGlassTuning() {
        val profile = LauncherRealtimeLiquidGlassPolicy.profileFor(
            surface = LauncherRealtimeLiquidGlassPolicy.Surface.SEARCH_PILL,
            radiusDp = 22,
            darkMode = false
        )

        assertEquals(22, profile.radiusDp)
        assertEquals(10f, profile.blurRadiusDp, 0.001f)
        assertEquals(16f, profile.refractionHeightDp, 0.01f)
        assertEquals(48f, profile.refractionOffsetDp, 0.01f)
        assertEquals(0.35f, profile.dispersion, 0.01f)
        assertEquals(1f, profile.tintRed, 0.01f)
        assertEquals(1f, profile.tintGreen, 0.01f)
        assertEquals(1f, profile.tintBlue, 0.01f)
        assertEquals(0.08f, profile.tintAlpha, 0.01f)
    }

    @Test
    fun dockAndPageIndicatorProfilesKeepHomeChromeLiquidGlassTuning() {
        val appLibrary = LauncherRealtimeLiquidGlassPolicy.profileFor(
            surface = LauncherRealtimeLiquidGlassPolicy.Surface.APP_LIBRARY_FOLDER,
            radiusDp = 20,
            darkMode = false
        )
        val homeProfiles = listOf(
            LauncherRealtimeLiquidGlassPolicy.profileFor(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.DOCK,
                radiusDp = 38,
                darkMode = false
            ),
            LauncherRealtimeLiquidGlassPolicy.profileFor(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.PAGE_INDICATOR,
                radiusDp = 17,
                darkMode = false
            )
        )

        homeProfiles.forEach { profile ->
            assertEquals(14f, profile.blurRadiusDp, 0.001f)
            assertEquals(18f, profile.refractionHeightDp, 0.01f)
            assertEquals(54f, profile.refractionOffsetDp, 0.01f)
            assertEquals(appLibrary.dispersion, profile.dispersion, 0.01f)
            assertEquals(appLibrary.tintRed, profile.tintRed, 0.01f)
            assertEquals(appLibrary.tintGreen, profile.tintGreen, 0.01f)
            assertEquals(appLibrary.tintBlue, profile.tintBlue, 0.01f)
            assertEquals(0.03f, profile.tintAlpha, 0.01f)
        }
        assertEquals(38, homeProfiles[0].radiusDp)
        assertEquals(17, homeProfiles[1].radiusDp)
    }

    @Test
    fun folderLiquidGlassProfilesMatchAppLibraryFolderTuning() {
        val appLibrary = LauncherRealtimeLiquidGlassPolicy.profileFor(
            surface = LauncherRealtimeLiquidGlassPolicy.Surface.APP_LIBRARY_FOLDER,
            radiusDp = 20,
            darkMode = false
        )
        val folderPreview = LauncherRealtimeLiquidGlassPolicy.profileFor(
            surface = LauncherRealtimeLiquidGlassPolicy.Surface.FOLDER_PREVIEW,
            radiusDp = 16,
            darkMode = false
        )
        val folderPanel = LauncherRealtimeLiquidGlassPolicy.profileFor(
            surface = LauncherRealtimeLiquidGlassPolicy.Surface.FOLDER_PANEL,
            radiusDp = 42,
            darkMode = false
        )

        listOf(folderPreview, folderPanel).forEach { profile ->
            assertEquals(appLibrary.blurRadiusDp, profile.blurRadiusDp, 0.001f)
            assertEquals(appLibrary.refractionHeightDp, profile.refractionHeightDp, 0.01f)
            assertEquals(appLibrary.refractionOffsetDp, profile.refractionOffsetDp, 0.01f)
            assertEquals(appLibrary.dispersion, profile.dispersion, 0.01f)
            assertEquals(appLibrary.tintRed, profile.tintRed, 0.01f)
            assertEquals(appLibrary.tintGreen, profile.tintGreen, 0.01f)
            assertEquals(appLibrary.tintBlue, profile.tintBlue, 0.01f)
            assertEquals(appLibrary.tintAlpha, profile.tintAlpha, 0.01f)
        }
        assertEquals(16, folderPreview.radiusDp)
        assertEquals(42, folderPanel.radiusDp)
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

        assertEquals(light.radiusDp, dark.radiusDp)
        assertEquals(light.blurRadiusDp, dark.blurRadiusDp, 0.001f)
        assertEquals(light.refractionHeightDp, dark.refractionHeightDp, 0.01f)
        assertEquals(light.refractionOffsetDp, dark.refractionOffsetDp, 0.01f)
        assertEquals(light.dispersion, dark.dispersion, 0.01f)
        assertEquals(light.tintRed, dark.tintRed, 0.01f)
        assertEquals(light.tintGreen, dark.tintGreen, 0.01f)
        assertEquals(light.tintBlue, dark.tintBlue, 0.01f)
        assertEquals(light.tintAlpha, dark.tintAlpha, 0.01f)
    }
}

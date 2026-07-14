package com.vhmsoft.launcherios26.ui.launcher.workspace

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class AndroidLiquidGlassPolicyTest {

    @Test
    fun realtimeLiquidGlassRequiresAndroid13AndPreference() {
        val minSdk = AndroidLiquidGlassPolicy.QMDEVE_MIN_SDK

        assertEquals(33, minSdk)
        assertFalse(AndroidLiquidGlassPolicy.shouldUseRealtimeLiquidGlass(false, minSdk))
        assertFalse(AndroidLiquidGlassPolicy.shouldUseRealtimeLiquidGlass(true, minSdk - 1))
        assertTrue(AndroidLiquidGlassPolicy.shouldUseRealtimeLiquidGlass(true, minSdk))
    }

    @Test
    fun everySurfaceFallbackBackgroundDrawsOnlyWhenRealtimeGlassIsInactive() {
        AndroidLiquidGlassPolicy.Surface.entries.forEach { surface ->
            assertFalse(
                AndroidLiquidGlassPolicy.shouldDrawFallbackBackground(
                    surface = surface,
                    realtimeLiquidGlassActive = true
                )
            )
            assertTrue(
                AndroidLiquidGlassPolicy.shouldDrawFallbackBackground(
                    surface = surface,
                    realtimeLiquidGlassActive = false
                )
            )
        }
    }

    @Test
    fun appLibrarySurfacesDoNotDrawFallbackMaterialWhileWaitingForQmDeveGlass() {
        assertFalse(
            AndroidLiquidGlassPolicy.shouldDrawFallbackBackground(
                surface = AndroidLiquidGlassPolicy.Surface.APP_LIBRARY_FOLDER,
                realtimeLiquidGlassActive = false,
                realtimeEnabled = true
            )
        )
        assertFalse(
            AndroidLiquidGlassPolicy.shouldDrawFallbackBackground(
                surface = AndroidLiquidGlassPolicy.Surface.APP_LIBRARY_SEARCH,
                realtimeLiquidGlassActive = false,
                realtimeEnabled = true
            )
        )
        assertTrue(
            AndroidLiquidGlassPolicy.shouldDrawFallbackBackground(
                surface = AndroidLiquidGlassPolicy.Surface.APP_LIBRARY_FOLDER,
                realtimeLiquidGlassActive = false,
                realtimeEnabled = false
            )
        )
        assertTrue(
            AndroidLiquidGlassPolicy.shouldDrawFallbackBackground(
                surface = AndroidLiquidGlassPolicy.Surface.SEARCH_PILL,
                realtimeLiquidGlassActive = false,
                realtimeEnabled = true
            )
        )
    }

    @Test
    fun everySurfaceContentBackgroundIsTransparentOnlyAfterRealtimeGlassIsActive() {
        AndroidLiquidGlassPolicy.Surface.entries.forEach { surface ->
            assertTrue(
                AndroidLiquidGlassPolicy.shouldUseTransparentContentBackground(
                    surface = surface,
                    realtimeLiquidGlassActive = true
                )
            )
            assertFalse(
                AndroidLiquidGlassPolicy.shouldUseTransparentContentBackground(
                    surface = surface,
                    realtimeLiquidGlassActive = false
                )
            )
        }
    }

    @Test
    fun realtimeSourceCannotContainRealtimeTarget() {
        assertTrue(AndroidLiquidGlassPolicy.shouldBindRealtimeSource(sourceContainsTarget = false))
        assertFalse(AndroidLiquidGlassPolicy.shouldBindRealtimeSource(sourceContainsTarget = true))
    }

    @Test
    fun activeRealtimeGlassIsLaidOutToNonZeroHostBounds() {
        assertTrue(
            AndroidLiquidGlassPolicy.shouldLayoutRealtimeViewToHostBounds(
                hostWidth = 424,
                hostHeight = 457,
                realtimeLiquidGlassActive = true
            )
        )
        assertFalse(
            AndroidLiquidGlassPolicy.shouldLayoutRealtimeViewToHostBounds(
                hostWidth = 0,
                hostHeight = 457,
                realtimeLiquidGlassActive = true
            )
        )
        assertFalse(
            AndroidLiquidGlassPolicy.shouldLayoutRealtimeViewToHostBounds(
                hostWidth = 424,
                hostHeight = 457,
                realtimeLiquidGlassActive = false
            )
        )
    }

    @Test
    fun realtimeGlassViewRecreationRunsOnlyWhenProfileChanges() {
        val profile = AndroidLiquidGlassPolicy.profileFor(
            surface = AndroidLiquidGlassPolicy.Surface.SEARCH_PILL,
            radiusDp = 17
        )
        val sameTestLiquidGlassProfile = AndroidLiquidGlassPolicy.profileFor(
            surface = AndroidLiquidGlassPolicy.Surface.SEARCH_PILL,
            radiusDp = 22
        )

        assertTrue(AndroidLiquidGlassPolicy.shouldRecreateRealtimeView(null, profile))
        assertFalse(AndroidLiquidGlassPolicy.shouldRecreateRealtimeView(profile, profile))
        assertFalse(AndroidLiquidGlassPolicy.shouldRecreateRealtimeView(profile, sameTestLiquidGlassProfile))
    }

    @Test
    fun appLibraryFolderKeepsRealtimeViewWhenHolderIsReboundWithSameProfile() {
        val profile = AndroidLiquidGlassPolicy.profileFor(
            surface = AndroidLiquidGlassPolicy.Surface.APP_LIBRARY_FOLDER,
            radiusDp = 38
        )

        assertFalse(
            AndroidLiquidGlassPolicy.shouldRecreateRealtimeView(
                surface = AndroidLiquidGlassPolicy.Surface.APP_LIBRARY_FOLDER,
                currentProfile = profile,
                nextProfile = profile,
                forceRefresh = true,
                realtimeLiquidGlassActive = true
            )
        )
        assertFalse(
            AndroidLiquidGlassPolicy.shouldRecreateRealtimeView(
                surface = AndroidLiquidGlassPolicy.Surface.APP_LIBRARY_FOLDER,
                currentProfile = profile,
                nextProfile = profile,
                forceRefresh = true,
                realtimeLiquidGlassActive = false
            )
        )
        assertFalse(
            AndroidLiquidGlassPolicy.shouldRecreateRealtimeView(
                surface = AndroidLiquidGlassPolicy.Surface.DOCK,
                currentProfile = profile,
                nextProfile = profile,
                forceRefresh = true
            )
        )
    }

    @Test
    fun realtimeSourceBindRunsOnlyWhenSourceChangesOrGlassIsInactive() {
        assertFalse(
            AndroidLiquidGlassPolicy.shouldBindRealtimeViewSource(
                sourceChanged = false,
                realtimeLiquidGlassActive = true,
                sourceBoundWhileVisible = true
            )
        )
        assertTrue(
            AndroidLiquidGlassPolicy.shouldBindRealtimeViewSource(
                sourceChanged = true,
                realtimeLiquidGlassActive = true,
                sourceBoundWhileVisible = true
            )
        )
        assertTrue(
            AndroidLiquidGlassPolicy.shouldBindRealtimeViewSource(
                sourceChanged = false,
                realtimeLiquidGlassActive = false,
                sourceBoundWhileVisible = true
            )
        )
        assertTrue(
            AndroidLiquidGlassPolicy.shouldBindRealtimeViewSource(
                sourceChanged = false,
                realtimeLiquidGlassActive = true,
                sourceBoundWhileVisible = false
            )
        )
    }

    @Test
    fun allWorkspaceProfilesUseTestLiquidGlassMainActivityTuningExceptFolderPreviewShape() {
        AndroidLiquidGlassPolicy.Surface.entries.forEach { surface ->
            val profile = AndroidLiquidGlassPolicy.profileFor(
                surface = surface,
                radiusDp = 38
            )

            val expectedCornerRadius = if (surface == AndroidLiquidGlassPolicy.Surface.FOLDER_PREVIEW) {
                38f
            } else {
                90f
            }
            assertEquals(expectedCornerRadius, profile.cornerRadius, 0.001f)
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
    fun workspaceFolderPreviewProfileUsesIconCornerRadiusInsteadOfPillRadius() {
        val profile = AndroidLiquidGlassPolicy.profileFor(
            surface = AndroidLiquidGlassPolicy.Surface.FOLDER_PREVIEW,
            radiusDp = 13
        )

        assertEquals(13f, profile.cornerRadius, 0.001f)
        assertEquals(2.5f, profile.blurRadiusDp, 0.001f)
        assertEquals(50f, profile.refractionHeightDp, 0.01f)
        assertEquals(120f, profile.refractionOffsetDp, 0.01f)
        assertEquals(0.08f, profile.dispersion, 0.01f)
    }

    @Test
    fun removeBadgeHasLiquidGlassProfile() {
        val profile = AndroidLiquidGlassPolicy.profileFor(
            surface = AndroidLiquidGlassPolicy.Surface.REMOVE_BADGE,
            radiusDp = 12
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
    fun visibilityOverlayNeverDrawsOverQmDeveRealtimeLiquidGlass() {
        AndroidLiquidGlassPolicy.Surface.entries.forEach { surface ->
            assertFalse(
                AndroidLiquidGlassPolicy.shouldDrawVisibilityOverlay(
                    surface = surface,
                    realtimeLiquidGlassActive = true
                )
            )
            assertFalse(
                AndroidLiquidGlassPolicy.shouldDrawVisibilityOverlay(
                    surface = surface,
                    realtimeLiquidGlassActive = false
                )
            )
        }
    }

    @Test
    fun removeBadgeUsesStaticMaterialForEditModeSwipePerformance() {
        assertFalse(AndroidLiquidGlassPolicy.shouldUseRealtimeRemoveBadge(realtimeEnabled = true))
        assertFalse(AndroidLiquidGlassPolicy.shouldUseRealtimeRemoveBadge(realtimeEnabled = false))
    }
}

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
    fun realtimeGeneratedSurfacesExceptIndicatorUseTransparentBackgroundWhileWaitingForFirstBind() {
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldUseTransparentSurfaceBackground(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.APP_LIBRARY_SEARCH,
                realtimeLiquidGlassActive = false,
                realtimeEnabled = true
            )
        )
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldUseTransparentSurfaceBackground(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.SEARCH_RESULTS,
                realtimeLiquidGlassActive = false,
                realtimeEnabled = true
            )
        )
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldUseTransparentSurfaceBackground(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.APP_LIBRARY_FOLDER,
                realtimeLiquidGlassActive = false,
                realtimeEnabled = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldUseTransparentSurfaceBackground(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.PAGE_INDICATOR,
                realtimeLiquidGlassActive = false,
                realtimeEnabled = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldUseTransparentSurfaceBackground(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.SEARCH_PILL,
                realtimeLiquidGlassActive = false,
                realtimeEnabled = false
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldUseTransparentSurfaceBackground(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.DOCK,
                realtimeLiquidGlassActive = false,
                realtimeEnabled = true
            )
        )
    }

    @Test
    fun onlySearchRealtimeSurfacesKeepStableMaterialBehindGlass() {
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldUseStableMaterialBehindRealtimeGlass(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.SEARCH_PILL,
                realtimeEnabled = true
            )
        )
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldUseStableMaterialBehindRealtimeGlass(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.SEARCH_RESULTS,
                realtimeEnabled = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldUseStableMaterialBehindRealtimeGlass(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.APP_LIBRARY_FOLDER,
                realtimeEnabled = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldUseStableMaterialBehindRealtimeGlass(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.APP_LIBRARY_SEARCH,
                realtimeEnabled = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldUseStableMaterialBehindRealtimeGlass(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.SEARCH_PILL,
                realtimeEnabled = false
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldUseStableMaterialBehindRealtimeGlass(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.DOCK,
                realtimeEnabled = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldUseStableMaterialBehindRealtimeGlass(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.PAGE_INDICATOR,
                realtimeEnabled = true
            )
        )
    }

    @Test
    fun dockFallbackDrawingIsDisabledWhenRealtimeGlassIsActive() {
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldDisableFallbackDrawingForExternalGlass(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.DOCK,
                realtimeLiquidGlassActive = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldDisableFallbackDrawingForExternalGlass(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.DOCK,
                realtimeLiquidGlassActive = false
            )
        )
    }

    @Test
    fun nonDockExternalSurfacesDisableFallbackDrawingAfterRealtimeGlassIsActive() {
        LauncherRealtimeLiquidGlassPolicy.Surface.entries
            .filterNot { it == LauncherRealtimeLiquidGlassPolicy.Surface.DOCK }
            .forEach { surface ->
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
    fun pageIndicatorKeepsForegroundBackgroundUntilRealtimeGlassIsActive() {
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldClearForegroundBackgroundForExternalGlass(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.PAGE_INDICATOR,
                realtimeLiquidGlassActive = false,
                realtimeEnabled = true
            )
        )
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldClearForegroundBackgroundForExternalGlass(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.PAGE_INDICATOR,
                realtimeLiquidGlassActive = true,
                realtimeEnabled = false
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldClearForegroundBackgroundForExternalGlass(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.PAGE_INDICATOR,
                realtimeLiquidGlassActive = false,
                realtimeEnabled = false
            )
        )
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
    fun hiddenDockKeepsRealtimeGlassAttachedSoItCanRestoreWithoutRebind() {
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldKeepRealtimeGlassAttachedWhenChromeHidden(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.DOCK,
                realtimeEnabled = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldKeepRealtimeGlassAttachedWhenChromeHidden(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.PAGE_INDICATOR,
                realtimeEnabled = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldKeepRealtimeGlassAttachedWhenChromeHidden(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.DOCK,
                realtimeEnabled = false
            )
        )
    }

    @Test
    fun dockRestoreRefreshesOnlyWhenRealtimeGlassWasNotKeptActive() {
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshRealtimeOnPersistentChromeRestore(
                realtimeEnabled = true,
                nextVisible = true,
                realtimeLiquidGlassActive = true
            )
        )
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshRealtimeOnPersistentChromeRestore(
                realtimeEnabled = true,
                nextVisible = true,
                realtimeLiquidGlassActive = false
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshRealtimeOnPersistentChromeRestore(
                realtimeEnabled = true,
                nextVisible = false,
                realtimeLiquidGlassActive = false
            )
        )
    }

    @Test
    fun appearanceApplyRestoresVisibleRealtimeDockGlassAlphaAfterPreferenceToggle() {
        assertEquals(
            1f,
            LauncherRealtimeLiquidGlassPolicy.realtimeDockGlassAlphaForAppearanceApply(
                realtimeDockEnabled = true,
                dockVisible = true,
                dockAlpha = 0f
            ),
            0.001f
        )
        assertEquals(
            0f,
            LauncherRealtimeLiquidGlassPolicy.realtimeDockGlassAlphaForAppearanceApply(
                realtimeDockEnabled = true,
                dockVisible = false,
                dockAlpha = 1f
            ),
            0.001f
        )
        assertEquals(
            0.35f,
            LauncherRealtimeLiquidGlassPolicy.realtimeDockGlassAlphaForAppearanceApply(
                realtimeDockEnabled = false,
                dockVisible = true,
                dockAlpha = 0.35f
            ),
            0.001f
        )
    }

    @Test
    fun visibleRealtimeIndicatorUsesDockGlassAlphaRule() {
        assertEquals(
            1f,
            LauncherRealtimeLiquidGlassPolicy.realtimeIndicatorGlassAlphaForChromeSync(
                realtimeIndicatorEnabled = true,
                indicatorVisible = true,
                indicatorAlpha = 0f
            ),
            0.001f
        )
        assertEquals(
            0f,
            LauncherRealtimeLiquidGlassPolicy.realtimeIndicatorGlassAlphaForChromeSync(
                realtimeIndicatorEnabled = true,
                indicatorVisible = false,
                indicatorAlpha = 1f
            ),
            0.001f
        )
        assertEquals(
            0.4f,
            LauncherRealtimeLiquidGlassPolicy.realtimeIndicatorGlassAlphaForChromeSync(
                realtimeIndicatorEnabled = false,
                indicatorVisible = true,
                indicatorAlpha = 0.4f
            ),
            0.001f
        )
    }

    @Test
    fun appearanceApplyRefreshesFolderPreviewRealtimeGlassWhenPreferenceIsEnabled() {
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshFolderPreviewRealtimeOnAppearanceApply(
                realtimeEnabled = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshFolderPreviewRealtimeOnAppearanceApply(
                realtimeEnabled = false
            )
        )
    }

    @Test
    fun realtimeDescendantRefreshRestoresHiddenGlassWhenLiquidGlassIsEnabled() {
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshRealtimeDescendant(
                realtimeEnabled = true,
                descendantShown = false
            )
        )
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshRealtimeDescendant(
                realtimeEnabled = false,
                descendantShown = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshRealtimeDescendant(
                realtimeEnabled = false,
                descendantShown = false
            )
        )
    }

    @Test
    fun pageRestoreRefreshesFolderPreviewHostOnlyWhenRealtimePreviewIsEnabled() {
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshFolderPreviewHostOnPageRestore(
                realtimeEnabled = true,
                folderPreviewRealtimeEnabled = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshFolderPreviewHostOnPageRestore(
                realtimeEnabled = true,
                folderPreviewRealtimeEnabled = false
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshFolderPreviewHostOnPageRestore(
                realtimeEnabled = false,
                folderPreviewRealtimeEnabled = true
            )
        )
    }

    @Test
    fun settledPageDoesNotRefreshRealtimeGlassEveryDraw() {
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshRealtimeOnSettledPage(
                realtimeEnabled = true,
                wasScrolling = true,
                pageChanged = false
            )
        )
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshRealtimeOnSettledPage(
                realtimeEnabled = true,
                wasScrolling = false,
                pageChanged = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshRealtimeOnSettledPage(
                realtimeEnabled = true,
                wasScrolling = false,
                pageChanged = false
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshRealtimeOnSettledPage(
                realtimeEnabled = false,
                wasScrolling = true,
                pageChanged = true
            )
        )
    }

    @Test
    fun settledPageDoesNotRebindPersistentChromeGlass() {
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshRealtimeSurfaceOnSettledPage(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.DOCK,
                realtimeEnabled = true,
                wasScrolling = true,
                pageChanged = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshRealtimeSurfaceOnSettledPage(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.PAGE_INDICATOR,
                realtimeEnabled = true,
                wasScrolling = true,
                pageChanged = true
            )
        )
    }

    @Test
    fun settledPageStillRefreshesPageContentGlass() {
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshRealtimeSurfaceOnSettledPage(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.APP_LIBRARY_FOLDER,
                realtimeEnabled = true,
                wasScrolling = true,
                pageChanged = true
            )
        )
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshRealtimeSurfaceOnSettledPage(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.FOLDER_PREVIEW,
                realtimeEnabled = true,
                wasScrolling = true,
                pageChanged = false
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshRealtimeSurfaceOnSettledPage(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.APP_LIBRARY_FOLDER,
                realtimeEnabled = true,
                wasScrolling = false,
                pageChanged = false
            )
        )
    }

    @Test
    fun appLibrarySearchDismissRefreshesRealtimeGlassAfterPageIsVisibleAgain() {
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshAppLibraryRealtimeOnSearchDismiss(
                realtimeEnabled = true,
                pageVisible = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshAppLibraryRealtimeOnSearchDismiss(
                realtimeEnabled = true,
                pageVisible = false
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshAppLibraryRealtimeOnSearchDismiss(
                realtimeEnabled = false,
                pageVisible = true
            )
        )
    }

    @Test
    fun swipeSearchOpenRefreshesRealtimeSearchGlassOnlyWhenVisibleAgain() {
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshSwipeSearchRealtimeOnOpen(
                realtimeEnabled = true,
                searchVisible = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshSwipeSearchRealtimeOnOpen(
                realtimeEnabled = true,
                searchVisible = false
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshSwipeSearchRealtimeOnOpen(
                realtimeEnabled = false,
                searchVisible = true
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
    fun activeRealtimeGlassIsLaidOutToNonZeroHostBounds() {
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldLayoutRealtimeViewToHostBounds(
                hostWidth = 424,
                hostHeight = 457,
                realtimeLiquidGlassActive = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldLayoutRealtimeViewToHostBounds(
                hostWidth = 0,
                hostHeight = 457,
                realtimeLiquidGlassActive = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldLayoutRealtimeViewToHostBounds(
                hostWidth = 424,
                hostHeight = 457,
                realtimeLiquidGlassActive = false
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
    fun explicitRefreshKeepsStableRealtimeViewsWhenProfileIsUnchanged() {
        val profile = LauncherRealtimeLiquidGlassPolicy.profileFor(
            surface = LauncherRealtimeLiquidGlassPolicy.Surface.FOLDER_PREVIEW,
            radiusDp = 8,
            darkMode = false
        )

        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldRecreateRealtimeView(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.FOLDER_PREVIEW,
                currentProfile = profile,
                nextProfile = profile,
                forceRefresh = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldRecreateRealtimeView(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.FOLDER_PANEL,
                currentProfile = profile,
                nextProfile = profile,
                forceRefresh = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldRecreateRealtimeView(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.APP_LIBRARY_FOLDER,
                currentProfile = profile,
                nextProfile = profile,
                forceRefresh = true,
                realtimeLiquidGlassActive = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldRecreateRealtimeView(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.APP_LIBRARY_FOLDER,
                currentProfile = profile,
                nextProfile = profile,
                forceRefresh = true,
                realtimeLiquidGlassActive = false
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldRecreateRealtimeView(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.PAGE_INDICATOR,
                currentProfile = profile,
                nextProfile = profile,
                forceRefresh = true,
                realtimeLiquidGlassActive = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldRecreateRealtimeView(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.SEARCH_PILL,
                currentProfile = profile,
                nextProfile = profile,
                forceRefresh = true,
                realtimeLiquidGlassActive = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldRecreateRealtimeView(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.SEARCH_RESULTS,
                currentProfile = profile,
                nextProfile = profile,
                forceRefresh = true,
                realtimeLiquidGlassActive = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldRecreateRealtimeView(
                surface = LauncherRealtimeLiquidGlassPolicy.Surface.DOCK,
                currentProfile = profile,
                nextProfile = profile,
                forceRefresh = true
            )
        )
    }

    @Test
    fun realtimeSourceBindRunsOnlyWhenSourceChangesOrGlassIsInactive() {
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldBindRealtimeViewSource(
                sourceChanged = false,
                realtimeLiquidGlassActive = true,
                sourceBoundWhileVisible = true
            )
        )
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldBindRealtimeViewSource(
                sourceChanged = true,
                realtimeLiquidGlassActive = true,
                sourceBoundWhileVisible = true
            )
        )
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldBindRealtimeViewSource(
                sourceChanged = false,
                realtimeLiquidGlassActive = false,
                sourceBoundWhileVisible = true
            )
        )
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldBindRealtimeViewSource(
                sourceChanged = false,
                realtimeLiquidGlassActive = true,
                sourceBoundWhileVisible = false
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
    fun realtimeProfilesUseTestLiquidGlassMainActivityTuningExceptFolderPreviewShape() {
        LauncherRealtimeLiquidGlassPolicy.Surface.entries.forEach { surface ->
            val profile = LauncherRealtimeLiquidGlassPolicy.profileFor(
                surface = surface,
                radiusDp = 24,
                darkMode = false
            )

            val expectedCornerRadius = if (surface == LauncherRealtimeLiquidGlassPolicy.Surface.FOLDER_PREVIEW) {
                24f
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
    fun folderPreviewProfileUsesIconCornerRadiusInsteadOfPillRadius() {
        val profile = LauncherRealtimeLiquidGlassPolicy.profileFor(
            surface = LauncherRealtimeLiquidGlassPolicy.Surface.FOLDER_PREVIEW,
            radiusDp = 13,
            darkMode = false
        )

        assertEquals(13f, profile.cornerRadius, 0.001f)
        assertEquals(2.5f, profile.blurRadiusDp, 0.001f)
        assertEquals(50f, profile.refractionHeightDp, 0.01f)
        assertEquals(120f, profile.refractionOffsetDp, 0.01f)
        assertEquals(0.08f, profile.dispersion, 0.01f)
    }

    @Test
    fun removeBadgeProfileUsesFullyRoundedLiquidGlassShape() {
        val profile = LauncherRealtimeLiquidGlassPolicy.profileFor(
            surface = LauncherRealtimeLiquidGlassPolicy.Surface.REMOVE_BADGE,
            radiusDp = 12,
            darkMode = false
        )

        assertEquals(90f, profile.cornerRadius, 0.001f)
        assertEquals(2.5f, profile.blurRadiusDp, 0.001f)
        assertEquals(50f, profile.refractionHeightDp, 0.01f)
        assertEquals(120f, profile.refractionOffsetDp, 0.01f)
        assertEquals(0.08f, profile.dispersion, 0.01f)
        assertEquals(0.008f, profile.tintAlpha, 0.001f)
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
    fun folderPanelRefreshesRealtimeGlassWhenOpenContainerBecomesVisible() {
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshFolderPanelRealtimeOnOpenVisible(
                realtimeEnabled = true,
                folderVisible = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshFolderPanelRealtimeOnOpenVisible(
                realtimeEnabled = true,
                folderVisible = false
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshFolderPanelRealtimeOnOpenVisible(
                realtimeEnabled = false,
                folderVisible = true
            )
        )
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
    fun realtimeSurfacesDoNotDrawMaterialVisibilityOverlayOverQmDeveGlass() {
        LauncherRealtimeLiquidGlassPolicy.Surface.entries
            .forEach { surface ->
                assertFalse(
                    LauncherRealtimeLiquidGlassPolicy.shouldDrawVisibilityOverlay(
                        surface = surface,
                        realtimeLiquidGlassActive = true
                    )
                )
            }
    }

    @Test
    fun removeBadgeUsesStaticMaterialForEditModeSwipePerformance() {
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldUseRealtimeRemoveBadge(
                realtimeEnabled = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldUseRealtimeRemoveBadge(
                realtimeEnabled = false
            )
        )
    }

    @Test
    fun realtimeGlassIsActiveOnlyWhenHostAndGlassAreShownAndSized() {
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.isRealtimeGlassActive(
                hostVisible = true,
                hostShown = true,
                hostWidth = 120,
                hostHeight = 80,
                glassAttached = true,
                glassVisible = true,
                glassShown = true,
                glassWidth = 120,
                glassHeight = 80,
                realtimeEnabled = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.isRealtimeGlassActive(
                hostVisible = true,
                hostShown = false,
                hostWidth = 120,
                hostHeight = 80,
                glassAttached = true,
                glassVisible = true,
                glassShown = true,
                glassWidth = 120,
                glassHeight = 80,
                realtimeEnabled = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.isRealtimeGlassActive(
                hostVisible = true,
                hostShown = true,
                hostWidth = 0,
                hostHeight = 80,
                glassAttached = true,
                glassVisible = true,
                glassShown = true,
                glassWidth = 120,
                glassHeight = 80,
                realtimeEnabled = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.isRealtimeGlassActive(
                hostVisible = true,
                hostShown = true,
                hostWidth = 120,
                hostHeight = 80,
                glassAttached = true,
                glassVisible = true,
                glassShown = false,
                glassWidth = 120,
                glassHeight = 80,
                realtimeEnabled = true
            )
        )
    }

    @Test
    fun folderPanelRefreshesRealtimeGlassAfterVisibleContentChanges() {
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshFolderPanelRealtimeAfterContentChange(
                realtimeEnabled = true,
                folderVisible = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshFolderPanelRealtimeAfterContentChange(
                realtimeEnabled = false,
                folderVisible = true
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldRefreshFolderPanelRealtimeAfterContentChange(
                realtimeEnabled = true,
                folderVisible = false
            )
        )
    }
}

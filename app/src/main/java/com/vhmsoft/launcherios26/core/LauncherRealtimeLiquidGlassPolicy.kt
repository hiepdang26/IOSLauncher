package com.vhmsoft.launcherios26.core

import android.os.Build

object LauncherRealtimeLiquidGlassPolicy {
    const val QMDEVE_MIN_SDK = 33

    enum class Surface {
        DOCK,
        FOLDER_PREVIEW,
        FOLDER_PANEL,
        PAGE_INDICATOR,
        SEARCH_PILL,
        SEARCH_RESULTS,
        APP_LIBRARY_FOLDER
    }

    data class Profile(
        val cornerRadius: Float,
        val blurRadiusDp: Float,
        val refractionHeightDp: Float,
        val refractionOffsetDp: Float,
        val dispersion: Float,
        val tintRed: Float = 1f,
        val tintGreen: Float = 1f,
        val tintBlue: Float = 1f,
        val tintAlpha: Float = 0.08f
    )

    fun shouldUseRealtimeLiquidGlass(
        liquidGlassEnabled: Boolean,
        sdkInt: Int = Build.VERSION.SDK_INT
    ): Boolean = liquidGlassEnabled && sdkInt >= QMDEVE_MIN_SDK

    fun shouldDrawFallbackBlur(realtimeLiquidGlassActive: Boolean): Boolean =
        !realtimeLiquidGlassActive

    fun shouldUseTransparentSurfaceBackground(
        surface: Surface,
        realtimeLiquidGlassActive: Boolean,
        realtimeEnabled: Boolean = false
    ): Boolean =
        realtimeLiquidGlassActive ||
            (realtimeEnabled && shouldUseTransparentSurfaceBackgroundWhilePendingBind(surface))

    private fun shouldUseTransparentSurfaceBackgroundWhilePendingBind(surface: Surface): Boolean =
        surface == Surface.SEARCH_PILL ||
            surface == Surface.SEARCH_RESULTS ||
            surface == Surface.APP_LIBRARY_FOLDER

    fun shouldUseStableMaterialBehindRealtimeGlass(
        surface: Surface,
        realtimeEnabled: Boolean
    ): Boolean =
        realtimeEnabled && (
            surface == Surface.SEARCH_PILL ||
                surface == Surface.SEARCH_RESULTS
            )

    fun shouldDisableFallbackDrawingForExternalGlass(
        surface: Surface,
        realtimeLiquidGlassActive: Boolean
    ): Boolean =
        realtimeLiquidGlassActive

    fun shouldDrawMaterialOverlay(
        realtimeLiquidGlassActive: Boolean,
        hasMaterialDrawable: Boolean
    ): Boolean = hasMaterialDrawable && !realtimeLiquidGlassActive

    fun shouldRefreshRealtimeOnVisibilityChanged(
        realtimeEnabled: Boolean,
        visible: Boolean
    ): Boolean = realtimeEnabled && visible

    fun shouldRefreshRealtimeOnChromeSync(
        realtimeEnabled: Boolean,
        wasVisible: Boolean,
        nextVisible: Boolean
    ): Boolean = realtimeEnabled && !wasVisible && nextVisible

    fun shouldKeepRealtimeGlassAttachedWhenChromeHidden(
        surface: Surface,
        realtimeEnabled: Boolean
    ): Boolean = realtimeEnabled && surface == Surface.DOCK

    fun shouldRefreshRealtimeOnPersistentChromeRestore(
        realtimeEnabled: Boolean,
        nextVisible: Boolean,
        realtimeLiquidGlassActive: Boolean
    ): Boolean = realtimeEnabled && nextVisible && !realtimeLiquidGlassActive

    fun realtimeDockGlassAlphaForAppearanceApply(
        realtimeDockEnabled: Boolean,
        dockVisible: Boolean,
        dockAlpha: Float
    ): Float = when {
        realtimeDockEnabled && dockVisible -> 1f
        dockVisible -> dockAlpha
        else -> 0f
    }

    fun shouldRefreshFolderPreviewRealtimeOnAppearanceApply(
        realtimeEnabled: Boolean
    ): Boolean = realtimeEnabled

    fun shouldRefreshFolderPanelRealtimeOnOpenVisible(
        realtimeEnabled: Boolean,
        folderVisible: Boolean
    ): Boolean = realtimeEnabled && folderVisible

    fun shouldRefreshRealtimeDescendant(
        realtimeEnabled: Boolean,
        descendantShown: Boolean
    ): Boolean = realtimeEnabled || descendantShown

    fun shouldRefreshFolderPreviewHostOnPageRestore(
        realtimeEnabled: Boolean,
        folderPreviewRealtimeEnabled: Boolean
    ): Boolean = realtimeEnabled && folderPreviewRealtimeEnabled

    fun shouldRefreshRealtimeOnSettledPage(
        realtimeEnabled: Boolean,
        wasScrolling: Boolean,
        pageChanged: Boolean
    ): Boolean = realtimeEnabled && (wasScrolling || pageChanged)

    fun shouldRefreshRealtimeSurfaceOnSettledPage(
        surface: Surface,
        realtimeEnabled: Boolean,
        wasScrolling: Boolean,
        pageChanged: Boolean
    ): Boolean {
        if (!shouldRefreshRealtimeOnSettledPage(realtimeEnabled, wasScrolling, pageChanged)) {
            return false
        }
        return surface != Surface.DOCK && surface != Surface.PAGE_INDICATOR
    }

    fun shouldBindRealtimeSource(sourceContainsTarget: Boolean): Boolean =
        !sourceContainsTarget

    fun shouldDrawVisibilityOverlay(
        surface: Surface,
        realtimeLiquidGlassActive: Boolean
    ): Boolean =
        realtimeLiquidGlassActive && surface == Surface.APP_LIBRARY_FOLDER

    fun shouldMirrorCustomWallpaperToSource(customWallpaperAvailable: Boolean): Boolean =
        customWallpaperAvailable

    fun shouldUseDefaultWallpaperSourceFallback(customWallpaperAvailable: Boolean): Boolean =
        !customWallpaperAvailable

    fun shouldConfigureRealtimeProfile(
        currentProfile: Profile?,
        nextProfile: Profile
    ): Boolean = currentProfile != nextProfile

    fun shouldForceRecreateRealtimeViewOnRefresh(
        surface: Surface?,
        realtimeLiquidGlassActive: Boolean = false
    ): Boolean =
        surface == Surface.FOLDER_PREVIEW ||
            surface == Surface.FOLDER_PANEL ||
            (surface == Surface.APP_LIBRARY_FOLDER && !realtimeLiquidGlassActive)

    fun shouldRecreateRealtimeView(
        currentProfile: Profile?,
        nextProfile: Profile
    ): Boolean =
        shouldRecreateRealtimeView(
            surface = null,
            currentProfile = currentProfile,
            nextProfile = nextProfile,
            forceRefresh = false
        )

    fun shouldRecreateRealtimeView(
        surface: Surface?,
        currentProfile: Profile?,
        nextProfile: Profile,
        forceRefresh: Boolean,
        realtimeLiquidGlassActive: Boolean = false
    ): Boolean =
        currentProfile != nextProfile ||
            (forceRefresh && shouldForceRecreateRealtimeViewOnRefresh(surface, realtimeLiquidGlassActive))

    @Suppress("UNUSED_PARAMETER")
    fun profileFor(
        surface: Surface,
        radiusDp: Int,
        darkMode: Boolean
    ): Profile =
        Profile(
            cornerRadius = realtimeCornerRadius(surface, radiusDp),
            blurRadiusDp = LauncherLiquidGlassTuning.BLUR_RADIUS,
            refractionHeightDp = LauncherLiquidGlassTuning.REFRACTION_HEIGHT,
            refractionOffsetDp = LauncherLiquidGlassTuning.REFRACTION_OFFSET,
            dispersion = LauncherLiquidGlassTuning.DISPERSION,
            tintRed = LauncherLiquidGlassTuning.TINT_RED,
            tintGreen = LauncherLiquidGlassTuning.TINT_GREEN,
            tintBlue = LauncherLiquidGlassTuning.TINT_BLUE,
            tintAlpha = LauncherLiquidGlassTuning.TINT_ALPHA
        )

    private fun realtimeCornerRadius(surface: Surface, radiusDp: Int): Float =
        if (surface == Surface.FOLDER_PREVIEW) {
            radiusDp.toFloat()
        } else {
            LauncherLiquidGlassTuning.CORNER_RADIUS
        }
}

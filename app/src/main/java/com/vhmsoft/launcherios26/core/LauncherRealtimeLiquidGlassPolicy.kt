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
        realtimeLiquidGlassActive: Boolean
    ): Boolean =
        realtimeLiquidGlassActive

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

    fun shouldBindRealtimeSource(sourceContainsTarget: Boolean): Boolean =
        !sourceContainsTarget

    fun shouldDrawVisibilityOverlay(
        surface: Surface,
        realtimeLiquidGlassActive: Boolean
    ): Boolean =
        realtimeLiquidGlassActive && when (surface) {
            Surface.SEARCH_PILL,
            Surface.SEARCH_RESULTS -> false
            Surface.DOCK,
            Surface.FOLDER_PREVIEW,
            Surface.FOLDER_PANEL,
            Surface.PAGE_INDICATOR,
            Surface.APP_LIBRARY_FOLDER -> true
        }

    fun shouldMirrorCustomWallpaperToSource(customWallpaperAvailable: Boolean): Boolean =
        customWallpaperAvailable

    fun shouldUseDefaultWallpaperSourceFallback(customWallpaperAvailable: Boolean): Boolean =
        !customWallpaperAvailable

    fun shouldConfigureRealtimeProfile(
        currentProfile: Profile?,
        nextProfile: Profile
    ): Boolean = currentProfile != nextProfile

    fun shouldRecreateRealtimeView(
        currentProfile: Profile?,
        nextProfile: Profile
    ): Boolean = currentProfile != nextProfile

    @Suppress("UNUSED_PARAMETER")
    fun profileFor(
        surface: Surface,
        radiusDp: Int,
        darkMode: Boolean
    ): Profile =
        Profile(
            cornerRadius = LauncherLiquidGlassTuning.CORNER_RADIUS,
            blurRadiusDp = LauncherLiquidGlassTuning.BLUR_RADIUS,
            refractionHeightDp = LauncherLiquidGlassTuning.REFRACTION_HEIGHT,
            refractionOffsetDp = LauncherLiquidGlassTuning.REFRACTION_OFFSET,
            dispersion = LauncherLiquidGlassTuning.DISPERSION,
            tintRed = LauncherLiquidGlassTuning.TINT_RED,
            tintGreen = LauncherLiquidGlassTuning.TINT_GREEN,
            tintBlue = LauncherLiquidGlassTuning.TINT_BLUE,
            tintAlpha = LauncherLiquidGlassTuning.TINT_ALPHA
        )
}

package com.vhmsoft.launcherios26.ui.launcher.workspace

import android.os.Build
import com.vhmsoft.launcherios26.core.LauncherLiquidGlassTuning

object AndroidLiquidGlassPolicy {
    const val QMDEVE_MIN_SDK = 33

    enum class Surface {
        DOCK,
        SEARCH_PILL,
        SEARCH_FIELD,
        SEARCH_RESULTS,
        FOLDER_PREVIEW,
        FOLDER_PANEL,
        APP_LIBRARY_FOLDER,
        APP_LIBRARY_SEARCH,
        REMOVE_BADGE
    }

    data class Profile(
        val cornerRadius: Float,
        val blurRadiusDp: Float,
        val refractionHeightDp: Float,
        val refractionOffsetDp: Float,
        val dispersion: Float,
        val tintRed: Float,
        val tintGreen: Float,
        val tintBlue: Float,
        val tintAlpha: Float
    )

    fun shouldUseRealtimeLiquidGlass(
        liquidGlassEnabled: Boolean,
        sdkInt: Int = Build.VERSION.SDK_INT
    ): Boolean = liquidGlassEnabled && sdkInt >= QMDEVE_MIN_SDK

    fun shouldDrawFallbackBackground(
        surface: Surface,
        realtimeLiquidGlassActive: Boolean
    ): Boolean =
        !realtimeLiquidGlassActive

    fun shouldUseTransparentContentBackground(
        surface: Surface,
        realtimeLiquidGlassActive: Boolean
    ): Boolean =
        realtimeLiquidGlassActive

    fun shouldBindRealtimeSource(sourceContainsTarget: Boolean): Boolean =
        !sourceContainsTarget

    fun shouldDrawVisibilityOverlay(
        surface: Surface,
        realtimeLiquidGlassActive: Boolean
    ): Boolean =
        realtimeLiquidGlassActive && when (surface) {
            Surface.SEARCH_PILL,
            Surface.SEARCH_FIELD,
            Surface.SEARCH_RESULTS,
            Surface.APP_LIBRARY_SEARCH -> false
            Surface.DOCK,
            Surface.FOLDER_PREVIEW,
            Surface.FOLDER_PANEL,
            Surface.APP_LIBRARY_FOLDER,
            Surface.REMOVE_BADGE -> true
        }

    fun shouldRecreateRealtimeView(
        currentProfile: Profile?,
        nextProfile: Profile
    ): Boolean = currentProfile != nextProfile

    @Suppress("UNUSED_PARAMETER")
    fun profileFor(surface: Surface, radiusDp: Int): Profile =
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

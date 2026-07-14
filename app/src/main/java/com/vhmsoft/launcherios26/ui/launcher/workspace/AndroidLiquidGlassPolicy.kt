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

    @Suppress("UNUSED_PARAMETER")
    fun shouldUseRealtimeRemoveBadge(realtimeEnabled: Boolean): Boolean = false

    fun shouldDrawFallbackBackground(
        surface: Surface,
        realtimeLiquidGlassActive: Boolean,
        realtimeEnabled: Boolean = false
    ): Boolean =
        !realtimeLiquidGlassActive &&
            !(
                realtimeEnabled &&
                    (surface == Surface.APP_LIBRARY_FOLDER || surface == Surface.APP_LIBRARY_SEARCH)
                )

    fun shouldUseTransparentContentBackground(
        surface: Surface,
        realtimeLiquidGlassActive: Boolean
    ): Boolean =
        realtimeLiquidGlassActive

    fun shouldBindRealtimeSource(sourceContainsTarget: Boolean): Boolean =
        !sourceContainsTarget

    fun shouldBindRealtimeViewSource(
        sourceChanged: Boolean,
        realtimeLiquidGlassActive: Boolean,
        sourceBoundWhileVisible: Boolean = true
    ): Boolean =
        sourceChanged || !realtimeLiquidGlassActive || !sourceBoundWhileVisible

    fun shouldLayoutRealtimeViewToHostBounds(
        hostWidth: Int,
        hostHeight: Int,
        realtimeLiquidGlassActive: Boolean
    ): Boolean =
        realtimeLiquidGlassActive && hostWidth > 0 && hostHeight > 0

    fun shouldDrawVisibilityOverlay(
        surface: Surface,
        realtimeLiquidGlassActive: Boolean
    ): Boolean = false

    fun shouldForceRecreateRealtimeViewOnApply(
        surface: Surface?,
        realtimeLiquidGlassActive: Boolean = false
    ): Boolean = false

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
            (forceRefresh && shouldForceRecreateRealtimeViewOnApply(surface, realtimeLiquidGlassActive))

    @Suppress("UNUSED_PARAMETER")
    fun profileFor(surface: Surface, radiusDp: Int): Profile =
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

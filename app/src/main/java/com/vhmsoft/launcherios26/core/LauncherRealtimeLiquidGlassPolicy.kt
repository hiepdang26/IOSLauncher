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
        val radiusDp: Int,
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

    fun shouldDrawMaterialOverlay(
        realtimeLiquidGlassActive: Boolean,
        hasMaterialDrawable: Boolean
    ): Boolean = hasMaterialDrawable

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

    fun profileFor(
        surface: Surface,
        radiusDp: Int,
        darkMode: Boolean
    ): Profile {
        return when (surface) {
            Surface.SEARCH_PILL -> Profile(
                radiusDp = radiusDp,
                blurRadiusDp = 10f,
                refractionHeightDp = 16f,
                refractionOffsetDp = 48f,
                dispersion = 0.35f
            )

            Surface.PAGE_INDICATOR -> homeChromeProfile(radiusDp)

            Surface.SEARCH_RESULTS -> Profile(
                radiusDp = radiusDp,
                blurRadiusDp = 12f,
                refractionHeightDp = 18f,
                refractionOffsetDp = 56f,
                dispersion = 0.4f,
                tintAlpha = 0.06f
            )

            Surface.APP_LIBRARY_FOLDER -> appLibraryFolderProfile(radiusDp)

            Surface.FOLDER_PREVIEW -> appLibraryFolderProfile(radiusDp)

            Surface.FOLDER_PANEL -> folderPanelProfile(radiusDp)

            Surface.DOCK -> homeChromeProfile(radiusDp)
        }
    }

    private fun appLibraryFolderProfile(radiusDp: Int): Profile =
        Profile(
            radiusDp = radiusDp,
            blurRadiusDp = 10f,
            refractionHeightDp = 16f,
            refractionOffsetDp = 50f,
            dispersion = 0.35f,
            tintAlpha = 0.04f
        )

    private fun folderPanelProfile(radiusDp: Int): Profile =
        Profile(
            radiusDp = radiusDp,
            blurRadiusDp = 36f,
            refractionHeightDp = 36f,
            refractionOffsetDp = 96f,
            dispersion = 0.75f,
            tintAlpha = 0.16f
        )

    private fun homeChromeProfile(radiusDp: Int): Profile =
        Profile(
            radiusDp = radiusDp,
            blurRadiusDp = 14f,
            refractionHeightDp = 18f,
            refractionOffsetDp = 54f,
            dispersion = 0.35f,
            tintAlpha = 0.03f
        )
}

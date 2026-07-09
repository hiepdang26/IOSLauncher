package com.vhmsoft.launcherios26.ui.launcher.workspace

import android.os.Build

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
        APP_LIBRARY_SEARCH
    }

    data class Profile(
        val radiusDp: Int,
        val blurRadiusDp: Float,
        val refractionHeightDp: Float,
        val refractionOffsetDp: Float,
        val dispersion: Float,
        val tintAlpha: Float
    )

    fun shouldUseRealtimeLiquidGlass(
        liquidGlassEnabled: Boolean,
        sdkInt: Int = Build.VERSION.SDK_INT
    ): Boolean = liquidGlassEnabled && sdkInt >= QMDEVE_MIN_SDK

    fun shouldDrawFallbackBackground(realtimeLiquidGlassActive: Boolean): Boolean =
        !realtimeLiquidGlassActive

    fun shouldRecreateRealtimeView(
        currentProfile: Profile?,
        nextProfile: Profile
    ): Boolean = currentProfile != nextProfile

    fun profileFor(surface: Surface, radiusDp: Int): Profile {
        return when (surface) {
            Surface.DOCK -> Profile(radiusDp, 16f, 26f, 78f, 0.5f, 0.08f)
            Surface.SEARCH_PILL -> Profile(radiusDp, 10f, 16f, 48f, 0.35f, 0.08f)
            Surface.SEARCH_FIELD -> Profile(radiusDp, 12f, 18f, 56f, 0.4f, 0.06f)
            Surface.SEARCH_RESULTS -> Profile(radiusDp, 12f, 20f, 58f, 0.4f, 0.06f)
            Surface.FOLDER_PREVIEW -> Profile(radiusDp, 10f, 16f, 50f, 0.35f, 0.06f)
            Surface.FOLDER_PANEL -> Profile(radiusDp, 14f, 24f, 70f, 0.45f, 0.08f)
            Surface.APP_LIBRARY_FOLDER -> Profile(radiusDp, 10f, 16f, 50f, 0.35f, 0.05f)
            Surface.APP_LIBRARY_SEARCH -> Profile(radiusDp, 10f, 16f, 48f, 0.35f, 0.06f)
        }
    }
}

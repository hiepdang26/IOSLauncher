package com.cloudx.ios17.core

import android.os.Build

object LauncherRealtimeLiquidGlassPolicy {
    const val QWEA_MIN_SDK = 24

    enum class Surface {
        DOCK,
        FOLDER_PANEL,
        SEARCH_PILL,
        SEARCH_RESULTS,
        APP_LIBRARY_FOLDER
    }

    data class Profile(
        val radiusDp: Int,
        val blurAmount: Float,
        val saturation: Float,
        val aberrationIntensity: Float,
        val displacementScale: Float,
        val globalDownsampleFactor: Float,
        val aberrationDownsample: Float,
        val edgeHighlightOpacity: Float,
        val dynamicBackground: Boolean
    )

    fun shouldUseRealtimeLiquidGlass(
        liquidGlassEnabled: Boolean,
        sdkInt: Int = Build.VERSION.SDK_INT
    ): Boolean = liquidGlassEnabled && sdkInt >= QWEA_MIN_SDK

    fun shouldDrawFallbackBlur(realtimeLiquidGlassActive: Boolean): Boolean =
        !realtimeLiquidGlassActive

    fun shouldConfigureRealtimeProfile(
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
                blurAmount = 0.06f,
                saturation = 140f,
                aberrationIntensity = 1.35f,
                displacementScale = 54f,
                globalDownsampleFactor = 0.55f,
                aberrationDownsample = 0.5f,
                edgeHighlightOpacity = 84f,
                dynamicBackground = true
            )

            Surface.SEARCH_RESULTS -> Profile(
                radiusDp = radiusDp,
                blurAmount = 0.07f,
                saturation = 136f,
                aberrationIntensity = 1.55f,
                displacementScale = 62f,
                globalDownsampleFactor = 0.5f,
                aberrationDownsample = 0.5f,
                edgeHighlightOpacity = 78f,
                dynamicBackground = true
            )

            Surface.APP_LIBRARY_FOLDER -> Profile(
                radiusDp = radiusDp,
                blurAmount = 0.07f,
                saturation = 136f,
                aberrationIntensity = 1.55f,
                displacementScale = 62f,
                globalDownsampleFactor = 0.48f,
                aberrationDownsample = 0.5f,
                edgeHighlightOpacity = 76f,
                dynamicBackground = false
            )

            Surface.FOLDER_PANEL -> Profile(
                radiusDp = radiusDp,
                blurAmount = 0.075f,
                saturation = 138f,
                aberrationIntensity = 1.75f,
                displacementScale = 70f,
                globalDownsampleFactor = 0.52f,
                aberrationDownsample = 0.5f,
                edgeHighlightOpacity = 82f,
                dynamicBackground = true
            )

            Surface.DOCK -> Profile(
                radiusDp = radiusDp,
                blurAmount = 0.0825f,
                saturation = 145f,
                aberrationIntensity = 2f,
                displacementScale = 78f,
                globalDownsampleFactor = 0.5f,
                aberrationDownsample = 0.5f,
                edgeHighlightOpacity = 88f,
                dynamicBackground = true
            )
        }
    }
}

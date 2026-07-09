package com.cloudx.ios17.core

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherRealtimeLiquidGlassPolicyTest {

    @Test
    fun realtimeLiquidGlass_requiresPreferenceAndQweaMinSdk() {
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldUseRealtimeLiquidGlass(
                liquidGlassEnabled = false,
                sdkInt = LauncherRealtimeLiquidGlassPolicy.QWEA_MIN_SDK
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldUseRealtimeLiquidGlass(
                liquidGlassEnabled = true,
                sdkInt = LauncherRealtimeLiquidGlassPolicy.QWEA_MIN_SDK - 1
            )
        )
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldUseRealtimeLiquidGlass(
                liquidGlassEnabled = true,
                sdkInt = LauncherRealtimeLiquidGlassPolicy.QWEA_MIN_SDK
            )
        )
    }

    @Test
    fun fallbackBlurDrawsOnlyWhenRealtimeLiquidGlassIsInactive() {
        assertFalse(LauncherRealtimeLiquidGlassPolicy.shouldDrawFallbackBlur(realtimeLiquidGlassActive = true))
        assertTrue(LauncherRealtimeLiquidGlassPolicy.shouldDrawFallbackBlur(realtimeLiquidGlassActive = false))
    }

    @Test
    fun realtimeProfileReconfigurationRunsOnlyWhenProfileChanges() {
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
            LauncherRealtimeLiquidGlassPolicy.shouldConfigureRealtimeProfile(
                currentProfile = null,
                nextProfile = profile
            )
        )
        assertFalse(
            LauncherRealtimeLiquidGlassPolicy.shouldConfigureRealtimeProfile(
                currentProfile = profile,
                nextProfile = profile
            )
        )
        assertTrue(
            LauncherRealtimeLiquidGlassPolicy.shouldConfigureRealtimeProfile(
                currentProfile = profile,
                nextProfile = changedProfile
            )
        )
    }

    @Test
    fun searchPillProfile_usesQweaLiquidGlassTuning() {
        val profile = LauncherRealtimeLiquidGlassPolicy.profileFor(
            surface = LauncherRealtimeLiquidGlassPolicy.Surface.SEARCH_PILL,
            radiusDp = 22,
            darkMode = false
        )

        assertEquals(22, profile.radiusDp)
        assertEquals(0.06f, profile.blurAmount, 0.001f)
        assertEquals(140f, profile.saturation, 0.01f)
        assertEquals(1.35f, profile.aberrationIntensity, 0.01f)
        assertEquals(54f, profile.displacementScale, 0.01f)
        assertEquals(0.55f, profile.globalDownsampleFactor, 0.01f)
        assertEquals(0.5f, profile.aberrationDownsample, 0.01f)
        assertEquals(84f, profile.edgeHighlightOpacity, 0.01f)
        assertTrue(profile.dynamicBackground)
    }

    @Test
    fun dockProfile_usesMoreDepthThanSearchPill() {
        val search = LauncherRealtimeLiquidGlassPolicy.profileFor(
            surface = LauncherRealtimeLiquidGlassPolicy.Surface.SEARCH_PILL,
            radiusDp = 22,
            darkMode = false
        )
        val dock = LauncherRealtimeLiquidGlassPolicy.profileFor(
            surface = LauncherRealtimeLiquidGlassPolicy.Surface.DOCK,
            radiusDp = 38,
            darkMode = false
        )

        assertEquals(38, dock.radiusDp)
        assertTrue(dock.blurAmount > search.blurAmount)
        assertTrue(dock.aberrationIntensity > search.aberrationIntensity)
        assertTrue(dock.displacementScale > search.displacementScale)
        assertTrue(dock.edgeHighlightOpacity > search.edgeHighlightOpacity)
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
        assertEquals(light.blurAmount, dark.blurAmount, 0.001f)
        assertEquals(light.saturation, dark.saturation, 0.01f)
        assertEquals(light.aberrationIntensity, dark.aberrationIntensity, 0.01f)
        assertEquals(light.displacementScale, dark.displacementScale, 0.01f)
        assertEquals(light.globalDownsampleFactor, dark.globalDownsampleFactor, 0.01f)
        assertEquals(light.aberrationDownsample, dark.aberrationDownsample, 0.01f)
        assertEquals(light.edgeHighlightOpacity, dark.edgeHighlightOpacity, 0.01f)
        assertEquals(light.dynamicBackground, dark.dynamicBackground)
    }
}

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
    fun fallbackBackgroundDrawsOnlyWhenRealtimeGlassIsInactive() {
        assertFalse(AndroidLiquidGlassPolicy.shouldDrawFallbackBackground(realtimeLiquidGlassActive = true))
        assertTrue(AndroidLiquidGlassPolicy.shouldDrawFallbackBackground(realtimeLiquidGlassActive = false))
    }

    @Test
    fun realtimeGlassViewRecreationRunsOnlyWhenProfileChanges() {
        val profile = AndroidLiquidGlassPolicy.profileFor(
            surface = AndroidLiquidGlassPolicy.Surface.SEARCH_PILL,
            radiusDp = 17
        )
        val changedProfile = AndroidLiquidGlassPolicy.profileFor(
            surface = AndroidLiquidGlassPolicy.Surface.SEARCH_PILL,
            radiusDp = 22
        )

        assertTrue(AndroidLiquidGlassPolicy.shouldRecreateRealtimeView(null, profile))
        assertFalse(AndroidLiquidGlassPolicy.shouldRecreateRealtimeView(profile, profile))
        assertTrue(AndroidLiquidGlassPolicy.shouldRecreateRealtimeView(profile, changedProfile))
    }

    @Test
    fun dockProfileHasMoreDepthThanSearchPill() {
        val dock = AndroidLiquidGlassPolicy.profileFor(
            surface = AndroidLiquidGlassPolicy.Surface.DOCK,
            radiusDp = 38
        )
        val search = AndroidLiquidGlassPolicy.profileFor(
            surface = AndroidLiquidGlassPolicy.Surface.SEARCH_PILL,
            radiusDp = 17
        )

        assertEquals(38, dock.radiusDp)
        assertTrue(dock.blurRadiusDp > search.blurRadiusDp)
        assertTrue(dock.refractionHeightDp > search.refractionHeightDp)
        assertTrue(dock.refractionOffsetDp > search.refractionOffsetDp)
    }
}

package com.vhmsoft.launcherios26.core

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class HomeIconRenderPolicyTest {
    @Test
    fun legacyFallbackIcons_areWrappedInGeneratedBackgrounds() {
        assertTrue(HomeIconRenderPolicy.wrapLegacyFallbackIcons)
    }

    @Test
    fun cacheStyleVersion_changesForUniformIconRendering() {
        assertEquals("uniform_icon_v3", HomeIconRenderPolicy.cacheStyleVersion)
    }

    @Test
    fun legacyFallbackIcons_areCroppedSlightlyToHideSourceBorders() {
        assertTrue(HomeIconRenderPolicy.legacyFallbackIconForegroundScale > 1f)
        assertEquals(1.14f, HomeIconRenderPolicy.legacyFallbackIconForegroundScale, 0.001f)
    }

    @Test
    fun homeScreenAppIcons_areCroppedAtDisplayTimeToHideEmbeddedBorders() {
        assertTrue(HomeIconRenderPolicy.homeScreenIconContentScale > 1f)
        assertEquals(1.18f, HomeIconRenderPolicy.homeScreenIconContentScale, 0.001f)
    }

    @Test
    fun appIcons_areAlwaysClippedToIosMaskEvenWithoutDisplayScale() {
        assertTrue(HomeIconRenderPolicy.shouldClipIconDrawable(1f))
        assertTrue(HomeIconRenderPolicy.shouldClipIconDrawable(HomeIconRenderPolicy.homeScreenIconContentScale))
    }

    @Test
    fun appIcons_areOnlyScaledWhenScaleDiffersFromDefault() {
        assertFalse(HomeIconRenderPolicy.shouldScaleIconDrawable(1f))
        assertTrue(HomeIconRenderPolicy.shouldScaleIconDrawable(HomeIconRenderPolicy.homeScreenIconContentScale))
    }

    @Test
    fun appIconMask_isResizedWhenIconViewUsesADifferentSize() {
        assertTrue(
            HomeIconRenderPolicy.shouldResizeClipMaskToViewBounds(
                viewWidth = 62,
                viewHeight = 62,
                maskWidth = 72f,
                maskHeight = 72f
            )
        )
        assertFalse(
            HomeIconRenderPolicy.shouldResizeClipMaskToViewBounds(
                viewWidth = 62,
                viewHeight = 62,
                maskWidth = 62f,
                maskHeight = 62f
            )
        )
    }
}

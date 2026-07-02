package com.cloudx.ios17.core

import org.junit.Assert.assertEquals
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
}

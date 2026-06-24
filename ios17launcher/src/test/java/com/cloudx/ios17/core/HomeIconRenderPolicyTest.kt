package com.cloudx.ios17.core

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test

class HomeIconRenderPolicyTest {
    @Test
    fun legacyFallbackIcons_areNotWrappedInGeneratedBackgrounds() {
        assertFalse(HomeIconRenderPolicy.wrapLegacyFallbackIcons)
    }

    @Test
    fun cacheStyleVersion_changesForOriginalIconRendering() {
        assertEquals("original_icon_v1", HomeIconRenderPolicy.cacheStyleVersion)
    }
}

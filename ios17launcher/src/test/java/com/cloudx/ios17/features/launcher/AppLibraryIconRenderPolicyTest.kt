package com.cloudx.ios17.features.launcher

import com.cloudx.ios17.core.HomeIconRenderPolicy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class AppLibraryIconRenderPolicyTest {

    @Test
    fun appLibraryIcons_useTheSameDisplayCropAsHomeScreenIcons() {
        assertEquals(
            HomeIconRenderPolicy.homeScreenIconContentScale,
            AppLibraryIconRenderPolicy.iconContentScale,
            0.001f
        )
    }

    @Test
    fun appLibraryIcons_areClippedToTheIosIconMask() {
        assertTrue(AppLibraryIconRenderPolicy.shouldClipIconDrawable())
    }
}

package com.vhmsoft.launcherios26.features.launcher

import com.vhmsoft.launcherios26.core.HomeIconRenderPolicy
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

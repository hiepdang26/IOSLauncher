package com.vhmsoft.launcherios26.features.launcher

import com.vhmsoft.launcherios26.core.HomeIconRenderPolicy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class TodayWidgetAppIconRenderPolicyTest {

    @Test
    fun todayWidgetAppIcons_useTheSameDisplayCropAsHomeScreenIcons() {
        assertEquals(
            HomeIconRenderPolicy.homeScreenIconContentScale,
            TodayWidgetAppIconRenderPolicy.iconContentScale,
            0.001f
        )
    }

    @Test
    fun todayWidgetAppIcons_areClippedToTheIosIconMask() {
        assertTrue(TodayWidgetAppIconRenderPolicy.shouldClipIconDrawable())
    }
}

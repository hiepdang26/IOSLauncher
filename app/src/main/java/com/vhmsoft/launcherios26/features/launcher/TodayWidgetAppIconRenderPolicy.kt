package com.vhmsoft.launcherios26.features.launcher

import com.vhmsoft.launcherios26.core.HomeIconRenderPolicy

object TodayWidgetAppIconRenderPolicy {
    const val iconContentScale = HomeIconRenderPolicy.homeScreenIconContentScale

    fun shouldClipIconDrawable(): Boolean =
        HomeIconRenderPolicy.shouldClipIconDrawable(iconContentScale)
}

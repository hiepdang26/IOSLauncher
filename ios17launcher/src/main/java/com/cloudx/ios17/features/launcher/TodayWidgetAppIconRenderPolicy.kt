package com.cloudx.ios17.features.launcher

import com.cloudx.ios17.core.HomeIconRenderPolicy

object TodayWidgetAppIconRenderPolicy {
    const val iconContentScale = HomeIconRenderPolicy.homeScreenIconContentScale

    fun shouldClipIconDrawable(): Boolean =
        HomeIconRenderPolicy.shouldClipIconDrawable(iconContentScale)
}

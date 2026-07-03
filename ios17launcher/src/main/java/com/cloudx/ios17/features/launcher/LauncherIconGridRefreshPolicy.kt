package com.cloudx.ios17.features.launcher

object LauncherIconGridRefreshPolicy {

    fun shouldRequestProviderReload(itemCount: Int): Boolean {
        return itemCount == 0
    }

    fun shouldRenderIncomingItems(
        itemCount: Int,
        allAppsDisplayed: Boolean,
        forceRender: Boolean
    ): Boolean {
        return itemCount > 0 && (!allAppsDisplayed || forceRender)
    }

    fun shouldSuppressEquivalentIncomingItems(
        previousItemIds: List<String>,
        nextItemIds: List<String>,
        forceRender: Boolean
    ): Boolean {
        return !forceRender && previousItemIds == nextItemIds
    }
}

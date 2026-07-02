package com.cloudx.ios17.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Test

class LauncherIconGridRefreshPolicyTest {

    @Test
    fun emptyRelay_requestsProviderReload() {
        assertEquals(true, LauncherIconGridRefreshPolicy.shouldRequestProviderReload(itemCount = 0))
        assertEquals(false, LauncherIconGridRefreshPolicy.shouldRequestProviderReload(itemCount = 4))
    }

    @Test
    fun firstNonEmptyRelay_rendersGrid() {
        val shouldRender = LauncherIconGridRefreshPolicy.shouldRenderIncomingItems(
            itemCount = 4,
            allAppsDisplayed = false,
            forceRender = false
        )

        assertEquals(true, shouldRender)
    }

    @Test
    fun laterNonEmptyRelay_withoutForce_keepsCurrentGrid() {
        val shouldRender = LauncherIconGridRefreshPolicy.shouldRenderIncomingItems(
            itemCount = 4,
            allAppsDisplayed = true,
            forceRender = false
        )

        assertEquals(false, shouldRender)
    }

    @Test
    fun laterNonEmptyRelay_withCustomIconForce_rendersGridAgain() {
        val shouldRender = LauncherIconGridRefreshPolicy.shouldRenderIncomingItems(
            itemCount = 4,
            allAppsDisplayed = true,
            forceRender = true
        )

        assertEquals(true, shouldRender)
    }
}

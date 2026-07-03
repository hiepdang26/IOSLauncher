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

    @Test
    fun equivalentIncomingItems_withoutForce_areSuppressed() {
        val shouldSuppress = LauncherIconGridRefreshPolicy.shouldSuppressEquivalentIncomingItems(
            previousItemIds = listOf("app_a", "app_b"),
            nextItemIds = listOf("app_a", "app_b"),
            forceRender = false
        )

        assertEquals(true, shouldSuppress)
    }

    @Test
    fun equivalentIncomingItems_withCustomIconForce_areNotSuppressed() {
        val shouldSuppress = LauncherIconGridRefreshPolicy.shouldSuppressEquivalentIncomingItems(
            previousItemIds = listOf("app_a", "app_b"),
            nextItemIds = listOf("app_a", "app_b"),
            forceRender = true
        )

        assertEquals(false, shouldSuppress)
    }

    @Test
    fun changedIncomingItems_areNotSuppressed() {
        val shouldSuppress = LauncherIconGridRefreshPolicy.shouldSuppressEquivalentIncomingItems(
            previousItemIds = listOf("app_a", "app_b"),
            nextItemIds = listOf("app_a", "app_c"),
            forceRender = false
        )

        assertEquals(false, shouldSuppress)
    }
}

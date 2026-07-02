package com.cloudx.ios17.features.launcher

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class HomeWidgetVisualCleanupPolicyTest {

    @Test
    fun removesRecentlyDeletedVisualHostEvenIfAFrameStillContainsIt() {
        assertTrue(
            HomeWidgetVisualCleanupPolicy.shouldRemoveHost(
                hostId = "deleted",
                validIds = setOf("kept"),
                recentlyRemovedIds = setOf("deleted")
            )
        )
    }

    @Test
    fun removesStaleVisualHostThatIsNoLongerBackedByPreferences() {
        assertTrue(
            HomeWidgetVisualCleanupPolicy.shouldRemoveHost(
                hostId = "ghost",
                validIds = setOf("kept"),
                recentlyRemovedIds = emptySet()
            )
        )
    }

    @Test
    fun keepsVisualHostThatIsStillBackedByPreferences() {
        assertFalse(
            HomeWidgetVisualCleanupPolicy.shouldRemoveHost(
                hostId = "kept",
                validIds = setOf("kept"),
                recentlyRemovedIds = emptySet()
            )
        )
    }
}

package com.cloudx.ios17.core.database.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherItemEqualityTest {
    @Test
    fun contains_matchesSameInstanceWithoutRecursing() {
        val item = LauncherItem().apply {
            id = "phone"
        }

        val pinnedItems = arrayListOf(item)

        assertTrue(pinnedItems.contains(item))
    }

    @Test
    fun equals_matchesItemsWithSameId() {
        val first = LauncherItem().apply {
            id = "camera"
        }
        val second = LauncherItem().apply {
            id = "camera"
        }

        assertEquals(first, second)
        assertEquals(first.hashCode(), second.hashCode())
    }
}

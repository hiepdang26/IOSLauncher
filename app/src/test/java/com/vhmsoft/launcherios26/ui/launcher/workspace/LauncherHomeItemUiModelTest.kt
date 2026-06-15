package com.vhmsoft.launcherios26.ui.launcher.workspace

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class LauncherHomeItemUiModelTest {
    @Test
    fun stablePlaceholderForGridIndexKeepsIdAcrossPreviewUpdates() {
        val first = LauncherHomeItemUiModel.Placeholder.forGridIndex(7)
        val second = LauncherHomeItemUiModel.Placeholder.forGridIndex(7)

        assertEquals(first.stableId, second.stableId)
    }

    @Test
    fun stablePlaceholderForGridIndexUsesDifferentIdsForDifferentSlots() {
        val first = LauncherHomeItemUiModel.Placeholder.forGridIndex(7)
        val second = LauncherHomeItemUiModel.Placeholder.forGridIndex(8)

        assertNotEquals(first.stableId, second.stableId)
    }
}

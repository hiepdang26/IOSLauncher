package com.vhmsoft.launcherios26.features.launcher

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class HomeWidgetDropValidationPolicyTest {

    @Test
    fun acceptsDropWhenCandidateCellsAreInsideGridAndDoNotOverlapWidgets() {
        assertTrue(
            HomeWidgetDropValidationPolicy.canPlace(
                candidateCells = setOf(8, 9, 12, 13),
                reservedWidgetCells = setOf(0, 1, 4, 5)
            )
        )
    }

    @Test
    fun rejectsDropWhenCandidateCellsOverlapExistingWidget() {
        assertFalse(
            HomeWidgetDropValidationPolicy.canPlace(
                candidateCells = setOf(8, 9, 12, 13),
                reservedWidgetCells = setOf(12, 13, 16, 17)
            )
        )
    }

    @Test
    fun rejectsDropWhenCandidateCellsCouldNotBeResolved() {
        assertFalse(
            HomeWidgetDropValidationPolicy.canPlace(
                candidateCells = null,
                reservedWidgetCells = emptySet()
            )
        )
    }
}

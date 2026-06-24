package com.cloudx.ios17.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherDropCommitPolicyTest {

    @Test
    fun shouldAttachWhenDraggedViewIsStillInAnotherPage() {
        assertTrue(
            LauncherDropCommitPolicy.shouldAttachToTargetPage(
                movingHasParent = true,
                movingParentIsTargetPage = false
            )
        )
    }

    @Test
    fun shouldAttachWhenDraggedViewAlreadyBelongsToTargetPageSoFinalDropCellIsCommitted() {
        assertTrue(
            LauncherDropCommitPolicy.shouldAttachToTargetPage(
                movingHasParent = true,
                movingParentIsTargetPage = true
            )
        )
    }

    @Test
    fun shouldAppendWhenDropIndexIsEmptyOrOutOfBounds() {
        assertEquals(3, LauncherDropCommitPolicy.targetInsertIndex(-999, childCount = 3))
        assertEquals(3, LauncherDropCommitPolicy.targetInsertIndex(8, childCount = 3))
    }
}

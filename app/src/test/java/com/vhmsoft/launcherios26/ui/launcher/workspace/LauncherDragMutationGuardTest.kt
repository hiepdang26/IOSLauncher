package com.vhmsoft.launcherios26.ui.launcher.workspace

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherDragMutationGuardTest {
    @Test
    fun canMutate_returnsFalseWhileRecyclerViewIsComputingLayout() {
        assertFalse(
            LauncherDragMutationGuard.canMutate(
                isComputingLayout = true,
                itemAnimatorRunning = false,
                hasPendingAdapterUpdates = false,
                isScrollIdle = true
            )
        )
    }

    @Test
    fun canMutate_returnsFalseWhileItemAnimatorIsRunning() {
        assertFalse(
            LauncherDragMutationGuard.canMutate(
                isComputingLayout = false,
                itemAnimatorRunning = true,
                hasPendingAdapterUpdates = false,
                isScrollIdle = true
            )
        )
    }

    @Test
    fun canMutate_returnsFalseWhileRecyclerViewHasPendingAdapterUpdates() {
        assertFalse(
            LauncherDragMutationGuard.canMutate(
                isComputingLayout = false,
                itemAnimatorRunning = false,
                hasPendingAdapterUpdates = true,
                isScrollIdle = true
            )
        )
    }

    @Test
    fun canMutate_returnsFalseWhileRecyclerViewIsScrolling() {
        assertFalse(
            LauncherDragMutationGuard.canMutate(
                isComputingLayout = false,
                itemAnimatorRunning = false,
                hasPendingAdapterUpdates = false,
                isScrollIdle = false
            )
        )
    }

    @Test
    fun canMutate_returnsTrueWhenRecyclerViewIsIdle() {
        assertTrue(
            LauncherDragMutationGuard.canMutate(
                isComputingLayout = false,
                itemAnimatorRunning = false,
                hasPendingAdapterUpdates = false,
                isScrollIdle = true
            )
        )
    }

    @Test
    fun canMutateDuringActiveDrag_returnsFalseForHomeScreenDrag() {
        assertFalse(
            LauncherDragMutationGuard.canMutateDuringActiveDrag(
                allowFolderDrop = true,
                reorderOnMove = false
            )
        )
    }

    @Test
    fun canMutateDuringActiveDrag_returnsTrueForExplicitReorderDrag() {
        assertTrue(
            LauncherDragMutationGuard.canMutateDuringActiveDrag(
                allowFolderDrop = false,
                reorderOnMove = true
            )
        )
    }
}

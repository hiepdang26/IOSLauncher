package com.vhmsoft.launcherios26.ui.launcher.workspace

import androidx.recyclerview.widget.RecyclerView
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherPageBindDeferralTest {
    @Test
    fun shouldDefer_returnsTrueWhileChildRecyclerViewIsLayingOut() {
        assertTrue(
            LauncherPageBindDeferral.shouldDefer(
                childComputingLayout = true,
                childItemAnimatorRunning = false,
                parentComputingLayout = false,
                parentScrollState = RecyclerView.SCROLL_STATE_IDLE
            )
        )
    }

    @Test
    fun shouldDefer_returnsTrueWhileChildItemAnimatorIsRunning() {
        assertTrue(
            LauncherPageBindDeferral.shouldDefer(
                childComputingLayout = false,
                childItemAnimatorRunning = true,
                parentComputingLayout = false,
                parentScrollState = RecyclerView.SCROLL_STATE_IDLE
            )
        )
    }

    @Test
    fun shouldDefer_returnsTrueWhileParentPagerIsScrolling() {
        assertTrue(
            LauncherPageBindDeferral.shouldDefer(
                childComputingLayout = false,
                childItemAnimatorRunning = false,
                parentComputingLayout = false,
                parentScrollState = RecyclerView.SCROLL_STATE_SETTLING
            )
        )
    }

    @Test
    fun shouldDeferChildAdapterUpdate_returnsTrueWhileParentPagerIsSettling() {
        assertTrue(
            LauncherPageBindDeferral.shouldDeferChildAdapterUpdate(
                childComputingLayout = false,
                childItemAnimatorRunning = false,
                parentComputingLayout = false,
                parentScrollState = RecyclerView.SCROLL_STATE_SETTLING
            )
        )
    }

    @Test
    fun shouldDefer_returnsFalseWhenRecyclerViewsAreIdle() {
        assertFalse(
            LauncherPageBindDeferral.shouldDefer(
                childComputingLayout = false,
                childItemAnimatorRunning = false,
                parentComputingLayout = false,
                parentScrollState = RecyclerView.SCROLL_STATE_IDLE
            )
        )
    }
}

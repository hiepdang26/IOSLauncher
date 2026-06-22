package com.cloudx.ios17.core

import org.junit.Assert.assertEquals
import org.junit.Test

class LauncherHomeLayoutPolicyTest {
    @Test
    fun normalizeRows_keepsSupportedRows() {
        assertEquals(5, LauncherHomeLayoutPolicy.normalizeRows(5))
        assertEquals(6, LauncherHomeLayoutPolicy.normalizeRows(6))
    }

    @Test
    fun normalizeRows_defaultsUnsupportedRowsToSix() {
        assertEquals(6, LauncherHomeLayoutPolicy.normalizeRows(4))
        assertEquals(6, LauncherHomeLayoutPolicy.normalizeRows(7))
    }

    @Test
    fun pageSize_usesRowsAndColumns() {
        assertEquals(20, LauncherHomeLayoutPolicy.pageSize(5, 4))
        assertEquals(24, LauncherHomeLayoutPolicy.pageSize(6, 4))
    }

    @Test
    fun iconPadding_keepsIconCenteredInsideCell() {
        assertEquals(18, LauncherHomeLayoutPolicy.iconPadding(100, 64, 4))
        assertEquals(4, LauncherHomeLayoutPolicy.iconPadding(60, 64, 4))
    }
}

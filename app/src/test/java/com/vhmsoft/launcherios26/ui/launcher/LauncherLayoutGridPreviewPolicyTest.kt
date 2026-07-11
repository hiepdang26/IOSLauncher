package com.vhmsoft.launcherios26.ui.launcher

import org.junit.Assert.assertEquals
import org.junit.Test

class LauncherLayoutGridPreviewPolicyTest {
    @Test
    fun layoutGridPreview_usesFourColumnsWithFiveOrSixRows() {
        assertEquals(4, LauncherLayoutGridPreviewPolicy.columns)
        assertEquals(5, LauncherLayoutGridPreviewPolicy.rows5x4)
        assertEquals(6, LauncherLayoutGridPreviewPolicy.rows6x4)
    }

    @Test
    fun layoutGridPreview_usesSmallSquareCellsLikeTheReferenceSettingsPage() {
        assertEquals(6, LauncherLayoutGridPreviewPolicy.cellSizeDp)
        assertEquals(3, LauncherLayoutGridPreviewPolicy.cellGapDp)
        assertEquals(0xFF8F8F8F.toInt(), LauncherLayoutGridPreviewPolicy.lightCellColor)
    }
}

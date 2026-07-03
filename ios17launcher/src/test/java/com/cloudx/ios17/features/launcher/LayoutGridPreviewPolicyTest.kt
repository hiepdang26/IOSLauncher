package com.cloudx.ios17.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Test

class LayoutGridPreviewPolicyTest {
    @Test
    fun previewSpec_usesFourColumnsAndAllRowsForHomeGridOptions() {
        assertEquals(
            LayoutGridPreviewPolicy.GridSpec(rows = 5, columns = 4, cellCount = 20),
            LayoutGridPreviewPolicy.previewSpec(rows = 5)
        )
        assertEquals(
            LayoutGridPreviewPolicy.GridSpec(rows = 6, columns = 4, cellCount = 24),
            LayoutGridPreviewPolicy.previewSpec(rows = 6)
        )
    }
}

package com.cloudx.ios17.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Test

class HomeWidgetPhotoPolicyTest {
    @Test
    fun outputSizeMatchesWidgetAspect() {
        assertEquals(
            HomeWidgetPhotoPolicy.OutputSize(width = 720, height = 720),
            HomeWidgetPhotoPolicy.outputSizeFor(HomeWidgetPlacementPolicy.WidgetSize.SMALL)
        )
        assertEquals(
            HomeWidgetPhotoPolicy.OutputSize(width = 1440, height = 720),
            HomeWidgetPhotoPolicy.outputSizeFor(HomeWidgetPlacementPolicy.WidgetSize.FULL_WIDTH)
        )
    }

    @Test
    fun fileNameForWidgetIdRemovesUnsafeCharacters() {
        assertEquals("widget_a_b_1.png", HomeWidgetPhotoPolicy.fileNameForWidgetId("widget/a:b 1"))
    }

    @Test
    fun sourceRectForCropMapsVisibleCropToBitmapPixels() {
        val source = HomeWidgetPhotoPolicy.sourceRectForCrop(
            imageRect = HomeWidgetPhotoPolicy.FloatRect(left = 20f, top = 40f, right = 420f, bottom = 240f),
            cropRect = HomeWidgetPhotoPolicy.FloatRect(left = 120f, top = 90f, right = 320f, bottom = 190f),
            bitmapWidth = 800,
            bitmapHeight = 400
        )

        assertEquals(
            HomeWidgetPhotoPolicy.IntRect(left = 200, top = 100, right = 600, bottom = 300),
            source
        )
    }
}

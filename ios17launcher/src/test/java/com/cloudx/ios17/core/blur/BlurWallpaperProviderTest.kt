package com.cloudx.ios17.core.blur

import org.junit.Assert.assertEquals
import org.junit.Test

class BlurWallpaperProviderTest {
    @Test
    fun homeChromeAndFolderPreviewUseSofterWallpaperBlur() {
        assertEquals(12, BlurWallpaperProvider.blurConfigDock.radius)
        assertEquals(12, BlurWallpaperProvider.blurConfigAppGroup.radius)
    }
}

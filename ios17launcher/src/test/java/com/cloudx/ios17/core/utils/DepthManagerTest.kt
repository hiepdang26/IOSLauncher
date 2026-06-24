package com.cloudx.ios17.core.utils

import android.os.IBinder
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Test

class DepthManagerTest {

    @Test
    fun resolveWallpaperZoomOutMethod_returnsNullWhenPlatformMethodIsMissing() {
        assertNull(DepthManager.resolveWallpaperZoomOutMethod(WallpaperManagerWithoutZoom::class.java))
    }

    @Test
    fun resolveWallpaperZoomOutMethod_findsCompatiblePlatformMethod() {
        assertNotNull(DepthManager.resolveWallpaperZoomOutMethod(WallpaperManagerWithZoom::class.java))
    }

    private class WallpaperManagerWithoutZoom

    private class WallpaperManagerWithZoom {
        @Suppress("unused")
        fun setWallpaperZoomOut(windowToken: IBinder, zoom: Float) = Unit
    }
}

package com.cloudx.ios17.core.events

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNull
import org.junit.Test

class AppWallpaperEventTest {
    @Test
    fun appWallpaperEvent_carriesSelectedWallpaperUri() {
        val event = AppWallpaperEvent("content://example/wallpaper")

        assertEquals(AppWallpaperEvent.TYPE, event.eventType)
        assertEquals("content://example/wallpaper", event.wallpaperUri)
        assertNotEquals(AppRenameEvent.TYPE, event.eventType)
    }

    @Test
    fun appWallpaperEvent_allowsNullUriForDefaultWallpaper() {
        val event = AppWallpaperEvent(null)

        assertEquals(AppWallpaperEvent.TYPE, event.eventType)
        assertNull(event.wallpaperUri)
    }
}

package com.cloudx.ios17.core.events

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class AppRenameEventTest {
    @Test
    fun appRenameEvent_carriesRenameKeysAndUpdatedTitle() {
        val keys = listOf("com.example.camera/.MainActivity", "com.example.camera")

        val event = AppRenameEvent(keys, "Camera Pro")

        assertEquals(AppRenameEvent.TYPE, event.eventType)
        assertEquals(keys, event.appKeys)
        assertEquals("Camera Pro", event.updatedTitle)
        assertNotEquals(AppChangeEvent.TYPE, event.eventType)
    }
}

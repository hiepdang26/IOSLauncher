package com.vhmsoft.launcherios26.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherDockChromeControllerTest {
    @Test
    fun `set visibility shows dock and realtime glass then refreshes inactive glass`() {
        val dock = RecordingDockSurface(alpha = 0.7f)
        val glass = RecordingDockGlassSurface(realtimeActive = false)
        val controller = LauncherDockChromeController(
            dock = dock,
            glassProvider = { glass },
            realtimeDockEnabled = { true }
        )

        controller.setVisibility(true)

        assertTrue(dock.visible)
        assertTrue(glass.visible)
        assertEquals(0.7f, glass.alpha)
        assertEquals(1, glass.refreshCalls)
        assertFalse(dock.externalRealtimeLiquidGlass)
    }

    @Test
    fun `set visibility keeps realtime dock glass attached while dock is hidden`() {
        val dock = RecordingDockSurface(alpha = 0.5f)
        val glass = RecordingDockGlassSurface(realtimeActive = true)
        val controller = LauncherDockChromeController(
            dock = dock,
            glassProvider = { glass },
            realtimeDockEnabled = { true }
        )

        controller.setVisibility(false)

        assertFalse(dock.visible)
        assertTrue(glass.visible)
        assertEquals(0f, glass.alpha)
        assertEquals(0, glass.refreshCalls)
        assertTrue(dock.externalRealtimeLiquidGlass)
    }

    @Test
    fun `set visibility hides dock glass when realtime dock is disabled`() {
        val dock = RecordingDockSurface(alpha = 0.5f)
        val glass = RecordingDockGlassSurface(realtimeActive = true)
        val controller = LauncherDockChromeController(
            dock = dock,
            glassProvider = { glass },
            realtimeDockEnabled = { false }
        )

        controller.setVisibility(true)

        assertTrue(dock.visible)
        assertFalse(glass.visible)
        assertEquals(0.5f, glass.alpha)
        assertTrue(dock.externalRealtimeLiquidGlass)
    }

    @Test
    fun `sync transform mirrors dock translation and visible alpha`() {
        val dock = RecordingDockSurface(
            visible = true,
            alpha = 0.42f,
            translationY = 18f
        )
        val glass = RecordingDockGlassSurface()
        val controller = LauncherDockChromeController(
            dock = dock,
            glassProvider = { glass },
            realtimeDockEnabled = { true }
        )

        controller.syncTransform()

        assertEquals(18f, glass.translationY)
        assertEquals(0.42f, glass.alpha)
    }

    @Test
    fun `sync transform clears glass alpha when dock is hidden`() {
        val dock = RecordingDockSurface(
            visible = false,
            alpha = 0.42f,
            translationY = 18f
        )
        val glass = RecordingDockGlassSurface(alpha = 1f)
        val controller = LauncherDockChromeController(
            dock = dock,
            glassProvider = { glass },
            realtimeDockEnabled = { true }
        )

        controller.syncTransform()

        assertEquals(18f, glass.translationY)
        assertEquals(0f, glass.alpha)
    }

    private class RecordingDockSurface(
        override var visible: Boolean = false,
        override var alpha: Float = 1f,
        override var translationY: Float = 0f
    ) : LauncherDockChromeController.DockSurface {
        var externalRealtimeLiquidGlass = false

        override fun setExternalRealtimeLiquidGlassEnabled(enabled: Boolean) {
            externalRealtimeLiquidGlass = enabled
        }
    }

    private class RecordingDockGlassSurface(
        override var visible: Boolean = false,
        override var alpha: Float = 0f,
        override var translationY: Float = 0f,
        private val realtimeActive: Boolean = false
    ) : LauncherDockChromeController.DockGlassSurface {
        var refreshCalls = 0

        override fun isRealtimeLiquidGlassActive(): Boolean = realtimeActive

        override fun refreshRealtimeLiquidGlass() {
            refreshCalls++
        }
    }
}

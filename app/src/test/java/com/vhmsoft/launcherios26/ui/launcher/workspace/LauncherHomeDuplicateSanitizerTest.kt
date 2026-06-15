package com.vhmsoft.launcherios26.ui.launcher.workspace

import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable
import com.vhmsoft.launcherios26.data.model.LauncherApp
import com.vhmsoft.launcherios26.data.model.LauncherAppCategory
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherHomeDuplicateSanitizerTest {
    @Test
    fun sanitize_keepsLatestHomeOccurrenceAndBlanksOlderSlot() {
        val dragged = appItem("YT Music")
        val camera = appItem("Camera")
        val items = buildList {
            add(LauncherHomeItemUiModel.App(dragged))
            add(LauncherHomeItemUiModel.App(camera))
            repeat(23) {
                add(LauncherHomeItemUiModel.Placeholder.forGridIndex(size))
            }
            add(LauncherHomeItemUiModel.App(dragged))
        }

        val sanitized = LauncherHomeDuplicateSanitizer.sanitize(items)

        assertEquals(26, sanitized.size)
        assertTrue(sanitized[0] is LauncherHomeItemUiModel.Placeholder)
        assertEquals("Camera", sanitized[1].label)
        assertEquals("YT Music", sanitized[25].label)
        assertEquals(
            1,
            sanitized.flatMap { item -> item.containedApps() }.count { app ->
                app.app.iconKey == dragged.app.iconKey
            }
        )
    }

    @Test
    fun sanitize_removesOlderFolderOccurrenceWhenAppWasDroppedOntoHomeLater() {
        val dragged = appItem("Photos")
        val maps = appItem("Maps")
        val folder = LauncherHomeItemUiModel.Folder(
            id = "folder",
            title = "Folder",
            apps = listOf(dragged, maps)
        )
        val items = listOf(
            folder,
            LauncherHomeItemUiModel.Placeholder.forGridIndex(1),
            LauncherHomeItemUiModel.App(dragged)
        )

        val sanitized = LauncherHomeDuplicateSanitizer.sanitize(items)

        assertEquals("Maps", sanitized[0].label)
        assertTrue(sanitized[1] is LauncherHomeItemUiModel.Placeholder)
        assertEquals("Photos", sanitized[2].label)
        assertEquals(
            1,
            sanitized.flatMap { item -> item.containedApps() }.count { app ->
                app.app.iconKey == dragged.app.iconKey
            }
        )
    }

    private fun appItem(label: String): LauncherIconUiModel {
        val app = LauncherApp(
            label = label,
            packageName = "test.${label.lowercase().replace(" ", "")}",
            className = "MainActivity",
            iconKey = label
        )
        return LauncherIconUiModel(app, TestDrawable, LauncherAppCategory.OTHER)
    }

    @Suppress("OVERRIDE_DEPRECATION")
    private object TestDrawable : Drawable() {
        override fun draw(canvas: Canvas) = Unit
        override fun setAlpha(alpha: Int) = Unit
        @Suppress("DEPRECATION")
        override fun setColorFilter(colorFilter: ColorFilter?) = Unit
        @Suppress("DEPRECATION")
        override fun getOpacity(): Int = PixelFormat.TRANSLUCENT
    }
}

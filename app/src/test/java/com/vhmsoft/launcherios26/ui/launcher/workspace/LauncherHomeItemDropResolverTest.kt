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

class LauncherHomeItemDropResolverTest {
    @Test
    fun resolveDrop_movesFolderToDropIndexWithoutLeavingDuplicateFolder() {
        val folder = LauncherHomeItemUiModel.Folder(
            id = "folder-1",
            title = "Folder",
            apps = listOf(appItem("Photos"), appItem("Maps"))
        )
        val baseItems = buildList {
            add(LauncherHomeItemUiModel.Placeholder.forGridIndex(0))
            repeat(23) {
                add(LauncherHomeItemUiModel.Placeholder.forGridIndex(size))
            }
            add(LauncherHomeItemUiModel.App(appItem("Music")))
        }

        val resolved = LauncherHomeItemDropResolver.resolveDrop(
            baseItems = baseItems,
            draggedItem = folder,
            dropIndex = 25
        )

        assertEquals(26, resolved.size)
        assertTrue(resolved[0] is LauncherHomeItemUiModel.Placeholder)
        assertEquals(folder, resolved[25])
        assertEquals(1, resolved.count { item -> item.stableId == folder.stableId })
    }

    private fun appItem(label: String): LauncherIconUiModel {
        val app = LauncherApp(
            label = label,
            packageName = "test.${label.lowercase()}",
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

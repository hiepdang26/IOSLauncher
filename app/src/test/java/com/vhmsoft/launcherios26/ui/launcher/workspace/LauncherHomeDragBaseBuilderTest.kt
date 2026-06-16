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

class LauncherHomeDragBaseBuilderTest {
    @Test
    fun forMovingApp_replacesDraggedAppWithPlaceholderWithoutShiftingNextPageApps() {
        val dragged = appItem("Photos")
        val pageTwoFirst = appItem("Music")
        val pageTwoSecond = appItem("Camera")
        val items = buildList {
            add(LauncherHomeItemUiModel.App(dragged))
            repeat(23) { index ->
                add(LauncherHomeItemUiModel.Placeholder.forGridIndex(index + 1))
            }
            add(LauncherHomeItemUiModel.App(pageTwoFirst))
            add(LauncherHomeItemUiModel.App(pageTwoSecond))
        }

        val baseItems = LauncherHomeDragBaseBuilder.forMovingApp(items, dragged)

        assertTrue(baseItems[0] is LauncherHomeItemUiModel.Placeholder)
        assertEquals(pageTwoFirst.app.iconKey, baseItems[24].containedApps().single().app.iconKey)
        assertEquals(pageTwoSecond.app.iconKey, baseItems[25].containedApps().single().app.iconKey)
        assertTrue(baseItems.none { item ->
            item.containedApps().any { app -> app.app.iconKey == dragged.app.iconKey }
        })
    }

    @Test
    fun forMovingApp_usesProvidedDragSessionPlaceholder() {
        val dragged = appItem("Photos")
        val dragPlaceholder = LauncherHomeItemUiModel.Placeholder.forDragSession()
        val items = listOf(
            LauncherHomeItemUiModel.App(dragged),
            LauncherHomeItemUiModel.App(appItem("Music"))
        )

        val baseItems = LauncherHomeDragBaseBuilder.forMovingApp(
            items = items,
            draggedApp = dragged,
            placeholder = dragPlaceholder
        )

        assertEquals(dragPlaceholder.stableId, baseItems[0].stableId)
    }

    @Test
    fun forMovingItem_replacesDraggedFolderWithPlaceholderWithoutShiftingNextPageApps() {
        val draggedFolder = LauncherHomeItemUiModel.Folder(
            id = "folder-1",
            title = "Folder",
            apps = listOf(appItem("Photos"), appItem("Maps"))
        )
        val pageTwoFirst = appItem("Music")
        val pageTwoSecond = appItem("Camera")
        val items = buildList {
            add(draggedFolder)
            repeat(23) { index ->
                add(LauncherHomeItemUiModel.Placeholder.forGridIndex(index + 1))
            }
            add(LauncherHomeItemUiModel.App(pageTwoFirst))
            add(LauncherHomeItemUiModel.App(pageTwoSecond))
        }

        val baseItems = LauncherHomeDragBaseBuilder.forMovingItem(items, draggedFolder)

        assertTrue(baseItems[0] is LauncherHomeItemUiModel.Placeholder)
        assertEquals(pageTwoFirst.app.iconKey, baseItems[24].containedApps().single().app.iconKey)
        assertEquals(pageTwoSecond.app.iconKey, baseItems[25].containedApps().single().app.iconKey)
        assertTrue(baseItems.none { item -> item.stableId == draggedFolder.stableId })
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

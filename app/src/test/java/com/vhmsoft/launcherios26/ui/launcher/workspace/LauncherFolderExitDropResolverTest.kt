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

class LauncherFolderExitDropResolverTest {
    @Test
    fun resolveDrop_addsDraggedAppToTargetFolder() {
        val dragged = appItem("Photos")
        val folderApp = appItem("Maps")
        val folder = LauncherHomeItemUiModel.Folder(
            id = "folder-target",
            title = "Folder",
            apps = listOf(folderApp)
        )
        val baseItems = listOf(
            LauncherHomeItemUiModel.App(appItem("Camera")),
            folder
        )

        val resolved = LauncherFolderExitDropResolver.resolveDrop(
            baseItems = baseItems,
            draggedApp = dragged,
            dropIndex = 0,
            folderTargetIndex = 1
        )

        val resolvedFolder = resolved[1] as LauncherHomeItemUiModel.Folder
        assertEquals(listOf(folderApp, dragged), resolvedFolder.apps)
        assertEquals(2, resolved.size)
    }

    @Test
    fun resolveDrop_insertsDraggedAppAtDropIndexWhenNoFolderTarget() {
        val dragged = appItem("Photos")
        val baseItems = listOf(
            LauncherHomeItemUiModel.App(appItem("Camera")),
            LauncherHomeItemUiModel.App(appItem("Maps"))
        )

        val resolved = LauncherFolderExitDropResolver.resolveDrop(
            baseItems = baseItems,
            draggedApp = dragged,
            dropIndex = 1,
            folderTargetIndex = null
        )

        assertEquals(listOf("Camera", "Photos", "Maps"), resolved.map { item -> item.label })
        assertTrue(resolved[1] is LauncherHomeItemUiModel.App)
    }

    @Test
    fun resolveDrop_replacesPlaceholderAtDropIndexWhenDroppingIntoBlankCell() {
        val dragged = appItem("Photos")
        val baseItems = listOf(
            LauncherHomeItemUiModel.App(appItem("Camera")),
            LauncherHomeItemUiModel.Placeholder(),
            LauncherHomeItemUiModel.App(appItem("Maps"))
        )

        val resolved = LauncherFolderExitDropResolver.resolveDrop(
            baseItems = baseItems,
            draggedApp = dragged,
            dropIndex = 1,
            folderTargetIndex = null
        )

        assertEquals(listOf("Camera", "Photos", "Maps"), resolved.map { item -> item.label })
        assertTrue(resolved.none { item -> item is LauncherHomeItemUiModel.Placeholder })
    }

    @Test
    fun resolveDrop_padsPlaceholdersWhenDroppingBeyondCurrentEnd() {
        val dragged = appItem("Photos")
        val baseItems = listOf(
            LauncherHomeItemUiModel.App(appItem("Camera"))
        )

        val resolved = LauncherFolderExitDropResolver.resolveDrop(
            baseItems = baseItems,
            draggedApp = dragged,
            dropIndex = 25,
            folderTargetIndex = null
        )

        assertEquals(26, resolved.size)
        assertEquals("Photos", resolved[25].label)
        assertTrue(resolved.slice(1 until 25).all { item -> item is LauncherHomeItemUiModel.Placeholder })
    }

    @Test
    fun resolveDrop_removesExistingDraggedAppBeforeInserting() {
        val dragged = appItem("Photos")
        val baseItems = listOf(
            LauncherHomeItemUiModel.App(appItem("Camera")),
            LauncherHomeItemUiModel.App(dragged),
            LauncherHomeItemUiModel.App(appItem("Maps"))
        )

        val resolved = LauncherFolderExitDropResolver.resolveDrop(
            baseItems = baseItems,
            draggedApp = dragged,
            dropIndex = 2,
            folderTargetIndex = null
        )

        assertEquals(listOf("Camera", "Maps", "Photos"), resolved.map { item -> item.label })
        assertEquals(1, resolved.flatMap { item -> item.containedApps() }.count { app ->
            app.app.iconKey == dragged.app.iconKey
        })
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

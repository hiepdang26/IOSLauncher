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

class LauncherDockHomeDropResolverTest {
    @Test
    fun resolveDrop_createsFolderWhenDockAppIsDroppedOnHomeApp() {
        val dragged = appItem("Phone")
        val target = appItem("Photos")
        val baseItems = listOf(
            LauncherHomeItemUiModel.App(appItem("Camera")),
            LauncherHomeItemUiModel.App(target)
        )

        val resolved = LauncherDockHomeDropResolver.resolveDrop(
            baseItems = baseItems,
            dockItem = LauncherHomeItemUiModel.App(dragged),
            dropIndex = 1,
            folderTargetIndex = 1
        )

        val folder = resolved[1] as LauncherHomeItemUiModel.Folder
        assertEquals(listOf(target, dragged), folder.apps)
    }

    @Test
    fun resolveDrop_addsDockAppToTargetHomeFolder() {
        val dragged = appItem("Phone")
        val folderApp = appItem("Photos")
        val folder = LauncherHomeItemUiModel.Folder(
            id = "folder-target",
            title = "Folder",
            apps = listOf(folderApp, appItem("Maps"))
        )
        val baseItems = listOf(
            LauncherHomeItemUiModel.App(appItem("Camera")),
            folder
        )

        val resolved = LauncherDockHomeDropResolver.resolveDrop(
            baseItems = baseItems,
            dockItem = LauncherHomeItemUiModel.App(dragged),
            dropIndex = 1,
            folderTargetIndex = 1
        )

        val resolvedFolder = resolved[1] as LauncherHomeItemUiModel.Folder
        assertEquals(listOf(folderApp, appItem("Maps"), dragged), resolvedFolder.apps)
    }

    @Test
    fun resolveDrop_insertsDockFolderWhenNoHomeFolderTarget() {
        val dockFolder = LauncherHomeItemUiModel.Folder(
            id = "dock-folder",
            title = "Folder",
            apps = listOf(appItem("Phone"), appItem("Messages"))
        )
        val baseItems = listOf(
            LauncherHomeItemUiModel.App(appItem("Camera")),
            LauncherHomeItemUiModel.App(appItem("Photos"))
        )

        val resolved = LauncherDockHomeDropResolver.resolveDrop(
            baseItems = baseItems,
            dockItem = dockFolder,
            dropIndex = 1,
            folderTargetIndex = null
        )

        assertEquals(listOf("Camera", "Folder", "Photos"), resolved.map { item -> item.label })
        assertTrue(resolved[1] is LauncherHomeItemUiModel.Folder)
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

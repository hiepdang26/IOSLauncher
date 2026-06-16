package com.vhmsoft.launcherios26.ui.launcher.workspace

import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable
import com.vhmsoft.launcherios26.data.model.LauncherApp
import com.vhmsoft.launcherios26.data.model.LauncherAppCategory
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class LauncherFolderDropCommitResolverTest {
    @Test
    fun resolve_createsFolderForTwoApps() {
        val dragged = appItem("4K Wallpapers")
        val target = appItem("TikTok")

        val result = LauncherFolderDropCommitResolver.resolve(
            items = listOf(
                LauncherHomeItemUiModel.App(dragged),
                LauncherHomeItemUiModel.App(target)
            ),
            draggedStableId = dragged.stableId,
            targetStableId = target.stableId,
            newFolderId = { "folder-new" }
        )

        assertNotNull(result)
        val folder = result!!.items.single() as LauncherHomeItemUiModel.Folder
        assertEquals("folder-new", folder.id)
        assertEquals(listOf(target, dragged), folder.apps)
    }

    @Test
    fun resolve_addsAppToExistingFolder() {
        val dragged = appItem("4K Wallpapers")
        val folderApp = appItem("TikTok")
        val youtube = appItem("YouTube")
        val existingFolder = LauncherHomeItemUiModel.Folder(
            id = "folder-1",
            title = "Thư mục",
            apps = listOf(folderApp, youtube)
        )

        val result = LauncherFolderDropCommitResolver.resolve(
            items = listOf(
                LauncherHomeItemUiModel.App(dragged),
                existingFolder
            ),
            draggedStableId = dragged.stableId,
            targetStableId = existingFolder.stableId,
            newFolderId = { "unused" }
        )

        assertNotNull(result)
        val folder = result!!.items.single() as LauncherHomeItemUiModel.Folder
        assertEquals("folder-1", folder.id)
        assertEquals(listOf(folderApp, youtube, dragged), folder.apps)
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

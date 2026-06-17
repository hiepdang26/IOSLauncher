package com.vhmsoft.launcherios26.ui.launcher.workspace

import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable
import com.vhmsoft.launcherios26.data.model.LauncherApp
import com.vhmsoft.launcherios26.data.model.LauncherAppCategory
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
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
        assertTrue(result!!.items[0] is LauncherHomeItemUiModel.Placeholder)
        val folder = result.items[1] as LauncherHomeItemUiModel.Folder
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
        assertTrue(result!!.items[0] is LauncherHomeItemUiModel.Placeholder)
        val folder = result.items[1] as LauncherHomeItemUiModel.Folder
        assertEquals("folder-1", folder.id)
        assertEquals(listOf(folderApp, youtube, dragged), folder.apps)
    }

    @Test
    fun resolve_keepsPlaceholderWhenFullPageAppIsDroppedIntoFolder() {
        val dragged = appItem("Dragged")
        val folderApp = appItem("Folder App")
        val folderApp2 = appItem("Folder App 2")
        val existingFolder = LauncherHomeItemUiModel.Folder(
            id = "folder-1",
            title = "ThÆ° má»¥c",
            apps = listOf(folderApp, folderApp2)
        )
        val pageItems = MutableList<LauncherHomeItemUiModel>(24) { index ->
            LauncherHomeItemUiModel.App(appItem("App $index"))
        }
        pageItems[5] = LauncherHomeItemUiModel.App(dragged)
        pageItems[10] = existingFolder

        val result = LauncherFolderDropCommitResolver.resolve(
            items = pageItems,
            draggedStableId = dragged.stableId,
            targetStableId = existingFolder.stableId,
            newFolderId = { "unused" }
        )

        assertNotNull(result)
        assertEquals(24, result!!.items.size)
        assertTrue(result.items[5] is LauncherHomeItemUiModel.Placeholder)
        val folder = result.items[10] as LauncherHomeItemUiModel.Folder
        assertEquals(listOf(folderApp, folderApp2, dragged), folder.apps)
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

package com.vhmsoft.launcherios26.ui.launcher.workspace

import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable
import com.vhmsoft.launcherios26.data.model.LauncherApp
import com.vhmsoft.launcherios26.data.model.LauncherAppCategory
import com.vhmsoft.launcherios26.data.model.LauncherFolder
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherHomeLayoutBuilderTest {
    @Test
    fun build_placesSavedFolderAtFirstFolderAppPosition() {
        val photos = appItem("Photos")
        val camera = appItem("Camera")
        val maps = appItem("Maps")
        val folder = LauncherFolder(
            id = "folder-1",
            title = "Thư mục",
            appIconKeys = listOf(photos.app.iconKey, maps.app.iconKey)
        )

        val items = LauncherHomeLayoutBuilder.build(
            apps = listOf(photos, camera, maps),
            folders = listOf(folder)
        )

        assertTrue(items[0] is LauncherHomeItemUiModel.Folder)
        assertTrue(items[1] is LauncherHomeItemUiModel.App)
        assertEquals(listOf(camera), items[1].containedApps())
        assertEquals(listOf(photos, maps), items[0].containedApps())
    }

    @Test
    fun extractFolders_keepsFolderAppIconKeysForPersistence() {
        val photos = appItem("Photos")
        val camera = appItem("Camera")
        val folderItem = LauncherHomeItemUiModel.Folder(
            id = "folder-1",
            title = "Thư mục",
            apps = listOf(photos, camera)
        )

        val folders = LauncherHomeLayoutBuilder.extractFolders(listOf(folderItem))

        assertEquals(
            listOf(LauncherFolder("folder-1", "Thư mục", listOf("Photos", "Camera"))),
            folders
        )
    }

    @Test
    fun normalize_rekeysPlaceholdersByCurrentPositionToAvoidDuplicateStableIds() {
        val normalized = LauncherHomeLayoutBuilder.normalize(
            listOf(
                LauncherHomeItemUiModel.App(appItem("Photos")),
                LauncherHomeItemUiModel.Placeholder.forGridIndex(24),
                LauncherHomeItemUiModel.Placeholder.forGridIndex(24)
            )
        )

        val placeholderIds = normalized
            .filterIsInstance<LauncherHomeItemUiModel.Placeholder>()
            .map { placeholder -> placeholder.stableId }

        assertEquals(
            listOf(
                LauncherHomeItemUiModel.Placeholder.forGridIndex(1).stableId,
                LauncherHomeItemUiModel.Placeholder.forGridIndex(2).stableId
            ),
            placeholderIds
        )
        assertEquals(placeholderIds.size, placeholderIds.toSet().size)
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

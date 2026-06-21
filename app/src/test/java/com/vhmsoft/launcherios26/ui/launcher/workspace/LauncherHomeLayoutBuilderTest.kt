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
    fun build_createsIosCloneDefaultFirstPageWithGoogleFolderWhenNoSavedFoldersExist() {
        val weather = appItem("Thời tiết", packageName = "com.vhmsoft.weather")
        val launcher = appItem("iOS Launcher", packageName = "com.vhmsoft.launcherios26")
        val playStore = appItem("Cửa hàng Play", packageName = "com.android.vending")
        val chrome = appItem("Chrome", packageName = "com.android.chrome")
        val gmail = appItem("Gmail", packageName = "com.google.android.gm")
        val maps = appItem("Maps", packageName = "com.google.android.apps.maps")
        val youtube = appItem("YouTube", packageName = "com.google.android.youtube")
        val zalo = appItem("Zalo", packageName = "com.zing.zalo")

        val items = LauncherHomeLayoutBuilder.build(
            apps = listOf(zalo, gmail, weather, maps, launcher, chrome, playStore, youtube),
            folders = emptyList()
        )

        assertEquals(listOf(weather), items[0].containedApps())
        assertEquals(listOf(launcher), items[1].containedApps())
        assertEquals(listOf(playStore), items[2].containedApps())
        val googleFolder = items[3] as LauncherHomeItemUiModel.Folder
        assertEquals(LauncherHomeLayoutBuilder.DEFAULT_FOLDER_TITLE, googleFolder.title)
        assertEquals(listOf(gmail, maps, chrome, youtube), googleFolder.apps)
        assertTrue(items.slice(4 until 24).all { item -> item is LauncherHomeItemUiModel.Placeholder })
        assertEquals(listOf(zalo), items[24].containedApps())
    }

    @Test
    fun build_wrapsEveryGoogleAppInDefaultFolderEvenWhenOnlyOneGoogleAppExists() {
        val weather = appItem("Thời tiết", packageName = "com.vhmsoft.weather")
        val launcher = appItem("iOS Launcher", packageName = "com.vhmsoft.launcherios26")
        val playStore = appItem("Cửa hàng Play", packageName = "com.android.vending")
        val gmail = appItem("Gmail", packageName = "com.google.android.gm")
        val zalo = appItem("Zalo", packageName = "com.zing.zalo")

        val items = LauncherHomeLayoutBuilder.build(
            apps = listOf(zalo, weather, gmail, launcher, playStore),
            folders = emptyList()
        )

        val googleFolder = items[3] as LauncherHomeItemUiModel.Folder
        assertEquals(listOf(gmail), googleFolder.apps)
        assertTrue(items.slice(4 until 24).all { item -> item is LauncherHomeItemUiModel.Placeholder })
        assertEquals(listOf(zalo), items[24].containedApps())
    }

    @Test
    fun normalizeAndExtractFolders_keepSingleAppDefaultGoogleFolderForPersistence() {
        val weather = appItem("Thời tiết", packageName = "com.vhmsoft.weather")
        val launcher = appItem("iOS Launcher", packageName = "com.vhmsoft.launcherios26")
        val playStore = appItem("Cửa hàng Play", packageName = "com.android.vending")
        val gmail = appItem("Gmail", packageName = "com.google.android.gm")

        val items = LauncherHomeLayoutBuilder.build(
            apps = listOf(weather, launcher, playStore, gmail),
            folders = emptyList()
        )

        assertTrue(LauncherHomeLayoutBuilder.normalize(items)[3] is LauncherHomeItemUiModel.Folder)
        assertEquals(
            listOf(gmail.app.iconKey),
            LauncherHomeLayoutBuilder.extractFolders(items).single().appIconKeys
        )
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

    @Test
    fun compact_removesPlaceholdersAndKeepsItemOrder() {
        val photos = appItem("Photos")
        val camera = appItem("Camera")
        val maps = appItem("Maps")
        val folderItem = LauncherHomeItemUiModel.Folder(
            id = "folder-1",
            title = "Folder",
            apps = listOf(camera, maps)
        )

        val compacted = LauncherHomeLayoutBuilder.compact(
            listOf(
                LauncherHomeItemUiModel.Placeholder.forGridIndex(0),
                LauncherHomeItemUiModel.App(photos),
                LauncherHomeItemUiModel.Placeholder.forGridIndex(2),
                folderItem
            )
        )

        assertEquals(
            listOf(
                LauncherHomeItemUiModel.App(photos),
                folderItem
            ),
            compacted
        )
    }

    private fun appItem(
        label: String,
        packageName: String = "test.${label.lowercase()}"
    ): LauncherIconUiModel {
        val app = LauncherApp(
            label = label,
            packageName = packageName,
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

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

class LauncherHomeLayoutStatePolicyTest {
    @Test
    fun resetFoldersToApps_removesFoldersAndReturnsStandaloneApps() {
        val photos = appItem("Photos")
        val camera = appItem("Camera")
        val maps = appItem("Maps")
        val folder = LauncherHomeItemUiModel.Folder(
            id = "folder-1",
            title = "Thư mục",
            apps = listOf(photos, camera)
        )

        val reset = LauncherHomeLayoutStatePolicy.resetFoldersToApps(
            listOf(
                LauncherHomeItemUiModel.App(maps),
                LauncherHomeItemUiModel.Placeholder.forGridIndex(1),
                folder
            )
        )

        assertEquals(listOf("Maps", "Photos", "Camera"), reset.map { item -> item.label })
        assertTrue(reset.all { item -> item is LauncherHomeItemUiModel.App })
    }

    @Test
    fun arrange_compactsOnlyWhenAutoArrangeIsEnabled() {
        val photos = LauncherHomeItemUiModel.App(appItem("Photos"))
        val camera = LauncherHomeItemUiModel.App(appItem("Camera"))
        val items = listOf(
            photos,
            LauncherHomeItemUiModel.Placeholder.forGridIndex(1),
            camera
        )

        assertEquals(items, LauncherHomeLayoutStatePolicy.arrange(items, autoArrange = false))
        assertEquals(listOf(photos, camera), LauncherHomeLayoutStatePolicy.arrange(items, autoArrange = true))
    }

    @Test
    fun restore_keepsSavedPlaceholderInsteadOfFillingFromLaterApps() {
        val photos = appItem("Photos")
        val camera = appItem("Camera")
        val maps = appItem("Maps")
        val saved = LauncherHomeLayoutStatePolicy.encode(
            listOf(
                LauncherHomeItemUiModel.App(photos),
                LauncherHomeItemUiModel.Placeholder.forGridIndex(1),
                LauncherHomeItemUiModel.App(camera)
            )
        )
        val fallback = listOf(
            LauncherHomeItemUiModel.App(photos),
            LauncherHomeItemUiModel.App(camera),
            LauncherHomeItemUiModel.App(maps)
        )

        val restored = LauncherHomeLayoutStatePolicy.restore(
            encoded = saved,
            apps = listOf(photos, camera, maps),
            folders = emptyList(),
            fallbackItems = fallback
        )

        assertEquals("Photos", restored[0].label)
        assertTrue(restored[1] is LauncherHomeItemUiModel.Placeholder)
        assertEquals("Camera", restored[2].label)
        assertEquals("Maps", restored[3].label)
    }

    @Test
    fun restoreThenAutoArrange_preservesSavedOrderAndCompactsPlaceholders() {
        val photos = appItem("Photos")
        val camera = appItem("Camera")
        val maps = appItem("Maps")
        val music = appItem("Music")
        val saved = LauncherHomeLayoutStatePolicy.encode(
            listOf(
                LauncherHomeItemUiModel.App(maps),
                LauncherHomeItemUiModel.Placeholder.forGridIndex(1),
                LauncherHomeItemUiModel.App(photos),
                LauncherHomeItemUiModel.App(camera)
            )
        )
        val fallback = listOf(
            LauncherHomeItemUiModel.App(photos),
            LauncherHomeItemUiModel.App(camera),
            LauncherHomeItemUiModel.App(maps),
            LauncherHomeItemUiModel.App(music)
        )

        val restored = LauncherHomeLayoutStatePolicy.restore(
            encoded = saved,
            apps = listOf(photos, camera, maps, music),
            folders = emptyList(),
            fallbackItems = fallback
        )
        val arranged = LauncherHomeLayoutStatePolicy.arrange(restored, autoArrange = true)

        assertEquals(listOf("Maps", "Photos", "Camera", "Music"), arranged.map { item -> item.label })
        assertTrue(arranged.none { item -> item is LauncherHomeItemUiModel.Placeholder })
    }

    @Test
    fun restore_keepsSavedFolderPosition() {
        val photos = appItem("Photos")
        val camera = appItem("Camera")
        val maps = appItem("Maps")
        val saved = LauncherHomeLayoutStatePolicy.encode(
            listOf(
                LauncherHomeItemUiModel.Placeholder.forGridIndex(0),
                LauncherHomeItemUiModel.Folder(
                    id = "folder-1",
                    title = "Thư mục",
                    apps = listOf(photos, camera)
                )
            )
        )

        val restored = LauncherHomeLayoutStatePolicy.restore(
            encoded = saved,
            apps = listOf(photos, camera, maps),
            folders = listOf(
                LauncherFolder(
                    id = "folder-1",
                    title = "Thư mục",
                    appIconKeys = listOf("Photos", "Camera")
                )
            ),
            fallbackItems = listOf(
                LauncherHomeItemUiModel.Folder(
                    id = "folder-1",
                    title = "Thư mục",
                    apps = listOf(photos, camera)
                ),
                LauncherHomeItemUiModel.App(maps)
            )
        )

        assertTrue(restored[0] is LauncherHomeItemUiModel.Placeholder)
        assertTrue(restored[1] is LauncherHomeItemUiModel.Folder)
        assertEquals("Maps", restored[2].label)
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

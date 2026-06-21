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
    fun resolveDrop_insertsDraggedItemAtTargetIndexLikeIos17() {
        val baseItems = appItems("A", "B", "C", "D", "E", "F", "G", "H")

        val resolved = LauncherHomeItemDropResolver.resolveDrop(
            baseItems = baseItems,
            draggedItem = baseItems[0],
            dropIndex = 2
        )

        assertEquals(listOf("B", "C", "A", "D", "E", "F", "G", "H"), labels(resolved))
    }

    @Test
    fun resolveDrop_insertsDraggedItemAtTargetIndexLikeIos17ReorderAlarm() {
        val baseItems = appItems("A", "B", "C", "D", "E", "F", "G", "H", "I")

        val resolved = LauncherHomeItemDropResolver.resolveDrop(
            baseItems = baseItems,
            draggedItem = baseItems[0],
            dropIndex = 8
        )

        assertEquals(listOf("B", "C", "D", "E", "F", "G", "H", "I", "A"), labels(resolved))
    }

    @Test
    fun resolveDrop_insertsDraggedItemInsteadOfSwappingLikeIos17() {
        val baseItems = appItems("A", "B", "C", "D", "E", "F", "G", "H")

        val resolved = LauncherHomeItemDropResolver.resolveDrop(
            baseItems = baseItems,
            draggedItem = baseItems[0],
            dropIndex = 5
        )

        assertEquals(listOf("B", "C", "D", "E", "F", "A", "G", "H"), labels(resolved))
    }

    @Test
    fun resolveDrop_movesDragPlaceholderWithoutChangingPageSize() {
        val dragPlaceholder = LauncherHomeItemUiModel.Placeholder.forDragSession()
        val camera = LauncherHomeItemUiModel.App(appItem("Camera"))
        val maps = LauncherHomeItemUiModel.App(appItem("Maps"))
        val baseItems = listOf(
            dragPlaceholder,
            camera,
            maps,
            LauncherHomeItemUiModel.Placeholder.forGridIndex(3)
        )

        val resolved = LauncherHomeItemDropResolver.resolveDrop(
            baseItems = baseItems,
            draggedItem = dragPlaceholder,
            dropIndex = 2
        )

        assertEquals(baseItems.size, resolved.size)
        assertEquals(listOf("Maps", "Camera", ""), resolved.take(3).map { item -> item.label })
        assertEquals(dragPlaceholder.stableId, resolved[2].stableId)
        assertEquals(1, resolved.count { item -> item.stableId == dragPlaceholder.stableId })
    }

    @Test
    fun resolveDrop_swapsDraggedItemWithTargetWhenSourcePlaceholderExists() {
        val sourcePlaceholder = LauncherHomeItemUiModel.Placeholder.forDragSession()
        val camera = LauncherHomeItemUiModel.App(appItem("Camera"))
        val maps = LauncherHomeItemUiModel.App(appItem("Maps"))
        val music = LauncherHomeItemUiModel.App(appItem("Music"))
        val baseItems = listOf(
            sourcePlaceholder,
            maps,
            music
        )

        val resolved = LauncherHomeItemDropResolver.resolveDrop(
            baseItems = baseItems,
            draggedItem = camera,
            dropIndex = 1,
            sourcePlaceholderStableId = sourcePlaceholder.stableId
        )

        assertEquals(listOf("Maps", "Camera", "Music"), labels(resolved))
    }

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

    private fun appItems(vararg labels: String): List<LauncherHomeItemUiModel.App> {
        return labels.map { label -> LauncherHomeItemUiModel.App(appItem(label)) }
    }

    private fun labels(items: List<LauncherHomeItemUiModel>): List<String> {
        return items.map { item -> item.label }
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

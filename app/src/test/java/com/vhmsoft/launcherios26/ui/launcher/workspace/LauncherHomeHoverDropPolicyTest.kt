package com.vhmsoft.launcherios26.ui.launcher.workspace

import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable
import com.vhmsoft.launcherios26.data.model.LauncherApp
import com.vhmsoft.launcherios26.data.model.LauncherAppCategory
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class LauncherHomeHoverDropPolicyTest {
    @Test
    fun resolveAction_returnsFolderWhenDraggingAppOverCenterOfApp() {
        val dragged = LauncherHomeItemUiModel.App(appItem("Photos"))
        val target = LauncherHomeItemUiModel.App(appItem("Maps"))

        val action = LauncherHomeHoverDropPolicy.resolveAction(
            draggedItem = dragged,
            targetItem = target,
            localXInCell = 0.5f,
            localYInCell = 0.5f
        )

        assertEquals(LauncherHomeHoverDropAction.FOLDER, action)
    }

    @Test
    fun resolveAction_returnsFolderWhenDraggingAppOverCenterOfFolder() {
        val dragged = LauncherHomeItemUiModel.App(appItem("Photos"))
        val target = LauncherHomeItemUiModel.Folder(
            id = "folder",
            title = "Folder",
            apps = listOf(appItem("Maps"))
        )

        val action = LauncherHomeHoverDropPolicy.resolveAction(
            draggedItem = dragged,
            targetItem = target,
            localXInCell = 0.5f,
            localYInCell = 0.5f
        )

        assertEquals(LauncherHomeHoverDropAction.FOLDER, action)
    }

    @Test
    fun resolveAction_returnsReorderOnLeftEdgeWhenNotInsideFolderInterest() {
        val dragged = LauncherHomeItemUiModel.App(appItem("Photos"))
        val target = LauncherHomeItemUiModel.App(appItem("Maps"))

        val action = LauncherHomeHoverDropPolicy.resolveAction(
            draggedItem = dragged,
            targetItem = target,
            localXInCell = 0.03f,
            localYInCell = 0.5f
        )

        assertEquals(LauncherHomeHoverDropAction.REORDER, action)
    }

    @Test
    fun resolveAction_returnsReorderOnRightEdgeWhenNotInsideFolderInterest() {
        val dragged = LauncherHomeItemUiModel.App(appItem("Photos"))
        val target = LauncherHomeItemUiModel.App(appItem("Maps"))

        val action = LauncherHomeHoverDropPolicy.resolveAction(
            draggedItem = dragged,
            targetItem = target,
            localXInCell = 0.97f,
            localYInCell = 0.5f
        )

        assertEquals(LauncherHomeHoverDropAction.REORDER, action)
    }

    @Test
    fun resolveAction_usesIos17DistanceForFolderInterestNearHorizontalEdge() {
        val dragged = LauncherHomeItemUiModel.App(appItem("Photos"))
        val target = LauncherHomeItemUiModel.App(appItem("Maps"))

        val action = LauncherHomeHoverDropPolicy.resolveAction(
            draggedItem = dragged,
            targetItem = target,
            localXInCell = 0.1f,
            localYInCell = 0.5f
        )

        assertEquals(LauncherHomeHoverDropAction.FOLDER, action)
    }

    @Test
    fun resolveAction_doesNotMergeDraggedFolderIntoTarget() {
        val dragged = LauncherHomeItemUiModel.Folder(
            id = "dragged-folder",
            title = "Folder",
            apps = listOf(appItem("Photos"))
        )
        val target = LauncherHomeItemUiModel.App(appItem("Maps"))

        val action = LauncherHomeHoverDropPolicy.resolveAction(
            draggedItem = dragged,
            targetItem = target,
            localXInCell = 0.5f,
            localYInCell = 0.5f
        )

        assertEquals(LauncherHomeHoverDropAction.REORDER, action)
    }

    @Test
    fun resolveAction_ignoresPlaceholderTargets() {
        val dragged = LauncherHomeItemUiModel.App(appItem("Photos"))
        val target = LauncherHomeItemUiModel.Placeholder.forGridIndex(3)

        val action = LauncherHomeHoverDropPolicy.resolveAction(
            draggedItem = dragged,
            targetItem = target,
            localXInCell = 0.5f,
            localYInCell = 0.5f
        )

        assertNull(action)
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

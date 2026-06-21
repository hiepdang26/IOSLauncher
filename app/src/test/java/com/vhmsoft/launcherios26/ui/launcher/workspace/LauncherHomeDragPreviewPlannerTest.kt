package com.vhmsoft.launcherios26.ui.launcher.workspace

import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable
import com.vhmsoft.launcherios26.data.model.LauncherApp
import com.vhmsoft.launcherios26.data.model.LauncherAppCategory
import org.junit.Assert.assertEquals
import org.junit.Test

class LauncherHomeDragPreviewPlannerTest {
    @Test
    fun movesAllDisplacedHomeIconsToTheirPreviewCells() {
        val camera = LauncherHomeItemUiModel.App(appItem("Camera"))
        val maps = LauncherHomeItemUiModel.App(appItem("Maps"))
        val music = LauncherHomeItemUiModel.App(appItem("Music"))
        val phone = LauncherHomeItemUiModel.App(appItem("Phone"))
        val dragPlaceholder = LauncherHomeItemUiModel.Placeholder.forDragSession()
        val basePage = listOf(
            camera,
            maps,
            music,
            phone,
            LauncherHomeItemUiModel.Placeholder.forGridIndex(4),
            LauncherHomeItemUiModel.Placeholder.forGridIndex(5)
        )
        val previewPage = listOf(
            camera,
            dragPlaceholder,
            maps,
            music,
            phone,
            LauncherHomeItemUiModel.Placeholder.forGridIndex(5)
        )

        val moves = LauncherHomeDragPreviewPlanner.moves(
            basePageItems = basePage,
            previewPageItems = previewPage
        )

        assertEquals(
            listOf(
                LauncherHomeDragPreviewPlanner.Move(maps.stableId, 1, 2),
                LauncherHomeDragPreviewPlanner.Move(music.stableId, 2, 3),
                LauncherHomeDragPreviewPlanner.Move(phone.stableId, 3, 4)
            ),
            moves
        )
    }

    @Test
    fun ignoresPlaceholdersAndUnchangedIcons() {
        val camera = LauncherHomeItemUiModel.App(appItem("Camera"))
        val basePage = listOf(
            camera,
            LauncherHomeItemUiModel.Placeholder.forGridIndex(1)
        )
        val previewPage = listOf(
            camera,
            LauncherHomeItemUiModel.Placeholder.forGridIndex(1)
        )

        val moves = LauncherHomeDragPreviewPlanner.moves(
            basePageItems = basePage,
            previewPageItems = previewPage
        )

        assertEquals(emptyList<LauncherHomeDragPreviewPlanner.Move>(), moves)
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

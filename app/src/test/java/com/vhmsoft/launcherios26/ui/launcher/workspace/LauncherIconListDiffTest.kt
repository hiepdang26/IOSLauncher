package com.vhmsoft.launcherios26.ui.launcher.workspace

import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable
import com.vhmsoft.launcherios26.data.model.LauncherApp
import com.vhmsoft.launcherios26.data.model.LauncherAppCategory
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherIconListDiffTest {
    @Test
    fun between_marksOnlyChangedSlotsWhenListSizeIsStable() {
        val oldItems = listOf(
            LauncherHomeItemUiModel.App(appItem("Camera")),
            LauncherHomeItemUiModel.Placeholder.forGridIndex(1),
            LauncherHomeItemUiModel.App(appItem("Maps"))
        )
        val newItems = listOf(
            LauncherHomeItemUiModel.App(appItem("Camera")),
            LauncherHomeItemUiModel.App(appItem("Photos")),
            LauncherHomeItemUiModel.App(appItem("Maps"))
        )

        val diff = LauncherIconListDiff.between(oldItems, newItems)

        assertFalse(diff.requiresFullRefresh)
        assertEquals(listOf(1), diff.changedIndices)
    }

    @Test
    fun between_requiresFullRefreshWhenListSizeChanges() {
        val oldItems = listOf(LauncherHomeItemUiModel.App(appItem("Camera")))
        val newItems = oldItems + LauncherHomeItemUiModel.App(appItem("Photos"))

        val diff = LauncherIconListDiff.between(oldItems, newItems)

        assertTrue(diff.requiresFullRefresh)
        assertTrue(diff.changedIndices.isEmpty())
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

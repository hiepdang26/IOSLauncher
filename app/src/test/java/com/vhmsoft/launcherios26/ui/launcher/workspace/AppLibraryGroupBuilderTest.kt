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

class AppLibraryGroupBuilderTest {
    @Test
    fun buildGroups_placesAppsInTheirSelectedCategories() {
        val productivityApp = appItem(
            label = "ChatGPT",
            category = LauncherAppCategory.PRODUCTIVITY
        )
        val gameApp = appItem(
            label = "Car Driving City 3D",
            category = LauncherAppCategory.GAME
        )

        val groups = AppLibraryGroupBuilder.buildGroups(listOf(productivityApp, gameApp))

        assertEquals(listOf(productivityApp), groups.appsFor(LauncherAppCategory.PRODUCTIVITY))
        assertEquals(listOf(gameApp), groups.appsFor(LauncherAppCategory.GAME))
        assertTrue(groups.appsFor(LauncherAppCategory.OTHER).isEmpty())
    }

    private fun List<AppLibraryGroupUiModel>.appsFor(
        category: LauncherAppCategory
    ): List<LauncherIconUiModel> {
        return first { group -> group.category == category }.apps
    }

    private fun appItem(label: String, category: LauncherAppCategory): LauncherIconUiModel {
        val app = LauncherApp(
            label = label,
            packageName = "test.${label.lowercase().replace(" ", ".")}",
            className = "MainActivity",
            iconKey = label
        )
        return LauncherIconUiModel(app = app, icon = TestDrawable, category = category)
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

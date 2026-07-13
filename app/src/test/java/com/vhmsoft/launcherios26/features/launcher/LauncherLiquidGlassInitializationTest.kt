package com.vhmsoft.launcherios26.features.launcher

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

class LauncherLiquidGlassInitializationTest {

    @Test
    fun onCreate_preparesWallpaperSourceBeforeInitialLiquidGlassBind() {
        val source = launcherActivitySource()
        val onCreateBody = functionBody(source, "onCreate")
        val wallpaperIndex = onCreateBody.indexOf("applyCustomWallpaperFromPreferences()")
        val liquidGlassIndex = onCreateBody.indexOf("applyLiquidGlassAppearance()")

        assertTrue(wallpaperIndex >= 0)
        assertTrue(liquidGlassIndex >= 0)
        assertTrue(wallpaperIndex < liquidGlassIndex)
    }

    @Test
    fun setupViews_doesNotBindLiquidGlassBeforeWallpaperSourceExists() {
        val setupViewsBody = functionBody(launcherActivitySource(), "setupViews")

        assertFalse(setupViewsBody.contains("applyLiquidGlassAppearance()"))
    }

    private fun launcherActivitySource(): String =
        listOf(
            File("app/src/main/java/com/vhmsoft/launcherios26/features/launcher/LauncherActivity.kt"),
            File("src/main/java/com/vhmsoft/launcherios26/features/launcher/LauncherActivity.kt")
        ).first { it.exists() }.readText()

    private fun functionBody(source: String, functionName: String): String {
        val start = source.indexOf("fun $functionName(")
        require(start >= 0) { "Missing function $functionName" }
        val bodyStart = source.indexOf('{', start)
        require(bodyStart >= 0) { "Missing body for $functionName" }
        var depth = 0
        for (index in bodyStart until source.length) {
            when (source[index]) {
                '{' -> depth++
                '}' -> {
                    depth--
                    if (depth == 0) {
                        return source.substring(bodyStart + 1, index)
                    }
                }
            }
        }
        error("Unclosed body for $functionName")
    }
}

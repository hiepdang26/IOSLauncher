package com.vhmsoft.launcherios26

import java.io.File
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class AndroidProjectConfigTest {
    @Test
    fun `android sdk versions match launcher requirement`() {
        val gradle = buildGradleFile().readText()

        assertEquals(26, gradleConfigInt(gradle, "minSdk"))
        assertEquals(36, gradleConfigInt(gradle, "targetSdk"))
    }

    @Test
    fun `launcher activity keeps reducing manual findViewById usage`() {
        val launcherActivity = launcherActivityFile().readText()

        val manualFindViewByIdCount = Regex("""\bfindViewById\s*<""")
            .findAll(launcherActivity)
            .count()

        assertTrue(
            "LauncherActivity has $manualFindViewByIdCount manual findViewById calls",
            manualFindViewByIdCount <= 6
        )
    }

    @Test
    fun `search input observer uses view binding for suggested apps`() {
        val observer = searchInputObserverFile().readText()

        assertEquals(0, Regex("""\bfindViewById\s*<""").findAll(observer).count())
    }

    private fun gradleConfigInt(gradle: String, key: String): Int {
        val pattern = Regex("""$key\s*=\s*(\d+)""")
        val match = pattern.find(gradle) ?: error("$key is not configured")
        return match.groupValues[1].toInt()
    }

    private fun buildGradleFile(): File {
        return listOf(
            File("app/build.gradle.kts"),
            File("build.gradle.kts")
        ).first { it.exists() }
    }

    private fun launcherActivityFile(): File {
        return listOf(
            File("app/src/main/java/com/vhmsoft/launcherios26/features/launcher/LauncherActivity.kt"),
            File("src/main/java/com/vhmsoft/launcherios26/features/launcher/LauncherActivity.kt")
        ).first { it.exists() }
    }

    private fun searchInputObserverFile(): File {
        return listOf(
            File("app/src/main/java/com/vhmsoft/launcherios26/features/launcher/SearchInputDisposableObserver.kt"),
            File("src/main/java/com/vhmsoft/launcherios26/features/launcher/SearchInputDisposableObserver.kt")
        ).first { it.exists() }
    }
}

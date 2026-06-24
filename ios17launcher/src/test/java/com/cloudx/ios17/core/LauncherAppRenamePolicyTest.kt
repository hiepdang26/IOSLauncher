package com.cloudx.ios17.core

import org.junit.Assert.assertEquals
import org.junit.Test

class LauncherAppRenamePolicyTest {

    @Test
    fun `custom title is used when saved for app id`() {
        val title = LauncherAppRenamePolicy.displayTitle(
            appId = "com.example/.Main",
            defaultTitle = "Example",
            renamedTitles = mapOf("com.example/.Main" to "New name")
        )

        assertEquals("New name", title)
    }

    @Test
    fun `default title is used when saved title is blank`() {
        val title = LauncherAppRenamePolicy.displayTitle(
            appId = "com.example/.Main",
            defaultTitle = "Example",
            renamedTitles = mapOf("com.example/.Main" to "   ")
        )

        assertEquals("Example", title)
    }

    @Test
    fun `custom title is used when saved for alternate app key`() {
        val title = LauncherAppRenamePolicy.displayTitle(
            appKeys = listOf("com.example/.Main", "com.example"),
            defaultTitle = "Example",
            renamedTitles = mapOf("com.example" to "Renamed")
        )

        assertEquals("Renamed", title)
    }

    @Test
    fun `matching app keys detect same app from alternate key`() {
        val matches = LauncherAppRenamePolicy.matchesApp(
            targetKeys = listOf("com.example/.Main", "com.example"),
            candidateKeys = listOf("com.example/.Other")
        )

        assertEquals(true, matches)
    }

    @Test
    fun `submitted title is trimmed before saving`() {
        val title = LauncherAppRenamePolicy.submittedTitle(
            input = "  Zalo mới  ",
            currentTitle = "Zalo"
        )

        assertEquals("Zalo mới", title)
    }

    @Test
    fun `blank submitted title keeps current title`() {
        val title = LauncherAppRenamePolicy.submittedTitle(
            input = "  ",
            currentTitle = "Zalo"
        )

        assertEquals("Zalo", title)
    }
}

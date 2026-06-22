package com.cloudx.ios17.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Test

class AppLibrarySearchPolicyTest {
    private val apps = listOf(
        AppLibraryCategoryPolicy.App("com.one/.Main", "1.1.1.1", "com.one"),
        AppLibraryCategoryPolicy.App("com.wallpaper/.Main", "4K Wallpapers", "com.wallpaper"),
        AppLibraryCategoryPolicy.App("com.acb/.Main", "ACB ONE", "com.acb"),
        AppLibraryCategoryPolicy.App("com.agoda/.Main", "Agoda", "com.agoda"),
        AppLibraryCategoryPolicy.App("com.driving/.Main", "Car Driving City", "com.driving"),
        AppLibraryCategoryPolicy.App("com.chatgpt/.Main", "ChatGPT", "com.openai.chatgpt")
    )

    @Test
    fun sections_groupsEmptyQueryByNumberThenLetters() {
        val sections = AppLibrarySearchPolicy.sections(
            apps = apps,
            query = "",
            sectionFilter = null
        )

        assertEquals(listOf("1", "4", "A", "C"), sections.map { it.label })
        assertEquals(listOf("1.1.1.1"), sections[0].apps.map { it.title })
        assertEquals(listOf("ACB ONE", "Agoda"), sections[2].apps.map { it.title })
    }

    @Test
    fun sections_filtersByQueryInTitleOrPackageName() {
        val sections = AppLibrarySearchPolicy.sections(
            apps = apps,
            query = "g",
            sectionFilter = null
        )

        assertEquals(
            listOf("Agoda", "Car Driving City", "ChatGPT"),
            sections.flatMap { it.apps }.map { it.title }
        )
    }

    @Test
    fun sections_filtersByRightIndexLabel() {
        val sections = AppLibrarySearchPolicy.sections(
            apps = apps,
            query = "",
            sectionFilter = "A"
        )

        assertEquals(listOf("A"), sections.map { it.label })
        assertEquals(listOf("ACB ONE", "Agoda"), sections.single().apps.map { it.title })
    }

    @Test
    fun indexLabels_includesNumberSectionsThenAlphabet() {
        assertEquals(
            listOf("1", "4", "A", "B", "C"),
            AppLibrarySearchPolicy.indexLabels(apps).take(5)
        )
        assertEquals("Z", AppLibrarySearchPolicy.indexLabels(apps).last())
    }
}

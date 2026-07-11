package com.vhmsoft.launcherios26.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Test

class AppLibraryCategoryPolicyTest {
    @Test
    fun iconKeyFromLauncherId_removesUserSuffixFromComponentKey() {
        assertEquals(
            "com.example.music/com.example.music.MainActivity",
            AppLibraryCategoryPolicy.iconKeyFromLauncherId(
                "com.example.music/com.example.music.MainActivity/0"
            )
        )
    }

    @Test
    fun categoryFor_usesSavedCategoryBeforeInference() {
        val app = AppLibraryCategoryPolicy.App(
            id = "com.example.todo/com.example.todo.MainActivity/0",
            title = "Racing Notes",
            packageName = "com.example.todo"
        )

        assertEquals(
            AppLibraryCategory.PRODUCTIVITY,
            AppLibraryCategoryPolicy.categoryFor(
                app = app,
                savedCategories = mapOf(
                    "com.example.todo/com.example.todo.MainActivity" to "productivity"
                )
            )
        )
    }

    @Test
    fun buildGroups_returnsRecentThenSelectableCategoriesInDisplayOrder() {
        val apps = listOf(
            AppLibraryCategoryPolicy.App("com.video/.Main", "YouTube", "com.video"),
            AppLibraryCategoryPolicy.App("com.game/.Main", "Block Blast!", "com.game"),
            AppLibraryCategoryPolicy.App("com.social/.Main", "Zalo", "com.social"),
            AppLibraryCategoryPolicy.App("com.maps/.Main", "Maps", "com.maps"),
            AppLibraryCategoryPolicy.App("com.bank/.Main", "ACB ONE", "com.bank")
        )

        val groups = AppLibraryCategoryPolicy.buildGroups(
            apps = apps,
            savedCategories = mapOf(
                "com.video/.Main" to "video",
                "com.game/.Main" to "game",
                "com.social/.Main" to "social",
                "com.maps/.Main" to "map",
                "com.bank/.Main" to "productivity"
            )
        )

        assertEquals(
            listOf(
                AppLibraryCategory.RECENT,
                AppLibraryCategory.GAME,
                AppLibraryCategory.AUDIO,
                AppLibraryCategory.VIDEO,
                AppLibraryCategory.PHOTO,
                AppLibraryCategory.SOCIAL,
                AppLibraryCategory.NEWS,
                AppLibraryCategory.MAP,
                AppLibraryCategory.PRODUCTIVITY,
                AppLibraryCategory.OTHER
            ),
            groups.map { it.category }
        )
        assertEquals(apps.take(4), groups.first().apps)
        assertEquals(listOf("Block Blast!"), groups.first { it.category == AppLibraryCategory.GAME }.apps.map { it.title })
        assertEquals(listOf("ACB ONE"), groups.first { it.category == AppLibraryCategory.PRODUCTIVITY }.apps.map { it.title })
    }
}

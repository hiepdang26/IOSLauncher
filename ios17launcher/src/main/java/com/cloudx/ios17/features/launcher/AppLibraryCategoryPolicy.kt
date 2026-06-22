package com.cloudx.ios17.features.launcher

import java.util.Locale

enum class AppLibraryCategory(
    val code: String,
    val displayName: String
) {
    RECENT("recent", "Gần đây"),
    GAME("game", "Trò chơi"),
    AUDIO("audio", "Âm thanh"),
    VIDEO("video", "Video"),
    PHOTO("photo", "Hình ảnh"),
    SOCIAL("social", "Xã hội"),
    NEWS("news", "Tin tức"),
    MAP("map", "Bản đồ"),
    PRODUCTIVITY("productivity", "Năng suất"),
    OTHER("other", "Khác");

    companion object {
        val selectableEntries: List<AppLibraryCategory>
            get() = entries.filterNot { category -> category == RECENT }

        fun fromCode(code: String?): AppLibraryCategory {
            return selectableEntries.firstOrNull { category -> category.code == code } ?: OTHER
        }
    }
}

data class AppLibraryGroup<T>(
    val category: AppLibraryCategory,
    val apps: List<T>
)

object AppLibraryCategoryPolicy {
    data class App(
        val id: String,
        val title: String,
        val packageName: String?
    )

    fun iconKeyFromLauncherId(id: String): String {
        val parts = id.split('/')
        return if (parts.size >= 2) {
            "${parts[0]}/${parts[1]}"
        } else {
            id
        }
    }

    fun categoryFor(
        app: App,
        savedCategories: Map<String, String>
    ): AppLibraryCategory {
        val iconKey = iconKeyFromLauncherId(app.id)
        val savedCategoryCode = savedCategories[iconKey]
        return if (savedCategoryCode != null) {
            AppLibraryCategory.fromCode(savedCategoryCode)
        } else {
            inferFrom(app)
        }
    }

    fun <T> buildGroups(
        apps: List<T>,
        savedCategories: Map<String, String>,
        appInfo: (T) -> App
    ): List<AppLibraryGroup<T>> {
        val categorizedApps = apps.groupBy { app ->
            categoryFor(appInfo(app), savedCategories)
        }
        return listOf(
            AppLibraryGroup(
                category = AppLibraryCategory.RECENT,
                apps = apps.take(RECENT_LIBRARY_APP_COUNT)
            )
        ) + AppLibraryCategory.selectableEntries.map { category ->
            AppLibraryGroup(
                category = category,
                apps = categorizedApps[category].orEmpty()
            )
        }
    }

    fun buildGroups(
        apps: List<App>,
        savedCategories: Map<String, String>
    ): List<AppLibraryGroup<App>> {
        return buildGroups(
            apps = apps,
            savedCategories = savedCategories,
            appInfo = { app -> app }
        )
    }

    private fun inferFrom(app: App): AppLibraryCategory {
        val value = "${app.title} ${app.packageName.orEmpty()}".lowercase(Locale.ROOT)
        return when {
            value.containsAny("game", "driving", "monster", "blast", "anime", "moto") -> AppLibraryCategory.GAME
            value.containsAny("music", "audio", "spotify", "sound", "record", "ghi âm") -> AppLibraryCategory.AUDIO
            value.containsAny("video", "camera", "youtube", "tiktok", "film", "movie") -> AppLibraryCategory.VIDEO
            value.containsAny("photo", "image", "gallery", "photos", "hình", "ảnh") -> AppLibraryCategory.PHOTO
            value.containsAny("facebook", "messenger", "instagram", "zalo", "discord", "threads") -> AppLibraryCategory.SOCIAL
            value.containsAny("news", "tin tức", "bao moi") -> AppLibraryCategory.NEWS
            value.containsAny("map", "gps", "maps", "bản đồ") -> AppLibraryCategory.MAP
            value.containsAny("chatgpt", "chrome", "bank", "drive", "gmail", "calendar", "docs", "one") -> AppLibraryCategory.PRODUCTIVITY
            else -> AppLibraryCategory.OTHER
        }
    }

    private fun String.containsAny(vararg values: String): Boolean {
        return values.any { value -> contains(value) }
    }

    private const val RECENT_LIBRARY_APP_COUNT = 4
}

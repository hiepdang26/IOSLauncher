package com.vhmsoft.launcherios26.data.model

import java.util.Locale

enum class LauncherAppCategory(
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
        val selectableEntries: List<LauncherAppCategory>
            get() = entries.filterNot { category -> category == RECENT }

        fun fromCode(code: String?): LauncherAppCategory {
            return selectableEntries.firstOrNull { it.code == code } ?: OTHER
        }

        fun inferFrom(app: LauncherApp): LauncherAppCategory {
            val value = "${app.label} ${app.packageName}".lowercase(Locale.ROOT)
            return when {
                value.containsAny("game", "driving", "monster", "blast", "anime", "moto") -> GAME
                value.containsAny("music", "audio", "spotify", "sound", "record", "ghi âm") -> AUDIO
                value.containsAny("video", "camera", "youtube", "tiktok", "film", "movie") -> VIDEO
                value.containsAny("photo", "image", "gallery", "photos", "hình", "ảnh") -> PHOTO
                value.containsAny("facebook", "messenger", "instagram", "zalo", "discord", "threads") -> SOCIAL
                value.containsAny("news", "tin tức", "bao moi") -> NEWS
                value.containsAny("map", "gps", "maps", "bản đồ") -> MAP
                value.containsAny("chatgpt", "chrome", "bank", "drive", "gmail", "calendar", "docs", "one") -> PRODUCTIVITY
                else -> OTHER
            }
        }

        private fun String.containsAny(vararg values: String): Boolean {
            return values.any { contains(it) }
        }
    }
}

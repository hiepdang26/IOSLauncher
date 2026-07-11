package com.vhmsoft.launcherios26.data.icon

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.vhmsoft.launcherios26.R
import com.vhmsoft.launcherios26.data.model.LauncherApp
import java.text.Normalizer
import java.util.Locale

internal object SystemIosIconOverridePolicy {
    fun hasOverride(app: LauncherApp): Boolean {
        return resolveIconAssetName(app) != null
    }

    fun resolveDrawable(context: Context, app: LauncherApp): Drawable? {
        val iconRes = resolveIconRes(app) ?: return null
        return ContextCompat.getDrawable(context, iconRes)
    }

    fun resolveIconAssetName(app: LauncherApp): String? {
        if (app.canUninstall) {
            return null
        }

        val packageName = app.packageName.lowercase(Locale.ROOT)
        val className = app.className.lowercase(Locale.ROOT)
        val label = app.label.normalizedForMatch()
        val appKey = "$packageName/$className"

        return when {
            packageName == "com.android.vending" ||
                label.hasAny("cua hang play", "play store", "google play") -> "sys_ios17_appstore"

            packageName == "com.google.android.apps.maps" -> "sys_ios17_google_maps"
            packageName.hasAny("maps") || label.hasAny("maps", "ban do") -> "sys_ios17_maps"

            appKey.hasAny("weather") || label.hasAny("weather", "thoi tiet") -> "sys_ios17_weather"
            appKey.hasAny("camera") || label.hasAny("camera", "may anh") -> "sys_ios17_camera"
            appKey.hasAny("settings") || label.hasAny("settings", "cai dat") -> "sys_ios17_settings"
            appKey.hasAny("calendar") || label.hasAny("calendar", "lich") -> "sys_ios17_calendar"
            appKey.hasAny("clock") || label.hasAny("clock", "dong ho") -> "sys_ios17_clock"

            appKey.hasAny("contacts", "dialer", "phone") ||
                label.hasAny("contacts", "lien he", "danh ba", "phone", "dien thoai") -> "sys_ios17_contacts"

            appKey.hasAny("mms", "messaging", "messages") ||
                label.hasAny("messages", "message", "tin nhan") -> "sys_ios17_messages"

            appKey.hasAny("photos", "gallery", "album") ||
                label.hasAny("photos", "photo", "gallery", "album", "anh", "thu vien") -> "sys_ios17_photos"

            appKey.hasAny("files", "filemanager", "file.manager", "documentsui") ||
                label.hasAny("files", "file", "tap tin", "tep", "quan ly tep") -> "sys_ios17_files"

            appKey.hasAny("mail", "email") ||
                label.hasAny("email", "thu dien tu") -> "sys_ios17_mail"

            appKey.hasAny("calculator") || label.hasAny("calculator", "may tinh") -> "sys_ios17_calculator"
            appKey.hasAny("compass") || label.hasAny("compass", "la ban") -> "sys_ios17_compass"
            packageName.endsWith(".music") ||
                packageName.contains(".music.") ||
                appKey.hasAny("musicplayer") ||
                label.hasAny("music", "nhac") -> "sys_ios17_music"
            appKey.hasAny("notes") || label.hasAny("notes", "ghi chu") -> "sys_ios17_notes"
            appKey.hasAny("browser", "safari") || label.hasAny("browser", "safari", "trinh duyet") -> "sys_ios17_safari"
            else -> null
        }
    }

    private fun resolveIconRes(app: LauncherApp): Int? {
        return when (resolveIconAssetName(app)) {
            "sys_ios17_appstore" -> R.drawable.sys_ios17_appstore
            "sys_ios17_weather" -> R.drawable.sys_ios17_weather
            "sys_ios17_maps" -> R.drawable.sys_ios17_maps
            "sys_ios17_google_maps" -> R.drawable.sys_ios17_google_maps
            "sys_ios17_settings" -> R.drawable.sys_ios17_settings
            "sys_ios17_photos" -> R.drawable.sys_ios17_photos
            "sys_ios17_calendar" -> R.drawable.sys_ios17_calendar
            "sys_ios17_messages" -> R.drawable.sys_ios17_messages
            "sys_ios17_camera" -> R.drawable.sys_ios17_camera
            "sys_ios17_files" -> R.drawable.sys_ios17_files
            "sys_ios17_clock" -> R.drawable.sys_ios17_clock
            "sys_ios17_contacts" -> R.drawable.sys_ios17_contacts
            "sys_ios17_mail" -> R.drawable.sys_ios17_mail
            "sys_ios17_calculator" -> R.drawable.sys_ios17_calculator
            "sys_ios17_compass" -> R.drawable.sys_ios17_compass
            "sys_ios17_music" -> R.drawable.sys_ios17_music
            "sys_ios17_notes" -> R.drawable.sys_ios17_notes
            "sys_ios17_safari" -> R.drawable.sys_ios17_safari
            else -> null
        }
    }

    private fun String.normalizedForMatch(): String {
        val lower = lowercase(Locale.ROOT)
        val withoutMarks = Normalizer.normalize(lower, Normalizer.Form.NFD)
            .replace("\\p{Mn}+".toRegex(), "")
            .replace('đ', 'd')
        return "$lower $withoutMarks"
    }

    private fun String.hasAny(vararg needles: String): Boolean {
        return needles.any { needle -> contains(needle) }
    }
}

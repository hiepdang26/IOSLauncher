package com.cloudx.ios17.core

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.cloudx.ios17.R
import java.text.Normalizer
import java.util.Locale

object SystemIosIconOverridePolicy {
    fun resolveDrawable(
        context: Context,
        label: CharSequence?,
        packageName: String?,
        className: String?,
        isSystemApp: Boolean
    ): Drawable? {
        val iconRes = resolveIconRes(
            label = label?.toString().orEmpty(),
            packageName = packageName.orEmpty(),
            className = className.orEmpty(),
            isSystemApp = isSystemApp
        ) ?: return null
        return ContextCompat.getDrawable(context, iconRes)
    }

    fun resolveIconAssetName(
        label: String,
        packageName: String,
        className: String,
        isSystemApp: Boolean
    ): String? {
        if (!isSystemApp) {
            return null
        }

        val normalizedPackage = packageName.lowercase(Locale.ROOT)
        val normalizedClass = className.lowercase(Locale.ROOT)
        val normalizedLabel = label.normalizedForMatch()
        val appKey = "$normalizedPackage/$normalizedClass"

        return when {
            normalizedPackage == "com.android.vending" ||
                normalizedLabel.hasAny("cua hang play", "play store", "google play") -> "legacy_sys_ios17_appstore"

            normalizedPackage == "com.google.android.apps.maps" -> "legacy_sys_ios17_google_maps"
            normalizedPackage.hasAny("maps") || normalizedLabel.hasAny("maps", "ban do") -> "legacy_sys_ios17_maps"

            appKey.hasAny("weather") || normalizedLabel.hasAny("weather", "thoi tiet") -> "legacy_sys_ios17_weather"
            appKey.hasAny("camera") || normalizedLabel.hasAny("camera", "may anh") -> "legacy_sys_ios17_camera"
            appKey.hasAny("settings") || normalizedLabel.hasAny("settings", "cai dat") -> "legacy_sys_ios17_settings"
            appKey.hasAny("calendar") || normalizedLabel.hasAny("calendar", "lich") -> "legacy_sys_ios17_calendar"
            appKey.hasAny("clock") || normalizedLabel.hasAny("clock", "dong ho") -> "legacy_sys_ios17_clock"

            appKey.hasAny("contacts", "dialer", "phone") ||
                normalizedLabel.hasAny("contacts", "lien he", "danh ba", "phone", "dien thoai") ->
                "legacy_sys_ios17_contacts"

            appKey.hasAny("mms", "messaging", "messages") ||
                normalizedLabel.hasAny("messages", "message", "tin nhan") -> "legacy_sys_ios17_messages"

            appKey.hasAny("photos", "gallery", "album") ||
                normalizedLabel.hasAny("photos", "photo", "gallery", "album", "anh", "thu vien") ->
                "legacy_sys_ios17_photos"

            appKey.hasAny("files", "filemanager", "file.manager", "documentsui") ||
                normalizedLabel.hasAny("files", "file", "tap tin", "tep", "quan ly tep") ->
                "legacy_sys_ios17_files"

            appKey.hasAny("mail", "email") ||
                normalizedLabel.hasAny("email", "thu dien tu") -> "legacy_sys_ios17_mail"

            appKey.hasAny("calculator") || normalizedLabel.hasAny("calculator", "may tinh") ->
                "legacy_sys_ios17_calculator"

            appKey.hasAny("compass") || normalizedLabel.hasAny("compass", "la ban") -> "legacy_sys_ios17_compass"
            normalizedPackage.endsWith(".music") ||
                normalizedPackage.contains(".music.") ||
                appKey.hasAny("musicplayer") ||
                normalizedLabel.hasAny("music", "nhac") -> "legacy_sys_ios17_music"

            appKey.hasAny("notes") || normalizedLabel.hasAny("notes", "ghi chu") -> "legacy_sys_ios17_notes"
            appKey.hasAny("browser", "safari") || normalizedLabel.hasAny("browser", "safari", "trinh duyet") ->
                "legacy_sys_ios17_safari"

            else -> null
        }
    }

    private fun resolveIconRes(
        label: String,
        packageName: String,
        className: String,
        isSystemApp: Boolean
    ): Int? {
        return when (resolveIconAssetName(label, packageName, className, isSystemApp)) {
            "legacy_sys_ios17_appstore" -> R.drawable.legacy_sys_ios17_appstore
            "legacy_sys_ios17_weather" -> R.drawable.legacy_sys_ios17_weather
            "legacy_sys_ios17_maps" -> R.drawable.legacy_sys_ios17_maps
            "legacy_sys_ios17_google_maps" -> R.drawable.legacy_sys_ios17_google_maps
            "legacy_sys_ios17_settings" -> R.drawable.legacy_sys_ios17_settings
            "legacy_sys_ios17_photos" -> R.drawable.legacy_sys_ios17_photos
            "legacy_sys_ios17_calendar" -> R.drawable.legacy_sys_ios17_calendar
            "legacy_sys_ios17_messages" -> R.drawable.legacy_sys_ios17_messages
            "legacy_sys_ios17_camera" -> R.drawable.legacy_sys_ios17_camera
            "legacy_sys_ios17_files" -> R.drawable.legacy_sys_ios17_files
            "legacy_sys_ios17_clock" -> R.drawable.legacy_sys_ios17_clock
            "legacy_sys_ios17_contacts" -> R.drawable.legacy_sys_ios17_contacts
            "legacy_sys_ios17_mail" -> R.drawable.legacy_sys_ios17_mail
            "legacy_sys_ios17_calculator" -> R.drawable.legacy_sys_ios17_calculator
            "legacy_sys_ios17_compass" -> R.drawable.legacy_sys_ios17_compass
            "legacy_sys_ios17_music" -> R.drawable.legacy_sys_ios17_music
            "legacy_sys_ios17_notes" -> R.drawable.legacy_sys_ios17_notes
            "legacy_sys_ios17_safari" -> R.drawable.legacy_sys_ios17_safari
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

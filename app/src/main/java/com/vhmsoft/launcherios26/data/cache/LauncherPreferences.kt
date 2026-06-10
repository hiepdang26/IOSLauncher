package com.vhmsoft.launcherios26.data.cache

import android.content.Context
import com.vhmsoft.launcherios26.data.model.LauncherFolder

class LauncherPreferences(context: Context) {
    private val preferences = context.applicationContext.getSharedPreferences(
        PREF_NAME,
        Context.MODE_PRIVATE
    )

    fun getAppOrder(): List<String> {
        return preferences.getString(KEY_APP_ORDER, null)
            ?.split(ORDER_SEPARATOR)
            ?.filter { it.isNotBlank() }
            .orEmpty()
    }

    fun saveAppOrder(iconKeys: List<String>) {
        preferences.edit()
            .putString(KEY_APP_ORDER, iconKeys.joinToString(ORDER_SEPARATOR))
            .apply()
    }

    fun getLauncherFolders(): List<LauncherFolder> {
        return preferences.getString(KEY_LAUNCHER_FOLDERS, null)
            ?.lines()
            ?.mapNotNull { line -> decodeFolder(line) }
            .orEmpty()
    }

    fun saveLauncherFolders(folders: List<LauncherFolder>) {
        preferences.edit()
            .putString(KEY_LAUNCHER_FOLDERS, folders.joinToString(FOLDER_SEPARATOR) { encodeFolder(it) })
            .apply()
    }

    fun getAppCategory(iconKey: String): String? {
        return preferences.getString(categoryKey(iconKey), null)
    }

    fun getAppCategories(): Map<String, String> {
        return preferences.all
            .filterKeys { key -> key.startsWith(KEY_APP_CATEGORY_PREFIX) }
            .mapNotNull { (key, value) ->
                val category = value as? String ?: return@mapNotNull null
                key.removePrefix(KEY_APP_CATEGORY_PREFIX) to category
            }
            .toMap()
    }

    fun saveAppCategory(iconKey: String, categoryCode: String) {
        preferences.edit()
            .putString(categoryKey(iconKey), categoryCode)
            .apply()
    }

    private fun categoryKey(iconKey: String): String {
        return KEY_APP_CATEGORY_PREFIX + iconKey
    }

    private fun encodeFolder(folder: LauncherFolder): String {
        return listOf(
            folder.id,
            folder.title,
            folder.appIconKeys.joinToString(FOLDER_APP_SEPARATOR)
        ).joinToString(FOLDER_FIELD_SEPARATOR)
    }

    private fun decodeFolder(raw: String): LauncherFolder? {
        if (raw.isBlank()) return null

        val fields = raw.split(FOLDER_FIELD_SEPARATOR, limit = FOLDER_FIELD_COUNT)
        if (fields.size != FOLDER_FIELD_COUNT) return null

        val appKeys = fields[2]
            .split(FOLDER_APP_SEPARATOR)
            .filter { iconKey -> iconKey.isNotBlank() }
        if (fields[0].isBlank() || appKeys.isEmpty()) return null

        return LauncherFolder(
            id = fields[0],
            title = fields[1],
            appIconKeys = appKeys
        )
    }

    private companion object {
        const val PREF_NAME = "ios_launcher_preferences"
        const val KEY_APP_ORDER = "app_order"
        const val KEY_LAUNCHER_FOLDERS = "launcher_folders"
        const val KEY_APP_CATEGORY_PREFIX = "app_category_"
        const val ORDER_SEPARATOR = "|"
        const val FOLDER_SEPARATOR = "\n"
        const val FOLDER_FIELD_SEPARATOR = "|"
        const val FOLDER_APP_SEPARATOR = ","
        const val FOLDER_FIELD_COUNT = 3
    }
}

package com.bg.global.ioslauncher.data.cache

import android.content.Context

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

    private companion object {
        const val PREF_NAME = "ios_launcher_preferences"
        const val KEY_APP_ORDER = "app_order"
        const val KEY_APP_CATEGORY_PREFIX = "app_category_"
        const val ORDER_SEPARATOR = "|"
    }
}

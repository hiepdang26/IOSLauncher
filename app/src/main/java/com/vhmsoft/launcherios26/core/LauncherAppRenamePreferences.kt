package com.vhmsoft.launcherios26.core

import android.content.Context

object LauncherAppRenamePreferences {
    private const val PREF_NAME = "ios_launcher_app_renames"

    fun renamedTitle(context: Context, appId: String, defaultTitle: String): String {
        return renamedTitle(
            context = context,
            appKeys = LauncherAppRenamePolicy.appKeys(appId = appId),
            defaultTitle = defaultTitle
        )
    }

    fun renamedTitle(context: Context, appKeys: List<String>, defaultTitle: String): String {
        return LauncherAppRenamePolicy.displayTitle(
            appKeys = appKeys,
            defaultTitle = defaultTitle,
            renamedTitles = readAll(context)
        )
    }

    fun save(context: Context, appId: String, title: String) {
        save(context, LauncherAppRenamePolicy.appKeys(appId = appId), title)
    }

    fun save(context: Context, appKeys: List<String>, title: String) {
        val editor = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit()
        appKeys.forEach { key ->
            editor.putString(key, title.trim())
        }
        editor.apply()
    }

    fun readAll(context: Context): Map<String, String?> {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            .all
            .mapValues { (_, value) -> value as? String }
    }
}

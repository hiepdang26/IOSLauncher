package com.cloudx.ios17.core

import java.nio.charset.StandardCharsets
import java.util.Base64

object LauncherCustomIconPolicy {
    const val PREF_NAME = "ios_launcher_preferences"
    const val KEY_CUSTOM_ICON_PREFIX = "custom_icon_"
    const val KEY_CUSTOM_ICON_VERSION = "custom_icon_version"

    fun iconKeys(
        appId: String,
        componentName: String? = null,
        packageName: String? = null
    ): List<String> {
        return LauncherAppRenamePolicy.appKeys(
            appId = appId,
            componentName = componentName,
            packageName = packageName
        )
    }

    fun preferenceKey(iconKey: String): String {
        return KEY_CUSTOM_ICON_PREFIX + iconKey
    }

    fun fileNameForKey(iconKey: String): String {
        return Base64.getUrlEncoder()
            .withoutPadding()
            .encodeToString(iconKey.toByteArray(StandardCharsets.UTF_8)) + ".png"
    }
}

package com.cloudx.ios17.core

import org.junit.Assert.assertEquals
import org.junit.Test

class LauncherCustomIconPolicyTest {

    @Test
    fun iconKeys_matchComponentAndPackageAliases() {
        val keys = LauncherCustomIconPolicy.iconKeys(
            appId = "com.example.camera/com.example.camera.MainActivity",
            componentName = "com.example.camera/com.example.camera.MainActivity",
            packageName = "com.example.camera"
        )

        assertEquals(
            listOf(
                "com.example.camera/com.example.camera.MainActivity",
                "com.example.camera"
            ),
            keys
        )
    }

    @Test
    fun preferenceKey_usesSharedLauncherPreferencesPrefix() {
        assertEquals(
            "custom_icon_com.example.camera/com.example.camera.MainActivity",
            LauncherCustomIconPolicy.preferenceKey("com.example.camera/com.example.camera.MainActivity")
        )
    }

    @Test
    fun fileName_isStableAndFileSafe() {
        assertEquals(
            LauncherCustomIconPolicy.fileNameForKey("com.example/.Main"),
            LauncherCustomIconPolicy.fileNameForKey("com.example/.Main")
        )
        assertEquals(
            false,
            LauncherCustomIconPolicy.fileNameForKey("com.example/.Main").contains("/")
        )
    }
}

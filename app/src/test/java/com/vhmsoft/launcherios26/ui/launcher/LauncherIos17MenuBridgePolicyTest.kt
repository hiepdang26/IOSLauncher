package com.vhmsoft.launcherios26.ui.launcher

import com.vhmsoft.launcherios26.data.model.LauncherApp
import org.junit.Assert.assertEquals
import org.junit.Test

class LauncherIos17MenuBridgePolicyTest {
    @Test
    fun renameKeys_matchIos17LauncherComponentAndPackageKeys() {
        val app = LauncherApp(
            label = "Camera",
            packageName = "com.example.camera",
            className = "com.example.camera.MainActivity",
            iconKey = "com.example.camera/com.example.camera.MainActivity"
        )

        val keys = LauncherIos17MenuBridgePolicy.renameKeys(app)

        assertEquals(
            listOf(
                "com.example.camera/com.example.camera.MainActivity",
                "com.example.camera"
            ),
            keys
        )
    }

    @Test
    fun iconKeys_matchIos17LauncherComponentAndPackageKeys() {
        val app = LauncherApp(
            label = "Camera",
            packageName = "com.example.camera",
            className = "com.example.camera.MainActivity",
            iconKey = "com.example.camera/com.example.camera.MainActivity"
        )

        val keys = LauncherIos17MenuBridgePolicy.iconKeys(app)

        assertEquals(
            listOf(
                "com.example.camera/com.example.camera.MainActivity",
                "com.example.camera"
            ),
            keys
        )
    }
}

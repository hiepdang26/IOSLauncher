package com.vhmsoft.launcherios26.data.icon

import com.vhmsoft.launcherios26.data.model.LauncherApp
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class SystemIosIconOverridePolicyTest {
    @Test
    fun resolveIconAssetName_mapsVietnameseSystemLabelsToIosIcons() {
        assertEquals("sys_ios17_weather", launcherApp("Thời tiết").iconAssetName())
        assertEquals("sys_ios17_settings", launcherApp("Cài đặt").iconAssetName())
        assertEquals("sys_ios17_calendar", launcherApp("Lịch").iconAssetName())
        assertEquals("sys_ios17_contacts", launcherApp("Liên hệ").iconAssetName())
        assertEquals("sys_ios17_contacts", launcherApp("Điện thoại").iconAssetName())
        assertEquals("sys_ios17_files", launcherApp("Tập tin").iconAssetName())
    }

    @Test
    fun resolveIconAssetName_mapsKnownSystemPackagesToIosIcons() {
        assertEquals(
            "sys_ios17_appstore",
            launcherApp("Cửa hàng Play", packageName = "com.android.vending").iconAssetName()
        )
        assertEquals(
            "sys_ios17_google_maps",
            launcherApp("Maps", packageName = "com.google.android.apps.maps").iconAssetName()
        )
        assertEquals(
            "sys_ios17_messages",
            launcherApp("Messages", packageName = "com.google.android.apps.messaging").iconAssetName()
        )
    }

    @Test
    fun resolveIconAssetName_keepsThirdPartyAppsUntouched() {
        assertNull(launcherApp("Zalo", packageName = "com.zing.zalo").iconAssetName())
        assertNull(launcherApp("TikTok", packageName = "com.zhiliaoapp.musically").iconAssetName())
        assertNull(launcherApp("Thời tiết", canUninstall = true).iconAssetName())
        assertNull(launcherApp("Camera", packageName = "com.example.camera", canUninstall = true).iconAssetName())
        assertNull(
            launcherApp(
                "Maps",
                packageName = "com.google.android.apps.maps",
                canUninstall = true
            ).iconAssetName()
        )
    }

    private fun LauncherApp.iconAssetName(): String? {
        return SystemIosIconOverridePolicy.resolveIconAssetName(this)
    }

    private fun launcherApp(
        label: String,
        packageName: String = "com.example.${label.lowercase()}",
        className: String = "MainActivity",
        canUninstall: Boolean = false
    ): LauncherApp {
        return LauncherApp(
            label = label,
            packageName = packageName,
            className = className,
            iconKey = "$packageName/$className",
            canUninstall = canUninstall
        )
    }
}

package com.cloudx.ios17.core

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class SystemIosIconOverridePolicyTest {
    @Test
    fun resolveIconAssetName_mapsVietnameseSystemLabelsToIosIcons() {
        assertEquals("legacy_sys_ios17_weather", iconAssetName("Thời tiết"))
        assertEquals("legacy_sys_ios17_settings", iconAssetName("Cài đặt"))
        assertEquals("legacy_sys_ios17_calendar", iconAssetName("Lịch"))
        assertEquals("legacy_sys_ios17_contacts", iconAssetName("Liên hệ"))
        assertEquals("legacy_sys_ios17_contacts", iconAssetName("Điện thoại"))
        assertEquals("legacy_sys_ios17_files", iconAssetName("Tập tin"))
    }

    @Test
    fun resolveIconAssetName_mapsKnownSystemPackagesToIosIcons() {
        assertEquals(
            "legacy_sys_ios17_appstore",
            iconAssetName("Cửa hàng Play", packageName = "com.android.vending")
        )
        assertEquals(
            "legacy_sys_ios17_google_maps",
            iconAssetName("Maps", packageName = "com.google.android.apps.maps")
        )
        assertEquals(
            "legacy_sys_ios17_messages",
            iconAssetName("Messages", packageName = "com.google.android.apps.messaging")
        )
    }

    @Test
    fun resolveIconAssetName_keepsThirdPartyAppsUntouched() {
        assertNull(iconAssetName("Zalo", packageName = "com.zing.zalo", isSystemApp = false))
        assertNull(iconAssetName("TikTok", packageName = "com.zhiliaoapp.musically", isSystemApp = false))
        assertNull(iconAssetName("Thời tiết", isSystemApp = false))
        assertNull(iconAssetName("Camera", packageName = "com.example.camera", isSystemApp = false))
        assertNull(
            iconAssetName(
                "Maps",
                packageName = "com.google.android.apps.maps",
                isSystemApp = false
            )
        )
    }

    private fun iconAssetName(
        label: String,
        packageName: String = "com.example.${label.lowercase()}",
        className: String = "MainActivity",
        isSystemApp: Boolean = true
    ): String? {
        return SystemIosIconOverridePolicy.resolveIconAssetName(
            label = label,
            packageName = packageName,
            className = className,
            isSystemApp = isSystemApp
        )
    }
}

package com.vhmsoft.launcherios26.data.model

import org.junit.Assert.assertEquals
import org.junit.Test

class LauncherAppCustomizationPolicyTest {
    @Test
    fun apply_hidesAppsAndUsesCustomLabels() {
        val visible = launcherApp("Visible")
        val renamed = launcherApp("Original")
        val hidden = launcherApp("Hidden")

        val result = LauncherAppCustomizationPolicy.apply(
            apps = listOf(visible, renamed, hidden),
            hiddenIconKeys = setOf(hidden.iconKey),
            customLabels = mapOf(renamed.iconKey to "Tên mới")
        )

        assertEquals(listOf("Visible", "Tên mới"), result.map { app -> app.label })
        assertEquals(listOf(visible.iconKey, renamed.iconKey), result.map { app -> app.iconKey })
    }

    @Test
    fun apply_ignoresBlankCustomLabels() {
        val app = launcherApp("Original")

        val result = LauncherAppCustomizationPolicy.apply(
            apps = listOf(app),
            hiddenIconKeys = emptySet(),
            customLabels = mapOf(app.iconKey to "   ")
        )

        assertEquals(listOf("Original"), result.map { item -> item.label })
    }

    private fun launcherApp(label: String): LauncherApp {
        return LauncherApp(
            label = label,
            packageName = "com.example.${label.lowercase()}",
            className = "MainActivity",
            iconKey = "com.example.${label.lowercase()}/MainActivity"
        )
    }
}

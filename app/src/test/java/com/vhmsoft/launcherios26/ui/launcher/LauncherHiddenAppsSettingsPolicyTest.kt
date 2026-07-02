package com.vhmsoft.launcherios26.ui.launcher

import com.vhmsoft.launcherios26.data.model.LauncherApp
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertSame
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherHiddenAppsSettingsPolicyTest {
    @Test
    fun hiddenAppsMenu_opensFullscreenPageInsteadOfDialogList() {
        assertTrue(LauncherHiddenAppsSettingsPolicy.opensFullscreenPage)
        assertFalse(LauncherHiddenAppsSettingsPolicy.usesDialogList)
    }

    @Test
    fun sections_splitHiddenAndVisibleAppsAlphabetically() {
        val chrome = app("Chrome", "chrome")
        val maps = app("Maps", "maps")
        val agoda = app("Agoda", "agoda")

        val sections = LauncherHiddenAppsSettingsPolicy.sections(
            apps = listOf(chrome, maps, agoda),
            hiddenIconKeys = setOf("maps")
        )

        assertEquals(listOf("Maps"), sections.hidden.map { app -> app.label })
        assertEquals(listOf("Agoda", "Chrome"), sections.visible.map { app -> app.label })
        assertSame(maps, sections.hidden.single())
    }

    private fun app(label: String, iconKey: String): LauncherApp {
        return LauncherApp(
            label = label,
            packageName = iconKey,
            className = "$iconKey.Main",
            iconKey = iconKey
        )
    }
}

package com.vhmsoft.launcherios26.ui.launcher

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

class IOSLauncherActivityMenuOnlyLayoutTest {
    @Test
    fun iosLauncherActivityLayout_keepsSettingsPanelsButDoesNotEmbedWorkspace() {
        val xml = activityLayoutFile().readText()

        assertTrue(xml.contains("@+id/settingsPanel"))
        assertTrue(xml.contains("@+id/layoutSettingsPanel"))
        assertTrue(xml.contains("@+id/liquidGlassSettingsPanel"))
        assertTrue(xml.contains("@+id/blurSettingsPanel"))
        assertTrue(xml.contains("@+id/animationSettingsPanel"))
        assertTrue(xml.contains("@+id/settingsDrawerOverlay"))

        assertFalse(xml.contains("@layout/view_ios_workspace"))
        assertFalse(xml.contains("@+id/workspace"))
    }

    private fun activityLayoutFile(): File {
        return listOf(
            File("app/src/main/res/layout/activity_ios_launcher.xml"),
            File("src/main/res/layout/activity_ios_launcher.xml")
        ).first { it.exists() }
    }
}

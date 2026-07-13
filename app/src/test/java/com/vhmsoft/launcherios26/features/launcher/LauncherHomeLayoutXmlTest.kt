package com.vhmsoft.launcherios26.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory

class LauncherHomeLayoutXmlTest {
    @Test
    fun homeRoot_keepsLauncherRootViewWithoutConsumingSystemInsets() {
        val root = DocumentBuilderFactory.newInstance()
            .newDocumentBuilder()
            .parse(activityMainLayout())
            .documentElement

        assertEquals("com.luutinhit.launcher6.LauncherRootView", root.tagName)
        assertEquals("@+id/launcher", root.getAttribute("android:id"))
        assertNotEquals("true", root.getAttribute("android:fitsSystemWindows"))
    }

    private fun activityMainLayout(): File {
        return listOf(
            File("app/src/main/res/layout/activity_main.xml"),
            File("src/main/res/layout/activity_main.xml")
        ).first { it.exists() }
    }
}

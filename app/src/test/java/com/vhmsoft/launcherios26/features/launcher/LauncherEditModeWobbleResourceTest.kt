package com.vhmsoft.launcherios26.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory

class LauncherEditModeWobbleResourceTest {

    @Test
    fun appIconWobbleAnimationsStayGentleInEditMode() {
        assertGentleWobble(
            fileName = "wobble.xml",
            expectedDuration = "160",
            expectedFromDegrees = -1.25f,
            expectedToDegrees = 1.25f
        )
        assertGentleWobble(
            fileName = "wobble_reverse.xml",
            expectedDuration = "160",
            expectedFromDegrees = 1.25f,
            expectedToDegrees = -1.25f
        )
    }

    @Test
    fun widgetWobbleAnimationsAreNoticeableButSlowerThanIcons() {
        assertGentleWobble(
            fileName = "today_widget_wobble.xml",
            expectedDuration = "130",
            expectedFromDegrees = -1.45f,
            expectedToDegrees = 1.45f
        )
        assertGentleWobble(
            fileName = "today_widget_wobble_reverse.xml",
            expectedDuration = "130",
            expectedFromDegrees = 1.45f,
            expectedToDegrees = -1.45f
        )
    }

    @Test
    fun appIconWobbleIsReducedWhileDraggingHomeWidget() {
        assertGentleWobble(
            fileName = "wobble_widget_drag.xml",
            expectedDuration = "190",
            expectedFromDegrees = -0.45f,
            expectedToDegrees = 0.45f
        )
        assertGentleWobble(
            fileName = "wobble_widget_drag_reverse.xml",
            expectedDuration = "190",
            expectedFromDegrees = 0.45f,
            expectedToDegrees = -0.45f
        )
    }

    private fun assertGentleWobble(
        fileName: String,
        expectedDuration: String,
        expectedFromDegrees: Float,
        expectedToDegrees: Float
    ) {
        val root = DocumentBuilderFactory.newInstance()
            .newDocumentBuilder()
            .parse(animFile(fileName))
            .documentElement

        assertEquals(expectedDuration, root.getAttribute("android:duration"))
        assertEquals(expectedFromDegrees, root.getAttribute("android:fromDegrees").toFloat(), 0.001f)
        assertEquals(expectedToDegrees, root.getAttribute("android:toDegrees").toFloat(), 0.001f)
    }

    private fun animFile(fileName: String): File {
        return listOf(
            File("app/src/main/res/anim/$fileName"),
            File("src/main/res/anim/$fileName")
        ).first { it.exists() }
    }
}

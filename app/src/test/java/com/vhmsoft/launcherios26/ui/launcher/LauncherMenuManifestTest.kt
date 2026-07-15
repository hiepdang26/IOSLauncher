package com.vhmsoft.launcherios26.ui.launcher

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test
import org.w3c.dom.Element
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory

class LauncherMenuManifestTest {
    @Test
    fun manifest_usesDistinctMenuAndHomeLauncherEntries() {
        val activities = manifestActivities()

        assertEquals(
            listOf(".ui.launcher.LauncherMenuActivity"),
            activities.filter { it.hasAction(ACTION_MAIN) && it.hasCategory(CATEGORY_LAUNCHER) }
                .map { it.androidName() }
        )
        assertEquals(
            listOf(".features.launcher.IOSLauncherActivity"),
            activities.filter { it.hasAction(ACTION_MAIN) && it.hasCategory(CATEGORY_HOME) }
                .map { it.androidName() }
        )
        assertFalse(
            activities
                .filter { it.hasAction(ACTION_MAIN) && it.hasCategory(CATEGORY_LAUNCHER) }
                .any { it.androidName() == ".ui.launcher.IOSLauncherActivity" }
        )
    }

    @Test
    fun menuLauncherEntry_usesRegularTaskLaunchBehavior() {
        val menuActivity = manifestActivities()
            .single { it.androidName() == ".ui.launcher.LauncherMenuActivity" }

        assertFalse(menuActivity.hasAndroidAttribute("launchMode", "singleTask"))
        assertFalse(menuActivity.hasAndroidAttribute("clearTaskOnLaunch", "true"))
    }

    private fun manifestActivities(): List<Element> {
        val document = DocumentBuilderFactory.newInstance().apply {
            isNamespaceAware = true
        }
            .newDocumentBuilder()
            .parse(manifestFile())
        val nodes = document.getElementsByTagName("activity")
        return buildList {
            for (index in 0 until nodes.length) {
                add(nodes.item(index) as Element)
            }
        }
    }

    private fun Element.androidName(): String {
        return getAttributeNS(ANDROID_NS, "name")
    }

    private fun Element.hasAndroidAttribute(attributeName: String, expectedValue: String): Boolean {
        return getAttributeNS(ANDROID_NS, attributeName) == expectedValue
    }

    private fun Element.hasAction(actionName: String): Boolean {
        return descendantHasAndroidName("action", actionName)
    }

    private fun Element.hasCategory(categoryName: String): Boolean {
        return descendantHasAndroidName("category", categoryName)
    }

    private fun Element.descendantHasAndroidName(tagName: String, expectedName: String): Boolean {
        val nodes = getElementsByTagName(tagName)
        for (index in 0 until nodes.length) {
            val element = nodes.item(index) as Element
            if (element.getAttributeNS(ANDROID_NS, "name") == expectedName) {
                return true
            }
        }
        return false
    }

    private fun manifestFile(): File {
        return listOf(
            File("app/src/main/AndroidManifest.xml"),
            File("src/main/AndroidManifest.xml")
        ).first { it.exists() }
    }

    private companion object {
        const val ANDROID_NS = "http://schemas.android.com/apk/res/android"
        const val ACTION_MAIN = "android.intent.action.MAIN"
        const val CATEGORY_HOME = "android.intent.category.HOME"
        const val CATEGORY_LAUNCHER = "android.intent.category.LAUNCHER"
    }
}

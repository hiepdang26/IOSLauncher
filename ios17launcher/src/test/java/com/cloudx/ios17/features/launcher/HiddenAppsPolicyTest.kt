package com.cloudx.ios17.features.launcher

import com.cloudx.ios17.core.database.model.ApplicationItem
import com.cloudx.ios17.core.database.model.FolderItem
import com.cloudx.ios17.core.database.model.LauncherItem
import com.cloudx.ios17.core.utils.Constants
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertSame
import org.junit.Test

class HiddenAppsPolicyTest {
    @Test
    fun hiddenKeyFor_usesLauncherIdWhenComponentNameIsUnavailable() {
        val app = app("com.example.hidden/com.example.hidden.MainActivity/10", "Hidden")

        val hiddenKey = HiddenAppsPolicy.hiddenKeyFor(app)

        assertEquals("com.example.hidden/com.example.hidden.MainActivity/10", hiddenKey)
    }

    @Test
    fun visibleLauncherItems_removesHiddenDesktopAndDockApps() {
        val visible = app("visible", "Visible")
        val hiddenDesktop = app("hidden-desktop", "Hidden Desktop")
        val hiddenDock = app("hidden-dock", "Hidden Dock").apply {
            container = Constants.CONTAINER_HOTSEAT.toLong()
        }

        val result = HiddenAppsPolicy.visibleLauncherItems(
            launcherItems = listOf(visible, hiddenDesktop, hiddenDock),
            hiddenAppIds = setOf("hidden-desktop", "hidden-dock")
        )

        assertEquals(listOf("Visible"), result.map { it.title.toString() })
    }

    @Test
    fun visibleLauncherItems_removesAppWhenHiddenKeyMatchesBaseLauncherIdWithoutUserSuffix() {
        val hidden = app("com.example.hidden/com.example.hidden.MainActivity/10", "Hidden")

        val result = HiddenAppsPolicy.visibleLauncherItems(
            launcherItems = listOf(hidden),
            hiddenAppIds = setOf("com.example.hidden/com.example.hidden.MainActivity")
        )

        assertEquals(emptyList<LauncherItem>(), result)
    }

    @Test
    fun visibleLauncherItems_removesAppWhenHiddenKeyMatchesPackageName() {
        val hidden = app("database-id", "Hidden").apply {
            packageName = "com.example.hidden"
        }

        val result = HiddenAppsPolicy.visibleLauncherItems(
            launcherItems = listOf(hidden),
            hiddenAppIds = setOf("com.example.hidden")
        )

        assertEquals(emptyList<LauncherItem>(), result)
    }

    @Test
    fun visibleLauncherItems_filtersHiddenFolderChildrenWithoutMutatingOriginalFolder() {
        val visibleChild = app("visible-child", "Visible Child")
        val hiddenChild = app("hidden-child", "Hidden Child")
        val folder = FolderItem().apply {
            id = "folder"
            title = "Folder"
            container = Constants.CONTAINER_DESKTOP.toLong()
            items = mutableListOf(visibleChild, hiddenChild)
        }

        val result = HiddenAppsPolicy.visibleLauncherItems(
            launcherItems = listOf(folder),
            hiddenAppIds = setOf("hidden-child")
        )
        val filteredFolder = result.single() as FolderItem

        assertEquals(listOf("Visible Child"), filteredFolder.items.orEmpty().map { it.title.toString() })
        assertEquals(listOf("Visible Child", "Hidden Child"), folder.items.orEmpty().map { it.title.toString() })
        assertFalse(filteredFolder === folder)
    }

    @Test
    fun visibleLauncherItems_removesFolderWhenAllChildrenAreHidden() {
        val folder = FolderItem().apply {
            id = "folder"
            title = "Folder"
            container = Constants.CONTAINER_DESKTOP.toLong()
            items = mutableListOf(app("hidden-child", "Hidden Child"))
        }

        val result = HiddenAppsPolicy.visibleLauncherItems(
            launcherItems = listOf(folder),
            hiddenAppIds = setOf("hidden-child")
        )

        assertEquals(emptyList<LauncherItem>(), result)
    }

    @Test
    fun sections_splitsHiddenAndVisibleAppsAlphabetically() {
        val zalo = app("zalo", "Zalo")
        val camera = app("camera", "Camera")
        val maps = app("maps", "Maps")

        val sections = HiddenAppsPolicy.sections(
            apps = listOf(zalo, camera, maps),
            hiddenAppIds = setOf("maps")
        )

        assertEquals(listOf("Maps"), sections.hidden.map { it.title.toString() })
        assertEquals(listOf("Camera", "Zalo"), sections.visible.map { it.title.toString() })
        assertSame(maps, sections.hidden.single())
    }

    private fun app(id: String, title: String): ApplicationItem =
        ApplicationItem().apply {
            this.id = id
            this.title = title
            packageName = id
            container = Constants.CONTAINER_DESKTOP.toLong()
        }
}

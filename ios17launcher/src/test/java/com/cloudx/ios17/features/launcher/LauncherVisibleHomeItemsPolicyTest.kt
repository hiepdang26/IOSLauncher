package com.cloudx.ios17.features.launcher

import com.cloudx.ios17.core.database.model.ApplicationItem
import com.cloudx.ios17.core.database.model.FolderItem
import com.cloudx.ios17.core.database.model.LauncherItem
import com.cloudx.ios17.core.utils.Constants
import org.junit.Assert.assertEquals
import org.junit.Test

class LauncherVisibleHomeItemsPolicyTest {
    @Test
    fun visibleItems_refreshesFolderPreviewsEvenWhenNoAppsAreHidden() {
        val folder = folder(
            id = "folder",
            children = mutableListOf(app("child", "Child"))
        )
        val refreshedFolderIds = mutableListOf<String>()

        val result = LauncherVisibleHomeItemsPolicy.visibleItems(
            launcherItems = listOf(folder),
            hiddenAppIds = emptySet()
        ) { refreshedFolderIds += it.id }

        assertEquals(listOf(folder), result)
        assertEquals(listOf("folder"), refreshedFolderIds)
    }

    @Test
    fun visibleItems_doesNotRefreshFolderRemovedByHiddenApps() {
        val folder = folder(
            id = "folder",
            children = mutableListOf(app("hidden-child", "Hidden Child"))
        )
        val refreshedFolderIds = mutableListOf<String>()

        val result = LauncherVisibleHomeItemsPolicy.visibleItems(
            launcherItems = listOf(folder),
            hiddenAppIds = setOf("hidden-child")
        ) { refreshedFolderIds += it.id }

        assertEquals(emptyList<LauncherItem>(), result)
        assertEquals(emptyList<String>(), refreshedFolderIds)
    }

    private fun folder(id: String, children: MutableList<LauncherItem>): FolderItem =
        FolderItem().apply {
            this.id = id
            title = id
            container = Constants.CONTAINER_DESKTOP.toLong()
            items = children
        }

    private fun app(id: String, title: String): ApplicationItem =
        ApplicationItem().apply {
            this.id = id
            this.title = title
            packageName = id
            container = Constants.CONTAINER_DESKTOP.toLong()
        }
}

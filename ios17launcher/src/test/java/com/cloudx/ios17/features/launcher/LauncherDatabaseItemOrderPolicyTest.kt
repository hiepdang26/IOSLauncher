package com.cloudx.ios17.features.launcher

import com.cloudx.ios17.core.database.model.ApplicationItem
import com.cloudx.ios17.core.database.model.FolderItem
import com.cloudx.ios17.core.utils.Constants
import org.junit.Assert.assertEquals
import org.junit.Test

class LauncherDatabaseItemOrderPolicyTest {
    @Test
    fun parentsBeforeFolderChildren_movesFolderBeforeItsChildren() {
        val folder = FolderItem().apply {
            id = DefaultLauncherHomeLayoutPolicy.GOOGLE_FOLDER_ID
            title = "Google"
            container = Constants.CONTAINER_DESKTOP.toLong()
            screenId = 0
            cell = 3
        }
        val child = ApplicationItem().apply {
            id = "com.google.android.gm/.Main"
            title = "Gmail"
            container = DefaultLauncherHomeLayoutPolicy.GOOGLE_FOLDER_ID.toLong()
            cell = 0
        }

        val ordered = LauncherDatabaseItemOrderPolicy.parentsBeforeFolderChildren(listOf(child, folder))

        assertEquals(listOf(folder.id, child.id), ordered.map { it.id })
    }

    @Test
    fun parentsBeforeFolderChildren_recoversMissingGoogleFolderForOrphanedChildren() {
        val child = ApplicationItem().apply {
            id = "com.google.android.gm/.Main"
            title = "Gmail"
            container = DefaultLauncherHomeLayoutPolicy.GOOGLE_FOLDER_ID.toLong()
            cell = 0
        }

        val ordered = LauncherDatabaseItemOrderPolicy.parentsBeforeFolderChildren(listOf(child))
        val recoveredFolder = ordered.first() as FolderItem

        assertEquals(DefaultLauncherHomeLayoutPolicy.GOOGLE_FOLDER_ID, recoveredFolder.id)
        assertEquals("Google", recoveredFolder.title)
        assertEquals(listOf(DefaultLauncherHomeLayoutPolicy.GOOGLE_FOLDER_ID, child.id), ordered.map { it.id })
    }
}

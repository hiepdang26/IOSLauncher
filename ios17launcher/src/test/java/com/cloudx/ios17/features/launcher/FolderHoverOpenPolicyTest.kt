package com.cloudx.ios17.features.launcher

import com.cloudx.ios17.core.database.model.LauncherItem
import com.cloudx.ios17.core.utils.Constants
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class FolderHoverOpenPolicyTest {

    @Test
    fun canScheduleOpen_onlyForNonFolderDraggedOverClosedFolder() {
        assertTrue(
            FolderHoverOpenPolicy.canScheduleOpen(
                folderInterest = true,
                movingItemType = Constants.ITEM_TYPE_APPLICATION,
                targetItemType = Constants.ITEM_TYPE_FOLDER,
                folderAlreadyOpen = false
            )
        )
    }

    @Test
    fun canScheduleOpen_ignoresQuickPassesAndNonFolders() {
        assertFalse(
            FolderHoverOpenPolicy.canScheduleOpen(
                folderInterest = false,
                movingItemType = Constants.ITEM_TYPE_APPLICATION,
                targetItemType = Constants.ITEM_TYPE_FOLDER,
                folderAlreadyOpen = false
            )
        )
        assertFalse(
            FolderHoverOpenPolicy.canScheduleOpen(
                folderInterest = true,
                movingItemType = Constants.ITEM_TYPE_APPLICATION,
                targetItemType = Constants.ITEM_TYPE_APPLICATION,
                folderAlreadyOpen = false
            )
        )
        assertFalse(
            FolderHoverOpenPolicy.canScheduleOpen(
                folderInterest = true,
                movingItemType = Constants.ITEM_TYPE_FOLDER,
                targetItemType = Constants.ITEM_TYPE_FOLDER,
                folderAlreadyOpen = false
            )
        )
    }

    @Test
    fun canScheduleOpen_ignoresAlreadyOpenFolder() {
        assertFalse(
            FolderHoverOpenPolicy.canScheduleOpen(
                folderInterest = true,
                movingItemType = Constants.ITEM_TYPE_APPLICATION,
                targetItemType = Constants.ITEM_TYPE_FOLDER,
                folderAlreadyOpen = true
            )
        )
    }

    @Test
    fun isExternalDropIntoOpenFolder_detectsAppsFromOutsideFolder() {
        val folder = LauncherItem().apply { id = "123" }
        val outsideApp = LauncherItem().apply { container = Constants.CONTAINER_DESKTOP.toLong() }
        val insideApp = LauncherItem().apply { container = 123L }

        assertTrue(FolderHoverOpenPolicy.isExternalDropIntoOpenFolder(outsideApp, folder))
        assertFalse(FolderHoverOpenPolicy.isExternalDropIntoOpenFolder(insideApp, folder))
    }
}

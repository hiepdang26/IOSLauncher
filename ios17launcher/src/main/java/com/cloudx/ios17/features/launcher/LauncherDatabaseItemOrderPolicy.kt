package com.cloudx.ios17.features.launcher

import com.cloudx.ios17.core.database.model.LauncherItem
import com.cloudx.ios17.core.database.model.FolderItem
import com.cloudx.ios17.core.utils.Constants

object LauncherDatabaseItemOrderPolicy {
    fun parentsBeforeFolderChildren(items: List<LauncherItem>): List<LauncherItem> {
        val recoverableItems = recoverMissingGoogleFolder(items)
        val folderIds = recoverableItems.asSequence()
            .filter { it.itemType == Constants.ITEM_TYPE_FOLDER }
            .mapNotNull { it.id.toLongOrNull() }
            .toSet()
        return recoverableItems.sortedBy { item ->
            if (item.itemType != Constants.ITEM_TYPE_FOLDER && item.container in folderIds) {
                1
            } else {
                0
            }
        }
    }

    private fun recoverMissingGoogleFolder(items: List<LauncherItem>): List<LauncherItem> {
        val googleFolderId = DefaultLauncherHomeLayoutPolicy.GOOGLE_FOLDER_ID
        val hasGoogleFolder = items.any {
            it.itemType == Constants.ITEM_TYPE_FOLDER && it.id == googleFolderId
        }
        val hasGoogleFolderChild = items.any {
            it.container == googleFolderId.toLong()
        }
        if (hasGoogleFolder || !hasGoogleFolderChild) {
            return items
        }

        val googleFolder = FolderItem().apply {
            id = googleFolderId
            title = "Google"
            packageName = "FOLDER"
            container = Constants.CONTAINER_DESKTOP.toLong()
            screenId = 0
            cell = 3
        }
        return items + googleFolder
    }
}

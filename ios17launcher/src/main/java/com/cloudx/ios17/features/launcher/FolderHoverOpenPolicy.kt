package com.cloudx.ios17.features.launcher

import com.cloudx.ios17.core.database.model.LauncherItem
import com.cloudx.ios17.core.utils.Constants

object FolderHoverOpenPolicy {
    const val OPEN_DELAY_MS = 650L

    fun canScheduleOpen(
        folderInterest: Boolean,
        movingItemType: Int,
        targetItemType: Int?,
        folderAlreadyOpen: Boolean
    ): Boolean =
        folderInterest &&
            !folderAlreadyOpen &&
            movingItemType != Constants.ITEM_TYPE_FOLDER &&
            targetItemType == Constants.ITEM_TYPE_FOLDER

    fun isExternalDropIntoOpenFolder(movingItem: LauncherItem, folder: LauncherItem): Boolean =
        movingItem.container != folder.id.toLongOrNull()
}

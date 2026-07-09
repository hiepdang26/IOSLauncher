package com.cloudx.ios17.features.launcher

import com.cloudx.ios17.core.database.model.FolderItem
import com.cloudx.ios17.core.database.model.LauncherItem

object LauncherVisibleHomeItemsPolicy {
    fun visibleItems(
        launcherItems: List<LauncherItem>,
        hiddenAppIds: Set<String>,
        refreshFolderPreview: (FolderItem) -> Unit
    ): List<LauncherItem> {
        val visibleItems = HiddenAppsPolicy.visibleLauncherItems(launcherItems, hiddenAppIds)
        visibleItems.filterIsInstance<FolderItem>()
            .filterNot { folder -> folder.items.isNullOrEmpty() }
            .forEach(refreshFolderPreview)
        return visibleItems
    }
}

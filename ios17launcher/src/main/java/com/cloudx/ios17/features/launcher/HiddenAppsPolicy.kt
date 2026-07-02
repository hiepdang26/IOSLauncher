package com.cloudx.ios17.features.launcher

import com.cloudx.ios17.core.database.model.ApplicationItem
import com.cloudx.ios17.core.database.model.FolderItem
import com.cloudx.ios17.core.database.model.LauncherItem
import com.cloudx.ios17.core.utils.Constants
import java.text.Collator

object HiddenAppsPolicy {
    data class Sections(
        val hidden: List<ApplicationItem>,
        val visible: List<ApplicationItem>
    )

    fun visibleLauncherItems(
        launcherItems: List<LauncherItem>,
        hiddenAppIds: Set<String>
    ): List<LauncherItem> {
        if (hiddenAppIds.isEmpty()) {
            return launcherItems
        }

        return launcherItems.mapNotNull { item ->
            when (item.itemType) {
                Constants.ITEM_TYPE_APPLICATION -> {
                    if ((item as ApplicationItem).isHiddenBy(hiddenAppIds)) null else item
                }
                Constants.ITEM_TYPE_FOLDER -> {
                    visibleFolderOrNull(item as FolderItem, hiddenAppIds)
                }
                else -> item
            }
        }
    }

    fun sections(
        apps: List<ApplicationItem>,
        hiddenAppIds: Set<String>
    ): Sections {
        val sortedApps = sortedApps(apps)
        return Sections(
            hidden = sortedApps.filter { it.isHiddenBy(hiddenAppIds) },
            visible = sortedApps.filterNot { it.isHiddenBy(hiddenAppIds) }
        )
    }

    fun uniqueAppsFromLauncherItems(launcherItems: List<LauncherItem>): List<ApplicationItem> {
        val appsById = linkedMapOf<String, ApplicationItem>()

        fun collect(item: LauncherItem) {
            when (item.itemType) {
                Constants.ITEM_TYPE_APPLICATION -> appsById.putIfAbsent(item.id, item as ApplicationItem)
                Constants.ITEM_TYPE_FOLDER -> (item as FolderItem).items.orEmpty().forEach(::collect)
            }
        }

        launcherItems.forEach(::collect)
        return sortedApps(appsById.values.toList())
    }

    fun hiddenKeyFor(app: ApplicationItem): String =
        app.componentName?.flattenToString()?.takeIf { key -> key.isNotBlank() } ?: app.id

    private fun visibleFolderOrNull(folderItem: FolderItem, hiddenAppIds: Set<String>): FolderItem? {
        val visibleItems = folderItem.items.orEmpty().filterNot { item ->
            item.itemType == Constants.ITEM_TYPE_APPLICATION &&
                (item as ApplicationItem).isHiddenBy(hiddenAppIds)
        }
        if (visibleItems.isEmpty()) {
            return null
        }

        return FolderItem().apply {
            id = folderItem.id
            keyId = folderItem.keyId
            title = folderItem.title
            container = folderItem.container
            screenId = folderItem.screenId
            cell = folderItem.cell
            packageName = folderItem.packageName
            icon = folderItem.icon
            user = folderItem.user
            items = visibleItems.toMutableList()
        }
    }

    private fun sortedApps(apps: List<ApplicationItem>): List<ApplicationItem> {
        val collator = Collator.getInstance()
        return apps.sortedWith { left, right ->
            collator.compare(left.title.toString(), right.title.toString())
        }
    }

    private fun ApplicationItem.isHiddenBy(hiddenAppIds: Set<String>): Boolean {
        if (hiddenAppIds.isEmpty()) {
            return false
        }
        return hiddenKeys().any { key -> key in hiddenAppIds }
    }

    private fun ApplicationItem.hiddenKeys(): Set<String> {
        return linkedSetOf<String>().apply {
            id.takeIf { key -> key.isNotBlank() }?.let(::add)
            id.substringBeforeLast('/', missingDelimiterValue = id)
                .takeIf { key -> key.isNotBlank() && key != id }
                ?.let(::add)
            componentName?.flattenToString()?.takeIf { key -> key.isNotBlank() }?.let(::add)
            packageName?.takeIf { key -> key.isNotBlank() }?.let(::add)
        }
    }
}

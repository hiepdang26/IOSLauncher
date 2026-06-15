package com.vhmsoft.launcherios26.ui.launcher.workspace

object LauncherHomeDuplicateSanitizer {
    fun sanitize(items: List<LauncherHomeItemUiModel>): List<LauncherHomeItemUiModel> {
        val normalizedItems = LauncherHomeLayoutBuilder.normalize(items)
        val occurrenceByIconKey = mutableMapOf<String, LauncherAppOccurrence>()
        normalizedItems.forEachIndexed { itemIndex, item ->
            item.containedApps().forEachIndexed { appIndex, app ->
                occurrenceByIconKey[app.app.iconKey] = LauncherAppOccurrence(itemIndex, appIndex)
            }
        }

        val keptIconKeys = mutableSetOf<String>()
        val sanitizedItems = normalizedItems.mapIndexed { itemIndex, item ->
            when (item) {
                is LauncherHomeItemUiModel.App -> {
                    val iconKey = item.iconItem.app.iconKey
                    val occurrence = occurrenceByIconKey[iconKey]
                    if (occurrence?.itemIndex == itemIndex && keptIconKeys.add(iconKey)) {
                        item
                    } else {
                        LauncherHomeItemUiModel.Placeholder.forGridIndex(itemIndex)
                    }
                }

                is LauncherHomeItemUiModel.Folder -> {
                    val filteredApps = item.apps.filterIndexed { appIndex, app ->
                        val iconKey = app.app.iconKey
                        val occurrence = occurrenceByIconKey[iconKey]
                        occurrence?.itemIndex == itemIndex &&
                            occurrence.appIndex == appIndex &&
                            keptIconKeys.add(iconKey)
                    }
                    item.copy(apps = filteredApps)
                }

                is LauncherHomeItemUiModel.Placeholder -> item
            }
        }

        return LauncherHomeLayoutBuilder.normalize(sanitizedItems)
    }

    private data class LauncherAppOccurrence(
        val itemIndex: Int,
        val appIndex: Int
    )
}

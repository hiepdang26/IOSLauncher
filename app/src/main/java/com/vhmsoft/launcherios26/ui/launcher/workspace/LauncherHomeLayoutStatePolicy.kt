package com.vhmsoft.launcherios26.ui.launcher.workspace

import com.vhmsoft.launcherios26.data.model.LauncherFolder
import java.util.Base64

object LauncherHomeLayoutStatePolicy {
    fun arrange(
        items: List<LauncherHomeItemUiModel>,
        autoArrange: Boolean
    ): List<LauncherHomeItemUiModel> {
        val sanitizedItems = LauncherHomeDuplicateSanitizer.sanitize(items)
        return if (autoArrange) {
            LauncherHomeLayoutBuilder.compact(sanitizedItems)
        } else {
            sanitizedItems
        }
    }

    fun resetFoldersToApps(items: List<LauncherHomeItemUiModel>): List<LauncherHomeItemUiModel> {
        return LauncherHomeLayoutBuilder.normalize(items)
            .flatMap { item -> item.containedApps() }
            .map { iconItem -> LauncherHomeItemUiModel.App(iconItem) }
    }

    fun encode(items: List<LauncherHomeItemUiModel>): String {
        return LauncherHomeLayoutBuilder.normalize(items)
            .joinToString(SLOT_SEPARATOR) { item ->
                when (item) {
                    is LauncherHomeItemUiModel.App -> "$APP_PREFIX${encodeValue(item.iconItem.app.iconKey)}"
                    is LauncherHomeItemUiModel.Folder -> "$FOLDER_PREFIX${encodeValue(item.id)}"
                    is LauncherHomeItemUiModel.Placeholder -> PLACEHOLDER_SLOT
                }
            }
    }

    fun restore(
        encoded: String?,
        apps: List<LauncherIconUiModel>,
        folders: List<LauncherFolder>,
        fallbackItems: List<LauncherHomeItemUiModel>
    ): List<LauncherHomeItemUiModel> {
        if (encoded.isNullOrBlank()) return fallbackItems

        val appByKey = apps.associateBy { item -> item.app.iconKey }
        val folderById = folders.associateBy { folder -> folder.id }
        val usedIconKeys = mutableSetOf<String>()
        val restoredItems = mutableListOf<LauncherHomeItemUiModel>()

        encoded.split(SLOT_SEPARATOR).forEach { slot ->
            when {
                slot == PLACEHOLDER_SLOT -> {
                    restoredItems += LauncherHomeItemUiModel.Placeholder.forGridIndex(restoredItems.size)
                }

                slot.startsWith(APP_PREFIX) -> {
                    val iconKey = decodeValue(slot.removePrefix(APP_PREFIX)) ?: return@forEach
                    val app = appByKey[iconKey] ?: return@forEach
                    if (usedIconKeys.add(iconKey)) {
                        restoredItems += LauncherHomeItemUiModel.App(app)
                    }
                }

                slot.startsWith(FOLDER_PREFIX) -> {
                    val folderId = decodeValue(slot.removePrefix(FOLDER_PREFIX)) ?: return@forEach
                    val folder = folderById[folderId] ?: return@forEach
                    val folderApps = folder.appIconKeys
                        .mapNotNull { iconKey -> appByKey[iconKey] }
                        .filter { app -> app.app.iconKey !in usedIconKeys }
                    if (folderApps.isNotEmpty()) {
                        usedIconKeys += folderApps.map { app -> app.app.iconKey }
                        restoredItems += LauncherHomeItemUiModel.Folder(
                            id = folder.id,
                            title = folder.title.ifBlank { LauncherHomeLayoutBuilder.DEFAULT_FOLDER_TITLE },
                            apps = folderApps
                        )
                    }
                }
            }
        }

        appendRemainingItems(
            target = restoredItems,
            fallbackItems = fallbackItems,
            usedIconKeys = usedIconKeys
        )
        return LauncherHomeDuplicateSanitizer.sanitize(restoredItems)
    }

    private fun appendRemainingItems(
        target: MutableList<LauncherHomeItemUiModel>,
        fallbackItems: List<LauncherHomeItemUiModel>,
        usedIconKeys: MutableSet<String>
    ) {
        LauncherHomeLayoutBuilder.normalize(fallbackItems).forEach { item ->
            when (item) {
                is LauncherHomeItemUiModel.App -> {
                    val iconKey = item.iconItem.app.iconKey
                    if (usedIconKeys.add(iconKey)) {
                        target += item
                    }
                }

                is LauncherHomeItemUiModel.Folder -> {
                    val remainingApps = item.apps.filter { app -> app.app.iconKey !in usedIconKeys }
                    if (remainingApps.isNotEmpty()) {
                        usedIconKeys += remainingApps.map { app -> app.app.iconKey }
                        target += item.copy(apps = remainingApps)
                    }
                }

                is LauncherHomeItemUiModel.Placeholder -> Unit
            }
        }
    }

    private fun encodeValue(value: String): String {
        return Base64.getUrlEncoder()
            .withoutPadding()
            .encodeToString(value.toByteArray(Charsets.UTF_8))
    }

    private fun decodeValue(value: String): String? {
        return runCatching {
            String(Base64.getUrlDecoder().decode(value), Charsets.UTF_8)
        }.getOrNull()
    }

    private const val SLOT_SEPARATOR = "\n"
    private const val APP_PREFIX = "A:"
    private const val FOLDER_PREFIX = "F:"
    private const val PLACEHOLDER_SLOT = "P"
}

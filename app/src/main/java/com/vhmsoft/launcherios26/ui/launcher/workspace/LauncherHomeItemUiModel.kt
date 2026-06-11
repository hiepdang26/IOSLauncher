package com.vhmsoft.launcherios26.ui.launcher.workspace

sealed class LauncherHomeItemUiModel {
    abstract val label: String
    abstract val stableId: Long

    data class App(
        val iconItem: LauncherIconUiModel
    ) : LauncherHomeItemUiModel() {
        override val label: String = iconItem.label
        override val stableId: Long = iconItem.stableId
    }

    data class Folder(
        val id: String,
        val title: String,
        val apps: List<LauncherIconUiModel>
    ) : LauncherHomeItemUiModel() {
        override val label: String = title
        override val stableId: Long = id.hashCode().toLong()
    }

    data class Placeholder(
        private val placeholderId: Long = nextPlaceholderId()
    ) : LauncherHomeItemUiModel() {
        override val label: String = ""
        override val stableId: Long = Long.MIN_VALUE + placeholderId
    }

    fun containedApps(): List<LauncherIconUiModel> {
        return when (this) {
            is App -> listOf(iconItem)
            is Folder -> apps
            is Placeholder -> emptyList()
        }
    }

    private companion object {
        private var nextPlaceholderId = 1L

        fun nextPlaceholderId(): Long {
            return nextPlaceholderId++
        }
    }
}

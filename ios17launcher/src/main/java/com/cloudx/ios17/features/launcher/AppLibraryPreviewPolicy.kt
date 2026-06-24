package com.cloudx.ios17.features.launcher

object AppLibraryPreviewPolicy {
    private const val MAX_LARGE_PREVIEW_COUNT = 3
    private const val FULL_SIZE_PREVIEW_COUNT = 4
    private const val OVERFLOW_PREVIEW_COUNT = 4

    enum class SlotContent {
        LARGE_ICON,
        OVERFLOW_CLUSTER
    }

    fun shouldUseOverflowCluster(appCount: Int): Boolean {
        return appCount > FULL_SIZE_PREVIEW_COUNT
    }

    fun previewSlotContent(appCount: Int, slot: Int): SlotContent {
        return if (slot == MAX_LARGE_PREVIEW_COUNT && shouldUseOverflowCluster(appCount)) {
            SlotContent.OVERFLOW_CLUSTER
        } else {
            SlotContent.LARGE_ICON
        }
    }

    fun <T> largePreviewApps(apps: List<T>): List<T> {
        return if (shouldUseOverflowCluster(apps.size)) {
            apps.take(MAX_LARGE_PREVIEW_COUNT)
        } else {
            apps.take(FULL_SIZE_PREVIEW_COUNT)
        }
    }

    fun <T> overflowPreviewApps(apps: List<T>): List<T> {
        return if (shouldUseOverflowCluster(apps.size)) {
            apps.drop(MAX_LARGE_PREVIEW_COUNT).take(OVERFLOW_PREVIEW_COUNT)
        } else {
            emptyList()
        }
    }
}

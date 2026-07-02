package com.cloudx.ios17.features.launcher

object HomeWidgetVisualCleanupPolicy {

    fun shouldRemoveHost(
        hostId: String?,
        validIds: Set<String>,
        recentlyRemovedIds: Set<String>
    ): Boolean {
        hostId ?: return false
        return hostId in recentlyRemovedIds || hostId !in validIds
    }
}

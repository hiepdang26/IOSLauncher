package com.cloudx.ios17.features.launcher

internal object HomeWidgetDragSessionPolicy {
    fun shouldApplyDragEnd(activeSessionId: Long, endedSessionId: Long): Boolean {
        return activeSessionId == endedSessionId
    }

    fun nextSessionId(currentSessionId: Long): Long {
        return currentSessionId + 1L
    }
}

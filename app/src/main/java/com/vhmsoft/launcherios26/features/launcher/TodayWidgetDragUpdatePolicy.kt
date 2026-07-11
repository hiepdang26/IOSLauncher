package com.vhmsoft.launcherios26.features.launcher

import kotlin.math.abs

object TodayWidgetDragUpdatePolicy {
    fun shouldInspectMove(
        lastRawX: Float,
        lastRawY: Float,
        rawX: Float,
        rawY: Float,
        lastUptimeMs: Long,
        nowUptimeMs: Long,
        minMovePx: Float,
        minIntervalMs: Long
    ): Boolean {
        if (lastUptimeMs <= 0L || lastRawX.isNaN() || lastRawY.isNaN()) {
            return true
        }

        val deltaX = rawX - lastRawX
        val deltaY = rawY - lastRawY
        if (deltaX * deltaX + deltaY * deltaY >= minMovePx * minMovePx) {
            return true
        }

        return nowUptimeMs - lastUptimeMs >= minIntervalMs
    }

    fun shouldStartSheetDrag(deltaY: Float, touchSlop: Float): Boolean {
        return abs(deltaY) >= touchSlop
    }
}

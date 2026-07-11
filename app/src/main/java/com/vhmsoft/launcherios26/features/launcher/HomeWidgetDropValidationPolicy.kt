package com.vhmsoft.launcherios26.features.launcher

object HomeWidgetDropValidationPolicy {

    fun canPlace(
        candidateCells: Set<Int>?,
        reservedWidgetCells: Set<Int>
    ): Boolean {
        if (candidateCells == null || candidateCells.isEmpty()) {
            return false
        }
        return candidateCells.none { it in reservedWidgetCells }
    }
}

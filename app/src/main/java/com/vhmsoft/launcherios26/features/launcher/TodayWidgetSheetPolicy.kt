package com.vhmsoft.launcherios26.features.launcher

object TodayWidgetSheetPolicy {
    enum class SnapTarget {
        EXPANDED,
        RESTING,
        DISMISS
    }

    fun dragTranslation(
        startTranslation: Float,
        deltaY: Float,
        minTranslation: Float,
        maxTranslation: Float
    ): Float {
        return (startTranslation + deltaY).coerceIn(minTranslation, maxTranslation)
    }

    fun snapTarget(
        translationY: Float,
        sheetHeight: Float
    ): SnapTarget {
        if (sheetHeight <= 0f) {
            return SnapTarget.RESTING
        }

        return when {
            translationY >= sheetHeight * DISMISS_THRESHOLD_RATIO -> SnapTarget.DISMISS
            translationY <= -sheetHeight * EXPAND_THRESHOLD_RATIO -> SnapTarget.EXPANDED
            else -> SnapTarget.RESTING
        }
    }

    private const val DISMISS_THRESHOLD_RATIO = 0.22f
    private const val EXPAND_THRESHOLD_RATIO = 0.08f
}

package com.cloudx.ios17.features.launcher

object LauncherIndicatorSearchPillPolicy {
    data class VisualSpec(
        val widthDp: Int,
        val heightDp: Int,
        val iconSizeDp: Int,
        val iconTextGapDp: Int,
        val textSizeSp: Float
    )

    fun visualSpec(): VisualSpec =
        VisualSpec(
            widthDp = 104,
            heightDp = 36,
            iconSizeDp = 18,
            iconTextGapDp = 4,
            textSizeSp = 13f
        )
}

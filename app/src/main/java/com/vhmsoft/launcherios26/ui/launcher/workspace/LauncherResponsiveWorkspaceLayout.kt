package com.vhmsoft.launcherios26.ui.launcher.workspace

import com.vhmsoft.launcherios26.ui.launcher.LauncherHomeIconSizePolicy
import kotlin.math.roundToInt

data class LauncherResponsiveWorkspaceSpec(
    val effectiveRows: Int,
    val effectiveIconSizeDp: Int,
    val homeTopPaddingDp: Int,
    val homeBottomPaddingDp: Int,
    val bottomControlHeightDp: Int,
    val bottomControlTopMarginDp: Int,
    val bottomControlBottomMarginDp: Int,
    val dockHeightDp: Int,
    val dockHorizontalPaddingDp: Int,
    val dockVerticalPaddingDp: Int
)

object LauncherResponsiveWorkspaceLayout {
    fun resolve(
        rootHeightPx: Int,
        density: Float,
        preferredRows: Int,
        preferredIconSizeDp: Int,
        iphone8Style: Boolean
    ): LauncherResponsiveWorkspaceSpec {
        val safeDensity = density.takeIf { value -> value > 0f } ?: 1f
        val rootHeightDp = rootHeightPx / safeDensity
        val compact = compactFactor(rootHeightDp)
        val iconSizeDp = lerp(preferredIconSizeDp, preferredIconSizeDp.coerceAtMost(COMPACT_ICON_SIZE_DP), compact)
            .coerceIn(MIN_COMPACT_ICON_SIZE_DP, preferredIconSizeDp)
        val homeTopPaddingDp = lerp(HOME_TOP_PADDING_DP, COMPACT_HOME_TOP_PADDING_DP, compact)
        val homeBottomPaddingDp = lerp(HOME_BOTTOM_PADDING_DP, COMPACT_HOME_BOTTOM_PADDING_DP, compact)
        val bottomControlHeightDp = lerp(BOTTOM_CONTROL_HEIGHT_DP, COMPACT_BOTTOM_CONTROL_HEIGHT_DP, compact)
        val bottomControlTopMarginDp = lerp(BOTTOM_CONTROL_TOP_MARGIN_DP, COMPACT_BOTTOM_CONTROL_TOP_MARGIN_DP, compact)
        val bottomControlBottomMarginDp = lerp(BOTTOM_CONTROL_BOTTOM_MARGIN_DP, COMPACT_BOTTOM_CONTROL_BOTTOM_MARGIN_DP, compact)
        val dockExtraDp = lerp(
            if (iphone8Style) DOCK_IPHONE8_EXTRA_DP else DOCK_EXTRA_DP,
            if (iphone8Style) COMPACT_DOCK_IPHONE8_EXTRA_DP else COMPACT_DOCK_EXTRA_DP,
            compact
        )
        val dockHeightDp = iconSizeDp + dockExtraDp
        val availablePagerHeightDp = rootHeightDp -
            homeTopPaddingDp -
            homeBottomPaddingDp -
            bottomControlHeightDp -
            bottomControlTopMarginDp -
            bottomControlBottomMarginDp -
            dockHeightDp

        val effectiveRows = resolveRows(
            preferredRows = preferredRows
        )
        val cellHeightDp = availablePagerHeightDp / effectiveRows.coerceAtLeast(1)
        val fitIconSizeDp = (cellHeightDp - MIN_LABEL_AND_GAP_DP)
            .roundToInt()
            .coerceIn(MIN_COMPACT_ICON_SIZE_DP, iconSizeDp)
        val effectiveIconSizeDp = fitIconSizeDp.coerceAtMost(iconSizeDp)

        return LauncherResponsiveWorkspaceSpec(
            effectiveRows = effectiveRows,
            effectiveIconSizeDp = effectiveIconSizeDp,
            homeTopPaddingDp = homeTopPaddingDp,
            homeBottomPaddingDp = homeBottomPaddingDp,
            bottomControlHeightDp = bottomControlHeightDp,
            bottomControlTopMarginDp = bottomControlTopMarginDp,
            bottomControlBottomMarginDp = bottomControlBottomMarginDp,
            dockHeightDp = effectiveIconSizeDp + dockExtraDp,
            dockHorizontalPaddingDp = lerp(
                if (iphone8Style) DOCK_IPHONE8_HORIZONTAL_PADDING_DP else DOCK_HORIZONTAL_PADDING_DP,
                if (iphone8Style) COMPACT_DOCK_IPHONE8_HORIZONTAL_PADDING_DP else COMPACT_DOCK_HORIZONTAL_PADDING_DP,
                compact
            ),
            dockVerticalPaddingDp = lerp(
                if (iphone8Style) DOCK_IPHONE8_VERTICAL_PADDING_DP else DOCK_VERTICAL_PADDING_DP,
                if (iphone8Style) COMPACT_DOCK_IPHONE8_VERTICAL_PADDING_DP else COMPACT_DOCK_VERTICAL_PADDING_DP,
                compact
            )
        )
    }

    private fun resolveRows(
        preferredRows: Int
    ): Int {
        return preferredRows.coerceIn(MIN_HOME_ROWS, MAX_HOME_ROWS)
    }

    private fun compactFactor(rootHeightDp: Float): Float {
        return when {
            rootHeightDp <= COMPACT_HEIGHT_DP -> 1f
            rootHeightDp >= REGULAR_HEIGHT_DP -> 0f
            else -> (REGULAR_HEIGHT_DP - rootHeightDp) / (REGULAR_HEIGHT_DP - COMPACT_HEIGHT_DP)
        }.coerceIn(0f, 1f)
    }

    private fun lerp(start: Int, end: Int, amount: Float): Int {
        return (start + (end - start) * amount).roundToInt()
    }

    private const val MIN_HOME_ROWS = 5
    private const val MAX_HOME_ROWS = 6
    private const val REGULAR_HEIGHT_DP = 760f
    private const val COMPACT_HEIGHT_DP = 660f
    private const val HOME_TOP_PADDING_DP = 78
    private const val COMPACT_HOME_TOP_PADDING_DP = 36
    private const val HOME_BOTTOM_PADDING_DP = 16
    private const val COMPACT_HOME_BOTTOM_PADDING_DP = 8
    private const val BOTTOM_CONTROL_HEIGHT_DP = 54
    private const val COMPACT_BOTTOM_CONTROL_HEIGHT_DP = 40
    private const val BOTTOM_CONTROL_TOP_MARGIN_DP = 8
    private const val COMPACT_BOTTOM_CONTROL_TOP_MARGIN_DP = 4
    private const val BOTTOM_CONTROL_BOTTOM_MARGIN_DP = 14
    private const val COMPACT_BOTTOM_CONTROL_BOTTOM_MARGIN_DP = 6
    private const val DOCK_EXTRA_DP = 28
    private const val COMPACT_DOCK_EXTRA_DP = 18
    private const val DOCK_IPHONE8_EXTRA_DP = 58
    private const val COMPACT_DOCK_IPHONE8_EXTRA_DP = 38
    private const val DOCK_HORIZONTAL_PADDING_DP = 14
    private const val COMPACT_DOCK_HORIZONTAL_PADDING_DP = 10
    private const val DOCK_VERTICAL_PADDING_DP = 10
    private const val COMPACT_DOCK_VERTICAL_PADDING_DP = 7
    private const val DOCK_IPHONE8_HORIZONTAL_PADDING_DP = 28
    private const val COMPACT_DOCK_IPHONE8_HORIZONTAL_PADDING_DP = 22
    private const val DOCK_IPHONE8_VERTICAL_PADDING_DP = 18
    private const val COMPACT_DOCK_IPHONE8_VERTICAL_PADDING_DP = 12
    private const val COMPACT_ICON_SIZE_DP = 56
    private const val MIN_COMPACT_ICON_SIZE_DP = LauncherHomeIconSizePolicy.MIN_HOME_ICON_SIZE_DP
    private const val MIN_LABEL_AND_GAP_DP = 31
}

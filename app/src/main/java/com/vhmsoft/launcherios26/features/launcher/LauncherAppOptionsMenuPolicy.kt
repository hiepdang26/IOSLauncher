package com.vhmsoft.launcherios26.features.launcher

import kotlin.math.max
import kotlin.math.min

object LauncherAppOptionsMenuPolicy {
    const val POPUP_WIDTH_DP = 262
    const val ROW_HEIGHT_DP = 40
    const val ROW_HORIZONTAL_PADDING_DP = 12
    const val TRAILING_ICON_SIZE_DP = 20
    const val TITLE_TEXT_SIZE_SP = 14f
    const val CORNER_RADIUS_DP = 12
    const val DIVIDER_HEIGHT_PX = 1
    const val VERTICAL_PADDING_DP = 4
    const val SCREEN_EDGE_MARGIN_DP = 16
    const val ANCHOR_GAP_DP = 8
    const val SELECTED_ICON_PREVIEW_OPEN_SCALE = 1.08f

    enum class SystemOption {
        APP_INFO,
        HIDE_APP,
        EDIT_HOME,
        DELETE
    }

    enum class RowType {
        SHORTCUT,
        APP_INFO,
        HIDE_APP,
        EDIT_HOME,
        DELETE
    }

    fun systemOptions(canHideApp: Boolean): List<SystemOption> =
        buildList {
            add(SystemOption.APP_INFO)
            if (canHideApp) {
                add(SystemOption.HIDE_APP)
            }
            add(SystemOption.EDIT_HOME)
            add(SystemOption.DELETE)
        }

    fun rowTypes(shortcutCount: Int, canHideApp: Boolean): List<RowType> =
        buildList {
            repeat(shortcutCount.coerceAtLeast(0)) {
                add(RowType.SHORTCUT)
            }
            systemOptions(canHideApp).forEach { option ->
                add(
                    when (option) {
                        SystemOption.APP_INFO -> RowType.APP_INFO
                        SystemOption.HIDE_APP -> RowType.HIDE_APP
                        SystemOption.EDIT_HOME -> RowType.EDIT_HOME
                        SystemOption.DELETE -> RowType.DELETE
                    }
                )
            }
        }

    fun popupHeightPx(
        rowCount: Int,
        rowHeightPx: Int,
        verticalPaddingPx: Int,
        dividerHeightPx: Int,
        availableHeightPx: Int
    ): Int {
        val safeRowCount = rowCount.coerceAtLeast(0)
        val dividerCount = (safeRowCount - 1).coerceAtLeast(0)
        val contentHeight = safeRowCount * rowHeightPx + dividerCount * dividerHeightPx + verticalPaddingPx
        return contentHeight.coerceAtMost(availableHeightPx.coerceAtLeast(0))
    }

    fun shouldScroll(
        rowCount: Int,
        rowHeightPx: Int,
        verticalPaddingPx: Int,
        dividerHeightPx: Int,
        availableHeightPx: Int
    ): Boolean {
        val safeRowCount = rowCount.coerceAtLeast(0)
        val dividerCount = (safeRowCount - 1).coerceAtLeast(0)
        val contentHeight = safeRowCount * rowHeightPx + dividerCount * dividerHeightPx + verticalPaddingPx
        return contentHeight > availableHeightPx
    }

    fun popupY(
        anchorTopPx: Int,
        anchorHeightPx: Int,
        selectedIconTopPx: Int,
        selectedIconBottomPx: Int,
        popupHeightPx: Int,
        screenHeightPx: Int,
        marginPx: Int,
        gapPx: Int
    ): Int {
        val screenBottomLimit = screenHeightPx - marginPx
        val desiredBelowPx = max(
            anchorTopPx + anchorHeightPx + gapPx,
            selectedIconBottomPx + gapPx
        )
        if (desiredBelowPx + popupHeightPx <= screenBottomLimit) {
            return desiredBelowPx
        }

        val desiredAbovePx = selectedIconTopPx - gapPx - popupHeightPx
        if (desiredAbovePx >= marginPx) {
            return desiredAbovePx
        }

        return max(marginPx, min(desiredBelowPx, screenBottomLimit - popupHeightPx))
    }

    fun availableHeightPx(
        selectedIconTopPx: Int,
        selectedIconBottomPx: Int,
        screenHeightPx: Int,
        marginPx: Int,
        gapPx: Int,
        minimumHeightPx: Int
    ): Int {
        val abovePx = selectedIconTopPx - gapPx - marginPx
        val belowPx = screenHeightPx - selectedIconBottomPx - gapPx - marginPx
        return max(minimumHeightPx, max(abovePx, belowPx))
    }
}

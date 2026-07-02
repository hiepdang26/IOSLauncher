package com.cloudx.ios17.features.launcher

object LauncherUninstallConfirmationPolicy {
    const val DIM_AMOUNT = 0.56f
    const val SHEET_CORNER_RADIUS_DP = 28
    const val SHEET_HORIZONTAL_PADDING_DP = 28
    const val SHEET_TOP_PADDING_DP = 30
    const val SHEET_BOTTOM_PADDING_DP = 18
    const val MESSAGE_TOP_MARGIN_DP = 22
    const val ACTION_ROW_TOP_MARGIN_DP = 48
    const val ACTION_WIDTH_DP = 96
    const val ACTION_HEIGHT_DP = 52

    fun shouldConfirmBeforeUninstall(isApplication: Boolean, canUninstall: Boolean): Boolean {
        return isApplication && canUninstall
    }

    fun shouldRemoveFromHomeAfterUninstallRequest(requestStarted: Boolean): Boolean {
        return requestStarted
    }
}

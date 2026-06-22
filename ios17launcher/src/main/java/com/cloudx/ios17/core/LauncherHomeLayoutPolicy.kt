package com.cloudx.ios17.core

class LauncherHomeLayoutPolicy private constructor() {
    companion object {
        const val DEFAULT_HOME_GRID_ROWS = 6

        @JvmStatic
        fun normalizeRows(rows: Int): Int {
            return if (rows == 5 || rows == 6) rows else DEFAULT_HOME_GRID_ROWS
        }

        @JvmStatic
        fun pageSize(rows: Int, columns: Int): Int {
            return rows.coerceAtLeast(1) * columns.coerceAtLeast(1)
        }

        @JvmStatic
        fun iconPadding(cellWidthPx: Int, iconSizePx: Int, minPaddingPx: Int): Int {
            return maxOf(minPaddingPx, (cellWidthPx - iconSizePx) / 2)
        }
    }
}

package com.vhmsoft.launcherios26.features.launcher

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherAppOptionsMenuPolicyTest {
    @Test
    fun designMetrics_matchReferenceMenu() {
        assertEquals(262, LauncherAppOptionsMenuPolicy.POPUP_WIDTH_DP)
        assertEquals(40, LauncherAppOptionsMenuPolicy.ROW_HEIGHT_DP)
        assertEquals(12, LauncherAppOptionsMenuPolicy.ROW_HORIZONTAL_PADDING_DP)
        assertEquals(20, LauncherAppOptionsMenuPolicy.TRAILING_ICON_SIZE_DP)
        assertEquals(14f, LauncherAppOptionsMenuPolicy.TITLE_TEXT_SIZE_SP)
        assertEquals(12, LauncherAppOptionsMenuPolicy.CORNER_RADIUS_DP)
        assertEquals(1, LauncherAppOptionsMenuPolicy.DIVIDER_HEIGHT_PX)
    }

    @Test
    fun systemOptions_followReferenceOrderForApps() {
        val options = LauncherAppOptionsMenuPolicy.systemOptions(canHideApp = true)

        assertEquals(
            listOf(
                LauncherAppOptionsMenuPolicy.SystemOption.APP_INFO,
                LauncherAppOptionsMenuPolicy.SystemOption.HIDE_APP,
                LauncherAppOptionsMenuPolicy.SystemOption.EDIT_HOME,
                LauncherAppOptionsMenuPolicy.SystemOption.DELETE
            ),
            options
        )
    }

    @Test
    fun systemOptions_skipHideWhenItemCannotBeHidden() {
        val options = LauncherAppOptionsMenuPolicy.systemOptions(canHideApp = false)

        assertEquals(
            listOf(
                LauncherAppOptionsMenuPolicy.SystemOption.APP_INFO,
                LauncherAppOptionsMenuPolicy.SystemOption.EDIT_HOME,
                LauncherAppOptionsMenuPolicy.SystemOption.DELETE
            ),
            options
        )
    }

    @Test
    fun rowTypes_placeAppShortcutsAboveSystemOptions() {
        val rows = LauncherAppOptionsMenuPolicy.rowTypes(shortcutCount = 2, canHideApp = true)

        assertEquals(
            listOf(
                LauncherAppOptionsMenuPolicy.RowType.SHORTCUT,
                LauncherAppOptionsMenuPolicy.RowType.SHORTCUT,
                LauncherAppOptionsMenuPolicy.RowType.APP_INFO,
                LauncherAppOptionsMenuPolicy.RowType.HIDE_APP,
                LauncherAppOptionsMenuPolicy.RowType.EDIT_HOME,
                LauncherAppOptionsMenuPolicy.RowType.DELETE
            ),
            rows
        )
    }

    @Test
    fun popupHeight_wrapsContentWhenRowsFit() {
        val height = LauncherAppOptionsMenuPolicy.popupHeightPx(
            rowCount = 4,
            rowHeightPx = 40,
            verticalPaddingPx = 4,
            dividerHeightPx = 1,
            availableHeightPx = 300
        )

        assertEquals(167, height)
        assertFalse(
            LauncherAppOptionsMenuPolicy.shouldScroll(
                rowCount = 4,
                rowHeightPx = 40,
                verticalPaddingPx = 4,
                dividerHeightPx = 1,
                availableHeightPx = 300
            )
        )
    }

    @Test
    fun popupHeight_capsAtAvailableHeightWhenRowsOverflow() {
        val height = LauncherAppOptionsMenuPolicy.popupHeightPx(
            rowCount = 12,
            rowHeightPx = 40,
            verticalPaddingPx = 4,
            dividerHeightPx = 1,
            availableHeightPx = 300
        )

        assertEquals(300, height)
        assertTrue(
            LauncherAppOptionsMenuPolicy.shouldScroll(
                rowCount = 12,
                rowHeightPx = 40,
                verticalPaddingPx = 4,
                dividerHeightPx = 1,
                availableHeightPx = 300
            )
        )
    }

    @Test
    fun popupY_usesVisibleSelectedIconBottomWhenPlacedBelow() {
        val y = LauncherAppOptionsMenuPolicy.popupY(
            anchorTopPx = 410,
            anchorHeightPx = 68,
            selectedIconTopPx = 408,
            selectedIconBottomPx = 486,
            popupHeightPx = 167,
            screenHeightPx = 930,
            marginPx = 16,
            gapPx = 8
        )

        assertEquals(494, y)
    }

    @Test
    fun popupY_movesAboveVisibleSelectedIconWhenBelowWouldOverflow() {
        val y = LauncherAppOptionsMenuPolicy.popupY(
            anchorTopPx = 720,
            anchorHeightPx = 68,
            selectedIconTopPx = 718,
            selectedIconBottomPx = 796,
            popupHeightPx = 167,
            screenHeightPx = 930,
            marginPx = 16,
            gapPx = 8
        )

        assertEquals(543, y)
    }
}

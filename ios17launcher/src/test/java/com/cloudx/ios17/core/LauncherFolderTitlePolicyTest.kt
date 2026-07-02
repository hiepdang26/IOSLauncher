package com.cloudx.ios17.core

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class LauncherFolderTitlePolicyTest {

    @Test
    fun isUnnamed_treatsBlankAndLegacyUntitledAsUnnamed() {
        assertTrue(LauncherFolderTitlePolicy.isUnnamed(null))
        assertTrue(LauncherFolderTitlePolicy.isUnnamed(""))
        assertTrue(LauncherFolderTitlePolicy.isUnnamed("   "))
        assertTrue(LauncherFolderTitlePolicy.isUnnamed("Untitled"))
        assertTrue(LauncherFolderTitlePolicy.isUnnamed("UNtitled"))
        assertTrue(LauncherFolderTitlePolicy.isUnnamed("untitled"))
        assertFalse(LauncherFolderTitlePolicy.isUnnamed("Game"))
    }

    @Test
    fun homeTitle_usesDefaultFolderNameForUnnamedFolders() {
        assertEquals(
            "Thư mục",
            LauncherFolderTitlePolicy.homeTitle(
                rawTitle = "Untitled",
                defaultFolderName = "Thư mục"
            )
        )
        assertEquals(
            "Game",
            LauncherFolderTitlePolicy.homeTitle(
                rawTitle = "  Game  ",
                defaultFolderName = "Thư mục"
            )
        )
    }

    @Test
    fun editableText_isEmptyForUnnamedAndTrimmedForNamedFolders() {
        assertEquals("", LauncherFolderTitlePolicy.editableText("Untitled"))
        assertEquals("", LauncherFolderTitlePolicy.editableText(" "))
        assertEquals("Ảnh", LauncherFolderTitlePolicy.editableText("  Ảnh  "))
    }

    @Test
    fun storedTitle_isBlankWhenUserClearsFolderName() {
        assertEquals("", LauncherFolderTitlePolicy.storedTitle(" "))
        assertEquals("Du lịch", LauncherFolderTitlePolicy.storedTitle("  Du lịch  "))
    }

    @Test
    fun inputHint_onlyShowsForUnnamedFoldersWhenNotFocused() {
        assertEquals(
            "thư mục chưa đặt tên",
            LauncherFolderTitlePolicy.inputHint(
                rawTitle = "",
                hasFocus = false,
                unnamedHint = "thư mục chưa đặt tên"
            )
        )
        assertEquals(
            "",
            LauncherFolderTitlePolicy.inputHint(
                rawTitle = "",
                hasFocus = true,
                unnamedHint = "thư mục chưa đặt tên"
            )
        )
        assertEquals(
            "",
            LauncherFolderTitlePolicy.inputHint(
                rawTitle = "Ảnh",
                hasFocus = false,
                unnamedHint = "thư mục chưa đặt tên"
            )
        )
    }

    @Test
    fun inputTextSize_usesSmallerSizeOnlyForUnfocusedUnnamedHint() {
        assertEquals(
            20f,
            LauncherFolderTitlePolicy.inputTextSizeSp(
                rawTitle = "",
                hasFocus = false,
                normalSizeSp = 38f,
                hintSizeSp = 20f
            )
        )
        assertEquals(
            38f,
            LauncherFolderTitlePolicy.inputTextSizeSp(
                rawTitle = "",
                hasFocus = true,
                normalSizeSp = 38f,
                hintSizeSp = 20f
            )
        )
        assertEquals(
            38f,
            LauncherFolderTitlePolicy.inputTextSizeSp(
                rawTitle = "Ảnh",
                hasFocus = false,
                normalSizeSp = 38f,
                hintSizeSp = 20f
            )
        )
    }

    @Test
    fun titleTapHandling_onlyInterceptsTapWhenInputIsNotFocused() {
        assertTrue(LauncherFolderTitlePolicy.shouldHandleTitleTap(hasFocus = false))
        assertFalse(LauncherFolderTitlePolicy.shouldHandleTitleTap(hasFocus = true))
    }
}

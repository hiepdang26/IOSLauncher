package com.vhmsoft.launcherios26.core

object LauncherFolderTitlePolicy {
    private val legacyUntitledNames = setOf("untitled")

    fun isUnnamed(rawTitle: String?): Boolean {
        val title = rawTitle?.trim().orEmpty()
        return title.isEmpty() || title.lowercase() in legacyUntitledNames
    }

    fun homeTitle(rawTitle: String?, defaultFolderName: String): String =
        if (isUnnamed(rawTitle)) defaultFolderName else rawTitle!!.trim()

    fun editableText(rawTitle: String?): String =
        if (isUnnamed(rawTitle)) "" else rawTitle!!.trim()

    fun storedTitle(input: String?): String = input?.trim().orEmpty()

    fun inputHint(rawTitle: String?, hasFocus: Boolean, unnamedHint: String): String =
        if (isUnnamed(rawTitle) && !hasFocus) unnamedHint else ""

    fun inputTextSizeSp(
        rawTitle: String?,
        hasFocus: Boolean,
        normalSizeSp: Float,
        hintSizeSp: Float
    ): Float =
        if (isUnnamed(rawTitle) && !hasFocus) hintSizeSp else normalSizeSp

    fun shouldHandleTitleTap(hasFocus: Boolean): Boolean = !hasFocus
}

package com.cloudx.ios17.features.launcher

object LauncherBlurEffectPolicy {
    const val SEARCH_BACKGROUND_CONTENT_ALPHA = 0f
    const val SEARCH_TOUCH_BLOCKER_ALPHA = 0.22f

    fun overlayAlpha(masterEnabled: Boolean, targetEnabled: Boolean): Float {
        return if (masterEnabled && targetEnabled) 1f else 0f
    }

    fun folderOverlayAlpha(
        masterEnabled: Boolean,
        folderEnabled: Boolean,
        liquidGlassEnabled: Boolean
    ): Float {
        return 1f
    }

    fun folderBackgroundContentAlpha(
        masterEnabled: Boolean,
        folderEnabled: Boolean,
        liquidGlassEnabled: Boolean = false
    ): Float {
        return FolderOpenLayoutPolicy.BACKGROUND_CONTENT_ALPHA
    }

    fun searchBackgroundContentAlpha(masterEnabled: Boolean, searchEnabled: Boolean): Float {
        return SEARCH_BACKGROUND_CONTENT_ALPHA
    }

    fun searchTouchBlockerAlpha(masterEnabled: Boolean, searchEnabled: Boolean): Float {
        return if (masterEnabled && searchEnabled) SEARCH_TOUCH_BLOCKER_ALPHA else 0f
    }
}

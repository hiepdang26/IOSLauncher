package com.cloudx.ios17.features.launcher

object LauncherBlurEffectPolicy {
    const val SEARCH_BACKGROUND_CONTENT_ALPHA = 0f
    const val SEARCH_TOUCH_BLOCKER_ALPHA = 0.22f

    fun lightModeTargetBlurEnabled(
        masterEnabled: Boolean,
        targetEnabled: Boolean,
        darkModeEnabled: Boolean
    ): Boolean = masterEnabled && targetEnabled && !darkModeEnabled

    fun overlayAlpha(
        masterEnabled: Boolean,
        targetEnabled: Boolean,
        darkModeEnabled: Boolean = false
    ): Float {
        return if (lightModeTargetBlurEnabled(masterEnabled, targetEnabled, darkModeEnabled)) 1f else 0f
    }

    fun folderOverlayAlpha(
        masterEnabled: Boolean,
        folderEnabled: Boolean,
        liquidGlassEnabled: Boolean,
        darkModeEnabled: Boolean = false
    ): Float {
        return overlayAlpha(
            masterEnabled = masterEnabled,
            targetEnabled = folderEnabled,
            darkModeEnabled = darkModeEnabled
        )
    }

    fun folderBackgroundContentAlpha(
        masterEnabled: Boolean,
        folderEnabled: Boolean,
        liquidGlassEnabled: Boolean = false,
        darkModeEnabled: Boolean = false
    ): Float {
        return if (lightModeTargetBlurEnabled(masterEnabled, folderEnabled, darkModeEnabled)) {
            FolderOpenLayoutPolicy.BACKGROUND_CONTENT_ALPHA
        } else {
            1f
        }
    }

    fun searchBackgroundContentAlpha(masterEnabled: Boolean, searchEnabled: Boolean): Float {
        return SEARCH_BACKGROUND_CONTENT_ALPHA
    }

    fun searchChromeStyleEnabled(
        searchBlurEnabled: Boolean,
        darkModeEnabled: Boolean = false
    ): Boolean {
        return if (darkModeEnabled) {
            searchBlurEnabled
        } else {
            !searchBlurEnabled
        }
    }

    fun searchTouchBlockerAlpha(
        masterEnabled: Boolean,
        searchEnabled: Boolean,
        darkModeEnabled: Boolean = false
    ): Float {
        return if (lightModeTargetBlurEnabled(masterEnabled, searchEnabled, darkModeEnabled)) {
            SEARCH_TOUCH_BLOCKER_ALPHA
        } else {
            0f
        }
    }
}

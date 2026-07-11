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
        darkModeEnabled: Boolean = false,
        liquidGlassEnabled: Boolean = false
    ): Float {
        if (liquidGlassEnabled) return 0f
        return if (lightModeTargetBlurEnabled(masterEnabled, targetEnabled, darkModeEnabled)) 1f else 0f
    }

    fun folderOverlayAlpha(
        masterEnabled: Boolean,
        folderEnabled: Boolean,
        liquidGlassEnabled: Boolean,
        darkModeEnabled: Boolean = false
    ): Float {
        if (liquidGlassEnabled) return 1f
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
    ): Float =
        if (liquidGlassEnabled) {
            FolderOpenLayoutPolicy.LIQUID_GLASS_BACKGROUND_CONTENT_ALPHA
        } else {
            FolderOpenLayoutPolicy.BACKGROUND_CONTENT_ALPHA
        }

    fun searchBackgroundContentAlpha(masterEnabled: Boolean, searchEnabled: Boolean): Float {
        return SEARCH_BACKGROUND_CONTENT_ALPHA
    }

    fun searchTouchBlockerAlpha(
        masterEnabled: Boolean,
        searchEnabled: Boolean,
        darkModeEnabled: Boolean = false,
        liquidGlassEnabled: Boolean = false
    ): Float {
        if (liquidGlassEnabled) return 0f
        return if (lightModeTargetBlurEnabled(masterEnabled, searchEnabled, darkModeEnabled)) {
            SEARCH_TOUCH_BLOCKER_ALPHA
        } else {
            0f
        }
    }
}

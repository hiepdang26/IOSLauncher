package com.cloudx.ios17.core

import android.os.Build

object LauncherFolderPreviewBackgroundPolicy {
    fun shouldUseParentBlur(
        liquidGlassEnabled: Boolean,
        folderBlurEnabled: Boolean = false,
        darkModeEnabled: Boolean
    ): Boolean = folderBlurEnabled && !liquidGlassEnabled && !darkModeEnabled

    fun shouldUseRealtimeLiquidGlass(
        liquidGlassEnabled: Boolean,
        folderBlurEnabled: Boolean = true,
        darkModeEnabled: Boolean = false,
        sdkInt: Int = Build.VERSION.SDK_INT
    ): Boolean = folderBlurEnabled &&
        !darkModeEnabled &&
        LauncherRealtimeLiquidGlassPolicy.shouldUseRealtimeLiquidGlass(
            liquidGlassEnabled = liquidGlassEnabled,
            sdkInt = sdkInt
        )

    fun shouldDrawBitmapBackground(realtimeLiquidGlassActive: Boolean): Boolean =
        !realtimeLiquidGlassActive
}

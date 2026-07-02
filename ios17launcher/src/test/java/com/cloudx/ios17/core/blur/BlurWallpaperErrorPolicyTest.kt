package com.cloudx.ios17.core.blur

import org.junit.Assert.assertFalse
import org.junit.Test

class BlurWallpaperErrorPolicyTest {
    @Test
    fun wallpaperReadPermissionFailure_isSilent() {
        assertFalse(
            BlurWallpaperErrorPolicy.shouldShowLoadFailureToast(
                "Permission android.permission.READ_EXTERNAL_STORAGE denied"
            )
        )
    }

    @Test
    fun wallpaperLoadFailureDebugToast_isDisabled() {
        assertFalse(
            BlurWallpaperErrorPolicy.shouldShowLoadFailureToast("Unable to read wallpaper")
        )
    }
}

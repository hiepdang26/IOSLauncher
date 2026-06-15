package com.vhmsoft.launcherios26.ui.settings.feature

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.vhmsoft.launcherios26.R

enum class LauncherExternalFeatureCode(val value: String) {
    LOCK_SCREEN("lock_screen"),
    CONTROL_CENTER("control_center"),
    ASSISTIVE_TOUCH("assistive_touch")
}

data class LauncherExternalFeature(
    val code: LauncherExternalFeatureCode,
    @param:StringRes @field:StringRes val titleRes: Int,
    @param:StringRes @field:StringRes val messageRes: Int,
    @param:StringRes @field:StringRes val packageNameRes: Int,
    @param:DrawableRes @field:DrawableRes val previewDrawableRes: Int
)

/**
 * Single source of truth for Settings rows that open companion launcher packages.
 */
object LauncherExternalFeatureCatalog {
    val lockScreen = LauncherExternalFeature(
        code = LauncherExternalFeatureCode.LOCK_SCREEN,
        titleRes = R.string.settings_lock_screen,
        messageRes = R.string.lock_screen_download_message,
        packageNameRes = R.string.external_package_lock_screen,
        previewDrawableRes = R.drawable.bg_lock_screen_download_preview
    )

    val controlCenter = LauncherExternalFeature(
        code = LauncherExternalFeatureCode.CONTROL_CENTER,
        titleRes = R.string.settings_control_center,
        messageRes = R.string.control_center_download_message,
        packageNameRes = R.string.external_package_control_center,
        previewDrawableRes = R.drawable.bg_control_center_download_preview
    )

    val assistiveTouch = LauncherExternalFeature(
        code = LauncherExternalFeatureCode.ASSISTIVE_TOUCH,
        titleRes = R.string.settings_assistive_touch,
        messageRes = R.string.assistive_touch_download_message,
        packageNameRes = R.string.external_package_assistive_touch,
        previewDrawableRes = R.drawable.bg_assistive_touch_download_preview
    )

    val all: List<LauncherExternalFeature> = listOf(
        lockScreen,
        controlCenter,
        assistiveTouch
    )

    fun requireFeature(code: LauncherExternalFeatureCode): LauncherExternalFeature {
        return all.firstOrNull { feature -> feature.code == code }
            ?: error("Unsupported external feature code: ${code.value}")
    }
}

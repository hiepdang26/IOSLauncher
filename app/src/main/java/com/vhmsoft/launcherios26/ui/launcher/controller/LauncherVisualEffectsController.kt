package com.vhmsoft.launcherios26.ui.launcher.controller

import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import com.vhmsoft.launcherios26.databinding.ActivityIosLauncherBinding

class LauncherVisualEffectsController(
    private val binding: ActivityIosLauncherBinding
) {
    private var blurSettings = LauncherBlurSettings()

    fun setBlurEnabled(enabled: Boolean) {
        setBlurSettings(blurSettings.copy(dockEnabled = enabled))
    }

    fun setBlurSettings(settings: LauncherBlurSettings) {
        blurSettings = settings
    }

    fun applyHomeBlur() {
        applyHomeBlur(enabled = true)
    }

    fun applyFolderBlur() {
        applyHomeBlur(enabled = blurSettings.folderBlurActive)
    }

    fun applyWidgetBlur() {
        applyHomeBlur(enabled = blurSettings.widgetBlurActive)
    }

    fun applySearchBlur() {
        applyHomeBlur(enabled = blurSettings.searchBlurActive)
    }

    private fun applyHomeBlur(enabled: Boolean) {
        if (!enabled) {
            clearHomeBlur()
            return
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            binding.workspace.homeContent.setRenderEffect(
                RenderEffect.createBlurEffect(HOME_BLUR_RADIUS, HOME_BLUR_RADIUS, Shader.TileMode.CLAMP)
            )
        } else {
            binding.workspace.homeContent.alpha = LEGACY_HOME_BLUR_ALPHA
        }
    }

    fun clearHomeBlur() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            binding.workspace.homeContent.setRenderEffect(null)
        } else {
            binding.workspace.homeContent.alpha = 1f
        }
    }

    private companion object {
        const val HOME_BLUR_RADIUS = 18f
        const val LEGACY_HOME_BLUR_ALPHA = 0.45f
    }
}

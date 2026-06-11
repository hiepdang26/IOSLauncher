package com.vhmsoft.launcherios26.ui.launcher.controller

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.vhmsoft.launcherios26.databinding.ActivityIosLauncherBinding
import com.vhmsoft.launcherios26.ui.launcher.workspace.AppLibraryGroupUiModel
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherIconAdapter

class LauncherCategoryDetailController(
    private val activity: AppCompatActivity,
    private val binding: ActivityIosLauncherBinding,
    private val categoryDetailAdapter: LauncherIconAdapter,
    private val keyboardController: LauncherKeyboardController,
    private val dismissAppOptions: () -> Unit,
    private val clearPageIndicatorCallbacks: () -> Unit,
    private val applySystemUi: () -> Unit
) {
    fun show(group: AppLibraryGroupUiModel) {
        if (group.apps.isEmpty()) return

        dismissAppOptions()
        keyboardController.hideKeyboard(binding.workspace.searchEditText)
        binding.workspace.categoryDetailTitle.text = group.title
        categoryDetailAdapter.submitApps(group.apps)
        clearPageIndicatorCallbacks()
        binding.workspace.pageIndicator.visibility = View.GONE

        binding.workspace.categoryDetailOverlay.apply {
            animate().cancel()
            alpha = 0f
            translationY = dp(18).toFloat()
            visibility = View.VISIBLE
            animate()
                .alpha(1f)
                .translationY(0f)
                .setDuration(180L)
                .start()
        }
        applySystemUi()
    }

    fun hide() {
        if (binding.workspace.categoryDetailOverlay.visibility != View.VISIBLE) return

        binding.workspace.categoryDetailOverlay.animate()
            .alpha(0f)
            .translationY(dp(18).toFloat())
            .setDuration(150L)
            .withEndAction {
                binding.workspace.categoryDetailOverlay.visibility = View.GONE
                binding.workspace.categoryDetailOverlay.translationY = 0f
                categoryDetailAdapter.submitApps(emptyList())
                applySystemUi()
            }
            .start()
    }

    private fun dp(value: Int): Int {
        return (value * activity.resources.displayMetrics.density).toInt()
    }
}

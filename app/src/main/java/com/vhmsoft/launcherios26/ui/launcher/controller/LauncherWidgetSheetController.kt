package com.vhmsoft.launcherios26.ui.launcher.controller

import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.vhmsoft.launcherios26.databinding.ActivityIosLauncherBinding

class LauncherWidgetSheetController(
    private val activity: AppCompatActivity,
    private val binding: ActivityIosLauncherBinding,
    private val applySystemUi: () -> Unit
) {
    private var sheetDownY = 0f

    fun toggleEditWidgetPrompt() {
        if (binding.workspace.editWidgetPrompt.visibility == View.VISIBLE) {
            hideEditWidgetPrompt()
        } else {
            showEditWidgetPrompt()
        }
    }

    fun hideEditWidgetPrompt() {
        if (binding.workspace.editWidgetPrompt.visibility != View.VISIBLE) return

        binding.workspace.editWidgetPrompt.animate()
            .alpha(0f)
            .scaleX(0.96f)
            .scaleY(0.96f)
            .translationY(-dp(8).toFloat())
            .setDuration(120L)
            .withEndAction {
                binding.workspace.editWidgetPrompt.visibility = View.GONE
                binding.workspace.editWidgetPrompt.translationY = 0f
                binding.workspace.editWidgetPrompt.scaleX = 1f
                binding.workspace.editWidgetPrompt.scaleY = 1f
            }
            .start()
    }

    fun showWidgetSheet() {
        binding.workspace.widgetSheetOverlay.apply {
            animate().cancel()
            alpha = 0f
            visibility = View.VISIBLE
        }
        binding.workspace.widgetSheet.post {
            binding.workspace.widgetSheet.translationY = binding.workspace.widgetSheet.height.toFloat()
            binding.workspace.widgetSheetOverlay.animate()
                .alpha(1f)
                .setDuration(140L)
                .start()
            binding.workspace.widgetSheet.animate()
                .translationY(0f)
                .setDuration(240L)
                .start()
        }
    }

    fun hideWidgetSheet() {
        if (binding.workspace.widgetSheetOverlay.visibility != View.VISIBLE) return

        binding.workspace.widgetSheet.animate()
            .translationY(binding.workspace.widgetSheet.height.toFloat())
            .setDuration(180L)
            .start()
        binding.workspace.widgetSheetOverlay.animate()
            .alpha(0f)
            .setStartDelay(60L)
            .setDuration(140L)
            .withEndAction {
                binding.workspace.widgetSheetOverlay.visibility = View.GONE
                binding.workspace.widgetSheetOverlay.alpha = 1f
                binding.workspace.widgetSheet.translationY = 0f
                applySystemUi()
            }
            .start()
    }

    fun handleWidgetSheetDrag(event: MotionEvent): Boolean {
        return when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                sheetDownY = event.rawY
                binding.workspace.widgetSheet.animate().cancel()
                true
            }

            MotionEvent.ACTION_MOVE -> {
                val dy = (event.rawY - sheetDownY).coerceAtLeast(0f)
                binding.workspace.widgetSheet.translationY = dy * 0.72f
                true
            }

            MotionEvent.ACTION_UP,
            MotionEvent.ACTION_CANCEL -> {
                val dy = event.rawY - sheetDownY
                if (dy > dp(WIDGET_SHEET_DISMISS_DRAG_DP)) {
                    hideWidgetSheet()
                } else {
                    binding.workspace.widgetSheet.animate()
                        .translationY(0f)
                        .setDuration(140L)
                        .start()
                }
                true
            }

            else -> true
        }
    }

    private fun showEditWidgetPrompt() {
        binding.workspace.editWidgetPrompt.apply {
            animate().cancel()
            alpha = 0f
            scaleX = 0.96f
            scaleY = 0.96f
            translationY = -dp(8).toFloat()
            visibility = View.VISIBLE
            animate()
                .alpha(1f)
                .scaleX(1f)
                .scaleY(1f)
                .translationY(0f)
                .setDuration(160L)
                .start()
        }
    }

    private fun dp(value: Int): Int {
        return (value * activity.resources.displayMetrics.density).toInt()
    }

    private companion object {
        const val WIDGET_SHEET_DISMISS_DRAG_DP = 86
    }
}

package com.vhmsoft.launcherios26.ui.launcher.controller

import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import androidx.appcompat.app.AppCompatActivity
import com.cloudx.ios17.features.launcher.TodayWidgetDragUpdatePolicy
import com.cloudx.ios17.features.launcher.TodayWidgetSheetPolicy
import com.vhmsoft.launcherios26.databinding.ActivityIosLauncherBinding

class LauncherWidgetSheetController(
    private val activity: AppCompatActivity,
    private val binding: ActivityIosLauncherBinding,
    private val visualEffectsController: LauncherVisualEffectsController,
    private val applySystemUi: () -> Unit
) {
    private var sheetDownY = 0f
    private var sheetStartTranslationY = 0f
    private var sheetDragging = false
    private val sheetTouchSlop = ViewConfiguration.get(activity).scaledTouchSlop.toFloat()

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
        visualEffectsController.applyWidgetBlur()
        binding.workspace.widgetSheetOverlay.apply {
            animate().cancel()
            alpha = 0f
            visibility = View.VISIBLE
        }
        binding.workspace.widgetSheet.post {
            binding.workspace.widgetSheet.translationY = binding.workspace.widgetSheet.height.toFloat()
            sheetDragging = false
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
                visualEffectsController.clearHomeBlur()
                applySystemUi()
            }
            .start()
    }

    fun handleWidgetSheetDrag(event: MotionEvent): Boolean {
        return when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                sheetDownY = event.rawY
                sheetStartTranslationY = binding.workspace.widgetSheet.translationY
                sheetDragging = false
                binding.workspace.widgetSheet.animate().cancel()
                binding.workspace.widgetSheet.parent?.requestDisallowInterceptTouchEvent(true)
                true
            }

            MotionEvent.ACTION_MOVE -> {
                val dy = event.rawY - sheetDownY
                if (!sheetDragging) {
                    if (!TodayWidgetDragUpdatePolicy.shouldStartSheetDrag(dy, sheetTouchSlop)) {
                        return true
                    }
                    sheetDragging = true
                }
                val sheetHeight = binding.workspace.widgetSheet.height
                    .takeIf { height -> height > 0 }
                    ?: activity.resources.displayMetrics.heightPixels
                binding.workspace.widgetSheet.translationY = TodayWidgetSheetPolicy.dragTranslation(
                    startTranslation = sheetStartTranslationY,
                    deltaY = dy,
                    minTranslation = -dp(WIDGET_SHEET_EXPAND_DRAG_DP).toFloat(),
                    maxTranslation = sheetHeight * WIDGET_SHEET_MAX_DISMISS_RATIO
                )
                true
            }

            MotionEvent.ACTION_UP,
            MotionEvent.ACTION_CANCEL -> {
                binding.workspace.widgetSheet.parent?.requestDisallowInterceptTouchEvent(false)
                if (sheetDragging) {
                    when (TodayWidgetSheetPolicy.snapTarget(
                        binding.workspace.widgetSheet.translationY,
                        binding.workspace.widgetSheet.height.toFloat()
                    )) {
                        TodayWidgetSheetPolicy.SnapTarget.EXPANDED -> {
                            binding.workspace.widgetSheet.animate()
                                .translationY(-dp(WIDGET_SHEET_EXPAND_DRAG_DP).toFloat())
                                .setDuration(140L)
                                .start()
                        }
                        TodayWidgetSheetPolicy.SnapTarget.RESTING -> {
                            binding.workspace.widgetSheet.animate()
                                .translationY(0f)
                                .setDuration(140L)
                                .start()
                        }
                        TodayWidgetSheetPolicy.SnapTarget.DISMISS -> hideWidgetSheet()
                    }
                }
                sheetDragging = false
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
        const val WIDGET_SHEET_EXPAND_DRAG_DP = 128
        const val WIDGET_SHEET_MAX_DISMISS_RATIO = 0.7f
    }
}

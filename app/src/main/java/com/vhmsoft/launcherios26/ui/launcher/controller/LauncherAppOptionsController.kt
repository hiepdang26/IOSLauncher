package com.vhmsoft.launcherios26.ui.launcher.controller

import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import androidx.appcompat.app.AppCompatActivity
import com.vhmsoft.launcherios26.R
import com.vhmsoft.launcherios26.databinding.ActivityIosLauncherBinding
import com.vhmsoft.launcherios26.databinding.PopupLauncherAppOptionsBinding
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherIconUiModel

class LauncherAppOptionsController(
    private val activity: AppCompatActivity,
    private val binding: ActivityIosLauncherBinding,
    private val visualEffectsController: LauncherVisualEffectsController,
    private val onAppInfoClicked: (LauncherIconUiModel) -> Unit,
    private val onHideClicked: (LauncherIconUiModel) -> Unit,
    private val onEditHomeClicked: () -> Unit,
    private val onDeleteClicked: (LauncherIconUiModel) -> Unit
) {
    private var popup: PopupWindow? = null

    fun show(item: LauncherIconUiModel, anchor: View) {
        dismiss()

        val optionBinding = PopupLauncherAppOptionsBinding.inflate(LayoutInflater.from(activity))
        val activePopup = PopupWindow(
            optionBinding.root,
            activity.resources.getDimensionPixelSize(R.dimen.app_option_popup_width),
            ViewGroup.LayoutParams.WRAP_CONTENT,
            true
        ).apply {
            setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
            isOutsideTouchable = true
            elevation = activity.resources.getDimension(R.dimen.app_option_popup_elevation)
            setOnDismissListener {
                hideContextOverlay()
                if (popup === this) {
                    popup = null
                }
            }
        }

        optionBinding.appInfoButton.setOnClickListener {
            activePopup.dismiss()
            onAppInfoClicked(item)
        }
        optionBinding.hideButton.setOnClickListener {
            activePopup.dismiss()
            onHideClicked(item)
        }
        optionBinding.editHomeButton.setOnClickListener {
            activePopup.dismiss()
            onEditHomeClicked()
        }
        optionBinding.deleteButton.setOnClickListener {
            activePopup.dismiss()
            onDeleteClicked(item)
        }

        popup = activePopup
        optionBinding.root.measure(
            View.MeasureSpec.makeMeasureSpec(activity.resources.displayMetrics.widthPixels, View.MeasureSpec.AT_MOST),
            View.MeasureSpec.makeMeasureSpec(activity.resources.displayMetrics.heightPixels, View.MeasureSpec.AT_MOST)
        )

        showContextOverlay()
        showSelectedIconPreview(item, anchor)
        activePopup.showAtLocation(
            binding.workspace.root,
            Gravity.NO_GRAVITY,
            popupX(anchor),
            popupY(anchor, optionBinding.root)
        )
    }

    fun dismiss() {
        popup?.dismiss()
    }

    fun isShowing(): Boolean {
        return popup != null
    }

    private fun showSelectedIconPreview(item: LauncherIconUiModel, anchor: View) {
        if (anchor === binding.workspace.root) return

        binding.workspace.selectedIconImage.setImageDrawable(item.icon)
        binding.workspace.selectedIconLabel.text = item.label

        val anchorLocation = IntArray(2)
        val rootLocation = IntArray(2)
        anchor.getLocationOnScreen(anchorLocation)
        binding.workspace.root.getLocationOnScreen(rootLocation)

        val previewWidth = binding.workspace.selectedIconPreview.width.takeIf { it > 0 } ?: dp(94)
        val previewHeight = binding.workspace.selectedIconPreview.height.takeIf { it > 0 } ?: dp(118)
        val rootWidth = binding.workspace.root.width.takeIf { it > 0 } ?: activity.resources.displayMetrics.widthPixels
        val rootHeight = binding.workspace.root.height.takeIf { it > 0 } ?: activity.resources.displayMetrics.heightPixels
        val left = (anchorLocation[0] - rootLocation[0] + anchor.width / 2 - previewWidth / 2)
            .coerceIn(dp(4), rootWidth - previewWidth - dp(4))
        val top = (anchorLocation[1] - rootLocation[1] - dp(2))
            .coerceIn(dp(12), rootHeight - previewHeight - dp(12))

        binding.workspace.selectedIconPreview.layoutParams =
            (binding.workspace.selectedIconPreview.layoutParams as android.widget.FrameLayout.LayoutParams).apply {
                leftMargin = left
                topMargin = top
            }
        binding.workspace.selectedIconPreview.apply {
            animate().cancel()
            alpha = 0f
            scaleX = 1.03f
            scaleY = 1.03f
            visibility = View.VISIBLE
            animate()
                .alpha(1f)
                .scaleX(1.08f)
                .scaleY(1.08f)
                .setDuration(120L)
                .start()
        }
    }

    private fun hideSelectedIconPreview() {
        binding.workspace.selectedIconPreview.animate()
            .alpha(0f)
            .scaleX(1f)
            .scaleY(1f)
            .setDuration(110L)
            .withEndAction {
                binding.workspace.selectedIconPreview.visibility = View.GONE
            }
            .start()
    }

    private fun showContextOverlay() {
        binding.workspace.contextOverlay.apply {
            alpha = 0f
            visibility = View.VISIBLE
            animate().alpha(1f).setDuration(120L).start()
        }
        visualEffectsController.applyHomeBlur()
    }

    private fun hideContextOverlay() {
        hideSelectedIconPreview()
        binding.workspace.contextOverlay.animate()
            .alpha(0f)
            .setDuration(120L)
            .withEndAction {
                binding.workspace.contextOverlay.visibility = View.GONE
                if (binding.workspace.searchOverlay.visibility != View.VISIBLE) {
                    visualEffectsController.clearHomeBlur()
                }
            }
            .start()
    }

    private fun popupX(anchor: View): Int {
        val anchorLocation = IntArray(2)
        anchor.getLocationOnScreen(anchorLocation)
        val popupWidth = activity.resources.getDimensionPixelSize(R.dimen.app_option_popup_width)
        val screenWidth = activity.resources.displayMetrics.widthPixels
        val margin = dp(16)
        return anchorLocation[0].coerceIn(margin, screenWidth - popupWidth - margin)
    }

    private fun popupY(anchor: View, popupContent: View): Int {
        val anchorLocation = IntArray(2)
        anchor.getLocationOnScreen(anchorLocation)
        val popupHeight = popupContent.measuredHeight
        val screenHeight = activity.resources.displayMetrics.heightPixels
        val margin = dp(16)
        val desiredY = anchorLocation[1] + anchor.height + dp(8)
        return if (desiredY + popupHeight > screenHeight - margin) {
            (anchorLocation[1] - popupHeight - dp(8)).coerceAtLeast(margin)
        } else {
            desiredY
        }
    }

    private fun dp(value: Int): Int {
        return (value * activity.resources.displayMetrics.density).toInt()
    }
}

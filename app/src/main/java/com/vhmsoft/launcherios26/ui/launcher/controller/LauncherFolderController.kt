package com.vhmsoft.launcherios26.ui.launcher.controller

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.vhmsoft.launcherios26.databinding.ActivityIosLauncherBinding
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherHomeItemUiModel
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherHomeLayoutBuilder
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherIconAdapter

class LauncherFolderController(
    private val activity: AppCompatActivity,
    private val binding: ActivityIosLauncherBinding,
    private val folderContentAdapter: LauncherIconAdapter,
    private val visualEffectsController: LauncherVisualEffectsController,
    private val dismissAppOptions: () -> Unit,
    private val clearPageIndicatorCallbacks: () -> Unit,
    private val isEditingHome: () -> Boolean,
    private val isCurrentPageLibrary: () -> Boolean,
    private val showSearchTrigger: (Boolean) -> Unit
) {
    private var openFolderId: String? = null

    fun show(folder: LauncherHomeItemUiModel.Folder) {
        dismissAppOptions()
        clearPageIndicatorCallbacks()
        binding.workspace.pageIndicator.visibility = View.GONE
        binding.workspace.searchPill.visibility = View.GONE
        openFolderId = folder.id
        binding.workspace.folderTitle.text = folderTitle(folder)
        folderContentAdapter.setEditing(isEditingHome())
        folderContentAdapter.submitApps(folder.apps)
        binding.workspace.folderRecyclerView.scrollToPosition(0)
        visualEffectsController.applyFolderBlur()

        binding.workspace.folderOverlay.apply {
            animate().cancel()
            alpha = 0f
            visibility = View.VISIBLE
            animate()
                .alpha(1f)
                .setDuration(140L)
                .start()
        }
        binding.workspace.folderContentPanel.apply {
            animate().cancel()
            scaleX = 0.86f
            scaleY = 0.86f
            alpha = 0f
            animate()
                .alpha(1f)
                .scaleX(1f)
                .scaleY(1f)
                .setDuration(190L)
                .start()
        }
        binding.workspace.folderTitle.apply {
            animate().cancel()
            alpha = 0f
            translationY = dp(10).toFloat()
            animate()
                .alpha(1f)
                .translationY(0f)
                .setDuration(180L)
                .start()
        }
    }

    fun hide(animate: Boolean = true) {
        if (binding.workspace.folderOverlay.visibility != View.VISIBLE) {
            openFolderId = null
            return
        }

        openFolderId = null
        if (!animate) {
            binding.workspace.folderContentPanel.animate().cancel()
            binding.workspace.folderTitle.animate().cancel()
            binding.workspace.folderOverlay.animate().cancel()
            binding.workspace.folderOverlay.visibility = View.GONE
            binding.workspace.folderOverlay.alpha = 1f
            binding.workspace.folderContentPanel.apply {
                alpha = 1f
                scaleX = 1f
                scaleY = 1f
            }
            binding.workspace.folderTitle.apply {
                alpha = 1f
                translationY = 0f
            }
            folderContentAdapter.submitApps(emptyList())
            if (binding.workspace.searchOverlay.visibility != View.VISIBLE &&
                binding.workspace.contextOverlay.visibility != View.VISIBLE
            ) {
                visualEffectsController.clearHomeBlur()
            }
            if (!isEditingHome() && !isCurrentPageLibrary()) {
                showSearchTrigger(true)
            }
            return
        }

        binding.workspace.folderContentPanel.animate()
            .scaleX(0.92f)
            .scaleY(0.92f)
            .alpha(0f)
            .setDuration(130L)
            .start()
        binding.workspace.folderTitle.animate()
            .alpha(0f)
            .translationY(dp(8).toFloat())
            .setDuration(110L)
            .start()
        binding.workspace.folderOverlay.animate()
            .alpha(0f)
            .setStartDelay(40L)
            .setDuration(130L)
            .withEndAction {
                binding.workspace.folderOverlay.visibility = View.GONE
                binding.workspace.folderOverlay.alpha = 1f
                binding.workspace.folderContentPanel.apply {
                    alpha = 1f
                    scaleX = 1f
                    scaleY = 1f
                }
                binding.workspace.folderTitle.apply {
                    alpha = 1f
                    translationY = 0f
                }
                folderContentAdapter.submitApps(emptyList())
                if (binding.workspace.searchOverlay.visibility != View.VISIBLE &&
                    binding.workspace.contextOverlay.visibility != View.VISIBLE
                ) {
                    visualEffectsController.clearHomeBlur()
                }
                if (!isEditingHome() && !isCurrentPageLibrary()) {
                    showSearchTrigger(true)
                }
            }
            .start()
    }

    fun updateContent(items: List<LauncherHomeItemUiModel>) {
        val folderId = openFolderId ?: return
        val folder = items
            .filterIsInstance<LauncherHomeItemUiModel.Folder>()
            .firstOrNull { item -> item.id == folderId }
        if (folder == null) {
            hide()
            return
        }

        binding.workspace.folderTitle.text = folderTitle(folder)
        folderContentAdapter.submitApps(folder.apps)
    }

    fun currentFolderId(): String? {
        return openFolderId
    }

    fun setEditing(enabled: Boolean) {
        folderContentAdapter.setEditing(enabled)
    }

    private fun folderTitle(folder: LauncherHomeItemUiModel.Folder): String {
        return if (folder.title == LauncherHomeLayoutBuilder.DEFAULT_FOLDER_TITLE) {
            "Thư mục chưa đặt tên"
        } else {
            folder.title
        }
    }

    private fun dp(value: Int): Int {
        return (value * activity.resources.displayMetrics.density).toInt()
    }
}

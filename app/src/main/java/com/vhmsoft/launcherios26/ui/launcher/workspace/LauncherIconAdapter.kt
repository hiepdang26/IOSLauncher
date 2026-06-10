package com.vhmsoft.launcherios26.ui.launcher.workspace

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.vhmsoft.launcherios26.R
import com.vhmsoft.launcherios26.databinding.ItemLauncherIconBinding
import java.util.Collections
import kotlin.math.max
import kotlin.math.min

class LauncherIconAdapter(
    private val onIconClicked: (LauncherIconUiModel) -> Unit,
    private val onIconLongClicked: (LauncherIconUiModel, View) -> Boolean = { _, _ -> false },
    private val onRemoveClicked: (LauncherIconUiModel) -> Unit = {},
    private val onFolderClicked: (LauncherHomeItemUiModel.Folder) -> Unit = {},
    private val onDragRequested: (RecyclerView.ViewHolder) -> Unit = {},
    private val onOrderChanged: (List<LauncherHomeItemUiModel>) -> Unit = {}
) : RecyclerView.Adapter<LauncherIconAdapter.IconViewHolder>() {
    private val items = mutableListOf<LauncherHomeItemUiModel>()
    private var itemHeightPx: Int = 0
    private var editing = false
    private var pendingDropTarget: PendingDropTarget? = null

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IconViewHolder {
        val binding = ItemLauncherIconBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return IconViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IconViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    override fun getItemId(position: Int): Long = items[position].stableId

    fun submitItems(homeItems: List<LauncherHomeItemUiModel>) {
        items.clear()
        items.addAll(homeItems)
        pendingDropTarget = null
        notifyDataSetChanged()
    }

    fun submitApps(apps: List<LauncherIconUiModel>) {
        submitItems(apps.map { app -> LauncherHomeItemUiModel.App(app) })
    }

    fun setItemHeight(heightPx: Int) {
        if (itemHeightPx == heightPx) return
        itemHeightPx = heightPx
        notifyDataSetChanged()
    }

    fun setEditing(enabled: Boolean) {
        if (editing == enabled) return
        editing = enabled
        notifyDataSetChanged()
    }

    fun isEditing(): Boolean = editing

    fun moveItem(fromPosition: Int, toPosition: Int): Boolean {
        if (fromPosition == RecyclerView.NO_POSITION || toPosition == RecyclerView.NO_POSITION) {
            return false
        }
        if (fromPosition !in items.indices || toPosition !in items.indices) {
            return false
        }

        if (fromPosition < toPosition) {
            for (index in fromPosition until toPosition) {
                Collections.swap(items, index, index + 1)
            }
        } else {
            for (index in fromPosition downTo toPosition + 1) {
                Collections.swap(items, index, index - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
        return true
    }

    fun rememberDropTarget(fromPosition: Int, targetPosition: Int) {
        pendingDropTarget = null
        if (!editing) return
        if (fromPosition !in items.indices || targetPosition !in items.indices) return

        val dragged = items[fromPosition] as? LauncherHomeItemUiModel.App ?: return
        val target = items[targetPosition]
        if (target !is LauncherHomeItemUiModel.App && target !is LauncherHomeItemUiModel.Folder) return
        if (dragged.stableId == target.stableId) return

        pendingDropTarget = PendingDropTarget(
            draggedStableId = dragged.stableId,
            targetStableId = target.stableId
        )
    }

    fun commitPendingDropTarget(): Boolean {
        val target = pendingDropTarget ?: return false
        pendingDropTarget = null

        val draggedIndex = items.indexOfFirst { item -> item.stableId == target.draggedStableId }
        val targetIndex = items.indexOfFirst { item -> item.stableId == target.targetStableId }
        if (draggedIndex == -1 || targetIndex == -1 || draggedIndex == targetIndex) return false

        val dragged = items[draggedIndex] as? LauncherHomeItemUiModel.App ?: return false
        val targetItem = items[targetIndex]
        val updatedTarget = when (targetItem) {
            is LauncherHomeItemUiModel.App -> LauncherHomeItemUiModel.Folder(
                id = "folder_${System.nanoTime()}",
                title = LauncherHomeLayoutBuilder.DEFAULT_FOLDER_TITLE,
                apps = listOf(targetItem.iconItem, dragged.iconItem)
            )

            is LauncherHomeItemUiModel.Folder -> {
                if (targetItem.apps.any { item -> item.app.iconKey == dragged.iconItem.app.iconKey }) {
                    return false
                }
                targetItem.copy(apps = targetItem.apps + dragged.iconItem)
            }
        }

        val newItems = items.toMutableList()
        newItems.removeAt(draggedIndex)
        val adjustedTargetIndex = if (draggedIndex < targetIndex) targetIndex - 1 else targetIndex
        newItems[adjustedTargetIndex] = updatedTarget

        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
        return true
    }

    fun notifyOrderChanged() {
        onOrderChanged(items.toList())
    }

    inner class IconViewHolder(
        private val binding: ItemLauncherIconBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LauncherHomeItemUiModel) {
            binding.item = item
            applyFixedCellSize()
            binding.root.setOnClickListener(null)
            binding.root.setOnLongClickListener(null)
            binding.iconPlate.setOnClickListener {
                if (editing) {
                    if (item is LauncherHomeItemUiModel.Folder) {
                        onFolderClicked(item)
                    }
                    return@setOnClickListener
                }

                when (item) {
                    is LauncherHomeItemUiModel.App -> onIconClicked(item.iconItem)
                    is LauncherHomeItemUiModel.Folder -> onFolderClicked(item)
                }
            }
            binding.iconPlate.setOnLongClickListener {
                if (editing) {
                    onDragRequested(this)
                    true
                } else {
                    when (item) {
                        is LauncherHomeItemUiModel.App -> onIconLongClicked(item.iconItem, binding.iconPlate)
                        is LauncherHomeItemUiModel.Folder -> {
                            onFolderClicked(item)
                            true
                        }
                    }
                }
            }
            binding.removeBadge.visibility = if (editing) View.VISIBLE else View.GONE
            binding.removeBadge.setOnClickListener {
                when (item) {
                    is LauncherHomeItemUiModel.App -> onRemoveClicked(item.iconItem)
                    is LauncherHomeItemUiModel.Folder -> dissolveFolder(item)
                }
            }
            bindIconArtwork(item)
            applyEditAnimation()
            binding.executePendingBindings()
        }

        private fun bindIconArtwork(item: LauncherHomeItemUiModel) {
            when (item) {
                is LauncherHomeItemUiModel.App -> {
                    binding.iconPlate.setBackgroundResource(0)
                    binding.appIcon.visibility = View.VISIBLE
                    binding.folderPreview.visibility = View.GONE
                    binding.appIcon.setImageDrawable(item.iconItem.icon)
                    clearFolderPreviewIcons()
                }

                is LauncherHomeItemUiModel.Folder -> {
                    binding.iconPlate.setBackgroundResource(R.drawable.bg_launcher_folder_preview)
                    binding.appIcon.visibility = View.GONE
                    binding.appIcon.setImageDrawable(null)
                    binding.folderPreview.visibility = View.VISIBLE
                    bindFolderPreviewIcons(item.apps)
                }
            }
        }

        private fun bindFolderPreviewIcons(apps: List<LauncherIconUiModel>) {
            folderPreviewIcons().forEachIndexed { index, imageView ->
                val app = apps.getOrNull(index)
                imageView.visibility = if (app == null) View.INVISIBLE else View.VISIBLE
                imageView.setImageDrawable(app?.icon)
            }
        }

        private fun clearFolderPreviewIcons() {
            folderPreviewIcons().forEach { imageView ->
                imageView.visibility = View.INVISIBLE
                imageView.setImageDrawable(null)
            }
        }

        private fun folderPreviewIcons(): List<ImageView> {
            return listOf(
                binding.folderIcon1,
                binding.folderIcon2,
                binding.folderIcon3,
                binding.folderIcon4,
                binding.folderIcon5,
                binding.folderIcon6,
                binding.folderIcon7,
                binding.folderIcon8,
                binding.folderIcon9
            )
        }

        private fun applyFixedCellSize() {
            if (itemHeightPx <= 0) return

            binding.root.layoutParams = binding.root.layoutParams.apply {
                height = itemHeightPx
            }

            val iconSize = min(dp(66), max(dp(54), itemHeightPx - dp(40)))
            binding.iconPlate.layoutParams = binding.iconPlate.layoutParams.apply {
                width = iconSize
                height = iconSize
            }

            binding.appLabel.layoutParams = binding.appLabel.layoutParams.apply {
                height = max(dp(30), itemHeightPx - iconSize - dp(7))
            }
        }

        private fun dp(value: Int): Int {
            return (value * binding.root.resources.displayMetrics.density).toInt()
        }

        private fun applyEditAnimation() {
            binding.root.animate().cancel()
            if (editing) {
                val startRotation = if (bindingAdapterPosition % 2 == 0) -1.6f else 1.6f
                binding.root.rotation = startRotation
                binding.root.post { animateWiggle(binding.root, startRotation < 0) }
            } else {
                binding.root.rotation = 0f
            }
        }

        private fun animateWiggle(view: View, rotateRight: Boolean) {
            if (!editing || !view.isAttachedToWindow) return

            view.animate()
                .rotation(if (rotateRight) 1.6f else -1.6f)
                .setDuration(95L)
                .setInterpolator(LinearInterpolator())
                .withEndAction { animateWiggle(view, !rotateRight) }
                .start()
        }
    }

    private fun dissolveFolder(folder: LauncherHomeItemUiModel.Folder) {
        val index = items.indexOfFirst { item -> item.stableId == folder.stableId }
        if (index == -1) return

        items.removeAt(index)
        items.addAll(index, folder.apps.map { app -> LauncherHomeItemUiModel.App(app) })
        notifyDataSetChanged()
        notifyOrderChanged()
    }

    private data class PendingDropTarget(
        val draggedStableId: Long,
        val targetStableId: Long
    )
}

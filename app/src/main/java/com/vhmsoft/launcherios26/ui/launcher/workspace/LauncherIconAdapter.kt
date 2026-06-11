package com.vhmsoft.launcherios26.ui.launcher.workspace

import android.animation.ObjectAnimator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import android.view.animation.OvershootInterpolator
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
    private var recentlyUpdatedFolderStableId: Long? = null
    private var activeDragStableId: Long? = null
    private var activeTouchRawX = 0f
    private var activeTouchRawY = 0f
    private var hasActiveTouch = false

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
        items.addAll(LauncherHomeLayoutBuilder.normalize(homeItems))
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
        if (!editing) {
            pendingDropTarget = null
            recentlyUpdatedFolderStableId = null
        }
        notifyDataSetChanged()
    }

    fun isEditing(): Boolean = editing

    fun stableIdAt(position: Int): Long? {
        return items.getOrNull(position)?.stableId
    }

    fun itemAt(position: Int): LauncherHomeItemUiModel? {
        return items.getOrNull(position)
    }

    fun itemByStableId(stableId: Long?): LauncherHomeItemUiModel? {
        if (stableId == null) return null
        return items.firstOrNull { item -> item.stableId == stableId }
    }

    fun updateActiveTouch(rawX: Float, rawY: Float) {
        activeTouchRawX = rawX
        activeTouchRawY = rawY
        hasActiveTouch = true
    }

    fun activeTouchRaw(): Pair<Float, Float>? {
        if (!hasActiveTouch) return null
        return Pair(activeTouchRawX, activeTouchRawY)
    }

    fun clearActiveTouch() {
        hasActiveTouch = false
    }

    fun setActiveDragStableId(stableId: Long?) {
        if (activeDragStableId == stableId) return

        val previousStableId = activeDragStableId
        activeDragStableId = stableId
        notifyDragVisibilityChanged(previousStableId)
        notifyDragVisibilityChanged(stableId)
    }

    fun moveItemByStableIdToEdge(
        draggedStableId: Long?,
        targetPosition: Int,
        insertAfterTarget: Boolean
    ): Boolean {
        return moveItemByStableIdBesideTarget(
            draggedStableId = draggedStableId,
            targetStableId = stableIdAt(targetPosition),
            insertAfterTarget = insertAfterTarget
        )
    }

    fun moveItemByStableIdBesideTarget(
        draggedStableId: Long?,
        targetStableId: Long?,
        insertAfterTarget: Boolean
    ): Boolean {
        val draggedIndex = items.indexOfFirst { item -> item.stableId == draggedStableId }
        val targetIndex = items.indexOfFirst { item -> item.stableId == targetStableId }
        if (draggedIndex == -1 || targetIndex == -1 || draggedIndex == targetIndex) return false

        val dragged = items[draggedIndex]
        if (dragged !is LauncherHomeItemUiModel.App) return false
        val target = items[targetIndex]
        if (target is LauncherHomeItemUiModel.Placeholder) return false

        val targetIndexAfterRemoval = if (draggedIndex < targetIndex) {
            targetIndex - 1
        } else {
            targetIndex
        }
        val finalIndex = targetIndexAfterRemoval + if (insertAfterTarget) 1 else 0
        return moveItemByStableIdToPosition(draggedStableId, finalIndex)
    }

    fun moveItemByStableIdToPosition(draggedStableId: Long?, finalPosition: Int): Boolean {
        val fromPosition = items.indexOfFirst { item -> item.stableId == draggedStableId }
        if (fromPosition == -1 || fromPosition !in items.indices) return false
        val boundedFinalPosition = finalPosition.coerceIn(0, items.lastIndex)
        if (fromPosition == boundedFinalPosition) return false

        val movedItem = items.removeAt(fromPosition)
        items.add(boundedFinalPosition, movedItem)
        pendingDropTarget = null
        notifyItemMoved(fromPosition, boundedFinalPosition)
        return true
    }

    fun moveItem(fromPosition: Int, toPosition: Int): Boolean {
        if (fromPosition == RecyclerView.NO_POSITION || toPosition == RecyclerView.NO_POSITION) {
            return false
        }
        if (fromPosition !in items.indices || toPosition !in items.indices || fromPosition == toPosition) {
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

    fun removeItemByStableId(stableId: Long, notifyOrder: Boolean = true): LauncherHomeItemUiModel? {
        val index = items.indexOfFirst { item -> item.stableId == stableId }
        if (index == -1) return null

        val removedItem = items.removeAt(index)
        notifyItemRemoved(index)
        if (notifyOrder) {
            notifyOrderChanged()
        }
        return removedItem
    }

    fun rememberDropTarget(fromPosition: Int, targetPosition: Int) {
        rememberDropTargetByStableId(stableIdAt(fromPosition), targetPosition)
    }

    fun rememberDropTargetByStableId(draggedStableId: Long?, targetPosition: Int) {
        rememberDropTargetByTargetStableId(
            draggedStableId = draggedStableId,
            targetStableId = stableIdAt(targetPosition)
        )
    }

    fun rememberDropTargetByTargetStableId(draggedStableId: Long?, targetStableId: Long?) {
        val previousTargetStableId = pendingDropTarget?.targetStableId
        pendingDropTarget = null
        if (!editing) return
        if (draggedStableId == null || targetStableId == null) {
            notifyDropTargetChanged(previousTargetStableId)
            return
        }

        val dragged = items.firstOrNull { item -> item.stableId == draggedStableId } as? LauncherHomeItemUiModel.App
        if (dragged == null) {
            notifyDropTargetChanged(previousTargetStableId)
            return
        }
        val target = items.firstOrNull { item -> item.stableId == targetStableId }
        if (target !is LauncherHomeItemUiModel.App && target !is LauncherHomeItemUiModel.Folder) {
            notifyDropTargetChanged(previousTargetStableId)
            return
        }
        if (dragged.stableId == target.stableId) {
            notifyDropTargetChanged(previousTargetStableId)
            return
        }

        pendingDropTarget = PendingDropTarget(
            draggedStableId = dragged.stableId,
            targetStableId = target.stableId
        )
        if (previousTargetStableId != target.stableId) {
            notifyDropTargetChanged(previousTargetStableId)
            notifyDropTargetChanged(target.stableId)
        }
    }

    fun clearPendingDropTarget() {
        val previousTargetStableId = pendingDropTarget?.targetStableId
        pendingDropTarget = null
        notifyDropTargetChanged(previousTargetStableId)
    }

    fun hasPendingDropTarget(): Boolean {
        return pendingDropTarget != null
    }

    fun pendingDropTargetPosition(): Int {
        val targetStableId = pendingDropTarget?.targetStableId ?: return RecyclerView.NO_POSITION
        return items.indexOfFirst { item -> item.stableId == targetStableId }
    }

    fun commitPendingDropTarget(): Boolean {
        val target = pendingDropTarget ?: return false
        pendingDropTarget = null

        val draggedIndex = items.indexOfFirst { item -> item.stableId == target.draggedStableId }
        val targetIndex = items.indexOfFirst { item -> item.stableId == target.targetStableId }
        if (draggedIndex == -1 || targetIndex == -1 || draggedIndex == targetIndex) {
            notifyDropTargetChanged(target.targetStableId)
            return false
        }

        val dragged = items[draggedIndex] as? LauncherHomeItemUiModel.App
        if (dragged == null) {
            notifyDropTargetChanged(target.targetStableId)
            return false
        }
        val targetItem = items[targetIndex]
        val updatedTarget = when (targetItem) {
            is LauncherHomeItemUiModel.App -> LauncherHomeItemUiModel.Folder(
                id = "folder_${System.nanoTime()}",
                title = LauncherHomeLayoutBuilder.DEFAULT_FOLDER_TITLE,
                apps = listOf(targetItem.iconItem, dragged.iconItem)
            )

            is LauncherHomeItemUiModel.Folder -> {
                if (targetItem.apps.any { item -> item.app.iconKey == dragged.iconItem.app.iconKey }) {
                    notifyDropTargetChanged(target.targetStableId)
                    return false
                }
                targetItem.copy(apps = targetItem.apps + dragged.iconItem)
            }

            is LauncherHomeItemUiModel.Placeholder -> {
                notifyDropTargetChanged(target.targetStableId)
                return false
            }
        }

        val newItems = items.toMutableList()
        newItems.removeAt(draggedIndex)
        val adjustedTargetIndex = if (draggedIndex < targetIndex) targetIndex - 1 else targetIndex
        newItems[adjustedTargetIndex] = updatedTarget

        recentlyUpdatedFolderStableId = updatedTarget.stableId
        items.clear()
        items.addAll(LauncherHomeLayoutBuilder.normalize(newItems))
        notifyItemRemoved(draggedIndex)
        notifyItemChanged(adjustedTargetIndex)
        return true
    }

    fun notifyOrderChanged() {
        val normalizedItems = LauncherHomeLayoutBuilder.normalize(items)
        if (normalizedItems != items) {
            items.clear()
            items.addAll(normalizedItems)
            notifyDataSetChanged()
        }
        onOrderChanged(items.toList())
    }

    private fun notifyDropTargetChanged(stableId: Long?) {
        if (stableId == null) return

        val position = items.indexOfFirst { item -> item.stableId == stableId }
        if (position != -1) {
            notifyItemChanged(position)
        }
    }

    inner class IconViewHolder(
        private val binding: ItemLauncherIconBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private var wiggleAnimator: ObjectAnimator? = null

        fun bind(item: LauncherHomeItemUiModel) {
            applyFixedCellSize()
            stopWiggle()
            binding.root.alpha = 1f
            binding.root.scaleX = 1f
            binding.root.scaleY = 1f
            binding.root.translationX = 0f
            binding.root.translationY = 0f
            binding.root.rotation = 0f
            binding.root.setOnClickListener(null)
            binding.root.setOnLongClickListener(null)
            if (item is LauncherHomeItemUiModel.Placeholder) {
                bindPlaceholder()
                return
            }
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
                    is LauncherHomeItemUiModel.Placeholder -> Unit
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

                        is LauncherHomeItemUiModel.Placeholder -> false
                    }
                }
            }
            binding.iconPlate.setOnTouchListener { _, event ->
                updateActiveTouch(event.rawX, event.rawY)
                false
            }
            binding.removeBadge.visibility = if (editing) View.VISIBLE else View.GONE
            binding.removeBadge.setOnClickListener {
                when (item) {
                    is LauncherHomeItemUiModel.App -> onRemoveClicked(item.iconItem)
                    is LauncherHomeItemUiModel.Folder -> dissolveFolder(item)
                    is LauncherHomeItemUiModel.Placeholder -> Unit
                }
            }
            bindIconArtwork(item)
            applyDropTargetState(item)
            applyEditAnimation()
            applyFolderAbsorbAnimation(item)
            applyActiveDragVisibility(item)
        }

        private fun bindPlaceholder() {
            stopWiggle()
            binding.root.animate().cancel()
            binding.root.rotation = 0f
            binding.iconPlate.animate().cancel()
            binding.appIcon.animate().cancel()
            binding.folderPreview.animate().cancel()
            binding.iconPlate.visibility = View.INVISIBLE
            binding.appLabel.visibility = View.INVISIBLE
            binding.removeBadge.visibility = View.GONE
            binding.appIcon.setImageDrawable(null)
            binding.folderPreview.visibility = View.GONE
            clearFolderPreviewIcons()
        }

        private fun bindIconArtwork(item: LauncherHomeItemUiModel) {
            binding.iconPlate.visibility = View.VISIBLE
            binding.appLabel.visibility = View.VISIBLE
            binding.appLabel.text = item.label
            binding.appIcon.contentDescription = item.label
            when (item) {
                is LauncherHomeItemUiModel.App -> {
                    val pendingFolderTarget = isPendingDropTarget(item)
                    binding.iconPlate.setBackgroundResource(
                        if (pendingFolderTarget) R.drawable.bg_launcher_folder_preview else 0
                    )
                    binding.appIcon.setImageDrawable(item.iconItem.icon)
                    binding.appIcon.visibility = View.VISIBLE
                    binding.folderPreview.visibility = View.GONE
                    clearFolderPreviewIcons()
                }

                is LauncherHomeItemUiModel.Folder -> {
                    binding.iconPlate.setBackgroundResource(R.drawable.bg_launcher_folder_preview)
                    binding.appIcon.visibility = View.GONE
                    binding.appIcon.setImageDrawable(null)
                    binding.folderPreview.visibility = View.VISIBLE
                    bindFolderPreviewIcons(
                        if (isPendingDropTarget(item)) {
                            item.apps + listOfNotNull(pendingDraggedIcon())
                        } else {
                            item.apps
                        }
                    )
                }

                is LauncherHomeItemUiModel.Placeholder -> bindPlaceholder()
            }
        }

        private fun applyDropTargetState(item: LauncherHomeItemUiModel) {
            val activeTarget = isPendingDropTarget(item)
            binding.iconPlate.animate().cancel()
            binding.appIcon.animate().cancel()
            binding.folderPreview.animate().cancel()

            if (activeTarget) {
                binding.removeBadge.visibility = View.GONE
                binding.iconPlate.elevation = dp(14).toFloat()
                binding.iconPlate.animate()
                    .scaleX(1.14f)
                    .scaleY(1.14f)
                    .setDuration(145L)
                    .setInterpolator(DecelerateInterpolator())
                    .start()
                binding.appIcon.animate()
                    .scaleX(0.82f)
                    .scaleY(0.82f)
                    .setDuration(145L)
                    .setInterpolator(DecelerateInterpolator())
                    .start()
                binding.folderPreview.animate()
                    .scaleX(0.9f)
                    .scaleY(0.9f)
                    .setDuration(145L)
                    .setInterpolator(DecelerateInterpolator())
                    .start()
            } else {
                binding.iconPlate.elevation = dp(2).toFloat()
                binding.iconPlate.scaleX = 1f
                binding.iconPlate.scaleY = 1f
                binding.appIcon.scaleX = 1f
                binding.appIcon.scaleY = 1f
                binding.folderPreview.scaleX = 1f
                binding.folderPreview.scaleY = 1f
            }
        }

        private fun applyFolderAbsorbAnimation(item: LauncherHomeItemUiModel) {
            if (item.stableId != recentlyUpdatedFolderStableId) return

            recentlyUpdatedFolderStableId = null
            binding.iconPlate.animate().cancel()
            binding.iconPlate.scaleX = 1.22f
            binding.iconPlate.scaleY = 1.22f
            binding.iconPlate.alpha = 0.82f
            binding.iconPlate.animate()
                .scaleX(1f)
                .scaleY(1f)
                .alpha(1f)
                .setDuration(240L)
                .setInterpolator(OvershootInterpolator(1.18f))
                .start()
            binding.folderPreview.alpha = 0f
            binding.folderPreview.animate()
                .alpha(1f)
                .setDuration(160L)
                .setStartDelay(50L)
                .start()
        }

        private fun isPendingDropTarget(item: LauncherHomeItemUiModel): Boolean {
            return editing && pendingDropTarget?.targetStableId == item.stableId
        }

        private fun pendingDraggedIcon(): LauncherIconUiModel? {
            val draggedStableId = pendingDropTarget?.draggedStableId ?: return null
            val draggedItem = items.firstOrNull { item -> item.stableId == draggedStableId }
            return (draggedItem as? LauncherHomeItemUiModel.App)?.iconItem
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
            if (editing) {
                val startRotation = if (bindingAdapterPosition % 2 == 0) -1.6f else 1.6f
                startWiggle(startRotation)
            } else {
                stopWiggle()
            }
        }

        private fun startWiggle(startRotation: Float) {
            if (wiggleAnimator?.isStarted == true) return

            binding.root.rotation = startRotation
            wiggleAnimator = ObjectAnimator.ofFloat(
                binding.root,
                View.ROTATION,
                startRotation,
                -startRotation
            ).apply {
                duration = 95L
                repeatCount = ObjectAnimator.INFINITE
                repeatMode = ObjectAnimator.REVERSE
                interpolator = LinearInterpolator()
                start()
            }
        }

        private fun stopWiggle() {
            wiggleAnimator?.cancel()
            wiggleAnimator = null
            binding.root.rotation = 0f
        }

        private fun applyActiveDragVisibility(item: LauncherHomeItemUiModel) {
            if (item.stableId == activeDragStableId) {
                binding.root.alpha = 0f
                binding.root.translationX = 0f
                binding.root.translationY = 0f
            }
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

    private fun notifyDragVisibilityChanged(stableId: Long?) {
        if (stableId == null) return

        val position = items.indexOfFirst { item -> item.stableId == stableId }
        if (position != -1) {
            notifyItemChanged(position)
        }
    }
}

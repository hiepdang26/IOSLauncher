package com.vhmsoft.launcherios26.ui.launcher.workspace

import android.animation.ObjectAnimator
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import android.view.animation.OvershootInterpolator
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.vhmsoft.launcherios26.databinding.ItemLauncherDockIconBinding
import com.vhmsoft.launcherios26.ui.launcher.LauncherHomeIconSizePolicy
import java.util.Collections

class LauncherDockAdapter(
    private val onIconClicked: (LauncherIconUiModel) -> Unit,
    private val onFolderClicked: (LauncherHomeItemUiModel.Folder) -> Unit = {},
    private val onRemoveClicked: (LauncherIconUiModel) -> Unit = {},
    private val onDragRequested: (RecyclerView.ViewHolder) -> Unit = {},
    private val onOrderChanged: (List<LauncherHomeItemUiModel>) -> Unit = {}
) : RecyclerView.Adapter<LauncherDockAdapter.DockViewHolder>() {
    private val items = mutableListOf<LauncherHomeItemUiModel>()
    private var editing = false
    private var iconSizeDp = DEFAULT_ICON_SIZE_DP
    private var darkMode = false
    private var liquidGlassEnabled = false
    private var pendingDropTarget: PendingDropTarget? = null
    private var recentlyUpdatedFolderStableId: Long? = null
    private var activeTouchRawX = 0f
    private var activeTouchRawY = 0f
    private var hasActiveTouch = false

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DockViewHolder {
        val binding = ItemLauncherDockIconBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return DockViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DockViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    override fun getItemId(position: Int): Long = items[position].stableId

    fun submitItems(dockItems: List<LauncherHomeItemUiModel>) {
        items.clear()
        items.addAll(
            LauncherHomeLayoutBuilder.normalize(dockItems)
                .filterNot { item -> item is LauncherHomeItemUiModel.Placeholder }
                .take(MAX_DOCK_ITEMS)
        )
        pendingDropTarget = null
        recentlyUpdatedFolderStableId = null
        clearActiveTouch()
        notifyDataSetChanged()
    }

    fun submitApps(apps: List<LauncherIconUiModel>) {
        submitItems(apps.map { app -> LauncherHomeItemUiModel.App(app) })
    }

    fun setEditing(enabled: Boolean) {
        if (editing == enabled) return
        editing = enabled
        if (!editing) {
            pendingDropTarget = null
            recentlyUpdatedFolderStableId = null
            clearActiveTouch()
        }
        notifyDataSetChanged()
    }

    fun setIconSizeDp(sizeDp: Int) {
        val boundedSize = sizeDp.coerceIn(MIN_ICON_SIZE_DP, MAX_ICON_SIZE_DP)
        if (iconSizeDp == boundedSize) return
        iconSizeDp = boundedSize
        notifyDataSetChanged()
    }

    fun setDarkMode(enabled: Boolean) {
        if (darkMode == enabled) return
        darkMode = enabled
        notifyDataSetChanged()
    }

    fun setLiquidGlassEnabled(enabled: Boolean) {
        if (liquidGlassEnabled == enabled) return
        liquidGlassEnabled = enabled
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

    fun itemsSnapshot(): List<LauncherHomeItemUiModel> {
        return items.toList()
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

    fun moveItem(fromPosition: Int, toPosition: Int): Boolean {
        if (fromPosition == RecyclerView.NO_POSITION || toPosition == RecyclerView.NO_POSITION) return false
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
        pendingDropTarget = null
        notifyItemMoved(fromPosition, toPosition)
        return true
    }

    fun rememberDropTargetByTargetStableId(draggedStableId: Long?, targetStableId: Long?) {
        val previousTargetStableId = pendingDropTarget?.targetStableId
        pendingDropTarget = null
        if (!editing || draggedStableId == null || targetStableId == null) {
            notifyDropTargetChanged(previousTargetStableId)
            return
        }

        val dragged = items.firstOrNull { item -> item.stableId == draggedStableId } as? LauncherHomeItemUiModel.App
        val target = items.firstOrNull { item -> item.stableId == targetStableId }
        if (dragged == null ||
            target == null ||
            dragged.stableId == target.stableId ||
            target is LauncherHomeItemUiModel.Placeholder
        ) {
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
                id = "dock_folder_${System.nanoTime()}",
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
        items.addAll(
            LauncherHomeLayoutBuilder.normalize(newItems)
                .filterNot { item -> item is LauncherHomeItemUiModel.Placeholder }
                .take(MAX_DOCK_ITEMS)
        )
        notifyDataSetChanged()
        return true
    }

    fun notifyOrderChanged() {
        val normalizedItems = LauncherHomeLayoutBuilder.normalize(items)
            .filterNot { item -> item is LauncherHomeItemUiModel.Placeholder }
            .take(MAX_DOCK_ITEMS)
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

    inner class DockViewHolder(
        private val binding: ItemLauncherDockIconBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private var wiggleAnimator: ObjectAnimator? = null

        fun bind(item: LauncherHomeItemUiModel) {
            stopWiggle()
            binding.root.alpha = 1f
            binding.root.scaleX = 1f
            binding.root.scaleY = 1f
            binding.root.translationX = 0f
            binding.root.translationY = 0f
            binding.root.rotation = 0f
            binding.root.setOnClickListener(null)
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
                if (!editing) return@setOnLongClickListener false
                onDragRequested(this)
                true
            }
            binding.iconPlate.setOnTouchListener { _, event ->
                updateActiveTouch(event.rawX, event.rawY)
                false
            }
            binding.removeBadge.visibility = if (editing && canShowRemoveBadge(item)) {
                View.VISIBLE
            } else {
                View.GONE
            }
            applyRemoveBadgeAppearance()
            binding.removeBadge.setOnClickListener {
                when (item) {
                    is LauncherHomeItemUiModel.App -> onRemoveClicked(item.iconItem)
                    is LauncherHomeItemUiModel.Folder -> dissolveFolder(item)
                    is LauncherHomeItemUiModel.Placeholder -> Unit
                }
            }
            bindIconArtwork(item)
            applyIconSize()
            applyDropTargetState(item)
            applyEditAnimation()
            applyFolderAbsorbAnimation(item)
        }

        private fun bindIconArtwork(item: LauncherHomeItemUiModel) {
            binding.appIcon.contentDescription = item.label
            when (item) {
                is LauncherHomeItemUiModel.App -> {
                    binding.iconPlate.background = if (isPendingDropTarget(item)) {
                        folderPreviewBackground()
                    } else {
                        null
                    }
                    binding.appIcon.setImageDrawable(item.iconItem.displayIcon)
                    binding.appIcon.visibility = View.VISIBLE
                    binding.folderPreview.visibility = View.GONE
                    clearFolderPreviewIcons()
                }

                is LauncherHomeItemUiModel.Folder -> {
                    binding.iconPlate.background = folderPreviewBackground()
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

                is LauncherHomeItemUiModel.Placeholder -> Unit
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
                    .scaleX(1.12f)
                    .scaleY(1.12f)
                    .setDuration(135L)
                    .setInterpolator(DecelerateInterpolator())
                    .start()
                binding.appIcon.animate()
                    .scaleX(0.82f)
                    .scaleY(0.82f)
                    .setDuration(135L)
                    .setInterpolator(DecelerateInterpolator())
                    .start()
                binding.folderPreview.animate()
                    .scaleX(0.9f)
                    .scaleY(0.9f)
                    .setDuration(135L)
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
            binding.iconPlate.scaleX = 1.18f
            binding.iconPlate.scaleY = 1.18f
            binding.iconPlate.alpha = 0.86f
            binding.iconPlate.animate()
                .scaleX(1f)
                .scaleY(1f)
                .alpha(1f)
                .setDuration(220L)
                .setInterpolator(OvershootInterpolator(1.16f))
                .start()
        }

        private fun applyEditAnimation() {
            if (editing) {
                val startRotation = if (bindingAdapterPosition % 2 == 0) -1.4f else 1.4f
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
                duration = 100L
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
                imageView.setImageDrawable(app?.displayIcon)
            }
        }

        private fun clearFolderPreviewIcons() {
            folderPreviewIcons().forEach { imageView ->
                imageView.visibility = View.INVISIBLE
                imageView.setImageDrawable(null)
            }
        }

        private fun folderPreviewBackground(): GradientDrawable {
            val style = LauncherLiquidGlassStylePolicy.folderPreview(
                enabled = liquidGlassEnabled,
                darkMode = darkMode
            )
            return GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = dp(style.radiusDp).toFloat()
                setColor(style.color)
                style.strokeColor?.let { strokeColor ->
                    setStroke(dp(style.strokeWidthDp), strokeColor)
                }
            }
        }

        private fun applyRemoveBadgeAppearance() {
            binding.removeBadge.background = GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = dp(12).toFloat()
                if (liquidGlassEnabled) {
                    setColor(0x68FFFFFF)
                    setStroke(dp(1), 0xB5FFFFFF.toInt())
                } else {
                    setColor(0xC8FFFFFF.toInt())
                    setStroke(dp(1), 0xA8FFFFFF.toInt())
                }
            }
            binding.removeBadge.alpha = if (liquidGlassEnabled) 0.72f else 1f
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

        private fun applyIconSize() {
            val sizePx = dp(iconSizeDp)
            binding.iconPlate.layoutParams = binding.iconPlate.layoutParams.apply {
                width = sizePx
                height = sizePx
            }
        }

        private fun dp(value: Int): Int {
            return (value * binding.root.resources.displayMetrics.density).toInt()
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

    private fun canShowRemoveBadge(item: LauncherHomeItemUiModel): Boolean {
        return when (item) {
            is LauncherHomeItemUiModel.App -> item.iconItem.app.canUninstall
            is LauncherHomeItemUiModel.Folder,
            is LauncherHomeItemUiModel.Placeholder -> false
        }
    }

    private data class PendingDropTarget(
        val draggedStableId: Long,
        val targetStableId: Long
    )

    private companion object {
        const val MIN_ICON_SIZE_DP = LauncherHomeIconSizePolicy.MIN_HOME_ICON_SIZE_DP
        const val DEFAULT_ICON_SIZE_DP = LauncherHomeIconSizePolicy.DEFAULT_HOME_ICON_SIZE_DP
        const val MAX_ICON_SIZE_DP = LauncherHomeIconSizePolicy.MAX_HOME_ICON_SIZE_DP
        const val MAX_DOCK_ITEMS = 4
    }
}

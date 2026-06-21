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
    private var iconSizeDp: Int = DEFAULT_ICON_SIZE_DP
    private var editing = false
    private var pendingDropTarget: PendingDropTarget? = null
    private var recentlyUpdatedFolderStableId: Long? = null
    private var activeDragStableId: Long? = null
    private var darkMode = false
    private var liquidGlassEnabled = false
    private var activeTouchRawX = 0f
    private var activeTouchRawY = 0f
    private var hasActiveTouch = false
    private var attachedRecyclerView: RecyclerView? = null

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

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        attachedRecyclerView = recyclerView
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        if (attachedRecyclerView === recyclerView) {
            attachedRecyclerView = null
        }
        super.onDetachedFromRecyclerView(recyclerView)
    }

    fun submitItems(homeItems: List<LauncherHomeItemUiModel>) {
        val oldItems = items.toList()
        items.clear()
        items.addAll(LauncherHomeLayoutBuilder.normalize(homeItems))
        val diff = LauncherIconListDiff.between(oldItems, items)
        pendingDropTarget = null
        recentlyUpdatedFolderStableId = null
        val previousActiveDragStableId = activeDragStableId
        activeDragStableId = null
        clearActiveTouch()
        if (diff.requiresFullRefresh) {
            notifyDataSetChanged()
            return
        }

        diff.move?.let { move ->
            notifyItemMoved(move.fromPosition, move.toPosition)
            diff.changedIndices
                .filter { index -> index in items.indices }
                .forEach { index -> notifyItemChanged(index) }
            return
        }

        val activeDragIndex = oldItems.indexOfFirst { item ->
            item.stableId == previousActiveDragStableId
        }
        (diff.changedIndices + activeDragIndex)
            .filter { index -> index in items.indices }
            .distinct()
            .forEach { index -> notifyItemChanged(index) }
    }

    fun submitApps(apps: List<LauncherIconUiModel>) {
        submitItems(apps.map { app -> LauncherHomeItemUiModel.App(app) })
    }

    fun setItemHeight(heightPx: Int) {
        if (itemHeightPx == heightPx) return
        itemHeightPx = heightPx
        notifyDataSetChanged()
    }

    fun setIconSizeDp(sizeDp: Int) {
        val boundedSize = sizeDp.coerceIn(MIN_COMPACT_ICON_SIZE_DP, MAX_ICON_SIZE_DP)
        if (iconSizeDp == boundedSize) return
        iconSizeDp = boundedSize
        notifyDataSetChanged()
    }

    fun setEditing(enabled: Boolean) {
        if (editing == enabled) return
        editing = enabled
        if (!editing) {
            pendingDropTarget = null
            recentlyUpdatedFolderStableId = null
            activeDragStableId = null
            clearActiveTouch()
        }
        notifyDataSetChanged()
    }

    fun isEditing(): Boolean = editing

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
        if (dragged is LauncherHomeItemUiModel.Placeholder) return false
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

        if (items[boundedFinalPosition] is LauncherHomeItemUiModel.Placeholder) {
            val movedItem = items[fromPosition]
            if (movedItem is LauncherHomeItemUiModel.Placeholder) return false

            items[boundedFinalPosition] = movedItem
            items[fromPosition] = LauncherHomeItemUiModel.Placeholder.forGridIndex(fromPosition)
            pendingDropTarget = null
            notifyItemChanged(fromPosition)
            notifyItemChanged(boundedFinalPosition)
            return true
        }

        val movedItem = items.removeAt(fromPosition)
        items.add(boundedFinalPosition, movedItem)
        pendingDropTarget = null
        notifyItemMoved(fromPosition, boundedFinalPosition)
        return true
    }

    fun moveItemByStableIdWithIos17Rule(
        draggedStableId: Long?,
        baseItems: List<LauncherHomeItemUiModel>,
        targetPosition: Int
    ): Boolean {
        val stableId = draggedStableId ?: return false
        val movedItems = LauncherIos17HomeReorderPolicy.moveExistingItemToIndex(
            items = baseItems,
            draggedStableId = stableId,
            targetIndex = targetPosition
        ) ?: return false

        if (items.map { item -> item.stableId } == movedItems.map { item -> item.stableId }) {
            return false
        }
        val changedPositions = items.indices
            .filter { index -> items[index].stableId != movedItems[index].stableId }
        items.clear()
        items.addAll(movedItems)
        pendingDropTarget = null
        changedPositions.forEach { position ->
            notifyItemChanged(position)
        }
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

        val result = LauncherFolderDropCommitResolver.resolve(
            items = items,
            draggedStableId = target.draggedStableId,
            targetStableId = target.targetStableId,
            newFolderId = { "folder_${System.nanoTime()}" }
        )
        if (result == null) {
            notifyDropTargetChanged(target.targetStableId)
            return false
        }

        recentlyUpdatedFolderStableId = result.updatedFolderStableId
        items.clear()
        items.addAll(result.items)
        notifyItemChanged(result.draggedIndex)
        notifyItemChanged(result.updatedTargetIndex)
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
            binding.root.setOnTouchListener(null)
            binding.iconPlate.setOnClickListener(null)
            binding.iconPlate.setOnLongClickListener(null)
            binding.iconPlate.setOnTouchListener(null)
            if (item is LauncherHomeItemUiModel.Placeholder) {
                bindPlaceholder()
                return
            }
            val clickListener = View.OnClickListener {
                if (editing) {
                    if (item is LauncherHomeItemUiModel.Folder) {
                        onFolderClicked(item)
                    }
                    return@OnClickListener
                }

                when (item) {
                    is LauncherHomeItemUiModel.App -> onIconClicked(item.iconItem)
                    is LauncherHomeItemUiModel.Folder -> onFolderClicked(item)
                    is LauncherHomeItemUiModel.Placeholder -> Unit
                }
            }
            val longClickListener = View.OnLongClickListener {
                if (editing) {
                    onDragRequested(this)
                    return@OnLongClickListener true
                } else {
                    return@OnLongClickListener when (item) {
                        is LauncherHomeItemUiModel.App -> onIconLongClicked(item.iconItem, binding.iconPlate)
                        is LauncherHomeItemUiModel.Folder -> {
                            onFolderClicked(item)
                            true
                        }

                        is LauncherHomeItemUiModel.Placeholder -> false
                    }
                }
            }
            val touchListener = View.OnTouchListener { _, event ->
                updateActiveTouch(event.rawX, event.rawY)
                false
            }
            binding.root.setOnClickListener(clickListener)
            binding.root.setOnLongClickListener(longClickListener)
            binding.root.setOnTouchListener(touchListener)
            binding.iconPlate.setOnClickListener(clickListener)
            binding.iconPlate.setOnLongClickListener(longClickListener)
            binding.iconPlate.setOnTouchListener(touchListener)
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
                    binding.iconPlate.background = if (pendingFolderTarget) folderPreviewBackground() else null
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
            return GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = dp(16).toFloat()
                if (liquidGlassEnabled) {
                    setColor(0x4DFFFFFF)
                    setStroke(dp(1), 0x9AFFFFFF.toInt())
                } else {
                    setColor(if (darkMode) 0x5A42484B else 0x705F6663)
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

        private fun applyFixedCellSize() {
            if (itemHeightPx <= 0) return

            binding.root.layoutParams = binding.root.layoutParams.apply {
                height = itemHeightPx
            }

            val verticalGap = dp(CELL_VERTICAL_GAP_DP)
            val minimumLabelHeight = dp(MIN_LABEL_HEIGHT_DP)
            val twoLineLabelHeight = dp(TWO_LINE_LABEL_HEIGHT_DP)
            val maxIconForCell = (itemHeightPx - minimumLabelHeight - verticalGap).coerceAtLeast(dp(MIN_TINY_ICON_SIZE_DP))
            val compactMinIcon = min(dp(MIN_COMPACT_ICON_SIZE_DP), maxIconForCell)
            val iconSize = min(dp(iconSizeDp), maxIconForCell).coerceAtLeast(compactMinIcon)
            binding.iconPlate.layoutParams = binding.iconPlate.layoutParams.apply {
                width = iconSize
                height = iconSize
            }

            binding.appLabel.maxLines = if (itemHeightPx - iconSize - verticalGap >= twoLineLabelHeight) 2 else 1
            binding.appLabel.layoutParams = binding.appLabel.layoutParams.apply {
                height = max(minimumLabelHeight, itemHeightPx - iconSize - verticalGap)
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
        const val MIN_COMPACT_ICON_SIZE_DP = 44
        const val MIN_TINY_ICON_SIZE_DP = 32
        const val DEFAULT_ICON_SIZE_DP = 64
        const val MAX_ICON_SIZE_DP = 78
        const val CELL_VERTICAL_GAP_DP = 7
        const val MIN_LABEL_HEIGHT_DP = 22
        const val TWO_LINE_LABEL_HEIGHT_DP = 30
    }

    private fun notifyDragVisibilityChanged(stableId: Long?) {
        if (stableId == null) return

        val position = items.indexOfFirst { item -> item.stableId == stableId }
        if (position != -1) {
            val recyclerView = attachedRecyclerView
            if (recyclerView?.isComputingLayout == true) {
                recyclerView.post { notifyDragVisibilityChanged(stableId) }
            } else {
                notifyItemChanged(position)
            }
        }
    }
}

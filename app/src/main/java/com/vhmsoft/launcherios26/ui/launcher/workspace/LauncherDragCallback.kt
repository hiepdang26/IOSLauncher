package com.vhmsoft.launcherios26.ui.launcher.workspace

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.drawable.BitmapDrawable
import android.os.SystemClock
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.DecelerateInterpolator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.vhmsoft.launcherios26.R
import kotlin.math.pow
import kotlin.math.roundToInt

class LauncherDragCallback(
    private val adapter: LauncherIconAdapter,
    private val allowFolderDrop: Boolean = true,
    private val reorderOnMove: Boolean = false,
    private val gridRows: () -> Int = { DEFAULT_GRID_ROWS },
    private val isDroppedOutside: (RecyclerView, RecyclerView.ViewHolder, Float, Float) -> Boolean = { _, _, _, _ -> false },
    private val onDragOutsideChanged: (
        LauncherHomeItemUiModel?,
        RecyclerView.ViewHolder,
        Boolean,
        Float,
        Float
    ) -> Unit = { _, _, _, _, _ -> },
    private val onDroppedOutside: (LauncherHomeItemUiModel) -> Boolean = { false },
    private val onDragMoved: (
        LauncherHomeItemUiModel?,
        RecyclerView.ViewHolder,
        Float,
        Float
    ) -> Boolean = { _, _, _, _ -> false },
    private val onDragEnded: (
        LauncherHomeItemUiModel?,
        RecyclerView.ViewHolder,
        Float,
        Float
    ) -> Boolean = { _, _, _, _ -> false }
) : ItemTouchHelper.Callback() {
    private var draggedStableId: Long? = null
    private var draggingOutside = false
    private var dragStartCenterX = 0f
    private var dragStartCenterY = 0f
    private var lastDragCenterX = 0f
    private var lastDragCenterY = 0f
    private var touchToCenterOffsetX = 0f
    private var touchToCenterOffsetY = 0f
    private var externalDragActive = false
    private var edgeReordered = false
    private var dragBaseItems: List<LauncherHomeItemUiModel> = emptyList()
    private var lastHoverTarget: HoverTarget? = null
    private var lastHoverStartedAt = 0L
    private var lastReorderAt = 0L
    private var dragPreviewBitmap: Bitmap? = null
    private var dragPreviewAnchorX = 0f
    private var dragPreviewAnchorY = 0f
    private val dragPreviewPaint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.FILTER_BITMAP_FLAG)
    private var folderAbsorbTargetPosition = RecyclerView.NO_POSITION
    private var folderAbsorbStartedAt = 0L
    private var lastDragPreviewTransform: LauncherFolderDropPreviewTransform.Transform? = null
    private var dropPreviewAnimator: ValueAnimator? = null

    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        if (!adapter.isEditing()) return makeMovementFlags(0, 0)

        val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN or
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        return makeMovementFlags(dragFlags, 0)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        if (reorderOnMove) {
            if (draggingOutside) return false
            return adapter.moveItem(viewHolder.bindingAdapterPosition, target.bindingAdapterPosition)
        }
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) = Unit

    override fun isLongPressDragEnabled(): Boolean = false

    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
        super.onSelectedChanged(viewHolder, actionState)
        if (actionState == ItemTouchHelper.ACTION_STATE_DRAG) {
            cancelDropPreviewAnimation()
            draggedStableId = viewHolder?.bindingAdapterPosition
                ?.let { position -> adapter.stableIdAt(position) }
            dragBaseItems = adapter.itemsSnapshot()
            draggingOutside = false
            externalDragActive = false
            edgeReordered = false
            resetFolderAbsorbState()
            resetHoverState()
            viewHolder?.let { holder -> rememberDragStartCenter(holder) }
            if (allowFolderDrop && !reorderOnMove) {
                viewHolder?.let { holder -> beginHomeDragPreview(holder) }
            } else {
                viewHolder?.itemView?.animate()
                    ?.scaleX(1.08f)
                    ?.scaleY(1.08f)
                    ?.alpha(0.96f)
                    ?.setDuration(120L)
                    ?.start()
                viewHolder?.itemView?.elevation = 18f
            }
        }
    }

    override fun onChildDrawOver(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder?,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        val preview = dragPreviewBitmap
        if (actionState == ItemTouchHelper.ACTION_STATE_DRAG &&
            isCurrentlyActive &&
            allowFolderDrop &&
            !reorderOnMove &&
            !externalDragActive &&
            preview != null
        ) {
            val transform = dragPreviewTransform(recyclerView)
            lastDragPreviewTransform = transform
            drawDragPreview(c, preview, transform)
            if (folderAbsorbTargetPosition != RecyclerView.NO_POSITION) {
                recyclerView.postInvalidateOnAnimation()
            }
            return
        }
        super.onChildDrawOver(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        if (actionState != ItemTouchHelper.ACTION_STATE_DRAG || !isCurrentlyActive) return
        updateDragCenter(dX, dY)
        val draggedItem = adapter.itemByStableId(draggedStableId)
        val (callbackCenterX, callbackCenterY) = dragCallbackCenter()
        if (externalDragActive) {
            onDragMoved(draggedItem, viewHolder, callbackCenterX, callbackCenterY)
            viewHolder.itemView.alpha = 0f
            viewHolder.itemView.translationX = 0f
            viewHolder.itemView.translationY = 0f
            return
        }
        if (onDragMoved(draggedItem, viewHolder, callbackCenterX, callbackCenterY)) {
            externalDragActive = true
            if (canMutateDragItems(recyclerView)) {
                adapter.clearPendingDropTarget()
            }
            viewHolder.itemView.animate().cancel()
            viewHolder.itemView.alpha = 0f
            viewHolder.itemView.translationX = 0f
            viewHolder.itemView.translationY = 0f
            return
        }

        if (reorderOnMove && !allowFolderDrop) {
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
            val outside = isDroppedOutside(recyclerView, viewHolder, callbackCenterX, callbackCenterY)
            if (outside) {
                viewHolder.itemView.alpha = 0f
                onDragOutsideChanged(draggedItem, viewHolder, true, callbackCenterX, callbackCenterY)
            } else if (draggingOutside) {
                viewHolder.itemView.alpha = 0.96f
                onDragOutsideChanged(draggedItem, viewHolder, false, callbackCenterX, callbackCenterY)
            }
            draggingOutside = outside
            return
        }
        if (!allowFolderDrop) return

        hideHomeDraggedViewHolder(viewHolder)
        if (!LauncherDragMutationGuard.canMutateDuringActiveDrag(allowFolderDrop, reorderOnMove)) {
            applyHomeDragMovementPreview(recyclerView, viewHolder, dX, dY)
            resetHoverState()
            return
        }
        if (!canMutateDragItems(recyclerView)) {
            resetHoverState()
            return
        }
        val hoverTarget = findHomeHoverTarget(recyclerView, viewHolder, dX, dY)
        if (!isHomeHoverReady(hoverTarget)) return
        when (hoverTarget?.action) {
            HoverAction.INSERT_BEFORE -> {
                adapter.clearPendingDropTarget()
                val moved = adapter.moveItemByStableIdWithPlusRule(
                    draggedStableId = draggedStableId,
                    baseItems = dragBaseItems,
                    targetPosition = hoverTarget.targetPosition,
                    columns = gridColumns(recyclerView),
                    rows = gridRows()
                )
                edgeReordered = moved || edgeReordered
                if (moved) resetHoverState()
            }

            HoverAction.INSERT_AFTER -> {
                adapter.clearPendingDropTarget()
                val moved = adapter.moveItemByStableIdWithPlusRule(
                    draggedStableId = draggedStableId,
                    baseItems = dragBaseItems,
                    targetPosition = hoverTarget.targetPosition,
                    columns = gridColumns(recyclerView),
                    rows = gridRows()
                )
                edgeReordered = moved || edgeReordered
                if (moved) resetHoverState()
            }

            HoverAction.FOLDER -> {
                adapter.rememberDropTargetByTargetStableId(draggedStableId, hoverTarget.targetStableId)
            }

            null -> {
                adapter.clearPendingDropTarget()
                val blankCellPosition = findBlankGridDropPosition(recyclerView)
                if (blankCellPosition != RecyclerView.NO_POSITION) {
                    val moved = adapter.moveItemByStableIdToPosition(
                        draggedStableId = draggedStableId,
                        finalPosition = blankCellPosition
                    )
                    edgeReordered = moved || edgeReordered
                    if (moved) resetHoverState()
                }
            }
        }
    }

    private fun canMutateDragItems(recyclerView: RecyclerView): Boolean {
        return LauncherDragMutationGuard.canMutate(
            isComputingLayout = recyclerView.isComputingLayout,
            itemAnimatorRunning = recyclerView.itemAnimator?.isRunning == true,
            hasPendingAdapterUpdates = recyclerView.hasPendingAdapterUpdates(),
            isScrollIdle = recyclerView.scrollState == RecyclerView.SCROLL_STATE_IDLE
        )
    }

    private fun beginHomeDragPreview(viewHolder: RecyclerView.ViewHolder) {
        createDragPreviewBitmap(viewHolder)
        adapter.setActiveDragStableId(draggedStableId)
        hideHomeDraggedViewHolder(viewHolder)
    }

    private fun createDragPreviewBitmap(viewHolder: RecyclerView.ViewHolder) {
        recycleDragPreviewBitmap()

        val draggedView = viewHolder.itemView
        if (draggedView.width <= 0 || draggedView.height <= 0) return

        val iconPlate = draggedView.findViewById<android.view.View>(R.id.iconPlate) ?: draggedView
        dragPreviewAnchorX = iconPlate.left + iconPlate.width / 2f
        dragPreviewAnchorY = iconPlate.top + iconPlate.height / 2f
        dragPreviewBitmap = Bitmap.createBitmap(
            draggedView.width,
            draggedView.height,
            Bitmap.Config.ARGB_8888
        ).also { bitmap ->
            draggedView.draw(Canvas(bitmap))
        }
    }

    private fun hideHomeDraggedViewHolder(viewHolder: RecyclerView.ViewHolder) {
        viewHolder.itemView.animate().cancel()
        viewHolder.itemView.alpha = 0f
        viewHolder.itemView.translationX = 0f
        viewHolder.itemView.translationY = 0f
        viewHolder.itemView.scaleX = 1f
        viewHolder.itemView.scaleY = 1f
        viewHolder.itemView.elevation = 0f
    }

    private fun isHomeHoverReady(hoverTarget: HoverTarget?): Boolean {
        if (hoverTarget == null) {
            resetHoverState()
            return true
        }

        val now = SystemClock.uptimeMillis()
        if (hoverTarget.action == HoverAction.FOLDER) {
            lastHoverTarget = hoverTarget
            lastHoverStartedAt = now
            return true
        }
        if (hoverTarget != lastHoverTarget) {
            lastHoverTarget = hoverTarget
            lastHoverStartedAt = now
            return false
        }
        if (now - lastHoverStartedAt < HOME_HOVER_SETTLE_MS) return false
        if (now - lastReorderAt < HOME_REORDER_THROTTLE_MS) return false

        lastReorderAt = now
        return true
    }

    private fun resetHoverState() {
        lastHoverTarget = null
        lastHoverStartedAt = 0L
    }

    private fun applyHomeDragMovementPreview(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float
    ) {
        val hoverTarget = findHomeHoverTarget(recyclerView, viewHolder, dX, dY)
        when (hoverTarget?.action) {
            HoverAction.FOLDER -> {
                clearHomeIconMovementPreview(recyclerView, animate = true)
                adapter.rememberDropTargetByTargetStableId(draggedStableId, hoverTarget.targetStableId)
            }

            HoverAction.INSERT_BEFORE,
            HoverAction.INSERT_AFTER -> {
                adapter.clearPendingDropTarget()
                val previewItems = LauncherHomeIconMovePolicy.moveExistingItem(
                    items = dragBaseItems,
                    draggedStableId = draggedStableId ?: return clearHomeIconMovementPreview(
                        recyclerView,
                        animate = true
                    ),
                    targetIndex = hoverTarget.targetPosition,
                    columns = gridColumns(recyclerView),
                    rows = gridRows()
                )
                if (previewItems == null) {
                    clearHomeIconMovementPreview(recyclerView, animate = true)
                } else {
                    applyHomeIconMovementPreview(recyclerView, previewItems)
                }
            }

            null -> {
                adapter.clearPendingDropTarget()
                clearHomeIconMovementPreview(recyclerView, animate = true)
            }
        }
    }

    private fun applyHomeIconMovementPreview(
        recyclerView: RecyclerView,
        previewItems: List<LauncherHomeItemUiModel>
    ) {
        val width = recyclerView.width.takeIf { it > 0 } ?: return
        val height = recyclerView.height.takeIf { it > 0 } ?: return
        val columns = gridColumns(recyclerView).coerceAtLeast(1)
        val rows = gridRows().coerceAtLeast(1)
        val cellWidth = width / columns.toFloat()
        val cellHeight = height / rows.toFloat()
        val movesByStableId = LauncherHomeDragPreviewPlanner
            .moves(dragBaseItems, previewItems)
            .filter { move -> move.stableId != draggedStableId }
            .associateBy { move -> move.stableId }

        for (index in 0 until recyclerView.childCount) {
            val child = recyclerView.getChildAt(index)
            val holder = recyclerView.getChildViewHolder(child)
            val adapterPosition = holder.bindingAdapterPosition
            val item = adapter.itemAt(adapterPosition)
            val move = item?.stableId?.let { stableId -> movesByStableId[stableId] }
            val targetTranslation = move?.translation(
                columns = columns,
                cellWidth = cellWidth,
                cellHeight = cellHeight
            )
            child.animate().cancel()
            child.animate()
                .translationX(targetTranslation?.first ?: 0f)
                .translationY(targetTranslation?.second ?: 0f)
                .setDuration(HOME_ICON_REORDER_PREVIEW_MS)
                .setInterpolator(DecelerateInterpolator())
                .start()
        }
    }

    private fun clearHomeIconMovementPreview(
        recyclerView: RecyclerView,
        animate: Boolean
    ) {
        for (index in 0 until recyclerView.childCount) {
            val child = recyclerView.getChildAt(index)
            child.animate().cancel()
            if (animate) {
                child.animate()
                    .translationX(0f)
                    .translationY(0f)
                    .setDuration(HOME_ICON_REORDER_PREVIEW_MS)
                    .setInterpolator(DecelerateInterpolator())
                    .start()
            } else {
                child.translationX = 0f
                child.translationY = 0f
            }
        }
    }

    private fun LauncherHomeDragPreviewPlanner.Move.translation(
        columns: Int,
        cellWidth: Float,
        cellHeight: Float
    ): Pair<Float, Float> {
        val boundedColumns = columns.coerceAtLeast(1)
        val fromColumn = fromIndex % boundedColumns
        val fromRow = fromIndex / boundedColumns
        val toColumn = toIndex % boundedColumns
        val toRow = toIndex / boundedColumns
        return Pair(
            (toColumn - fromColumn) * cellWidth,
            (toRow - fromRow) * cellHeight
        )
    }

    private fun settleHomeDraggedView(viewHolder: RecyclerView.ViewHolder) {
        viewHolder.itemView.animate().cancel()
        viewHolder.itemView.animate()
            .translationX(0f)
            .translationY(0f)
            .scaleX(1f)
            .scaleY(1f)
            .alpha(1f)
            .setDuration(HOME_DROP_SETTLE_MS)
            .setInterpolator(DecelerateInterpolator())
            .withEndAction {
                viewHolder.itemView.elevation = 0f
            }
            .start()
    }

    override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
        val draggedItem = adapter.itemByStableId(draggedStableId)
        val (callbackCenterX, callbackCenterY) = dragCallbackCenter()
        if (allowFolderDrop) {
            clearHomeIconMovementPreview(recyclerView, animate = false)
        }
        if (onDragEnded(draggedItem, viewHolder, callbackCenterX, callbackCenterY)) {
            super.clearView(recyclerView, viewHolder)
            if (externalDragActive || draggingOutside) {
                hideHomeDraggedViewHolder(viewHolder)
            } else {
                resetDraggedView(viewHolder)
            }
            draggedStableId = null
            dragBaseItems = emptyList()
            draggingOutside = false
            externalDragActive = false
            edgeReordered = false
            resetHoverState()
            clearHomeDragPreview()
            adapter.clearPendingDropTarget()
            adapter.clearActiveTouch()
            return
        }

        if (isDroppedOutside(recyclerView, viewHolder, callbackCenterX, callbackCenterY)) {
            super.clearView(recyclerView, viewHolder)
            resetDraggedView(viewHolder)
            val removedItem = draggedStableId?.let { stableId ->
                adapter.removeItemByStableId(stableId, notifyOrder = false)
            }
            draggedStableId = null
            dragBaseItems = emptyList()
            draggingOutside = false
            externalDragActive = false
            edgeReordered = false
            resetHoverState()
            clearHomeDragPreview()
            if (removedItem != null && onDroppedOutside(removedItem)) {
                adapter.clearActiveTouch()
                return
            }
            onDragOutsideChanged(removedItem, viewHolder, false, callbackCenterX, callbackCenterY)
        }

        if (!allowFolderDrop) {
            super.clearView(recyclerView, viewHolder)
            resetDraggedView(viewHolder)
            if (draggingOutside) {
                onDragOutsideChanged(
                    adapter.itemByStableId(draggedStableId),
                    viewHolder,
                    false,
                    callbackCenterX,
                    callbackCenterY
                )
            }
            draggedStableId = null
            dragBaseItems = emptyList()
            draggingOutside = false
            externalDragActive = false
            edgeReordered = false
            resetHoverState()
            clearHomeDragPreview()
            adapter.clearActiveTouch()
            adapter.notifyOrderChanged()
            return
        }

        val folderTargetStableId = findFolderDropTargetStableId(recyclerView, viewHolder)
        if (folderTargetStableId != null) {
            adapter.rememberDropTargetByTargetStableId(draggedStableId, folderTargetStableId)
        } else {
            adapter.clearPendingDropTarget()
            commitHomeDropOnRelease(recyclerView, viewHolder)
        }

        if (adapter.hasPendingDropTarget()) {
            val targetPosition = adapter.pendingDropTargetPosition()
            val commitBeforeAnimation = LauncherFolderDropCommitPolicy.shouldCommitBeforeAnimation(
                hasPendingDropTarget = adapter.hasPendingDropTarget()
            )
            val overlayAnimation = if (commitBeforeAnimation) {
                captureDropPreviewAnimation(recyclerView, targetPosition)
            } else {
                null
            }
            if (commitBeforeAnimation) {
                adapter.commitPendingDropTarget()
                adapter.notifyOrderChanged()
            }
            if (overlayAnimation != null) {
                hideHomeDraggedViewHolder(viewHolder)
                clearHomeDragPreview()
                startDropPreviewAnimation(recyclerView, overlayAnimation)
            } else {
                restoreHomeDraggedViewAtPreview(recyclerView, viewHolder, lastDragPreviewTransform)
                animateDropIntoFolder(
                    recyclerView = recyclerView,
                    viewHolder = viewHolder,
                    targetPosition = targetPosition,
                    commitOnEnd = !commitBeforeAnimation
                )
            }
        } else {
            restoreHomeDraggedViewAtFinger(recyclerView, viewHolder)
            recyclerView.post { settleHomeDraggedView(viewHolder) }
            adapter.notifyOrderChanged()
        }
        draggedStableId = null
        dragBaseItems = emptyList()
        draggingOutside = false
        externalDragActive = false
        edgeReordered = false
        resetHoverState()
    }

    private fun commitHomeDropOnRelease(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Boolean {
        val blankCellPosition = findBlankGridDropPosition(recyclerView)
        if (blankCellPosition != RecyclerView.NO_POSITION) {
            return adapter.moveItemByStableIdToPosition(
                draggedStableId = draggedStableId,
                finalPosition = blankCellPosition
            )
        }

        val targetPosition = findDropTargetPosition(
            recyclerView = recyclerView,
            viewHolder = viewHolder,
            dX = viewHolder.itemView.translationX,
            dY = viewHolder.itemView.translationY
        )
        if (targetPosition == RecyclerView.NO_POSITION) return false
        val targetItem = adapter.itemAt(targetPosition)
        if (targetItem == null || targetItem is LauncherHomeItemUiModel.Placeholder) {
            return false
        }

        return adapter.moveItemByStableIdWithPlusRule(
            draggedStableId = draggedStableId,
            baseItems = dragBaseItems,
            targetPosition = targetPosition,
            columns = gridColumns(recyclerView),
            rows = gridRows()
        )
    }

    private fun dragCallbackCenter(): Pair<Float, Float> {
        if (reorderOnMove && !allowFolderDrop) {
            adapter.activeTouchRaw()?.let { touchRaw ->
                return touchRaw
            }
        }
        return Pair(lastDragCenterX, lastDragCenterY)
    }

    private fun restoreHomeDraggedViewAtFinger(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ) {
        val (centerX, centerY) = dragCenterInRecycler(recyclerView)
        restoreHomeDraggedViewAtPreview(
            recyclerView = recyclerView,
            viewHolder = viewHolder,
            transform = LauncherFolderDropPreviewTransform.Transform(
                centerX = centerX,
                centerY = centerY,
                scale = 1.08f,
                alphaFraction = 0.96f
            )
        )
    }

    private fun restoreHomeDraggedViewAtPreview(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        transform: LauncherFolderDropPreviewTransform.Transform?
    ) {
        val draggedView = viewHolder.itemView
        val iconPlate = draggedView.findViewById<android.view.View>(R.id.iconPlate) ?: draggedView
        val (fallbackCenterX, fallbackCenterY) = dragCenterInRecycler(recyclerView)
        val previewTransform = transform ?: LauncherFolderDropPreviewTransform.Transform(
            centerX = fallbackCenterX,
            centerY = fallbackCenterY,
            scale = 1.08f,
            alphaFraction = 0.96f
        )
        val currentCenterX = draggedView.left + iconPlate.left + iconPlate.width / 2f
        val currentCenterY = draggedView.top + iconPlate.top + iconPlate.height / 2f

        adapter.setActiveDragStableId(null)
        recycleDragPreviewBitmap()
        draggedView.animate().cancel()
        draggedView.pivotX = iconPlate.left + iconPlate.width / 2f
        draggedView.pivotY = iconPlate.top + iconPlate.height / 2f
        draggedView.alpha = previewTransform.alphaFraction
        draggedView.scaleX = previewTransform.scale
        draggedView.scaleY = previewTransform.scale
        draggedView.translationX = previewTransform.centerX - currentCenterX
        draggedView.translationY = previewTransform.centerY - currentCenterY
        draggedView.elevation = dp(draggedView, DRAGGED_HOME_ELEVATION_DP)
    }

    private fun clearHomeDragPreview() {
        adapter.setActiveDragStableId(null)
        recycleDragPreviewBitmap()
        adapter.clearActiveTouch()
    }

    private fun recycleDragPreviewBitmap() {
        dragPreviewBitmap?.recycle()
        dragPreviewBitmap = null
        dragPreviewAnchorX = 0f
        dragPreviewAnchorY = 0f
        lastDragPreviewTransform = null
        resetFolderAbsorbState()
        dragPreviewPaint.alpha = 255
    }

    private fun dragPreviewTransform(
        recyclerView: RecyclerView
    ): LauncherFolderDropPreviewTransform.Transform {
        val (centerX, centerY) = dragCenterInRecycler(recyclerView)
        val targetPosition = adapter.pendingDropTargetPosition()
        val targetCenter = targetCenterInRecycler(recyclerView, targetPosition)

        if (targetCenter == null) {
            resetFolderAbsorbState()
            return LauncherFolderDropPreviewTransform.Transform(
                centerX = centerX,
                centerY = centerY,
                scale = 1f,
                alphaFraction = 1f
            )
        }

        if (folderAbsorbTargetPosition != targetPosition) {
            folderAbsorbTargetPosition = targetPosition
            folderAbsorbStartedAt = SystemClock.uptimeMillis()
        }
        return LauncherFolderDropPreviewTransform.hoverTransform(
            currentCenterX = centerX,
            currentCenterY = centerY,
            targetCenterX = targetCenter.first,
            targetCenterY = targetCenter.second,
            elapsedMs = SystemClock.uptimeMillis() - folderAbsorbStartedAt,
            durationMs = FOLDER_HOVER_ABSORB_DURATION_MS
        )
    }

    private fun drawDragPreview(
        canvas: Canvas,
        preview: Bitmap,
        transform: LauncherFolderDropPreviewTransform.Transform
    ) {
        val scale = transform.scale.coerceAtLeast(0.01f)
        val left = transform.centerX - dragPreviewAnchorX * scale
        val top = transform.centerY - dragPreviewAnchorY * scale
        dragPreviewPaint.alpha = (transform.alphaFraction.coerceIn(0f, 1f) * 255f).roundToInt()

        canvas.save()
        canvas.translate(left, top)
        canvas.scale(scale, scale)
        canvas.drawBitmap(preview, 0f, 0f, dragPreviewPaint)
        canvas.restore()
        dragPreviewPaint.alpha = 255
    }

    private fun targetCenterInRecycler(recyclerView: RecyclerView, targetPosition: Int): Pair<Float, Float>? {
        if (targetPosition == RecyclerView.NO_POSITION) return null
        val targetView = recyclerView.findViewHolderForAdapterPosition(targetPosition)?.itemView ?: return null
        val targetPlate = targetView.findViewById<android.view.View>(R.id.iconPlate) ?: targetView
        return Pair(
            targetView.left + targetPlate.left + targetPlate.width / 2f,
            targetView.top + targetPlate.top + targetPlate.height / 2f
        )
    }

    private fun resetFolderAbsorbState() {
        folderAbsorbTargetPosition = RecyclerView.NO_POSITION
        folderAbsorbStartedAt = 0L
    }

    private fun captureDropPreviewAnimation(
        recyclerView: RecyclerView,
        targetPosition: Int
    ): DropPreviewAnimation? {
        val preview = dragPreviewBitmap?.copy(Bitmap.Config.ARGB_8888, false) ?: return null
        val targetCenter = targetCenterInRecycler(recyclerView, targetPosition)
        if (targetCenter == null) {
            preview.recycle()
            return null
        }
        val fallbackCenter = dragCenterInRecycler(recyclerView)
        val startTransform = lastDragPreviewTransform ?: LauncherFolderDropPreviewTransform.Transform(
            centerX = fallbackCenter.first,
            centerY = fallbackCenter.second,
            scale = 1.08f,
            alphaFraction = 0.96f
        )
        return DropPreviewAnimation(
            bitmap = preview,
            anchorX = dragPreviewAnchorX,
            anchorY = dragPreviewAnchorY,
            startCenterX = startTransform.centerX,
            startCenterY = startTransform.centerY,
            startScale = startTransform.scale,
            startAlpha = startTransform.alphaFraction,
            targetCenterX = targetCenter.first,
            targetCenterY = targetCenter.second
        )
    }

    private fun startDropPreviewAnimation(
        recyclerView: RecyclerView,
        animation: DropPreviewAnimation
    ) {
        cancelDropPreviewAnimation()
        val drawable = BitmapDrawable(recyclerView.resources, animation.bitmap).apply {
            paint.isAntiAlias = true
            paint.isFilterBitmap = true
        }
        val initialScale = animation.startScale.coerceAtLeast(0.01f)
        val initialLeft = animation.startCenterX - animation.anchorX * initialScale
        val initialTop = animation.startCenterY - animation.anchorY * initialScale
        drawable.setBounds(
            initialLeft.roundToInt(),
            initialTop.roundToInt(),
            (initialLeft + animation.bitmap.width * initialScale).roundToInt(),
            (initialTop + animation.bitmap.height * initialScale).roundToInt()
        )
        drawable.alpha = (animation.startAlpha * 255f).roundToInt()
        recyclerView.overlay.add(drawable)

        val animator = ValueAnimator.ofFloat(0f, 1f).apply {
            duration = DROP_INTO_FOLDER_DURATION_MS
            interpolator = AccelerateDecelerateInterpolator()
        }
        val endScale = LauncherFolderDropPreviewTransform.dropTransform(
            currentCenterX = animation.startCenterX,
            currentCenterY = animation.startCenterY,
            targetCenterX = animation.targetCenterX,
            targetCenterY = animation.targetCenterY,
            progress = 1f
        ).scale
        var cleanedUp = false
        fun cleanup() {
            if (cleanedUp) return
            cleanedUp = true
            recyclerView.overlay.remove(drawable)
            animation.bitmap.recycle()
            if (dropPreviewAnimator === animator) {
                dropPreviewAnimator = null
            }
        }

        animator.addUpdateListener { valueAnimator ->
            val progress = valueAnimator.animatedValue as Float
            val transform = LauncherFolderDropPreviewTransform.dropTransform(
                currentCenterX = animation.startCenterX,
                currentCenterY = animation.startCenterY,
                targetCenterX = animation.targetCenterX,
                targetCenterY = animation.targetCenterY,
                progress = progress
            )
            val scale = interpolate(animation.startScale, endScale, progress).coerceAtLeast(0.01f)
            val left = transform.centerX - animation.anchorX * scale
            val top = transform.centerY - animation.anchorY * scale
            val right = left + animation.bitmap.width * scale
            val bottom = top + animation.bitmap.height * scale
            val fadeProgress = ((progress - DROP_FADE_START_PROGRESS) /
                (1f - DROP_FADE_START_PROGRESS)).coerceIn(0f, 1f)

            drawable.setBounds(
                left.roundToInt(),
                top.roundToInt(),
                right.roundToInt(),
                bottom.roundToInt()
            )
            drawable.alpha = (animation.startAlpha * (1f - fadeProgress) * 255f).roundToInt()
            drawable.invalidateSelf()
            recyclerView.invalidate()
        }
        animator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                cleanup()
            }

            override fun onAnimationCancel(animation: Animator) {
                cleanup()
            }
        })
        dropPreviewAnimator = animator
        animator.start()
    }

    private fun interpolate(start: Float, end: Float, progress: Float): Float {
        val boundedProgress = progress.coerceIn(0f, 1f)
        return start + (end - start) * boundedProgress
    }

    private fun cancelDropPreviewAnimation() {
        dropPreviewAnimator?.cancel()
        dropPreviewAnimator = null
    }

    private fun animateDropIntoFolder(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        targetPosition: Int,
        commitOnEnd: Boolean = true
    ) {
        val targetCenter = targetCenterInRecycler(recyclerView, targetPosition)
        val draggedView = viewHolder.itemView
        val targetCenterX = targetCenter?.first ?: 0f
        val targetCenterY = targetCenter?.second ?: 0f
        val draggedPlate = draggedView.findViewById<android.view.View>(R.id.iconPlate) ?: draggedView
        val draggedCenterX = draggedView.left + draggedView.translationX + draggedPlate.left + draggedPlate.width / 2f
        val draggedCenterY = draggedView.top + draggedView.translationY + draggedPlate.top + draggedPlate.height / 2f
        val finalTransform = LauncherFolderDropPreviewTransform.dropTransform(
            currentCenterX = draggedCenterX,
            currentCenterY = draggedCenterY,
            targetCenterX = targetCenterX,
            targetCenterY = targetCenterY,
            progress = if (targetCenter == null) 0f else 1f
        )
        val targetDx = finalTransform.centerX - draggedCenterX
        val targetDy = finalTransform.centerY - draggedCenterY

        draggedView.animate().cancel()
        draggedView.animate()
            .translationX(draggedView.translationX + targetDx)
            .translationY(draggedView.translationY + targetDy)
            .scaleX(finalTransform.scale)
            .scaleY(finalTransform.scale)
            .alpha(finalTransform.alphaFraction)
            .setDuration(DROP_INTO_FOLDER_DURATION_MS)
            .setInterpolator(DecelerateInterpolator(1.45f))
            .withEndAction {
                if (commitOnEnd) {
                    adapter.commitPendingDropTarget()
                    adapter.notifyOrderChanged()
                }
                resetDraggedView(viewHolder)
            }
            .start()
    }

    private fun resetDraggedView(viewHolder: RecyclerView.ViewHolder) {
        viewHolder.itemView.animate().cancel()
        viewHolder.itemView.translationX = 0f
        viewHolder.itemView.translationY = 0f
        viewHolder.itemView.scaleX = 1f
        viewHolder.itemView.scaleY = 1f
        viewHolder.itemView.alpha = 1f
        viewHolder.itemView.elevation = 0f
        viewHolder.itemView.pivotX = viewHolder.itemView.width / 2f
        viewHolder.itemView.pivotY = viewHolder.itemView.height / 2f
    }

    private fun rememberDragStartCenter(viewHolder: RecyclerView.ViewHolder) {
        val draggedView = viewHolder.itemView
        val iconPlate = draggedView.findViewById<android.view.View>(R.id.iconPlate) ?: draggedView
        val location = IntArray(2)
        draggedView.getLocationOnScreen(location)
        dragStartCenterX = location[0] + iconPlate.left + iconPlate.width / 2f
        dragStartCenterY = location[1] + iconPlate.top + iconPlate.height / 2f
        val touchRaw = adapter.activeTouchRaw()
        if (touchRaw != null) {
            touchToCenterOffsetX = dragStartCenterX - touchRaw.first
            touchToCenterOffsetY = dragStartCenterY - touchRaw.second
            lastDragCenterX = touchRaw.first + touchToCenterOffsetX
            lastDragCenterY = touchRaw.second + touchToCenterOffsetY
        } else {
            touchToCenterOffsetX = 0f
            touchToCenterOffsetY = 0f
            lastDragCenterX = dragStartCenterX
            lastDragCenterY = dragStartCenterY
        }
    }

    private fun updateDragCenter(dX: Float, dY: Float) {
        val center = LauncherDragCenterResolver.resolve(
            dragStartCenterX = dragStartCenterX,
            dragStartCenterY = dragStartCenterY,
            dX = dX,
            dY = dY,
            rawTouch = adapter.activeTouchRaw(),
            touchToCenterOffsetX = touchToCenterOffsetX,
            touchToCenterOffsetY = touchToCenterOffsetY
        )
        lastDragCenterX = center.first
        lastDragCenterY = center.second
    }

    private fun findDropTargetPosition(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float
    ): Int {
        val draggedView = viewHolder.itemView
        val (draggedCenterX, draggedCenterY) = dragCenterInRecycler(recyclerView)
        val draggedIcon = draggedView.findViewById<android.view.View>(R.id.iconPlate) ?: draggedView
        val dragIconWidth = draggedIcon.width.toFloat()
        val dragIconHeight = draggedIcon.height.toFloat()

        var bestPosition = RecyclerView.NO_POSITION
        var bestDistance = Float.MAX_VALUE
        for (index in 0 until recyclerView.childCount) {
            val child = recyclerView.getChildAt(index)
            if (child === draggedView) continue

            val holder = recyclerView.getChildViewHolder(child)
            val position = holder.bindingAdapterPosition
            if (position == RecyclerView.NO_POSITION) continue

            val iconPlate = child.findViewById<android.view.View>(R.id.iconPlate) ?: child
            val left = child.left + iconPlate.left.toFloat()
            val top = child.top + iconPlate.top.toFloat()
            val right = child.left + iconPlate.right.toFloat()
            val bottom = child.top + iconPlate.bottom.toFloat()
            if (!LauncherIos17DragGeometryPolicy.intersectsTargetIcon(
                    dragCenterX = draggedCenterX,
                    dragCenterY = draggedCenterY,
                    dragIconWidth = dragIconWidth,
                    dragIconHeight = dragIconHeight,
                    targetLeft = left,
                    targetTop = top,
                    targetRight = right,
                    targetBottom = bottom
                )
            ) {
                continue
            }

            val targetCenterX = (left + right) / 2f
            val targetCenterY = (top + bottom) / 2f
            val distance = (draggedCenterX - targetCenterX).pow(2) + (draggedCenterY - targetCenterY).pow(2)
            if (distance < bestDistance) {
                bestDistance = distance
                bestPosition = position
            }
        }
        return bestPosition
    }

    private fun findFolderDropTargetStableId(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Long? {
        val draggedItem = adapter.itemByStableId(draggedStableId)
        val draggedView = viewHolder.itemView
        val (draggedCenterX, draggedCenterY) = dragCenterInRecycler(recyclerView)
        val draggedIcon = draggedView.findViewById<android.view.View>(R.id.iconPlate) ?: draggedView
        val dragIconWidth = draggedIcon.width.toFloat()
        val dragIconHeight = draggedIcon.height.toFloat()

        var bestStableId: Long? = null
        var bestDistance = Float.MAX_VALUE
        for (index in 0 until recyclerView.childCount) {
            val child = recyclerView.getChildAt(index)
            if (child === draggedView) continue

            val holder = recyclerView.getChildViewHolder(child)
            val position = holder.bindingAdapterPosition
            if (position == RecyclerView.NO_POSITION) continue
            val item = adapter.itemAt(position) ?: continue
            if (item.stableId == draggedStableId) continue

            val iconPlate = child.findViewById<android.view.View>(R.id.iconPlate) ?: child
            val left = child.left + iconPlate.left.toFloat()
            val top = child.top + iconPlate.top.toFloat()
            val right = child.left + iconPlate.right.toFloat()
            val bottom = child.top + iconPlate.bottom.toFloat()
            if (!LauncherIos17DragGeometryPolicy.intersectsTargetIcon(
                    dragCenterX = draggedCenterX,
                    dragCenterY = draggedCenterY,
                    dragIconWidth = dragIconWidth,
                    dragIconHeight = dragIconHeight,
                    targetLeft = left,
                    targetTop = top,
                    targetRight = right,
                    targetBottom = bottom
                )
            ) {
                continue
            }

            if (iconPlate.width <= 0 || iconPlate.height <= 0) continue
            val plateLeft = child.left + iconPlate.left
            val plateTop = child.top + iconPlate.top
            val localX = ((draggedCenterX - plateLeft) / iconPlate.width).coerceIn(0f, 1f)
            val localY = ((draggedCenterY - plateTop) / iconPlate.height).coerceIn(0f, 1f)
            val action = LauncherHomeHoverDropPolicy.resolveAction(
                draggedItem = draggedItem,
                targetItem = item,
                localXInCell = localX,
                localYInCell = localY,
                edgeInsertFraction = EDGE_INSERT_FRACTION,
                edgeInsertVerticalFraction = EDGE_INSERT_VERTICAL_FRACTION
            )
            if (action != LauncherHomeHoverDropAction.FOLDER) continue

            val targetCenterX = child.left + iconPlate.left + iconPlate.width / 2f
            val targetCenterY = child.top + iconPlate.top + iconPlate.height / 2f
            val distance = (draggedCenterX - targetCenterX).pow(2) + (draggedCenterY - targetCenterY).pow(2)
            if (distance < bestDistance) {
                bestDistance = distance
                bestStableId = item.stableId
            }
        }
        return bestStableId
    }

    private fun findHomeHoverTarget(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float
    ): HoverTarget? {
        val draggedItem = adapter.itemByStableId(draggedStableId)
        val draggedView = viewHolder.itemView
        val (draggedCenterX, draggedCenterY) = dragCenterInRecycler(recyclerView)
        val draggedIcon = draggedView.findViewById<android.view.View>(R.id.iconPlate) ?: draggedView
        val dragIconWidth = draggedIcon.width.toFloat()
        val dragIconHeight = draggedIcon.height.toFloat()

        var bestTarget: HoverTarget? = null
        var bestDistance = Float.MAX_VALUE
        for (index in 0 until recyclerView.childCount) {
            val child = recyclerView.getChildAt(index)
            if (child === draggedView) continue

            val holder = recyclerView.getChildViewHolder(child)
            val position = holder.bindingAdapterPosition
            if (position == RecyclerView.NO_POSITION) continue
            val targetItem = adapter.itemAt(position)
            if (targetItem == null || targetItem is LauncherHomeItemUiModel.Placeholder) continue
            val targetStableId = targetItem.stableId
            if (targetStableId == draggedStableId) continue

            val iconPlate = child.findViewById<android.view.View>(R.id.iconPlate) ?: child
            val left = child.left + iconPlate.left.toFloat()
            val top = child.top + iconPlate.top.toFloat()
            val right = child.left + iconPlate.right.toFloat()
            val bottom = child.top + iconPlate.bottom.toFloat()
            if (!LauncherIos17DragGeometryPolicy.intersectsTargetIcon(
                    dragCenterX = draggedCenterX,
                    dragCenterY = draggedCenterY,
                    dragIconWidth = dragIconWidth,
                    dragIconHeight = dragIconHeight,
                    targetLeft = left,
                    targetTop = top,
                    targetRight = right,
                    targetBottom = bottom
                )
            ) {
                continue
            }

            if (iconPlate.width <= 0 || iconPlate.height <= 0) continue
            val plateLeft = child.left + iconPlate.left
            val plateTop = child.top + iconPlate.top
            val localX = ((draggedCenterX - plateLeft) / iconPlate.width).coerceIn(0f, 1f)
            val localY = ((draggedCenterY - plateTop) / iconPlate.height).coerceIn(0f, 1f)
            val hoverAction = LauncherHomeHoverDropPolicy.resolveAction(
                draggedItem = draggedItem,
                targetItem = targetItem,
                localXInCell = localX,
                localYInCell = localY,
                edgeInsertFraction = EDGE_INSERT_FRACTION,
                edgeInsertVerticalFraction = EDGE_INSERT_VERTICAL_FRACTION
            )
            val action = when (hoverAction) {
                LauncherHomeHoverDropAction.INSERT_BEFORE -> HoverAction.INSERT_BEFORE
                LauncherHomeHoverDropAction.INSERT_AFTER -> HoverAction.INSERT_AFTER
                LauncherHomeHoverDropAction.FOLDER -> HoverAction.FOLDER
                null -> null
            } ?: continue

            val targetCenterX = child.left + iconPlate.left + iconPlate.width / 2f
            val targetCenterY = child.top + iconPlate.top + iconPlate.height / 2f
            val distance = (draggedCenterX - targetCenterX).pow(2) + (draggedCenterY - targetCenterY).pow(2)
            if (distance < bestDistance) {
                bestDistance = distance
                bestTarget = HoverTarget(targetStableId, position, action)
            }
        }
        return bestTarget
    }

    private fun findBlankGridDropPosition(recyclerView: RecyclerView): Int {
        val (draggedCenterX, draggedCenterY) = dragCenterInRecycler(recyclerView)
        return LauncherHomeScreenGridPolicy.blankDropPosition(
            draggedCenterX = draggedCenterX,
            draggedCenterY = draggedCenterY,
            gridWidth = recyclerView.width,
            gridHeight = recyclerView.height,
            rows = gridRows(),
            columns = gridColumns(recyclerView),
            itemCount = adapter.itemCount,
            isBlankAtPosition = { position ->
                adapter.itemAt(position) is LauncherHomeItemUiModel.Placeholder
            }
        )
    }

    private fun gridColumns(recyclerView: RecyclerView): Int {
        return (recyclerView.layoutManager as? GridLayoutManager)?.spanCount ?: DEFAULT_GRID_COLUMNS
    }

    private fun dragCenterInRecycler(recyclerView: RecyclerView): Pair<Float, Float> {
        val location = IntArray(2)
        recyclerView.getLocationOnScreen(location)
        return Pair(
            lastDragCenterX - location[0],
            lastDragCenterY - location[1]
        )
    }

    private fun dp(view: android.view.View, value: Int): Float {
        return value * view.resources.displayMetrics.density
    }

    private companion object {
        const val EDGE_INSERT_FRACTION = 0.32f
        const val EDGE_INSERT_VERTICAL_FRACTION = 0.22f
        const val FOLDER_HOVER_ABSORB_DURATION_MS = 240L
        const val DROP_INTO_FOLDER_DURATION_MS = 420L
        const val DROP_FADE_START_PROGRESS = 0.68f
        const val HOME_HOVER_SETTLE_MS = 350L
        const val HOME_REORDER_THROTTLE_MS = 0L
        const val HOME_ICON_REORDER_PREVIEW_MS = 95L
        const val HOME_DROP_SETTLE_MS = 120L
        const val DRAGGED_HOME_ELEVATION_DP = 18
        const val DEFAULT_GRID_COLUMNS = 4
        const val DEFAULT_GRID_ROWS = 6
    }

    private data class HoverTarget(
        val targetStableId: Long,
        val targetPosition: Int,
        val action: HoverAction
    )

    private enum class HoverAction {
        INSERT_BEFORE,
        INSERT_AFTER,
        FOLDER
    }

    private data class DropPreviewAnimation(
        val bitmap: Bitmap,
        val anchorX: Float,
        val anchorY: Float,
        val startCenterX: Float,
        val startCenterY: Float,
        val startScale: Float,
        val startAlpha: Float,
        val targetCenterX: Float,
        val targetCenterY: Float
    )
}

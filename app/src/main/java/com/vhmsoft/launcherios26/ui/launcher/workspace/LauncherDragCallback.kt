package com.vhmsoft.launcherios26.ui.launcher.workspace

import android.graphics.Canvas
import android.graphics.Bitmap
import android.os.SystemClock
import android.view.animation.DecelerateInterpolator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.vhmsoft.launcherios26.R
import kotlin.math.pow

class LauncherDragCallback(
    private val adapter: LauncherIconAdapter,
    private val allowFolderDrop: Boolean = true,
    private val reorderOnMove: Boolean = false,
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
    private var lastHoverTarget: HoverTarget? = null
    private var lastHoverStartedAt = 0L
    private var lastReorderAt = 0L
    private var dragPreviewBitmap: Bitmap? = null
    private var dragPreviewAnchorX = 0f
    private var dragPreviewAnchorY = 0f

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
            draggedStableId = viewHolder?.bindingAdapterPosition
                ?.let { position -> adapter.stableIdAt(position) }
            draggingOutside = false
            externalDragActive = false
            edgeReordered = false
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
            val (centerX, centerY) = dragCenterInRecycler(recyclerView)
            c.drawBitmap(preview, centerX - dragPreviewAnchorX, centerY - dragPreviewAnchorY, null)
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
        if (externalDragActive) {
            viewHolder.itemView.alpha = 0f
            viewHolder.itemView.translationX = 0f
            viewHolder.itemView.translationY = 0f
            return
        }
        if (onDragMoved(draggedItem, viewHolder, lastDragCenterX, lastDragCenterY)) {
            externalDragActive = true
            adapter.clearPendingDropTarget()
            viewHolder.itemView.animate().cancel()
            viewHolder.itemView.alpha = 0f
            viewHolder.itemView.translationX = 0f
            viewHolder.itemView.translationY = 0f
            return
        }

        if (reorderOnMove && !allowFolderDrop) {
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
            val outside = isDroppedOutside(recyclerView, viewHolder, lastDragCenterX, lastDragCenterY)
            if (outside) {
                viewHolder.itemView.alpha = 0f
                if (!draggingOutside) {
                    onDragOutsideChanged(draggedItem, viewHolder, true, lastDragCenterX, lastDragCenterY)
                }
            } else if (draggingOutside) {
                viewHolder.itemView.alpha = 0.96f
                onDragOutsideChanged(draggedItem, viewHolder, false, lastDragCenterX, lastDragCenterY)
            }
            draggingOutside = outside
            return
        }
        if (!allowFolderDrop) return

        hideHomeDraggedViewHolder(viewHolder)
        val hoverTarget = findHomeHoverTarget(recyclerView, viewHolder, dX, dY)
        if (!isHomeHoverReady(hoverTarget)) return
        when (hoverTarget?.action) {
            HoverAction.INSERT_BEFORE -> {
                adapter.clearPendingDropTarget()
                val moved = adapter.moveItemByStableIdBesideTarget(
                    draggedStableId = draggedStableId,
                    targetStableId = hoverTarget.targetStableId,
                    insertAfterTarget = false
                )
                edgeReordered = moved || edgeReordered
                if (moved) resetHoverState()
            }

            HoverAction.INSERT_AFTER -> {
                adapter.clearPendingDropTarget()
                val moved = adapter.moveItemByStableIdBesideTarget(
                    draggedStableId = draggedStableId,
                    targetStableId = hoverTarget.targetStableId,
                    insertAfterTarget = true
                )
                edgeReordered = moved || edgeReordered
                if (moved) resetHoverState()
            }

            HoverAction.FOLDER -> {
                adapter.rememberDropTargetByTargetStableId(draggedStableId, hoverTarget.targetStableId)
            }

            null -> {
                adapter.clearPendingDropTarget()
                val blankCellPosition = findBlankGridDropPosition(recyclerView, viewHolder, dX, dY)
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
        if (onDragEnded(draggedItem, viewHolder, lastDragCenterX, lastDragCenterY)) {
            super.clearView(recyclerView, viewHolder)
            resetDraggedView(viewHolder)
            draggedStableId = null
            draggingOutside = false
            externalDragActive = false
            edgeReordered = false
            resetHoverState()
            clearHomeDragPreview()
            adapter.clearPendingDropTarget()
            return
        }

        if (isDroppedOutside(recyclerView, viewHolder, lastDragCenterX, lastDragCenterY)) {
            super.clearView(recyclerView, viewHolder)
            resetDraggedView(viewHolder)
            val removedItem = draggedStableId?.let { stableId ->
                adapter.removeItemByStableId(stableId, notifyOrder = false)
            }
            draggedStableId = null
            draggingOutside = false
            externalDragActive = false
            edgeReordered = false
            resetHoverState()
            clearHomeDragPreview()
            if (removedItem != null && onDroppedOutside(removedItem)) {
                return
            }
            onDragOutsideChanged(removedItem, viewHolder, false, lastDragCenterX, lastDragCenterY)
        }

        if (!allowFolderDrop) {
            super.clearView(recyclerView, viewHolder)
            resetDraggedView(viewHolder)
            if (draggingOutside) {
                onDragOutsideChanged(
                    adapter.itemByStableId(draggedStableId),
                    viewHolder,
                    false,
                    lastDragCenterX,
                    lastDragCenterY
                )
            }
            draggedStableId = null
            draggingOutside = false
            externalDragActive = false
            edgeReordered = false
            resetHoverState()
            clearHomeDragPreview()
            adapter.notifyOrderChanged()
            return
        }

        val folderTargetStableId = findFolderDropTargetStableId(recyclerView, viewHolder)
        if (folderTargetStableId != null) {
            adapter.rememberDropTargetByTargetStableId(draggedStableId, folderTargetStableId)
        } else if (!adapter.hasPendingDropTarget()) {
            val targetPosition = findDropTargetPosition(
                recyclerView = recyclerView,
                viewHolder = viewHolder,
                dX = viewHolder.itemView.translationX,
                dY = viewHolder.itemView.translationY
            )
            val targetItem = adapter.itemAt(targetPosition)
            if (targetPosition != RecyclerView.NO_POSITION &&
                (!edgeReordered || targetItem is LauncherHomeItemUiModel.Folder)
            ) {
                adapter.rememberDropTargetByStableId(draggedStableId, targetPosition)
            }
        }

        if (adapter.hasPendingDropTarget()) {
            clearHomeDragPreview()
            resetDraggedView(viewHolder)
            adapter.commitPendingDropTarget()
            adapter.notifyOrderChanged()
        } else {
            restoreHomeDraggedViewAtFinger(recyclerView, viewHolder)
            recyclerView.post { settleHomeDraggedView(viewHolder) }
            adapter.notifyOrderChanged()
        }
        draggedStableId = null
        draggingOutside = false
        externalDragActive = false
        edgeReordered = false
        resetHoverState()
    }

    private fun restoreHomeDraggedViewAtFinger(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ) {
        val draggedView = viewHolder.itemView
        val iconPlate = draggedView.findViewById<android.view.View>(R.id.iconPlate) ?: draggedView
        val (centerX, centerY) = dragCenterInRecycler(recyclerView)
        val currentCenterX = draggedView.left + iconPlate.left + iconPlate.width / 2f
        val currentCenterY = draggedView.top + iconPlate.top + iconPlate.height / 2f

        adapter.setActiveDragStableId(null)
        recycleDragPreviewBitmap()
        draggedView.animate().cancel()
        draggedView.alpha = 0.96f
        draggedView.scaleX = 1.08f
        draggedView.scaleY = 1.08f
        draggedView.translationX = centerX - currentCenterX
        draggedView.translationY = centerY - currentCenterY
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
    }

    private fun animateDropIntoFolder(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        targetPosition: Int
    ) {
        val targetView = recyclerView.findViewHolderForAdapterPosition(targetPosition)?.itemView
        val targetPlate = targetView?.findViewById<android.view.View>(R.id.iconPlate) ?: targetView
        val draggedView = viewHolder.itemView
        val targetCenterX = if (targetPlate == null || targetView == null) {
            0f
        } else {
            targetView.left + targetPlate.left + targetPlate.width / 2f
        }
        val targetCenterY = if (targetPlate == null || targetView == null) {
            0f
        } else {
            targetView.top + targetPlate.top + targetPlate.height / 2f
        }
        val draggedPlate = draggedView.findViewById<android.view.View>(R.id.iconPlate) ?: draggedView
        val draggedCenterX = draggedView.left + draggedView.translationX + draggedPlate.left + draggedPlate.width / 2f
        val draggedCenterY = draggedView.top + draggedView.translationY + draggedPlate.top + draggedPlate.height / 2f
        val targetDx = if (targetPlate == null) 0f else targetCenterX - draggedCenterX
        val targetDy = if (targetPlate == null) 0f else targetCenterY - draggedCenterY

        draggedView.animate().cancel()
        draggedView.animate()
            .translationX(draggedView.translationX + targetDx * DROP_INTO_FOLDER_PROGRESS)
            .translationY(draggedView.translationY + targetDy * DROP_INTO_FOLDER_PROGRESS)
            .scaleX(0.42f)
            .scaleY(0.42f)
            .alpha(0.08f)
            .setDuration(150L)
            .withEndAction {
                resetDraggedView(viewHolder)
                adapter.commitPendingDropTarget()
                adapter.notifyOrderChanged()
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
        val touchRaw = adapter.activeTouchRaw()
        if (touchRaw != null) {
            lastDragCenterX = touchRaw.first + touchToCenterOffsetX
            lastDragCenterY = touchRaw.second + touchToCenterOffsetY
            return
        }

        lastDragCenterX = dragStartCenterX + dX
        lastDragCenterY = dragStartCenterY + dY
    }

    private fun findDropTargetPosition(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float
    ): Int {
        val draggedView = viewHolder.itemView
        val (draggedCenterX, draggedCenterY) = dragCenterInRecycler(recyclerView)
        val hitSlop = dp(recyclerView, DROP_TARGET_HIT_SLOP_DP)

        var bestPosition = RecyclerView.NO_POSITION
        var bestDistance = Float.MAX_VALUE
        for (index in 0 until recyclerView.childCount) {
            val child = recyclerView.getChildAt(index)
            if (child === draggedView) continue

            val holder = recyclerView.getChildViewHolder(child)
            val position = holder.bindingAdapterPosition
            if (position == RecyclerView.NO_POSITION) continue

            val iconPlate = child.findViewById<android.view.View>(R.id.iconPlate) ?: child
            val left = child.left + iconPlate.left - hitSlop
            val top = child.top + iconPlate.top - hitSlop
            val right = child.left + iconPlate.right + hitSlop
            val bottom = child.top + iconPlate.bottom + hitSlop
            if (draggedCenterX < left || draggedCenterX > right || draggedCenterY < top || draggedCenterY > bottom) {
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
        val draggedView = viewHolder.itemView
        val (draggedCenterX, draggedCenterY) = dragCenterInRecycler(recyclerView)
        val hitSlop = dp(recyclerView, FOLDER_DROP_HIT_SLOP_DP)

        var bestStableId: Long? = null
        var bestDistance = Float.MAX_VALUE
        for (index in 0 until recyclerView.childCount) {
            val child = recyclerView.getChildAt(index)
            if (child === draggedView) continue

            val holder = recyclerView.getChildViewHolder(child)
            val position = holder.bindingAdapterPosition
            if (position == RecyclerView.NO_POSITION) continue
            val item = adapter.itemAt(position) as? LauncherHomeItemUiModel.Folder ?: continue
            if (item.stableId == draggedStableId) continue

            val iconPlate = child.findViewById<android.view.View>(R.id.iconPlate) ?: child
            val left = child.left + iconPlate.left - hitSlop
            val top = child.top + iconPlate.top - hitSlop
            val right = child.left + iconPlate.right + hitSlop
            val bottom = child.top + iconPlate.bottom + hitSlop
            if (draggedCenterX < left || draggedCenterX > right || draggedCenterY < top || draggedCenterY > bottom) {
                continue
            }

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
        val draggedView = viewHolder.itemView
        val (draggedCenterX, draggedCenterY) = dragCenterInRecycler(recyclerView)
        val hitSlop = dp(recyclerView, EDGE_INSERT_HIT_SLOP_DP)

        var bestTarget: HoverTarget? = null
        var bestDistance = Float.MAX_VALUE
        for (index in 0 until recyclerView.childCount) {
            val child = recyclerView.getChildAt(index)
            if (child === draggedView) continue

            val holder = recyclerView.getChildViewHolder(child)
            val position = holder.bindingAdapterPosition
            if (position == RecyclerView.NO_POSITION) continue
            val targetStableId = adapter.stableIdAt(position) ?: continue
            if (targetStableId == draggedStableId) continue

            val iconPlate = child.findViewById<android.view.View>(R.id.iconPlate) ?: child
            val left = child.left + iconPlate.left - hitSlop
            val top = child.top + iconPlate.top - hitSlop
            val right = child.left + iconPlate.right + hitSlop
            val bottom = child.top + iconPlate.bottom + hitSlop
            if (draggedCenterX < left || draggedCenterX > right || draggedCenterY < top || draggedCenterY > bottom) {
                continue
            }

            val plateLeft = child.left + iconPlate.left
            val plateTop = child.top + iconPlate.top
            val localX = ((draggedCenterX - plateLeft) / iconPlate.width).coerceIn(0f, 1f)
            val localY = ((draggedCenterY - plateTop) / iconPlate.height).coerceIn(0f, 1f)
            val action = when {
                localX <= EDGE_INSERT_FRACTION -> HoverAction.INSERT_BEFORE
                localX >= 1f - EDGE_INSERT_FRACTION -> HoverAction.INSERT_AFTER
                localY <= EDGE_INSERT_VERTICAL_FRACTION -> HoverAction.INSERT_BEFORE
                localY >= 1f - EDGE_INSERT_VERTICAL_FRACTION -> HoverAction.INSERT_AFTER
                else -> HoverAction.FOLDER
            }

            val targetCenterX = child.left + iconPlate.left + iconPlate.width / 2f
            val targetCenterY = child.top + iconPlate.top + iconPlate.height / 2f
            val distance = (draggedCenterX - targetCenterX).pow(2) + (draggedCenterY - targetCenterY).pow(2)
            if (distance < bestDistance) {
                bestDistance = distance
                bestTarget = HoverTarget(targetStableId, action)
            }
        }
        return bestTarget
    }

    private fun findBlankGridDropPosition(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float
    ): Int {
        val draggedView = viewHolder.itemView
        val (draggedCenterX, draggedCenterY) = dragCenterInRecycler(recyclerView)
        if (draggedCenterX < 0f ||
            draggedCenterX > recyclerView.width ||
            draggedCenterY < 0f ||
            draggedCenterY > recyclerView.height
        ) {
            return RecyclerView.NO_POSITION
        }

        val spanCount = (recyclerView.layoutManager as? GridLayoutManager)?.spanCount ?: DEFAULT_GRID_COLUMNS
        val cellWidth = recyclerView.width / spanCount.toFloat()
        val cellHeight = draggedView.height.takeIf { height -> height > 0 }?.toFloat()
            ?: (recyclerView.height / DEFAULT_GRID_ROWS.toFloat())
        val column = (draggedCenterX / cellWidth).toInt().coerceIn(0, spanCount - 1)
        val row = (draggedCenterY / cellHeight).toInt().coerceAtLeast(0)
        val gridIndex = row * spanCount + column
        if (gridIndex < adapter.itemCount) return RecyclerView.NO_POSITION

        return adapter.itemCount - 1
    }

    private fun dragCenterInRecycler(recyclerView: RecyclerView): Pair<Float, Float> {
        val location = IntArray(2)
        recyclerView.getLocationOnScreen(location)
        return Pair(
            lastDragCenterX - location[0],
            lastDragCenterY - location[1]
        )
    }

    private fun dp(recyclerView: RecyclerView, value: Int): Float {
        return value * recyclerView.resources.displayMetrics.density
    }

    private fun dp(view: android.view.View, value: Int): Float {
        return value * view.resources.displayMetrics.density
    }

    private companion object {
        const val DROP_TARGET_HIT_SLOP_DP = 46
        const val FOLDER_DROP_HIT_SLOP_DP = 26
        const val EDGE_INSERT_HIT_SLOP_DP = 18
        const val EDGE_INSERT_FRACTION = 0.32f
        const val EDGE_INSERT_VERTICAL_FRACTION = 0.22f
        const val DROP_INTO_FOLDER_PROGRESS = 0.78f
        const val HOME_HOVER_SETTLE_MS = 45L
        const val HOME_REORDER_THROTTLE_MS = 95L
        const val HOME_DROP_SETTLE_MS = 120L
        const val DRAGGED_HOME_ELEVATION_DP = 18
        const val DEFAULT_GRID_COLUMNS = 4
        const val DEFAULT_GRID_ROWS = 6
    }

    private data class HoverTarget(
        val targetStableId: Long,
        val action: HoverAction
    )

    private enum class HoverAction {
        INSERT_BEFORE,
        INSERT_AFTER,
        FOLDER
    }
}

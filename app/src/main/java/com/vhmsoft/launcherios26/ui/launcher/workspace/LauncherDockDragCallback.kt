package com.vhmsoft.launcherios26.ui.launcher.workspace

import android.graphics.Canvas
import android.os.SystemClock
import android.view.View
import android.view.animation.DecelerateInterpolator
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.vhmsoft.launcherios26.R
import kotlin.math.pow

class LauncherDockDragCallback(
    private val adapter: LauncherDockAdapter,
    private val isDragCenterInDock: (Float, Float) -> Boolean,
    private val onDragMoved: (
        LauncherHomeItemUiModel,
        RecyclerView.ViewHolder,
        Float,
        Float
    ) -> Boolean = { _, _, _, _ -> false },
    private val onDragEnded: (
        LauncherHomeItemUiModel,
        RecyclerView.ViewHolder,
        Float,
        Float
    ) -> Boolean = { _, _, _, _ -> false }
) : ItemTouchHelper.Callback() {
    private var draggedStableId: Long? = null
    private var dragStartCenterX = 0f
    private var dragStartCenterY = 0f
    private var lastDragCenterX = 0f
    private var lastDragCenterY = 0f
    private var touchToCenterOffsetX = 0f
    private var touchToCenterOffsetY = 0f
    private var externalDragActive = false
    private var lastHoverTargetPosition = RecyclerView.NO_POSITION
    private var lastHoverStartedAt = 0L

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
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) = Unit

    override fun isLongPressDragEnabled(): Boolean = false

    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
        super.onSelectedChanged(viewHolder, actionState)
        if (actionState != ItemTouchHelper.ACTION_STATE_DRAG) return

        externalDragActive = false
        resetDockReorderState()
        draggedStableId = viewHolder?.bindingAdapterPosition
            ?.let { position -> adapter.stableIdAt(position) }
        viewHolder?.let { holder ->
            rememberDragStartCenter(holder)
            holder.itemView.animate().cancel()
            holder.itemView.animate()
                .scaleX(DRAG_SCALE)
                .scaleY(DRAG_SCALE)
                .alpha(DRAG_ALPHA)
                .setDuration(DRAG_LIFT_DURATION_MS)
                .setInterpolator(DecelerateInterpolator())
                .start()
            holder.itemView.elevation = dp(holder.itemView, DRAG_ELEVATION_DP)
        }
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
        if (actionState == ItemTouchHelper.ACTION_STATE_DRAG && isCurrentlyActive) {
            updateDragCenter(dX, dY)
            val draggedItem = adapter.itemByStableId(draggedStableId)
            if (externalDragActive) {
                val stillHandledExternally = draggedItem?.let { item ->
                    onDragMoved(item, viewHolder, lastDragCenterX, lastDragCenterY)
                } == true
                if (stillHandledExternally) {
                    hideDraggedView(viewHolder)
                    return
                }
                externalDragActive = false
                resetDraggedView(viewHolder)
            }
            if (draggedItem != null &&
                onDragMoved(draggedItem, viewHolder, lastDragCenterX, lastDragCenterY)
            ) {
                externalDragActive = true
                adapter.clearPendingDropTarget()
                hideDraggedView(viewHolder)
                return
            }
            val targetStableId = if (isDragCenterInDock(lastDragCenterX, lastDragCenterY)) {
                findDockDropTargetStableId(recyclerView, viewHolder)
            } else {
                null
            }
            if (targetStableId == null) {
                adapter.clearPendingDropTarget()
                if (isDragCenterInDock(lastDragCenterX, lastDragCenterY)) {
                    updateDockReorder(recyclerView)
                } else {
                    resetDockReorderState()
                }
            } else {
                resetDockReorderState()
                adapter.rememberDropTargetByTargetStableId(draggedStableId, targetStableId)
            }
        }
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    }

    override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
        val draggedItem = adapter.itemByStableId(draggedStableId)
        val folderTargetStableId = if (isDragCenterInDock(lastDragCenterX, lastDragCenterY)) {
            findDockDropTargetStableId(recyclerView, viewHolder)
        } else {
            null
        }
        if (folderTargetStableId != null) {
            adapter.rememberDropTargetByTargetStableId(draggedStableId, folderTargetStableId)
        }
        if (adapter.hasPendingDropTarget()) {
            super.clearView(recyclerView, viewHolder)
            resetDraggedView(viewHolder)
            adapter.commitPendingDropTarget()
            adapter.notifyOrderChanged()
            draggedStableId = null
            resetDockReorderState()
            adapter.clearActiveTouch()
            return
        }

        val handledOutside = draggedItem?.let { item ->
            onDragEnded(item, viewHolder, lastDragCenterX, lastDragCenterY)
        } == true

        super.clearView(recyclerView, viewHolder)
        if (handledOutside && externalDragActive) {
            hideDraggedView(viewHolder)
        } else {
            resetDraggedView(viewHolder)
        }
        draggedStableId = null
        externalDragActive = false
        resetDockReorderState()
        adapter.clearActiveTouch()

        if (!handledOutside) {
            adapter.notifyOrderChanged()
        }
    }

    private fun findDockDropTargetStableId(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Long? {
        val draggedItem = adapter.itemByStableId(draggedStableId)
        val draggedView = viewHolder.itemView
        val recyclerLocation = IntArray(2)
        recyclerView.getLocationOnScreen(recyclerLocation)
        val draggedCenterX = lastDragCenterX - recyclerLocation[0]
        val draggedCenterY = lastDragCenterY - recyclerLocation[1]
        val draggedIcon = draggedView.findViewById<View>(R.id.iconPlate) ?: draggedView
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
            val stableId = adapter.stableIdAt(position) ?: continue
            if (stableId == draggedStableId) continue
            val targetItem = adapter.itemAt(position) ?: continue

            val iconPlate = child.findViewById<View>(R.id.iconPlate) ?: child
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
                targetItem = targetItem,
                localXInCell = localX,
                localYInCell = localY
            )
            if (action != LauncherHomeHoverDropAction.FOLDER) continue

            val targetCenterX = child.left + iconPlate.left + iconPlate.width / 2f
            val targetCenterY = child.top + iconPlate.top + iconPlate.height / 2f
            val distance = (draggedCenterX - targetCenterX).pow(2) +
                (draggedCenterY - targetCenterY).pow(2)
            if (distance < bestDistance) {
                bestDistance = distance
                bestStableId = stableId
            }
        }
        return bestStableId
    }

    private fun updateDockReorder(recyclerView: RecyclerView) {
        val targetPosition = findDockHoverTargetPosition(recyclerView)
        if (targetPosition == RecyclerView.NO_POSITION) {
            resetDockReorderState()
            return
        }

        val now = SystemClock.uptimeMillis()
        if (targetPosition != lastHoverTargetPosition) {
            lastHoverTargetPosition = targetPosition
            lastHoverStartedAt = now
            return
        }

        val canReorder = LauncherIos17DragDropPolicy.canDockReorder(
            dockItemCount = adapter.itemCount,
            maxDockItems = MAX_DOCK_ITEMS,
            parentPage = LauncherIos17DragDropPolicy.DOCK_PARENT_PAGE
        )
        if (!canReorder ||
            !LauncherIos17DragDropPolicy.shouldFireReorderAlarm(
                folderInterest = false,
                targetIndex = targetPosition,
                hoverElapsedMs = now - lastHoverStartedAt
            )
        ) {
            return
        }

        val fromPosition = positionOfStableId(draggedStableId)
        if (fromPosition != RecyclerView.NO_POSITION && fromPosition != targetPosition) {
            adapter.moveItem(fromPosition, targetPosition)
        }
        resetDockReorderState()
    }

    private fun findDockHoverTargetPosition(recyclerView: RecyclerView): Int {
        val draggedView = recyclerView.findViewHolderForAdapterPosition(
            positionOfStableId(draggedStableId)
        )?.itemView
        val recyclerLocation = IntArray(2)
        recyclerView.getLocationOnScreen(recyclerLocation)
        val draggedCenterX = lastDragCenterX - recyclerLocation[0]
        val draggedCenterY = lastDragCenterY - recyclerLocation[1]
        val dragIcon = draggedView?.findViewById<View>(R.id.iconPlate) ?: draggedView
        val activeDragIcon = dragIcon ?: return RecyclerView.NO_POSITION
        val dragIconWidth = activeDragIcon.width.toFloat()
        val dragIconHeight = activeDragIcon.height.toFloat()

        var bestPosition = RecyclerView.NO_POSITION
        var bestDistance = Float.MAX_VALUE
        for (index in 0 until recyclerView.childCount) {
            val child = recyclerView.getChildAt(index)
            if (child === draggedView) continue

            val holder = recyclerView.getChildViewHolder(child)
            val position = holder.bindingAdapterPosition
            if (position == RecyclerView.NO_POSITION) continue
            if (adapter.stableIdAt(position) == draggedStableId) continue

            val iconPlate = child.findViewById<View>(R.id.iconPlate) ?: child
            if (iconPlate.width <= 0 || iconPlate.height <= 0) continue
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

            val targetCenterX = child.left + iconPlate.left + iconPlate.width / 2f
            val targetCenterY = child.top + iconPlate.top + iconPlate.height / 2f
            val distance = (draggedCenterX - targetCenterX).pow(2) +
                (draggedCenterY - targetCenterY).pow(2)
            if (distance < bestDistance) {
                bestDistance = distance
                bestPosition = position
            }
        }
        return bestPosition
    }

    private fun positionOfStableId(stableId: Long?): Int {
        if (stableId == null) return RecyclerView.NO_POSITION
        for (position in 0 until adapter.itemCount) {
            if (adapter.stableIdAt(position) == stableId) return position
        }
        return RecyclerView.NO_POSITION
    }

    private fun resetDockReorderState() {
        lastHoverTargetPosition = RecyclerView.NO_POSITION
        lastHoverStartedAt = 0L
    }

    private fun rememberDragStartCenter(viewHolder: RecyclerView.ViewHolder) {
        val draggedView = viewHolder.itemView
        val iconPlate = draggedView.findViewById<View>(R.id.iconPlate) ?: draggedView
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

    private fun resetDraggedView(viewHolder: RecyclerView.ViewHolder) {
        viewHolder.itemView.animate().cancel()
        viewHolder.itemView.translationX = 0f
        viewHolder.itemView.translationY = 0f
        viewHolder.itemView.scaleX = 1f
        viewHolder.itemView.scaleY = 1f
        viewHolder.itemView.alpha = 1f
        viewHolder.itemView.elevation = 0f
    }

    private fun hideDraggedView(viewHolder: RecyclerView.ViewHolder) {
        viewHolder.itemView.animate().cancel()
        viewHolder.itemView.translationX = 0f
        viewHolder.itemView.translationY = 0f
        viewHolder.itemView.scaleX = 1f
        viewHolder.itemView.scaleY = 1f
        viewHolder.itemView.alpha = 0f
        viewHolder.itemView.elevation = 0f
    }

    private fun dp(view: View, value: Int): Float {
        return value * view.resources.displayMetrics.density
    }

    private companion object {
        const val DRAG_SCALE = 1.08f
        const val DRAG_ALPHA = 0.96f
        const val DRAG_LIFT_DURATION_MS = 120L
        const val DRAG_ELEVATION_DP = 18
        const val MAX_DOCK_ITEMS = 4
    }
}

package com.vhmsoft.launcherios26.ui.launcher.workspace

import android.graphics.Canvas
import android.view.View
import android.view.animation.DecelerateInterpolator
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.vhmsoft.launcherios26.R

class LauncherDockDragCallback(
    private val adapter: LauncherDockAdapter,
    private val isDragCenterInDock: (Float, Float) -> Boolean,
    private val onDragEnded: (
        LauncherIconUiModel,
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
        if (!isDragCenterInDock(lastDragCenterX, lastDragCenterY)) return false
        return adapter.moveItem(viewHolder.bindingAdapterPosition, target.bindingAdapterPosition)
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) = Unit

    override fun isLongPressDragEnabled(): Boolean = false

    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
        super.onSelectedChanged(viewHolder, actionState)
        if (actionState != ItemTouchHelper.ACTION_STATE_DRAG) return

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
        }
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    }

    override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
        val draggedItem = adapter.itemByStableId(draggedStableId)
        val handledOutside = draggedItem?.let { item ->
            onDragEnded(item, viewHolder, lastDragCenterX, lastDragCenterY)
        } == true

        super.clearView(recyclerView, viewHolder)
        resetDraggedView(viewHolder)
        draggedStableId = null
        adapter.clearActiveTouch()

        if (!handledOutside) {
            adapter.notifyOrderChanged()
        }
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

    private fun dp(view: View, value: Int): Float {
        return value * view.resources.displayMetrics.density
    }

    private companion object {
        const val DRAG_SCALE = 1.08f
        const val DRAG_ALPHA = 0.96f
        const val DRAG_LIFT_DURATION_MS = 120L
        const val DRAG_ELEVATION_DP = 18
    }
}

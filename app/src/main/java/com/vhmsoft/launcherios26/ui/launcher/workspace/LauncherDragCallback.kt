package com.vhmsoft.launcherios26.ui.launcher.workspace

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class LauncherDragCallback(
    private val adapter: LauncherIconAdapter
) : ItemTouchHelper.Callback() {
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
        adapter.rememberDropTarget(viewHolder.bindingAdapterPosition, target.bindingAdapterPosition)
        return adapter.moveItem(viewHolder.bindingAdapterPosition, target.bindingAdapterPosition)
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) = Unit

    override fun isLongPressDragEnabled(): Boolean = false

    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
        super.onSelectedChanged(viewHolder, actionState)
        if (actionState == ItemTouchHelper.ACTION_STATE_DRAG) {
            viewHolder?.itemView?.animate()
                ?.scaleX(1.08f)
                ?.scaleY(1.08f)
                ?.setDuration(120L)
                ?.start()
            viewHolder?.itemView?.elevation = 18f
        }
    }

    override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
        super.clearView(recyclerView, viewHolder)
        viewHolder.itemView.animate()
            .scaleX(1f)
            .scaleY(1f)
            .setDuration(160L)
            .start()
        viewHolder.itemView.elevation = 0f
        adapter.commitPendingDropTarget()
        adapter.notifyOrderChanged()
    }
}

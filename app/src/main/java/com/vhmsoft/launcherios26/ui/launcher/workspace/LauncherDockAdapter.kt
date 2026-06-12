package com.vhmsoft.launcherios26.ui.launcher.workspace

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.vhmsoft.launcherios26.databinding.ItemLauncherDockIconBinding
import java.util.Collections

class LauncherDockAdapter(
    private val onIconClicked: (LauncherIconUiModel) -> Unit,
    private val onRemoveClicked: (LauncherIconUiModel) -> Unit = {},
    private val onDragRequested: (RecyclerView.ViewHolder) -> Unit = {},
    private val onOrderChanged: (List<LauncherIconUiModel>) -> Unit = {}
) : RecyclerView.Adapter<LauncherDockAdapter.DockViewHolder>() {
    private val items = mutableListOf<LauncherIconUiModel>()
    private var editing = false
    private var iconSizeDp = DEFAULT_ICON_SIZE_DP
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

    fun submitApps(apps: List<LauncherIconUiModel>) {
        items.clear()
        items.addAll(apps)
        notifyDataSetChanged()
    }

    fun setEditing(enabled: Boolean) {
        if (editing == enabled) return
        editing = enabled
        notifyDataSetChanged()
    }

    fun setIconSizeDp(sizeDp: Int) {
        val boundedSize = sizeDp.coerceIn(MIN_ICON_SIZE_DP, MAX_ICON_SIZE_DP)
        if (iconSizeDp == boundedSize) return
        iconSizeDp = boundedSize
        notifyDataSetChanged()
    }

    fun isEditing(): Boolean = editing

    fun stableIdAt(position: Int): Long? {
        return items.getOrNull(position)?.stableId
    }

    fun itemByStableId(stableId: Long?): LauncherIconUiModel? {
        if (stableId == null) return null
        return items.firstOrNull { item -> item.stableId == stableId }
    }

    fun itemsSnapshot(): List<LauncherIconUiModel> {
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
        notifyItemMoved(fromPosition, toPosition)
        return true
    }

    fun notifyOrderChanged() {
        onOrderChanged(items.toList())
    }

    inner class DockViewHolder(
        private val binding: ItemLauncherDockIconBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LauncherIconUiModel) {
            binding.root.setOnClickListener(null)
            binding.appIcon.setImageDrawable(item.displayIcon)
            binding.appIcon.contentDescription = item.label
            applyIconSize()
            binding.iconPlate.setOnClickListener {
                if (!editing) {
                    onIconClicked(item)
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
            binding.removeBadge.visibility = if (editing) View.VISIBLE else View.GONE
            binding.removeBadge.setOnClickListener { onRemoveClicked(item) }
            applyEditAnimation()
        }

        private fun applyEditAnimation() {
            binding.root.animate().cancel()
            if (editing) {
                val startRotation = if (bindingAdapterPosition % 2 == 0) -1.4f else 1.4f
                binding.root.rotation = startRotation
                binding.root.post { animateWiggle(binding.root, startRotation < 0) }
            } else {
                binding.root.rotation = 0f
            }
        }

        private fun animateWiggle(view: View, rotateRight: Boolean) {
            if (!editing || !view.isAttachedToWindow) return

            view.animate()
                .rotation(if (rotateRight) 1.4f else -1.4f)
                .setDuration(100L)
                .setInterpolator(LinearInterpolator())
                .withEndAction { animateWiggle(view, !rotateRight) }
                .start()
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

    private companion object {
        const val MIN_ICON_SIZE_DP = 52
        const val DEFAULT_ICON_SIZE_DP = 64
        const val MAX_ICON_SIZE_DP = 78
    }
}

package com.bg.global.ioslauncher.ui.launcher.workspace

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.bg.global.ioslauncher.databinding.ItemLauncherIconBinding
import java.util.Collections
import kotlin.math.max
import kotlin.math.min

class LauncherIconAdapter(
    private val onIconClicked: (LauncherIconUiModel) -> Unit,
    private val onIconLongClicked: (LauncherIconUiModel, View) -> Boolean = { _, _ -> false },
    private val onRemoveClicked: (LauncherIconUiModel) -> Unit = {},
    private val onOrderChanged: (List<LauncherIconUiModel>) -> Unit = {}
) : RecyclerView.Adapter<LauncherIconAdapter.IconViewHolder>() {
    private val items = mutableListOf<LauncherIconUiModel>()
    private var itemHeightPx: Int = 0
    private var editing = false

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

    fun submitApps(apps: List<LauncherIconUiModel>) {
        items.clear()
        items.addAll(apps)
        notifyDataSetChanged()
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

    fun notifyOrderChanged() {
        onOrderChanged(items.toList())
    }

    inner class IconViewHolder(
        private val binding: ItemLauncherIconBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LauncherIconUiModel) {
            binding.item = item
            applyFixedCellSize()
            binding.root.setOnClickListener(null)
            binding.root.setOnLongClickListener(null)
            binding.iconPlate.setOnClickListener {
                if (!editing) {
                    onIconClicked(item)
                }
            }
            binding.iconPlate.setOnLongClickListener { onIconLongClicked(item, binding.iconPlate) }
            binding.removeBadge.visibility = if (editing) View.VISIBLE else View.GONE
            binding.removeBadge.setOnClickListener { onRemoveClicked(item) }
            applyEditAnimation()
            binding.executePendingBindings()
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
}

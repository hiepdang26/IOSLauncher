package com.vhmsoft.launcherios26.ui.launcher.workspace

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.vhmsoft.launcherios26.databinding.ItemLauncherDockIconBinding

class LauncherDockAdapter(
    private val onIconClicked: (LauncherIconUiModel) -> Unit,
    private val onRemoveClicked: (LauncherIconUiModel) -> Unit = {}
) : RecyclerView.Adapter<LauncherDockAdapter.DockViewHolder>() {
    private val items = mutableListOf<LauncherIconUiModel>()
    private var editing = false

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

    inner class DockViewHolder(
        private val binding: ItemLauncherDockIconBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LauncherIconUiModel) {
            binding.item = item
            binding.root.setOnClickListener(null)
            binding.iconPlate.setOnClickListener {
                if (!editing) {
                    onIconClicked(item)
                }
            }
            binding.removeBadge.visibility = if (editing) View.VISIBLE else View.GONE
            binding.removeBadge.setOnClickListener { onRemoveClicked(item) }
            applyEditAnimation()
            binding.executePendingBindings()
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
    }
}

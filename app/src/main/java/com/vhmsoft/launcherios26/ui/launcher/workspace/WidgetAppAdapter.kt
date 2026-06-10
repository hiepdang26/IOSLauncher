package com.vhmsoft.launcherios26.ui.launcher.workspace

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vhmsoft.launcherios26.databinding.ItemWidgetAppBinding
import java.util.Locale

class WidgetAppAdapter(
    private val onAppClicked: (LauncherIconUiModel) -> Unit = {}
) : RecyclerView.Adapter<WidgetAppAdapter.WidgetAppViewHolder>() {
    private val items = mutableListOf<LauncherIconUiModel>()

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WidgetAppViewHolder {
        val binding = ItemWidgetAppBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return WidgetAppViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WidgetAppViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    override fun getItemId(position: Int): Long = items[position].stableId

    fun submitApps(apps: List<LauncherIconUiModel>) {
        items.clear()
        items.addAll(apps.sortedBy { item -> item.label.lowercase(Locale.getDefault()) })
        notifyDataSetChanged()
    }

    inner class WidgetAppViewHolder(
        private val binding: ItemWidgetAppBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LauncherIconUiModel) {
            binding.item = item
            binding.root.setOnClickListener { onAppClicked(item) }
            binding.executePendingBindings()
        }
    }
}

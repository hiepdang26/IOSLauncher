package com.vhmsoft.launcherios26.ui.applibrary

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vhmsoft.launcherios26.databinding.ItemAppLibrarySettingBinding
import com.vhmsoft.launcherios26.ui.launcher.workspace.LauncherIconUiModel

class AppLibraryAdapter(
    private val onAppClicked: (LauncherIconUiModel) -> Unit
) : RecyclerView.Adapter<AppLibraryAdapter.AppViewHolder>() {
    private val items = mutableListOf<LauncherIconUiModel>()

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val binding = ItemAppLibrarySettingBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return AppViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    override fun getItemId(position: Int): Long = items[position].stableId

    fun submitApps(apps: List<LauncherIconUiModel>) {
        items.clear()
        items.addAll(apps)
        notifyDataSetChanged()
    }

    inner class AppViewHolder(
        private val binding: ItemAppLibrarySettingBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LauncherIconUiModel) {
            binding.item = item
            binding.root.setOnClickListener { onAppClicked(item) }
            binding.executePendingBindings()
        }
    }
}

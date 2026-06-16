package com.vhmsoft.launcherios26.ui.launcher.workspace

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vhmsoft.launcherios26.databinding.ItemWidgetAppBinding

class WidgetAppAdapter(
    private val onAppClicked: (LauncherIconUiModel) -> Unit = {}
) : RecyclerView.Adapter<WidgetAppAdapter.WidgetAppViewHolder>() {
    private val items = mutableListOf<LauncherIconUiModel>()
    private val suggestionSeed = System.currentTimeMillis()

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
        items.addAll(
            LauncherTodayAppSuggester.select(
                apps = apps,
                limit = WIDGET_APP_SUGGESTION_COUNT,
                stableKey = { item -> item.app.iconKey },
                seed = suggestionSeed
            )
        )
        notifyDataSetChanged()
    }

    inner class WidgetAppViewHolder(
        private val binding: ItemWidgetAppBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LauncherIconUiModel) {
            binding.appIcon.setImageDrawable(item.displayIcon)
            binding.appIcon.contentDescription = item.label
            binding.appLabel.text = item.label
            binding.root.setOnClickListener { onAppClicked(item) }
        }
    }

    private companion object {
        const val WIDGET_APP_SUGGESTION_COUNT = 8
    }
}

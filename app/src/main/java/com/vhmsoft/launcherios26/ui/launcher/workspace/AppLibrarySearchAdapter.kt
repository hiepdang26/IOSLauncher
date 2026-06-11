package com.vhmsoft.launcherios26.ui.launcher.workspace

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vhmsoft.launcherios26.databinding.ItemAppLibrarySearchAppBinding
import java.text.Normalizer
import java.util.Locale

class AppLibrarySearchAdapter(
    private val onAppClicked: (LauncherIconUiModel) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val rows = mutableListOf<Row>()
    private val sectionPositions = linkedMapOf<String, Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_SECTION) {
            val view = LayoutInflater.from(parent.context).inflate(
                com.vhmsoft.launcherios26.R.layout.item_app_library_search_section,
                parent,
                false
            ) as TextView
            SectionViewHolder(view)
        } else {
            val binding = ItemAppLibrarySearchAppBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            AppViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val row = rows[position]) {
            is Row.Section -> (holder as SectionViewHolder).bind(row.title)
            is Row.App -> (holder as AppViewHolder).bind(row.item)
        }
    }

    override fun getItemCount(): Int = rows.size

    override fun getItemViewType(position: Int): Int {
        return when (rows[position]) {
            is Row.Section -> VIEW_TYPE_SECTION
            is Row.App -> VIEW_TYPE_APP
        }
    }

    fun submitApps(apps: List<LauncherIconUiModel>): Map<String, Int> {
        rows.clear()
        sectionPositions.clear()

        apps.sortedBy { item -> item.label.lowercase(Locale.getDefault()) }
            .groupBy { item -> sectionFor(item.label) }
            .toSortedMap(sectionComparator)
            .forEach { (section, sectionApps) ->
                sectionPositions[section] = rows.size
                rows.add(Row.Section(section))
                sectionApps.forEach { item -> rows.add(Row.App(item)) }
            }
        notifyDataSetChanged()
        return sectionPositions.toMap()
    }

    fun positionForSection(section: String): Int? = sectionPositions[section]

    private fun sectionFor(label: String): String {
        val normalized = Normalizer.normalize(label.trim(), Normalizer.Form.NFD)
            .replace("\\p{Mn}+".toRegex(), "")
        val first = normalized.firstOrNull()?.uppercaseChar() ?: '#'
        return when {
            first.isDigit() -> first.toString()
            first in 'A'..'Z' -> first.toString()
            else -> "#"
        }
    }

    inner class SectionViewHolder(
        private val titleView: TextView
    ) : RecyclerView.ViewHolder(titleView) {
        fun bind(title: String) {
            titleView.text = title
        }
    }

    inner class AppViewHolder(
        private val binding: ItemAppLibrarySearchAppBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LauncherIconUiModel) {
            binding.appIcon.setImageDrawable(item.icon)
            binding.appIcon.contentDescription = item.label
            binding.appLabel.text = item.label
            binding.root.setOnClickListener { onAppClicked(item) }
        }
    }

    private sealed class Row {
        data class Section(val title: String) : Row()
        data class App(val item: LauncherIconUiModel) : Row()
    }

    private companion object {
        const val VIEW_TYPE_SECTION = 1
        const val VIEW_TYPE_APP = 2

        val sectionComparator = Comparator<String> { first, second ->
            val firstDigit = first.firstOrNull()?.isDigit() == true
            val secondDigit = second.firstOrNull()?.isDigit() == true
            when {
                first == second -> 0
                firstDigit && !secondDigit -> -1
                !firstDigit && secondDigit -> 1
                first == "#" -> 1
                second == "#" -> -1
                else -> first.compareTo(second)
            }
        }
    }
}

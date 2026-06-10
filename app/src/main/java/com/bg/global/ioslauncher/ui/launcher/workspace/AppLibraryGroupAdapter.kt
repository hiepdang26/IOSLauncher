package com.bg.global.ioslauncher.ui.launcher.workspace

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bg.global.ioslauncher.R
import com.bg.global.ioslauncher.databinding.ItemAppLibraryGroupBinding

class AppLibraryGroupAdapter(
    private val onGroupClicked: (AppLibraryGroupUiModel) -> Unit = {}
) : RecyclerView.Adapter<AppLibraryGroupAdapter.GroupViewHolder>() {
    private val items = mutableListOf<AppLibraryGroupUiModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val binding = ItemAppLibraryGroupBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GroupViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun submitGroups(groups: List<AppLibraryGroupUiModel>) {
        items.clear()
        items.addAll(groups)
        notifyDataSetChanged()
    }

    inner class GroupViewHolder(
        private val binding: ItemAppLibraryGroupBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private val previewViews: List<ImageView> = listOf(
            binding.previewIcon1,
            binding.previewIcon2,
            binding.previewIcon3
        )
        private val overflowViews: List<ImageView> = listOf(
            binding.overflowIcon1,
            binding.overflowIcon2,
            binding.overflowIcon3,
            binding.overflowIcon4
        )

        fun bind(item: AppLibraryGroupUiModel) {
            binding.categoryLabel.text = item.title
            binding.folderCard.setBackgroundResource(
                if (item.apps.isEmpty()) R.drawable.bg_app_library_folder_empty else R.drawable.bg_app_library_folder
            )
            previewViews.forEachIndexed { index, imageView ->
                val previewApp = item.apps.getOrNull(index)
                imageView.visibility = if (previewApp == null) View.INVISIBLE else View.VISIBLE
                imageView.setImageDrawable(previewApp?.icon)
            }
            bindFourthSlot(item)
            binding.root.setOnClickListener { onGroupClicked(item) }
        }

        private fun bindFourthSlot(item: AppLibraryGroupUiModel) {
            val useOverflowCluster = item.apps.size > FULL_SIZE_PREVIEW_COUNT
            binding.previewIcon4.visibility = if (useOverflowCluster) View.GONE else View.VISIBLE
            binding.overflowPreviewCluster.visibility = if (useOverflowCluster) View.VISIBLE else View.GONE

            if (useOverflowCluster) {
                val overflowApps = item.apps.drop(MAX_LARGE_PREVIEW_COUNT).take(OVERFLOW_PREVIEW_COUNT)
                overflowViews.forEachIndexed { index, imageView ->
                    val previewApp = overflowApps.getOrNull(index)
                    imageView.visibility = if (previewApp == null) View.INVISIBLE else View.VISIBLE
                    imageView.setImageDrawable(previewApp?.icon)
                }
            } else {
                val previewApp = item.apps.getOrNull(3)
                binding.previewIcon4.visibility = if (previewApp == null) View.INVISIBLE else View.VISIBLE
                binding.previewIcon4.setImageDrawable(previewApp?.icon)
            }
        }
    }

    private companion object {
        const val MAX_LARGE_PREVIEW_COUNT = 3
        const val FULL_SIZE_PREVIEW_COUNT = 4
        const val OVERFLOW_PREVIEW_COUNT = 4
    }
}

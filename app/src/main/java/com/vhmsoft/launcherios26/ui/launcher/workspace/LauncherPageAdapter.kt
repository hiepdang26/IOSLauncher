package com.vhmsoft.launcherios26.ui.launcher.workspace

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.vhmsoft.launcherios26.databinding.ItemAppLibraryPageBinding
import com.vhmsoft.launcherios26.databinding.ItemLauncherPageBinding

class LauncherPageAdapter(
    private val onIconClicked: (LauncherIconUiModel) -> Unit,
    private val onIconLongClicked: (LauncherIconUiModel, View) -> Boolean,
    private val onRemoveClicked: (LauncherIconUiModel) -> Unit = {},
    private val onFolderClicked: (LauncherHomeItemUiModel.Folder) -> Unit = {},
    private val onHomeItemsChanged: (List<LauncherHomeItemUiModel>) -> Unit = {},
    private val onLibrarySearchClicked: () -> Unit = {},
    private val onLibraryGroupClicked: (AppLibraryGroupUiModel) -> Unit = {}
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val pages = mutableListOf<List<LauncherHomeItemUiModel>>()
    private val libraryGroups = mutableListOf<AppLibraryGroupUiModel>()
    private var editing = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_LIBRARY -> {
                val binding = ItemAppLibraryPageBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                AppLibraryViewHolder(binding)
            }

            else -> {
                val binding = ItemLauncherPageBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                PageViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PageViewHolder -> holder.bind(pages[position])
            is AppLibraryViewHolder -> holder.bind(libraryGroups)
        }
    }

    override fun getItemCount(): Int = pages.size + LIBRARY_PAGE_COUNT

    override fun getItemViewType(position: Int): Int {
        return if (position >= pages.size) VIEW_TYPE_LIBRARY else VIEW_TYPE_HOME
    }

    fun submitItems(items: List<LauncherHomeItemUiModel>) {
        pages.clear()
        pages.addAll(items.chunked(PAGE_SIZE))
        notifyDataSetChanged()
    }

    fun submitApps(apps: List<LauncherIconUiModel>) {
        submitItems(apps.map { app -> LauncherHomeItemUiModel.App(app) })
    }

    fun submitLibraryGroups(groups: List<AppLibraryGroupUiModel>) {
        libraryGroups.clear()
        libraryGroups.addAll(groups)
        notifyDataSetChanged()
    }

    fun setEditing(enabled: Boolean) {
        if (editing == enabled) return
        editing = enabled
        notifyDataSetChanged()
    }

    inner class PageViewHolder(
        private val binding: ItemLauncherPageBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private lateinit var itemTouchHelper: ItemTouchHelper
        private val pageAdapter = LauncherIconAdapter(
            onIconClicked = onIconClicked,
            onIconLongClicked = onIconLongClicked,
            onRemoveClicked = onRemoveClicked,
            onFolderClicked = onFolderClicked,
            onDragRequested = { holder ->
                if (::itemTouchHelper.isInitialized) {
                    itemTouchHelper.startDrag(holder)
                }
            },
            onOrderChanged = { pageItems ->
                handlePageItemsChanged(bindingAdapterPosition, pageItems)
            }
        )

        init {
            itemTouchHelper = ItemTouchHelper(LauncherDragCallback(pageAdapter))
            binding.pageRecyclerView.apply {
                layoutManager = FixedPageGridLayoutManager(context, PAGE_COLUMNS)
                adapter = pageAdapter
                itemTouchHelper.attachToRecyclerView(this)
                setHasFixedSize(true)
                itemAnimator = null
                isNestedScrollingEnabled = false
                overScrollMode = View.OVER_SCROLL_NEVER
                post {
                    pageAdapter.setItemHeight(height / PAGE_ROWS)
                }
            }
        }

        fun bind(items: List<LauncherHomeItemUiModel>) {
            pageAdapter.setEditing(editing)
            pageAdapter.submitItems(items)
            binding.pageRecyclerView.post {
                pageAdapter.setItemHeight(binding.pageRecyclerView.height / PAGE_ROWS)
            }
        }
    }

    private fun handlePageItemsChanged(pagePosition: Int, pageItems: List<LauncherHomeItemUiModel>) {
        if (pagePosition !in pages.indices) return

        pages[pagePosition] = pageItems
        onHomeItemsChanged(pages.flatten())
    }

    inner class AppLibraryViewHolder(
        private val binding: ItemAppLibraryPageBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private val groupAdapter = AppLibraryGroupAdapter(onLibraryGroupClicked)

        init {
            binding.librarySearchPill.setOnClickListener { onLibrarySearchClicked() }
            binding.libraryRecyclerView.apply {
                layoutManager = GridLayoutManager(context, LIBRARY_COLUMNS)
                adapter = groupAdapter
                itemAnimator = null
                overScrollMode = View.OVER_SCROLL_NEVER
                setHasFixedSize(true)
            }
        }

        fun bind(groups: List<AppLibraryGroupUiModel>) {
            groupAdapter.submitGroups(groups)
        }
    }

    private companion object {
        const val VIEW_TYPE_HOME = 0
        const val VIEW_TYPE_LIBRARY = 1
        const val LIBRARY_PAGE_COUNT = 1
        const val LIBRARY_COLUMNS = 2
        const val PAGE_COLUMNS = 4
        const val PAGE_ROWS = 6
        const val PAGE_SIZE = PAGE_COLUMNS * PAGE_ROWS
    }
}

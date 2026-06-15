package com.vhmsoft.launcherios26.ui.launcher.workspace

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
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
    private val onHomeDragMoved: (
        LauncherHomeItemUiModel?,
        RecyclerView.ViewHolder,
        Float,
        Float
    ) -> Boolean = { _, _, _, _ -> false },
    private val onHomeDragEnded: (
        LauncherHomeItemUiModel?,
        RecyclerView.ViewHolder,
        Float,
        Float
    ) -> Boolean = { _, _, _, _ -> false },
    private val onLibrarySearchClicked: () -> Unit = {},
    private val onLibraryGroupClicked: (AppLibraryGroupUiModel) -> Unit = {}
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val sourceItems = mutableListOf<LauncherHomeItemUiModel>()
    private val pages = mutableListOf<List<LauncherHomeItemUiModel>>()
    private val libraryGroups = mutableListOf<AppLibraryGroupUiModel>()
    private val attachedHomePageHolders = mutableMapOf<Int, PageViewHolder>()
    private var attachedLibraryPageHolder: AppLibraryViewHolder? = null
    private var editing = false
    private var darkMode = false
    private var pageRows = DEFAULT_PAGE_ROWS
    private var iconSizeDp = DEFAULT_ICON_SIZE_DP
    private var parentRecyclerView: RecyclerView? = null
    private val parentAdapterUpdateGate = LauncherDeferredAdapterUpdate(
        shouldDefer = { shouldDeferParentAdapterUpdate() },
        post = { update ->
            parentRecyclerView?.post(update) ?: update()
        }
    )

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
            is PageViewHolder -> holder.bind(position, pages[position])
            is AppLibraryViewHolder -> holder.bind(libraryGroups)
        }
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        if (holder is PageViewHolder) {
            holder.cancelPendingPageBind()
            attachedHomePageHolders.remove(holder.boundPagePosition(), holder)
        } else if (holder is AppLibraryViewHolder && attachedLibraryPageHolder === holder) {
            attachedLibraryPageHolder = null
        }
        super.onViewDetachedFromWindow(holder)
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        if (holder is PageViewHolder) {
            holder.cancelPendingPageBind()
            attachedHomePageHolders.remove(holder.boundPagePosition(), holder)
        } else if (holder is AppLibraryViewHolder && attachedLibraryPageHolder === holder) {
            attachedLibraryPageHolder = null
        }
        super.onViewRecycled(holder)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        parentRecyclerView = recyclerView
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        if (parentRecyclerView === recyclerView) {
            parentRecyclerView = null
        }
        parentAdapterUpdateGate.cancelPendingUpdate()
        super.onDetachedFromRecyclerView(recyclerView)
    }

    override fun getItemCount(): Int = pages.size + LIBRARY_PAGE_COUNT

    override fun getItemViewType(position: Int): Int {
        return if (position >= pages.size) VIEW_TYPE_LIBRARY else VIEW_TYPE_HOME
    }

    fun submitItems(items: List<LauncherHomeItemUiModel>) {
        parentAdapterUpdateGate.cancelPendingUpdate()
        sourceItems.clear()
        sourceItems.addAll(items)
        rebuildHomePages(refreshAllWhenPageCountUnchanged = false)
    }

    fun submitDragPreviewItems(
        items: List<LauncherHomeItemUiModel>,
        focusPage: Int
    ) {
        val previewItems = items.toList()
        parentAdapterUpdateGate.run {
            applyDragPreviewItems(previewItems, focusPage)
        }
    }

    private fun applyDragPreviewItems(
        items: List<LauncherHomeItemUiModel>,
        focusPage: Int
    ) {
        val newPages = items.chunked(pageSize())
        val diff = LauncherPageDiff.between(pages, newPages)

        pages.clear()
        pages.addAll(newPages)
        if (diff.pageCountChanged) {
            attachedHomePageHolders.clear()
            notifyDataSetChanged()
            return
        }

        val holder = attachedHomePageHolders[focusPage]
        if (holder != null) {
            holder.bindPageItems(pages[focusPage])
        } else if (focusPage in pages.indices) {
            notifyItemChanged(focusPage)
        }
    }

    private fun shouldDeferParentAdapterUpdate(): Boolean {
        val recyclerView = parentRecyclerView ?: return false
        return recyclerView.isComputingLayout ||
            recyclerView.scrollState != RecyclerView.SCROLL_STATE_IDLE
    }

    fun setHomeGridRows(rows: Int) {
        val boundedRows = rows.coerceIn(MIN_PAGE_ROWS, MAX_PAGE_ROWS)
        if (pageRows == boundedRows) return
        parentAdapterUpdateGate.cancelPendingUpdate()
        pageRows = boundedRows
        rebuildHomePages(refreshAllWhenPageCountUnchanged = true)
    }

    fun setIconSizeDp(sizeDp: Int) {
        val boundedSize = sizeDp.coerceIn(MIN_ICON_SIZE_DP, MAX_ICON_SIZE_DP)
        if (iconSizeDp == boundedSize) return
        iconSizeDp = boundedSize
        attachedHomePageHolders.values.forEach { holder -> holder.setIconSizeDp(boundedSize) }
    }

    fun homePageCount(): Int = pages.size

    private fun rebuildHomePages(refreshAllWhenPageCountUnchanged: Boolean) {
        val newPages = sourceItems.chunked(pageSize())
        val diff = LauncherPageDiff.between(pages, newPages)

        pages.clear()
        pages.addAll(newPages)
        if (diff.pageCountChanged || refreshAllWhenPageCountUnchanged) {
            attachedHomePageHolders.clear()
            notifyDataSetChanged()
            return
        }

        diff.changedIndices.forEach { index ->
            val holder = attachedHomePageHolders[index]
            if (holder != null) {
                holder.bindPageItems(pages[index])
            } else {
                notifyItemChanged(index)
            }
        }
    }

    private fun pageSize(): Int {
        return PAGE_COLUMNS * pageRows
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

    fun setDarkMode(enabled: Boolean) {
        if (darkMode == enabled) return
        darkMode = enabled
        attachedHomePageHolders.values.forEach { holder -> holder.setDarkMode(enabled) }
        attachedLibraryPageHolder?.setDarkMode(enabled)
        notifyItemChanged(pages.size)
    }

    inner class PageViewHolder(
        private val binding: ItemLauncherPageBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private lateinit var itemTouchHelper: ItemTouchHelper
        private var boundPagePosition = RecyclerView.NO_POSITION
        private val pageBindGate = LauncherDeferredAdapterUpdate(
            shouldDefer = { shouldDeferPageBind() },
            post = { update -> binding.pageRecyclerView.post(update) }
        )
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
            itemTouchHelper = ItemTouchHelper(
                LauncherDragCallback(
                    adapter = pageAdapter,
                    onDragMoved = onHomeDragMoved,
                    onDragEnded = onHomeDragEnded
                )
            )
            binding.pageRecyclerView.apply {
                layoutManager = FixedPageGridLayoutManager(context, PAGE_COLUMNS)
                adapter = pageAdapter
                itemTouchHelper.attachToRecyclerView(this)
                setHasFixedSize(true)
                itemAnimator = null
                setOnTouchListener { _, event ->
                    pageAdapter.updateActiveTouch(event.rawX, event.rawY)
                    false
                }
                isNestedScrollingEnabled = false
                overScrollMode = View.OVER_SCROLL_NEVER
                post {
                    pageAdapter.setItemHeight(height / pageRows)
                }
            }
        }

        fun bind(position: Int, items: List<LauncherHomeItemUiModel>) {
            attachedHomePageHolders.remove(boundPagePosition, this)
            boundPagePosition = position
            attachedHomePageHolders[position] = this
            bindPageItems(items)
        }

        fun bindPageItems(items: List<LauncherHomeItemUiModel>) {
            val pageItems = items.toList()
            pageBindGate.run {
                applyPageItems(pageItems)
            }
        }

        private fun applyPageItems(pageItems: List<LauncherHomeItemUiModel>) {
            pageAdapter.setEditing(editing)
            pageAdapter.setDarkMode(darkMode)
            pageAdapter.setIconSizeDp(iconSizeDp)
            pageAdapter.submitItems(pageItems)
            binding.pageRecyclerView.post {
                pageAdapter.setItemHeight(binding.pageRecyclerView.height / pageRows)
            }
        }

        private fun shouldDeferPageBind(): Boolean {
            val recyclerView = binding.pageRecyclerView
            val parent = parentRecyclerView
            return LauncherPageBindDeferral.shouldDefer(
                childComputingLayout = recyclerView.isComputingLayout,
                childItemAnimatorRunning = recyclerView.itemAnimator?.isRunning == true,
                parentComputingLayout = parent?.isComputingLayout == true,
                parentScrollState = parent?.scrollState ?: RecyclerView.SCROLL_STATE_IDLE
            )
        }

        fun setDarkMode(enabled: Boolean) {
            pageAdapter.setDarkMode(enabled)
        }

        fun setIconSizeDp(sizeDp: Int) {
            pageAdapter.setIconSizeDp(sizeDp)
        }

        fun cancelPendingPageBind() {
            pageBindGate.cancelPendingUpdate()
        }

        fun boundPagePosition(): Int = boundPagePosition
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
            attachedLibraryPageHolder = this
            applyAppearance()
            groupAdapter.setDarkMode(darkMode)
            groupAdapter.submitGroups(groups)
        }

        fun setDarkMode(enabled: Boolean) {
            groupAdapter.setDarkMode(enabled)
            applyAppearance()
        }

        private fun applyAppearance() {
            val pillColor = if (darkMode) 0x66324B5C else 0x733B5B6A
            val textColor = Color.WHITE
            binding.librarySearchPill.background = roundedBackground(
                binding.root,
                pillColor,
                22
            )
            binding.librarySearchPillIcon.imageTintList = ColorStateList.valueOf(textColor)
            binding.librarySearchPillText.setTextColor(textColor)
        }
    }

    private fun roundedBackground(
        anchor: View,
        color: Int,
        radiusDp: Int,
        strokeColor: Int? = null
    ): GradientDrawable {
        val density = anchor.resources.displayMetrics.density
        return GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = radiusDp * density
            setColor(color)
            strokeColor?.let {
                setStroke((1f * density).toInt().coerceAtLeast(1), it)
            }
        }
    }

    private companion object {
        const val VIEW_TYPE_HOME = 0
        const val VIEW_TYPE_LIBRARY = 1
        const val LIBRARY_PAGE_COUNT = 1
        const val LIBRARY_COLUMNS = 2
        const val PAGE_COLUMNS = 4
        const val MIN_PAGE_ROWS = 5
        const val DEFAULT_PAGE_ROWS = 6
        const val MAX_PAGE_ROWS = 6
        const val MIN_ICON_SIZE_DP = 44
        const val DEFAULT_ICON_SIZE_DP = 64
        const val MAX_ICON_SIZE_DP = 78
    }
}

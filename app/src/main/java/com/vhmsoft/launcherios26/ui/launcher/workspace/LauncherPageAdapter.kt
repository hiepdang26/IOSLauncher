package com.vhmsoft.launcherios26.ui.launcher.workspace

import android.animation.ObjectAnimator
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.vhmsoft.launcherios26.R
import com.vhmsoft.launcherios26.databinding.ItemAppLibraryPageBinding
import com.vhmsoft.launcherios26.databinding.ItemLauncherPageBinding
import com.vhmsoft.launcherios26.databinding.ItemLauncherWidgetPageBinding

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
    private val onLibraryGroupClicked: (AppLibraryGroupUiModel) -> Unit = {},
    private val onWidgetEditClicked: () -> Unit = {}
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val sourceItems = mutableListOf<LauncherHomeItemUiModel>()
    private val pages = mutableListOf<List<LauncherHomeItemUiModel>>()
    private val libraryGroups = mutableListOf<AppLibraryGroupUiModel>()
    private val todayWidgets = mutableListOf(
        TodayWidget(1L, TodayWidgetType.WEATHER),
        TodayWidget(2L, TodayWidgetType.BATTERY),
        TodayWidget(3L, TodayWidgetType.APP_GROUP)
    )
    private val attachedHomePageHolders = mutableMapOf<Int, PageViewHolder>()
    private var attachedWidgetPageHolder: WidgetPageViewHolder? = null
    private var attachedLibraryPageHolder: AppLibraryViewHolder? = null
    private var nextTodayWidgetId = 4L
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
            VIEW_TYPE_WIDGET -> {
                val binding = ItemLauncherWidgetPageBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                WidgetPageViewHolder(binding)
            }

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
            is WidgetPageViewHolder -> holder.bind(todayWidgets, availableTodayApps())
            is PageViewHolder -> {
                val homePagePosition = homePagePositionForAdapterPosition(position)
                holder.bind(homePagePosition, pages[homePagePosition])
            }
            is AppLibraryViewHolder -> holder.bind(libraryGroups)
        }
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        when (holder) {
            is WidgetPageViewHolder -> {
                holder.cancelAnimations()
                if (attachedWidgetPageHolder === holder) {
                    attachedWidgetPageHolder = null
                }
            }

            is PageViewHolder -> {
                holder.cancelPendingPageBind()
                attachedHomePageHolders.remove(holder.boundPagePosition(), holder)
            }

            is AppLibraryViewHolder -> if (attachedLibraryPageHolder === holder) {
                attachedLibraryPageHolder = null
            }
        }
        super.onViewDetachedFromWindow(holder)
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        when (holder) {
            is WidgetPageViewHolder -> {
                holder.cancelAnimations()
                if (attachedWidgetPageHolder === holder) {
                    attachedWidgetPageHolder = null
                }
            }

            is PageViewHolder -> {
                holder.cancelPendingPageBind()
                attachedHomePageHolders.remove(holder.boundPagePosition(), holder)
            }

            is AppLibraryViewHolder -> if (attachedLibraryPageHolder === holder) {
                attachedLibraryPageHolder = null
            }
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

    override fun getItemCount(): Int = WIDGET_PAGE_COUNT + pages.size + LIBRARY_PAGE_COUNT

    override fun getItemViewType(position: Int): Int {
        return when {
            position == WIDGET_PAGE_POSITION -> VIEW_TYPE_WIDGET
            position == libraryAdapterPosition() -> VIEW_TYPE_LIBRARY
            else -> VIEW_TYPE_HOME
        }
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
            notifyItemChanged(adapterPositionForHomePage(focusPage))
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

    fun firstHomeAdapterPosition(): Int = WIDGET_PAGE_COUNT

    fun adapterPositionForHomePage(homePagePosition: Int): Int {
        return WIDGET_PAGE_COUNT + homePagePosition.coerceAtLeast(0)
    }

    fun homePagePositionForAdapterPosition(adapterPosition: Int): Int {
        return (adapterPosition - WIDGET_PAGE_COUNT).coerceAtLeast(0)
    }

    fun isWidgetPage(position: Int): Boolean = position == WIDGET_PAGE_POSITION

    fun isHomePage(position: Int): Boolean {
        return position in firstHomeAdapterPosition() until libraryAdapterPosition()
    }

    fun addWeatherWidget() {
        addTodayWidget(TodayWidgetType.WEATHER)
    }

    fun addBatteryWidget() {
        addTodayWidget(TodayWidgetType.BATTERY)
    }

    fun addPictureWidget() {
        addTodayWidget(TodayWidgetType.PICTURE)
    }

    fun addSuggestionsWidget() {
        addTodayWidget(TodayWidgetType.APP_GROUP)
    }

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
                notifyItemChanged(adapterPositionForHomePage(index))
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
        attachedWidgetPageHolder?.bind(todayWidgets, availableTodayApps())
        attachedHomePageHolders.values.forEach { holder -> holder.setDarkMode(enabled) }
        attachedLibraryPageHolder?.setDarkMode(enabled)
        notifyItemChanged(WIDGET_PAGE_POSITION)
        notifyItemChanged(libraryAdapterPosition())
    }

    private fun addTodayWidget(type: TodayWidgetType) {
        todayWidgets += TodayWidget(nextTodayWidgetId++, type)
        attachedWidgetPageHolder?.bind(todayWidgets, availableTodayApps()) ?: notifyItemChanged(WIDGET_PAGE_POSITION)
    }

    private fun removeTodayWidget(widgetId: Long) {
        if (todayWidgets.removeAll { widget -> widget.id == widgetId }) {
            attachedWidgetPageHolder?.bind(todayWidgets, availableTodayApps()) ?: notifyItemChanged(WIDGET_PAGE_POSITION)
        }
    }

    private fun availableTodayApps(): List<LauncherIconUiModel> {
        return sourceItems
            .flatMap { item -> item.containedApps() }
            .distinctBy { item -> item.app.iconKey }
            .take(TODAY_APP_WIDGET_COUNT)
    }

    private fun libraryAdapterPosition(): Int {
        return WIDGET_PAGE_COUNT + pages.size
    }

    private inner class WidgetPageViewHolder(
        private val binding: ItemLauncherWidgetPageBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private val wiggleAnimators = mutableListOf<ObjectAnimator>()

        init {
            binding.todayWidgetEditButton.setOnClickListener { onWidgetEditClicked() }
        }

        fun bind(widgets: List<TodayWidget>, apps: List<LauncherIconUiModel>) {
            attachedWidgetPageHolder = this
            cancelAnimations()
            binding.todayWidgetContainer.removeAllViews()

            val pendingSmallWidgets = mutableListOf<TodayWidget>()
            widgets.forEach { widget ->
                if (widget.type.isSmall) {
                    pendingSmallWidgets += widget
                    if (pendingSmallWidgets.size == 2) {
                        addSmallWidgetRow(pendingSmallWidgets.toList(), apps)
                        pendingSmallWidgets.clear()
                    }
                } else {
                    if (pendingSmallWidgets.isNotEmpty()) {
                        addSmallWidgetRow(pendingSmallWidgets.toList(), apps)
                        pendingSmallWidgets.clear()
                    }
                    addFullWidthWidget(widget, apps)
                }
            }
            if (pendingSmallWidgets.isNotEmpty()) {
                addSmallWidgetRow(pendingSmallWidgets.toList(), apps)
            }
        }

        fun cancelAnimations() {
            wiggleAnimators.forEach { animator -> animator.cancel() }
            wiggleAnimators.clear()
        }

        private fun addFullWidthWidget(widget: TodayWidget, apps: List<LauncherIconUiModel>) {
            val view = editableWidgetFrame(
                widget = widget,
                content = when (widget.type) {
                    TodayWidgetType.WEATHER -> createWeatherWidget()
                    TodayWidgetType.APP_GROUP -> createAppGroupWidget(apps)
                    TodayWidgetType.BATTERY -> createBatteryWidget()
                    TodayWidgetType.PICTURE -> createPictureWidget()
                }
            )
            binding.todayWidgetContainer.addView(
                view,
                LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    when (widget.type) {
                        TodayWidgetType.WEATHER -> dp(82)
                        TodayWidgetType.APP_GROUP -> dp(190)
                        else -> dp(168)
                    }
                ).apply {
                    bottomMargin = if (widget.type == TodayWidgetType.WEATHER) dp(56) else dp(22)
                }
            )
        }

        private fun addSmallWidgetRow(widgets: List<TodayWidget>, apps: List<LauncherIconUiModel>) {
            val row = LinearLayout(binding.root.context).apply {
                clipChildren = false
                clipToPadding = false
                orientation = LinearLayout.HORIZONTAL
            }
            widgets.forEachIndexed { index, widget ->
                val content = when (widget.type) {
                    TodayWidgetType.BATTERY -> createBatteryWidget()
                    TodayWidgetType.PICTURE -> createPictureWidget()
                    TodayWidgetType.WEATHER -> createWeatherWidget()
                    TodayWidgetType.APP_GROUP -> createAppGroupWidget(apps)
                }
                row.addView(
                    editableWidgetFrame(widget, content),
                    LinearLayout.LayoutParams(
                        if (widgets.size == 1) dp(168) else 0,
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        if (widgets.size == 1) 0f else 1f
                    ).apply {
                        if (index < widgets.lastIndex) {
                            marginEnd = dp(22)
                        }
                    }
                )
            }
            binding.todayWidgetContainer.addView(
                row,
                LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    dp(168)
                ).apply {
                    bottomMargin = dp(22)
                }
            )
        }

        private fun editableWidgetFrame(widget: TodayWidget, content: View): FrameLayout {
            return FrameLayout(binding.root.context).apply {
                clipChildren = false
                clipToPadding = false
                addView(
                    content,
                    FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                )
                if (editing) {
                    addView(createRemoveBadge(widget.id))
                    startWiggle(this, widget.id)
                }
            }
        }

        private fun createWeatherWidget(): View {
            return FrameLayout(binding.root.context).apply {
                background = GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM,
                    intArrayOf(0xFF3D6FA8.toInt(), 0xFF5A8FD1.toInt())
                ).apply {
                    cornerRadius = dp(18).toFloat()
                }
                addView(
                    TextView(context).apply {
                        gravity = Gravity.CENTER
                        text = context.getString(R.string.launcher_widget_location_title)
                        setTextColor(0xFFFF2D55.toInt())
                        textSize = 13f
                        typeface = Typeface.DEFAULT_BOLD
                    },
                    FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        dp(28),
                        Gravity.TOP
                    ).apply {
                        topMargin = dp(12)
                    }
                )
                addView(
                    TextView(context).apply {
                        gravity = Gravity.CENTER
                        text = context.getString(R.string.launcher_widget_location_message)
                        setTextColor(Color.WHITE)
                        textSize = 13f
                        typeface = Typeface.DEFAULT_BOLD
                        maxLines = 2
                    },
                    FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        dp(42),
                        Gravity.BOTTOM
                    ).apply {
                        leftMargin = dp(4)
                        rightMargin = dp(4)
                        bottomMargin = dp(4)
                    }
                )
            }
        }

        private fun createBatteryWidget(): View {
            return FrameLayout(binding.root.context).apply {
                background = roundedBackground(0xFF050505.toInt(), 20)
                addView(
                    FrameLayout(context).apply {
                        background = GradientDrawable().apply {
                            shape = GradientDrawable.OVAL
                            setColor(Color.TRANSPARENT)
                            setStroke(dp(6), 0xFF00E321.toInt())
                        }
                        addView(
                            ImageView(context).apply {
                                setImageResource(R.drawable.ic_phone_home_20)
                                imageTintList = ColorStateList.valueOf(Color.WHITE)
                            },
                            FrameLayout.LayoutParams(dp(38), dp(38), Gravity.CENTER)
                        )
                    },
                    FrameLayout.LayoutParams(dp(72), dp(72), Gravity.TOP or Gravity.START).apply {
                        leftMargin = dp(18)
                        topMargin = dp(16)
                    }
                )
                addView(
                    TextView(context).apply {
                        text = "100%"
                        setTextColor(Color.WHITE)
                        textSize = 34f
                        includeFontPadding = false
                    },
                    FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        dp(52),
                        Gravity.BOTTOM or Gravity.START
                    ).apply {
                        leftMargin = dp(10)
                        bottomMargin = dp(24)
                    }
                )
            }
        }

        private fun createPictureWidget(): View {
            return FrameLayout(binding.root.context).apply {
                background = GradientDrawable(
                    GradientDrawable.Orientation.BL_TR,
                    intArrayOf(0xFFFFB12B.toInt(), 0xFFFFE07A.toInt(), 0xFF7DB6FF.toInt())
                ).apply {
                    cornerRadius = dp(18).toFloat()
                }
                addView(
                    TextView(context).apply {
                        text = context.getString(R.string.launcher_widget_picture)
                        gravity = Gravity.CENTER
                        setTextColor(0xDD111111.toInt())
                        textSize = 14f
                        typeface = Typeface.DEFAULT_BOLD
                    },
                    FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                )
            }
        }

        private fun createAppGroupWidget(apps: List<LauncherIconUiModel>): View {
            return LinearLayout(binding.root.context).apply {
                background = roundedBackground(if (darkMode) 0x7242484B else 0x80D8DEE2.toInt(), 20)
                clipChildren = false
                clipToPadding = false
                orientation = LinearLayout.VERTICAL
                gravity = Gravity.CENTER
                setPadding(dp(18), dp(18), dp(18), dp(18))
                repeat(2) { rowIndex ->
                    addView(
                        LinearLayout(context).apply {
                            gravity = Gravity.CENTER
                            orientation = LinearLayout.HORIZONTAL
                            repeat(4) { columnIndex ->
                                val app = apps.getOrNull(rowIndex * 4 + columnIndex)
                                addView(
                                    FrameLayout(context).apply {
                                        addView(
                                            ImageView(context).apply {
                                                setImageDrawable(app?.displayIcon)
                                                contentDescription = app?.label
                                                visibility = if (app == null) View.INVISIBLE else View.VISIBLE
                                                scaleType = ImageView.ScaleType.FIT_CENTER
                                            },
                                            FrameLayout.LayoutParams(dp(62), dp(62), Gravity.CENTER)
                                        )
                                    },
                                    LinearLayout.LayoutParams(0, dp(72), 1f)
                                )
                            }
                        },
                        LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            0,
                            1f
                        )
                    )
                }
            }
        }

        private fun createRemoveBadge(widgetId: Long): TextView {
            return TextView(binding.root.context).apply {
                background = GradientDrawable().apply {
                    shape = GradientDrawable.OVAL
                    setColor(0xFFD1D1D6.toInt())
                }
                elevation = dp(6).toFloat()
                gravity = Gravity.CENTER
                text = "-"
                setTextColor(0xFF111111.toInt())
                textSize = 18f
                setOnClickListener { removeTodayWidget(widgetId) }
                layoutParams = FrameLayout.LayoutParams(dp(26), dp(26), Gravity.TOP or Gravity.START).apply {
                    leftMargin = -dp(8)
                    topMargin = -dp(8)
                }
            }
        }

        private fun startWiggle(view: View, widgetId: Long) {
            val startRotation = if (widgetId % 2L == 0L) -1.2f else 1.2f
            view.rotation = startRotation
            ObjectAnimator.ofFloat(view, View.ROTATION, startRotation, -startRotation).apply {
                duration = 95L
                repeatCount = ObjectAnimator.INFINITE
                repeatMode = ObjectAnimator.REVERSE
                interpolator = LinearInterpolator()
                start()
                wiggleAnimators += this
            }
        }

        private fun roundedBackground(color: Int, radiusDp: Int): GradientDrawable {
            return GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = dp(radiusDp).toFloat()
                setColor(color)
            }
        }

        private fun dp(value: Int): Int {
            return (value * binding.root.resources.displayMetrics.density).toInt()
        }
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
                handlePageItemsChanged(boundPagePosition, pageItems)
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

    private data class TodayWidget(
        val id: Long,
        val type: TodayWidgetType
    )

    private enum class TodayWidgetType(
        val isSmall: Boolean
    ) {
        WEATHER(isSmall = false),
        BATTERY(isSmall = true),
        PICTURE(isSmall = true),
        APP_GROUP(isSmall = false)
    }

    private companion object {
        const val VIEW_TYPE_WIDGET = 0
        const val VIEW_TYPE_HOME = 1
        const val VIEW_TYPE_LIBRARY = 2
        const val WIDGET_PAGE_POSITION = 0
        const val WIDGET_PAGE_COUNT = 1
        const val LIBRARY_PAGE_COUNT = 1
        const val LIBRARY_COLUMNS = 2
        const val PAGE_COLUMNS = 4
        const val TODAY_APP_WIDGET_COUNT = 8
        const val MIN_PAGE_ROWS = 5
        const val DEFAULT_PAGE_ROWS = 6
        const val MAX_PAGE_ROWS = 6
        const val MIN_ICON_SIZE_DP = 44
        const val DEFAULT_ICON_SIZE_DP = 64
        const val MAX_ICON_SIZE_DP = 78
    }
}

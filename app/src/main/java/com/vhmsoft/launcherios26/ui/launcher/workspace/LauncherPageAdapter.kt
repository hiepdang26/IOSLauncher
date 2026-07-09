package com.vhmsoft.launcherios26.ui.launcher.workspace

import android.animation.ObjectAnimator
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.os.SystemClock
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.cloudx.ios17.features.launcher.TodayWidgetDragUpdatePolicy
import com.vhmsoft.launcherios26.R
import com.vhmsoft.launcherios26.databinding.ItemAppLibraryPageBinding
import com.vhmsoft.launcherios26.databinding.ItemLauncherPageBinding
import com.vhmsoft.launcherios26.databinding.ItemLauncherWidgetPageBinding
import com.vhmsoft.launcherios26.ui.launcher.LauncherHomeIconSizePolicy
import com.vhmsoft.launcherios26.weather.HomeHourlyWeather
import com.vhmsoft.launcherios26.weather.WeatherConditionMapper
import com.vhmsoft.launcherios26.weather.WeatherForecast
import com.vhmsoft.launcherios26.weather.WeatherHomeWidgetPolicy
import com.vhmsoft.launcherios26.weather.WeatherWidgetUiState

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
    private val onWidgetEditClicked: () -> Unit = {},
    private val onWidgetAppClicked: (LauncherIconUiModel) -> Unit = {},
    private val onWeatherPermissionClicked: () -> Unit = {},
    private val onWeatherWidgetClicked: () -> Unit = {}
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
    private val boundHomePageHolders = mutableMapOf<Int, PageViewHolder>()
    private var attachedWidgetPageHolder: WidgetPageViewHolder? = null
    private var attachedLibraryPageHolder: AppLibraryViewHolder? = null
    private var nextTodayWidgetId = 4L
    private val todaySuggestionSeed = System.currentTimeMillis()
    private var editing = false
    private var darkMode = false
    private var liquidGlassEnabled = false
    private var weatherWidgetState: WeatherWidgetUiState = WeatherWidgetUiState.PermissionRequired
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
                boundHomePageHolders.remove(holder.boundPagePosition(), holder)
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

    fun applyTemporaryHomeDragPreview(
        baseItems: List<LauncherHomeItemUiModel>,
        previewItems: List<LauncherHomeItemUiModel>,
        focusPage: Int
    ) {
        val basePageItems = baseItems.pageItems(focusPage)
        val previewPageItems = previewItems.pageItems(focusPage)
        attachedHomePageHolders[focusPage]?.applyTemporaryDragPreview(
            basePageItems = basePageItems,
            previewPageItems = previewPageItems
        )
    }

    fun clearTemporaryHomeDragPreview() {
        attachedHomePageHolders.values.forEach { holder ->
            holder.clearTemporaryDragPreview(animate = false)
        }
    }

    fun ensureTemporaryHomePage(page: Int) {
        val targetPage = page.coerceAtLeast(0)
        parentAdapterUpdateGate.run {
            applyEnsureTemporaryHomePage(targetPage)
        }
    }

    private fun applyEnsureTemporaryHomePage(page: Int) {
        if (page < pages.size) return

        val oldPageCount = pages.size
        while (pages.size <= page) {
            pages += placeholderPage(pages.size)
        }
        notifyItemRangeInserted(
            adapterPositionForHomePage(oldPageCount),
            pages.size - oldPageCount
        )
    }

    private fun applyDragPreviewItems(
        items: List<LauncherHomeItemUiModel>,
        focusPage: Int
    ) {
        val oldPages = pages.toList()
        val newPages = LauncherHomeScreenGridPolicy
            .padToFullPages(
                items = items,
                pageSize = pageSize(),
                preserveEmptyPages = true
            )
            .chunked(pageSize())
        val diff = LauncherPageDiff.between(oldPages, newPages)

        pages.clear()
        pages.addAll(newPages)
        dispatchHomePageUpdates(
            oldPages = oldPages,
            newPages = newPages,
            diff = diff,
            focusedPage = focusPage
        )
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
        val oldPages = pages.toList()
        val newPages = LauncherHomeScreenGridPolicy
            .padToFullPages(sourceItems, pageSize())
            .chunked(pageSize())
        val diff = LauncherPageDiff.between(oldPages, newPages)

        pages.clear()
        pages.addAll(newPages)
        if (refreshAllWhenPageCountUnchanged && !diff.pageCountChanged) {
            attachedHomePageHolders.clear()
            boundHomePageHolders.clear()
            notifyDataSetChanged()
            return
        }

        dispatchHomePageUpdates(
            oldPages = oldPages,
            newPages = newPages,
            diff = diff
        )
    }

    private fun pageSize(): Int {
        return LauncherHomeScreenGridPolicy.pageSize(pageRows, PAGE_COLUMNS)
    }

    private fun List<LauncherHomeItemUiModel>.pageItems(page: Int): List<LauncherHomeItemUiModel> {
        val startIndex = page.coerceAtLeast(0) * pageSize()
        return drop(startIndex)
            .take(pageSize())
            .let { items ->
                if (items.size >= pageSize()) {
                    items
                } else {
                    items.toMutableList().apply {
                        while (size < pageSize()) {
                            add(LauncherHomeItemUiModel.Placeholder.forGridIndex(startIndex + size))
                        }
                    }
                }
            }
    }

    private fun placeholderPage(page: Int): List<LauncherHomeItemUiModel.Placeholder> {
        val startIndex = page.coerceAtLeast(0) * pageSize()
        return List(pageSize()) { offset ->
            LauncherHomeItemUiModel.Placeholder.forGridIndex(startIndex + offset)
        }
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
        parentAdapterUpdateGate.run {
            applyEditing(enabled)
        }
    }

    private fun applyEditing(enabled: Boolean) {
        val update = LauncherEditModePagerUpdatePolicy.plan(
            currentEditing = editing,
            nextEditing = enabled
        )
        if (!update.refreshWholePager &&
            !update.updateBoundHomePages &&
            !update.updateAttachedWidgetPage &&
            !update.refreshAllHomePages
        ) {
            return
        }
        editing = enabled
        if (update.refreshWholePager) {
            attachedHomePageHolders.clear()
            boundHomePageHolders.clear()
            notifyDataSetChanged()
            return
        }
        if (update.updateAttachedWidgetPage) {
            attachedWidgetPageHolder?.refreshEditingState()
        }
        if (update.updateBoundHomePages) {
            boundHomePageHolders.values.toList().forEach { holder ->
                holder.setEditing(enabled)
            }
        }
        if (update.refreshAllHomePages && pages.isNotEmpty()) {
            notifyItemRangeChanged(firstHomeAdapterPosition(), pages.size)
        }
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

    fun setLiquidGlassEnabled(enabled: Boolean) {
        if (liquidGlassEnabled == enabled) return
        liquidGlassEnabled = enabled
        attachedHomePageHolders.values.forEach { holder -> holder.setLiquidGlassEnabled(enabled) }
        attachedLibraryPageHolder?.setLiquidGlassEnabled(enabled)
        notifyItemChanged(libraryAdapterPosition())
    }

    fun setWeatherWidgetState(state: WeatherWidgetUiState) {
        if (weatherWidgetState == state) return
        weatherWidgetState = state
        attachedWidgetPageHolder?.bind(todayWidgets, availableTodayApps()) ?: notifyItemChanged(WIDGET_PAGE_POSITION)
    }

    private fun addTodayWidget(type: TodayWidgetType) {
        todayWidgets += TodayWidget(nextTodayWidgetId++, type)
        attachedWidgetPageHolder?.bind(todayWidgets, availableTodayApps()) ?: notifyItemChanged(WIDGET_PAGE_POSITION)
    }

    private fun removeTodayWidget(widgetId: Long) {
        if (todayWidgets.removeAll { widget -> widget.id == widgetId }) {
            attachedWidgetPageHolder?.bind(todayWidgets, availableTodayApps())
                ?: notifyItemChanged(WIDGET_PAGE_POSITION)
        }
    }

    private fun moveTodayWidget(widgetId: Long, targetIndex: Int) {
        val fromIndex = todayWidgets.indexOfFirst { widget -> widget.id == widgetId }
        if (fromIndex == -1 || fromIndex == targetIndex) return

        val movedWidgets = LauncherTodayWidgetLayoutPlanner.move(
            items = todayWidgets,
            fromIndex = fromIndex,
            toIndex = targetIndex
        )
        todayWidgets.clear()
        todayWidgets.addAll(movedWidgets)
        attachedWidgetPageHolder?.bind(todayWidgets, availableTodayApps()) ?: notifyItemChanged(WIDGET_PAGE_POSITION)
    }

    private fun availableTodayApps(): List<LauncherIconUiModel> {
        val apps = sourceItems
            .flatMap { item -> item.containedApps() }
        return LauncherTodayAppSuggester.select(
            apps = apps,
            limit = TODAY_APP_WIDGET_COUNT,
            stableKey = { item -> item.app.iconKey },
            seed = todaySuggestionSeed
        )
    }

    private fun libraryAdapterPosition(): Int {
        return WIDGET_PAGE_COUNT + pages.size
    }

    private inner class WidgetPageViewHolder(
        private val binding: ItemLauncherWidgetPageBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private val wiggleAnimators = mutableListOf<ObjectAnimator>()
        private val widgetViews = mutableMapOf<Long, View>()
        private val widgetBaseCenters = mutableMapOf<Long, LauncherTodayWidgetCenter>()
        private var boundWidgets: List<TodayWidget> = emptyList()
        private var draggingWidgetId: Long? = null
        private var draggingView: View? = null
        private var dragStartRawX = 0f
        private var dragStartRawY = 0f
        private var lastWidgetTouchRawX = 0f
        private var lastWidgetTouchRawY = 0f
        private var lastWidgetPreviewRawX = Float.NaN
        private var lastWidgetPreviewRawY = Float.NaN
        private var lastWidgetPreviewUptime = 0L
        private var lastWidgetPreviewTargetIndex = RecyclerView.NO_POSITION

        init {
            binding.todayWidgetEditButton.setOnClickListener { onWidgetEditClicked() }
        }

        fun bind(widgets: List<TodayWidget>, apps: List<LauncherIconUiModel>) {
            attachedWidgetPageHolder = this
            cancelAnimations()
            widgetViews.clear()
            widgetBaseCenters.clear()
            boundWidgets = widgets.toList()
            draggingWidgetId = null
            draggingView = null
            lastWidgetPreviewTargetIndex = RecyclerView.NO_POSITION
            lastWidgetPreviewRawX = Float.NaN
            lastWidgetPreviewRawY = Float.NaN
            lastWidgetPreviewUptime = 0L
            binding.todayWidgetContainer.removeAllViews()

            val rows = LauncherTodayWidgetLayoutPlanner.rows(
                widgets.map { widget -> widget.type.widgetSize }
            )
            rows.forEach { rowIndices ->
                val rowWidgets = rowIndices.mapNotNull { index -> widgets.getOrNull(index) }
                if (rowWidgets.size == 1 && !rowWidgets.first().type.isSmall) {
                    addFullWidthWidget(rowWidgets.first(), apps)
                } else {
                    addSmallWidgetRow(rowWidgets, apps)
                }
            }
        }

        fun refreshEditingState() {
            bind(todayWidgets, availableTodayApps())
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
                    widgetHeightPx(widget)
                ).apply {
                    bottomMargin = if (widget.type == TodayWidgetType.WEATHER) {
                        dp(WEATHER_WIDGET_BOTTOM_MARGIN_DP)
                    } else {
                        dp(WIDGET_BOTTOM_MARGIN_DP)
                    }
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
                        if (widgets.size == 1) dp(SINGLE_SMALL_WIDGET_WIDTH_DP) else 0,
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        if (widgets.size == 1) 0f else 1f
                    ).apply {
                        if (index < widgets.lastIndex) {
                            marginEnd = dp(SMALL_WIDGET_GAP_DP)
                        }
                    }
                )
            }
            binding.todayWidgetContainer.addView(
                row,
                LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    dp(SMALL_WIDGET_HEIGHT_DP)
                ).apply {
                    bottomMargin = dp(WIDGET_BOTTOM_MARGIN_DP)
                }
            )
        }

        private fun editableWidgetFrame(widget: TodayWidget, content: View): FrameLayout {
            return FrameLayout(binding.root.context).apply {
                clipChildren = false
                clipToPadding = false
                widgetViews[widget.id] = this
                addView(
                    content,
                    FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                )
                if (editing) {
                    addView(createRemoveBadge(widget.id))
                    setOnLongClickListener {
                        beginWidgetDrag(widget.id, this)
                        true
                    }
                    setOnTouchListener { _, event ->
                        handleWidgetDragTouch(widget.id, this, event)
                    }
                    startWiggle(this, widget.id)
                }
            }
        }

        private fun beginWidgetDrag(widgetId: Long, view: View) {
            draggingWidgetId = widgetId
            draggingView = view
            dragStartRawX = lastWidgetTouchRawX
            dragStartRawY = lastWidgetTouchRawY
            lastWidgetPreviewTargetIndex = boundWidgets.indexOfFirst { widget -> widget.id == widgetId }
            lastWidgetPreviewRawX = Float.NaN
            lastWidgetPreviewRawY = Float.NaN
            lastWidgetPreviewUptime = 0L
            captureWidgetBaseCenters()
            binding.todayWidgetScroll.requestDisallowInterceptTouchEvent(true)
            cancelAnimations()
            widgetViews.values.forEach { widgetView -> widgetView.rotation = 0f }
            view.animate().cancel()
            view.bringToFront()
            view.elevation = dp(14).toFloat()
            view.scaleX = 1.03f
            view.scaleY = 1.03f
        }

        private fun handleWidgetDragTouch(widgetId: Long, view: View, event: MotionEvent): Boolean {
            if (!editing) return false

            if (event.actionMasked == MotionEvent.ACTION_DOWN) {
                dragStartRawX = event.rawX
                dragStartRawY = event.rawY
                lastWidgetTouchRawX = event.rawX
                lastWidgetTouchRawY = event.rawY
            }

            if (draggingWidgetId != widgetId || draggingView !== view) return false

            when (event.actionMasked) {
                MotionEvent.ACTION_MOVE -> {
                    if (dragStartRawX == 0f && dragStartRawY == 0f) {
                        dragStartRawX = event.rawX
                        dragStartRawY = event.rawY
                    }
                    view.translationX = event.rawX - dragStartRawX
                    view.translationY = event.rawY - dragStartRawY
                    if (shouldInspectWidgetPushPreview(event.rawX, event.rawY)) {
                        updateWidgetPushPreview(widgetId, event.rawX, event.rawY)
                    }
                    return true
                }

                MotionEvent.ACTION_UP,
                MotionEvent.ACTION_CANCEL -> {
                    finishWidgetDrag(widgetId, event.rawX, event.rawY)
                    return true
                }
            }

            return true
        }

        private fun finishWidgetDrag(widgetId: Long, rawX: Float, rawY: Float) {
            val targetIndex = findWidgetDropIndex(rawX, rawY)
            val fromIndex = boundWidgets.indexOfFirst { widget -> widget.id == widgetId }
            val draggedView = draggingView
            draggingWidgetId = null
            draggingView = null
            lastWidgetPreviewTargetIndex = RecyclerView.NO_POSITION
            lastWidgetPreviewRawX = Float.NaN
            lastWidgetPreviewRawY = Float.NaN
            lastWidgetPreviewUptime = 0L
            binding.todayWidgetScroll.requestDisallowInterceptTouchEvent(false)
            if (targetIndex != RecyclerView.NO_POSITION && targetIndex != fromIndex) {
                moveTodayWidget(widgetId, targetIndex)
            } else {
                resetWidgetPushPreview(animate = true)
                draggedView?.let { view -> resetDraggedWidgetView(view) }
            }
        }

        private fun findWidgetDropIndex(rawX: Float, rawY: Float): Int {
            val currentIndex = boundWidgets.indexOfFirst { widget -> widget.id == draggingWidgetId }
            var bestIndex = currentIndex.takeIf { index -> index != -1 } ?: 0
            var bestDistance = Float.MAX_VALUE

            boundWidgets.forEachIndexed { index, widget ->
                val center = widgetBaseCenters[widget.id] ?: widgetCenterOnScreen(widget.id)
                    ?: return@forEachIndexed
                val distanceX = rawX - center.x
                val distanceY = rawY - center.y
                val distance = distanceX * distanceX + distanceY * distanceY
                if (distance < bestDistance) {
                    bestDistance = distance
                    bestIndex = index
                }
            }

            return bestIndex
        }

        private fun shouldInspectWidgetPushPreview(rawX: Float, rawY: Float): Boolean {
            val now = SystemClock.uptimeMillis()
            val shouldInspect = TodayWidgetDragUpdatePolicy.shouldInspectMove(
                lastRawX = lastWidgetPreviewRawX,
                lastRawY = lastWidgetPreviewRawY,
                rawX = rawX,
                rawY = rawY,
                lastUptimeMs = lastWidgetPreviewUptime,
                nowUptimeMs = now,
                minMovePx = dp(WIDGET_DRAG_PREVIEW_MIN_MOVE_DP).toFloat(),
                minIntervalMs = WIDGET_DRAG_PREVIEW_THROTTLE_MS
            )
            if (shouldInspect) {
                lastWidgetPreviewRawX = rawX
                lastWidgetPreviewRawY = rawY
                lastWidgetPreviewUptime = now
            }
            return shouldInspect
        }

        private fun updateWidgetPushPreview(widgetId: Long, rawX: Float, rawY: Float) {
            val targetIndex = findWidgetDropIndex(rawX, rawY)
            if (targetIndex == RecyclerView.NO_POSITION || targetIndex == lastWidgetPreviewTargetIndex) return

            lastWidgetPreviewTargetIndex = targetIndex
            val offsets = LauncherTodayWidgetPushPreview.offsetsForTargetCenters(
                draggedWidgetId = widgetId,
                centers = widgetBaseCenters,
                targetCenters = widgetTargetCentersForPreview(widgetId, targetIndex)
            )
            widgetViews.forEach { (id, view) ->
                if (id == widgetId) return@forEach

                val offset = offsets[id] ?: LauncherTodayWidgetOffset(0f, 0f)
                view.animate()
                    .translationX(offset.x)
                    .translationY(offset.y)
                    .setDuration(WIDGET_PUSH_PREVIEW_MS)
                    .setInterpolator(DecelerateInterpolator())
                    .start()
            }
        }

        private fun widgetTargetCentersForPreview(
            draggedWidgetId: Long,
            targetIndex: Int
        ): Map<Long, LauncherTodayWidgetCenter> {
            val fromIndex = boundWidgets.indexOfFirst { widget -> widget.id == draggedWidgetId }
            if (fromIndex == -1) return emptyMap()

            val previewWidgets = LauncherTodayWidgetLayoutPlanner.move(
                items = boundWidgets,
                fromIndex = fromIndex,
                toIndex = targetIndex
            )
            val containerLocation = IntArray(2)
            binding.todayWidgetContainer.getLocationOnScreen(containerLocation)
            val containerLeft = containerLocation[0].toFloat()
            val containerTop = containerLocation[1].toFloat()
            val containerWidth = binding.todayWidgetContainer.width.toFloat()
                .takeIf { width -> width > 0f }
                ?: binding.root.width.toFloat()
            if (containerWidth <= 0f) return emptyMap()

            val targetCenters = mutableMapOf<Long, LauncherTodayWidgetCenter>()
            var rowTop = 0f
            val rows = LauncherTodayWidgetLayoutPlanner.rows(
                previewWidgets.map { widget -> widget.type.widgetSize }
            )
            rows.forEach { rowIndices ->
                val rowWidgets = rowIndices.mapNotNull { index -> previewWidgets.getOrNull(index) }
                if (rowWidgets.isEmpty()) return@forEach

                val rowHeight = rowHeightPx(rowWidgets)
                val centerY = containerTop + rowTop + rowHeight / 2f
                if (rowWidgets.size == 2 && rowWidgets.all { widget -> widget.type.isSmall }) {
                    val gap = dp(SMALL_WIDGET_GAP_DP).toFloat()
                    val childWidth = (containerWidth - gap) / 2f
                    rowWidgets.forEachIndexed { index, widget ->
                        val centerX = containerLeft + childWidth / 2f + index * (childWidth + gap)
                        targetCenters[widget.id] = LauncherTodayWidgetCenter(centerX, centerY)
                    }
                } else {
                    val widget = rowWidgets.first()
                    val centerX = if (widget.type.isSmall) {
                        containerLeft + dp(SINGLE_SMALL_WIDGET_WIDTH_DP) / 2f
                    } else {
                        containerLeft + containerWidth / 2f
                    }
                    targetCenters[widget.id] = LauncherTodayWidgetCenter(centerX, centerY)
                }

                rowTop += rowHeight + rowBottomMarginPx(rowWidgets)
            }

            return targetCenters
        }

        private fun rowHeightPx(widgets: List<TodayWidget>): Float {
            val widget = widgets.firstOrNull() ?: return 0f
            return if (widgets.size == 2 && widgets.all { item -> item.type.isSmall }) {
                dp(SMALL_WIDGET_HEIGHT_DP).toFloat()
            } else {
                widgetHeightPx(widget).toFloat()
            }
        }

        private fun rowBottomMarginPx(widgets: List<TodayWidget>): Float {
            val widget = widgets.firstOrNull() ?: return 0f
            return if (widget.type == TodayWidgetType.WEATHER) {
                dp(WEATHER_WIDGET_BOTTOM_MARGIN_DP).toFloat()
            } else {
                dp(WIDGET_BOTTOM_MARGIN_DP).toFloat()
            }
        }

        private fun widgetHeightPx(widget: TodayWidget): Int {
            return when (widget.type) {
                TodayWidgetType.WEATHER -> {
                    dp(WEATHER_FORECAST_WIDGET_HEIGHT_DP)
                }

                TodayWidgetType.APP_GROUP -> dp(APP_GROUP_WIDGET_HEIGHT_DP)
                TodayWidgetType.BATTERY,
                TodayWidgetType.PICTURE -> dp(SMALL_WIDGET_HEIGHT_DP)
            }
        }

        private fun captureWidgetBaseCenters() {
            widgetBaseCenters.clear()
            widgetViews.keys.forEach { widgetId ->
                widgetCenterOnScreen(widgetId)?.let { center ->
                    widgetBaseCenters[widgetId] = center
                }
            }
        }

        private fun widgetCenterOnScreen(widgetId: Long): LauncherTodayWidgetCenter? {
            val view = widgetViews[widgetId] ?: return null
            val location = IntArray(2)
            view.getLocationOnScreen(location)
            return LauncherTodayWidgetCenter(
                x = location[0] + view.width / 2f,
                y = location[1] + view.height / 2f
            )
        }

        private fun resetWidgetPushPreview(animate: Boolean) {
            widgetViews.forEach { (id, view) ->
                if (id == draggingWidgetId) return@forEach

                view.animate().cancel()
                if (animate) {
                    view.animate()
                        .translationX(0f)
                        .translationY(0f)
                        .setDuration(WIDGET_PUSH_PREVIEW_MS)
                        .setInterpolator(DecelerateInterpolator())
                        .start()
                } else {
                    view.translationX = 0f
                    view.translationY = 0f
                }
            }
        }

        private fun resetDraggedWidgetView(view: View) {
            view.animate().cancel()
            view.animate()
                .translationX(0f)
                .translationY(0f)
                .scaleX(1f)
                .scaleY(1f)
                .setDuration(WIDGET_PUSH_PREVIEW_MS)
                .setInterpolator(DecelerateInterpolator())
                .withEndAction {
                    view.elevation = 0f
                    restartWiggleIfEditing()
                }
                .start()
        }

        private fun restartWiggleIfEditing() {
            if (!editing || draggingWidgetId != null) return
            cancelAnimations()
            widgetViews.forEach { (widgetId, view) ->
                view.rotation = 0f
                startWiggle(view, widgetId)
            }
        }

        private fun createWeatherWidget(): View {
            return when (val state = weatherWidgetState) {
                WeatherWidgetUiState.PermissionRequired -> createWeatherStatusWidget(
                    text = binding.root.context.getString(R.string.launcher_widget_location_title),
                    onClick = onWeatherPermissionClicked
                )
                WeatherWidgetUiState.NoNetwork -> createWeatherStatusWidget(
                    text = binding.root.context.getString(R.string.launcher_widget_weather_no_network),
                    onClick = onWeatherWidgetClicked
                )
                WeatherWidgetUiState.Loading -> createWeatherStatusWidget(
                    text = binding.root.context.getString(R.string.launcher_widget_weather_loading),
                    onClick = onWeatherWidgetClicked
                )
                is WeatherWidgetUiState.Forecast -> createWeatherForecastWidget(state.forecast)
            }
        }

        private fun createWeatherStatusWidget(text: String, onClick: () -> Unit): View {
            return FrameLayout(binding.root.context).apply {
                background = GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM,
                    intArrayOf(0xFF3D6FA8.toInt(), 0xFF5A8FD1.toInt())
                ).apply {
                    cornerRadius = dp(18).toFloat()
                }
                isClickable = true
                isFocusable = true
                setOnClickListener { onClick() }
                addView(
                    TextView(context).apply {
                        gravity = Gravity.CENTER
                        this.text = text
                        setTextColor(Color.WHITE)
                        textSize = 19f
                        typeface = Typeface.DEFAULT
                    },
                    FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        Gravity.CENTER
                    )
                )
            }
        }

        private fun createWeatherForecastWidget(forecast: WeatherForecast): View {
            val summary = WeatherHomeWidgetPolicy.homeSummary(forecast)
            return FrameLayout(binding.root.context).apply {
                background = GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM,
                    intArrayOf(0xFF3E70A8.toInt(), 0xFF78A9E6.toInt())
                ).apply {
                    cornerRadius = dp(22).toFloat()
                }
                isClickable = true
                isFocusable = true
                setOnClickListener { onWeatherWidgetClicked() }
                addView(
                    TextView(context).apply {
                        text = summary.locationName
                        setTextColor(Color.WHITE)
                        textSize = 16f
                        typeface = Typeface.DEFAULT_BOLD
                        includeFontPadding = false
                    },
                    FrameLayout.LayoutParams(
                        dp(188),
                        dp(28),
                        Gravity.TOP or Gravity.START
                    ).apply {
                        leftMargin = dp(16)
                        topMargin = dp(16)
                    }
                )
                addView(
                    TextView(context).apply {
                        text = context.getString(
                            R.string.launcher_widget_weather_temperature_format,
                            summary.currentTemperature
                        )
                        setTextColor(Color.WHITE)
                        textSize = 48f
                        includeFontPadding = false
                    },
                    FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        dp(66),
                        Gravity.START or Gravity.TOP
                    ).apply {
                        leftMargin = dp(16)
                        topMargin = dp(50)
                    }
                )
                addView(
                    LinearLayout(context).apply {
                        orientation = LinearLayout.VERTICAL
                        gravity = Gravity.END
                        addView(
                            ImageView(context).apply {
                                setImageResource(weatherIconRes(summary.conditionCode))
                                imageTintList = ColorStateList.valueOf(Color.WHITE)
                            },
                            LinearLayout.LayoutParams(dp(38), dp(38)).apply {
                                bottomMargin = dp(4)
                            }
                        )
                        addView(
                            TextView(context).apply {
                                text = summary.condition
                                setTextColor(Color.WHITE)
                                textSize = 17f
                                typeface = Typeface.DEFAULT_BOLD
                                gravity = Gravity.END
                                includeFontPadding = false
                                maxLines = 1
                            }
                        )
                        addView(
                            TextView(context).apply {
                                text = context.getString(
                                    R.string.launcher_widget_weather_high_low_format,
                                    summary.highTemperature,
                                    summary.lowTemperature
                                )
                                setTextColor(Color.WHITE)
                                textSize = 14f
                                gravity = Gravity.END
                                includeFontPadding = false
                            }
                        )
                    },
                    FrameLayout.LayoutParams(
                        dp(148),
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        Gravity.TOP or Gravity.END
                    ).apply {
                        topMargin = dp(16)
                        rightMargin = dp(14)
                    }
                )
                addView(
                    LinearLayout(context).apply {
                        orientation = LinearLayout.HORIZONTAL
                        gravity = Gravity.CENTER
                        summary.hourly.forEach { item ->
                            addView(
                                createHomeWeatherHourlyColumn(item),
                                LinearLayout.LayoutParams(
                                    0,
                                    ViewGroup.LayoutParams.MATCH_PARENT,
                                    1f
                                )
                            )
                        }
                    },
                    FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        dp(72),
                        Gravity.START or Gravity.BOTTOM
                    ).apply {
                        leftMargin = dp(12)
                        rightMargin = dp(12)
                        bottomMargin = dp(12)
                    }
                )
            }
        }

        private fun createHomeWeatherHourlyColumn(item: HomeHourlyWeather): View {
            return LinearLayout(binding.root.context).apply {
                orientation = LinearLayout.VERTICAL
                gravity = Gravity.CENTER
                addView(
                    TextView(context).apply {
                        text = item.label
                        setTextColor(Color.WHITE)
                        textSize = 13f
                        gravity = Gravity.CENTER
                        includeFontPadding = false
                    },
                    LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        dp(18)
                    )
                )
                addView(
                    ImageView(context).apply {
                        setImageResource(weatherIconRes(item.conditionCode))
                        imageTintList = ColorStateList.valueOf(Color.WHITE)
                    },
                    LinearLayout.LayoutParams(dp(28), dp(28)).apply {
                        topMargin = dp(4)
                    }
                )
                addView(
                    TextView(context).apply {
                        text = context.getString(
                            R.string.launcher_widget_weather_temperature_format,
                            item.temperature
                        )
                        setTextColor(Color.WHITE)
                        textSize = 16f
                        gravity = Gravity.CENTER
                        includeFontPadding = false
                    },
                    LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        dp(22)
                    ).apply {
                        topMargin = dp(2)
                    }
                )
            }
        }

        private fun weatherIconRes(conditionCode: Int): Int {
            return when {
                WeatherConditionMapper.isWet(conditionCode) -> R.drawable.ic_weather_rain_24
                conditionCode == 3 || conditionCode in 45..48 -> R.drawable.ic_weather_cloud_24
                else -> R.drawable.ic_weather_24
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
                                                if (app != null) {
                                                    isClickable = true
                                                    isFocusable = true
                                                    setOnClickListener { onWidgetAppClicked(app) }
                                                }
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
                    leftMargin = dp(2)
                    topMargin = dp(2)
                }
            }
        }

        private fun startWiggle(view: View, widgetId: Long) {
            val startRotation = if (widgetId % 2L == 0L) {
                -WIDGET_WIGGLE_DEGREES
            } else {
                WIDGET_WIGGLE_DEGREES
            }
            view.rotation = startRotation
            ObjectAnimator.ofFloat(view, View.ROTATION, startRotation, -startRotation).apply {
                duration = WIDGET_WIGGLE_DURATION_MS
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
                    gridRows = { pageRows },
                    onDragMoved = onHomeDragMoved,
                    onDragEnded = onHomeDragEnded
                )
            )
            binding.pageRecyclerView.apply {
                layoutManager = FixedPageGridLayoutManager(context, PAGE_COLUMNS)
                adapter = pageAdapter
                itemTouchHelper.attachToRecyclerView(this)
                setHasFixedSize(true)
                itemAnimator = DefaultItemAnimator().apply {
                    supportsChangeAnimations = false
                    addDuration = 0L
                    removeDuration = 0L
                    changeDuration = 0L
                    moveDuration = HOME_ICON_REORDER_MOVE_MS
                }
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
            boundHomePageHolders.remove(boundPagePosition, this)
            boundPagePosition = position
            attachedHomePageHolders[position] = this
            boundHomePageHolders[position] = this
            bindPageItems(items)
        }

        fun bindPageItems(items: List<LauncherHomeItemUiModel>) {
            val pageItems = items.toList()
            pageBindGate.run {
                applyPageItems(pageItems)
            }
        }

        private fun applyPageItems(pageItems: List<LauncherHomeItemUiModel>) {
            clearTemporaryDragPreview(animate = false)
            pageAdapter.setEditing(editing)
            pageAdapter.setDarkMode(darkMode)
            pageAdapter.setLiquidGlassEnabled(liquidGlassEnabled)
            pageAdapter.setIconSizeDp(iconSizeDp)
            pageAdapter.submitItems(pageItems)
            binding.pageRecyclerView.post {
                pageAdapter.setItemHeight(binding.pageRecyclerView.height / pageRows)
            }
        }

        fun applyTemporaryDragPreview(
            basePageItems: List<LauncherHomeItemUiModel>,
            previewPageItems: List<LauncherHomeItemUiModel>
        ) {
            val recyclerView = binding.pageRecyclerView
            val width = recyclerView.width.takeIf { it > 0 } ?: return
            val height = recyclerView.height.takeIf { it > 0 } ?: return
            val cellWidth = width / PAGE_COLUMNS.toFloat()
            val cellHeight = height / pageRows.coerceAtLeast(1).toFloat()
            val movesByStableId = LauncherHomeDragPreviewPlanner
                .moves(basePageItems, previewPageItems)
                .associateBy { move -> move.stableId }

            for (index in 0 until recyclerView.childCount) {
                val child = recyclerView.getChildAt(index)
                val holder = recyclerView.getChildViewHolder(child)
                val adapterPosition = holder.bindingAdapterPosition
                val item = pageAdapter.itemAt(adapterPosition)
                val move = item?.stableId?.let { stableId -> movesByStableId[stableId] }
                val targetTranslation = move?.translation(
                    cellWidth = cellWidth,
                    cellHeight = cellHeight
                )
                child.animate().cancel()
                child.animate()
                    .translationX(targetTranslation?.first ?: 0f)
                    .translationY(targetTranslation?.second ?: 0f)
                    .setDuration(HOME_ICON_REORDER_MOVE_MS)
                    .setInterpolator(DecelerateInterpolator())
                    .start()
            }
        }

        fun clearTemporaryDragPreview(animate: Boolean) {
            val recyclerView = binding.pageRecyclerView
            for (index in 0 until recyclerView.childCount) {
                val child = recyclerView.getChildAt(index)
                child.animate().cancel()
                if (animate) {
                    child.animate()
                        .translationX(0f)
                        .translationY(0f)
                        .setDuration(HOME_ICON_REORDER_MOVE_MS)
                        .setInterpolator(DecelerateInterpolator())
                        .start()
                } else {
                    child.translationX = 0f
                    child.translationY = 0f
                }
            }
        }

        private fun shouldDeferPageBind(): Boolean {
            val recyclerView = binding.pageRecyclerView
            val parent = parentRecyclerView
            return LauncherPageBindDeferral.shouldDeferChildAdapterUpdate(
                childComputingLayout = recyclerView.isComputingLayout,
                childItemAnimatorRunning = recyclerView.itemAnimator?.isRunning == true,
                parentComputingLayout = parent?.isComputingLayout == true,
                parentScrollState = parent?.scrollState ?: RecyclerView.SCROLL_STATE_IDLE
            )
        }

        fun setDarkMode(enabled: Boolean) {
            pageAdapter.setDarkMode(enabled)
        }

        fun setLiquidGlassEnabled(enabled: Boolean) {
            pageAdapter.setLiquidGlassEnabled(enabled)
        }

        fun setEditing(enabled: Boolean) {
            pageBindGate.run {
                pageAdapter.setEditing(enabled)
            }
        }

        fun setIconSizeDp(sizeDp: Int) {
            pageBindGate.run {
                pageAdapter.setIconSizeDp(sizeDp)
            }
        }

        fun cancelPendingPageBind() {
            pageBindGate.cancelPendingUpdate()
            clearTemporaryDragPreview(animate = false)
        }

        fun boundPagePosition(): Int = boundPagePosition

        private fun LauncherHomeDragPreviewPlanner.Move.translation(
            cellWidth: Float,
            cellHeight: Float
        ): Pair<Float, Float> {
            val fromColumn = fromIndex % PAGE_COLUMNS
            val fromRow = fromIndex / PAGE_COLUMNS
            val toColumn = toIndex % PAGE_COLUMNS
            val toRow = toIndex / PAGE_COLUMNS
            return Pair(
                (toColumn - fromColumn) * cellWidth,
                (toRow - fromRow) * cellHeight
            )
        }
    }

    private fun handlePageItemsChanged(pagePosition: Int, pageItems: List<LauncherHomeItemUiModel>) {
        if (pagePosition !in pages.indices) return

        val updatedItems = LauncherHomeScreenGridPolicy.replacePage(
            pages = pages,
            pagePosition = pagePosition,
            pageItems = pageItems,
            pageSize = pageSize()
        )
        sourceItems.clear()
        sourceItems.addAll(updatedItems)
        val oldPages = pages.toList()
        val updatedPages = LauncherHomeScreenGridPolicy
            .padToFullPages(updatedItems, pageSize())
            .chunked(pageSize())
        val diff = LauncherPageDiff.between(oldPages, updatedPages)
        pages.clear()
        pages.addAll(updatedPages)
        dispatchHomePageUpdates(
            oldPages = oldPages,
            newPages = updatedPages,
            diff = diff
        )
        onHomeItemsChanged(updatedItems)
    }

    private fun dispatchHomePageUpdates(
        oldPages: List<List<LauncherHomeItemUiModel>>,
        newPages: List<List<LauncherHomeItemUiModel>>,
        diff: LauncherPageDiff.Result,
        focusedPage: Int? = null
    ) {
        if (diff.pageCountChanged) {
            dispatchHomePageCountChanged(oldPages, newPages, focusedPage)
            return
        }

        ((diff.changedIndices + listOfNotNull(focusedPage))
            .filter { index -> index in pages.indices }
            .distinct()
        ).forEach { index ->
            bindOrNotifyHomePage(index)
        }
    }

    private fun dispatchHomePageCountChanged(
        oldPages: List<List<LauncherHomeItemUiModel>>,
        newPages: List<List<LauncherHomeItemUiModel>>,
        focusedPage: Int?
    ) {
        val update = LauncherHomePageCountUpdatePolicy.plan(
            oldPages = oldPages,
            newPages = newPages,
            focusedPage = focusedPage
        )

        update.removedPageStart?.let { start ->
            attachedHomePageHolders.keys
                .filter { page -> page >= start }
                .toList()
                .forEach { page ->
                    attachedHomePageHolders.remove(page)
                    boundHomePageHolders.remove(page)
                }
            notifyItemRangeRemoved(
                adapterPositionForHomePage(start),
                update.removedPageCount
            )
        }
        update.insertedPageStart?.let { start ->
            notifyItemRangeInserted(
                adapterPositionForHomePage(start),
                update.insertedPageCount
            )
        }
        update.changedPages.forEach { index ->
            bindOrNotifyHomePage(index)
        }
    }

    private fun bindOrNotifyHomePage(index: Int) {
        val holder = attachedHomePageHolders[index]
        if (holder != null) {
            holder.bindPageItems(pages[index])
        } else {
            notifyItemChanged(adapterPositionForHomePage(index))
        }
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
            groupAdapter.setLiquidGlassEnabled(liquidGlassEnabled)
            groupAdapter.submitGroups(groups)
        }

        fun setDarkMode(enabled: Boolean) {
            groupAdapter.setDarkMode(enabled)
            applyAppearance()
        }

        fun setLiquidGlassEnabled(enabled: Boolean) {
            groupAdapter.setLiquidGlassEnabled(enabled)
            applyAppearance()
        }

        private fun applyAppearance() {
            val pillStyle = LauncherLiquidGlassStylePolicy.appLibrarySearchPill(
                enabled = liquidGlassEnabled,
                darkMode = darkMode
            )
            val textColor = Color.WHITE
            binding.librarySearchPillGlassSurface.applyLiquidGlass(
                enabled = liquidGlassEnabled,
                source = binding.root.rootView as? ViewGroup,
                profile = AndroidLiquidGlassPolicy.profileFor(
                    surface = AndroidLiquidGlassPolicy.Surface.APP_LIBRARY_SEARCH,
                    radiusDp = pillStyle.radiusDp
                )
            )
            binding.librarySearchPillGlassSurface.applyFallbackBackground(
                roundedBackground(
                    binding.root,
                    pillStyle.color,
                    pillStyle.radiusDp,
                    pillStyle.strokeColor
                )
            )
            binding.librarySearchPill.background = null
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
        val isSmall: Boolean,
        val widgetSize: LauncherTodayWidgetSize
    ) {
        WEATHER(isSmall = false, widgetSize = LauncherTodayWidgetSize.WIDE),
        BATTERY(isSmall = true, widgetSize = LauncherTodayWidgetSize.SMALL),
        PICTURE(isSmall = true, widgetSize = LauncherTodayWidgetSize.SMALL),
        APP_GROUP(isSmall = false, widgetSize = LauncherTodayWidgetSize.WIDE)
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
        const val WEATHER_FORECAST_WIDGET_HEIGHT_DP = 184
        const val APP_GROUP_WIDGET_HEIGHT_DP = 190
        const val SMALL_WIDGET_HEIGHT_DP = 168
        const val SINGLE_SMALL_WIDGET_WIDTH_DP = 168
        const val SMALL_WIDGET_GAP_DP = 22
        const val WEATHER_WIDGET_BOTTOM_MARGIN_DP = 34
        const val WIDGET_BOTTOM_MARGIN_DP = 22
        const val WIDGET_PUSH_PREVIEW_MS = 130L
        const val WIDGET_DRAG_PREVIEW_THROTTLE_MS = 28L
        const val WIDGET_DRAG_PREVIEW_MIN_MOVE_DP = 4
        const val HOME_ICON_REORDER_MOVE_MS = 170L
        const val MIN_PAGE_ROWS = 5
        const val DEFAULT_PAGE_ROWS = 6
        const val MAX_PAGE_ROWS = 6
        const val MIN_ICON_SIZE_DP = LauncherHomeIconSizePolicy.MIN_HOME_ICON_SIZE_DP
        const val DEFAULT_ICON_SIZE_DP = LauncherHomeIconSizePolicy.DEFAULT_HOME_ICON_SIZE_DP
        const val MAX_ICON_SIZE_DP = LauncherHomeIconSizePolicy.MAX_HOME_ICON_SIZE_DP
        const val WIDGET_WIGGLE_DEGREES = 1.45f
        const val WIDGET_WIGGLE_DURATION_MS = 130L
    }
}

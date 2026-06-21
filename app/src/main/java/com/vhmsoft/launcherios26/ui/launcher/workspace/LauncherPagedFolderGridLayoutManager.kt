package com.vhmsoft.launcherios26.ui.launcher.workspace

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.max
import kotlin.math.min

class LauncherPagedFolderGridLayoutManager : RecyclerView.LayoutManager() {
    private var horizontalScrollOffset = 0
    private var pendingScrollPosition = RecyclerView.NO_POSITION

    override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
        return RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    override fun canScrollHorizontally(): Boolean = true

    override fun canScrollVertically(): Boolean = false

    override fun onLayoutChildren(
        recycler: RecyclerView.Recycler,
        state: RecyclerView.State
    ) {
        if (state.itemCount == 0) {
            horizontalScrollOffset = 0
            detachAndScrapAttachedViews(recycler)
            return
        }

        pendingScrollPosition.takeIf { it != RecyclerView.NO_POSITION }?.let { position ->
            horizontalScrollOffset = pageForPosition(position.coerceIn(0, state.itemCount - 1)) * pageWidth()
            pendingScrollPosition = RecyclerView.NO_POSITION
        }
        horizontalScrollOffset = horizontalScrollOffset.coerceIn(0, maxScrollOffset(state.itemCount))
        layoutVisibleChildren(recycler, state)
    }

    override fun scrollHorizontallyBy(
        dx: Int,
        recycler: RecyclerView.Recycler,
        state: RecyclerView.State
    ): Int {
        if (dx == 0 || state.itemCount == 0) return 0

        val nextOffset = (horizontalScrollOffset + dx).coerceIn(0, maxScrollOffset(state.itemCount))
        val traveled = nextOffset - horizontalScrollOffset
        if (traveled == 0) return 0

        horizontalScrollOffset = nextOffset
        layoutVisibleChildren(recycler, state)
        return traveled
    }

    override fun scrollToPosition(position: Int) {
        pendingScrollPosition = position.coerceAtLeast(0)
        requestLayout()
    }

    override fun computeHorizontalScrollExtent(state: RecyclerView.State): Int {
        return pageWidth()
    }

    override fun computeHorizontalScrollOffset(state: RecyclerView.State): Int {
        return horizontalScrollOffset
    }

    override fun computeHorizontalScrollRange(state: RecyclerView.State): Int {
        return pageWidth() * max(1, LauncherPagedFolderGridPolicy.pageCount(state.itemCount))
    }

    fun distanceToNearestPage(): Int {
        val pageWidth = pageWidth()
        if (pageWidth <= 0) return 0

        val nearestPage = ((horizontalScrollOffset + pageWidth / 2) / pageWidth)
            .coerceIn(0, max(0, LauncherPagedFolderGridPolicy.pageCount(itemCount) - 1))
        return nearestPage * pageWidth - horizontalScrollOffset
    }

    private fun layoutVisibleChildren(
        recycler: RecyclerView.Recycler,
        state: RecyclerView.State
    ) {
        detachAndScrapAttachedViews(recycler)
        if (state.itemCount == 0 || pageWidth() <= 0 || contentHeight() <= 0) return

        val firstPage = (horizontalScrollOffset / pageWidth()).coerceAtLeast(0)
        val lastPage = ((horizontalScrollOffset + pageWidth()) / pageWidth())
            .coerceAtMost(max(0, LauncherPagedFolderGridPolicy.pageCount(state.itemCount) - 1))
        val firstPosition = firstPage * LauncherPagedFolderGridPolicy.ITEMS_PER_PAGE
        val lastPosition = min(
            state.itemCount - 1,
            ((lastPage + 1) * LauncherPagedFolderGridPolicy.ITEMS_PER_PAGE) - 1
        )

        for (position in firstPosition..lastPosition) {
            val view = recycler.getViewForPosition(position)
            addView(view)
            measureChildForCell(view)
            val cell = LauncherPagedFolderGridPolicy.cellPosition(position)
            val left = paddingLeft + cell.page * pageWidth() + cellLeft(cell.column) - horizontalScrollOffset
            val top = paddingTop + cellTop(cell.row)
            layoutDecoratedWithMargins(
                view,
                left,
                top,
                left + cellWidth(cell.column),
                top + cellHeight(cell.row)
            )
        }
    }

    private fun measureChildForCell(view: View) {
        val cell = LauncherPagedFolderGridPolicy.cellPosition(getPosition(view))
        val widthSpec = View.MeasureSpec.makeMeasureSpec(
            cellWidth(cell.column),
            View.MeasureSpec.EXACTLY
        )
        val heightSpec = View.MeasureSpec.makeMeasureSpec(
            cellHeight(cell.row),
            View.MeasureSpec.EXACTLY
        )
        view.measure(widthSpec, heightSpec)
    }

    private fun pageForPosition(position: Int): Int {
        return LauncherPagedFolderGridPolicy.cellPosition(position).page
    }

    private fun maxScrollOffset(itemCount: Int): Int {
        val pageCount = LauncherPagedFolderGridPolicy.pageCount(itemCount)
        return max(0, (pageCount - 1) * pageWidth())
    }

    private fun pageWidth(): Int {
        return (width - paddingLeft - paddingRight).coerceAtLeast(0)
    }

    private fun contentHeight(): Int {
        return (height - paddingTop - paddingBottom).coerceAtLeast(0)
    }

    private fun cellLeft(column: Int): Int {
        return distributedStart(pageWidth(), LauncherPagedFolderGridPolicy.COLUMNS, column)
    }

    private fun cellTop(row: Int): Int {
        return distributedStart(contentHeight(), LauncherPagedFolderGridPolicy.ROWS, row)
    }

    private fun cellWidth(column: Int): Int {
        return distributedSize(pageWidth(), LauncherPagedFolderGridPolicy.COLUMNS, column)
    }

    private fun cellHeight(row: Int): Int {
        return distributedSize(contentHeight(), LauncherPagedFolderGridPolicy.ROWS, row)
    }

    private fun distributedStart(total: Int, parts: Int, index: Int): Int {
        val base = total / parts
        val remainder = total % parts
        return index * base + min(index, remainder)
    }

    private fun distributedSize(total: Int, parts: Int, index: Int): Int {
        return total / parts + if (index < total % parts) 1 else 0
    }
}

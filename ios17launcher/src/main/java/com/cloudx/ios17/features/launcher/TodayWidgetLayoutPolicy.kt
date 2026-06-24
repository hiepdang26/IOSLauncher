package com.cloudx.ios17.features.launcher

object TodayWidgetLayoutPolicy {
    enum class Span {
        HALF,
        FULL
    }

    data class Item(
        val id: Int,
        val span: Span
    )

    data class Row(
        val span: Span,
        val ids: List<Int>
    )

    fun spanFor(minWidth: Int, minHeight: Int): Span {
        if (minWidth <= 0 || minHeight <= 0) {
            return Span.FULL
        }
        return if (minWidth > minHeight * WIDE_WIDGET_RATIO) Span.FULL else Span.HALF
    }

    fun packRows(items: List<Item>): List<Row> {
        val rows = mutableListOf<Row>()
        val pendingHalf = mutableListOf<Int>()

        fun flushHalfRow() {
            if (pendingHalf.isNotEmpty()) {
                rows.add(Row(Span.HALF, pendingHalf.toList()))
                pendingHalf.clear()
            }
        }

        for (item in items) {
            if (item.span == Span.FULL) {
                flushHalfRow()
                rows.add(Row(Span.FULL, listOf(item.id)))
            } else {
                pendingHalf.add(item.id)
                if (pendingHalf.size == HALF_ROW_CAPACITY) {
                    flushHalfRow()
                }
            }
        }
        flushHalfRow()

        return rows
    }

    fun reorder(ids: List<Int>, draggedId: Int, targetIndex: Int): List<Int> {
        if (!ids.contains(draggedId)) {
            return ids
        }
        val mutable = ids.toMutableList()
        mutable.remove(draggedId)
        val boundedTarget = targetIndex.coerceIn(0, mutable.size)
        mutable.add(boundedTarget, draggedId)
        return mutable
    }

    fun previewOrder(ids: List<Int>, draggedId: Int, targetIndex: Int): List<Int> {
        return reorder(ids, draggedId, targetIndex)
    }

    private const val WIDE_WIDGET_RATIO = 1.35f
    private const val HALF_ROW_CAPACITY = 2
}

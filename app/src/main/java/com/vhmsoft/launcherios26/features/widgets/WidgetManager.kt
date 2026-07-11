package com.vhmsoft.launcherios26.features.widgets

import com.vhmsoft.launcherios26.core.customviews.RoundedWidgetView
import java.util.LinkedList
import java.util.Queue

class WidgetManager private constructor() {
    private val removeWidgetIds: Queue<Int> = LinkedList()
    private val addWidgetViews: Queue<RoundedWidgetView> = LinkedList()

    fun enqueueRemoveId(id: Int) {
        val iterator = addWidgetViews.iterator()
        while (iterator.hasNext()) {
            val view = iterator.next()
            if (id == view.appWidgetId) {
                addWidgetViews.remove(view)
                break
            }
        }
        removeWidgetIds.add(id)
    }

    fun enqueueAddWidget(view: RoundedWidgetView) {
        addWidgetViews.add(view)
    }

    fun dequeRemoveId(): Int? = removeWidgetIds.poll()

    fun dequeAddWidgetView(): RoundedWidgetView? = addWidgetViews.poll()

    companion object {
        private val ourInstance = WidgetManager()

        @JvmStatic
        fun getInstance(): WidgetManager = ourInstance
    }
}

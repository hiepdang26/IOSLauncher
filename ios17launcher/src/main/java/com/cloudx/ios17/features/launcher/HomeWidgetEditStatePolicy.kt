package com.cloudx.ios17.features.launcher

object HomeWidgetEditStatePolicy {

    fun shouldShowRemoveButton(editing: Boolean, draggingWidget: Boolean): Boolean {
        return editing && !draggingWidget
    }

    fun shouldAnimateWidget(editing: Boolean, draggingWidget: Boolean): Boolean {
        return editing && !draggingWidget
    }

    fun shouldHideEntryCardOnHomeTap(editing: Boolean, entryCardVisible: Boolean): Boolean {
        return editing && entryCardVisible
    }

    fun shouldPurgeEditChrome(editing: Boolean, draggingWidget: Boolean): Boolean {
        return !shouldShowRemoveButton(editing, draggingWidget)
    }

    fun shouldResetTransientTouchState(editing: Boolean): Boolean {
        return !editing
    }
}

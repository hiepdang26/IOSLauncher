package com.cloudx.ios17.core.events

import com.cloudx.ios17.core.database.model.ShortcutItem

class ShortcutAddEvent(
    val shortcutItem: ShortcutItem
) : Event(TYPE) {
    companion object {
        const val TYPE = 603
    }
}

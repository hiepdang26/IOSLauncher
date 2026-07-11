package com.vhmsoft.launcherios26.core.events

import com.vhmsoft.launcherios26.core.database.model.ShortcutItem

class ShortcutAddEvent(
    val shortcutItem: ShortcutItem
) : Event(TYPE) {
    companion object {
        const val TYPE = 603
    }
}

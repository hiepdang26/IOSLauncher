package com.vhmsoft.launcherios26.core.events

import com.vhmsoft.launcherios26.core.utils.UserHandle

class AppRemoveEvent(
    val packageName: String,
    val userHandle: UserHandle
) : Event(TYPE) {
    companion object {
        const val TYPE = 602
    }
}

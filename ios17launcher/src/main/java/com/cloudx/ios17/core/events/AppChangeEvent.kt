package com.cloudx.ios17.core.events

import com.cloudx.ios17.core.utils.UserHandle

class AppChangeEvent(
    val packageName: String,
    val userHandle: UserHandle
) : Event(TYPE) {
    companion object {
        const val TYPE = 601
    }
}

package com.vhmsoft.launcherios26.core.events

import com.vhmsoft.launcherios26.core.utils.UserHandle

class AppAddEvent(
    val packageName: String,
    val userHandle: UserHandle
) : Event(TYPE) {
    override fun toString(): String {
        return "AppAddEvent{packageName='$packageName', userHandle=$userHandle}"
    }

    companion object {
        const val TYPE = 600
    }
}

package com.cloudx.ios17.core.events

class AppRenameEvent(
    val appKeys: List<String>,
    val updatedTitle: String
) : Event(TYPE) {
    companion object {
        const val TYPE = 604
    }
}

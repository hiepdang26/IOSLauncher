package com.vhmsoft.launcherios26.core.events

class AppWallpaperEvent(
    val wallpaperUri: String?
) : Event(TYPE) {
    companion object {
        const val TYPE = 605
    }
}

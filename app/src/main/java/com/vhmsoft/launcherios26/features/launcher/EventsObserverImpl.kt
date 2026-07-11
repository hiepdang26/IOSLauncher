package com.vhmsoft.launcherios26.features.launcher

import com.vhmsoft.launcherios26.core.events.AppAddEvent
import com.vhmsoft.launcherios26.core.events.AppChangeEvent
import com.vhmsoft.launcherios26.core.events.AppRemoveEvent
import com.vhmsoft.launcherios26.core.events.AppRenameEvent
import com.vhmsoft.launcherios26.core.events.AppWallpaperEvent
import com.vhmsoft.launcherios26.core.events.Event
import com.vhmsoft.launcherios26.core.events.EventRelay
import com.vhmsoft.launcherios26.core.events.ForceReloadEvent
import com.vhmsoft.launcherios26.core.events.ShortcutAddEvent
import com.vhmsoft.launcherios26.core.events.TimeChangedEvent
import java.util.Calendar
import timber.log.Timber

class EventsObserverImpl(activity: LauncherActivity) : EventRelay.EventsObserver<Event> {

    private var launcherActivity: LauncherActivity? = activity

    override fun accept(event: Event) {
        Timber.tag(TAG).i("accept: %s", event.eventType)
        val activity = launcherActivity ?: return
        when (event.eventType) {
            AppAddEvent.TYPE -> activity.onAppAddEvent(event as AppAddEvent)
            AppChangeEvent.TYPE -> activity.onAppChangeEvent(event as AppChangeEvent)
            AppRemoveEvent.TYPE -> activity.onAppRemoveEvent(event as AppRemoveEvent)
            ShortcutAddEvent.TYPE -> activity.onShortcutAddEvent(event as ShortcutAddEvent)
            AppRenameEvent.TYPE -> activity.onAppRenameEvent(event as AppRenameEvent)
            AppWallpaperEvent.TYPE -> activity.onAppWallpaperEvent(event as AppWallpaperEvent)
            TimeChangedEvent.TYPE -> activity.updateAllCalendarIcons(Calendar.getInstance())
            ForceReloadEvent.TYPE -> activity.forceReload()
        }
    }

    override fun complete() {
        // BlissLauncher.getApplication(launcherActivity).getAppProvider().reload();
    }

    override fun clear() {
        launcherActivity = null
    }

    companion object {
        private const val TAG = "EventsObserverImpl"
    }
}

package com.cloudx.ios17.features.launcher

import com.cloudx.ios17.core.events.AppAddEvent
import com.cloudx.ios17.core.events.AppChangeEvent
import com.cloudx.ios17.core.events.AppRemoveEvent
import com.cloudx.ios17.core.events.Event
import com.cloudx.ios17.core.events.EventRelay
import com.cloudx.ios17.core.events.ForceReloadEvent
import com.cloudx.ios17.core.events.ShortcutAddEvent
import com.cloudx.ios17.core.events.TimeChangedEvent
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

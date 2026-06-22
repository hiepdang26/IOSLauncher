package com.cloudx.ios17.core.events

import java.util.Queue
import java.util.concurrent.ConcurrentLinkedQueue

class EventRelay private constructor() {
    private val events: Queue<Event> = ConcurrentLinkedQueue()
    private var observer: EventsObserver<Event>? = null

    fun push(event: Event) {
        val currentObserver = observer
        if (currentObserver != null) {
            currentObserver.accept(event)
            if (event !is TimeChangedEvent) {
                currentObserver.complete()
            }
        } else {
            events.offer(event)
        }
    }

    fun subscribe(observer: EventsObserver<Event>) {
        this.observer = observer
        var event = events.poll()
        val shouldInvokeComplete = event != null

        while (event != null) {
            this.observer?.accept(event)
            event = events.poll()
        }

        if (shouldInvokeComplete) {
            this.observer?.complete()
        }
    }

    fun unsubscribe() {
        observer?.clear()
        observer = null
    }

    interface EventsObserver<T> {
        fun accept(event: T)
        fun complete()
        fun clear()
    }

    companion object {
        @Volatile
        private var sInstance: EventRelay? = null

        @JvmStatic
        fun getInstance(): EventRelay {
            if (sInstance == null) {
                synchronized(EventRelay::class.java) {
                    if (sInstance == null) {
                        sInstance = EventRelay()
                    }
                }
            }
            return sInstance!!
        }
    }
}

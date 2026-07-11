package com.vhmsoft.launcherios26.features.notification

import com.jakewharton.rxrelay2.BehaviorRelay

class NotificationRepository private constructor() {
    private val notificationRelay: BehaviorRelay<Set<String>> =
        BehaviorRelay.createDefault(emptySet())

    fun clearNotifications() {
        notificationRelay.accept(emptySet())
    }

    fun getNotifications(): BehaviorRelay<Set<String>> = notificationRelay

    companion object {
        private var sInstance: NotificationRepository? = null

        @JvmStatic
        fun getNotificationRepository(): NotificationRepository {
            if (sInstance == null) {
                sInstance = NotificationRepository()
            }
            return sInstance!!
        }
    }
}

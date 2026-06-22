package com.cloudx.ios17.features.notification

import android.app.Notification
import android.service.notification.StatusBarNotification
import com.jakewharton.rxrelay2.BehaviorRelay
import timber.log.Timber

class NotificationRepository private constructor() {
    private val notificationRelay: BehaviorRelay<Set<String>> =
        BehaviorRelay.createDefault(emptySet())

    fun updateNotification(list: List<StatusBarNotification>) {
        Timber.tag(TAG).d("updateNotification() called with: list = [${list.size}]")
        val notificationSet = HashSet<String>()
        for (statusBarNotification in list) {
            val notification = statusBarNotification.notification
            if ((notification.flags and Notification.FLAG_ONGOING_EVENT) == Notification.FLAG_ONGOING_EVENT ||
                (notification.flags and Notification.FLAG_FOREGROUND_SERVICE) == Notification.FLAG_FOREGROUND_SERVICE
            ) {
                continue
            }
            notificationSet.add(statusBarNotification.packageName)
        }
        notificationRelay.accept(notificationSet)
    }

    fun getNotifications(): BehaviorRelay<Set<String>> = notificationRelay

    companion object {
        private const val TAG = "NotificationRepository"
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

package com.cloudx.ios17.features.notification

import android.content.Intent
import android.database.ContentObserver
import android.os.Handler
import android.provider.Settings
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import com.cloudx.ios17.BlissLauncher
import com.cloudx.ios17.core.utils.ListUtil
import java.util.Collections

class NotificationService : NotificationListenerService() {

    private lateinit var mNotificationRepository: NotificationRepository
    private var mAreDotsDisabled = false

    private val mNotificationSettingsObserver: ContentObserver = object : ContentObserver(Handler()) {
        override fun onChange(selfChange: Boolean) {
            onNotificationSettingsChanged()
        }
    }

    override fun onCreate() {
        super.onCreate()
        mNotificationRepository = NotificationRepository.getNotificationRepository()

        contentResolver.registerContentObserver(
            BlissLauncher.NOTIFICATION_BADGING_URI,
            false,
            mNotificationSettingsObserver
        )
        onNotificationSettingsChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        contentResolver.unregisterContentObserver(mNotificationSettingsObserver)
        mNotificationRepository.updateNotification(Collections.emptyList())
    }

    private fun onNotificationSettingsChanged() {
        mAreDotsDisabled = Settings.Secure.getInt(
            contentResolver,
            BlissLauncher.NOTIFICATION_BADGING_URI.lastPathSegment,
            1
        ) != 1
        if (mAreDotsDisabled && sIsConnected) {
            requestUnbind()
            updateNotifications()
        }
    }

    override fun onListenerConnected() {
        sIsConnected = true
        updateNotifications()
    }

    override fun onListenerDisconnected() {
        sIsConnected = false
    }

    override fun onNotificationPosted(sbn: StatusBarNotification) {
        updateNotifications()
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification) {
        updateNotifications()
    }

    private fun updateNotifications() {
        if (mAreDotsDisabled) {
            mNotificationRepository.updateNotification(Collections.emptyList())
            return
        }
        mNotificationRepository.updateNotification(ListUtil.asSafeList(*activeNotifications))
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int = START_STICKY

    companion object {
        private var sIsConnected = false
    }
}

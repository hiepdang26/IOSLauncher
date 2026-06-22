package com.cloudx.ios17

import android.app.Application
import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Context
import android.database.ContentObserver
import android.net.Uri
import android.os.Handler
import android.provider.Settings
import android.service.notification.NotificationListenerService
import android.util.Log
import com.cloudx.ios17.core.DeviceProfile
import com.cloudx.ios17.core.IconsHandler
import com.cloudx.ios17.core.blur.BlurWallpaperProvider
import com.cloudx.ios17.core.customviews.WidgetHost
import com.cloudx.ios17.features.launcher.AppProvider
import com.cloudx.ios17.features.notification.NotificationService
import foundation.e.lib.telemetry.Telemetry
import timber.log.Timber

open class BlissLauncher : Application() {

    private var iconsPackHandler: IconsHandler? = null
    private var deviceProfileInternal: DeviceProfile? = null
    private var mAppProvider: AppProvider? = null

    private class ReleaseTree : Timber.Tree() {
        override fun log(priority: Int, tag: String?, message: String, throwable: Throwable?) {
            if (priority < Log.INFO) {
                return
            }

            Log.println(priority, tag, message)
        }
    }

    override fun onCreate() {
        super.onCreate()
        sAppWidgetManager = AppWidgetManager.getInstance(applicationContext)
        sAppWidgetHost = WidgetHost(applicationContext, R.id.APPWIDGET_HOST_ID)
        sAppWidgetHost?.startListening()

        connectAppProvider()
        BlurWallpaperProvider.getInstance(this)

        val notificationSettingsObserver: ContentObserver = object : ContentObserver(Handler()) {
            override fun onChange(selfChange: Boolean) {
                onNotificationSettingsChanged()
            }
        }
        contentResolver.registerContentObserver(NOTIFICATION_BADGING_URI, false, notificationSettingsObserver)

        if (!BuildConfig.DEBUG) {
            Telemetry.init(BuildConfig.SENTRY_DSN, this, true)
            Timber.plant(ReleaseTree())
        } else {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun onNotificationSettingsChanged() {
        val areNotificationDotsEnabled = Settings.Secure.getInt(
            contentResolver,
            NOTIFICATION_BADGING_URI.lastPathSegment,
            1
        ) == 1
        if (areNotificationDotsEnabled) {
            NotificationListenerService.requestRebind(ComponentName(this, NotificationService::class.java))
        }
    }

    val deviceProfile: DeviceProfile
        get() {
            if (deviceProfileInternal == null) {
                deviceProfileInternal = DeviceProfile(this)
            }
            return requireNotNull(deviceProfileInternal)
        }

    fun resetDeviceProfile() {
        deviceProfileInternal = DeviceProfile(this)
    }

    val iconsHandler: IconsHandler
        get() {
            if (iconsPackHandler == null) {
                iconsPackHandler = IconsHandler(this)
            }
            return requireNotNull(iconsPackHandler)
        }

    fun resetIconsHandler() {
        iconsPackHandler = IconsHandler(this)
    }

    private fun connectAppProvider() {
        mAppProvider = AppProvider.getInstance(this)
    }

    val appProvider: AppProvider
        get() {
            if (mAppProvider == null) {
                connectAppProvider()
            }
            return requireNotNull(mAppProvider)
        }

    val appWidgetHost: WidgetHost
        get() = requireNotNull(sAppWidgetHost)

    val appWidgetManager: AppWidgetManager
        get() = requireNotNull(sAppWidgetManager)

    override fun onTerminate() {
        super.onTerminate()
        sAppWidgetHost?.stopListening()
        sAppWidgetHost = null
    }

    companion object {
        @JvmField
        val NOTIFICATION_BADGING_URI: Uri = Settings.Secure.getUriFor("notification_badging")

        private var sAppWidgetHost: WidgetHost? = null
        private var sAppWidgetManager: AppWidgetManager? = null

        @JvmStatic
        fun getApplication(context: Context): BlissLauncher =
            context.applicationContext as BlissLauncher

        @JvmStatic
        fun getLongPressTimeout(): Long = 500
    }
}

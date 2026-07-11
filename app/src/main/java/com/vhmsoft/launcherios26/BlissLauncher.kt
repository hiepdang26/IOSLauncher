package com.vhmsoft.launcherios26

import android.app.Application
import android.appwidget.AppWidgetManager
import android.content.Context
import android.util.Log
import com.vhmsoft.launcherios26.core.DeviceProfile
import com.vhmsoft.launcherios26.core.IconsHandler
import com.vhmsoft.launcherios26.core.blur.BlurWallpaperProvider
import com.vhmsoft.launcherios26.core.customviews.WidgetHost
import com.vhmsoft.launcherios26.features.launcher.AppProvider
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

        if (!BuildConfig.DEBUG) {
            Timber.plant(ReleaseTree())
        } else {
            Timber.plant(Timber.DebugTree())
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
        private var sAppWidgetHost: WidgetHost? = null
        private var sAppWidgetManager: AppWidgetManager? = null

        @JvmStatic
        fun getApplication(context: Context): BlissLauncher =
            context.applicationContext as BlissLauncher

        @JvmStatic
        fun getLongPressTimeout(): Long = 500
    }
}

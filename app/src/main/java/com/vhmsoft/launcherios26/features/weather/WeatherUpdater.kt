package com.vhmsoft.launcherios26.features.weather

import android.content.Context
import android.content.Intent
import android.os.SystemClock
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.vhmsoft.launcherios26.core.Preferences
import java.lang.ref.WeakReference
import lineageos.weather.LineageWeatherManager
import lineageos.weather.WeatherInfo
import lineageos.weather.WeatherLocation
import timber.log.Timber

class WeatherUpdater private constructor(context: Context) {

    private val mWeakContext = WeakReference(context)
    private var mLastWeatherUpdateInMs = 0L

    fun checkWeatherRequest() {
        val context = mWeakContext.get() ?: return
        val refreshPeriodInMs = Preferences.weatherRefreshIntervalInMs(context)
        val systemTimeInMs = SystemClock.elapsedRealtime()
        val elapsedTimeInMs = kotlin.math.abs(systemTimeInMs - mLastWeatherUpdateInMs)

        val isPeriodicRequestAllowed = refreshPeriodInMs != 0L && elapsedTimeInMs >= refreshPeriodInMs
        if (isPeriodicRequestAllowed) {
            updateWeather()
            mLastWeatherUpdateInMs = systemTimeInMs
        }
    }

    fun updateWeather() {
        Timber.tag(TAG).i("Updating weather")
        val context = mWeakContext.get() ?: return

        if (Preferences.useCustomWeatherLocation(context)) {
            requestCustomWeatherUpdate(Preferences.getCustomWeatherLocation(context))
        } else {
            fetchNewLocation()
        }
    }

    private fun fetchNewLocation() {
        Timber.tag(TAG).i("Device-location weather is disabled in this build")
    }

    protected fun requestCustomWeatherUpdate(location: WeatherLocation?) {
        if (location == null) {
            Timber.tag(TAG).w("Custom location is null. Cannot request weather")
            return
        }

        Timber.tag(TAG).i("Requesting weather info for location: %s", location)
        val context = mWeakContext.get() ?: return
        val weatherManager = LineageWeatherManager.getInstance(context)
        weatherManager.requestWeatherUpdate(location) { status: Int, weatherInfo: WeatherInfo? ->
            notifyUi(context, weatherInfo, status)
        }
    }

    private fun notifyUi(context: Context, weatherInfo: WeatherInfo?, status: Int) {
        if (weatherInfo == null) {
            Timber.tag(TAG).i("WeatherInfo is null. Status reported: %s", status)
            return
        }

        Timber.tag(TAG).i("WeatherInfo=%s", weatherInfo)

        val now = SystemClock.elapsedRealtime()
        Preferences.setCachedWeatherInfo(context, now, weatherInfo)
        val updateIntent = Intent(WeatherUpdateService.ACTION_UPDATE_FINISHED)
        LocalBroadcastManager.getInstance(context).sendBroadcast(updateIntent)
    }

    companion object {
        private const val TAG = "WeatherUpdater"
        private var mInstance: WeatherUpdater? = null

        @JvmStatic
        fun getInstance(context: Context): WeatherUpdater {
            if (mInstance == null) {
                mInstance = WeatherUpdater(context)
            }
            return mInstance!!
        }
    }
}

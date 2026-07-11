package com.vhmsoft.launcherios26.features.weather

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import com.vhmsoft.launcherios26.core.Preferences
import com.vhmsoft.launcherios26.core.utils.Constants
import lineageos.weather.LineageWeatherManager
import timber.log.Timber

class WeatherSourceListenerService : Service(),
    LineageWeatherManager.WeatherServiceProviderChangeListener {

    private lateinit var mContext: Context
    @Volatile
    private var mRegistered = false

    override fun onWeatherServiceProviderChanged(providerLabel: String?) {
        if (D) {
            Timber.tag(TAG).d("Weather Source changed %s", providerLabel)
        }
        Preferences.setWeatherSource(mContext, providerLabel)
        Preferences.setCachedWeatherInfo(mContext, 0, null)
        Preferences.setCustomWeatherLocationCity(mContext, null)
        Preferences.setCustomWeatherLocation(mContext, null)
        Preferences.setUseCustomWeatherLocation(mContext, false)

        if (providerLabel != null) {
            mContext.startService(
                Intent(mContext, WeatherUpdateService::class.java)
                    .putExtra(WeatherUpdateService.ACTION_FORCE_UPDATE, true)
            )
        }
    }

    override fun onCreate() {
        mContext = applicationContext
        val weatherManager = LineageWeatherManager.getInstance(mContext)
        weatherManager.registerWeatherServiceProviderChangeListener(this)
        mRegistered = true
        if (D) {
            Timber.tag(TAG).d("Listener registered")
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int = START_STICKY

    override fun onDestroy() {
        if (mRegistered) {
            val weatherManager = LineageWeatherManager.getInstance(mContext)
            weatherManager.unregisterWeatherServiceProviderChangeListener(this)
        }
    }

    override fun onBind(intent: Intent?): IBinder? = null

    companion object {
        private val TAG = WeatherSourceListenerService::class.java.simpleName
        private val D = Constants.DEBUG
    }
}

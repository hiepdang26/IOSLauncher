package com.cloudx.ios17.features.weather

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.HandlerThread
import android.os.IBinder
import timber.log.Timber

class WeatherUpdateService : Service() {
    private lateinit var mHandlerThread: HandlerThread
    private lateinit var mHandler: Handler
    private lateinit var mWeatherUpdater: WeatherUpdater

    @SuppressLint("MissingPermission")
    override fun onCreate() {
        Timber.tag(TAG).d("onCreate")

        mHandlerThread = HandlerThread("WeatherUpdateServiceHandler")
        mHandlerThread.start()
        mHandler = Handler(mHandlerThread.looper)

        mWeatherUpdater = WeatherUpdater.getInstance(applicationContext)
        executePeriodicRequest()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent != null && ACTION_FORCE_UPDATE == intent.action) {
            WeatherUpdater.getInstance(this).updateWeather()
        }
        return START_STICKY
    }

    private fun executePeriodicRequest() {
        mWeatherUpdater.checkWeatherRequest()
        mHandler.removeCallbacksAndMessages(null)
        mHandler.postDelayed({ executePeriodicRequest() }, UPDATE_PERIOD_IN_MS)
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onDestroy() {
        mHandler.removeCallbacksAndMessages(null)
        mHandlerThread.quitSafely()
        super.onDestroy()
    }

    companion object {
        private const val TAG = "WeatherUpdateService"

        const val ACTION_FORCE_UPDATE = "org.indin.blisslauncher.action.FORCE_WEATHER_UPDATE"
        const val ACTION_UPDATE_FINISHED = "org.indin.blisslauncher.action.WEATHER_UPDATE_FINISHED"
        const val ACTION_UPDATE_CITY_FINISHED =
            "org.indin.blisslauncher.action.WEATHER_UPDATE_CITY_FINISHED"
        const val EXTRA_UPDATE_CITY_KEY = "city"

        private const val UPDATE_PERIOD_IN_MS = 5L * 1000L
    }
}

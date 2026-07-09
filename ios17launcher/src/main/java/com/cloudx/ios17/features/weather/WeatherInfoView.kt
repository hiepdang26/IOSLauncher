package com.cloudx.ios17.features.weather

import android.content.BroadcastReceiver
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.content.IntentFilter
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.cloudx.ios17.R
import com.cloudx.ios17.core.Preferences
import com.cloudx.ios17.features.launcher.LauncherActivity
import timber.log.Timber

class WeatherInfoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private lateinit var mWeatherPanel: View
    private lateinit var mWeatherSetupTextView: View

    private val mWeatherReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if (WeatherUpdateService.ACTION_UPDATE_FINISHED == intent.action) {
                updateWeatherPanel()
            }

            if (WeatherUpdateService.ACTION_UPDATE_CITY_FINISHED == intent.action) {
                val textCity = mWeatherPanel.findViewById<TextView>(R.id.weather_city)
                val city = intent.getStringExtra(WeatherUpdateService.EXTRA_UPDATE_CITY_KEY)
                if (!city.isNullOrBlank()) {
                    textCity.text = city
                }
            }
        }
    }

    private val mResumeReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            updateWeatherPanel()
        }
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        mWeatherSetupTextView = findViewById(R.id.weather_setup_textview)
        mWeatherPanel = findViewById(R.id.weather_panel)
        mWeatherPanel.setOnClickListener {
            val launchIntent =
                context.packageManager.getLaunchIntentForPackage("foundation.e.weather")
            if (launchIntent != null) {
                launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(launchIntent)
            }
        }
        findViewById<View>(R.id.weather_setting_imageview).setOnClickListener { startWeatherPreferences() }
        findViewById<View>(R.id.weather_refresh_imageview).setOnClickListener {
            WeatherUpdater.getInstance(context.applicationContext).updateWeather()
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        val broadcastManager = LocalBroadcastManager.getInstance(context)
        val intentFilter = IntentFilter()

        intentFilter.addAction(WeatherUpdateService.ACTION_UPDATE_FINISHED)
        intentFilter.addAction(WeatherUpdateService.ACTION_UPDATE_CITY_FINISHED)

        broadcastManager.registerReceiver(mWeatherReceiver, intentFilter)
        broadcastManager.registerReceiver(
            mResumeReceiver,
            IntentFilter(LauncherActivity.ACTION_LAUNCHER_RESUME)
        )
        updateWeatherPanel()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        val broadcastManager = LocalBroadcastManager.getInstance(context)
        broadcastManager.unregisterReceiver(mWeatherReceiver)
        broadcastManager.unregisterReceiver(mResumeReceiver)
    }

    private fun updateWeatherPanel() {
        val cachedWeatherInfo = Preferences.getCachedWeatherInfo(context)
        if (cachedWeatherInfo == null) {
            Timber.tag("Weather").i("getCacheWeatherInfo is null")
            mWeatherSetupTextView.visibility = VISIBLE
            mWeatherPanel.visibility = GONE
            mWeatherSetupTextView.setOnClickListener { startWeatherPreferences() }
            return
        }
        mWeatherSetupTextView.visibility = GONE
        mWeatherPanel.visibility = VISIBLE
        ForecastBuilder.buildLargePanel(context, mWeatherPanel, cachedWeatherInfo)
    }

    private fun startWeatherPreferences() {
        val launcherActivity = findLauncherActivity(context)
        when (WeatherSettingsEntryPolicy.targetForLauncherContext(launcherActivity != null)) {
            WeatherSettingsEntryPolicy.Target.LAUNCHER_SETTINGS -> {
                launcherActivity?.openWeatherSettingsPage()
            }
            WeatherSettingsEntryPolicy.Target.LEGACY_PREFERENCES -> {
                startLegacyWeatherPreferences()
            }
        }
    }

    private fun startLegacyWeatherPreferences() {
        val intent = Intent(context, WeatherPreferences::class.java)
            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }

    private fun findLauncherActivity(context: Context): LauncherActivity? {
        var current: Context? = context
        while (current != null) {
            if (current is LauncherActivity) {
                return current
            }
            if (current !is ContextWrapper) {
                return null
            }
            val baseContext = current.baseContext
            if (baseContext === current) {
                return null
            }
            current = baseContext
        }
        return null
    }
}

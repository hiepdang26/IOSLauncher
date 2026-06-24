package com.cloudx.ios17.features.weather

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.EditTextPreference
import android.preference.ListPreference
import android.preference.Preference
import android.preference.PreferenceActivity
import android.preference.PreferenceScreen
import android.preference.SwitchPreference
import android.text.TextUtils
import com.cloudx.ios17.R
import com.cloudx.ios17.core.Preferences
import com.cloudx.ios17.core.utils.Constants
import lineageos.weather.LineageWeatherManager
import timber.log.Timber

class WeatherPreferences : PreferenceActivity(),
    SharedPreferences.OnSharedPreferenceChangeListener,
    LineageWeatherManager.WeatherServiceProviderChangeListener {

    private lateinit var mUseCustomLoc: SwitchPreference
    private lateinit var mCustomWeatherLoc: EditTextPreference
    private lateinit var mUseMetric: SwitchPreference
    private lateinit var mIconSet: IconSelectionPreference
    private lateinit var mUseCustomlocation: SwitchPreference
    private lateinit var mContext: Context
    private var mPostResumeRunnable: Runnable? = null
    private lateinit var mWeatherSource: PreferenceScreen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preferenceManager.sharedPreferencesName = Constants.PREF_NAME
        addPreferencesFromResource(R.xml.preferences_weather)
        mContext = this

        // Load networkItems that need custom summaries etc.
        mUseCustomLoc = findPreference(Constants.WEATHER_USE_CUSTOM_LOCATION) as SwitchPreference
        mCustomWeatherLoc =
            findPreference(Constants.WEATHER_CUSTOM_LOCATION_CITY) as EditTextPreference
        mIconSet = findPreference(Constants.WEATHER_ICONS) as IconSelectionPreference
        mUseMetric = findPreference(Constants.WEATHER_USE_METRIC) as SwitchPreference
        mUseCustomlocation = findPreference(Constants.WEATHER_USE_CUSTOM_LOCATION) as SwitchPreference
        mWeatherSource = findPreference(Constants.WEATHER_SOURCE) as PreferenceScreen
        mWeatherSource.onPreferenceChangeListener = Preference.OnPreferenceChangeListener { _, _ ->
            if (Preferences.getWeatherSource(mContext) != null) {
                mWeatherSource.notifyDependencyChange(false)
            } else {
                mWeatherSource.notifyDependencyChange(true)
            }
            false
        }

        // At first placement/start default the use of Metric units based on locale.
        // If we had a previously set value already, this will just reset the same value.
        val defValue = Preferences.useMetricUnits(mContext)
        Preferences.setUseMetricUnits(mContext, defValue)
        mUseMetric.isChecked = defValue

    }

    override fun onResume() {
        super.onResume()

        preferenceManager.sharedPreferences.registerOnSharedPreferenceChangeListener(this)

        mPostResumeRunnable?.run()
        mPostResumeRunnable = null

        val weatherManager = LineageWeatherManager.getInstance(mContext)
        weatherManager.registerWeatherServiceProviderChangeListener(this)

        mWeatherSource.isEnabled = true

        updateLocationSummary()
        updateIconSetSummary()
        updateWeatherProviderSummary(getWeatherProviderName())
    }

    override fun onPause() {
        super.onPause()
        preferenceManager.sharedPreferences.unregisterOnSharedPreferenceChangeListener(this)
        val weatherManager = LineageWeatherManager.getInstance(mContext)
        weatherManager.unregisterWeatherServiceProviderChangeListener(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mUseCustomlocation.isChecked && Preferences.getCustomWeatherLocationCity(mContext) == null) {
            // The user toggled custom location but did not set a location; fall back to geo location.
            Preferences.setUseCustomWeatherLocation(mContext, false)
        }
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, key: String?) {
        val pref = findPreference(key)
        if (pref is ListPreference) {
            pref.summary = pref.entry
        }

        var needWeatherUpdate = false
        var forceWeatherUpdate = false

        if (pref === mUseCustomLoc || pref === mCustomWeatherLoc) {
            updateLocationSummary()
        }

        if (pref === mIconSet) {
            updateIconSetSummary()
        }

        if (pref === mUseMetric) {
            // The display format of the temperatures changed; force refresh.
            forceWeatherUpdate = true
        }

        if (TextUtils.equals(key, Constants.WEATHER_SOURCE)) {
            // The weather source changed; invalidate custom location settings.
            Preferences.setCustomWeatherLocationCity(mContext, null)
            Preferences.setCustomWeatherLocation(mContext, null)
            Preferences.setUseCustomWeatherLocation(mContext, false)
            mUseCustomlocation.isChecked = false
            updateLocationSummary()
        }

        if (key == Constants.WEATHER_USE_CUSTOM_LOCATION) {
            if (!mUseCustomLoc.isChecked ||
                (mUseCustomLoc.isChecked && Preferences.getCustomWeatherLocation(mContext) != null)
            ) {
                forceWeatherUpdate = true
            }
        }

        if (key == Constants.WEATHER_CUSTOM_LOCATION_CITY && mUseCustomLoc.isChecked) {
            forceWeatherUpdate = true
        }

        if (key == Constants.WEATHER_REFRESH_INTERVAL) {
            needWeatherUpdate = true
        }

        mWeatherSource.isEnabled = true
        if (Preferences.getWeatherSource(mContext) != null) {
            mWeatherSource.notifyDependencyChange(false)
        } else {
            mWeatherSource.notifyDependencyChange(true)
        }

        if (Constants.DEBUG) {
            Timber.tag(TAG).v(
                "Preference $key changed, need update $needWeatherUpdate force update $forceWeatherUpdate"
            )
        }

        if (needWeatherUpdate || forceWeatherUpdate) {
            val updateIntent = Intent(mContext, WeatherUpdateService::class.java)
            if (forceWeatherUpdate) {
                updateIntent.action = WeatherUpdateService.ACTION_FORCE_UPDATE
            }
            mContext.startService(updateIntent)
        }
    }

    private fun updateLocationSummary() {
        if (mUseCustomLoc.isChecked) {
            var location = Preferences.getCustomWeatherLocationCity(mContext)
            if (location == null) {
                location = resources.getString(R.string.unknown)
            }
            mCustomWeatherLoc.summary = location
        } else {
            mCustomWeatherLoc.setSummary(R.string.weather_geolocated)
        }
    }

    private fun updateIconSetSummary() {
        mIconSet.summary = mIconSet.entry
    }

    override fun onWeatherServiceProviderChanged(providerName: String?) {
        updateWeatherProviderSummary(providerName)
    }

    private fun updateWeatherProviderSummary(providerName: String?) {
        if (providerName != null) {
            mWeatherSource.summary = providerName
            Preferences.setWeatherSource(mContext, providerName)
        } else {
            mWeatherSource.setSummary(R.string.weather_source_not_selected)
            Preferences.setWeatherSource(mContext, null)
        }

        if (providerName != null) {
            mWeatherSource.notifyDependencyChange(false)
        } else {
            mWeatherSource.notifyDependencyChange(true)
        }
    }

    private fun getWeatherProviderName(): String? {
        val weatherManager = LineageWeatherManager.getInstance(mContext)
        return weatherManager.activeWeatherServiceProviderLabel
    }

    companion object {
        private const val TAG = "WeatherPreferences"
        @JvmStatic
        fun hasLocationPermission(context: Context): Boolean = false
    }
}

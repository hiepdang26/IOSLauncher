package com.cloudx.ios17.features.weather

import android.Manifest.permission
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Build
import android.os.SystemClock
import androidx.core.app.ActivityCompat
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.cloudx.ios17.R
import com.cloudx.ios17.core.Preferences
import com.cloudx.ios17.features.weather.location.FusedLocationFetcher
import com.cloudx.ios17.features.weather.location.LocationFetcher
import com.cloudx.ios17.features.weather.location.NetworkGpsLocationFetcher
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.google.gson.JsonSyntaxException
import java.io.IOException
import java.lang.ref.WeakReference
import java.util.Locale
import lineageos.weather.LineageWeatherManager
import lineageos.weather.WeatherInfo
import lineageos.weather.WeatherLocation
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
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

    @SuppressLint("MissingPermission")
    private fun fetchNewLocation() {
        if (hasMissingPermissions()) {
            Timber.tag(TAG).e("Could not fetch location for missing permission")
            return
        }

        val context = mWeakContext.get() ?: return
        val locationFetcher: LocationFetcher = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            FusedLocationFetcher(context, this::onNewLocationFetched)
        } else {
            NetworkGpsLocationFetcher(context, this::onNewLocationFetched)
        }

        try {
            locationFetcher.fetchLocation()
        } catch (exception: Exception) {
            Timber.tag(TAG).w(exception, "Could not fetch location")
        }
    }

    protected fun hasMissingPermissions(): Boolean {
        val context = mWeakContext.get() ?: return true

        return ActivityCompat.checkSelfPermission(
            context,
            permission.ACCESS_FINE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(
                context,
                permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
    }

    protected fun requestWeatherUpdate(location: Location) {
        Timber.tag(TAG).i("Requesting weather info for location: %s", location)
        val context = mWeakContext.get() ?: return
        val weatherManager = LineageWeatherManager.getInstance(context)
        weatherManager.requestWeatherUpdate(location) { status: Int, weatherInfo: WeatherInfo? ->
            notifyUi(context, weatherInfo, status)
        }
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

    @Synchronized
    private fun onNewLocationFetched(location: Location?) {
        if (location == null) {
            Timber.tag(TAG).i("Could not fetch any location")
            return
        }

        Timber.tag(TAG).i("New location fetched:%s", location)

        requestWeatherUpdate(location)

        val context = mWeakContext.get() ?: return
        if (!Preferences.useCustomWeatherLocation(context)) {
            reverseGeocodeLocation(location)
        } else {
            Timber.tag(TAG).w("Do not reverse geocode location. User is using a custom location.")
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

    private fun reverseGeocodeLocation(location: Location) {
        Timber.tag(TAG).i("Reverse geocoding location %s", location)

        val context = mWeakContext.get() ?: return
        val url = "https://api.openweathermap.org/geo/1.0/reverse?lat=" +
            location.latitude +
            "&lon=" +
            location.longitude +
            "&limit=1&appid=" +
            context.getString(R.string.default_key)

        val okHttpClient = OkHttpClient()
        val request = Request.Builder().url(url).build()
        okHttpClient.newCall(request).enqueue(mReverseGeocodeCallback)
    }

    private fun onReverseGeocoded(response: Response) {
        val body = response.body
        if (body == null) {
            Timber.tag(TAG).w("Reverse geocoding response is empty")
            return
        }

        val locales: JsonObject?
        val defaultCityName: String?
        try {
            val json = body.string()
            val array = JsonParser().parse(json).asJsonArray

            val root = array[0].asJsonObject
            locales = root.getAsJsonObject("local_names")
            defaultCityName = root.get("name")?.asString
        } catch (exception: IOException) {
            Timber.tag(TAG).e(exception, "Exception caught")
            return
        } catch (exception: IllegalStateException) {
            Timber.tag(TAG).e(exception, "Exception caught")
            return
        } catch (exception: JsonSyntaxException) {
            Timber.tag(TAG).e(exception, "Exception caught")
            return
        }

        if (defaultCityName == null) {
            Timber.tag(TAG).w("Could not get default city name")
            return
        }

        if (locales == null) {
            Timber.tag(TAG).i(
                "Could not get locales. Fallbacking to default city name %s",
                defaultCityName
            )
            notifyUi(defaultCityName)
            return
        }

        val countryCode = Locale.getDefault().country.lowercase(Locale.ROOT)
        val jsonElement = locales.get(countryCode)
        if (jsonElement == null) {
            Timber.tag(TAG).i(
                "Could not get city name in country code: %s. Fallbacking to default city name %s",
                countryCode,
                defaultCityName
            )
            notifyUi(defaultCityName)
            return
        }

        val city = jsonElement.asString
        notifyUi(city)
    }

    private fun notifyUi(city: String) {
        val context = mWeakContext.get() ?: return
        Preferences.setCachedCity(context, city)
        val intent = Intent(WeatherUpdateService.ACTION_UPDATE_CITY_FINISHED)
        intent.putExtra(WeatherUpdateService.EXTRA_UPDATE_CITY_KEY, city)
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent)
    }

    private val mReverseGeocodeCallback: Callback = object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            Timber.tag(TAG).e(e, "Could not reverse geocode location")
        }

        override fun onResponse(call: Call, response: Response) {
            onReverseGeocoded(response)
        }
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

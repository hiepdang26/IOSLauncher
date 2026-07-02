package com.cloudx.ios17.features.weather.openmeteo

import android.annotation.SuppressLint
import android.content.Context
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.cloudx.ios17.R
import java.util.Locale

object WeatherLocationProvider {
    @SuppressLint("MissingPermission")
    fun currentCoordinates(context: Context, callback: (WeatherCoordinates?) -> Unit) {
        val manager = context.getSystemService(Context.LOCATION_SERVICE) as? LocationManager
        if (manager == null) {
            callback(null)
            return
        }
        bestLastKnownLocation(manager)?.let { location ->
            callback(location.toWeatherCoordinates())
            return
        }
        val provider = LOCATION_PROVIDERS.firstOrNull { providerName ->
            runCatching { manager.isProviderEnabled(providerName) }.getOrDefault(false)
        }
        if (provider == null) {
            callback(null)
            return
        }

        val handler = Handler(Looper.getMainLooper())
        lateinit var listener: LocationListener
        val timeout = Runnable {
            runCatching { manager.removeUpdates(listener) }
            callback(null)
        }
        listener = object : LocationListener {
            override fun onLocationChanged(location: Location) {
                handler.removeCallbacks(timeout)
                runCatching { manager.removeUpdates(this) }
                callback(location.toWeatherCoordinates())
            }

            @Deprecated("Deprecated in Android")
            override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) = Unit

            override fun onProviderEnabled(provider: String) = Unit
            override fun onProviderDisabled(provider: String) = Unit
        }
        manager.requestSingleUpdate(provider, listener, Looper.getMainLooper())
        handler.postDelayed(timeout, LOCATION_TIMEOUT_MS)
    }

    @Suppress("DEPRECATION")
    fun locationName(context: Context, coordinates: WeatherCoordinates): String {
        return runCatching {
            val address = Geocoder(context, Locale.getDefault())
                .getFromLocation(coordinates.latitude, coordinates.longitude, 1)
                ?.firstOrNull()
            address?.subLocality
                ?: address?.locality
                ?: address?.adminArea
        }.getOrNull()?.takeIf { name -> name.isNotBlank() }
            ?: context.getString(R.string.weather_current_location)
    }

    @SuppressLint("MissingPermission")
    private fun bestLastKnownLocation(manager: LocationManager): Location? {
        return LOCATION_PROVIDERS
            .mapNotNull { provider -> runCatching { manager.getLastKnownLocation(provider) }.getOrNull() }
            .maxByOrNull { location -> location.time }
    }

    private fun Location.toWeatherCoordinates(): WeatherCoordinates {
        return WeatherCoordinates(latitude = latitude, longitude = longitude)
    }

    private val LOCATION_PROVIDERS = listOf(
        LocationManager.NETWORK_PROVIDER,
        LocationManager.GPS_PROVIDER
    )
    private const val LOCATION_TIMEOUT_MS = 8_000L
}

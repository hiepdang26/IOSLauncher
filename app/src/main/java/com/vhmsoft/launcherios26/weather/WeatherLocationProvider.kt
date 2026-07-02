package com.vhmsoft.launcherios26.weather

import android.annotation.SuppressLint
import android.content.Context
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.vhmsoft.launcherios26.R
import java.util.Locale
import kotlin.coroutines.resume
import kotlinx.coroutines.suspendCancellableCoroutine

object WeatherLocationProvider {
    @SuppressLint("MissingPermission")
    suspend fun currentCoordinates(context: Context): WeatherCoordinates? {
        val manager = context.getSystemService(Context.LOCATION_SERVICE) as? LocationManager
            ?: return null
        bestLastKnownLocation(manager)?.let { location ->
            return location.toWeatherCoordinates()
        }
        val provider = LOCATION_PROVIDERS.firstOrNull { providerName ->
            runCatching { manager.isProviderEnabled(providerName) }.getOrDefault(false)
        } ?: return null

        return suspendCancellableCoroutine { continuation ->
            val handler = Handler(Looper.getMainLooper())
            lateinit var listener: LocationListener
            val timeout = Runnable {
                runCatching { manager.removeUpdates(listener) }
                if (continuation.isActive) {
                    continuation.resume(null)
                }
            }
            listener = object : LocationListener {
                override fun onLocationChanged(location: Location) {
                    handler.removeCallbacks(timeout)
                    runCatching { manager.removeUpdates(this) }
                    if (continuation.isActive) {
                        continuation.resume(location.toWeatherCoordinates())
                    }
                }

                @Deprecated("Deprecated in Android")
                override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) = Unit

                override fun onProviderEnabled(provider: String) = Unit
                override fun onProviderDisabled(provider: String) = Unit
            }
            continuation.invokeOnCancellation {
                handler.removeCallbacks(timeout)
                runCatching { manager.removeUpdates(listener) }
            }
            manager.requestSingleUpdate(provider, listener, Looper.getMainLooper())
            handler.postDelayed(timeout, LOCATION_TIMEOUT_MS)
        }
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

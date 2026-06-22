package com.cloudx.ios17.features.weather.location

import android.content.Context
import android.location.Location
import android.location.LocationManager
import androidx.core.location.LocationManagerCompat
import androidx.core.os.CancellationSignal
import java.util.concurrent.Executors
import timber.log.Timber

class NetworkGpsLocationFetcher(context: Context, callback: Callback) : LocationFetcher() {
    private var gpsLocation: Location? = null
    private var networkLocation: Location? = null

    init {
        this.context = context
        this.callback = callback
        locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    override fun fetchLocation() {
        if (!checkPermission()) {
            Timber.w("Could not fetch location. Missing permission.")
            return
        }

        LocationManagerCompat.getCurrentLocation(
            locationManager!!,
            LocationManager.GPS_PROVIDER,
            null as CancellationSignal?,
            Executors.newFixedThreadPool(1),
            this::onLocationFetched
        )

        LocationManagerCompat.getCurrentLocation(
            locationManager!!,
            LocationManager.NETWORK_PROVIDER,
            null as CancellationSignal?,
            Executors.newFixedThreadPool(1),
            this::onLocationFetched
        )
    }

    private fun onLocationFetched(location: Location?) {
        if (location == null) {
            return
        }

        if (location.provider == LocationManager.GPS_PROVIDER) {
            gpsLocation = location
        } else if (location.provider == LocationManager.NETWORK_PROVIDER) {
            networkLocation = location
        }

        callback?.onNewLocation(getMostRecentLocation())
    }

    private fun getMostRecentLocation(): Location {
        val gps = gpsLocation
        val network = networkLocation
        if (network == null && gps == null) {
            throw IllegalStateException()
        }
        if (gps == null) {
            return network!!
        }
        if (network == null) {
            return gps
        }

        return if (gps.time >= network.time) gps else network
    }
}

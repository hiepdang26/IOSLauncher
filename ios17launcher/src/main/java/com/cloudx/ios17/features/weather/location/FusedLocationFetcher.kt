package com.cloudx.ios17.features.weather.location

import android.content.Context
import android.location.Location
import android.location.LocationManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.location.LocationManagerCompat
import androidx.core.os.CancellationSignal
import java.util.concurrent.Executors
import timber.log.Timber

class FusedLocationFetcher(context: Context, callback: Callback) : LocationFetcher() {
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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            LocationManagerCompat.getCurrentLocation(
                locationManager!!,
                LocationManager.FUSED_PROVIDER,
                null as CancellationSignal?,
                Executors.newFixedThreadPool(1),
                this::onLocationFetched
            )
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.S)
    private fun onLocationFetched(location: Location?) {
        var currentLocation = location
        if (currentLocation == null && checkPermission()) {
            currentLocation = locationManager?.getLastKnownLocation(LocationManager.FUSED_PROVIDER)
        }

        callback?.onNewLocation(currentLocation)
    }
}

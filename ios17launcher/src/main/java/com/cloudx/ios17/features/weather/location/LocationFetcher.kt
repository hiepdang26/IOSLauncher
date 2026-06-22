package com.cloudx.ios17.features.weather.location

import android.Manifest.permission
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.core.app.ActivityCompat

abstract class LocationFetcher {
    @JvmField
    protected var locationManager: LocationManager? = null

    @JvmField
    protected var callback: Callback? = null

    @JvmField
    protected var context: Context? = null

    fun interface Callback {
        fun onNewLocation(location: Location?)
    }

    abstract fun fetchLocation()

    protected fun checkPermission(): Boolean {
        val safeContext = context ?: return false
        return ActivityCompat.checkSelfPermission(
            safeContext,
            permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED ||
            ActivityCompat.checkSelfPermission(
                safeContext,
                permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
    }
}

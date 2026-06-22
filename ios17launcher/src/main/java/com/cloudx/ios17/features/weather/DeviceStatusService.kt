package com.cloudx.ios17.features.weather

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.IBinder
import com.cloudx.ios17.core.utils.Constants
import timber.log.Timber

class DeviceStatusService : Service() {
    private val mDeviceStatusListenerReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val action = intent.action
            if (ConnectivityManager.CONNECTIVITY_ACTION == action) {
                val hasConnection =
                    !intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false)

                if (D) {
                    Timber.tag(TAG).d("Got connectivity change, has connection: $hasConnection")
                }

                val updateIntent = Intent(context, WeatherUpdateService::class.java)
                if (hasConnection) {
                    context.startService(updateIntent)
                } else {
                    context.stopService(updateIntent)
                }
            }
        }
    }

    override fun onCreate() {
        val deviceStatusFilter = IntentFilter()
        deviceStatusFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION)
        deviceStatusFilter.addAction(Intent.ACTION_SCREEN_OFF)
        deviceStatusFilter.addAction(Intent.ACTION_SCREEN_ON)
        registerReceiver(mDeviceStatusListenerReceiver, deviceStatusFilter)
    }

    override fun onDestroy() {
        if (D) {
            Timber.tag(TAG).d("Stopping service")
        }
        unregisterReceiver(mDeviceStatusListenerReceiver)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (D) {
            Timber.tag(TAG).d("Starting service")
        }
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? = null

    companion object {
        private val TAG = DeviceStatusService::class.java.simpleName
        private val D = Constants.DEBUG
    }
}

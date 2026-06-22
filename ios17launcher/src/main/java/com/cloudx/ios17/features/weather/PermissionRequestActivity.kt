package com.cloudx.ios17.features.weather

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.ResultReceiver

class PermissionRequestActivity : Activity() {
    private var mResultReceiver: ResultReceiver? = null
    private var mResult = RESULT_CANCELED

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (hasLocationPermission()) {
            finish()
            return
        }

        mResultReceiver = intent.getParcelableExtra(RESULT_RECEIVER_EXTRA)
        if (mResultReceiver == null) {
            finish()
            return
        }

        val permissions = arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, LOCATION_PERMISSION_REQUEST_CODE)
        }
    }

    fun hasLocationPermission(): Boolean =
        checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) ==
            PackageManager.PERMISSION_GRANTED

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                mResult = RESULT_OK
            }
        }
        finish()
    }

    override fun finish() {
        mResultReceiver?.send(mResult, null)
        super.finish()
    }

    companion object {
        private const val RESULT_RECEIVER_EXTRA = "result_receiver"
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }
}
